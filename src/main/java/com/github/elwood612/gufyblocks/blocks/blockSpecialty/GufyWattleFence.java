package com.github.elwood612.gufyblocks.blocks.blockSpecialty;

import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import com.mojang.serialization.MapCodec;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;

public class GufyWattleFence extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock
{
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	protected static final VoxelShape WEST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_SHAPE = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape NORTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
    protected static final VoxelShape SOUTH_SHAPE = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
    
    protected static final VoxelShape COLLISION_WEST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
    protected static final VoxelShape COLLISION_EAST_SHAPE = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape COLLISION_NORTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
    protected static final VoxelShape COLLISION_SOUTH_SHAPE = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);

    public GufyWattleFence(BlockBehaviour.Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec()
    {
        return null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) 
    {
        builder.add(FACING, WATERLOGGED);
    }
	
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) 
    {
    	BlockState BlockState = this.defaultBlockState();
        FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
        Direction direction = context.getClickedFace();
        
        if (direction.getAxis().isHorizontal()) { BlockState = BlockState.setValue(FACING, direction); } 
        else { BlockState = BlockState.setValue(FACING, context.getHorizontalDirection().getOpposite()); }
        
        return BlockState.setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.getType() == Fluids.WATER));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) 
    {
    	switch((Direction)state.getValue(FACING).getOpposite())
        {
            case WEST:
                return (VoxelShape) WEST_SHAPE;
            case EAST:
                return (VoxelShape) EAST_SHAPE;
            case SOUTH:
                return (VoxelShape) SOUTH_SHAPE;
            default:
                return (VoxelShape) NORTH_SHAPE;
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
    	switch((Direction)state.getValue(FACING).getOpposite())
        {
            case WEST:
                return (VoxelShape) COLLISION_WEST_SHAPE;
            case EAST:
                return (VoxelShape) COLLISION_EAST_SHAPE;
            case SOUTH:
                return (VoxelShape) COLLISION_SOUTH_SHAPE;
            default:
                return (VoxelShape) COLLISION_NORTH_SHAPE;
        }
     }

    @Override
    protected BlockState updateShape(
            BlockState stateIn,
            LevelReader levelIn,
            ScheduledTickAccess tick,
            BlockPos currentPos,
            Direction direction,
            BlockPos facingPos,
            BlockState facingState,
            RandomSource randomSource
    ) {
        if (stateIn.getValue(WATERLOGGED)) {
            tick.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelIn));
        }

        return super.updateShape(stateIn, levelIn, tick, currentPos, direction, facingPos, facingState, randomSource);
    }

    @Override
    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state) 
    {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected boolean isPathfindable(BlockState p_53306_, PathComputationType p_53309_) {
        return false;
    }
}
