package com.github.elwood612.gufyblocks.blocks.blockSpecialty;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GufySeat extends Block
{
    public static final VoxelShape SLAB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);

    public GufySeat(BlockBehaviour.Properties properties)
    {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SLAB;
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
        return super.updateShape(stateIn, levelIn, tick, currentPos, direction, facingPos, facingState, randomSource);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return this.getShape(state, level, pos, context);
    }
}
