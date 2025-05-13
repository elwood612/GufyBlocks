package com.github.elwood612.gufyblocks.blocks.blockUtil;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import static com.github.elwood612.gufyblocks.util.GufyUtil.copyPropertiesOf;

public class GufyProperties {

    public static final BlockBehaviour.Properties WATTLE = copyPropertiesOf(Blocks.OAK_FENCE).strength(0.5f);
    public static final BlockBehaviour.Properties STONE_TRAPDOOR = copyPropertiesOf(Blocks.STONE).noOcclusion();
    public static final BlockBehaviour.Properties OAK_FRAMED_GLASS = copyPropertiesOf(Blocks.GLASS_PANE).mapColor(MapColor.WOOD);
    public static final BlockBehaviour.Properties SPRUCE_FRAMED_GLASS = copyPropertiesOf(Blocks.GLASS_PANE).mapColor(MapColor.PODZOL);
    public static final BlockBehaviour.Properties BIRCH_FRAMED_GLASS = copyPropertiesOf(Blocks.GLASS_PANE).mapColor(MapColor.SAND);
    public static final BlockBehaviour.Properties DARK_OAK_FRAMED_GLASS = copyPropertiesOf(Blocks.GLASS_PANE).mapColor(MapColor.COLOR_BROWN);
    public static final BlockBehaviour.Properties JUNGLE_FRAMED_GLASS = copyPropertiesOf(Blocks.GLASS_PANE).mapColor(MapColor.DIRT);
    public static final BlockBehaviour.Properties ACACIA_FRAMED_GLASS = copyPropertiesOf(Blocks.GLASS_PANE).mapColor(MapColor.COLOR_ORANGE);
    public static final BlockBehaviour.Properties MANGROVE_FRAMED_GLASS = copyPropertiesOf(Blocks.GLASS_PANE).mapColor(MapColor.COLOR_RED);
    public static final BlockBehaviour.Properties CHERRY_FRAMED_GLASS = copyPropertiesOf(Blocks.GLASS_PANE).mapColor(MapColor.COLOR_PINK);
    public static final BlockBehaviour.Properties PALE_OAK_FRAMED_GLASS = copyPropertiesOf(Blocks.GLASS_PANE).mapColor(MapColor.QUARTZ);
    public static final BlockBehaviour.Properties BAMBOO_FRAMED_GLASS = copyPropertiesOf(Blocks.GLASS_PANE).mapColor(MapColor.COLOR_YELLOW);
    public static final BlockBehaviour.Properties CRIMSON_FRAMED_GLASS = copyPropertiesOf(Blocks.GLASS_PANE).mapColor(MapColor.CRIMSON_STEM);
    public static final BlockBehaviour.Properties WARPED_FRAMED_GLASS = copyPropertiesOf(Blocks.GLASS_PANE).mapColor(MapColor.WARPED_STEM);
    public static final BlockBehaviour.Properties MUSHROOM_FRAMED_GLASS = copyPropertiesOf(Blocks.GLASS_PANE).mapColor(MapColor.DIRT);
    public static final BlockBehaviour.Properties LEADED_GLASS = copyPropertiesOf(Blocks.GLASS_PANE).mapColor(MapColor.STONE).strength(0.3f, 3.0f);
    public static final BlockBehaviour.Properties WHITE_FRAMED_TERRACOTTA = copyPropertiesOf(Blocks.WHITE_TERRACOTTA).strength(2.0f, 6.0f);
    public static final BlockBehaviour.Properties WOODEN_SEAT = copyPropertiesOf(Blocks.WHITE_BED).mapColor(MapColor.WOOD);

}
