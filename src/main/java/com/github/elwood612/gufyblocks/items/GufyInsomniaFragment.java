package com.github.elwood612.gufyblocks.items;

import com.github.elwood612.gufyblocks.GufyRegistry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

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
}
