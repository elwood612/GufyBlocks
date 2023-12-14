package elwood612.gufyblocks.blocks.blockUtil;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

public interface GufyCrackable {
    public static final Supplier<BiMap<Block, Block>> CRACKABLES = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                // STONE BRICKS
                .put(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS)
                .put(Blocks.STONE_BRICK_STAIRS, GufyUtil.getGufyBlock("cracked_stone_bricks_stairs").get())
                .put(Blocks.STONE_BRICK_SLAB, GufyUtil.getGufyBlock("cracked_stone_bricks_slab").get())
                .put(Blocks.STONE_BRICK_WALL, GufyUtil.getGufyBlock("cracked_stone_bricks_wall").get())
                .put(GufyUtil.getGufyBlock("stone_bricks_verticalslab").get(), GufyUtil.getGufyBlock("cracked_stone_bricks_verticalslab").get())
                .put(GufyUtil.getGufyBlock("stone_bricks_hopper").get(), GufyUtil.getGufyBlock("cracked_stone_bricks_hopper").get())
                .put(GufyUtil.getGufyBlock("stone_bricks_post").get(), GufyUtil.getGufyBlock("cracked_stone_bricks_post").get())
                // STONE TILES
                .put(GufyUtil.getGufyBlock("cobblestone_bricks").get(), GufyUtil.getGufyBlock("cracked_cobblestone_bricks").get())
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_stairs").get(), GufyUtil.getGufyBlock("cracked_cobblestone_bricks_stairs").get())
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_slab").get(), GufyUtil.getGufyBlock("cracked_cobblestone_bricks_slab").get())
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_verticalslab").get(), GufyUtil.getGufyBlock("cracked_cobblestone_bricks_verticalslab").get())
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_wall").get(), GufyUtil.getGufyBlock("cracked_cobblestone_bricks_wall").get())
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_hopper").get(), GufyUtil.getGufyBlock("cracked_cobblestone_bricks_hopper").get())
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_post").get(), GufyUtil.getGufyBlock("cracked_cobblestone_bricks_post").get())
                // DIORITE BRICKS
                .put(GufyUtil.getGufyBlock("diorite_bricks").get(), GufyUtil.getGufyBlock("cracked_diorite_bricks").get())
                .put(GufyUtil.getGufyBlock("diorite_bricks_stairs").get(), GufyUtil.getGufyBlock("cracked_diorite_bricks_stairs").get())
                .put(GufyUtil.getGufyBlock("diorite_bricks_slab").get(), GufyUtil.getGufyBlock("cracked_diorite_bricks_slab").get())
                .put(GufyUtil.getGufyBlock("diorite_bricks_verticalslab").get(), GufyUtil.getGufyBlock("cracked_diorite_bricks_verticalslab").get())
                .put(GufyUtil.getGufyBlock("diorite_bricks_wall").get(), GufyUtil.getGufyBlock("cracked_diorite_bricks_wall").get())
                .put(GufyUtil.getGufyBlock("diorite_bricks_hopper").get(), GufyUtil.getGufyBlock("cracked_diorite_bricks_hopper").get())
                .put(GufyUtil.getGufyBlock("diorite_bricks_post").get(), GufyUtil.getGufyBlock("cracked_diorite_bricks_post").get())
                // DIORITE TILES
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks").get(), GufyUtil.getGufyBlock("cracked_diorite_cobble_bricks").get())
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_stairs").get(), GufyUtil.getGufyBlock("cracked_diorite_cobble_bricks_stairs").get())
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_slab").get(), GufyUtil.getGufyBlock("cracked_diorite_cobble_bricks_slab").get())
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_verticalslab").get(), GufyUtil.getGufyBlock("cracked_diorite_cobble_bricks_verticalslab").get())
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_wall").get(), GufyUtil.getGufyBlock("cracked_diorite_cobble_bricks_wall").get())
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_hopper").get(), GufyUtil.getGufyBlock("cracked_diorite_cobble_bricks_hopper").get())
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_post").get(), GufyUtil.getGufyBlock("cracked_diorite_cobble_bricks_post").get())
                // GRANITE BRICKS
                // GRANITE TILES
                // ANDESITE BRICKS
                // NETHER BRICKS
                .put(Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS)
                // DEEPSLATE BRICKS
                .put(Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS)
                .put(Blocks.DEEPSLATE_BRICK_STAIRS, GufyUtil.getGufyBlock("cracked_deepslate_bricks_stairs").get())
                .put(Blocks.DEEPSLATE_BRICK_SLAB, GufyUtil.getGufyBlock("cracked_deepslate_bricks_slab").get())
                .put(Blocks.DEEPSLATE_BRICK_WALL, GufyUtil.getGufyBlock("cracked_deepslate_bricks_wall").get())
                .put(GufyUtil.getGufyBlock("deepslate_bricks_verticalslab").get(), GufyUtil.getGufyBlock("cracked_deepslate_bricks_verticalslab").get())
                .put(GufyUtil.getGufyBlock("deepslate_bricks_hopper").get(), GufyUtil.getGufyBlock("cracked_deepslate_bricks_hopper").get())
                .put(GufyUtil.getGufyBlock("deepslate_bricks_post").get(), GufyUtil.getGufyBlock("cracked_deepslate_bricks_post").get())
                // DEEPSLATE TILES
                .put(Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES)
                .put(Blocks.DEEPSLATE_TILE_STAIRS, GufyUtil.getGufyBlock("cracked_deepslate_tiles_stairs").get())
                .put(Blocks.DEEPSLATE_TILE_SLAB, GufyUtil.getGufyBlock("cracked_deepslate_tiles_slab").get())
                .put(Blocks.DEEPSLATE_TILE_WALL, GufyUtil.getGufyBlock("cracked_deepslate_tiles_wall").get())
                .put(GufyUtil.getGufyBlock("deepslate_tiles_verticalslab").get(), GufyUtil.getGufyBlock("cracked_deepslate_tiles_verticalslab").get())
                .put(GufyUtil.getGufyBlock("deepslate_tiles_hopper").get(), GufyUtil.getGufyBlock("cracked_deepslate_tiles_hopper").get())
                .put(GufyUtil.getGufyBlock("deepslate_tiles_post").get(), GufyUtil.getGufyBlock("cracked_deepslate_tiles_post").get())
                // POLISHED BLACKSTONE BRICKS
                .put(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)
                .put(Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS, GufyUtil.getGufyBlock("cracked_polished_blackstone_brick_stairs").get())
                .put(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB, GufyUtil.getGufyBlock("cracked_polished_blackstone_brick_slab").get())
                .put(Blocks.POLISHED_BLACKSTONE_BRICK_WALL, GufyUtil.getGufyBlock("cracked_polished_blackstone_brick_wall").get())
                .put(GufyUtil.getGufyBlock("polished_blackstone_brick_verticalslab").get(), GufyUtil.getGufyBlock("cracked_polished_blackstone_brick_verticalslab").get())
                .put(GufyUtil.getGufyBlock("polished_blackstone_brick_hopper").get(), GufyUtil.getGufyBlock("cracked_polished_blackstone_brick_hopper").get())
                .put(GufyUtil.getGufyBlock("polished_blackstone_brick_post").get(), GufyUtil.getGufyBlock("cracked_polished_blackstone_brick_post").get())
                // SANDSTONE BRICKS
                // SANDSTONE TILES
                // FRAMED
                .put(GufyUtil.getGufyBlock("oak_framed_terracotta").get(), GufyUtil.getGufyBlock("oak_framed_terracotta_left").get())
                .put(GufyUtil.getGufyBlock("oak_framed_terracotta_left").get(), GufyUtil.getGufyBlock("oak_framed_terracotta_right").get())
                .put(GufyUtil.getGufyBlock("oak_framed_terracotta_right").get(), GufyUtil.getGufyBlock("oak_framed_terracotta_cross").get())
                .put(GufyUtil.getGufyBlock("oak_framed_terracotta_cross").get(), GufyUtil.getGufyBlock("oak_framed_terracotta").get())
                .put(GufyUtil.getGufyBlock("spruce_framed_terracotta").get(), GufyUtil.getGufyBlock("spruce_framed_terracotta_left").get())
                .put(GufyUtil.getGufyBlock("spruce_framed_terracotta_left").get(), GufyUtil.getGufyBlock("spruce_framed_terracotta_right").get())
                .put(GufyUtil.getGufyBlock("spruce_framed_terracotta_right").get(), GufyUtil.getGufyBlock("spruce_framed_terracotta_cross").get())
                .put(GufyUtil.getGufyBlock("spruce_framed_terracotta_cross").get(), GufyUtil.getGufyBlock("spruce_framed_terracotta").get())
                .put(GufyUtil.getGufyBlock("birch_framed_terracotta").get(), GufyUtil.getGufyBlock("birch_framed_terracotta_left").get())
                .put(GufyUtil.getGufyBlock("birch_framed_terracotta_left").get(), GufyUtil.getGufyBlock("birch_framed_terracotta_right").get())
                .put(GufyUtil.getGufyBlock("birch_framed_terracotta_right").get(), GufyUtil.getGufyBlock("birch_framed_terracotta_cross").get())
                .put(GufyUtil.getGufyBlock("birch_framed_terracotta_cross").get(), GufyUtil.getGufyBlock("birch_framed_terracotta").get())
                .put(GufyUtil.getGufyBlock("dark_oak_framed_terracotta").get(), GufyUtil.getGufyBlock("dark_oak_framed_terracotta_left").get())
                .put(GufyUtil.getGufyBlock("dark_oak_framed_terracotta_left").get(), GufyUtil.getGufyBlock("dark_oak_framed_terracotta_right").get())
                .put(GufyUtil.getGufyBlock("dark_oak_framed_terracotta_right").get(), GufyUtil.getGufyBlock("dark_oak_framed_terracotta_cross").get())
                .put(GufyUtil.getGufyBlock("dark_oak_framed_terracotta_cross").get(), GufyUtil.getGufyBlock("dark_oak_framed_terracotta").get())
                .put(GufyUtil.getGufyBlock("jungle_framed_terracotta").get(), GufyUtil.getGufyBlock("jungle_framed_terracotta_left").get())
                .put(GufyUtil.getGufyBlock("jungle_framed_terracotta_left").get(), GufyUtil.getGufyBlock("jungle_framed_terracotta_right").get())
                .put(GufyUtil.getGufyBlock("jungle_framed_terracotta_right").get(), GufyUtil.getGufyBlock("jungle_framed_terracotta_cross").get())
                .put(GufyUtil.getGufyBlock("jungle_framed_terracotta_cross").get(), GufyUtil.getGufyBlock("jungle_framed_terracotta").get())
                .put(GufyUtil.getGufyBlock("acacia_framed_terracotta").get(), GufyUtil.getGufyBlock("acacia_framed_terracotta_left").get())
                .put(GufyUtil.getGufyBlock("acacia_framed_terracotta_left").get(), GufyUtil.getGufyBlock("acacia_framed_terracotta_right").get())
                .put(GufyUtil.getGufyBlock("acacia_framed_terracotta_right").get(), GufyUtil.getGufyBlock("acacia_framed_terracotta_cross").get())
                .put(GufyUtil.getGufyBlock("acacia_framed_terracotta_cross").get(), GufyUtil.getGufyBlock("acacia_framed_terracotta").get())
                .put(GufyUtil.getGufyBlock("crimson_framed_terracotta").get(), GufyUtil.getGufyBlock("crimson_framed_terracotta_left").get())
                .put(GufyUtil.getGufyBlock("crimson_framed_terracotta_left").get(), GufyUtil.getGufyBlock("crimson_framed_terracotta_right").get())
                .put(GufyUtil.getGufyBlock("crimson_framed_terracotta_right").get(), GufyUtil.getGufyBlock("crimson_framed_terracotta_cross").get())
                .put(GufyUtil.getGufyBlock("crimson_framed_terracotta_cross").get(), GufyUtil.getGufyBlock("crimson_framed_terracotta").get())
                .put(GufyUtil.getGufyBlock("warped_framed_terracotta").get(), GufyUtil.getGufyBlock("warped_framed_terracotta_left").get())
                .put(GufyUtil.getGufyBlock("warped_framed_terracotta_left").get(), GufyUtil.getGufyBlock("warped_framed_terracotta_right").get())
                .put(GufyUtil.getGufyBlock("warped_framed_terracotta_right").get(), GufyUtil.getGufyBlock("warped_framed_terracotta_cross").get())
                .put(GufyUtil.getGufyBlock("warped_framed_terracotta_cross").get(), GufyUtil.getGufyBlock("warped_framed_terracotta").get())
                .put(GufyUtil.getGufyBlock("mangrove_framed_terracotta").get(), GufyUtil.getGufyBlock("mangrove_framed_terracotta_left").get())
                .put(GufyUtil.getGufyBlock("mangrove_framed_terracotta_left").get(), GufyUtil.getGufyBlock("mangrove_framed_terracotta_right").get())
                .put(GufyUtil.getGufyBlock("mangrove_framed_terracotta_right").get(), GufyUtil.getGufyBlock("mangrove_framed_terracotta_cross").get())
                .put(GufyUtil.getGufyBlock("mangrove_framed_terracotta_cross").get(), GufyUtil.getGufyBlock("mangrove_framed_terracotta").get())
                .put(GufyUtil.getGufyBlock("cherry_framed_terracotta").get(), GufyUtil.getGufyBlock("cherry_framed_terracotta_left").get())
                .put(GufyUtil.getGufyBlock("cherry_framed_terracotta_left").get(), GufyUtil.getGufyBlock("cherry_framed_terracotta_right").get())
                .put(GufyUtil.getGufyBlock("cherry_framed_terracotta_right").get(), GufyUtil.getGufyBlock("cherry_framed_terracotta_cross").get())
                .put(GufyUtil.getGufyBlock("cherry_framed_terracotta_cross").get(), GufyUtil.getGufyBlock("cherry_framed_terracotta").get())
                .put(GufyUtil.getGufyBlock("bamboo_framed_terracotta").get(), GufyUtil.getGufyBlock("bamboo_framed_terracotta_left").get())
                .put(GufyUtil.getGufyBlock("bamboo_framed_terracotta_left").get(), GufyUtil.getGufyBlock("bamboo_framed_terracotta_right").get())
                .put(GufyUtil.getGufyBlock("bamboo_framed_terracotta_right").get(), GufyUtil.getGufyBlock("bamboo_framed_terracotta_cross").get())
                .put(GufyUtil.getGufyBlock("bamboo_framed_terracotta_cross").get(), GufyUtil.getGufyBlock("bamboo_framed_terracotta").get())
                .put(GufyUtil.getGufyBlock("mushroom_framed_terracotta").get(), GufyUtil.getGufyBlock("mushroom_framed_terracotta_left").get())
                .put(GufyUtil.getGufyBlock("mushroom_framed_terracotta_left").get(), GufyUtil.getGufyBlock("mushroom_framed_terracotta_right").get())
                .put(GufyUtil.getGufyBlock("mushroom_framed_terracotta_right").get(), GufyUtil.getGufyBlock("mushroom_framed_terracotta_cross").get())
                .put(GufyUtil.getGufyBlock("mushroom_framed_terracotta_cross").get(), GufyUtil.getGufyBlock("mushroom_framed_terracotta").get())
                 // FRAMED MUD
                // CARVED LOGS
                .put(Blocks.STRIPPED_ACACIA_WOOD, GufyUtil.getGufyBlock("chiseled_stripped_acacia_wood").get())
                .put(Blocks.STRIPPED_BIRCH_WOOD, GufyUtil.getGufyBlock("chiseled_stripped_birch_wood").get())
                .put(Blocks.STRIPPED_BAMBOO_BLOCK, GufyUtil.getGufyBlock("chiseled_stripped_bamboo_block").get())
                .put(Blocks.STRIPPED_CRIMSON_HYPHAE, GufyUtil.getGufyBlock("chiseled_stripped_crimson_hyphae").get())
                .put(Blocks.STRIPPED_DARK_OAK_WOOD, GufyUtil.getGufyBlock("chiseled_stripped_dark_oak_wood").get())
                .put(Blocks.STRIPPED_JUNGLE_WOOD, GufyUtil.getGufyBlock("chiseled_stripped_jungle_wood").get())
                .put(Blocks.STRIPPED_OAK_WOOD, GufyUtil.getGufyBlock("chiseled_stripped_oak_wood").get())
                .put(Blocks.STRIPPED_MANGROVE_WOOD, GufyUtil.getGufyBlock("chiseled_stripped_mangrove_wood").get())
                .put(Blocks.STRIPPED_CHERRY_WOOD, GufyUtil.getGufyBlock("chiseled_stripped_cherry_wood").get())
                .put(Blocks.STRIPPED_SPRUCE_WOOD, GufyUtil.getGufyBlock("chiseled_stripped_spruce_wood").get())
                .put(Blocks.STRIPPED_WARPED_HYPHAE, GufyUtil.getGufyBlock("chiseled_stripped_warped_hyphae").get())
                .build();
    });
}
