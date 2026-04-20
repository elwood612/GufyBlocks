package com.github.elwood612.gufyblocks.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import java.util.Optional;

public record GufyCompassData(
        BlockPos lastSuccessfulSearchPos,
        ResourceKey<Level> lastSuccessfulSearchDimension,
        GlobalPos lastSuccessfulTarget
)
{
    public static final Codec<GufyCompassData> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    BlockPos.CODEC.optionalFieldOf("last_search_pos").forGetter(d -> Optional.ofNullable(d.lastSuccessfulSearchPos())),
                    Level.RESOURCE_KEY_CODEC.optionalFieldOf("last_search_dimension").forGetter(d -> Optional.ofNullable(d.lastSuccessfulSearchDimension())),
                    GlobalPos.CODEC.optionalFieldOf("last_target").forGetter(d -> Optional.ofNullable(d.lastSuccessfulTarget()))
            ).apply(instance, (pos, dim, target) ->
                    new GufyCompassData(
                            pos.orElse(null),
                            dim.orElse(null),
                            target.orElse(null)
                    )
            )
    );
}
