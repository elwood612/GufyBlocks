package com.github.elwood612.gufyblocks.util;

import com.github.elwood612.gufyblocks.GufyRegistry;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.conditional.ConditionalItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public record GufyOwnership() implements ConditionalItemModelProperty
{
    public static final MapCodec<GufyOwnership> MAP_CODEC = MapCodec.unit(new GufyOwnership());

    @Override
    public boolean get(ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed, ItemDisplayContext context) {
        return stack.has(GufyRegistry.OWNER.get());
    }

    @Override
    public MapCodec<GufyOwnership> type() {
        return MAP_CODEC;
    }
}
