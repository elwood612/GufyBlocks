package com.github.elwood612.gufyblocks.events;

import com.github.elwood612.gufyblocks.GufyBlocks;
import com.github.elwood612.gufyblocks.util.GufyOwnership;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterConditionalItemModelPropertyEvent;

@EventBusSubscriber(modid = GufyBlocks.MODID)
public class GufyClientEvents
{
    @SubscribeEvent // on the mod event bus only on the physical client
    public static void registerConditionalProperties(RegisterConditionalItemModelPropertyEvent event) {
        event.register(
                Identifier.fromNamespaceAndPath(GufyBlocks.MODID, "has_owner"),
                GufyOwnership.MAP_CODEC
        );
    }
}
