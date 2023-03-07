package elwood612.gufyblocks.blocks.blockUtil;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

public interface GufyFrameable
{
    public static final Supplier<BiMap<Block, Block>> FRAMEABLES_OAK = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(Blocks.WHITE_TERRACOTTA, GufyUtil.getGufyBlock("oak_framed_terracotta").get())
                .put(GufyUtil.getGufyBlock("oak_framed_terracotta").get(), GufyUtil.getGufyBlock("oak_framed_terracotta_left").get())
                .put(GufyUtil.getGufyBlock("oak_framed_terracotta_left").get(), GufyUtil.getGufyBlock("oak_framed_terracotta_right").get())
                .put(GufyUtil.getGufyBlock("oak_framed_terracotta_right").get(), GufyUtil.getGufyBlock("oak_framed_terracotta_cross").get())
                //.put(GufyUtil.getGufyBlock("oak_framed_terracotta_cross").get(), GufyUtil.getGufyBlock("oak_framed_terracotta").get())
                .build();
    });

    public static final Supplier<BiMap<Block, Block>> FRAMEABLES_SPRUCE = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(Blocks.WHITE_TERRACOTTA, GufyUtil.getGufyBlock("spruce_framed_terracotta").get())

                .build();
    });

    public static final Supplier<BiMap<Block, Block>> FRAMEABLES_BIRCH = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(Blocks.WHITE_TERRACOTTA, GufyUtil.getGufyBlock("birch_framed_terracotta").get())

                .build();
    });

    public static final Supplier<BiMap<Block, Block>> FRAMEABLES_DARK_OAK = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(Blocks.WHITE_TERRACOTTA, GufyUtil.getGufyBlock("dark_oak_framed_terracotta").get())

                .build();
    });

    public static final Supplier<BiMap<Block, Block>> FRAMEABLES_JUNGLE = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(Blocks.WHITE_TERRACOTTA, GufyUtil.getGufyBlock("jungle_framed_terracotta").get())

                .build();
    });

    public static final Supplier<BiMap<Block, Block>> FRAMEABLES_ACACIA = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(Blocks.WHITE_TERRACOTTA, GufyUtil.getGufyBlock("acacia_framed_terracotta").get())

                .build();
    });

    public static final Supplier<BiMap<Block, Block>> FRAMEABLES_MANGROVE = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(Blocks.WHITE_TERRACOTTA, GufyUtil.getGufyBlock("mangrove_framed_terracotta").get())

                .build();
    });

    public static final Supplier<BiMap<Block, Block>> FRAMEABLES_CRIMSON = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(Blocks.WHITE_TERRACOTTA, GufyUtil.getGufyBlock("crimson_framed_terracotta").get())

                .build();
    });

    public static final Supplier<BiMap<Block, Block>> FRAMEABLES_WARPED = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(Blocks.WHITE_TERRACOTTA, GufyUtil.getGufyBlock("warped_framed_terracotta").get())

                .build();
    });
}
