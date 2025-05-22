package com.github.elwood612.gufyblocks.util;

import net.minecraft.world.level.FoliageColor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

public class GufyTint {
    @SubscribeEvent
    public static void registerBlockColorHandlers(RegisterColorHandlersEvent.Block event) {
        // Parameters are the block's state, the level the block is in, the block's position, and the tint index.
        // The level and position may be null.
        event.register((state, level, pos, tintIndex) -> {
                    // Replace with your own calculation. See the BlockColors class for vanilla references.
                    // Colors are in ARGB format. Generally, if the tint index is -1, it means that no tinting
                    // should take place and a default value should be used instead.
                    return FoliageColor.FOLIAGE_DEFAULT;
                },
                // A varargs of blocks to apply the tinting to
                GufyUtil.getGufyBlock("potted_large_fern"),GufyUtil.getGufyBlock("potted_vine"));
    }
}
