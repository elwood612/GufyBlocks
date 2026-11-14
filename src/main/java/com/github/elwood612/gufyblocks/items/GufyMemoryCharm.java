package com.github.elwood612.gufyblocks.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class GufyMemoryCharm extends Item
{
    public GufyMemoryCharm(Item.Properties properties) { super(properties); }

    // Code for Memory charm is in memoryCharm package

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
