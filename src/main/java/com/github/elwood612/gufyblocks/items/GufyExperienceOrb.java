package com.github.elwood612.gufyblocks.items;

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
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class GufyExperienceOrb extends Item
{
    public GufyExperienceOrb(Item.Properties properties) { super(properties); }

    @NotNull
    @Override
    public InteractionResult use(Level level, Player player, @NotNull InteractionHand handIn) {
        BlockPos position = player.blockPosition();
        ItemStack itemstack = player.getItemInHand(handIn);
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel && player instanceof ServerPlayer serverPlayer) {
            player.swing(handIn, true);

            int basePerItem = 20 + serverLevel.random.nextInt(5) + serverLevel.random.nextInt(5);
            int itemsUsed = player.isShiftKeyDown() ? itemstack.getCount() : 1;
            double X = serverLevel.random.nextDouble() * 10;
            double Y = serverLevel.random.nextDouble();
            double Z = serverLevel.random.nextDouble() * 10;
            ExperienceOrb.awardWithDirection(serverLevel, player.position(), new Vec3(X, Y, Z), basePerItem * itemsUsed);

            if (!player.getAbilities().instabuild) {
                itemstack.shrink(itemsUsed);
            }

            level.playSound((Player) null, position, SoundEvents.SMALL_AMETHYST_BUD_BREAK, SoundSource.NEUTRAL, 0.5f, 0.5f);
            level.playSound((Player) null, position, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.NEUTRAL);
            serverLevel.sendParticles(
                    ParticleTypes.HAPPY_VILLAGER,
                    player.getX(), player.getY() + 1.0, player.getZ(),
                    5,
                    0.3, 0.3, 0.3,
                    0.05
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
