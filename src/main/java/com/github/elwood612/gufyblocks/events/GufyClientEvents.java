package com.github.elwood612.gufyblocks.events;

import com.github.elwood612.gufyblocks.GufyBlocks;
import com.github.elwood612.gufyblocks.GufyRegistry;
import com.github.elwood612.gufyblocks.items.GufyAnchor;
import com.github.elwood612.gufyblocks.util.GufyOwnership;
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
    }

    // Adds a tooltip to anchors based on ownership
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack itemstack = event.getItemStack();

        if (itemstack.getItem() instanceof GufyAnchor) {
            if (itemstack.has(GufyRegistry.OWNER.get())) {
                String owner = itemstack.getOrDefault(GufyRegistry.OWNER.get(), "");
                event.getToolTip().add(1,
                        Component.translatable("tooltip.gufyblocks.one_time_use")
                                .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC)
                );
                event.getToolTip().add(2,
                        Component.translatable("tooltip.gufyblocks.instructions")
                                .append(Component.literal(owner))
                                .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC)
                );
            } else {
                event.getToolTip().add(1,
                        Component.translatable("tooltip.gufyblocks.empty_anchor")
                                .withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC)
                );
            }
        }
    }
}
