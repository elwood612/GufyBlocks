package com.github.elwood612.gufyblocks.util;

import com.github.elwood612.gufyblocks.GufyRegistry;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.conditional.ConditionalItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public record GufyStoredBiome() implements ConditionalItemModelProperty
{
    public static final MapCodec<GufyStoredBiome> MAP_CODEC = MapCodec.unit(new GufyStoredBiome());

    @Override
    public boolean get(ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed, ItemDisplayContext context) {
        return stack.has(GufyRegistry.STORED_BIOME.get());
    }

    @Override
    public MapCodec<GufyStoredBiome> type() {
        return MAP_CODEC;
    }
}
