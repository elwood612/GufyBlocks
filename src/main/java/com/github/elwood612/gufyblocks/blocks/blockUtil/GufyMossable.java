package com.github.elwood612.gufyblocks.blocks.blockUtil;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

import static com.github.elwood612.gufyblocks.util.GufyUtil.getGufyBlock;

public interface GufyMossable
{
    public static final Supplier<BiMap<Block, Block>> MOSSABLES = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                // STONE BRICKS
                .put(Blocks.STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS)
                .put(Blocks.STONE_BRICK_STAIRS, Blocks.MOSSY_STONE_BRICK_STAIRS)
                .put(Blocks.STONE_BRICK_SLAB, Blocks.MOSSY_STONE_BRICK_SLAB)
                .put(Blocks.STONE_BRICK_WALL, Blocks.MOSSY_STONE_BRICK_WALL)
                .put(getGufyBlock("stone_bricks_verticalslab"), getGufyBlock("mossy_stone_bricks_verticalslab"))
                .put(getGufyBlock("stone_bricks_hopper"), getGufyBlock("mossy_stone_bricks_hopper"))
                .put(getGufyBlock("stone_bricks_post"), getGufyBlock("mossy_stone_bricks_post"))
                // COBBLESTONE
                .put(Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE)
                .put(Blocks.COBBLESTONE_STAIRS, Blocks.MOSSY_COBBLESTONE_STAIRS)
                .put(Blocks.COBBLESTONE_SLAB, Blocks.MOSSY_COBBLESTONE_SLAB)
                .put(Blocks.COBBLESTONE_WALL, Blocks.MOSSY_COBBLESTONE_WALL)
                .put(getGufyBlock("cobblestone_verticalslab"), getGufyBlock("mossy_cobblestone_verticalslab"))
                .put(getGufyBlock("cobblestone_hopper"), getGufyBlock("mossy_cobblestone_hopper"))
                .put(getGufyBlock("cobblestone_post"), getGufyBlock("mossy_cobblestone_post"))
                // STONE TILES
                .put(getGufyBlock("cobblestone_bricks"), getGufyBlock("mossy_cobblestone_bricks"))
                .put(getGufyBlock("cobblestone_bricks_stairs"), getGufyBlock("mossy_cobblestone_bricks_stairs"))
                .put(getGufyBlock("cobblestone_bricks_slab"), getGufyBlock("mossy_cobblestone_bricks_slab"))
                .put(getGufyBlock("cobblestone_bricks_verticalslab"), getGufyBlock("mossy_cobblestone_bricks_verticalslab"))
                .put(getGufyBlock("cobblestone_bricks_wall"), getGufyBlock("mossy_cobblestone_bricks_wall"))
                .put(getGufyBlock("cobblestone_bricks_hopper"), getGufyBlock("mossy_cobblestone_bricks_hopper"))
                .put(getGufyBlock("cobblestone_bricks_post"), getGufyBlock("mossy_cobblestone_bricks_post"))
                // DIORITE BRICKS
                .put(getGufyBlock("diorite_bricks"), getGufyBlock("mossy_diorite_bricks"))
                .put(getGufyBlock("diorite_bricks_stairs"), getGufyBlock("mossy_diorite_bricks_stairs"))
                .put(getGufyBlock("diorite_bricks_slab"), getGufyBlock("mossy_diorite_bricks_slab"))
                .put(getGufyBlock("diorite_bricks_verticalslab"), getGufyBlock("mossy_diorite_bricks_verticalslab"))
                .put(getGufyBlock("diorite_bricks_wall"), getGufyBlock("mossy_diorite_bricks_wall"))
                .put(getGufyBlock("diorite_bricks_hopper"), getGufyBlock("mossy_diorite_bricks_hopper"))
                .put(getGufyBlock("diorite_bricks_post"), getGufyBlock("mossy_diorite_bricks_post"))
                // DIORITE TILES
                .put(getGufyBlock("diorite_cobble_bricks"), getGufyBlock("mossy_diorite_cobble_bricks"))
                .put(getGufyBlock("diorite_cobble_bricks_stairs"), getGufyBlock("mossy_diorite_cobble_bricks_stairs"))
                .put(getGufyBlock("diorite_cobble_bricks_slab"), getGufyBlock("mossy_diorite_cobble_bricks_slab"))
                .put(getGufyBlock("diorite_cobble_bricks_verticalslab"), getGufyBlock("mossy_diorite_cobble_bricks_verticalslab"))
                .put(getGufyBlock("diorite_cobble_bricks_wall"), getGufyBlock("mossy_diorite_cobble_bricks_wall"))
                .put(getGufyBlock("diorite_cobble_bricks_hopper"), getGufyBlock("mossy_diorite_cobble_bricks_hopper"))
                .put(getGufyBlock("diorite_cobble_bricks_post"), getGufyBlock("mossy_diorite_cobble_bricks_post"))
                // GRANITE BRICKS
                .put(getGufyBlock("granite_bricks"), getGufyBlock("mossy_granite_bricks"))
                .put(getGufyBlock("granite_bricks_stairs"), getGufyBlock("mossy_granite_bricks_stairs"))
                .put(getGufyBlock("granite_bricks_slab"), getGufyBlock("mossy_granite_bricks_slab"))
                .put(getGufyBlock("granite_bricks_verticalslab"), getGufyBlock("mossy_granite_bricks_verticalslab"))
                .put(getGufyBlock("granite_bricks_wall"), getGufyBlock("mossy_granite_bricks_wall"))
                .put(getGufyBlock("granite_bricks_hopper"), getGufyBlock("mossy_granite_bricks_hopper"))
                .put(getGufyBlock("granite_bricks_post"), getGufyBlock("mossy_granite_bricks_post"))
                // GRANITE TILES
                .put(getGufyBlock("granite_cobble_bricks"), getGufyBlock("mossy_granite_cobble_bricks"))
                .put(getGufyBlock("granite_cobble_bricks_stairs"), getGufyBlock("mossy_granite_cobble_bricks_stairs"))
                .put(getGufyBlock("granite_cobble_bricks_slab"), getGufyBlock("mossy_granite_cobble_bricks_slab"))
                .put(getGufyBlock("granite_cobble_bricks_verticalslab"), getGufyBlock("mossy_granite_cobble_bricks_verticalslab"))
                .put(getGufyBlock("granite_cobble_bricks_wall"), getGufyBlock("mossy_granite_cobble_bricks_wall"))
                .put(getGufyBlock("granite_cobble_bricks_hopper"), getGufyBlock("mossy_granite_cobble_bricks_hopper"))
                .put(getGufyBlock("granite_cobble_bricks_post"), getGufyBlock("mossy_granite_cobble_bricks_post"))
                // ANDESITE BRICKS
                .put(getGufyBlock("andesite_bricks"), getGufyBlock("mossy_andesite_bricks"))
                .put(getGufyBlock("andesite_bricks_stairs"), getGufyBlock("mossy_andesite_bricks_stairs"))
                .put(getGufyBlock("andesite_bricks_slab"), getGufyBlock("mossy_andesite_bricks_slab"))
                .put(getGufyBlock("andesite_bricks_verticalslab"), getGufyBlock("mossy_andesite_bricks_verticalslab"))
                .put(getGufyBlock("andesite_bricks_wall"), getGufyBlock("mossy_andesite_bricks_wall"))
                .put(getGufyBlock("andesite_bricks_hopper"), getGufyBlock("mossy_andesite_bricks_hopper"))
                .put(getGufyBlock("andesite_bricks_post"), getGufyBlock("mossy_andesite_bricks_post"))
                // COBBLED DEEPSLATE
                .put(Blocks.COBBLED_DEEPSLATE, getGufyBlock("mossy_cobbled_deepslate"))
                .put(Blocks.COBBLED_DEEPSLATE_STAIRS, getGufyBlock("mossy_cobbled_deepslate_stairs"))
                .put(Blocks.COBBLED_DEEPSLATE_SLAB, getGufyBlock("mossy_cobbled_deepslate_slab"))
                .put(Blocks.COBBLED_DEEPSLATE_WALL, getGufyBlock("mossy_cobbled_deepslate_wall"))
                .put(getGufyBlock("cobbled_deepslate_verticalslab"), getGufyBlock("mossy_cobbled_deepslate_verticalslab"))
                .put(getGufyBlock("cobbled_deepslate_hopper"), getGufyBlock("mossy_cobbled_deepslate_hopper"))
                .put(getGufyBlock("cobbled_deepslate_post"), getGufyBlock("mossy_cobbled_deepslate_post"))
                // DEEPSLATE BRICKS
                .put(Blocks.DEEPSLATE_BRICKS, getGufyBlock("mossy_deepslate_bricks"))
                .put(Blocks.DEEPSLATE_BRICK_STAIRS, getGufyBlock("mossy_deepslate_bricks_stairs"))
                .put(Blocks.DEEPSLATE_BRICK_SLAB, getGufyBlock("mossy_deepslate_bricks_slab"))
                .put(Blocks.DEEPSLATE_BRICK_WALL, getGufyBlock("mossy_deepslate_bricks_wall"))
                .put(getGufyBlock("deepslate_bricks_verticalslab"), getGufyBlock("mossy_deepslate_bricks_verticalslab"))
                .put(getGufyBlock("deepslate_bricks_hopper"), getGufyBlock("mossy_deepslate_bricks_hopper"))
                .put(getGufyBlock("deepslate_bricks_post"), getGufyBlock("mossy_deepslate_bricks_post"))
                // DEEPSLATE TILES
                .put(Blocks.DEEPSLATE_TILES, getGufyBlock("mossy_deepslate_tiles"))
                .put(Blocks.DEEPSLATE_TILE_STAIRS, getGufyBlock("mossy_deepslate_tiles_stairs"))
                .put(Blocks.DEEPSLATE_TILE_SLAB, getGufyBlock("mossy_deepslate_tiles_slab"))
                .put(Blocks.DEEPSLATE_TILE_WALL, getGufyBlock("mossy_deepslate_tiles_wall"))
                .put(getGufyBlock("deepslate_tiles_verticalslab"), getGufyBlock("mossy_deepslate_tiles_verticalslab"))
                .put(getGufyBlock("deepslate_tiles_hopper"), getGufyBlock("mossy_deepslate_tiles_hopper"))
                .put(getGufyBlock("deepslate_tiles_post"), getGufyBlock("mossy_deepslate_tiles_post"))
                // SANDSTONE BRICKS
                .put(getGufyBlock("sandstone_bricks"), getGufyBlock("mossy_sandstone_bricks"))
                .put(getGufyBlock("sandstone_bricks_stairs"), getGufyBlock("mossy_sandstone_bricks_stairs"))
                .put(getGufyBlock("sandstone_bricks_slab"), getGufyBlock("mossy_sandstone_bricks_slab"))
                .put(getGufyBlock("sandstone_bricks_verticalslab"), getGufyBlock("mossy_sandstone_bricks_verticalslab"))
                .put(getGufyBlock("sandstone_bricks_wall"), getGufyBlock("mossy_sandstone_bricks_wall"))
                .put(getGufyBlock("sandstone_bricks_hopper"), getGufyBlock("mossy_sandstone_bricks_hopper"))
                .put(getGufyBlock("sandstone_bricks_post"), getGufyBlock("mossy_sandstone_bricks_post"))
                // SANDSTONE TILES
                .put(getGufyBlock("sandstone_cobble_bricks"), getGufyBlock("mossy_sandstone_cobble_bricks"))
                .put(getGufyBlock("sandstone_cobble_bricks_stairs"), getGufyBlock("mossy_sandstone_cobble_bricks_stairs"))
                .put(getGufyBlock("sandstone_cobble_bricks_slab"), getGufyBlock("mossy_sandstone_cobble_bricks_slab"))
                .put(getGufyBlock("sandstone_cobble_bricks_verticalslab"), getGufyBlock("mossy_sandstone_cobble_bricks_verticalslab"))
                .put(getGufyBlock("sandstone_cobble_bricks_wall"), getGufyBlock("mossy_sandstone_cobble_bricks_wall"))
                .put(getGufyBlock("sandstone_cobble_bricks_hopper"), getGufyBlock("mossy_sandstone_cobble_bricks_hopper"))
                .put(getGufyBlock("sandstone_cobble_bricks_post"), getGufyBlock("mossy_sandstone_cobble_bricks_post"))
                // RED SANDSTONE BRICKS
                .put(getGufyBlock("red_sandstone_bricks"), getGufyBlock("mossy_red_sandstone_bricks"))
                .put(getGufyBlock("red_sandstone_bricks_stairs"), getGufyBlock("mossy_red_sandstone_bricks_stairs"))
                .put(getGufyBlock("red_sandstone_bricks_slab"), getGufyBlock("mossy_red_sandstone_bricks_slab"))
                .put(getGufyBlock("red_sandstone_bricks_verticalslab"), getGufyBlock("mossy_red_sandstone_bricks_verticalslab"))
                .put(getGufyBlock("red_sandstone_bricks_wall"), getGufyBlock("mossy_red_sandstone_bricks_wall"))
                .put(getGufyBlock("red_sandstone_bricks_hopper"), getGufyBlock("mossy_red_sandstone_bricks_hopper"))
                .put(getGufyBlock("red_sandstone_bricks_post"), getGufyBlock("mossy_red_sandstone_bricks_post"))
                // RED SANDSTONE TILES
                .put(getGufyBlock("red_sandstone_cobble_bricks"), getGufyBlock("mossy_red_sandstone_cobble_bricks"))
                .put(getGufyBlock("red_sandstone_cobble_bricks_stairs"), getGufyBlock("mossy_red_sandstone_cobble_bricks_stairs"))
                .put(getGufyBlock("red_sandstone_cobble_bricks_slab"), getGufyBlock("mossy_red_sandstone_cobble_bricks_slab"))
                .put(getGufyBlock("red_sandstone_cobble_bricks_verticalslab"), getGufyBlock("mossy_red_sandstone_cobble_bricks_verticalslab"))
                .put(getGufyBlock("red_sandstone_cobble_bricks_wall"), getGufyBlock("mossy_red_sandstone_cobble_bricks_wall"))
                .put(getGufyBlock("red_sandstone_cobble_bricks_hopper"), getGufyBlock("mossy_red_sandstone_cobble_bricks_hopper"))
                .put(getGufyBlock("red_sandstone_cobble_bricks_post"), getGufyBlock("mossy_red_sandstone_cobble_bricks_post"))
                // BRICKS
                .put(Blocks.BRICKS, getGufyBlock("mossy_bricks"))
                .put(Blocks.BRICK_STAIRS, getGufyBlock("mossy_bricks_stairs"))
                .put(Blocks.BRICK_SLAB, getGufyBlock("mossy_bricks_slab"))
                .put(Blocks.BRICK_WALL, getGufyBlock("mossy_bricks_wall"))
                .put(getGufyBlock("brick_verticalslab"), getGufyBlock("mossy_bricks_verticalslab"))
                .put(getGufyBlock("brick_hopper"), getGufyBlock("mossy_bricks_hopper"))
                .put(getGufyBlock("brick_post"), getGufyBlock("mossy_bricks_post"))
                
                .build();
    });
}
