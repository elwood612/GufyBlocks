package com.github.elwood612.gufyblocks.util;

import com.github.elwood612.gufyblocks.GufyBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.GrassColor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = GufyBlocks.MODID)
public class GufyTintHandler
{
    @SubscribeEvent
    public static void registerBlockColorHandlers(RegisterColorHandlersEvent.Block event) {
        event.register((state, level, pos, tintIndex) ->
                level != null && pos != null ? BiomeColors.getAverageFoliageColor(level, pos) : -12012264,
                GufyUtil.getGufyBlock("potted_vine"));
        event.register((state, level, pos, tintIndex) ->
                        level != null && pos != null ? BiomeColors.getAverageGrassColor(level, pos) : GrassColor.getDefaultColor(),
                GufyUtil.getGufyBlock("potted_large_fern"));
    }
}
