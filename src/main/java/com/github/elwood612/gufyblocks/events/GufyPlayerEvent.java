package com.github.elwood612.gufyblocks.events;

import com.github.elwood612.gufyblocks.GufyBlocks;
import com.github.elwood612.gufyblocks.util.GufyPhasingHandler;
import com.github.elwood612.gufyblocks.util.GufyScheduler;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import java.util.UUID;

@EventBusSubscriber(modid = GufyBlocks.MODID)
public class GufyPlayerEvent
{
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

        UUID playerID = player.getUUID();
        GufyScheduler.cancelPlayerTasks(playerID);

        if (GufyPhasingHandler.activePhasing.containsKey(player.getUUID())) {
            GufyPhasingHandler.returnPlayer(player);
        }
    }
}
