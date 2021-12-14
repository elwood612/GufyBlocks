package elwood612.gufyblocks.blocks.blockUtil;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public interface GufyWeathering extends ChangeOverTimeBlock<WeatheringCopper.WeatherState> {
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                //copper
                .put(GufyUtil.getBlock("copper_stairs"), GufyUtil.getBlock("exposed_copper_stairs"))
                .put(GufyUtil.getBlock("exposed_copper_stairs"), GufyUtil.getBlock("weathered_copper_stairs"))
                .put(GufyUtil.getBlock("weathered_copper_stairs"), GufyUtil.getBlock("oxidized_copper_stairs"))
                .put(GufyUtil.getBlock("copper_slab"), GufyUtil.getBlock("exposed_copper_slab"))
                .put(GufyUtil.getBlock("exposed_copper_slab"), GufyUtil.getBlock("weathered_copper_slab"))
                .put(GufyUtil.getBlock("weathered_copper_slab"), GufyUtil.getBlock("oxidized_copper_slab"))
                .put(GufyUtil.getBlock("copper_verticalslab"), GufyUtil.getBlock("exposed_copper_verticalslab"))
                .put(GufyUtil.getBlock("exposed_copper_verticalslab"), GufyUtil.getBlock("weathered_copper_verticalslab"))
                .put(GufyUtil.getBlock("weathered_copper_verticalslab"), GufyUtil.getBlock("oxidized_copper_verticalslab"))
                .put(GufyUtil.getBlock("copper_wall"), GufyUtil.getBlock("exposed_copper_wall"))
                .put(GufyUtil.getBlock("exposed_copper_wall"), GufyUtil.getBlock("weathered_copper_wall"))
                .put(GufyUtil.getBlock("weathered_copper_wall"), GufyUtil.getBlock("oxidized_copper_wall"))
                .put(GufyUtil.getBlock("copper_hopper"), GufyUtil.getBlock("exposed_copper_hopper"))
                .put(GufyUtil.getBlock("exposed_copper_hopper"), GufyUtil.getBlock("weathered_copper_hopper"))
                .put(GufyUtil.getBlock("weathered_copper_hopper"), GufyUtil.getBlock("oxidized_copper_hopper"))
                .put(GufyUtil.getBlock("copper_post"), GufyUtil.getBlock("exposed_copper_post"))
                .put(GufyUtil.getBlock("exposed_copper_post"), GufyUtil.getBlock("weathered_copper_post"))
                .put(GufyUtil.getBlock("weathered_copper_post"), GufyUtil.getBlock("oxidized_copper_post"))
                //cut_copper
                .put(GufyUtil.getBlock("cut_copper_verticalslab"), GufyUtil.getBlock("exposed_cut_copper_verticalslab"))
                .put(GufyUtil.getBlock("exposed_cut_copper_verticalslab"), GufyUtil.getBlock("weathered_cut_copper_verticalslab"))
                .put(GufyUtil.getBlock("weathered_cut_copper_verticalslab"), GufyUtil.getBlock("oxidized_cut_copper_verticalslab"))
                .put(GufyUtil.getBlock("cut_copper_wall"), GufyUtil.getBlock("exposed_cut_copper_wall"))
                .put(GufyUtil.getBlock("exposed_cut_copper_wall"), GufyUtil.getBlock("weathered_cut_copper_wall"))
                .put(GufyUtil.getBlock("weathered_cut_copper_wall"), GufyUtil.getBlock("oxidized_cut_copper_wall"))
                .put(GufyUtil.getBlock("cut_copper_hopper"), GufyUtil.getBlock("exposed_cut_copper_hopper"))
                .put(GufyUtil.getBlock("exposed_cut_copper_hopper"), GufyUtil.getBlock("weathered_cut_copper_hopper"))
                .put(GufyUtil.getBlock("weathered_cut_copper_hopper"), GufyUtil.getBlock("oxidized_cut_copper_hopper"))
                .put(GufyUtil.getBlock("cut_copper_post"), GufyUtil.getBlock("exposed_cut_copper_post"))
                .put(GufyUtil.getBlock("exposed_cut_copper_post"), GufyUtil.getBlock("weathered_cut_copper_post"))
                .put(GufyUtil.getBlock("weathered_cut_copper_post"), GufyUtil.getBlock("oxidized_cut_copper_post"))
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

    public static enum WeatherState {
        UNAFFECTED,
        EXPOSED,
        WEATHERED,
        OXIDIZED
    }
}