package com.github.elwood612.gufyblocks.items;

import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.NotNull;

public class GufySunlightShard extends Item
{
    public GufySunlightShard(Item.Properties properties) { super(properties); }

    @NotNull
    @Override
    public InteractionResult use(Level level, Player player, @NotNull InteractionHand handIn) {
        BlockPos position = player.getOnPos();
        ItemStack itemstack = player.getItemInHand(handIn);
        Boolean fail = false;
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel && player instanceof ServerPlayer serverPlayer) {
            player.swing(handIn, true);

            if (level.dimension() != Level.OVERWORLD) {
                serverPlayer.sendSystemMessage(Component.translatable("message.gufyblocks.weather_dimension"));
                fail = true;
            }
            if (!level.canSeeSky(position.above())) {
                serverPlayer.sendSystemMessage(Component.translatable("message.gufyblocks.weather_outdoors"));
                fail = true;
            }
            if (!level.isRaining() && (level.getDayTime() % 24000 < 11000 || level.getDayTime() % 24000 > 22500)) {
                serverPlayer.sendSystemMessage(Component.translatable("message.gufyblocks.sunlight_daytime"));
                fail = true;
            }
            if (fail) {
                level.playSound((Player) null, position, SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 0.5f, 0.4f);
                return InteractionResult.FAIL;
            }

            if (!player.getAbilities().instabuild) {
                itemstack.consume(1, player);
            }

            serverLevel.setDayTime(0);
            serverLevel.resetWeatherCycle();

            level.playSound((Player) null, position, SoundEvents.BEACON_ACTIVATE, SoundSource.NEUTRAL, 0.5f, 1.5f);
            level.playSound((Player) null, position, SoundEvents.FIRECHARGE_USE, SoundSource.NEUTRAL, 1f, 0.5f);
            level.playSound((Player) null, position, SoundEvents.FIRE_EXTINGUISH, SoundSource.NEUTRAL, 0.5f, 0.7f);

            Vec3 pos = player.position().add(0, 1.0, 0);
            sendSunlightParticles(serverLevel, pos);

            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.FAIL;
        }
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    private void sendSunlightParticles(ServerLevel serverLevel, Vec3 pos) {
        serverLevel.sendParticles(
                ParticleTypes.END_ROD,
                pos.x, pos.y, pos.z,
                25,
                0.5, 0.5, 0.5,
                0.1
        );
        serverLevel.sendParticles(
                new DustParticleOptions(0xFFD54F, 1.2f),
                pos.x, pos.y, pos.z,
                40,
                0.4, 0.4, 0.4,
                0.05
        );

        RandomSource random = serverLevel.random;
        for (int i = 0; i < 40; i++) {
            double dx = (random.nextDouble() - 0.5) * 0.2;
            double dy = random.nextDouble() * 0.5 + i * 0.05; // mostly upward
            double dz = (random.nextDouble() - 0.5) * 0.2;

            serverLevel.sendParticles(
                    ParticleTypes.END_ROD,
                    pos.x, pos.y, pos.z,
                    1,
                    dx, dy, dz,
                    0.2
            );
        }
    }
}
