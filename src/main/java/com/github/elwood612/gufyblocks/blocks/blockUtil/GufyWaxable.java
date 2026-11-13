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
                .put(Blocks.COPPER_BLOCK.weathering().unaffected(), Blocks.COPPER_BLOCK.waxed().unaffected())
                .put(Blocks.COPPER_BLOCK.weathering().exposed(), Blocks.COPPER_BLOCK.waxed().exposed())
                .put(Blocks.COPPER_BLOCK.weathering().weathered(), Blocks.COPPER_BLOCK.waxed().weathered())
                .put(Blocks.COPPER_BLOCK.weathering().oxidized(), Blocks.COPPER_BLOCK.waxed().oxidized())
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
                .put(Blocks.CUT_COPPER.weathering().unaffected(), Blocks.CUT_COPPER.waxed().unaffected())
                .put(Blocks.CUT_COPPER.weathering().exposed(), Blocks.CUT_COPPER.waxed().exposed())
                .put(Blocks.CUT_COPPER.weathering().weathered(), Blocks.CUT_COPPER.waxed().weathered())
                .put(Blocks.CUT_COPPER.weathering().oxidized(), Blocks.CUT_COPPER.waxed().oxidized())
                .put(Blocks.CUT_COPPER_SLAB.weathering().unaffected(), Blocks.CUT_COPPER_SLAB.waxed().unaffected())
                .put(Blocks.CUT_COPPER_SLAB.weathering().exposed(), Blocks.CUT_COPPER_SLAB.waxed().exposed())
                .put(Blocks.CUT_COPPER_SLAB.weathering().weathered(), Blocks.CUT_COPPER_SLAB.waxed().weathered())
                .put(Blocks.CUT_COPPER_SLAB.weathering().oxidized(), Blocks.CUT_COPPER_SLAB.waxed().oxidized())
                .put(Blocks.CUT_COPPER_STAIRS.weathering().unaffected(), Blocks.CUT_COPPER_STAIRS.waxed().unaffected())
                .put(Blocks.CUT_COPPER_STAIRS.weathering().exposed(), Blocks.CUT_COPPER_STAIRS.waxed().exposed())
                .put(Blocks.CUT_COPPER_STAIRS.weathering().weathered(), Blocks.CUT_COPPER_STAIRS.waxed().weathered())
                .put(Blocks.CUT_COPPER_STAIRS.weathering().oxidized(), Blocks.CUT_COPPER_STAIRS.waxed().oxidized())
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
