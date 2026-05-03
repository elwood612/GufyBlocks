package com.github.elwood612.gufyblocks.events;

import com.github.elwood612.gufyblocks.GufyBlocks;
import com.github.elwood612.gufyblocks.util.GufyMonocleParticles;
import com.github.elwood612.gufyblocks.util.GufyScheduler;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

@EventBusSubscriber(modid = GufyBlocks.MODID)
public class GufyTickEvent
{
    @SubscribeEvent
    public static void onLevelTick(LevelTickEvent.Post event) {
        if (event.getLevel() instanceof ServerLevel serverLevel) {
            GufyScheduler.tick(serverLevel);
        }
    }
}
