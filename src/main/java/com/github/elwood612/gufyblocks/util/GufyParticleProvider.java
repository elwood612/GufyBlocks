package com.github.elwood612.gufyblocks.util;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import org.jspecify.annotations.Nullable;

public class GufyParticleProvider implements ParticleProvider<SimpleParticleType>
{
    private final SpriteSet sprites;

    public GufyParticleProvider(SpriteSet sprites) {
        this.sprites = sprites;
    }

    @Override
    public @Nullable Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel,
                                             double v, double v1, double v2,
                                             double v3, double v4, double v5,
                                             RandomSource randomSource) {
        TextureAtlasSprite sprite = sprites.get(randomSource);
        return new GufyMonocleCustomParticle(clientLevel, v, v1, v2, sprite);
    }
}
