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

                .build();
    });
}
