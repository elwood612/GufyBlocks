package com.github.elwood612.gufyblocks.items;

import com.github.elwood612.gufyblocks.spectralChime.LightyRequest;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import com.github.elwood612.gufyblocks.spectralChime.LightyActivator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

public class GufySpectralGem extends Item
{
    public GufySpectralGem(Item.Properties properties) { super(properties); }

    @NotNull
    @Override
    public InteractionResult use(Level level, Player player, @NotNull InteractionHand handIn) {
        BlockPos position = player.getOnPos();
        ItemStack itemstack = player.getItemInHand(handIn);
        double radius = 64.0;
        int durationTicks = 400;
        int durationSeconds = 20;
        AABB area = player.getBoundingBox().inflate(radius);

        if (!level.isClientSide() && level instanceof ServerLevel serverLevel && player instanceof ServerPlayer serverPlayer) {
            player.swing(handIn, SwingAnimation.DEFAULT, true);

            if (!player.getAbilities().instabuild) {
                itemstack.hurtAndBreak(1, player, handIn);
            }

            player.addEffect(new MobEffectInstance(
                    MobEffects.GLOWING,
                    durationTicks,
                    0,
                    false,
                    true
            ));
            for (Entity entity : level.getEntities(player, area)) {
                if (entity instanceof Mob mob) {
                    mob.addEffect(new MobEffectInstance(
                            MobEffects.GLOWING,
                            durationTicks,
                            0,
                            false,
                            true
                    ));
                }
            }

            for (ServerPlayer nearbyPlayer : serverLevel.players()) {
                if (nearbyPlayer.distanceToSqr(player) <= radius * radius) {
                    PacketDistributor.sendToPlayer(
                            nearbyPlayer,
                            new LightyRequest(durationSeconds)
                    );
                }
            }

            level.playSound((Player) null, position, SoundEvents.BELL_RESONATE, SoundSource.NEUTRAL, 0.8f, 0.35f);
            level.playSound((Player) null, position, SoundEvents.NOTE_BLOCK_CHIME.value(), SoundSource.NEUTRAL, 0.8f, 0.6f);
            level.playSound((Player) null, position, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.NEUTRAL, 4f, 0.8f);

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
