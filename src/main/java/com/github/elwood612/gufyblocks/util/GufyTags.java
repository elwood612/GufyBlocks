package com.github.elwood612.gufyblocks.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public class GufyTags
{
    public static final TagKey<Structure> ALL_COMPASS_TARGETS =
            TagKey.create(Registries.STRUCTURE, Identifier.fromNamespaceAndPath("gufyblocks", "compass_targets"));
}
