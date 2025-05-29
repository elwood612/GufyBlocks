package com.github.elwood612.gufyblocks.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ScaffoldingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ScaffoldingBlock.class, priority = 1001)
public abstract class ScaffoldingBlockMixin
{
    @Shadow @Final private static VoxelShape SHAPE_STABLE;
    @Shadow @Final private static VoxelShape SHAPE_UNSTABLE_BOTTOM;
    @Shadow @Final private static VoxelShape SHAPE_BELOW_BLOCK;
    @Shadow @Final public static BooleanProperty WATERLOGGED;
    @Unique private static final VoxelShape SHAPE_UNSTABLE_TOP = Block.box(0.0, 14.0, 0.0, 16.0, 16.0, 16.0);

    // Replaces vanilla getCollisionShape, by altering return values and cancelling before the rest of the method can be called
    @Inject(method = "getCollisionShape", at = @At("HEAD"), cancellable = true)
    private void injected_getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context, CallbackInfoReturnable<VoxelShape> callback) {
        boolean isFloating = state.getValue(ScaffoldingBlock.DISTANCE) != 0 &&
                state.getValue(ScaffoldingBlock.BOTTOM) &&
                context.isAbove(SHAPE_BELOW_BLOCK, pos, true);

        if (context.isAbove(Shapes.block(), pos, true) && !context.isDescending()) {
            callback.setReturnValue(SHAPE_STABLE);
        } else if (isFloating && context.isDescending()) {
            callback.setReturnValue(SHAPE_UNSTABLE_TOP);
        } else {
            callback.setReturnValue(isFloating ? SHAPE_UNSTABLE_BOTTOM : Shapes.empty());
        }
    }

    @Inject(method = "isBottom", at = @At("HEAD"), cancellable = true)
    private void injected_isBottom(BlockGetter level, BlockPos pos, int distance, CallbackInfoReturnable<Boolean> callback) {
        if (distance == 7 && !level.getBlockState(pos.below()).is(Blocks.SCAFFOLDING)) {
            callback.setReturnValue(false);
        }
    }
}
