package com.github.elwood612.gufyblocks.events;

import com.github.elwood612.gufyblocks.GufyBlocks;
import com.github.elwood612.gufyblocks.util.GufyPhasingHandler;
import com.github.elwood612.gufyblocks.util.GufyScheduler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerWakeUpEvent;

import java.util.UUID;

@EventBusSubscriber(modid = GufyBlocks.MODID)
public class GufyPlayerEvents
{
    public static long lastGlobalLoginTick = -1;

    @SubscribeEvent
    public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        UUID playerID = player.getUUID();
        GufyScheduler.cancelPlayerTasks(playerID);

        if (GufyPhasingHandler.activePhasing.containsKey(player.getUUID())) {
            GufyPhasingHandler.returnPlayer(player);
        }
    }

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        Level level = player.level();

        if (level instanceof ServerLevel serverLevel) {
            MinecraftServer server = serverLevel.getServer();

            // set time to day if nobody was on when you joined
            if (server != null && server.getPlayerList().getPlayerCount() == 1){
                int rand = level.random.nextIntBetweenInclusive(0, 5500);
                serverLevel.setDayTime(rand);
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
}
