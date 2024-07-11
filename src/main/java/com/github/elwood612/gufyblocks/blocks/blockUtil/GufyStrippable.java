package com.github.elwood612.gufyblocks.blocks.blockUtil;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface GufyStrippable {
    public static final Supplier<BiMap<Block, Block>> STRIPPABLES = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                // OAK
                .put(GufyUtil.getGufyBlock("oak_wood_stairs"), GufyUtil.getGufyBlock("stripped_oak_wood_stairs"))
                .put(GufyUtil.getGufyBlock("oak_wood_slab"), GufyUtil.getGufyBlock("stripped_oak_wood_slab"))
                .put(GufyUtil.getGufyBlock("oak_wood_verticalslab"), GufyUtil.getGufyBlock("stripped_oak_wood_verticalslab"))
                .put(GufyUtil.getGufyBlock("oak_wood_wall"), GufyUtil.getGufyBlock("stripped_oak_wood_wall"))
                .put(GufyUtil.getGufyBlock("oak_wood_hopper"), GufyUtil.getGufyBlock("stripped_oak_wood_hopper"))
                .put(GufyUtil.getGufyBlock("oak_wood_fence"), GufyUtil.getGufyBlock("stripped_oak_wood_fence"))
                .put(GufyUtil.getGufyBlock("oak_wood_panel"), GufyUtil.getGufyBlock("stripped_oak_wood_panel"))
                // SPRUCE
                .put(GufyUtil.getGufyBlock("spruce_wood_stairs"), GufyUtil.getGufyBlock("stripped_spruce_wood_stairs"))
                .put(GufyUtil.getGufyBlock("spruce_wood_slab"), GufyUtil.getGufyBlock("stripped_spruce_wood_slab"))
                .put(GufyUtil.getGufyBlock("spruce_wood_verticalslab"), GufyUtil.getGufyBlock("stripped_spruce_wood_verticalslab"))
                .put(GufyUtil.getGufyBlock("spruce_wood_wall"), GufyUtil.getGufyBlock("stripped_spruce_wood_wall"))
                .put(GufyUtil.getGufyBlock("spruce_wood_hopper"), GufyUtil.getGufyBlock("stripped_spruce_wood_hopper"))
                .put(GufyUtil.getGufyBlock("spruce_wood_fence"), GufyUtil.getGufyBlock("stripped_spruce_wood_fence"))
                .put(GufyUtil.getGufyBlock("spruce_wood_panel"), GufyUtil.getGufyBlock("stripped_spruce_wood_panel"))
                // BIRCH
                .put(GufyUtil.getGufyBlock("birch_wood_stairs"), GufyUtil.getGufyBlock("stripped_birch_wood_stairs"))
                .put(GufyUtil.getGufyBlock("birch_wood_slab"), GufyUtil.getGufyBlock("stripped_birch_wood_slab"))
                .put(GufyUtil.getGufyBlock("birch_wood_verticalslab"), GufyUtil.getGufyBlock("stripped_birch_wood_verticalslab"))
                .put(GufyUtil.getGufyBlock("birch_wood_wall"), GufyUtil.getGufyBlock("stripped_birch_wood_wall"))
                .put(GufyUtil.getGufyBlock("birch_wood_hopper"), GufyUtil.getGufyBlock("stripped_birch_wood_hopper"))
                .put(GufyUtil.getGufyBlock("birch_wood_fence"), GufyUtil.getGufyBlock("stripped_birch_wood_fence"))
                .put(GufyUtil.getGufyBlock("birch_wood_panel"), GufyUtil.getGufyBlock("stripped_birch_wood_panel"))
                // DARK_OAK
                .put(GufyUtil.getGufyBlock("dark_oak_wood_stairs"), GufyUtil.getGufyBlock("stripped_dark_oak_wood_stairs"))
                .put(GufyUtil.getGufyBlock("dark_oak_wood_slab"), GufyUtil.getGufyBlock("stripped_dark_oak_wood_slab"))
                .put(GufyUtil.getGufyBlock("dark_oak_wood_verticalslab"), GufyUtil.getGufyBlock("stripped_dark_oak_wood_verticalslab"))
                .put(GufyUtil.getGufyBlock("dark_oak_wood_wall"), GufyUtil.getGufyBlock("stripped_dark_oak_wood_wall"))
                .put(GufyUtil.getGufyBlock("dark_oak_wood_hopper"), GufyUtil.getGufyBlock("stripped_dark_oak_wood_hopper"))
                .put(GufyUtil.getGufyBlock("dark_oak_wood_fence"), GufyUtil.getGufyBlock("stripped_dark_oak_wood_fence"))
                .put(GufyUtil.getGufyBlock("dark_oak_wood_panel"), GufyUtil.getGufyBlock("stripped_dark_oak_wood_panel"))
                // JUNGLE
                .put(GufyUtil.getGufyBlock("jungle_wood_stairs"), GufyUtil.getGufyBlock("stripped_jungle_wood_stairs"))
                .put(GufyUtil.getGufyBlock("jungle_wood_slab"), GufyUtil.getGufyBlock("stripped_jungle_wood_slab"))
                .put(GufyUtil.getGufyBlock("jungle_wood_verticalslab"), GufyUtil.getGufyBlock("stripped_jungle_wood_verticalslab"))
                .put(GufyUtil.getGufyBlock("jungle_wood_wall"), GufyUtil.getGufyBlock("stripped_jungle_wood_wall"))
                .put(GufyUtil.getGufyBlock("jungle_wood_hopper"), GufyUtil.getGufyBlock("stripped_jungle_wood_hopper"))
                .put(GufyUtil.getGufyBlock("jungle_wood_fence"), GufyUtil.getGufyBlock("stripped_jungle_wood_fence"))
                .put(GufyUtil.getGufyBlock("jungle_wood_panel"), GufyUtil.getGufyBlock("stripped_jungle_wood_panel"))
                // ACACIA
                .put(GufyUtil.getGufyBlock("acacia_wood_stairs"), GufyUtil.getGufyBlock("stripped_acacia_wood_stairs"))
                .put(GufyUtil.getGufyBlock("acacia_wood_slab"), GufyUtil.getGufyBlock("stripped_acacia_wood_slab"))
                .put(GufyUtil.getGufyBlock("acacia_wood_verticalslab"), GufyUtil.getGufyBlock("stripped_acacia_wood_verticalslab"))
                .put(GufyUtil.getGufyBlock("acacia_wood_wall"), GufyUtil.getGufyBlock("stripped_acacia_wood_wall"))
                .put(GufyUtil.getGufyBlock("acacia_wood_hopper"), GufyUtil.getGufyBlock("stripped_acacia_wood_hopper"))
                .put(GufyUtil.getGufyBlock("acacia_wood_fence"), GufyUtil.getGufyBlock("stripped_acacia_wood_fence"))
                .put(GufyUtil.getGufyBlock("acacia_wood_panel"), GufyUtil.getGufyBlock("stripped_acacia_wood_panel"))
                // CRIMSON
                .put(GufyUtil.getGufyBlock("crimson_hyphae_stairs"), GufyUtil.getGufyBlock("stripped_crimson_hyphae_stairs"))
                .put(GufyUtil.getGufyBlock("crimson_hyphae_slab"), GufyUtil.getGufyBlock("stripped_crimson_hyphae_slab"))
                .put(GufyUtil.getGufyBlock("crimson_hyphae_verticalslab"), GufyUtil.getGufyBlock("stripped_crimson_hyphae_verticalslab"))
                .put(GufyUtil.getGufyBlock("crimson_hyphae_wall"), GufyUtil.getGufyBlock("stripped_crimson_hyphae_wall"))
                .put(GufyUtil.getGufyBlock("crimson_hyphae_hopper"), GufyUtil.getGufyBlock("stripped_crimson_hyphae_hopper"))
                .put(GufyUtil.getGufyBlock("crimson_hyphae_fence"), GufyUtil.getGufyBlock("stripped_crimson_hyphae_fence"))
                .put(GufyUtil.getGufyBlock("crimson_hyphae_panel"), GufyUtil.getGufyBlock("stripped_crimson_hyphae_panel"))
                // WARPED
                .put(GufyUtil.getGufyBlock("warped_hyphae_stairs"), GufyUtil.getGufyBlock("stripped_warped_hyphae_stairs"))
                .put(GufyUtil.getGufyBlock("warped_hyphae_slab"), GufyUtil.getGufyBlock("stripped_warped_hyphae_slab"))
                .put(GufyUtil.getGufyBlock("warped_hyphae_verticalslab"), GufyUtil.getGufyBlock("stripped_warped_hyphae_verticalslab"))
                .put(GufyUtil.getGufyBlock("warped_hyphae_wall"), GufyUtil.getGufyBlock("stripped_warped_hyphae_wall"))
                .put(GufyUtil.getGufyBlock("warped_hyphae_hopper"), GufyUtil.getGufyBlock("stripped_warped_hyphae_hopper"))
                .put(GufyUtil.getGufyBlock("warped_hyphae_fence"), GufyUtil.getGufyBlock("stripped_warped_hyphae_fence"))
                .put(GufyUtil.getGufyBlock("warped_hyphae_panel"), GufyUtil.getGufyBlock("stripped_warped_hyphae_panel"))
                // MANGROVE
                .put(GufyUtil.getGufyBlock("mangrove_wood_stairs"), GufyUtil.getGufyBlock("stripped_mangrove_wood_stairs"))
                .put(GufyUtil.getGufyBlock("mangrove_wood_slab"), GufyUtil.getGufyBlock("stripped_mangrove_wood_slab"))
                .put(GufyUtil.getGufyBlock("mangrove_wood_verticalslab"), GufyUtil.getGufyBlock("stripped_mangrove_wood_verticalslab"))
                .put(GufyUtil.getGufyBlock("mangrove_wood_wall"), GufyUtil.getGufyBlock("stripped_mangrove_wood_wall"))
                .put(GufyUtil.getGufyBlock("mangrove_wood_hopper"), GufyUtil.getGufyBlock("stripped_mangrove_wood_hopper"))
                .put(GufyUtil.getGufyBlock("mangrove_wood_fence"), GufyUtil.getGufyBlock("stripped_mangrove_wood_fence"))
                .put(GufyUtil.getGufyBlock("mangrove_wood_panel"), GufyUtil.getGufyBlock("stripped_mangrove_wood_panel"))
                // CHERRY
                .put(GufyUtil.getGufyBlock("cherry_wood_stairs"), GufyUtil.getGufyBlock("stripped_cherry_wood_stairs"))
                .put(GufyUtil.getGufyBlock("cherry_wood_slab"), GufyUtil.getGufyBlock("stripped_cherry_wood_slab"))
                .put(GufyUtil.getGufyBlock("cherry_wood_verticalslab"), GufyUtil.getGufyBlock("stripped_cherry_wood_verticalslab"))
                .put(GufyUtil.getGufyBlock("cherry_wood_wall"), GufyUtil.getGufyBlock("stripped_cherry_wood_wall"))
                .put(GufyUtil.getGufyBlock("cherry_wood_hopper"), GufyUtil.getGufyBlock("stripped_cherry_wood_hopper"))
                .put(GufyUtil.getGufyBlock("cherry_wood_fence"), GufyUtil.getGufyBlock("stripped_cherry_wood_fence"))
                .put(GufyUtil.getGufyBlock("cherry_wood_panel"), GufyUtil.getGufyBlock("stripped_cherry_wood_panel"))
                
                .build();
    });
}
