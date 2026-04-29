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
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class GufySoulboundAnchor extends Item
{
    public GufySoulboundAnchor(Item.Properties properties) { super(properties); }

    @NotNull
    @Override
    public InteractionResult use(Level level, Player player, @NotNull InteractionHand handIn) {
        BlockPos position = player.blockPosition();
        ItemStack itemstack = player.getItemInHand(handIn);
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel && player instanceof ServerPlayer serverPlayer) {
            player.swing(handIn, true);

            Optional<GlobalPos> optional = player.getLastDeathLocation();

            if (optional.isEmpty()) {
                serverPlayer.sendSystemMessage(Component.translatable("message.gufyblocks.soulbound_nodeath"));
                player.level().playSound((Player) null, player.blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 0.5f, 0.4f);
                return InteractionResult.FAIL;
            }

            GlobalPos deathPos = optional.get();
            MinecraftServer server = player.level().getServer();
            ServerLevel targetLevel = server.getLevel(deathPos.dimension());

            if (targetLevel == null) {
                return InteractionResult.FAIL;
            }
            if (!(targetLevel.dimension().equals(player.level().dimension()))){
                serverPlayer.sendSystemMessage(Component.translatable("message.gufyblocks.soulbound_dimension"));
                player.level().playSound((Player) null, player.blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 0.5f, 0.4f);
                return InteractionResult.FAIL;
            }

            BlockPos pos = deathPos.pos();
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

    private void teleportToLastDeath(ServerPlayer player) {

    }
}
