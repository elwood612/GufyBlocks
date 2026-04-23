package com.github.elwood612.gufyblocks.mixins;

import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Player.class, priority = 1001)
public abstract class PlayerMixin
{
    @Inject(method = "dropEquipment", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;destroyVanishingCursedItems()V"), cancellable = true)
    protected void injected_KeepInventory(ServerLevel level, CallbackInfo callback) {
        Player player = (Player)(Object)this;
        if (GufyUtil.hasTotemOfKeeping(player)) {
            GufyUtil.consumeTotem(player);
            callback.cancel();
        }
    }
}
