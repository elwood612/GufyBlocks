package com.github.elwood612.gufyblocks.items;

import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class GufySpectralGem extends Item
{
    public GufySpectralGem(Item.Properties properties) { super(properties); }

    @NotNull
    @Override
    public InteractionResult use(Level level, Player player, @NotNull InteractionHand handIn) {
        BlockPos position = player.getOnPos();
        ItemStack itemstack = player.getItemInHand(handIn);
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel && player instanceof ServerPlayer serverPlayer) {
            player.swing(handIn, true);

            if (!player.getAbilities().instabuild) {
                itemstack.consume(1, player);
            }

            GufyUtil.execute("effect give @p minecraft:night_vision 14 0 true", serverLevel, position, player);
            GufyUtil.execute("execute at @p run effect give @e[distance=..64] minecraft:glowing 14 0 true", serverLevel, position, player);
            GufyUtil.execute("effect give @p minecraft:blindness 1 0 true", serverLevel, position, player);

            level.playSound((Player) null,
                    position,
                    SoundEvents.ENDERMAN_AMBIENT,
                    SoundSource.NEUTRAL,
                    0.4f, 0.2f);
            level.playSound((Player) null,
                    position,
                    SoundEvents.AMETHYST_BLOCK_BREAK,
                    SoundSource.NEUTRAL);
            ((ServerLevel) player.level()).sendParticles(
                    ParticleTypes.PORTAL,
                    player.getX(),
                    player.getY() + 1.0,
                    player.getZ(),
                    16,
                    0.5, 0.5, 0.5,
                    0.1
            );

            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.FAIL;
        }
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
