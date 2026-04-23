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
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class GufyInsomniaFragment extends Item
{
    public GufyInsomniaFragment(Item.Properties properties) { super(properties); }

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
            if (position.getY() < 64) {
                serverPlayer.sendSystemMessage(Component.translatable("message.gufyblocks.insomnia_altitude"));
                fail = true;
            }
            if (fail) {
                level.playSound((Player) null, position, SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 0.5f, 0.4f);
                return InteractionResult.FAIL;
            }

            if (!player.getAbilities().instabuild) {
                itemstack.consume(1, player);
            }

            int rand = level.random.nextIntBetweenInclusive(14000, 18000);
            serverLevel.setDayTime(rand);
            GufyUtil.execute("effect give @p minecraft:blindness 3 0 true", serverLevel, position, player);
            GufyUtil.execute("effect give @p minecraft:nausea 3 0 true", serverLevel, position, player);
            GufyUtil.execute("gamerule spawn_phantoms true", serverLevel, position, player);
            GufyUtil.execute("summon minecraft:phantom ~ ~25 ~", serverLevel, position, player);
            if (level.random.nextFloat() < 0.5f) {
                GufyUtil.execute("summon minecraft:phantom ~ ~25 ~", serverLevel, position, player);
            }

            player.resetStat(Stats.CUSTOM.get(Stats.TIME_SINCE_REST));
            player.awardStat(Stats.CUSTOM.get(Stats.TIME_SINCE_REST), 200000);

            level.playSound((Player) null, position, SoundEvents.AMBIENT_CAVE.value(), SoundSource.NEUTRAL, 1.2f, 0.4f);
            level.playSound((Player) null, position, SoundEvents.AMETHYST_BLOCK_BREAK, SoundSource.NEUTRAL);
            ((ServerLevel) player.level()).sendParticles(
                    ParticleTypes.PORTAL,
                    player.getX(),
                    player.getY() + 1.0,
                    player.getZ(),
                    8,
                    0.5, 0.5, 0.5,
                    0.05
            );

            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.FAIL;
        }
    }

    @NotNull
    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable("item.gufyblocks.insomnia_fragment").copy().withStyle(ChatFormatting.DARK_PURPLE);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
