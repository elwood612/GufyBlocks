package elwood612.gufyblocks.blocks.blockUtil;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Supplier;

public interface GufyWeathering extends ChangeOverTimeBlock<WeatheringCopper.WeatherState> {
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                //copper
                .put(GufyUtil.getGufyBlock("copper_stairs").get(), GufyUtil.getGufyBlock("exposed_copper_stairs").get())
                .put(GufyUtil.getGufyBlock("exposed_copper_stairs").get(), GufyUtil.getGufyBlock("weathered_copper_stairs").get())
                .put(GufyUtil.getGufyBlock("weathered_copper_stairs").get(), GufyUtil.getGufyBlock("oxidized_copper_stairs").get())
                .put(GufyUtil.getGufyBlock("copper_slab").get(), GufyUtil.getGufyBlock("exposed_copper_slab").get())
                .put(GufyUtil.getGufyBlock("exposed_copper_slab").get(), GufyUtil.getGufyBlock("weathered_copper_slab").get())
                .put(GufyUtil.getGufyBlock("weathered_copper_slab").get(), GufyUtil.getGufyBlock("oxidized_copper_slab").get())
                .put(GufyUtil.getGufyBlock("copper_verticalslab").get(), GufyUtil.getGufyBlock("exposed_copper_verticalslab").get())
                .put(GufyUtil.getGufyBlock("exposed_copper_verticalslab").get(), GufyUtil.getGufyBlock("weathered_copper_verticalslab").get())
                .put(GufyUtil.getGufyBlock("weathered_copper_verticalslab").get(), GufyUtil.getGufyBlock("oxidized_copper_verticalslab").get())
                .put(GufyUtil.getGufyBlock("copper_wall").get(), GufyUtil.getGufyBlock("exposed_copper_wall").get())
                .put(GufyUtil.getGufyBlock("exposed_copper_wall").get(), GufyUtil.getGufyBlock("weathered_copper_wall").get())
                .put(GufyUtil.getGufyBlock("weathered_copper_wall").get(), GufyUtil.getGufyBlock("oxidized_copper_wall").get())
                .put(GufyUtil.getGufyBlock("copper_hopper").get(), GufyUtil.getGufyBlock("exposed_copper_hopper").get())
                .put(GufyUtil.getGufyBlock("exposed_copper_hopper").get(), GufyUtil.getGufyBlock("weathered_copper_hopper").get())
                .put(GufyUtil.getGufyBlock("weathered_copper_hopper").get(), GufyUtil.getGufyBlock("oxidized_copper_hopper").get())
                .put(GufyUtil.getGufyBlock("copper_post").get(), GufyUtil.getGufyBlock("exposed_copper_post").get())
                .put(GufyUtil.getGufyBlock("exposed_copper_post").get(), GufyUtil.getGufyBlock("weathered_copper_post").get())
                .put(GufyUtil.getGufyBlock("weathered_copper_post").get(), GufyUtil.getGufyBlock("oxidized_copper_post").get())
                //cut_copper
                .put(GufyUtil.getGufyBlock("cut_copper_verticalslab").get(), GufyUtil.getGufyBlock("exposed_cut_copper_verticalslab").get())
                .put(GufyUtil.getGufyBlock("exposed_cut_copper_verticalslab").get(), GufyUtil.getGufyBlock("weathered_cut_copper_verticalslab").get())
                .put(GufyUtil.getGufyBlock("weathered_cut_copper_verticalslab").get(), GufyUtil.getGufyBlock("oxidized_cut_copper_verticalslab").get())
                .put(GufyUtil.getGufyBlock("cut_copper_wall").get(), GufyUtil.getGufyBlock("exposed_cut_copper_wall").get())
                .put(GufyUtil.getGufyBlock("exposed_cut_copper_wall").get(), GufyUtil.getGufyBlock("weathered_cut_copper_wall").get())
                .put(GufyUtil.getGufyBlock("weathered_cut_copper_wall").get(), GufyUtil.getGufyBlock("oxidized_cut_copper_wall").get())
                .put(GufyUtil.getGufyBlock("cut_copper_hopper").get(), GufyUtil.getGufyBlock("exposed_cut_copper_hopper").get())
                .put(GufyUtil.getGufyBlock("exposed_cut_copper_hopper").get(), GufyUtil.getGufyBlock("weathered_cut_copper_hopper").get())
                .put(GufyUtil.getGufyBlock("weathered_cut_copper_hopper").get(), GufyUtil.getGufyBlock("oxidized_cut_copper_hopper").get())
                .put(GufyUtil.getGufyBlock("cut_copper_post").get(), GufyUtil.getGufyBlock("exposed_cut_copper_post").get())
                .put(GufyUtil.getGufyBlock("exposed_cut_copper_post").get(), GufyUtil.getGufyBlock("weathered_cut_copper_post").get())
                .put(GufyUtil.getGufyBlock("weathered_cut_copper_post").get(), GufyUtil.getGufyBlock("oxidized_cut_copper_post").get())
                .build();
    });
    Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> {
        return NEXT_BY_BLOCK.get().inverse();
    });

    static Optional<Block> getPrevious(Block p_154891_) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(p_154891_));
    }

    static Block getFirst(Block p_154898_) {
        Block block = p_154898_;

        for(Block block1 = PREVIOUS_BY_BLOCK.get().get(p_154898_); block1 != null; block1 = PREVIOUS_BY_BLOCK.get().get(block1)) {
            block = block1;
        }

        return block;
    }



    static Optional<BlockState> getPrevious(BlockState p_154900_) {
        return getPrevious(p_154900_.getBlock()).map((p_154903_) -> {
            return p_154903_.withPropertiesOf(p_154900_);
        });
    }

    static Optional<Block> getNext(Block p_154905_) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(p_154905_));
    }

    static BlockState getFirst(BlockState p_154907_) {
        return getFirst(p_154907_.getBlock()).withPropertiesOf(p_154907_);
    }

    default Optional<BlockState> getNext(BlockState p_154893_) {
        return getNext(p_154893_.getBlock()).map((p_154896_) -> {
            return p_154896_.withPropertiesOf(p_154893_);
        });
    }

    default float getChanceModifier() {
        return this.getAge() == net.minecraft.world.level.block.WeatheringCopper.WeatherState.UNAFFECTED ? 0.75F : 1.0F;
    }

    //@Nullable
    //BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate);

    public static enum WeatherState {
        UNAFFECTED,
        EXPOSED,
        WEATHERED,
        OXIDIZED
    }
}