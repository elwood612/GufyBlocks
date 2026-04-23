package com.github.elwood612.gufyblocks.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GufyTotemKeeping extends Item
{
    public GufyTotemKeeping(Item.Properties properties) { super(properties); }

    // Main code is handled in GufyPlayerEvents and the PlayerMixin

    @NotNull
    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable("item.gufyblocks.totem_keeping").copy().withStyle(ChatFormatting.AQUA);
    }
}
