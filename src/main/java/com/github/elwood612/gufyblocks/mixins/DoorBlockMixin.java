package com.github.elwood612.gufyblocks.mixins;

import com.github.elwood612.gufyblocks.util.GufyDoorHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(value = DoorBlock.class, priority = 1001)
public abstract class DoorBlockMixin
{
    @Inject(method = "playSound", at = @At("HEAD"))
    private void injected_playSound(@Nullable Entity source, Level level, BlockPos pos, boolean isOpening, CallbackInfo callback) {
        GufyDoorHandler.onDoorStateChange(level, pos, level.getBlockState(pos), isOpening);
    }
}