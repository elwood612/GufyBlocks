package com.github.elwood612.gufyblocks.blocks.blockUtil;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import java.util.Optional;
import java.util.function.Supplier;

import static com.github.elwood612.gufyblocks.util.GufyUtil.getGufyBlock;

public interface GufyWeathering extends ChangeOverTimeBlock<WeatheringCopper.WeatherState> {
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                //copper
                .put(getGufyBlock("copper_stairs"), getGufyBlock("exposed_copper_stairs"))
                .put(getGufyBlock("exposed_copper_stairs"), getGufyBlock("weathered_copper_stairs"))
                .put(getGufyBlock("weathered_copper_stairs"), getGufyBlock("oxidized_copper_stairs"))
                .put(getGufyBlock("copper_slab"), getGufyBlock("exposed_copper_slab"))
                .put(getGufyBlock("exposed_copper_slab"), getGufyBlock("weathered_copper_slab"))
                .put(getGufyBlock("weathered_copper_slab"), getGufyBlock("oxidized_copper_slab"))
                .put(getGufyBlock("copper_verticalslab"), getGufyBlock("exposed_copper_verticalslab"))
                .put(getGufyBlock("exposed_copper_verticalslab"), getGufyBlock("weathered_copper_verticalslab"))
                .put(getGufyBlock("weathered_copper_verticalslab"), getGufyBlock("oxidized_copper_verticalslab"))
                .put(getGufyBlock("copper_wall"), getGufyBlock("exposed_copper_wall"))
                .put(getGufyBlock("exposed_copper_wall"), getGufyBlock("weathered_copper_wall"))
                .put(getGufyBlock("weathered_copper_wall"), getGufyBlock("oxidized_copper_wall"))
                .put(getGufyBlock("copper_hopper"), getGufyBlock("exposed_copper_hopper"))
                .put(getGufyBlock("exposed_copper_hopper"), getGufyBlock("weathered_copper_hopper"))
                .put(getGufyBlock("weathered_copper_hopper"), getGufyBlock("oxidized_copper_hopper"))
                .put(getGufyBlock("copper_post"), getGufyBlock("exposed_copper_post"))
                .put(getGufyBlock("exposed_copper_post"), getGufyBlock("weathered_copper_post"))
                .put(getGufyBlock("weathered_copper_post"), getGufyBlock("oxidized_copper_post"))
                //cut_copper
                .put(getGufyBlock("cut_copper_verticalslab"), getGufyBlock("exposed_cut_copper_verticalslab"))
                .put(getGufyBlock("exposed_cut_copper_verticalslab"), getGufyBlock("weathered_cut_copper_verticalslab"))
                .put(getGufyBlock("weathered_cut_copper_verticalslab"), getGufyBlock("oxidized_cut_copper_verticalslab"))
                .put(getGufyBlock("cut_copper_wall"), getGufyBlock("exposed_cut_copper_wall"))
                .put(getGufyBlock("exposed_cut_copper_wall"), getGufyBlock("weathered_cut_copper_wall"))
                .put(getGufyBlock("weathered_cut_copper_wall"), getGufyBlock("oxidized_cut_copper_wall"))
                .put(getGufyBlock("cut_copper_hopper"), getGufyBlock("exposed_cut_copper_hopper"))
                .put(getGufyBlock("exposed_cut_copper_hopper"), getGufyBlock("weathered_cut_copper_hopper"))
                .put(getGufyBlock("weathered_cut_copper_hopper"), getGufyBlock("oxidized_cut_copper_hopper"))
                .put(getGufyBlock("cut_copper_post"), getGufyBlock("exposed_cut_copper_post"))
                .put(getGufyBlock("exposed_cut_copper_post"), getGufyBlock("weathered_cut_copper_post"))
                .put(getGufyBlock("weathered_cut_copper_post"), getGufyBlock("oxidized_cut_copper_post"))
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