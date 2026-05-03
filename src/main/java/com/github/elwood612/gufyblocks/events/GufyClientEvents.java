package com.github.elwood612.gufyblocks.events;

import com.github.elwood612.gufyblocks.GufyBlocks;
import com.github.elwood612.gufyblocks.GufyRegistry;
import com.github.elwood612.gufyblocks.items.*;
import com.github.elwood612.gufyblocks.util.*;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(modid = GufyBlocks.MODID, value = Dist.CLIENT)
public class GufyClientEvents
{
    private static final Identifier OVERLAY = Identifier.fromNamespaceAndPath(GufyBlocks.MODID, "textures/misc/monocle_overlay.png");

    // Client setup
    @SubscribeEvent
    public static void onClientSetup(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(GufyRegistry.MONOCLE_PARTICLE.get(), GufyParticleProvider::new);
    }

    // Render black & white shader while holding monocle
    @SubscribeEvent
    public static void onRenderLevel(RenderLevelStageEvent.AfterTranslucentBlocks event) {
        Minecraft mc = Minecraft.getInstance();
        GameRenderer renderer = mc.gameRenderer;
        Player player = mc.player;

        // this works fine
        if (player != null && player.isUsingItem() && player.getUseItem().is(GufyRegistry.MONOCLE) && mc.options.getCameraType().isFirstPerson()) {
//            renderer.setPostEffect(Identifier.fromNamespaceAndPath("gufyblocks", "monocle_vision"));
        } else {
//            renderer.clearPostEffect();
        }
    }

    @SubscribeEvent
    public static void onAfterParticles(RenderLevelStageEvent.AfterParticles event) {
        Minecraft mc = Minecraft.getInstance();
        GameRenderer renderer = mc.gameRenderer;
        Player player = mc.player;

        if (player != null && player.isUsingItem() && player.getUseItem().is(GufyRegistry.MONOCLE) && mc.options.getCameraType().isFirstPerson()) {
            // render custom pass particles here
        }
    }

    // Adds model properties to alter appearance of certain items
    @SubscribeEvent
    public static void registerConditionalProperties(RegisterConditionalItemModelPropertyEvent event) {
        event.register(Identifier.fromNamespaceAndPath(GufyBlocks.MODID, "has_owner"), GufyOwnership.MAP_CODEC);
        event.register(Identifier.fromNamespaceAndPath(GufyBlocks.MODID, "has_stored_biome"), GufyStoredBiome.MAP_CODEC);
    }

    // Detect using the monocle
    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) return;
        Level level = player.level();
        GufyMonocleParticles.showLightLevelParticles(level, player);
//        GufyMonocleParticles.highlightNearbyMobs(level, player);
    }

    // Render the GUI overlay for the monocle
    @SubscribeEvent
    public static void onGuiRender(RenderGuiLayerEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;

        if (player != null && player.isUsingItem() && player.getUseItem().is(GufyRegistry.MONOCLE) && mc.options.getCameraType().isFirstPerson()) {
            GuiGraphics gui = event.getGuiGraphics();
            float scale = 1.25f;
            int width = event.getGuiGraphics().guiWidth();
            int height = event.getGuiGraphics().guiHeight();
            int size = (int) (Math.min(width, height) * scale);
            int x0 = (width - size) / 2;
            int y0 = (height - size) / 2;
            int x1 = x0 + size;
            int y1 = y0 + size;
            int black = 0xFF000000;


            gui.fill(0, 0, x0, height, black);
            gui.fill(x1, 0, width, height, black);
            gui.fill(x0, 0, x1, y0, black);
            gui.fill(x0, y1, x1, height, black);

            gui.blit(OVERLAY, x0, y0, x0 + size, y0 + size, 0f, 1f, 0f, 1f);
        }
    }

    // Hide player's hands when holding the monocle
    @SubscribeEvent
    public static void onRenderHand(RenderHandEvent event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;

        if (player != null && player.isUsingItem() && player.getUseItem().is(GufyRegistry.MONOCLE) && mc.options.getCameraType().isFirstPerson()) {
            event.setCanceled(true);
        }
    }

//    @SubscribeEvent
//    public static void onRenderLiving(RenderLivingEvent.Post<?, ?> event) {
//        if (GufyMonocleParticles.HIGHLIGHTED.contains(event.getEntity().getUUID())) {
//
//            // render your own outline layer OR reuse outline buffer
//            event.getRenderer().render(
//                    event.getEntity(),
//                    event.getEntity().getYRot(),
//                    event.getPartialTick(),
//                    event.getPoseStack(),
//                    event.getMultiBufferSource(),
//                    event.getPackedLight()
//            );
//        }
//    }

    // Adds tooltips to relics
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
                    event.getToolTip().add(6, Component.translatable("tooltip.gufyblocks.relic_blank"));
                    event.getToolTip().add(7, Component.translatable("tooltip.gufyblocks.anchor_instructions_3").withStyle(ChatFormatting.GRAY));
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
                event.getToolTip().add(5, Component.translatable("tooltip.gufyblocks.relic_blank"));
                event.getToolTip().add(6, Component.translatable("tooltip.gufyblocks.spectral_gem_instructions_2").withStyle(ChatFormatting.GRAY));
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
                event.getToolTip().add(3, Component.translatable("tooltip.gufyblocks.relic_subtitle_broken").withStyle(ChatFormatting.GRAY));
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
            case GufyHammer gufyHammer -> {
                event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.hammer_instructions").withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            }
            case GufyMossClump gufyMossClump -> {
                event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.moss_instructions").withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            }
            case GufyPotentSpectralShard gufyPotentSpectralShard -> {
                event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.relic_title").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(2, Component.translatable("tooltip.gufyblocks.relic_blank"));
                event.getToolTip().add(3, Component.translatable("tooltip.gufyblocks.relic_subtitle_held").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(4, Component.translatable("tooltip.gufyblocks.potent_instructions").withStyle(ChatFormatting.GOLD));
                event.getToolTip().add(5, Component.translatable("tooltip.gufyblocks.potent_instructions_2").withStyle(ChatFormatting.GOLD));
            }
            case GufyStillstone gufyStillstone -> {
                event.getToolTip().add(1, Component.translatable("tooltip.gufyblocks.relic_title").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(2, Component.translatable("tooltip.gufyblocks.relic_blank"));
                event.getToolTip().add(3, Component.translatable("tooltip.gufyblocks.relic_subtitle_used").withStyle(ChatFormatting.GRAY));
                event.getToolTip().add(4, Component.translatable("tooltip.gufyblocks.stillstone_instructions").withStyle(ChatFormatting.GOLD));
                event.getToolTip().add(5, Component.translatable("tooltip.gufyblocks.relic_blank"));
                event.getToolTip().add(6, Component.translatable("tooltip.gufyblocks.spectral_gem_instructions_2").withStyle(ChatFormatting.GRAY));
            }
            default -> { }
        }
    }
}
