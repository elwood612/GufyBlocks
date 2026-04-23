package com.github.elwood612.gufyblocks.items;

import com.github.elwood612.gufyblocks.util.GufyPhasingHandler;
import com.github.elwood612.gufyblocks.util.GufyScheduler;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class GufyPhasingVial extends Item
{
    private static final int delay = 200; // 200 ticks = 10 seconds

    public GufyPhasingVial(Item.Properties properties) { super(properties); }

    @NotNull
    @Override
    public InteractionResult use(Level level, Player player, @NotNull InteractionHand handIn) {
        ItemStack itemstack = player.getItemInHand(handIn);
        Consumable consumable = itemstack.get(DataComponents.CONSUMABLE);
        if (consumable != null) {
            return consumable.startConsuming(player, itemstack, handIn);
        } else {
            return InteractionResult.PASS;
        }
    }

    @NotNull
    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level level, LivingEntity livingEntity) {
        Consumable consumable = itemstack.get(DataComponents.CONSUMABLE);

        if (!level.isClientSide() && level instanceof ServerLevel serverLevel && livingEntity instanceof ServerPlayer serverPlayer)
        {
            BlockPos origin = serverPlayer.getOnPos();
            Vec3 center = Vec3.atCenterOf(origin);

            for (int i = 0; i < delay; i += 2) { // every 2 ticks
                GufyScheduler.schedule(serverLevel, i, serverPlayer.getUUID(), () -> {
                    spawnPhasingOrb(serverLevel, center);
                });
                if (i == 2 || delay - i == 100 || delay - i == 54 || delay - i == 34 || delay - i == 16) {
                    GufyScheduler.schedule(serverLevel, i, serverPlayer.getUUID(), () -> {
                        addSpark(serverLevel, center);
                    });
                }
            }

            GufyPhasingHandler.originalMode = serverPlayer.gameMode.getGameModeForPlayer();
            serverPlayer.setGameMode(GameType.SPECTATOR);

            GufyScheduler.schedule(serverLevel, delay, serverPlayer.getUUID(), () -> {
                GufyPhasingHandler.returnPlayer(serverPlayer);
            });
            GufyPhasingHandler.activePhasing.put(serverPlayer.getUUID(), origin);

            GufyUtil.execute("effect give @p minecraft:blindness 1 0 true", serverLevel, origin, serverPlayer);

            if (!serverPlayer.getAbilities().instabuild) {
                return itemstack;
            }
        }

        return consumable != null ? consumable.onConsume(level, livingEntity, itemstack) : itemstack;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    private void spawnPhasingOrb(ServerLevel level, Vec3 center) {
        level.sendParticles(
                ParticleTypes.END_ROD,
                center.x, center.y + 1.2, center.z,
                2,
                0.1, 0.1, 0.1,
                0.01
        );
        level.sendParticles(
                ParticleTypes.SMOKE,
                center.x, center.y + 1, center.z,
                3,
                0.2, 0.1, 0.2,
                0.02
        );
    }

    private void addSpark(ServerLevel level, Vec3 center) {
        double dx = (level.random.nextDouble() - 0.5) * 2.5;
        double dy = level.random.nextDouble() * 1.5;
        double dz = (level.random.nextDouble() - 0.5) * 2.5;
        level.sendParticles(
                ParticleTypes.CRIT,
                center.x, center.y + 1, center.z,
                30,
                dx, dy, dz,
                0.2
        );
        level.sendParticles(
                ParticleTypes.END_ROD,
                center.x, center.y + 1, center.z,
                30,
                dx / 2, dy / 2, dz / 2,
                0.1
        );
        level.playSound((Player) null,
                center.x, center.y + 1, center.z,
                SoundEvents.BEACON_AMBIENT,
                SoundSource.NEUTRAL,
                0.8f, 0.4f);
        level.playSound((Player) null,
                center.x, center.y + 1, center.z,
                SoundEvents.ENDERMAN_TELEPORT,
                SoundSource.NEUTRAL,
                1f, 2.5f);
        level.playSound((Player) null,
                center.x, center.y + 1, center.z,
                SoundEvents.AMETHYST_CLUSTER_BREAK,
                SoundSource.NEUTRAL,
                0.4f, 0.5f);
    }
}
