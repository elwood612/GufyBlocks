package com.github.elwood612.gufyblocks.blocks.blockUtil;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

import static com.github.elwood612.gufyblocks.util.GufyUtil.getGufyBlock;

public interface GufyCrackable {
    public static final String[] woodTypes = {
            "oak",
            "spruce",
            "birch",
            "dark_oak",
            "jungle",
            "acacia",
            "mangrove",
            "cherry",
            "crimson",
            "warped",
            "bamboo",
            "pale_oak"
    };

    public static final Supplier<BiMap<Block, Block>> CRACKABLES = Suppliers.memoize(() -> {

        ImmutableBiMap.Builder<Block, Block> builder = ImmutableBiMap.builder();

        // STONE BRICKS
        builder.put(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS);
        builder.put(Blocks.STONE_BRICK_STAIRS, getGufyBlock("cracked_stone_bricks_stairs"));
        builder.put(Blocks.STONE_BRICK_SLAB, getGufyBlock("cracked_stone_bricks_slab"));
        builder.put(Blocks.STONE_BRICK_WALL, getGufyBlock("cracked_stone_bricks_wall"));
        builder.put(getGufyBlock("stone_bricks_verticalslab"), getGufyBlock("cracked_stone_bricks_verticalslab"));
        builder.put(getGufyBlock("stone_bricks_hopper"), getGufyBlock("cracked_stone_bricks_hopper"));
        builder.put(getGufyBlock("stone_bricks_post"), getGufyBlock("cracked_stone_bricks_post"));
        // STONE TILES
        builder.put(getGufyBlock("cobblestone_bricks"), getGufyBlock("cracked_cobblestone_bricks"));
        builder.put(getGufyBlock("cobblestone_bricks_stairs"), getGufyBlock("cracked_cobblestone_bricks_stairs"));
        builder.put(getGufyBlock("cobblestone_bricks_slab"), getGufyBlock("cracked_cobblestone_bricks_slab"));
        builder.put(getGufyBlock("cobblestone_bricks_verticalslab"), getGufyBlock("cracked_cobblestone_bricks_verticalslab"));
        builder.put(getGufyBlock("cobblestone_bricks_wall"), getGufyBlock("cracked_cobblestone_bricks_wall"));
        builder.put(getGufyBlock("cobblestone_bricks_hopper"), getGufyBlock("cracked_cobblestone_bricks_hopper"));
        builder.put(getGufyBlock("cobblestone_bricks_post"), getGufyBlock("cracked_cobblestone_bricks_post"));
        // DIORITE BRICKS
        builder.put(getGufyBlock("diorite_bricks"), getGufyBlock("cracked_diorite_bricks"));
        builder.put(getGufyBlock("diorite_bricks_stairs"), getGufyBlock("cracked_diorite_bricks_stairs"));
        builder.put(getGufyBlock("diorite_bricks_slab"), getGufyBlock("cracked_diorite_bricks_slab"));
        builder.put(getGufyBlock("diorite_bricks_verticalslab"), getGufyBlock("cracked_diorite_bricks_verticalslab"));
        builder.put(getGufyBlock("diorite_bricks_wall"), getGufyBlock("cracked_diorite_bricks_wall"));
        builder.put(getGufyBlock("diorite_bricks_hopper"), getGufyBlock("cracked_diorite_bricks_hopper"));
        builder.put(getGufyBlock("diorite_bricks_post"), getGufyBlock("cracked_diorite_bricks_post"));
        // DIORITE TILES
        builder.put(getGufyBlock("diorite_cobble_bricks"), getGufyBlock("cracked_diorite_cobble_bricks"));
        builder.put(getGufyBlock("diorite_cobble_bricks_stairs"), getGufyBlock("cracked_diorite_cobble_bricks_stairs"));
        builder.put(getGufyBlock("diorite_cobble_bricks_slab"), getGufyBlock("cracked_diorite_cobble_bricks_slab"));
        builder.put(getGufyBlock("diorite_cobble_bricks_verticalslab"), getGufyBlock("cracked_diorite_cobble_bricks_verticalslab"));
        builder.put(getGufyBlock("diorite_cobble_bricks_wall"), getGufyBlock("cracked_diorite_cobble_bricks_wall"));
        builder.put(getGufyBlock("diorite_cobble_bricks_hopper"), getGufyBlock("cracked_diorite_cobble_bricks_hopper"));
        builder.put(getGufyBlock("diorite_cobble_bricks_post"), getGufyBlock("cracked_diorite_cobble_bricks_post"));
        // GRANITE BRICKS
        builder.put(getGufyBlock("granite_bricks"), getGufyBlock("cracked_granite_bricks"));
        builder.put(getGufyBlock("granite_bricks_stairs"), getGufyBlock("cracked_granite_bricks_stairs"));
        builder.put(getGufyBlock("granite_bricks_slab"), getGufyBlock("cracked_granite_bricks_slab"));
        builder.put(getGufyBlock("granite_bricks_verticalslab"), getGufyBlock("cracked_granite_bricks_verticalslab"));
        builder.put(getGufyBlock("granite_bricks_wall"), getGufyBlock("cracked_granite_bricks_wall"));
        builder.put(getGufyBlock("granite_bricks_hopper"), getGufyBlock("cracked_granite_bricks_hopper"));
        builder.put(getGufyBlock("granite_bricks_post"), getGufyBlock("cracked_granite_bricks_post"));
        // GRANITE TILES
        builder.put(getGufyBlock("granite_cobble_bricks"), getGufyBlock("cracked_granite_cobble_bricks"));
        builder.put(getGufyBlock("granite_cobble_bricks_stairs"), getGufyBlock("cracked_granite_cobble_bricks_stairs"));
        builder.put(getGufyBlock("granite_cobble_bricks_slab"), getGufyBlock("cracked_granite_cobble_bricks_slab"));
        builder.put(getGufyBlock("granite_cobble_bricks_verticalslab"), getGufyBlock("cracked_granite_cobble_bricks_verticalslab"));
        builder.put(getGufyBlock("granite_cobble_bricks_wall"), getGufyBlock("cracked_granite_cobble_bricks_wall"));
        builder.put(getGufyBlock("granite_cobble_bricks_hopper"), getGufyBlock("cracked_granite_cobble_bricks_hopper"));
        builder.put(getGufyBlock("granite_cobble_bricks_post"), getGufyBlock("cracked_granite_cobble_bricks_post"));
        // ANDESITE BRICKS
        builder.put(getGufyBlock("andesite_bricks"), getGufyBlock("cracked_andesite_bricks"));
        builder.put(getGufyBlock("andesite_bricks_stairs"), getGufyBlock("cracked_andesite_bricks_stairs"));
        builder.put(getGufyBlock("andesite_bricks_slab"), getGufyBlock("cracked_andesite_bricks_slab"));
        builder.put(getGufyBlock("andesite_bricks_verticalslab"), getGufyBlock("cracked_andesite_bricks_verticalslab"));
        builder.put(getGufyBlock("andesite_bricks_wall"), getGufyBlock("cracked_andesite_bricks_wall"));
        builder.put(getGufyBlock("andesite_bricks_hopper"), getGufyBlock("cracked_andesite_bricks_hopper"));
        builder.put(getGufyBlock("andesite_bricks_post"), getGufyBlock("cracked_andesite_bricks_post"));
        // NETHER BRICKS
        builder.put(Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS);
        builder.put(Blocks.NETHER_BRICK_STAIRS, getGufyBlock("cracked_nether_bricks_stairs"));
        builder.put(Blocks.NETHER_BRICK_SLAB, getGufyBlock("cracked_nether_bricks_slab"));
        builder.put(Blocks.NETHER_BRICK_WALL, getGufyBlock("cracked_nether_bricks_wall"));
        builder.put(Blocks.NETHER_BRICK_FENCE, getGufyBlock("cracked_nether_bricks_fence"));
        builder.put(getGufyBlock("cracked_nether_bricks_verticalslab"), getGufyBlock("cracked_nether_bricks_verticalslab"));
        builder.put(getGufyBlock("cracked_nether_bricks_hopper"), getGufyBlock("cracked_nether_bricks_hopper"));
        // DEEPSLATE BRICKS
        builder.put(Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS);
        builder.put(Blocks.DEEPSLATE_BRICK_STAIRS, getGufyBlock("cracked_deepslate_bricks_stairs"));
        builder.put(Blocks.DEEPSLATE_BRICK_SLAB, getGufyBlock("cracked_deepslate_bricks_slab"));
        builder.put(Blocks.DEEPSLATE_BRICK_WALL, getGufyBlock("cracked_deepslate_bricks_wall"));
        builder.put(getGufyBlock("deepslate_bricks_verticalslab"), getGufyBlock("cracked_deepslate_bricks_verticalslab"));
        builder.put(getGufyBlock("deepslate_bricks_hopper"), getGufyBlock("cracked_deepslate_bricks_hopper"));
        builder.put(getGufyBlock("deepslate_bricks_post"), getGufyBlock("cracked_deepslate_bricks_post"));
        // DEEPSLATE TILES
        builder.put(Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES);
        builder.put(Blocks.DEEPSLATE_TILE_STAIRS, getGufyBlock("cracked_deepslate_tiles_stairs"));
        builder.put(Blocks.DEEPSLATE_TILE_SLAB, getGufyBlock("cracked_deepslate_tiles_slab"));
        builder.put(Blocks.DEEPSLATE_TILE_WALL, getGufyBlock("cracked_deepslate_tiles_wall"));
        builder.put(getGufyBlock("deepslate_tiles_verticalslab"), getGufyBlock("cracked_deepslate_tiles_verticalslab"));
        builder.put(getGufyBlock("deepslate_tiles_hopper"), getGufyBlock("cracked_deepslate_tiles_hopper"));
        builder.put(getGufyBlock("deepslate_tiles_post"), getGufyBlock("cracked_deepslate_tiles_post"));
        // POLISHED BLACKSTONE BRICKS
        builder.put(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        builder.put(Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS, getGufyBlock("cracked_polished_blackstone_brick_stairs"));
        builder.put(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB, getGufyBlock("cracked_polished_blackstone_brick_slab"));
        builder.put(Blocks.POLISHED_BLACKSTONE_BRICK_WALL, getGufyBlock("cracked_polished_blackstone_brick_wall"));
        builder.put(getGufyBlock("polished_blackstone_brick_verticalslab"), getGufyBlock("cracked_polished_blackstone_brick_verticalslab"));
        builder.put(getGufyBlock("polished_blackstone_brick_hopper"), getGufyBlock("cracked_polished_blackstone_brick_hopper"));
        builder.put(getGufyBlock("polished_blackstone_brick_post"), getGufyBlock("cracked_polished_blackstone_brick_post"));
        // SANDSTONE BRICKS
        builder.put(getGufyBlock("sandstone_bricks"), getGufyBlock("cracked_sandstone_bricks"));
        builder.put(getGufyBlock("sandstone_bricks_stairs"), getGufyBlock("cracked_sandstone_bricks_stairs"));
        builder.put(getGufyBlock("sandstone_bricks_slab"), getGufyBlock("cracked_sandstone_bricks_slab"));
        builder.put(getGufyBlock("sandstone_bricks_verticalslab"), getGufyBlock("cracked_sandstone_bricks_verticalslab"));
        builder.put(getGufyBlock("sandstone_bricks_wall"), getGufyBlock("cracked_sandstone_bricks_wall"));
        builder.put(getGufyBlock("sandstone_bricks_hopper"), getGufyBlock("cracked_sandstone_bricks_hopper"));
        builder.put(getGufyBlock("sandstone_bricks_post"), getGufyBlock("cracked_sandstone_bricks_post"));
        // SANDSTONE TILES
        builder.put(getGufyBlock("sandstone_cobble_bricks"), getGufyBlock("cracked_sandstone_cobble_bricks"));
        builder.put(getGufyBlock("sandstone_cobble_bricks_stairs"), getGufyBlock("cracked_sandstone_cobble_bricks_stairs"));
        builder.put(getGufyBlock("sandstone_cobble_bricks_slab"), getGufyBlock("cracked_sandstone_cobble_bricks_slab"));
        builder.put(getGufyBlock("sandstone_cobble_bricks_verticalslab"), getGufyBlock("cracked_sandstone_cobble_bricks_verticalslab"));
        builder.put(getGufyBlock("sandstone_cobble_bricks_wall"), getGufyBlock("cracked_sandstone_cobble_bricks_wall"));
        builder.put(getGufyBlock("sandstone_cobble_bricks_hopper"), getGufyBlock("cracked_sandstone_cobble_bricks_hopper"));
        builder.put(getGufyBlock("sandstone_cobble_bricks_post"), getGufyBlock("cracked_sandstone_cobble_bricks_post"));
        // RED SANDSTONE BRICKS
        builder.put(getGufyBlock("red_sandstone_bricks"), getGufyBlock("cracked_red_sandstone_bricks"));
        builder.put(getGufyBlock("red_sandstone_bricks_stairs"), getGufyBlock("cracked_red_sandstone_bricks_stairs"));
        builder.put(getGufyBlock("red_sandstone_bricks_slab"), getGufyBlock("cracked_red_sandstone_bricks_slab"));
        builder.put(getGufyBlock("red_sandstone_bricks_verticalslab"), getGufyBlock("cracked_red_sandstone_bricks_verticalslab"));
        builder.put(getGufyBlock("red_sandstone_bricks_wall"), getGufyBlock("cracked_red_sandstone_bricks_wall"));
        builder.put(getGufyBlock("red_sandstone_bricks_hopper"), getGufyBlock("cracked_red_sandstone_bricks_hopper"));
        builder.put(getGufyBlock("red_sandstone_bricks_post"), getGufyBlock("cracked_red_sandstone_bricks_post"));
        // RED SANDSTONE TILES
        builder.put(getGufyBlock("red_sandstone_cobble_bricks"), getGufyBlock("cracked_red_sandstone_cobble_bricks"));
        builder.put(getGufyBlock("red_sandstone_cobble_bricks_stairs"), getGufyBlock("cracked_red_sandstone_cobble_bricks_stairs"));
        builder.put(getGufyBlock("red_sandstone_cobble_bricks_slab"), getGufyBlock("cracked_red_sandstone_cobble_bricks_slab"));
        builder.put(getGufyBlock("red_sandstone_cobble_bricks_verticalslab"), getGufyBlock("cracked_red_sandstone_cobble_bricks_verticalslab"));
        builder.put(getGufyBlock("red_sandstone_cobble_bricks_wall"), getGufyBlock("cracked_red_sandstone_cobble_bricks_wall"));
        builder.put(getGufyBlock("red_sandstone_cobble_bricks_hopper"), getGufyBlock("cracked_red_sandstone_cobble_bricks_hopper"));
        builder.put(getGufyBlock("red_sandstone_cobble_bricks_post"), getGufyBlock("cracked_red_sandstone_cobble_bricks_post"));
        // BRICKS
        builder.put(Blocks.BRICKS, getGufyBlock("cracked_bricks"));
        builder.put(Blocks.BRICK_STAIRS, getGufyBlock("cracked_bricks_stairs"));
        builder.put(Blocks.BRICK_SLAB, getGufyBlock("cracked_bricks_slab"));
        builder.put(Blocks.BRICK_WALL, getGufyBlock("cracked_bricks_wall"));
        builder.put(getGufyBlock("brick_verticalslab"), getGufyBlock("cracked_bricks_verticalslab"));
        builder.put(getGufyBlock("brick_hopper"), getGufyBlock("cracked_bricks_hopper"));
        builder.put(getGufyBlock("brick_post"), getGufyBlock("cracked_bricks_post"));
        // CARVED LOGS
        builder.put(Blocks.STRIPPED_ACACIA_WOOD, getGufyBlock("chiseled_stripped_acacia_wood"));
        builder.put(Blocks.STRIPPED_BIRCH_WOOD, getGufyBlock("chiseled_stripped_birch_wood"));
        builder.put(Blocks.STRIPPED_BAMBOO_BLOCK, getGufyBlock("chiseled_stripped_bamboo_block"));
        builder.put(Blocks.STRIPPED_CRIMSON_HYPHAE, getGufyBlock("chiseled_stripped_crimson_hyphae"));
        builder.put(Blocks.STRIPPED_DARK_OAK_WOOD, getGufyBlock("chiseled_stripped_dark_oak_wood"));
        builder.put(Blocks.STRIPPED_JUNGLE_WOOD, getGufyBlock("chiseled_stripped_jungle_wood"));
        builder.put(Blocks.STRIPPED_OAK_WOOD, getGufyBlock("chiseled_stripped_oak_wood"));
        builder.put(Blocks.STRIPPED_MANGROVE_WOOD, getGufyBlock("chiseled_stripped_mangrove_wood"));
        builder.put(Blocks.STRIPPED_CHERRY_WOOD, getGufyBlock("chiseled_stripped_cherry_wood"));
        builder.put(Blocks.STRIPPED_SPRUCE_WOOD, getGufyBlock("chiseled_stripped_spruce_wood"));
        builder.put(Blocks.STRIPPED_WARPED_HYPHAE, getGufyBlock("chiseled_stripped_warped_hyphae"));
        builder.put(Blocks.STRIPPED_PALE_OAK_WOOD, getGufyBlock("chiseled_stripped_pale_oak_wood"));

        // FRAMED TERRACOTTA
        for (String woodType : woodTypes) {
            String block = woodType + "_framed_terracotta";

            builder.put(getGufyBlock(block), getGufyBlock(block + "_left"));
            builder.put(getGufyBlock(block + "_left"), getGufyBlock(block + "_right"));
            builder.put(getGufyBlock(block + "_right"), getGufyBlock(block + "_cross"));
            builder.put(getGufyBlock(block + "_cross"), getGufyBlock(block));

            for (GufyColors color : GufyColors.values()) {
                String colorBlock = woodType + "_framed_" + color.toString() + "_terracotta";

                builder.put(getGufyBlock(colorBlock), getGufyBlock(colorBlock + "_left"));
                builder.put(getGufyBlock(colorBlock + "_left"), getGufyBlock(colorBlock + "_right"));
                builder.put(getGufyBlock(colorBlock + "_right"), getGufyBlock(colorBlock + "_cross"));
                builder.put(getGufyBlock(colorBlock + "_cross"), getGufyBlock(colorBlock));
            }
        }

        return builder.build();
    });
}
