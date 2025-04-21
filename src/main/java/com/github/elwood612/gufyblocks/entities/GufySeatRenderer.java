package com.github.elwood612.gufyblocks.entities;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GufySeatRenderer extends EntityRenderer<GufySeatEntity, GufySeatEntityRenderState>
{
    public GufySeatRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public GufySeatEntityRenderState createRenderState() { return null; }

//    @NotNull
//    @Override
//    public ResourceLocation getTextureLocation(@NotNull GufySeatEntity entity) {
//        return null;
//    }
}
