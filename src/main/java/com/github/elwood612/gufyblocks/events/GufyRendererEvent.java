package com.github.elwood612.gufyblocks.events;

import com.github.elwood612.gufyblocks.GufyRegistry;
import com.github.elwood612.gufyblocks.entities.GufySeatRenderer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class GufyRendererEvent
{
    @SubscribeEvent
    public void onRegisterRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(GufyRegistry.SEAT.get(), GufySeatRenderer::new);
    }
}
