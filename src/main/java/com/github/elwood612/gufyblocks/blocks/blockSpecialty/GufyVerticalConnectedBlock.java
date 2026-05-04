package com.github.elwood612.gufyblocks.blocks.blockSpecialty;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

public class GufyVerticalConnectedBlock extends Block
{
    private static final IntegerProperty NEIGHBORS_VERTICAL = IntegerProperty.create("neighbors_vertical", 0, 3);
        // 0 = isolated
        // 1 = top (has bottom only)
        // 2 = middle (both)
        // 3 = bottom (has top only)

    public GufyVerticalConnectedBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(NEIGHBORS_VERTICAL, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NEIGHBORS_VERTICAL);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(NEIGHBORS_VERTICAL, computeVertical(context.getLevel(), context.getClickedPos()));
    }

    @NotNull
    @Override
    protected BlockState updateShape(BlockState state, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction,
                                     BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (direction.getAxis() == Direction.UP.getAxis()) {
            return state.setValue(NEIGHBORS_VERTICAL, computeVertical(levelReader, pos));
        }
        return state;
    }

    private int computeVertical(LevelReader level, BlockPos pos) {
        boolean up = level.getBlockState(pos.above()).is(this);
        boolean down = level.getBlockState(pos.below()).is(this);

        if (up) {
            if (down) return 2;     // if up && down
            else return 3;          // if up && !down
        } else {
            if (down) return 1;     // if !up && down
            else return 0;          // if !up && !down
        }
    }
}
