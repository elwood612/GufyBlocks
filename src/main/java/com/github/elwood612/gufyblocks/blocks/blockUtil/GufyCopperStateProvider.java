package com.github.elwood612.gufyblocks.blocks.blockUtil;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.Map;

public record GufyCopperStateProvider(Map<Block, Block> replacements) implements BlockStateProvider
{
    public static final MapCodec<GufyCopperStateProvider> CODEC =
            RecordCodecBuilder.mapCodec(instance ->
                    instance.group(
                            Codec.unboundedMap(
                                            BuiltInRegistries.BLOCK.byNameCodec(),
                                            BuiltInRegistries.BLOCK.byNameCodec()
                                    ).fieldOf("replacements")
                                    .forGetter(GufyCopperStateProvider::replacements)
                    ).apply(instance, GufyCopperStateProvider::new)
            );

    @Override
    public MapCodec<GufyCopperStateProvider> codec() {
        return CODEC;
    }

    @Override
    public BlockState getState(
            LevelAccessor level,
            RandomSource random,
            BlockPos pos
    ) {
        BlockState result = getOptionalState(level, random, pos);
        return result != null ? result : level.getBlockState(pos);
    }

    @Override
    public BlockState getOptionalState(
            LevelAccessor level,
            RandomSource random,
            BlockPos pos
    ) {
        BlockState original = level.getBlockState(pos);

        Block replacement = replacements.get(original.getBlock());

        if (replacement == null) {
            return null;
        }

        return replacement.defaultBlockState()
                .withPropertiesOf(original);
    }
}
