package elwood612.gufyblocks.blocks.blockUtil;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface GufyStrippable {
    public static final Supplier<BiMap<Block, Block>> STRIPPABLES = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                // OAK
                .put(GufyUtil.getGufyBlock("oak_wood_stairs").get(), GufyUtil.getGufyBlock("stripped_oak_wood_stairs").get())
                .put(GufyUtil.getGufyBlock("oak_wood_slab").get(), GufyUtil.getGufyBlock("stripped_oak_wood_slab").get())
                .put(GufyUtil.getGufyBlock("oak_wood_verticalslab").get(), GufyUtil.getGufyBlock("stripped_oak_wood_verticalslab").get())
                .put(GufyUtil.getGufyBlock("oak_wood_wall").get(), GufyUtil.getGufyBlock("stripped_oak_wood_wall").get())
                .put(GufyUtil.getGufyBlock("oak_wood_hopper").get(), GufyUtil.getGufyBlock("stripped_oak_wood_hopper").get())
                .put(GufyUtil.getGufyBlock("oak_wood_fence").get(), GufyUtil.getGufyBlock("stripped_oak_wood_fence").get())
                .put(GufyUtil.getGufyBlock("oak_wood_panel").get(), GufyUtil.getGufyBlock("stripped_oak_wood_panel").get())
                // SPRUCE
                .put(GufyUtil.getGufyBlock("spruce_wood_stairs").get(), GufyUtil.getGufyBlock("stripped_spruce_wood_stairs").get())
                .put(GufyUtil.getGufyBlock("spruce_wood_slab").get(), GufyUtil.getGufyBlock("stripped_spruce_wood_slab").get())
                .put(GufyUtil.getGufyBlock("spruce_wood_verticalslab").get(), GufyUtil.getGufyBlock("stripped_spruce_wood_verticalslab").get())
                .put(GufyUtil.getGufyBlock("spruce_wood_wall").get(), GufyUtil.getGufyBlock("stripped_spruce_wood_wall").get())
                .put(GufyUtil.getGufyBlock("spruce_wood_hopper").get(), GufyUtil.getGufyBlock("stripped_spruce_wood_hopper").get())
                .put(GufyUtil.getGufyBlock("spruce_wood_fence").get(), GufyUtil.getGufyBlock("stripped_spruce_wood_fence").get())
                .put(GufyUtil.getGufyBlock("spruce_wood_panel").get(), GufyUtil.getGufyBlock("stripped_spruce_wood_panel").get())
                // BIRCH
                .put(GufyUtil.getGufyBlock("birch_wood_stairs").get(), GufyUtil.getGufyBlock("stripped_birch_wood_stairs").get())
                .put(GufyUtil.getGufyBlock("birch_wood_slab").get(), GufyUtil.getGufyBlock("stripped_birch_wood_slab").get())
                .put(GufyUtil.getGufyBlock("birch_wood_verticalslab").get(), GufyUtil.getGufyBlock("stripped_birch_wood_verticalslab").get())
                .put(GufyUtil.getGufyBlock("birch_wood_wall").get(), GufyUtil.getGufyBlock("stripped_birch_wood_wall").get())
                .put(GufyUtil.getGufyBlock("birch_wood_hopper").get(), GufyUtil.getGufyBlock("stripped_birch_wood_hopper").get())
                .put(GufyUtil.getGufyBlock("birch_wood_fence").get(), GufyUtil.getGufyBlock("stripped_birch_wood_fence").get())
                .put(GufyUtil.getGufyBlock("birch_wood_panel").get(), GufyUtil.getGufyBlock("stripped_birch_wood_panel").get())
                // DARK_OAK
                .put(GufyUtil.getGufyBlock("dark_oak_wood_stairs").get(), GufyUtil.getGufyBlock("stripped_dark_oak_wood_stairs").get())
                .put(GufyUtil.getGufyBlock("dark_oak_wood_slab").get(), GufyUtil.getGufyBlock("stripped_dark_oak_wood_slab").get())
                .put(GufyUtil.getGufyBlock("dark_oak_wood_verticalslab").get(), GufyUtil.getGufyBlock("stripped_dark_oak_wood_verticalslab").get())
                .put(GufyUtil.getGufyBlock("dark_oak_wood_wall").get(), GufyUtil.getGufyBlock("stripped_dark_oak_wood_wall").get())
                .put(GufyUtil.getGufyBlock("dark_oak_wood_hopper").get(), GufyUtil.getGufyBlock("stripped_dark_oak_wood_hopper").get())
                .put(GufyUtil.getGufyBlock("dark_oak_wood_fence").get(), GufyUtil.getGufyBlock("stripped_dark_oak_wood_fence").get())
                .put(GufyUtil.getGufyBlock("dark_oak_wood_panel").get(), GufyUtil.getGufyBlock("stripped_dark_oak_wood_panel").get())
                // JUNGLE
                .put(GufyUtil.getGufyBlock("jungle_wood_stairs").get(), GufyUtil.getGufyBlock("stripped_jungle_wood_stairs").get())
                .put(GufyUtil.getGufyBlock("jungle_wood_slab").get(), GufyUtil.getGufyBlock("stripped_jungle_wood_slab").get())
                .put(GufyUtil.getGufyBlock("jungle_wood_verticalslab").get(), GufyUtil.getGufyBlock("stripped_jungle_wood_verticalslab").get())
                .put(GufyUtil.getGufyBlock("jungle_wood_wall").get(), GufyUtil.getGufyBlock("stripped_jungle_wood_wall").get())
                .put(GufyUtil.getGufyBlock("jungle_wood_hopper").get(), GufyUtil.getGufyBlock("stripped_jungle_wood_hopper").get())
                .put(GufyUtil.getGufyBlock("jungle_wood_fence").get(), GufyUtil.getGufyBlock("stripped_jungle_wood_fence").get())
                .put(GufyUtil.getGufyBlock("jungle_wood_panel").get(), GufyUtil.getGufyBlock("stripped_jungle_wood_panel").get())
                // ACACIA
                .put(GufyUtil.getGufyBlock("acacia_wood_stairs").get(), GufyUtil.getGufyBlock("stripped_acacia_wood_stairs").get())
                .put(GufyUtil.getGufyBlock("acacia_wood_slab").get(), GufyUtil.getGufyBlock("stripped_acacia_wood_slab").get())
                .put(GufyUtil.getGufyBlock("acacia_wood_verticalslab").get(), GufyUtil.getGufyBlock("stripped_acacia_wood_verticalslab").get())
                .put(GufyUtil.getGufyBlock("acacia_wood_wall").get(), GufyUtil.getGufyBlock("stripped_acacia_wood_wall").get())
                .put(GufyUtil.getGufyBlock("acacia_wood_hopper").get(), GufyUtil.getGufyBlock("stripped_acacia_wood_hopper").get())
                .put(GufyUtil.getGufyBlock("acacia_wood_fence").get(), GufyUtil.getGufyBlock("stripped_acacia_wood_fence").get())
                .put(GufyUtil.getGufyBlock("acacia_wood_panel").get(), GufyUtil.getGufyBlock("stripped_acacia_wood_panel").get())
                // CRIMSON
                .put(GufyUtil.getGufyBlock("crimson_hyphae_stairs").get(), GufyUtil.getGufyBlock("stripped_crimson_hyphae_stairs").get())
                .put(GufyUtil.getGufyBlock("crimson_hyphae_slab").get(), GufyUtil.getGufyBlock("stripped_crimson_hyphae_slab").get())
                .put(GufyUtil.getGufyBlock("crimson_hyphae_verticalslab").get(), GufyUtil.getGufyBlock("stripped_crimson_hyphae_verticalslab").get())
                .put(GufyUtil.getGufyBlock("crimson_hyphae_wall").get(), GufyUtil.getGufyBlock("stripped_crimson_hyphae_wall").get())
                .put(GufyUtil.getGufyBlock("crimson_hyphae_hopper").get(), GufyUtil.getGufyBlock("stripped_crimson_hyphae_hopper").get())
                .put(GufyUtil.getGufyBlock("crimson_hyphae_fence").get(), GufyUtil.getGufyBlock("stripped_crimson_hyphae_fence").get())
                .put(GufyUtil.getGufyBlock("crimson_hyphae_panel").get(), GufyUtil.getGufyBlock("stripped_crimson_hyphae_panel").get())
                // WARPED
                .put(GufyUtil.getGufyBlock("warped_hyphae_stairs").get(), GufyUtil.getGufyBlock("stripped_warped_hyphae_stairs").get())
                .put(GufyUtil.getGufyBlock("warped_hyphae_slab").get(), GufyUtil.getGufyBlock("stripped_warped_hyphae_slab").get())
                .put(GufyUtil.getGufyBlock("warped_hyphae_verticalslab").get(), GufyUtil.getGufyBlock("stripped_warped_hyphae_verticalslab").get())
                .put(GufyUtil.getGufyBlock("warped_hyphae_wall").get(), GufyUtil.getGufyBlock("stripped_warped_hyphae_wall").get())
                .put(GufyUtil.getGufyBlock("warped_hyphae_hopper").get(), GufyUtil.getGufyBlock("stripped_warped_hyphae_hopper").get())
                .put(GufyUtil.getGufyBlock("warped_hyphae_fence").get(), GufyUtil.getGufyBlock("stripped_warped_hyphae_fence").get())
                .put(GufyUtil.getGufyBlock("warped_hyphae_panel").get(), GufyUtil.getGufyBlock("stripped_warped_hyphae_panel").get())
                // MANGROVE
                .put(GufyUtil.getGufyBlock("mangrove_wood_stairs").get(), GufyUtil.getGufyBlock("stripped_mangrove_wood_stairs").get())
                .put(GufyUtil.getGufyBlock("mangrove_wood_slab").get(), GufyUtil.getGufyBlock("stripped_mangrove_wood_slab").get())
                .put(GufyUtil.getGufyBlock("mangrove_wood_verticalslab").get(), GufyUtil.getGufyBlock("stripped_mangrove_wood_verticalslab").get())
                .put(GufyUtil.getGufyBlock("mangrove_wood_wall").get(), GufyUtil.getGufyBlock("stripped_mangrove_wood_wall").get())
                .put(GufyUtil.getGufyBlock("mangrove_wood_hopper").get(), GufyUtil.getGufyBlock("stripped_mangrove_wood_hopper").get())
                .put(GufyUtil.getGufyBlock("mangrove_wood_fence").get(), GufyUtil.getGufyBlock("stripped_mangrove_wood_fence").get())
                .put(GufyUtil.getGufyBlock("mangrove_wood_panel").get(), GufyUtil.getGufyBlock("stripped_mangrove_wood_panel").get())
                // CHERRY
                .put(GufyUtil.getGufyBlock("cherry_wood_stairs").get(), GufyUtil.getGufyBlock("stripped_cherry_wood_stairs").get())
                .put(GufyUtil.getGufyBlock("cherry_wood_slab").get(), GufyUtil.getGufyBlock("stripped_cherry_wood_slab").get())
                .put(GufyUtil.getGufyBlock("cherry_wood_verticalslab").get(), GufyUtil.getGufyBlock("stripped_cherry_wood_verticalslab").get())
                .put(GufyUtil.getGufyBlock("cherry_wood_wall").get(), GufyUtil.getGufyBlock("stripped_cherry_wood_wall").get())
                .put(GufyUtil.getGufyBlock("cherry_wood_hopper").get(), GufyUtil.getGufyBlock("stripped_cherry_wood_hopper").get())
                .put(GufyUtil.getGufyBlock("cherry_wood_fence").get(), GufyUtil.getGufyBlock("stripped_cherry_wood_fence").get())
                .put(GufyUtil.getGufyBlock("cherry_wood_panel").get(), GufyUtil.getGufyBlock("stripped_cherry_wood_panel").get())
                
                .build();
    });
}
