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

                .build();
    });
}
