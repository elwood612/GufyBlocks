package com.github.elwood612.gufyblocks.blocks.blockUtil;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class GufyProperties {

    // ~~ WATTLE ~~ //
    public static final BlockBehaviour.Properties WATTLE = BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD)
            .sound(SoundType.WOOD)
            .strength(0.5f)
            .noOcclusion();

    // ~~ SEATS ~~ //
    public static final BlockBehaviour.Properties WHITE_SEAT = BlockBehaviour.Properties.of()
            .mapColor(MapColor.SNOW)
            .sound(SoundType.WOOD)
            .strength(0.2f)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties LIGHT_GRAY_SEAT = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_LIGHT_GRAY)
            .sound(SoundType.WOOD)
            .strength(0.2f)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties GRAY_SEAT = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_GRAY)
            .sound(SoundType.WOOD)
            .strength(0.2f)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties BLACK_SEAT = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLACK)
            .sound(SoundType.WOOD)
            .strength(0.2f)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties BROWN_SEAT = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BROWN)
            .sound(SoundType.WOOD)
            .strength(0.2f)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties RED_SEAT = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_RED)
            .sound(SoundType.WOOD)
            .strength(0.2f)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties ORANGE_SEAT = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_ORANGE)
            .sound(SoundType.WOOD)
            .strength(0.2f)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties YELLOW_SEAT = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_YELLOW)
            .sound(SoundType.WOOD)
            .strength(0.2f)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties LIME_SEAT = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_LIGHT_GREEN)
            .sound(SoundType.WOOD)
            .strength(0.2f)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties GREEN_SEAT = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_GREEN)
            .sound(SoundType.WOOD)
            .strength(0.2f)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties CYAN_SEAT = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_CYAN)
            .sound(SoundType.WOOD)
            .strength(0.2f)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties LIGHT_BLUE_SEAT = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_LIGHT_BLUE)
            .sound(SoundType.WOOD)
            .strength(0.2f)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties BLUE_SEAT = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLUE)
            .sound(SoundType.WOOD)
            .strength(0.2f)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties PURPLE_SEAT = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_PURPLE)
            .sound(SoundType.WOOD)
            .strength(0.2f)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties MAGENTA_SEAT = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_MAGENTA)
            .sound(SoundType.WOOD)
            .strength(0.2f)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties PINK_SEAT = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_PINK)
            .sound(SoundType.WOOD)
            .strength(0.2f)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);

    // ~~ GLASS ~~ //
    public static final BlockBehaviour.Properties OAK_FRAMED_GLASS = BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD)
            .sound(SoundType.GLASS)
            .strength(0.3f)
            .noOcclusion();
    public static final BlockBehaviour.Properties SPRUCE_FRAMED_GLASS = BlockBehaviour.Properties.of()
            .mapColor(MapColor.PODZOL)
            .sound(SoundType.GLASS)
            .strength(0.3f)
            .noOcclusion();
    public static final BlockBehaviour.Properties BIRCH_FRAMED_GLASS = BlockBehaviour.Properties.of()
            .mapColor(MapColor.SAND)
            .sound(SoundType.GLASS)
            .strength(0.3f)
            .noOcclusion();
    public static final BlockBehaviour.Properties DARK_OAK_FRAMED_GLASS = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BROWN)
            .sound(SoundType.GLASS)
            .strength(0.3f)
            .noOcclusion();
    public static final BlockBehaviour.Properties JUNGLE_FRAMED_GLASS = BlockBehaviour.Properties.of()
            .mapColor(MapColor.DIRT)
            .sound(SoundType.GLASS)
            .strength(0.3f)
            .noOcclusion();
    public static final BlockBehaviour.Properties ACACIA_FRAMED_GLASS = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_ORANGE)
            .sound(SoundType.GLASS)
            .strength(0.3f)
            .noOcclusion();
    public static final BlockBehaviour.Properties MANGROVE_FRAMED_GLASS = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_RED)
            .sound(SoundType.GLASS)
            .strength(0.3f)
            .noOcclusion();
    public static final BlockBehaviour.Properties CHERRY_FRAMED_GLASS = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_PINK)
            .sound(SoundType.GLASS)
            .strength(0.3f)
            .noOcclusion();
    public static final BlockBehaviour.Properties PALE_OAK_FRAMED_GLASS = BlockBehaviour.Properties.of()
            .mapColor(MapColor.QUARTZ)
            .sound(SoundType.GLASS)
            .strength(0.3f)
            .noOcclusion();
    public static final BlockBehaviour.Properties BAMBOO_FRAMED_GLASS = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_YELLOW)
            .sound(SoundType.GLASS)
            .strength(0.3f)
            .noOcclusion();
    public static final BlockBehaviour.Properties CRIMSON_FRAMED_GLASS = BlockBehaviour.Properties.of()
            .mapColor(MapColor.CRIMSON_STEM)
            .sound(SoundType.GLASS)
            .strength(0.3f)
            .noOcclusion();
    public static final BlockBehaviour.Properties WARPED_FRAMED_GLASS = BlockBehaviour.Properties.of()
            .mapColor(MapColor.WARPED_STEM)
            .sound(SoundType.GLASS)
            .strength(0.3f)
            .noOcclusion();

    public static final BlockBehaviour.Properties LEADED_GLASS = BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE)
            .sound(SoundType.GLASS)
            .strength(0.3f, 3.0f)
            .noOcclusion();

    // ~~ TERRACOTTA ~~ //
    public static final BlockBehaviour.Properties WHITE_FRAMED_TERRACOTTA = BlockBehaviour.Properties.of()
            .mapColor(MapColor.TERRACOTTA_WHITE)
            .sound(SoundType.STONE)
            .strength(2.0f, 6.0f)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops();
}
