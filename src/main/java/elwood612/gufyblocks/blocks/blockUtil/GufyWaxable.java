package elwood612.gufyblocks.blocks.blockUtil;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

public interface GufyWaxable
{
    public static final Supplier<BiMap<Block, Block>> WAXABLES = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                //copper
                .put(Blocks.COPPER_BLOCK, Blocks.WAXED_COPPER_BLOCK)
                .put(Blocks.EXPOSED_COPPER, Blocks.WAXED_EXPOSED_COPPER)
                .put(Blocks.WEATHERED_COPPER, Blocks.WAXED_WEATHERED_COPPER)
                .put(Blocks.OXIDIZED_COPPER, Blocks.WAXED_OXIDIZED_COPPER)
                .put(GufyUtil.getBlock("copper_stairs"), GufyUtil.getBlock("waxed_copper_stairs"))
                .put(GufyUtil.getBlock("exposed_copper_stairs"), GufyUtil.getBlock("waxed_exposed_copper_stairs"))
                .put(GufyUtil.getBlock("weathered_copper_stairs"), GufyUtil.getBlock("waxed_weathered_copper_stairs"))
                .put(GufyUtil.getBlock("oxidized_copper_stairs"), GufyUtil.getBlock("waxed_oxidized_copper_stairs"))
                .put(GufyUtil.getBlock("copper_slab"), GufyUtil.getBlock("waxed_copper_slab"))
                .put(GufyUtil.getBlock("exposed_copper_slab"), GufyUtil.getBlock("waxed_exposed_copper_slab"))
                .put(GufyUtil.getBlock("weathered_copper_slab"), GufyUtil.getBlock("waxed_weathered_copper_slab"))
                .put(GufyUtil.getBlock("oxidized_copper_slab"), GufyUtil.getBlock("waxed_oxidized_copper_slab"))
                .put(GufyUtil.getBlock("copper_verticalslab"), GufyUtil.getBlock("waxed_copper_verticalslab"))
                .put(GufyUtil.getBlock("exposed_copper_verticalslab"), GufyUtil.getBlock("waxed_exposed_copper_verticalslab"))
                .put(GufyUtil.getBlock("weathered_copper_verticalslab"), GufyUtil.getBlock("waxed_weathered_copper_verticalslab"))
                .put(GufyUtil.getBlock("oxidized_copper_verticalslab"), GufyUtil.getBlock("waxed_oxidized_copper_verticalslab"))
                .put(GufyUtil.getBlock("copper_wall"), GufyUtil.getBlock("waxed_copper_wall"))
                .put(GufyUtil.getBlock("exposed_copper_wall"), GufyUtil.getBlock("waxed_exposed_copper_wall"))
                .put(GufyUtil.getBlock("weathered_copper_wall"), GufyUtil.getBlock("waxed_weathered_copper_wall"))
                .put(GufyUtil.getBlock("oxidized_copper_wall"), GufyUtil.getBlock("waxed_oxidized_copper_wall"))
                .put(GufyUtil.getBlock("copper_hopper"), GufyUtil.getBlock("waxed_copper_hopper"))
                .put(GufyUtil.getBlock("exposed_copper_hopper"), GufyUtil.getBlock("waxed_exposed_copper_hopper"))
                .put(GufyUtil.getBlock("weathered_copper_hopper"), GufyUtil.getBlock("waxed_weathered_copper_hopper"))
                .put(GufyUtil.getBlock("oxidized_copper_hopper"), GufyUtil.getBlock("waxed_oxidized_copper_hopper"))
                .put(GufyUtil.getBlock("copper_post"), GufyUtil.getBlock("waxed_copper_post"))
                .put(GufyUtil.getBlock("exposed_copper_post"), GufyUtil.getBlock("waxed_exposed_copper_post"))
                .put(GufyUtil.getBlock("weathered_copper_post"), GufyUtil.getBlock("waxed_weathered_copper_post"))
                .put(GufyUtil.getBlock("oxidized_copper_post"), GufyUtil.getBlock("waxed_oxidized_copper_post"))
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
                .put(GufyUtil.getBlock("cut_copper_verticalslab"), GufyUtil.getBlock("waxed_cut_copper_verticalslab"))
                .put(GufyUtil.getBlock("exposed_cut_copper_verticalslab"), GufyUtil.getBlock("waxed_exposed_cut_copper_verticalslab"))
                .put(GufyUtil.getBlock("weathered_cut_copper_verticalslab"), GufyUtil.getBlock("waxed_weathered_cut_copper_verticalslab"))
                .put(GufyUtil.getBlock("oxidized_cut_copper_verticalslab"), GufyUtil.getBlock("waxed_oxidized_cut_copper_verticalslab"))
                .put(GufyUtil.getBlock("cut_copper_wall"), GufyUtil.getBlock("waxed_cut_copper_wall"))
                .put(GufyUtil.getBlock("exposed_cut_copper_wall"), GufyUtil.getBlock("waxed_exposed_cut_copper_wall"))
                .put(GufyUtil.getBlock("weathered_cut_copper_wall"), GufyUtil.getBlock("waxed_weathered_cut_copper_wall"))
                .put(GufyUtil.getBlock("oxidized_cut_copper_wall"), GufyUtil.getBlock("waxed_oxidized_cut_copper_wall"))
                .put(GufyUtil.getBlock("cut_copper_hopper"), GufyUtil.getBlock("waxed_cut_copper_hopper"))
                .put(GufyUtil.getBlock("exposed_cut_copper_hopper"), GufyUtil.getBlock("waxed_exposed_cut_copper_hopper"))
                .put(GufyUtil.getBlock("weathered_cut_copper_hopper"), GufyUtil.getBlock("waxed_weathered_cut_copper_hopper"))
                .put(GufyUtil.getBlock("oxidized_cut_copper_hopper"), GufyUtil.getBlock("waxed_oxidized_cut_copper_hopper"))
                .put(GufyUtil.getBlock("cut_copper_post"), GufyUtil.getBlock("waxed_cut_copper_post"))
                .put(GufyUtil.getBlock("exposed_cut_copper_post"), GufyUtil.getBlock("waxed_exposed_cut_copper_post"))
                .put(GufyUtil.getBlock("weathered_cut_copper_post"), GufyUtil.getBlock("waxed_weathered_cut_copper_post"))
                .put(GufyUtil.getBlock("oxidized_cut_copper_post"), GufyUtil.getBlock("waxed_oxidized_cut_copper_post"))
                .build();
    });
    public static final Supplier<BiMap<Block, Block>> WAX_OFF_BY_BLOCK = Suppliers.memoize(() -> {
        return WAXABLES.get().inverse();
    });
}
