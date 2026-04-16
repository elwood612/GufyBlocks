package com.github.elwood612.gufyblocks.events;

import com.github.elwood612.gufyblocks.GufyBlocks;
import com.github.elwood612.gufyblocks.GufyRegistry;
import com.github.elwood612.gufyblocks.items.*;
import com.github.elwood612.gufyblocks.util.GufyOwnership;
import com.github.elwood612.gufyblocks.util.GufyStoredBiome;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterConditionalItemModelPropertyEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(modid = GufyBlocks.MODID, value = Dist.CLIENT)
public class GufyClientEvents
{
    // Creates the "has_owner" property for anchors, so they can use the correct model
    @SubscribeEvent
    public static void registerConditionalProperties(RegisterConditionalItemModelPropertyEvent event) {
        event.register(
                Identifier.fromNamespaceAndPath(GufyBlocks.MODID, "has_owner"),
                GufyOwnership.MAP_CODEC
        );
        event.register(
                Identifier.fromNamespaceAndPath(GufyBlocks.MODID, "has_stored_biome"),
                GufyStoredBiome.MAP_CODEC
        );
    }

    // Adds a tooltip to anchors based on ownership
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack itemstack = event.getItemStack();

        switch (itemstack.getItem()) {
            case GufyAnchor gufyAnchor -> {
                if (itemstack.has(GufyRegistry.OWNER.get()))
                {
                    String owner = itemstack.getOrDefault(GufyRegistry.OWNER.get(), "");
                    event.getToolTip().add(1,
                            Component.translatable("tooltip.gufyblocks.one_time_use")
                                    .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC)
                    );
                    event.getToolTip().add(2,
                            Component.translatable("tooltip.gufyblocks.anchor_instructions")
                                    .append(Component.literal(owner))
                                    .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC)
                    );
                } else {
                    event.getToolTip().add(1,
                            Component.translatable("tooltip.gufyblocks.anchor_empty")
                                    .withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC)
                    );
                }
            }
            case GufySunlightShard gufySunlightShard -> {
                event.getToolTip().add(1,
                        Component.translatable("tooltip.gufyblocks.one_time_use")
                                .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC)
                );
                event.getToolTip().add(2,
                        Component.translatable("tooltip.gufyblocks.sunlight_shard_instructions")
                                .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC)
                );
            }
            case GufyStormEcho gufyStormEcho -> {
                event.getToolTip().add(1,
                        Component.translatable("tooltip.gufyblocks.one_time_use")
                                .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC)
                );
                event.getToolTip().add(2,
                        Component.translatable("tooltip.gufyblocks.storm_echo_instructions")
                                .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC)
                );
            }
            case GufySpectralGem gufySpectralGem -> {
                event.getToolTip().add(1,
                        Component.translatable("tooltip.gufyblocks.one_time_use")
                                .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC)
                );
                event.getToolTip().add(2,
                        Component.translatable("tooltip.gufyblocks.spectral_gem_instructions")
                                .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC)
                );
            }
            case GufyInsomniaFragment gufyInsomniaFragment -> {
                event.getToolTip().add(1,
                        Component.translatable("tooltip.gufyblocks.one_time_use")
                                .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC)
                );
                event.getToolTip().add(2,
                        Component.translatable("tooltip.gufyblocks.insomnia_fragment_instructions")
                                .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC)
                );
            }
            case GufyBiomeSeed gufyBiomeSeed -> {
                if (itemstack.has(GufyRegistry.STORED_BIOME.get()))
                {
                    Identifier biomeID = itemstack.get(GufyRegistry.STORED_BIOME.get());
                    if (biomeID == null) { return; }
                    String biomeKey = "biome." + biomeID.getNamespace() + "." + biomeID.getPath();
                    event.getToolTip().add(1,
                            Component.translatable("tooltip.gufyblocks.one_time_use")
                                    .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC)
                    );
                    event.getToolTip().add(2,
                            Component.translatable("tooltip.gufyblocks.biome_seed_instructions")
                                    .append(Component.translatable(biomeKey))
                                    .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC)
                    );
                } else {
                    event.getToolTip().add(1,
                            Component.translatable("tooltip.gufyblocks.biome_seed_dormant")
                                    .withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC)
                    );
                }
            }
            case GufyPhasingVial gufyPhasingVial -> {
                event.getToolTip().add(1,
                        Component.translatable("tooltip.gufyblocks.one_time_use")
                                .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC)
                );
                event.getToolTip().add(2,
                        Component.translatable("tooltip.gufyblocks.phasing_vial_instructions")
                                .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC)
                );
            }
            default -> { }
        }
    }
}
