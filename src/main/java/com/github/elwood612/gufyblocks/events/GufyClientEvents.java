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
    // Adds model properties to alter appearance of certain items
    @SubscribeEvent
    public static void registerConditionalProperties(RegisterConditionalItemModelPropertyEvent event) {
        event.register(Identifier.fromNamespaceAndPath(GufyBlocks.MODID, "has_owner"), GufyOwnership.MAP_CODEC);
        event.register(Identifier.fromNamespaceAndPath(GufyBlocks.MODID, "has_stored_biome"), GufyStoredBiome.MAP_CODEC);
    }

    // Adds a tooltip to anchors based on ownership
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack itemstack = event.getItemStack();

        switch (itemstack.getItem()) {
            case GufyAnchor gufyAnchor -> {
                if (itemstack.has(GufyRegistry.OWNER.get())) {
                    String owner = itemstack.getOrDefault(GufyRegistry.OWNER.get(), "");
                    event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.relic_title").withStyle(ChatFormatting.GRAY));
                    event.getToolTip().add(2, Component.translatable("tooltip.gufyblocks.relic_blank"));
                    event.getToolTip().add(3, Component.translatable("tooltip.gufyblocks.relic_subtitle_broken").withStyle(ChatFormatting.GRAY));
                    event.getToolTip().add(4, Component.translatable("tooltip.gufyblocks.anchor_instructions").withStyle(ChatFormatting.GOLD));
                    event.getToolTip().add(5, Component.translatable("tooltip.gufyblocks.anchor_instructions_2").append(Component.literal(owner)).withStyle(ChatFormatting.GOLD));
                } else {
                    event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.anchor_empty").withStyle(ChatFormatting.DARK_GRAY).withStyle(ChatFormatting.ITALIC));
                }
            }
            case GufySunlightShard gufySunlightShard -> {
                event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.relic_title").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(2, Component.translatable("tooltip.gufyblocks.relic_blank"));
                event.getToolTip().add(3, Component.translatable("tooltip.gufyblocks.relic_subtitle_broken").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(4, Component.translatable("tooltip.gufyblocks.sunlight_shard_instructions").withStyle(ChatFormatting.GOLD));
            }
            case GufyStormEcho gufyStormEcho -> {
                event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.relic_title").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(2, Component.translatable("tooltip.gufyblocks.relic_blank"));
                event.getToolTip().add(3, Component.translatable("tooltip.gufyblocks.relic_subtitle_broken").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(4, Component.translatable("tooltip.gufyblocks.storm_echo_instructions").withStyle(ChatFormatting.GOLD));
            }
            case GufySpectralGem gufySpectralGem -> {
                event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.relic_title").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(2, Component.translatable("tooltip.gufyblocks.relic_blank"));
                event.getToolTip().add(3, Component.translatable("tooltip.gufyblocks.relic_subtitle_broken").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(4, Component.translatable("tooltip.gufyblocks.spectral_gem_instructions").withStyle(ChatFormatting.GOLD));
            }
            case GufyInsomniaFragment gufyInsomniaFragment -> {
                event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.relic_title").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(2, Component.translatable("tooltip.gufyblocks.relic_blank"));
                event.getToolTip().add(3, Component.translatable("tooltip.gufyblocks.relic_subtitle_broken").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(4, Component.translatable("tooltip.gufyblocks.insomnia_fragment_instructions").withStyle(ChatFormatting.GOLD));
            }
            case GufyBiomeSeed gufyBiomeSeed -> {
                if (itemstack.has(GufyRegistry.STORED_BIOME.get())) {
                    Identifier biomeID = itemstack.get(GufyRegistry.STORED_BIOME.get());
                    if (biomeID == null) { return; }
                    String biomeKey = "biome." + biomeID.getNamespace() + "." + biomeID.getPath();
                    event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.relic_title").withStyle(ChatFormatting.GRAY));
                    event.getToolTip().add(2, Component.translatable("tooltip.gufyblocks.relic_blank"));
                    event.getToolTip().add(3, Component.translatable("tooltip.gufyblocks.relic_subtitle_planted").withStyle(ChatFormatting.GRAY));
                    event.getToolTip().add(4, Component.translatable("tooltip.gufyblocks.biome_seed_instructions").append(Component.translatable(biomeKey)).withStyle(ChatFormatting.GOLD));
                    event.getToolTip().add(5, Component.translatable("tooltip.gufyblocks.biome_seed_instructions_2").withStyle(ChatFormatting.GOLD));
                } else {
                    event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.biome_seed_dormant").withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
                }
            }
            case GufyPhasingVial gufyPhasingVial -> {
                event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.relic_title").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(2, Component.translatable("tooltip.gufyblocks.relic_blank"));
                event.getToolTip().add(3, Component.translatable("tooltip.gufyblocks.relic_subtitle_drunk").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(4, Component.translatable("tooltip.gufyblocks.phasing_vial_instructions").withStyle(ChatFormatting.GOLD));
            }
            case GufyWhisperingCompass gufyWhisperingCompass -> {
                event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.whispering_compass_instructions").withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            }
            case GufyExperienceOrb gufyExperienceOrb -> {
                event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.relic_title").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(2, Component.translatable("tooltip.gufyblocks.relic_blank"));
                event.getToolTip().add(3, Component.translatable("tooltip.gufyblocks.relic_subtitle_broken").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(4, Component.translatable("tooltip.gufyblocks.orb_instructions").withStyle(ChatFormatting.GOLD));
            }
            case GufyTotemKeeping gufyTotemKeeping -> {
                event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.relic_title").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(2, Component.translatable("tooltip.gufyblocks.relic_blank"));
                event.getToolTip().add(3, Component.translatable("tooltip.gufyblocks.relic_subtitle_held").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(4, Component.translatable("tooltip.gufyblocks.totem_instructions").withStyle(ChatFormatting.GOLD));
            }
            case GufySoulboundAnchor gufySoulboundAnchor -> {
                event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.relic_title").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(2, Component.translatable("tooltip.gufyblocks.relic_blank"));
                event.getToolTip().add(3, Component.translatable("tooltip.gufyblocks.relic_subtitle_held").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(4, Component.translatable("tooltip.gufyblocks.soulbound_instructions").withStyle(ChatFormatting.GOLD));
                event.getToolTip().add(5, Component.translatable("tooltip.gufyblocks.soulbound_instructions_2").withStyle(ChatFormatting.GOLD));
                event.getToolTip().add(6, Component.translatable("tooltip.gufyblocks.soulbound_instructions_3").withStyle(ChatFormatting.RED).withStyle(ChatFormatting.ITALIC));
            }
            case GufyMemoryCharm gufyMemoryCharm -> {
                event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.relic_title").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(2, Component.translatable("tooltip.gufyblocks.relic_blank"));
                event.getToolTip().add(3, Component.translatable("tooltip.gufyblocks.relic_subtitle_given").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(4, Component.translatable("tooltip.gufyblocks.charm_instructions").withStyle(ChatFormatting.GOLD));
                event.getToolTip().add(5, Component.translatable("tooltip.gufyblocks.charm_instructions_2").withStyle(ChatFormatting.RED).withStyle(ChatFormatting.ITALIC));
            }
            default -> { }
        }
    }
}
