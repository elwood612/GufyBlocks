package com.github.elwood612.gufyblocks.util;

import com.github.elwood612.gufyblocks.GufyBlocks;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.util.List;

@EventBusSubscriber(modid = GufyBlocks.MODID)
public class GufyTintHandler
{
    @SubscribeEvent
    public static void registerBlockColorHandlers(RegisterColorHandlersEvent.BlockTintSources event) {
        event.register(
                List.of(
                        new BlockTintSource() {
                            @Override
                            public int color(BlockState state) {
                                // Fallback color when not in-world
                                return 0xFF48B518; // equivalent-ish to -12012264 in ARGB
                            }

                            @Override
                            public int colorInWorld(BlockState state, BlockAndTintGetter level, BlockPos pos) {
                                return BiomeColors.getAverageFoliageColor(level, pos);
                            }
                        }
                ),
                GufyUtil.getGufyBlock("potted_vine")
        );
        event.register(
                List.of(
                        new BlockTintSource() {
                            @Override
                            public int color(BlockState state) {
                                return 0xFF79C05A | GrassColor.getDefaultColor() & 0x00FFFFFF;
                            }

                            @Override
                            public int colorInWorld(BlockState state, BlockAndTintGetter level, BlockPos pos) {
                                return BiomeColors.getAverageGrassColor(level, pos);
                            }
                        }
                ),
                GufyUtil.getGufyBlock("potted_tall_grass"), GufyUtil.getGufyBlock("potted_large_fern")
        );
    }
}
