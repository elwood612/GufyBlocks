package com.github.elwood612.gufyblocks.blocks.blockSpecialty;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class GufyVerticalConnectedPane extends IronBarsBlock
{
    private static final IntegerProperty NEIGHBORS_VERTICAL = IntegerProperty.create("neighbors_vertical", 0, 3);
    // 0 = isolated
    // 1 = top (has bottom only)
    // 2 = middle (both)
    // 3 = bottom (has top only)

    public GufyVerticalConnectedPane(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(NORTH, Boolean.FALSE).setValue(EAST, Boolean.FALSE)
                .setValue(SOUTH, Boolean.FALSE).setValue(WEST, Boolean.FALSE).setValue(WATERLOGGED, Boolean.FALSE).setValue(NEIGHBORS_VERTICAL, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{NORTH, EAST, WEST, SOUTH, WATERLOGGED, NEIGHBORS_VERTICAL});
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter blockgetter = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.south();
        BlockPos blockpos3 = blockpos.west();
        BlockPos blockpos4 = blockpos.east();
        BlockState blockstate = blockgetter.getBlockState(blockpos1);
        BlockState blockstate1 = blockgetter.getBlockState(blockpos2);
        BlockState blockstate2 = blockgetter.getBlockState(blockpos3);
        BlockState blockstate3 = blockgetter.getBlockState(blockpos4);
        return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.defaultBlockState()
                .setValue(NORTH, this.attachsTo(blockstate, blockstate.isFaceSturdy(blockgetter, blockpos1, Direction.SOUTH))))
                .setValue(SOUTH, this.attachsTo(blockstate1, blockstate1.isFaceSturdy(blockgetter, blockpos2, Direction.NORTH))))
                .setValue(WEST, this.attachsTo(blockstate2, blockstate2.isFaceSturdy(blockgetter, blockpos3, Direction.EAST))))
                .setValue(EAST, this.attachsTo(blockstate3, blockstate3.isFaceSturdy(blockgetter, blockpos4, Direction.WEST))))
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER)
                .setValue(NEIGHBORS_VERTICAL, computeVertical(context.getLevel(), blockpos));
    }

    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess tickAccess, BlockPos pos, Direction direction,
                                     BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if ((Boolean)state.getValue(WATERLOGGED)) {
            tickAccess.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        if (direction.getAxis().isHorizontal()) {
            return (BlockState)state.setValue((Property)PROPERTY_BY_DIRECTION.get(direction),
                this.attachsTo(neighborState, neighborState.isFaceSturdy(level, neighborPos, direction.getOpposite())));
        } else {
            return (BlockState)state.setValue(NEIGHBORS_VERTICAL, computeVertical(level, pos));
        }
//        return direction.getAxis().isHorizontal() ? (BlockState)state.setValue((Property)PROPERTY_BY_DIRECTION.get(direction),
//                this.attachsTo(neighborState, neighborState.isFaceSturdy(level, neighborPos, direction.getOpposite()))) :
//                super.updateShape(state, level, tickAccess, pos, direction, neighborPos, neighborState, random);
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
