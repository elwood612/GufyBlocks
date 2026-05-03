package com.github.elwood612.gufyblocks.util;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class GufyMonocleCustomParticle extends SingleQuadParticle
{
    public GufyMonocleCustomParticle(ClientLevel level, double x, double y, double z, TextureAtlasSprite sprite) {
        super(level, x, y, z, sprite);
        this.setSprite(sprite);

        this.xd = xd * 0.1;
        this.yd = yd * 0.1 + 0.01; // slight upward drift
        this.zd = zd * 0.1;

        this.lifetime = 40 + this.random.nextInt(20); // 2–3 seconds
        this.gravity = 0f;

        this.quadSize *= 0.8f;

        // red
        this.rCol = 1f;
        this.gCol = 0f;
        this.bCol = 0f;
    }

    @Override
    public void tick() {
        super.tick();

        // gentle drift like mycelium
        this.xd *= 0.98;
        this.yd *= 0.98;
        this.zd *= 0.98;
    }

    @Override
    protected SingleQuadParticle.Layer getLayer()
    {
        return Layer.TRANSLUCENT;
    }

    @Override
    public int getLightColor(float partialTick) {
        return 0xF000F0; // fullbright
    }
}
