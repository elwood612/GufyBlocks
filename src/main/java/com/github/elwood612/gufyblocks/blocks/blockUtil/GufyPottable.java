package com.github.elwood612.gufyblocks.blocks.blockUtil;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

import static com.github.elwood612.gufyblocks.util.GufyUtil.getGufyBlock;

public interface GufyPottable
{
    public static final Supplier<BiMap<Block, Block>> POTTABLES = Suppliers.memoize(() ->
    {
        return ImmutableBiMap.<Block, Block>builder()
                .put(getGufyBlock("flower_box"), getGufyBlock("potted_lilac"))
                .put(getGufyBlock("flower_box"), getGufyBlock("potted_peony"))
                .put(getGufyBlock("flower_box"), getGufyBlock("potted_pitcher_plant"))
                .put(getGufyBlock("flower_box"), getGufyBlock("potted_rose_bush"))
                .put(getGufyBlock("flower_box"), getGufyBlock("potted_sunflower"))

                .build();
    });
}
