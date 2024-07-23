package com.github.elwood612.gufyblocks.blocks.blockUtil;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

import static com.github.elwood612.gufyblocks.util.GufyUtil.getGufyBlock;

public interface GufyWaxable
{
    public static final Supplier<BiMap<Block, Block>> WAXABLES = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                //copper
                .put(Blocks.COPPER_BLOCK, Blocks.WAXED_COPPER_BLOCK)
                .put(Blocks.EXPOSED_COPPER, Blocks.WAXED_EXPOSED_COPPER)
                .put(Blocks.WEATHERED_COPPER, Blocks.WAXED_WEATHERED_COPPER)
                .put(Blocks.OXIDIZED_COPPER, Blocks.WAXED_OXIDIZED_COPPER)
                .put(getGufyBlock("copper_stairs"), getGufyBlock("waxed_copper_stairs"))
                .put(getGufyBlock("exposed_copper_stairs"), getGufyBlock("waxed_exposed_copper_stairs"))
                .put(getGufyBlock("weathered_copper_stairs"), getGufyBlock("waxed_weathered_copper_stairs"))
                .put(getGufyBlock("oxidized_copper_stairs"), getGufyBlock("waxed_oxidized_copper_stairs"))
                .put(getGufyBlock("copper_slab"), getGufyBlock("waxed_copper_slab"))
                .put(getGufyBlock("exposed_copper_slab"), getGufyBlock("waxed_exposed_copper_slab"))
                .put(getGufyBlock("weathered_copper_slab"), getGufyBlock("waxed_weathered_copper_slab"))
                .put(getGufyBlock("oxidized_copper_slab"), getGufyBlock("waxed_oxidized_copper_slab"))
                .put(getGufyBlock("copper_verticalslab"), getGufyBlock("waxed_copper_verticalslab"))
                .put(getGufyBlock("exposed_copper_verticalslab"), getGufyBlock("waxed_exposed_copper_verticalslab"))
                .put(getGufyBlock("weathered_copper_verticalslab"), getGufyBlock("waxed_weathered_copper_verticalslab"))
                .put(getGufyBlock("oxidized_copper_verticalslab"), getGufyBlock("waxed_oxidized_copper_verticalslab"))
                .put(getGufyBlock("copper_wall"), getGufyBlock("waxed_copper_wall"))
                .put(getGufyBlock("exposed_copper_wall"), getGufyBlock("waxed_exposed_copper_wall"))
                .put(getGufyBlock("weathered_copper_wall"), getGufyBlock("waxed_weathered_copper_wall"))
                .put(getGufyBlock("oxidized_copper_wall"), getGufyBlock("waxed_oxidized_copper_wall"))
                .put(getGufyBlock("copper_hopper"), getGufyBlock("waxed_copper_hopper"))
                .put(getGufyBlock("exposed_copper_hopper"), getGufyBlock("waxed_exposed_copper_hopper"))
                .put(getGufyBlock("weathered_copper_hopper"), getGufyBlock("waxed_weathered_copper_hopper"))
                .put(getGufyBlock("oxidized_copper_hopper"), getGufyBlock("waxed_oxidized_copper_hopper"))
                .put(getGufyBlock("copper_post"), getGufyBlock("waxed_copper_post"))
                .put(getGufyBlock("exposed_copper_post"), getGufyBlock("waxed_exposed_copper_post"))
                .put(getGufyBlock("weathered_copper_post"), getGufyBlock("waxed_weathered_copper_post"))
                .put(getGufyBlock("oxidized_copper_post"), getGufyBlock("waxed_oxidized_copper_post"))
                //cut_copper
                .put(Blocks.CUT_COPPER, Blocks.WAXED_CUT_COPPER)
                .put(Blocks.EXPOSED_CUT_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER)
                .put(Blocks.WEATHERED_CUT_COPPER, Blocks.WAXED_WEATHERED_CUT_COPPER)
                .put(Blocks.OXIDIZED_CUT_COPPER, Blocks.WAXED_OXIDIZED_CUT_COPPER)
                .put(Blocks.CUT_COPPER_SLAB, Blocks.WAXED_CUT_COPPER_SLAB)
                .put(Blocks.EXPOSED_CUT_COPPER_SLAB, Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB)
                .put(Blocks.WEATHERED_CUT_COPPER_SLAB, Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB)
                .put(Blocks.OXIDIZED_CUT_COPPER_SLAB, Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB)
                .put(Blocks.CUT_COPPER_STAIRS, Blocks.WAXED_CUT_COPPER_STAIRS)
                .put(Blocks.EXPOSED_CUT_COPPER_STAIRS, Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS)
                .put(Blocks.WEATHERED_CUT_COPPER_STAIRS, Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS)
                .put(Blocks.OXIDIZED_CUT_COPPER_STAIRS, Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS)
                .put(getGufyBlock("cut_copper_verticalslab"), getGufyBlock("waxed_cut_copper_verticalslab"))
                .put(getGufyBlock("exposed_cut_copper_verticalslab"), getGufyBlock("waxed_exposed_cut_copper_verticalslab"))
                .put(getGufyBlock("weathered_cut_copper_verticalslab"), getGufyBlock("waxed_weathered_cut_copper_verticalslab"))
                .put(getGufyBlock("oxidized_cut_copper_verticalslab"), getGufyBlock("waxed_oxidized_cut_copper_verticalslab"))
                .put(getGufyBlock("cut_copper_wall"), getGufyBlock("waxed_cut_copper_wall"))
                .put(getGufyBlock("exposed_cut_copper_wall"), getGufyBlock("waxed_exposed_cut_copper_wall"))
                .put(getGufyBlock("weathered_cut_copper_wall"), getGufyBlock("waxed_weathered_cut_copper_wall"))
                .put(getGufyBlock("oxidized_cut_copper_wall"), getGufyBlock("waxed_oxidized_cut_copper_wall"))
                .put(getGufyBlock("cut_copper_hopper"), getGufyBlock("waxed_cut_copper_hopper"))
                .put(getGufyBlock("exposed_cut_copper_hopper"), getGufyBlock("waxed_exposed_cut_copper_hopper"))
                .put(getGufyBlock("weathered_cut_copper_hopper"), getGufyBlock("waxed_weathered_cut_copper_hopper"))
                .put(getGufyBlock("oxidized_cut_copper_hopper"), getGufyBlock("waxed_oxidized_cut_copper_hopper"))
                .put(getGufyBlock("cut_copper_post"), getGufyBlock("waxed_cut_copper_post"))
                .put(getGufyBlock("exposed_cut_copper_post"), getGufyBlock("waxed_exposed_cut_copper_post"))
                .put(getGufyBlock("weathered_cut_copper_post"), getGufyBlock("waxed_weathered_cut_copper_post"))
                .put(getGufyBlock("oxidized_cut_copper_post"), getGufyBlock("waxed_oxidized_cut_copper_post"))
                .build();
    });
    public static final Supplier<BiMap<Block, Block>> WAX_OFF_BY_BLOCK = Suppliers.memoize(() -> {
        return WAXABLES.get().inverse();
    });
}
