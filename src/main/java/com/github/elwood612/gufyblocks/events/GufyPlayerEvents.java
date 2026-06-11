package com.github.elwood612.gufyblocks.events;

import com.github.elwood612.gufyblocks.GufyBlocks;
import com.github.elwood612.gufyblocks.packets.GufyVersionCheckPayload;
import com.github.elwood612.gufyblocks.util.GufyPhasingHandler;
import com.github.elwood612.gufyblocks.util.GufyScheduler;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.core.Holder;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.clock.ServerClockManager;
import net.minecraft.world.clock.WorldClock;
import net.minecraft.world.clock.WorldClocks;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.UUID;

@EventBusSubscriber(modid = GufyBlocks.MODID)
public class GufyPlayerEvents
{
    public static long lastGlobalLoginTick = -1;

    // Phasing Vial safety cleanup
    @SubscribeEvent
    public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        UUID playerID = player.getUUID();
        GufyScheduler.cancelPlayerTasks(playerID);

        if (GufyPhasingHandler.activePhasing.containsKey(player.getUUID())) {
            GufyPhasingHandler.returnPlayer(player);
        }
    }

    // Packet login check
    // Set time to day if no one is on
    // Phasing Vial safety cleanup
    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        Level level = player.level();

        // should prevent out-of-date clients loggin in to the server
        PacketDistributor.sendToPlayer(player, new GufyVersionCheckPayload(GufyBlocks.VERSION));

        if (level instanceof ServerLevel serverLevel) {
            MinecraftServer server = serverLevel.getServer();
            Holder.Reference<WorldClock> worldClock = serverLevel.registryAccess().getOrThrow(WorldClocks.OVERWORLD);
            ServerClockManager clockManager = serverLevel.clockManager();

            // set time to day if nobody was on when you joined
            if (server != null && server.getPlayerList().getPlayerCount() == 1) {
                int desiredTime = level.getRandom().nextIntBetweenInclusive(0, 5500); // 2000

                long currentTotalTime = clockManager.getTotalTicks(worldClock);
                long currentTimeOfDay = currentTotalTime % 24000L;
                long timeToAdvance = currentTimeOfDay < desiredTime ?
                        desiredTime - currentTimeOfDay : 24000L + desiredTime - currentTimeOfDay;
                clockManager.addTicks(worldClock, (int)timeToAdvance);
            }

            // set compass login delay
            lastGlobalLoginTick = serverLevel.getGameTime() + 100;
        }

        // This is more for safety, the logout event should normally have this covered
        UUID playerID = player.getUUID();
        GufyScheduler.cancelPlayerTasks(playerID);

        if (GufyPhasingHandler.activePhasing.containsKey(player.getUUID())) {
            GufyPhasingHandler.returnPlayer(player);
        }
    }

    // Both of these concern the Totem of Keeping
    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (!GufyUtil.hasTotemOfKeeping(player)) return;

        player.getPersistentData().putBoolean("gufyblocks_had_totem", true);
    }

    @SubscribeEvent
    public static void onClone(PlayerEvent.Clone event) {
        if (!event.isWasDeath()) return;

        ServerPlayer oldPlayer = (ServerPlayer) event.getOriginal();
        ServerPlayer newPlayer = (ServerPlayer) event.getEntity();

        boolean hadTotem = oldPlayer.getPersistentData().getBoolean("gufyblocks_had_totem").orElse(false);
        if (!hadTotem) return;

        newPlayer.getInventory().replaceWith(oldPlayer.getInventory());
        oldPlayer.getPersistentData().remove("gufyblocks_had_totem");
    }
}
