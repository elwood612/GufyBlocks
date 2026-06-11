package com.github.elwood612.gufyblocks.items;

import com.github.elwood612.gufyblocks.GufyBlocks;
import com.github.elwood612.gufyblocks.GufyRegistry;
import com.github.elwood612.gufyblocks.effects.GufyInsomniaEffect;
import com.github.elwood612.gufyblocks.util.GufyPhasingHandler;
import com.github.elwood612.gufyblocks.util.GufyScheduler;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.clock.ServerClockManager;
import net.minecraft.world.clock.WorldClock;
import net.minecraft.world.clock.WorldClocks;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import static com.github.elwood612.gufyblocks.GufyBlocks.MODID;

public class GufyInsomniaFragment extends Item
{
    public GufyInsomniaFragment(Item.Properties properties) { super(properties); }

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

        if (!level.isClientSide() && level instanceof ServerLevel serverLevel && livingEntity instanceof ServerPlayer serverPlayer) {
            MobEffectInstance instance = new MobEffectInstance(
                    GufyRegistry.INSOMNIA,7200, 0, false, true, true);
            serverPlayer.addEffect(instance);

            return consumable != null ? consumable.onConsume(level, livingEntity, itemstack) : itemstack;
        }

        return consumable != null ? consumable.onConsume(level, livingEntity, itemstack) : itemstack;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
