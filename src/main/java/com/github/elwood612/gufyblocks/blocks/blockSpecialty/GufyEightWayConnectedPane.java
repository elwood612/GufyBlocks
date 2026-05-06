package com.github.elwood612.gufyblocks.blocks.blockSpecialty;

import com.github.elwood612.gufyblocks.util.GufyEightWayPosition;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import joptsimple.util.KeyValuePair;
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

import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GufyEightWayConnectedPane extends IronBarsBlock {
    // 0 = isolated
    // 1 = top (has bottom only)
    // 2 = middle (both)
    // 3 = bottom (has top only)
    private static final IntegerProperty NORTH_UP_POSITION = IntegerProperty.create("north_up_position", 0, 4);
    private static final IntegerProperty NORTH_DOWN_POSITION = IntegerProperty.create("north_down_position", 0, 4);
    private static final IntegerProperty SOUTH_UP_POSITION = IntegerProperty.create("south_up_position", 0, 4);
    private static final IntegerProperty SOUTH_DOWN_POSITION = IntegerProperty.create("south_down_position", 0, 4);
    private static final IntegerProperty WEST_UP_POSITION = IntegerProperty.create("west_up_position", 0, 4);
    private static final IntegerProperty WEST_DOWN_POSITION = IntegerProperty.create("west_down_position", 0, 4);
    private static final IntegerProperty EAST_UP_POSITION = IntegerProperty.create("east_up_position", 0, 4);
    private static final IntegerProperty EAST_DOWN_POSITION = IntegerProperty.create("east_down_position", 0, 4);
    private static final IntegerProperty NORTH_EXPOSED = IntegerProperty.create("north_exposed", 0, 3);
    private static final IntegerProperty SOUTH_EXPOSED = IntegerProperty.create("south_exposed", 0, 3);
    private static final IntegerProperty WEST_EXPOSED = IntegerProperty.create("west_exposed", 0, 3);
    private static final IntegerProperty EAST_EXPOSED = IntegerProperty.create("east_exposed", 0, 3);
    private static final Map<GufyEightWayPosition, Direction[]> PROPERTY_BY_POSITION =
            ImmutableMap.copyOf(Maps.newEnumMap(Map.of(
                    GufyEightWayPosition.NORTH_UP, new Direction[] {Direction.NORTH, Direction.UP},
                    GufyEightWayPosition.NORTH_DOWN, new Direction[]{Direction.NORTH, Direction.DOWN},
                    GufyEightWayPosition.SOUTH_UP, new Direction[]{Direction.SOUTH, Direction.UP},
                    GufyEightWayPosition.SOUTH_DOWN, new Direction[]{Direction.SOUTH, Direction.DOWN},
                    GufyEightWayPosition.WEST_UP, new Direction[]{Direction.WEST, Direction.UP},
                    GufyEightWayPosition.WEST_DOWN, new Direction[]{Direction.WEST, Direction.DOWN},
                    GufyEightWayPosition.EAST_UP, new Direction[]{Direction.EAST, Direction.UP},
                    GufyEightWayPosition.EAST_DOWN, new Direction[]{Direction.EAST, Direction.DOWN}
                    )));

    public GufyEightWayConnectedPane(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState()
                .setValue(NORTH, Boolean.FALSE)
                .setValue(EAST, Boolean.FALSE)
                .setValue(SOUTH, Boolean.FALSE)
                .setValue(WEST, Boolean.FALSE)
                .setValue(WATERLOGGED, Boolean.FALSE)
                .setValue(NORTH_UP_POSITION, 0)
                .setValue(NORTH_DOWN_POSITION, 0)
                .setValue(SOUTH_UP_POSITION, 0)
                .setValue(SOUTH_DOWN_POSITION, 0)
                .setValue(WEST_UP_POSITION, 0)
                .setValue(WEST_DOWN_POSITION, 0)
                .setValue(EAST_UP_POSITION, 0)
                .setValue(EAST_DOWN_POSITION, 0)
                .setValue(NORTH_EXPOSED, 0)
                .setValue(SOUTH_EXPOSED, 0)
                .setValue(WEST_EXPOSED, 0)
                .setValue(EAST_EXPOSED, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{NORTH, EAST, WEST, SOUTH, WATERLOGGED, 
                NORTH_UP_POSITION, NORTH_DOWN_POSITION, SOUTH_UP_POSITION, SOUTH_DOWN_POSITION,
                WEST_UP_POSITION, WEST_DOWN_POSITION, EAST_UP_POSITION, EAST_DOWN_POSITION,
                NORTH_EXPOSED, SOUTH_EXPOSED, WEST_EXPOSED, EAST_EXPOSED});
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
                .setValue(NORTH_UP_POSITION, computePosition(GufyEightWayPosition.NORTH_UP, context.getLevel(), blockpos))
                .setValue(NORTH_DOWN_POSITION, computePosition(GufyEightWayPosition.NORTH_DOWN, context.getLevel(), blockpos))
                .setValue(SOUTH_UP_POSITION, computePosition(GufyEightWayPosition.SOUTH_UP, context.getLevel(), blockpos))
                .setValue(SOUTH_DOWN_POSITION, computePosition(GufyEightWayPosition.SOUTH_DOWN, context.getLevel(), blockpos))
                .setValue(WEST_UP_POSITION, computePosition(GufyEightWayPosition.WEST_UP, context.getLevel(), blockpos))
                .setValue(WEST_DOWN_POSITION, computePosition(GufyEightWayPosition.WEST_DOWN, context.getLevel(), blockpos))
                .setValue(EAST_UP_POSITION, computePosition(GufyEightWayPosition.EAST_UP, context.getLevel(), blockpos))
                .setValue(EAST_DOWN_POSITION, computePosition(GufyEightWayPosition.EAST_DOWN, context.getLevel(), blockpos))
                .setValue(NORTH_EXPOSED, checkDirectionExposed(Direction.NORTH, context.getLevel(), blockpos))
                .setValue(SOUTH_EXPOSED, checkDirectionExposed(Direction.SOUTH, context.getLevel(), blockpos))
                .setValue(WEST_EXPOSED, checkDirectionExposed(Direction.WEST, context.getLevel(), blockpos))
                .setValue(EAST_EXPOSED, checkDirectionExposed(Direction.EAST, context.getLevel(), blockpos));
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
            return (BlockState)state
                    .setValue(NORTH_UP_POSITION, computePosition(GufyEightWayPosition.NORTH_UP, level, pos))
                    .setValue(NORTH_DOWN_POSITION, computePosition(GufyEightWayPosition.NORTH_DOWN, level, pos))
                    .setValue(SOUTH_UP_POSITION, computePosition(GufyEightWayPosition.SOUTH_UP, level, pos))
                    .setValue(SOUTH_DOWN_POSITION, computePosition(GufyEightWayPosition.SOUTH_DOWN, level, pos))
                    .setValue(WEST_UP_POSITION, computePosition(GufyEightWayPosition.WEST_UP, level, pos))
                    .setValue(WEST_DOWN_POSITION, computePosition(GufyEightWayPosition.WEST_DOWN, level, pos))
                    .setValue(EAST_UP_POSITION, computePosition(GufyEightWayPosition.EAST_UP, level, pos))
                    .setValue(EAST_DOWN_POSITION, computePosition(GufyEightWayPosition.EAST_DOWN, level, pos))
                    .setValue(NORTH_EXPOSED, checkDirectionExposed(Direction.NORTH, level, pos))
                    .setValue(SOUTH_EXPOSED, checkDirectionExposed(Direction.SOUTH, level, pos))
                    .setValue(WEST_EXPOSED, checkDirectionExposed(Direction.WEST, level, pos))
                    .setValue(EAST_EXPOSED, checkDirectionExposed(Direction.EAST, level, pos));
        }
    }

    private int computePosition(GufyEightWayPosition position, LevelReader level, BlockPos pos) {
        boolean horizontal = false;
        boolean vertical = false;
        boolean diagonal = false;
        for (Direction direction : PROPERTY_BY_POSITION.get(position)) { // there's gotta be an easier way to do this...
            horizontal = (direction.getAxis() == Direction.Axis.X) || (direction.getAxis() == Direction.Axis.Z) &&
                    level.getBlockState(pos.relative(direction)).is(this);
            vertical = direction.getAxis() == Direction.Axis.Y &&
                    level.getBlockState(pos.relative(direction)).is(this);
//            diagonal = level.getBlockState(pos.)
        }
        return 0;
    }

    private int checkDirectionExposed(Direction direction, LevelReader level, BlockPos pos) {
        BlockState above = level.getBlockState(pos.above());
        BlockState below = level.getBlockState(pos.below());
        boolean up = above.is(this) && !above.getValue(PROPERTY_BY_DIRECTION.get(direction));
        boolean down = below.is(this) && !below.getValue(PROPERTY_BY_DIRECTION.get(direction));

        return GufyUtil.getVerticalPosition(up, down);
    }
}
