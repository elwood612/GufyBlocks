package com.github.elwood612.gufyblocks.blocks.blockUtil;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.material.MapColor;

import java.util.HashMap;

public class GufyColorMap {
    public static final HashMap<GufyColors, MapColor> WOOL_COLOR_MAP = new HashMap<>();
    public static final HashMap<GufyColors, MapColor> TERRACOTTA_COLOR_MAP = new HashMap<>();
    public static final HashMap<GufyColors, DyeColor> CONCRETE_COLOR_MAP = new HashMap<>();
    static {
        WOOL_COLOR_MAP.put(GufyColors.white, MapColor.SNOW);
        WOOL_COLOR_MAP.put(GufyColors.gray, MapColor.COLOR_GRAY);
        WOOL_COLOR_MAP.put(GufyColors.light_gray, MapColor.COLOR_LIGHT_GRAY);
        WOOL_COLOR_MAP.put(GufyColors.black, MapColor.COLOR_BLACK);
        WOOL_COLOR_MAP.put(GufyColors.brown, MapColor.COLOR_BROWN);
        WOOL_COLOR_MAP.put(GufyColors.red, MapColor.COLOR_RED);
        WOOL_COLOR_MAP.put(GufyColors.orange, MapColor.COLOR_ORANGE);
        WOOL_COLOR_MAP.put(GufyColors.yellow, MapColor.COLOR_YELLOW);
        WOOL_COLOR_MAP.put(GufyColors.lime, MapColor.COLOR_LIGHT_GREEN);
        WOOL_COLOR_MAP.put(GufyColors.green, MapColor.COLOR_GREEN);
        WOOL_COLOR_MAP.put(GufyColors.cyan, MapColor.COLOR_CYAN);
        WOOL_COLOR_MAP.put(GufyColors.light_blue, MapColor.COLOR_LIGHT_BLUE);
        WOOL_COLOR_MAP.put(GufyColors.blue, MapColor.COLOR_BLUE);
        WOOL_COLOR_MAP.put(GufyColors.purple, MapColor.COLOR_PURPLE);
        WOOL_COLOR_MAP.put(GufyColors.magenta, MapColor.COLOR_MAGENTA);
        WOOL_COLOR_MAP.put(GufyColors.pink, MapColor.COLOR_PINK);

        TERRACOTTA_COLOR_MAP.put(GufyColors.white, MapColor.TERRACOTTA_WHITE);
        TERRACOTTA_COLOR_MAP.put(GufyColors.gray, MapColor.TERRACOTTA_GRAY);
        TERRACOTTA_COLOR_MAP.put(GufyColors.light_gray, MapColor.TERRACOTTA_LIGHT_GRAY);
        TERRACOTTA_COLOR_MAP.put(GufyColors.black, MapColor.TERRACOTTA_BLACK);
        TERRACOTTA_COLOR_MAP.put(GufyColors.brown, MapColor.TERRACOTTA_BROWN);
        TERRACOTTA_COLOR_MAP.put(GufyColors.red, MapColor.TERRACOTTA_RED);
        TERRACOTTA_COLOR_MAP.put(GufyColors.orange, MapColor.TERRACOTTA_ORANGE);
        TERRACOTTA_COLOR_MAP.put(GufyColors.yellow, MapColor.TERRACOTTA_YELLOW);
        TERRACOTTA_COLOR_MAP.put(GufyColors.lime, MapColor.TERRACOTTA_LIGHT_GREEN);
        TERRACOTTA_COLOR_MAP.put(GufyColors.green, MapColor.TERRACOTTA_GREEN);
        TERRACOTTA_COLOR_MAP.put(GufyColors.cyan, MapColor.TERRACOTTA_CYAN);
        TERRACOTTA_COLOR_MAP.put(GufyColors.light_blue, MapColor.TERRACOTTA_LIGHT_BLUE);
        TERRACOTTA_COLOR_MAP.put(GufyColors.blue, MapColor.TERRACOTTA_BLUE);
        TERRACOTTA_COLOR_MAP.put(GufyColors.purple, MapColor.TERRACOTTA_PURPLE);
        TERRACOTTA_COLOR_MAP.put(GufyColors.magenta, MapColor.TERRACOTTA_MAGENTA);
        TERRACOTTA_COLOR_MAP.put(GufyColors.pink, MapColor.TERRACOTTA_PINK);

        CONCRETE_COLOR_MAP.put(GufyColors.white, DyeColor.WHITE);
        CONCRETE_COLOR_MAP.put(GufyColors.gray, DyeColor.GRAY);
        CONCRETE_COLOR_MAP.put(GufyColors.light_gray, DyeColor.LIGHT_GRAY);
        CONCRETE_COLOR_MAP.put(GufyColors.black, DyeColor.BLACK);
        CONCRETE_COLOR_MAP.put(GufyColors.brown, DyeColor.BROWN);
        CONCRETE_COLOR_MAP.put(GufyColors.red, DyeColor.RED);
        CONCRETE_COLOR_MAP.put(GufyColors.orange, DyeColor.ORANGE);
        CONCRETE_COLOR_MAP.put(GufyColors.yellow, DyeColor.YELLOW);
        CONCRETE_COLOR_MAP.put(GufyColors.lime, DyeColor.LIME);
        CONCRETE_COLOR_MAP.put(GufyColors.green, DyeColor.GREEN);
        CONCRETE_COLOR_MAP.put(GufyColors.cyan, DyeColor.CYAN);
        CONCRETE_COLOR_MAP.put(GufyColors.light_blue, DyeColor.LIGHT_BLUE);
        CONCRETE_COLOR_MAP.put(GufyColors.blue, DyeColor.BLUE);
        CONCRETE_COLOR_MAP.put(GufyColors.purple, DyeColor.PURPLE);
        CONCRETE_COLOR_MAP.put(GufyColors.magenta, DyeColor.MAGENTA);
        CONCRETE_COLOR_MAP.put(GufyColors.pink, DyeColor.PINK);
    }
}
