package elwood612.gufyblocks.blocks.blockUtil;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import elwood612.gufyblocks.util.GufyUtil;
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
                .put(GufyUtil.getGufyBlock("stone_bricks_verticalslab").get(), GufyUtil.getGufyBlock("mossy_stone_bricks_verticalslab").get())
                .put(GufyUtil.getGufyBlock("stone_bricks_hopper").get(), GufyUtil.getGufyBlock("mossy_stone_bricks_hopper").get())
                .put(GufyUtil.getGufyBlock("stone_bricks_post").get(), GufyUtil.getGufyBlock("mossy_stone_bricks_post").get())
                // COBBLESTONE
                .put(Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE)
                .put(Blocks.COBBLESTONE_STAIRS, Blocks.MOSSY_COBBLESTONE_STAIRS)
                .put(Blocks.COBBLESTONE_SLAB, Blocks.MOSSY_COBBLESTONE_SLAB)
                .put(Blocks.COBBLESTONE_WALL, Blocks.MOSSY_COBBLESTONE_WALL)
                .put(GufyUtil.getGufyBlock("cobblestone_verticalslab").get(), GufyUtil.getGufyBlock("mossy_cobblestone_verticalslab").get())
                .put(GufyUtil.getGufyBlock("cobblestone_hopper").get(), GufyUtil.getGufyBlock("mossy_cobblestone_hopper").get())
                .put(GufyUtil.getGufyBlock("cobblestone_post").get(), GufyUtil.getGufyBlock("mossy_cobblestone_post").get())
                // STONE TILES
                .put(GufyUtil.getGufyBlock("cobblestone_bricks").get(), GufyUtil.getGufyBlock("mossy_cobblestone_bricks").get())
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_stairs").get(), GufyUtil.getGufyBlock("mossy_cobblestone_bricks_stairs").get())
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_slab").get(), GufyUtil.getGufyBlock("mossy_cobblestone_bricks_slab").get())
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_verticalslab").get(), GufyUtil.getGufyBlock("mossy_cobblestone_bricks_verticalslab").get())
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_wall").get(), GufyUtil.getGufyBlock("mossy_cobblestone_bricks_wall").get())
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_hopper").get(), GufyUtil.getGufyBlock("mossy_cobblestone_bricks_hopper").get())
                .put(GufyUtil.getGufyBlock("cobblestone_bricks_post").get(), GufyUtil.getGufyBlock("mossy_cobblestone_bricks_post").get())
                // DIORITE BRICKS
                .put(GufyUtil.getGufyBlock("diorite_bricks").get(), GufyUtil.getGufyBlock("mossy_diorite_bricks").get())
                .put(GufyUtil.getGufyBlock("diorite_bricks_stairs").get(), GufyUtil.getGufyBlock("mossy_diorite_bricks_stairs").get())
                .put(GufyUtil.getGufyBlock("diorite_bricks_slab").get(), GufyUtil.getGufyBlock("mossy_diorite_bricks_slab").get())
                .put(GufyUtil.getGufyBlock("diorite_bricks_verticalslab").get(), GufyUtil.getGufyBlock("mossy_diorite_bricks_verticalslab").get())
                .put(GufyUtil.getGufyBlock("diorite_bricks_wall").get(), GufyUtil.getGufyBlock("mossy_diorite_bricks_wall").get())
                .put(GufyUtil.getGufyBlock("diorite_bricks_hopper").get(), GufyUtil.getGufyBlock("mossy_diorite_bricks_hopper").get())
                .put(GufyUtil.getGufyBlock("diorite_bricks_post").get(), GufyUtil.getGufyBlock("mossy_diorite_bricks_post").get())
                // DIORITE TILES
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks").get(), GufyUtil.getGufyBlock("mossy_diorite_cobble_bricks").get())
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_stairs").get(), GufyUtil.getGufyBlock("mossy_diorite_cobble_bricks_stairs").get())
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_slab").get(), GufyUtil.getGufyBlock("mossy_diorite_cobble_bricks_slab").get())
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_verticalslab").get(), GufyUtil.getGufyBlock("mossy_diorite_cobble_bricks_verticalslab").get())
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_wall").get(), GufyUtil.getGufyBlock("mossy_diorite_cobble_bricks_wall").get())
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_hopper").get(), GufyUtil.getGufyBlock("mossy_diorite_cobble_bricks_hopper").get())
                .put(GufyUtil.getGufyBlock("diorite_cobble_bricks_post").get(), GufyUtil.getGufyBlock("mossy_diorite_cobble_bricks_post").get())
                // GRANITE BRICKS
                // GRANITE TILES
                // ANDESITE BRICKS
                // DEEPSLATE BRICKS
                // DEEPSLATE TILES
                // POLISHED BLACKSTONE BRICKS
                // SANDSTONE BRICKS
                // SANDSTONE TILES
                .build();
    });
}
