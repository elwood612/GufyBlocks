package com.github.elwood612.gufyblocks.util;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;

public class GufyHighlightRenderer
{
    public static BlockPos pos;
    public static long endTick;

    public static void highlight(BlockPos blockPos) {
        Minecraft mc = Minecraft.getInstance();
        pos = blockPos;
        endTick = mc.level.getGameTime() + 100;
    }
}
