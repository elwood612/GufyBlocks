package com.github.elwood612.gufyblocks.blocks.blockUtil;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

import static com.github.elwood612.gufyblocks.util.GufyUtil.getGufyBlock;

public interface GufyStrippable {
    public static final Supplier<BiMap<Block, Block>> STRIPPABLES = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                // OAK
                .put(getGufyBlock("oak_wood_stairs"), getGufyBlock("stripped_oak_wood_stairs"))
                .put(getGufyBlock("oak_wood_slab"), getGufyBlock("stripped_oak_wood_slab"))
                .put(getGufyBlock("oak_wood_verticalslab"), getGufyBlock("stripped_oak_wood_verticalslab"))
                .put(getGufyBlock("oak_wood_wall"), getGufyBlock("stripped_oak_wood_wall"))
                .put(getGufyBlock("oak_wood_hopper"), getGufyBlock("stripped_oak_wood_hopper"))
                .put(getGufyBlock("oak_wood_fence"), getGufyBlock("stripped_oak_wood_fence"))
                .put(getGufyBlock("oak_wood_panel"), getGufyBlock("stripped_oak_wood_panel"))
                // SPRUCE
                .put(getGufyBlock("spruce_wood_stairs"), getGufyBlock("stripped_spruce_wood_stairs"))
                .put(getGufyBlock("spruce_wood_slab"), getGufyBlock("stripped_spruce_wood_slab"))
                .put(getGufyBlock("spruce_wood_verticalslab"), getGufyBlock("stripped_spruce_wood_verticalslab"))
                .put(getGufyBlock("spruce_wood_wall"), getGufyBlock("stripped_spruce_wood_wall"))
                .put(getGufyBlock("spruce_wood_hopper"), getGufyBlock("stripped_spruce_wood_hopper"))
                .put(getGufyBlock("spruce_wood_fence"), getGufyBlock("stripped_spruce_wood_fence"))
                .put(getGufyBlock("spruce_wood_panel"), getGufyBlock("stripped_spruce_wood_panel"))
                // BIRCH
                .put(getGufyBlock("birch_wood_stairs"), getGufyBlock("stripped_birch_wood_stairs"))
                .put(getGufyBlock("birch_wood_slab"), getGufyBlock("stripped_birch_wood_slab"))
                .put(getGufyBlock("birch_wood_verticalslab"), getGufyBlock("stripped_birch_wood_verticalslab"))
                .put(getGufyBlock("birch_wood_wall"), getGufyBlock("stripped_birch_wood_wall"))
                .put(getGufyBlock("birch_wood_hopper"), getGufyBlock("stripped_birch_wood_hopper"))
                .put(getGufyBlock("birch_wood_fence"), getGufyBlock("stripped_birch_wood_fence"))
                .put(getGufyBlock("birch_wood_panel"), getGufyBlock("stripped_birch_wood_panel"))
                // DARK_OAK
                .put(getGufyBlock("dark_oak_wood_stairs"), getGufyBlock("stripped_dark_oak_wood_stairs"))
                .put(getGufyBlock("dark_oak_wood_slab"), getGufyBlock("stripped_dark_oak_wood_slab"))
                .put(getGufyBlock("dark_oak_wood_verticalslab"), getGufyBlock("stripped_dark_oak_wood_verticalslab"))
                .put(getGufyBlock("dark_oak_wood_wall"), getGufyBlock("stripped_dark_oak_wood_wall"))
                .put(getGufyBlock("dark_oak_wood_hopper"), getGufyBlock("stripped_dark_oak_wood_hopper"))
                .put(getGufyBlock("dark_oak_wood_fence"), getGufyBlock("stripped_dark_oak_wood_fence"))
                .put(getGufyBlock("dark_oak_wood_panel"), getGufyBlock("stripped_dark_oak_wood_panel"))
                // JUNGLE
                .put(getGufyBlock("jungle_wood_stairs"), getGufyBlock("stripped_jungle_wood_stairs"))
                .put(getGufyBlock("jungle_wood_slab"), getGufyBlock("stripped_jungle_wood_slab"))
                .put(getGufyBlock("jungle_wood_verticalslab"), getGufyBlock("stripped_jungle_wood_verticalslab"))
                .put(getGufyBlock("jungle_wood_wall"), getGufyBlock("stripped_jungle_wood_wall"))
                .put(getGufyBlock("jungle_wood_hopper"), getGufyBlock("stripped_jungle_wood_hopper"))
                .put(getGufyBlock("jungle_wood_fence"), getGufyBlock("stripped_jungle_wood_fence"))
                .put(getGufyBlock("jungle_wood_panel"), getGufyBlock("stripped_jungle_wood_panel"))
                // ACACIA
                .put(getGufyBlock("acacia_wood_stairs"), getGufyBlock("stripped_acacia_wood_stairs"))
                .put(getGufyBlock("acacia_wood_slab"), getGufyBlock("stripped_acacia_wood_slab"))
                .put(getGufyBlock("acacia_wood_verticalslab"), getGufyBlock("stripped_acacia_wood_verticalslab"))
                .put(getGufyBlock("acacia_wood_wall"), getGufyBlock("stripped_acacia_wood_wall"))
                .put(getGufyBlock("acacia_wood_hopper"), getGufyBlock("stripped_acacia_wood_hopper"))
                .put(getGufyBlock("acacia_wood_fence"), getGufyBlock("stripped_acacia_wood_fence"))
                .put(getGufyBlock("acacia_wood_panel"), getGufyBlock("stripped_acacia_wood_panel"))
                // CRIMSON
                .put(getGufyBlock("crimson_hyphae_stairs"), getGufyBlock("stripped_crimson_hyphae_stairs"))
                .put(getGufyBlock("crimson_hyphae_slab"), getGufyBlock("stripped_crimson_hyphae_slab"))
                .put(getGufyBlock("crimson_hyphae_verticalslab"), getGufyBlock("stripped_crimson_hyphae_verticalslab"))
                .put(getGufyBlock("crimson_hyphae_wall"), getGufyBlock("stripped_crimson_hyphae_wall"))
                .put(getGufyBlock("crimson_hyphae_hopper"), getGufyBlock("stripped_crimson_hyphae_hopper"))
                .put(getGufyBlock("crimson_hyphae_fence"), getGufyBlock("stripped_crimson_hyphae_fence"))
                .put(getGufyBlock("crimson_hyphae_panel"), getGufyBlock("stripped_crimson_hyphae_panel"))
                // WARPED
                .put(getGufyBlock("warped_hyphae_stairs"), getGufyBlock("stripped_warped_hyphae_stairs"))
                .put(getGufyBlock("warped_hyphae_slab"), getGufyBlock("stripped_warped_hyphae_slab"))
                .put(getGufyBlock("warped_hyphae_verticalslab"), getGufyBlock("stripped_warped_hyphae_verticalslab"))
                .put(getGufyBlock("warped_hyphae_wall"), getGufyBlock("stripped_warped_hyphae_wall"))
                .put(getGufyBlock("warped_hyphae_hopper"), getGufyBlock("stripped_warped_hyphae_hopper"))
                .put(getGufyBlock("warped_hyphae_fence"), getGufyBlock("stripped_warped_hyphae_fence"))
                .put(getGufyBlock("warped_hyphae_panel"), getGufyBlock("stripped_warped_hyphae_panel"))
                // MANGROVE
                .put(getGufyBlock("mangrove_wood_stairs"), getGufyBlock("stripped_mangrove_wood_stairs"))
                .put(getGufyBlock("mangrove_wood_slab"), getGufyBlock("stripped_mangrove_wood_slab"))
                .put(getGufyBlock("mangrove_wood_verticalslab"), getGufyBlock("stripped_mangrove_wood_verticalslab"))
                .put(getGufyBlock("mangrove_wood_wall"), getGufyBlock("stripped_mangrove_wood_wall"))
                .put(getGufyBlock("mangrove_wood_hopper"), getGufyBlock("stripped_mangrove_wood_hopper"))
                .put(getGufyBlock("mangrove_wood_fence"), getGufyBlock("stripped_mangrove_wood_fence"))
                .put(getGufyBlock("mangrove_wood_panel"), getGufyBlock("stripped_mangrove_wood_panel"))
                // CHERRY
                .put(getGufyBlock("cherry_wood_stairs"), getGufyBlock("stripped_cherry_wood_stairs"))
                .put(getGufyBlock("cherry_wood_slab"), getGufyBlock("stripped_cherry_wood_slab"))
                .put(getGufyBlock("cherry_wood_verticalslab"), getGufyBlock("stripped_cherry_wood_verticalslab"))
                .put(getGufyBlock("cherry_wood_wall"), getGufyBlock("stripped_cherry_wood_wall"))
                .put(getGufyBlock("cherry_wood_hopper"), getGufyBlock("stripped_cherry_wood_hopper"))
                .put(getGufyBlock("cherry_wood_fence"), getGufyBlock("stripped_cherry_wood_fence"))
                .put(getGufyBlock("cherry_wood_panel"), getGufyBlock("stripped_cherry_wood_panel"))
                
                .build();
    });
}
