package com.github.elwood612.gufyblocks.blocks.blockUtil;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

public interface GufyMossable
{
    public static final Supplier<BiMap<Block, Block>> MOSSABLES = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                // STONE BRICKS
                .put(Blocks.STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS)
                .put(Blocks.STONE_BRICK_STAIRS, Blocks.MOSSY_STONE_BRICK_STAIRS)
                .put(Blocks.STONE_BRICK_SLAB, Blocks.MOSSY_STONE_BRICK_SLAB)
                .put(Blocks.STONE_BRICK_WALL, Blocks.MOSSY_STONE_BRICK_WALL)
                .put(GufyUtil.getGufyBlock("stone_bricks_verticalslab"), GufyUtil.getGufyBlock("mossy_stone_bricks_verticalslab"))
                .put(GufyUtil.getGufyBlock("stone_bricks_hopper"), GufyUtil.getGufyBlock("mossy_stone_bricks_hopper"))
                .put(GufyUtil.getGufyBlock("stone_bricks_post"), GufyUtil.getGufyBlock("mossy_stone_bricks_post"))
                // COBBLESTONE
                .put(Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE)
                .put(Blocks.COBBLESTONE_STAIRS, Blocks.MOSSY_COBBLESTONE_STAIRS)
                .put(Blocks.COBBLESTONE_SLAB, Blocks.MOSSY_COBBLESTONE_SLAB)
                .put(Blocks.COBBLESTONE_WALL, Blocks.MOSSY_COBBLESTONE_WALL)
                .put(GufyUtil.getGufyBlock("cobblestone_verticalslab"), GufyUtil.getGufyBlock("mossy_cobblestone_verticalslab"))
                .put(GufyUtil.getGufyBlock("cobblestone_hopper"), GufyUtil.getGufyBlock("mossy_cobblestone_hopper"))
                .put(GufyUtil.getGufyBlock("cobblestone_post"), GufyUtil.getGufyBlock("mossy_cobblestone_post"))
                // STONE TILES
                .put(GufyUtil.getGufyBlock("cobblestone_bricks"), GufyUtil.getGufyBlock("mossy_cobblestone_bricks"))
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_stairs"), GufyUtil.getGufyBlock("mossy_cobblestone_bricks_stairs"))
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_slab"), GufyUtil.getGufyBlock("mossy_cobblestone_bricks_slab"))
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_verticalslab"), GufyUtil.getGufyBlock("mossy_cobblestone_bricks_verticalslab"))
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_wall"), GufyUtil.getGufyBlock("mossy_cobblestone_bricks_wall"))
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_hopper"), GufyUtil.getGufyBlock("mossy_cobblestone_bricks_hopper"))
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_post"), GufyUtil.getGufyBlock("mossy_cobblestone_bricks_post"))
                // DIORITE BRICKS
                .put(GufyUtil.getGufyBlock("diorite_bricks"), GufyUtil.getGufyBlock("mossy_diorite_bricks"))
                .put(GufyUtil.getGufyBlock("diorite_bricks_stairs"), GufyUtil.getGufyBlock("mossy_diorite_bricks_stairs"))
                .put(GufyUtil.getGufyBlock("diorite_bricks_slab"), GufyUtil.getGufyBlock("mossy_diorite_bricks_slab"))
                .put(GufyUtil.getGufyBlock("diorite_bricks_verticalslab"), GufyUtil.getGufyBlock("mossy_diorite_bricks_verticalslab"))
                .put(GufyUtil.getGufyBlock("diorite_bricks_wall"), GufyUtil.getGufyBlock("mossy_diorite_bricks_wall"))
                .put(GufyUtil.getGufyBlock("diorite_bricks_hopper"), GufyUtil.getGufyBlock("mossy_diorite_bricks_hopper"))
                .put(GufyUtil.getGufyBlock("diorite_bricks_post"), GufyUtil.getGufyBlock("mossy_diorite_bricks_post"))
                // DIORITE TILES
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks"), GufyUtil.getGufyBlock("mossy_diorite_cobble_bricks"))
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_stairs"), GufyUtil.getGufyBlock("mossy_diorite_cobble_bricks_stairs"))
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_slab"), GufyUtil.getGufyBlock("mossy_diorite_cobble_bricks_slab"))
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_verticalslab"), GufyUtil.getGufyBlock("mossy_diorite_cobble_bricks_verticalslab"))
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_wall"), GufyUtil.getGufyBlock("mossy_diorite_cobble_bricks_wall"))
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_hopper"), GufyUtil.getGufyBlock("mossy_diorite_cobble_bricks_hopper"))
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_post"), GufyUtil.getGufyBlock("mossy_diorite_cobble_bricks_post"))
                // GRANITE BRICKS
                .put(GufyUtil.getGufyBlock("granite_bricks"), GufyUtil.getGufyBlock("mossy_granite_bricks"))
                .put(GufyUtil.getGufyBlock("granite_bricks_stairs"), GufyUtil.getGufyBlock("mossy_granite_bricks_stairs"))
                .put(GufyUtil.getGufyBlock("granite_bricks_slab"), GufyUtil.getGufyBlock("mossy_granite_bricks_slab"))
                .put(GufyUtil.getGufyBlock("granite_bricks_verticalslab"), GufyUtil.getGufyBlock("mossy_granite_bricks_verticalslab"))
                .put(GufyUtil.getGufyBlock("granite_bricks_wall"), GufyUtil.getGufyBlock("mossy_granite_bricks_wall"))
                .put(GufyUtil.getGufyBlock("granite_bricks_hopper"), GufyUtil.getGufyBlock("mossy_granite_bricks_hopper"))
                .put(GufyUtil.getGufyBlock("granite_bricks_post"), GufyUtil.getGufyBlock("mossy_granite_bricks_post"))
                // GRANITE TILES
                .put(GufyUtil.getGufyBlock("granite_cobble_bricks"), GufyUtil.getGufyBlock("mossy_granite_cobble_bricks"))
                .put(GufyUtil.getGufyBlock("granite_cobble_bricks_stairs"), GufyUtil.getGufyBlock("mossy_granite_cobble_bricks_stairs"))
                .put(GufyUtil.getGufyBlock("granite_cobble_bricks_slab"), GufyUtil.getGufyBlock("mossy_granite_cobble_bricks_slab"))
                .put(GufyUtil.getGufyBlock("granite_cobble_bricks_verticalslab"), GufyUtil.getGufyBlock("mossy_granite_cobble_bricks_verticalslab"))
                .put(GufyUtil.getGufyBlock("granite_cobble_bricks_wall"), GufyUtil.getGufyBlock("mossy_granite_cobble_bricks_wall"))
                .put(GufyUtil.getGufyBlock("granite_cobble_bricks_hopper"), GufyUtil.getGufyBlock("mossy_granite_cobble_bricks_hopper"))
                .put(GufyUtil.getGufyBlock("granite_cobble_bricks_post"), GufyUtil.getGufyBlock("mossy_granite_cobble_bricks_post"))
                // ANDESITE BRICKS
                .put(GufyUtil.getGufyBlock("andesite_bricks"), GufyUtil.getGufyBlock("mossy_andesite_bricks"))
                .put(GufyUtil.getGufyBlock("andesite_bricks_stairs"), GufyUtil.getGufyBlock("mossy_andesite_bricks_stairs"))
                .put(GufyUtil.getGufyBlock("andesite_bricks_slab"), GufyUtil.getGufyBlock("mossy_andesite_bricks_slab"))
                .put(GufyUtil.getGufyBlock("andesite_bricks_verticalslab"), GufyUtil.getGufyBlock("mossy_andesite_bricks_verticalslab"))
                .put(GufyUtil.getGufyBlock("andesite_bricks_wall"), GufyUtil.getGufyBlock("mossy_andesite_bricks_wall"))
                .put(GufyUtil.getGufyBlock("andesite_bricks_hopper"), GufyUtil.getGufyBlock("mossy_andesite_bricks_hopper"))
                .put(GufyUtil.getGufyBlock("andesite_bricks_post"), GufyUtil.getGufyBlock("mossy_andesite_bricks_post"))
                // COBBLED DEEPSLATE
                .put(Blocks.COBBLED_DEEPSLATE, GufyUtil.getGufyBlock("mossy_cobbled_deepslate"))
                .put(Blocks.COBBLED_DEEPSLATE_STAIRS, GufyUtil.getGufyBlock("mossy_cobbled_deepslate_stairs"))
                .put(Blocks.COBBLED_DEEPSLATE_SLAB, GufyUtil.getGufyBlock("mossy_cobbled_deepslate_slab"))
                .put(Blocks.COBBLED_DEEPSLATE_WALL, GufyUtil.getGufyBlock("mossy_cobbled_deepslate_wall"))
                .put(GufyUtil.getGufyBlock("cobbled_deepslate_verticalslab"), GufyUtil.getGufyBlock("mossy_cobbled_deepslate_verticalslab"))
                .put(GufyUtil.getGufyBlock("cobbled_deepslate_hopper"), GufyUtil.getGufyBlock("mossy_cobbled_deepslate_hopper"))
                .put(GufyUtil.getGufyBlock("cobbled_deepslate_post"), GufyUtil.getGufyBlock("mossy_cobbled_deepslate_post"))
                // DEEPSLATE BRICKS
                .put(Blocks.DEEPSLATE_BRICKS, GufyUtil.getGufyBlock("mossy_deepslate_bricks"))
                .put(Blocks.DEEPSLATE_BRICK_STAIRS, GufyUtil.getGufyBlock("mossy_deepslate_bricks_stairs"))
                .put(Blocks.DEEPSLATE_BRICK_SLAB, GufyUtil.getGufyBlock("mossy_deepslate_bricks_slab"))
                .put(Blocks.DEEPSLATE_BRICK_WALL, GufyUtil.getGufyBlock("mossy_deepslate_bricks_wall"))
                .put(GufyUtil.getGufyBlock("deepslate_bricks_verticalslab"), GufyUtil.getGufyBlock("mossy_deepslate_bricks_verticalslab"))
                .put(GufyUtil.getGufyBlock("deepslate_bricks_hopper"), GufyUtil.getGufyBlock("mossy_deepslate_bricks_hopper"))
                .put(GufyUtil.getGufyBlock("deepslate_bricks_post"), GufyUtil.getGufyBlock("mossy_deepslate_bricks_post"))
                // DEEPSLATE TILES
                .put(Blocks.DEEPSLATE_TILES, GufyUtil.getGufyBlock("mossy_deepslate_tiles"))
                .put(Blocks.DEEPSLATE_TILE_STAIRS, GufyUtil.getGufyBlock("mossy_deepslate_tiles_stairs"))
                .put(Blocks.DEEPSLATE_TILE_SLAB, GufyUtil.getGufyBlock("mossy_deepslate_tiles_slab"))
                .put(Blocks.DEEPSLATE_TILE_WALL, GufyUtil.getGufyBlock("mossy_deepslate_tiles_wall"))
                .put(GufyUtil.getGufyBlock("deepslate_tiles_verticalslab"), GufyUtil.getGufyBlock("mossy_deepslate_tiles_verticalslab"))
                .put(GufyUtil.getGufyBlock("deepslate_tiles_hopper"), GufyUtil.getGufyBlock("mossy_deepslate_tiles_hopper"))
                .put(GufyUtil.getGufyBlock("deepslate_tiles_post"), GufyUtil.getGufyBlock("mossy_deepslate_tiles_post"))
                // SANDSTONE BRICKS
                .put(GufyUtil.getGufyBlock("sandstone_bricks"), GufyUtil.getGufyBlock("mossy_sandstone_bricks"))
                .put(GufyUtil.getGufyBlock("sandstone_bricks_stairs"), GufyUtil.getGufyBlock("mossy_sandstone_bricks_stairs"))
                .put(GufyUtil.getGufyBlock("sandstone_bricks_slab"), GufyUtil.getGufyBlock("mossy_sandstone_bricks_slab"))
                .put(GufyUtil.getGufyBlock("sandstone_bricks_verticalslab"), GufyUtil.getGufyBlock("mossy_sandstone_bricks_verticalslab"))
                .put(GufyUtil.getGufyBlock("sandstone_bricks_wall"), GufyUtil.getGufyBlock("mossy_sandstone_bricks_wall"))
                .put(GufyUtil.getGufyBlock("sandstone_bricks_hopper"), GufyUtil.getGufyBlock("mossy_sandstone_bricks_hopper"))
                .put(GufyUtil.getGufyBlock("sandstone_bricks_post"), GufyUtil.getGufyBlock("mossy_sandstone_bricks_post"))
                // SANDSTONE TILES
                .put(GufyUtil.getGufyBlock("sandstone_cobble_bricks"), GufyUtil.getGufyBlock("mossy_sandstone_cobble_bricks"))
                .put(GufyUtil.getGufyBlock("sandstone_cobble_bricks_stairs"), GufyUtil.getGufyBlock("mossy_sandstone_cobble_bricks_stairs"))
                .put(GufyUtil.getGufyBlock("sandstone_cobble_bricks_slab"), GufyUtil.getGufyBlock("mossy_sandstone_cobble_bricks_slab"))
                .put(GufyUtil.getGufyBlock("sandstone_cobble_bricks_verticalslab"), GufyUtil.getGufyBlock("mossy_sandstone_cobble_bricks_verticalslab"))
                .put(GufyUtil.getGufyBlock("sandstone_cobble_bricks_wall"), GufyUtil.getGufyBlock("mossy_sandstone_cobble_bricks_wall"))
                .put(GufyUtil.getGufyBlock("sandstone_cobble_bricks_hopper"), GufyUtil.getGufyBlock("mossy_sandstone_cobble_bricks_hopper"))
                .put(GufyUtil.getGufyBlock("sandstone_cobble_bricks_post"), GufyUtil.getGufyBlock("mossy_sandstone_cobble_bricks_post"))
                // RED SANDSTONE BRICKS
                .put(GufyUtil.getGufyBlock("red_sandstone_bricks"), GufyUtil.getGufyBlock("mossy_red_sandstone_bricks"))
                .put(GufyUtil.getGufyBlock("red_sandstone_bricks_stairs"), GufyUtil.getGufyBlock("mossy_red_sandstone_bricks_stairs"))
                .put(GufyUtil.getGufyBlock("red_sandstone_bricks_slab"), GufyUtil.getGufyBlock("mossy_red_sandstone_bricks_slab"))
                .put(GufyUtil.getGufyBlock("red_sandstone_bricks_verticalslab"), GufyUtil.getGufyBlock("mossy_red_sandstone_bricks_verticalslab"))
                .put(GufyUtil.getGufyBlock("red_sandstone_bricks_wall"), GufyUtil.getGufyBlock("mossy_red_sandstone_bricks_wall"))
                .put(GufyUtil.getGufyBlock("red_sandstone_bricks_hopper"), GufyUtil.getGufyBlock("mossy_red_sandstone_bricks_hopper"))
                .put(GufyUtil.getGufyBlock("red_sandstone_bricks_post"), GufyUtil.getGufyBlock("mossy_red_sandstone_bricks_post"))
                // RED SANDSTONE TILES
                .put(GufyUtil.getGufyBlock("red_sandstone_cobble_bricks"), GufyUtil.getGufyBlock("mossy_red_sandstone_cobble_bricks"))
                .put(GufyUtil.getGufyBlock("red_sandstone_cobble_bricks_stairs"), GufyUtil.getGufyBlock("mossy_red_sandstone_cobble_bricks_stairs"))
                .put(GufyUtil.getGufyBlock("red_sandstone_cobble_bricks_slab"), GufyUtil.getGufyBlock("mossy_red_sandstone_cobble_bricks_slab"))
                .put(GufyUtil.getGufyBlock("red_sandstone_cobble_bricks_verticalslab"), GufyUtil.getGufyBlock("mossy_red_sandstone_cobble_bricks_verticalslab"))
                .put(GufyUtil.getGufyBlock("red_sandstone_cobble_bricks_wall"), GufyUtil.getGufyBlock("mossy_red_sandstone_cobble_bricks_wall"))
                .put(GufyUtil.getGufyBlock("red_sandstone_cobble_bricks_hopper"), GufyUtil.getGufyBlock("mossy_red_sandstone_cobble_bricks_hopper"))
                .put(GufyUtil.getGufyBlock("red_sandstone_cobble_bricks_post"), GufyUtil.getGufyBlock("mossy_red_sandstone_cobble_bricks_post"))
                // BRICKS
                .put(Blocks.BRICKS, GufyUtil.getGufyBlock("mossy_bricks"))
                .put(Blocks.BRICK_STAIRS, GufyUtil.getGufyBlock("mossy_bricks_stairs"))
                .put(Blocks.BRICK_SLAB, GufyUtil.getGufyBlock("mossy_bricks_slab"))
                .put(Blocks.BRICK_WALL, GufyUtil.getGufyBlock("mossy_bricks_wall"))
                .put(GufyUtil.getGufyBlock("brick_verticalslab"), GufyUtil.getGufyBlock("mossy_bricks_verticalslab"))
                .put(GufyUtil.getGufyBlock("brick_hopper"), GufyUtil.getGufyBlock("mossy_bricks_hopper"))
                .put(GufyUtil.getGufyBlock("brick_post"), GufyUtil.getGufyBlock("mossy_bricks_post"))
                
                .build();
    });
}
