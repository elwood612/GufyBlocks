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
                .put(Items.SWEET_BERRIES, getGufyBlock("potted_berries"))
                .put(Items.GLOW_BERRIES, getGufyBlock("potted_glow_berries"))
                .put(Items.LARGE_FERN, getGufyBlock("potted_large_fern"))
                .put(Items.LILAC, getGufyBlock("potted_lilac"))
                .put(Items.PEONY, getGufyBlock("potted_peony"))
                .put(Items.PITCHER_PLANT, getGufyBlock("potted_pitcher_plant"))
                .put(Items.ROSE_BUSH, getGufyBlock("potted_rose_bush"))
                .put(Items.SUNFLOWER, getGufyBlock("potted_sunflower"))
                .put(Items.TWISTING_VINES, getGufyBlock("potted_twisting_vine"))
                .put(Items.VINE, getGufyBlock("potted_vine"))
                .put(Items.WEEPING_VINES, getGufyBlock("potted_weeping_vine"))

                .build();
    });
}
