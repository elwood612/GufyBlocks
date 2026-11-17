package com.github.elwood612.gufyblocks.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class GufyHomeboundAnchor extends Item
{
    public GufyHomeboundAnchor(Item.Properties properties) { super(properties); }

    @NotNull
    @Override
    public InteractionResult use(Level level, Player player, @NotNull InteractionHand handIn) {
        BlockPos position = player.blockPosition();
        ItemStack itemstack = player.getItemInHand(handIn);
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel && player instanceof ServerPlayer serverPlayer) {
            player.swing(handIn, SwingAnimation.DEFAULT, true);

            // Get world spawn
            MinecraftServer server = serverLevel.getServer();
            GlobalPos spawnPos = server.overworld().getRespawnData().globalPos();

            // If player spawn exists, use that
            ServerPlayer.RespawnConfig config = serverPlayer.getRespawnConfig();
            if (config != null) {
                spawnPos = config.respawnData().globalPos();
            }

            ServerLevel targetLevel = server.getLevel(spawnPos.dimension());

            if (targetLevel == null) {
                serverPlayer.sendSystemMessage(Component.translatable("message.gufyblocks.homebound_nospawn"));
                player.level().playSound((Player) null, player.blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 0.5f, 0.4f);
                return InteractionResult.FAIL;
            }
            if (!(targetLevel.dimension().equals(player.level().dimension()))){
                serverPlayer.sendSystemMessage(Component.translatable("message.gufyblocks.homebound_dimension"));
                player.level().playSound((Player) null, player.blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 0.5f, 0.4f);
                return InteractionResult.FAIL;
            }

            BlockPos pos = spawnPos.pos();
            player.teleportTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);

            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            player.level().playSound((Player) null, player.blockPosition(), SoundEvents.AMETHYST_CLUSTER_BREAK, SoundSource.NEUTRAL);
            player.level().playSound((Player) null, pos, SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 0.5F, 0.4F);

            ((ServerLevel) player.level()).sendParticles(
                    ParticleTypes.PORTAL,
                    pos.getX(), pos.getY(), pos.getZ(),
                    32,
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
