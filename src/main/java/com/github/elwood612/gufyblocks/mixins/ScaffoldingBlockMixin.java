package com.github.elwood612.gufyblocks.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ScaffoldingBlock;
import net.minecraft.world.level.block.state.BlockState;
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
public class ScaffoldingBlockMixin
{
    @Shadow @Final private static VoxelShape SHAPE_STABLE;
    @Shadow @Final private static VoxelShape SHAPE_UNSTABLE_BOTTOM;
    @Shadow @Final private static VoxelShape SHAPE_BELOW_BLOCK;
    @Unique private static final VoxelShape SHAPE_UNSTABLE_TOP = Block.box(0.0, 14.0, 0.0, 16.0, 16.0, 16.0);

    // Replaces vanilla getCollisionShape, by altering return values and cancelling before the rest of the method can be called
    @Inject(method = "getCollisionShape", at = @At("HEAD"), cancellable = true)
    private void getModifiedCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context, CallbackInfoReturnable<VoxelShape> cir) {
        boolean isFloating = state.getValue(ScaffoldingBlock.DISTANCE) != 0 &&
                state.getValue(ScaffoldingBlock.BOTTOM) &&
                context.isAbove(SHAPE_BELOW_BLOCK, pos, true);

        if (context.isAbove(Shapes.block(), pos, true) && !context.isDescending()) {
            cir.setReturnValue(SHAPE_STABLE);
        } else if (isFloating && context.isDescending()) {
            cir.setReturnValue(SHAPE_UNSTABLE_TOP);
        } else {
            cir.setReturnValue(isFloating ? SHAPE_UNSTABLE_BOTTOM : Shapes.empty());
        }
    }
}
