package com.github.elwood612.gufyblocks.items;

import com.github.elwood612.gufyblocks.GufyRegistry;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GufyAnchor extends Item
{
    public GufyAnchor(Item.Properties properties) { super(properties); }

    @NotNull
    @Override
    public InteractionResult use(Level level, Player player, @NotNull InteractionHand handIn) {
        ItemStack itemstack = player.getItemInHand(handIn);
        BlockPos position = player.getOnPos();
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer && itemstack.has(GufyRegistry.OWNER.get())) {
            String ownerName = itemstack.getOrDefault(GufyRegistry.OWNER.get(), "");

            player.swing(handIn, true);

            if (ownerName.isEmpty()) return InteractionResult.PASS;

            if (ownerName.equalsIgnoreCase(player.getGameProfile().name())) {
                serverPlayer.sendSystemMessage(Component.translatable("message.gufyblocks.teleport_self"));
                level.playSound((Player) null, position, SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 0.5f, 0.4f);
                return InteractionResult.SUCCESS;
            }

            Player owner = GufyUtil.getPlayerEntityByName(level, ownerName);
            if (owner != null) {
                if (!owner.level().dimension().equals(player.level().dimension())) {
                    serverPlayer.sendSystemMessage(Component.translatable("message.gufyblocks.teleport_dimension"));
                    level.playSound((Player) null,
                            position,
                            SoundEvents.ENDERMAN_TELEPORT,
                            SoundSource.NEUTRAL,
                            0.5f, 0.4f);
                    return InteractionResult.SUCCESS;
                }

                if (!player.getAbilities().instabuild) {
                    itemstack.consume(1, player);
                }

                level.playSound((Player) null, position, SoundEvents.AMETHYST_CLUSTER_BREAK, SoundSource.NEUTRAL);
                level.playSound((Player) null, owner.blockPosition(), SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 0.5F, 0.4F / (level.random.nextFloat() * 0.4F + 0.8F));

                player.teleportTo(owner.getX(), owner.getY(), owner.getZ());
                ((ServerLevel) player.level()).sendParticles(
                        ParticleTypes.PORTAL,
                        owner.getX(),
                        owner.getY() + 1.0,
                        owner.getZ(),
                        32,
                        0.5, 0.5, 0.5,
                        0.1
                );

            } else {
                serverPlayer.sendSystemMessage(Component.translatable("message.gufyblocks.teleport_offline", ChatFormatting.RED + ownerName));
                level.playSound((Player) null,
                        position,
                        SoundEvents.ENDERMAN_TELEPORT,
                        SoundSource.BLOCKS,
                        0.5f, 0.4f);
            }
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.FAIL;
        }
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, ServerLevel level, @NotNull Entity entity, @Nullable EquipmentSlot slot) {
        if (!level.isClientSide()) {
            if (!stack.has(GufyRegistry.OWNER.get())) {
                if (entity instanceof Player player) {
                    stack.set(GufyRegistry.OWNER.get(), player.getGameProfile().name());
                    level.playSound((Player) null,
                            player.getX(),
                            player.getY(),
                            player.getZ(),
                            SoundEvents.ENCHANTMENT_TABLE_USE,
                            SoundSource.PLAYERS,
                            0.8f, 0.8f);
                }
            }
        }
        super.inventoryTick(stack, level, entity, slot);
    }

    @NotNull
    @Override
    public Component getName(ItemStack stack) {
        if (stack.has(GufyRegistry.OWNER.get())) {
            String owner = stack.getOrDefault(GufyRegistry.OWNER.get(), "");
            if (owner.isEmpty()) return super.getName(stack);
            return Component.literal("Teleportation Crystal: " + owner).copy().withStyle(ChatFormatting.LIGHT_PURPLE);
        } else {
            return super.getName(stack);
        }
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return stack.has(GufyRegistry.OWNER.get());
    }
}
