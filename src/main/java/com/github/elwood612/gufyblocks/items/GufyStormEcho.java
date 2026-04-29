package com.github.elwood612.gufyblocks.items;

import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class GufyStormEcho extends Item
{
    public GufyStormEcho(Item.Properties properties) { super(properties); }

    @NotNull
    @Override
    public InteractionResult use(Level level, Player player, @NotNull InteractionHand handIn) {
        BlockPos position = player.getOnPos();
        ItemStack itemstack = player.getItemInHand(handIn);
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel && player instanceof ServerPlayer serverPlayer) {
            player.swing(handIn, true);

            if (level.dimension() != Level.OVERWORLD) {
                serverPlayer.sendSystemMessage(Component.translatable("message.gufyblocks.weather_dimension"));
                level.playSound((Player) null, position, SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 0.5f, 0.4f);
                return InteractionResult.FAIL;
            }
            if (!level.canSeeSky(position.above())) {
                serverPlayer.sendSystemMessage(Component.translatable("message.gufyblocks.weather_outdoors"));
                level.playSound((Player) null, position, SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 0.5f, 0.4f);
                return InteractionResult.FAIL;
            }

            if (!player.getAbilities().instabuild) {
                itemstack.consume(1, player);
            }

            GufyUtil.execute("weather thunder 6000", serverLevel, position, player);
            level.getServer().getPlayerList().broadcastSystemMessage(Component.translatable("message.gufyblocks.server_thunder"), true);

            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(serverLevel, EntitySpawnReason.COMMAND);
            if (lightning != null) {
                lightning.moveOrInterpolateTo(player.position());
                serverLevel.addFreshEntity(lightning);
            }

            level.playSound((Player) null, position, SoundEvents.DRAGON_FIREBALL_EXPLODE, SoundSource.NEUTRAL);

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
