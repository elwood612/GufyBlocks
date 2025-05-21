package com.github.elwood612.gufyblocks.blocks.blockUtil;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

import static com.github.elwood612.gufyblocks.util.GufyUtil.getGufyBlock;

public interface GufyPottable
{
    public static final Supplier<BiMap<Item, Block>> POTTABLES = Suppliers.memoize(() ->
    {
        return ImmutableBiMap.<Item, Block>builder()
                .put(Items.LILAC, getGufyBlock("potted_lilac"))
                .put(Items.PEONY, getGufyBlock("potted_peony"))
                .put(Items.ROSE_BUSH, getGufyBlock("potted_rose_bush"))
                .put(Items.SUNFLOWER, getGufyBlock("potted_sunflower"))

                .build();
    });
}
