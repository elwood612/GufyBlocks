package com.github.elwood612.gufyblocks.blocks.blockSpecialty;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;

public class GufyRod extends DirectionalBlock implements SimpleWaterloggedBlock
{
    
    //RE-DO THIS:
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final VoxelShape SHAPE_VERTICAL = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);
    public static final VoxelShape SHAPE_NS = Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 16.0D);
    public static final VoxelShape SHAPE_WE = Block.box(0.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D);
    
    public GufyRod(BlockBehaviour.Properties properties)
	{
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(FACING, Direction.UP));
	}

    @Override
    protected MapCodec<? extends DirectionalBlock> codec()
    {
        return null;
    }

    @Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) 
	{
		builder.add(FACING);
		builder.add(WATERLOGGED);
	}
    
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) 
    {
    	Direction direction = context.getClickedFace();
    	FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos().relative(direction.getOpposite()));
        return blockstate.getBlock() == this && blockstate.getValue(FACING) == direction ? this.defaultBlockState().setValue(FACING, direction.getOpposite()).setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.getType() == Fluids.WATER)) : this.defaultBlockState().setValue(FACING, direction).setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.getType() == Fluids.WATER));
    }
    
    @Override
    public BlockState rotate(BlockState state, Rotation direction) 
    {
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }
    
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) 
    {
        return state.setValue(FACING, mirrorIn.mirror(state.getValue(FACING)));
    }
    
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
	{
    	switch(state.getValue(FACING).getAxis()) {
        case X:
        default:
           return SHAPE_WE;
        case Z:
           return SHAPE_NS;
        case Y:
           return SHAPE_VERTICAL;
        }
	}
    
    @Override
    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) 
    {
        if (stateIn.getValue(WATERLOGGED)) 
        {
            worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
        }

        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state) 
    {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
    
    public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) 
    {
        return false;
    }

}
