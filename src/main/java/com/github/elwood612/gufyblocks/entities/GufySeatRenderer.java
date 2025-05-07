package com.github.elwood612.gufyblocks.entities;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class GufySeatRenderer extends EntityRenderer<GufySeatEntity, GufySeatEntityRenderState>
{
    public GufySeatRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public GufySeatEntityRenderState createRenderState() { return new GufySeatEntityRenderState(); }

//    @NotNull
//    public ResourceLocation getTextureLocation(GufySeatEntityRenderState renderState) {
//        return null;
//    }
}
