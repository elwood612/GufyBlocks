package com.github.elwood612.gufyblocks.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class GufyStillstone extends Item
{
    public GufyStillstone(Item.Properties properties) { super(properties); }

    // Code for Stillstone (Amulet of Peace) is in InteractEvent

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
