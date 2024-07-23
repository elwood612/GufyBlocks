package com.github.elwood612.gufyblocks.entities;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class GufySeatRenderer extends EntityRenderer<GufySeatEntity>
{
    public GufySeatRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @NotNull
    @Override
    public ResourceLocation getTextureLocation(@NotNull GufySeatEntity entity) {
        return null;
    }
}
