package elwood612.gufyblocks.blocks.blockUtil;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public enum GufyMaterials 
{
	//Create Materials in here
	//Copy values from Blocks.class
	STONE(Material.STONE, MaterialColor.STONE, SoundType.STONE, 1.5F, 6.0F, true, true),
	STONE_TRAPDOOR(Material.METAL, MaterialColor.STONE, SoundType.STONE, 1.5F, 6.0F, true, false),
	COBBLESTONE(Material.STONE, MaterialColor.STONE, SoundType.STONE, 2.0F, 6.0F, true, true),
	DIORITE(Material.STONE, MaterialColor.QUARTZ, SoundType.STONE, 1.5F, 6.0F, true, true),
	DIORITE_TRAPDOOR(Material.METAL, MaterialColor.QUARTZ, SoundType.STONE, 1.5F, 6.0F, true, false),
	DIORITE_COBBLE(Material.STONE, MaterialColor.QUARTZ, SoundType.STONE, 2.0F, 6.0F, true, true),
	GRANITE(Material.STONE, MaterialColor.DIRT, SoundType.STONE, 1.5F, 6.0F, true, true),
	GRANITE_TRAPDOOR(Material.METAL, MaterialColor.DIRT, SoundType.STONE, 1.5F, 6.0F, true, false),
	GRANITE_COBBLE(Material.STONE, MaterialColor.DIRT, SoundType.STONE, 2.0F, 6.0F, true, true),
	ANDESITE(Material.STONE, MaterialColor.DIRT, SoundType.STONE, 1.5F, 6.0F, true, true),
	ANDESITE_TRAPDOOR(Material.METAL, MaterialColor.DIRT, SoundType.STONE, 1.5F, 6.0F, true, false),
	CALCITE(Material.STONE, MaterialColor.TERRACOTTA_WHITE, SoundType.STONE, 0.75F, 0.75F, true, true),
	BASALT(Material.STONE, MaterialColor.COLOR_BLACK, SoundType.BASALT, 1.25F, 4.2F, true, true),
	THATCH(Material.GRASS, MaterialColor.TERRACOTTA_YELLOW, SoundType.GRASS, 0.5F, 0.5F, false, true),
	MOSS(Material.MOSS, MaterialColor.COLOR_GREEN, SoundType.MOSS, 0.1F, 0.1F, false, true),
	TERRACOTTA(Material.STONE, MaterialColor.COLOR_ORANGE, SoundType.STONE, 1.25F, 4.2F, true, true),
	WHITE_TERRACOTTA(Material.STONE, MaterialColor.TERRACOTTA_WHITE, SoundType.STONE, 1.25F, 4.2F, true, true),
	LIGHT_GRAY_TERRACOTTA(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY, SoundType.STONE, 1.25F, 4.2F, true, true),
	GRAY_TERRACOTTA(Material.STONE, MaterialColor.TERRACOTTA_GRAY, SoundType.STONE, 1.25F, 4.2F, true, true),
	BLACK_TERRACOTTA(Material.STONE, MaterialColor.TERRACOTTA_BLACK, SoundType.STONE, 1.25F, 4.2F, true, true),
	BROWN_TERRACOTTA(Material.STONE, MaterialColor.TERRACOTTA_BROWN, SoundType.STONE, 1.25F, 4.2F, true, true),
	RED_TERRACOTTA(Material.STONE, MaterialColor.TERRACOTTA_RED, SoundType.STONE, 1.25F, 4.2F, true, true),
	ORANGE_TERRACOTTA(Material.STONE, MaterialColor.TERRACOTTA_ORANGE, SoundType.STONE, 1.25F, 4.2F, true, true),
	YELLOW_TERRACOTTA(Material.STONE, MaterialColor.TERRACOTTA_YELLOW, SoundType.STONE, 1.25F, 4.2F, true, true),
	LIME_TERRACOTTA(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GREEN, SoundType.STONE, 1.25F, 4.2F, true, true),
	GREEN_TERRACOTTA(Material.STONE, MaterialColor.TERRACOTTA_GREEN, SoundType.STONE, 1.25F, 4.2F, true, true),
	CYAN_TERRACOTTA(Material.STONE, MaterialColor.TERRACOTTA_CYAN, SoundType.STONE, 1.25F, 4.2F, true, true),
	LIGHT_BLUE_TERRACOTTA(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_BLUE, SoundType.STONE, 1.25F, 4.2F, true, true),
	BLUE_TERRACOTTA(Material.STONE, MaterialColor.TERRACOTTA_BLUE, SoundType.STONE, 1.25F, 4.2F, true, true),
	PURPLE_TERRACOTTA(Material.STONE, MaterialColor.TERRACOTTA_PURPLE, SoundType.STONE, 1.25F, 4.2F, true, true),
	MAGENTA_TERRACOTTA(Material.STONE, MaterialColor.TERRACOTTA_MAGENTA, SoundType.STONE, 1.25F, 4.2F, true, true),
	PINK_TERRACOTTA(Material.STONE, MaterialColor.TERRACOTTA_PINK, SoundType.STONE, 1.25F, 4.2F, true, true),
	WHITE_CONCRETE(Material.STONE, MaterialColor.SNOW, SoundType.STONE, 1.8F, 1.8F, true, true),
	LIGHT_GRAY_CONCRETE(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY, SoundType.STONE, 1.8F, 1.8F, true, true),
	GRAY_CONCRETE(Material.STONE, MaterialColor.COLOR_GRAY, SoundType.STONE, 1.8F, 1.8F, true, true),
	BLACK_CONCRETE(Material.STONE, MaterialColor.COLOR_BLACK, SoundType.STONE, 1.8F, 1.8F, true, true),
	BROWN_CONCRETE(Material.STONE, MaterialColor.COLOR_BROWN, SoundType.STONE, 1.8F, 1.8F, true, true),
	RED_CONCRETE(Material.STONE, MaterialColor.COLOR_RED, SoundType.STONE, 1.8F, 1.8F, true, true),
	ORANGE_CONCRETE(Material.STONE, MaterialColor.COLOR_ORANGE, SoundType.STONE, 1.8F, 1.8F, true, true),
	YELLOW_CONCRETE(Material.STONE, MaterialColor.COLOR_YELLOW, SoundType.STONE, 1.8F, 1.8F, true, true),
	LIME_CONCRETE(Material.STONE, MaterialColor.COLOR_LIGHT_GREEN, SoundType.STONE, 1.8F, 1.8F, true, true),
	GREEN_CONCRETE(Material.STONE, MaterialColor.COLOR_GREEN, SoundType.STONE, 1.8F, 1.8F, true, true),
	CYAN_CONCRETE(Material.STONE, MaterialColor.COLOR_CYAN, SoundType.STONE, 1.8F, 1.8F, true, true),
	LIGHT_BLUE_CONCRETE(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE, SoundType.STONE, 1.8F, 1.8F, true, true),
	BLUE_CONCRETE(Material.STONE, MaterialColor.COLOR_BLUE, SoundType.STONE, 1.8F, 1.8F, true, true),
	PURPLE_CONCRETE(Material.STONE, MaterialColor.COLOR_PURPLE, SoundType.STONE, 1.8F, 1.8F, true, true),
	MAGENTA_CONCRETE(Material.STONE, MaterialColor.COLOR_MAGENTA, SoundType.STONE, 1.8F, 1.8F, true, true),
	PINK_CONCRETE(Material.STONE, MaterialColor.COLOR_PINK, SoundType.STONE, 1.8F, 1.8F, true, true),
	WHITE_WOOL(Material.WOOL, MaterialColor.SNOW, SoundType.WOOL, 0.8F, 0.8F, false, true),
	LIGHT_GRAY_WOOL(Material.WOOL, MaterialColor.COLOR_LIGHT_GRAY, SoundType.WOOL, 0.8F, 0.8F, false, true),
	GRAY_WOOL(Material.WOOL, MaterialColor.COLOR_GRAY, SoundType.WOOL, 0.8F, 0.8F, false, true),
	BLACK_WOOL(Material.WOOL, MaterialColor.COLOR_BLACK, SoundType.WOOL, 0.8F, 0.8F, false, true),
	BROWN_WOOL(Material.WOOL, MaterialColor.COLOR_BROWN, SoundType.WOOL, 0.8F, 0.8F, false, true),
	RED_WOOL(Material.WOOL, MaterialColor.COLOR_RED, SoundType.WOOL, 0.8F, 0.8F, false, true),
	ORANGE_WOOL(Material.WOOL, MaterialColor.COLOR_ORANGE, SoundType.WOOL, 0.8F, 0.8F, false, true),
	YELLOW_WOOL(Material.WOOL, MaterialColor.COLOR_YELLOW, SoundType.WOOL, 0.8F, 0.8F, false, true),
	LIME_WOOL(Material.WOOL, MaterialColor.COLOR_LIGHT_GREEN, SoundType.WOOL, 0.8F, 0.8F, false, true),
	GREEN_WOOL(Material.WOOL, MaterialColor.COLOR_GREEN, SoundType.WOOL, 0.8F, 0.8F, false, true),
	CYAN_WOOL(Material.WOOL, MaterialColor.COLOR_CYAN, SoundType.WOOL, 0.8F, 0.8F, false, true),
	LIGHT_BLUE_WOOL(Material.WOOL, MaterialColor.COLOR_LIGHT_BLUE, SoundType.WOOL, 0.8F, 0.8F, false, true),
	BLUE_WOOL(Material.WOOL, MaterialColor.COLOR_BLUE, SoundType.WOOL, 0.8F, 0.8F, false, true),
	PURPLE_WOOL(Material.WOOL, MaterialColor.COLOR_PURPLE, SoundType.WOOL, 0.8F, 0.8F, false, true),
	MAGENTA_WOOL(Material.WOOL, MaterialColor.COLOR_MAGENTA, SoundType.WOOL, 0.8F, 0.8F, false, true),
	PINK_WOOL(Material.WOOL, MaterialColor.COLOR_PINK, SoundType.WOOL, 0.8F, 0.8F, false, true),
	OAK(Material.WOOD, MaterialColor.WOOD, SoundType.WOOD, 2.0F, 3.0F, false, true),
	SPRUCE(Material.WOOD, MaterialColor.PODZOL, SoundType.WOOD, 2.0F, 3.0F, false, true),
	SPRUCE_TRAPDOOR(Material.WOOD, MaterialColor.PODZOL, SoundType.WOOD, 2.0F, 3.0F, false, false),
	BIRCH(Material.WOOD, MaterialColor.SAND, SoundType.WOOD, 2.0F, 3.0F, false, true),
	JUNGLE(Material.WOOD, MaterialColor.DIRT, SoundType.WOOD, 2.0F, 3.0F, false, true),
	DARK_OAK(Material.WOOD, MaterialColor.COLOR_BROWN, SoundType.WOOD, 2.0F, 3.0F, false, true),
	ACACIA(Material.WOOD, MaterialColor.COLOR_ORANGE, SoundType.WOOD, 2.0F, 3.0F, false, true),
	CRIMSON(Material.NETHER_WOOD, MaterialColor.CRIMSON_STEM, SoundType.WOOD, 2.0F, 3.0F, false, true),
	WARPED(Material.NETHER_WOOD, MaterialColor.WARPED_STEM, SoundType.WOOD, 2.0F, 3.0F, false, true),
	NETHER_WART(Material.GRASS, MaterialColor.COLOR_RED, SoundType.WART_BLOCK, 1.0F, 1.0F, false, true),
	WARPED_WART(Material.GRASS, MaterialColor.WARPED_WART_BLOCK, SoundType.WART_BLOCK, 1.0F, 1.0F, false, true),
	NETHER_BRICKS(Material.STONE, MaterialColor.NETHER, SoundType.NETHER_BRICKS, 2.0F, 6.0F, true, true),
	WATTLE(Material.WOOD, MaterialColor.WOOD, SoundType.WOOD, 0.5F, 0.5F, false, false),
	DIRT(Material.DIRT, MaterialColor.DIRT, SoundType.GRAVEL, 0.5F, 0.5F, false, true),
	ROOTED_DIRT(Material.DIRT, MaterialColor.DIRT, SoundType.ROOTED_DIRT, 0.5F, 0.5F, false, true),
	FRAMED_WHITE(Material.STONE, MaterialColor.TERRACOTTA_WHITE, SoundType.STONE, 2.0F, 6.0F, true, true),
	FRAMED_BROWN(Material.STONE, MaterialColor.TERRACOTTA_BROWN, SoundType.STONE, 2.0F, 6.0F, true, true),
	DAUB(Material.DIRT, MaterialColor.TERRACOTTA_LIGHT_GRAY, SoundType.GRAVEL, 1.0F, 1.0F, false, true),
	COBBLED_DEEPSLATE(Material.STONE, MaterialColor.DEEPSLATE, SoundType.DEEPSLATE, 3.5F, 6.0F, true, true),
	TILED_DEEPSLATE(Material.STONE, MaterialColor.DEEPSLATE, SoundType.DEEPSLATE_TILES, 3.5F, 6.0F, true, true),
	DEEPSLATE_BRICK(Material.STONE, MaterialColor.DEEPSLATE, SoundType.DEEPSLATE_BRICKS, 3.5F, 6.0F, true, true),
	POLISHED_DEEPSLATE(Material.STONE, MaterialColor.DEEPSLATE, SoundType.POLISHED_DEEPSLATE, 3.5F, 6.0F, true, true),
	QUARTZ(Material.STONE, MaterialColor.QUARTZ, SoundType.STONE, 0.8F, 0.8F, true, true),
	BRICK(Material.STONE, MaterialColor.COLOR_RED, SoundType.STONE, 2.0F, 6.0F, true, true),
	OXIDIZED_COPPER(Material.METAL, MaterialColor.WARPED_NYLIUM, SoundType.COPPER, 3.0F, 6.0F, true, true),
	WEATHERED_COPPER(Material.METAL, MaterialColor.WARPED_STEM, SoundType.COPPER, 3.0F, 6.0F, true, true),
	EXPOSED_COPPER(Material.METAL, MaterialColor.TERRACOTTA_LIGHT_GRAY, SoundType.COPPER, 3.0F, 6.0F, true, true),
	COPPER(Material.METAL, MaterialColor.COLOR_ORANGE, SoundType.COPPER, 3.0F, 6.0F, true, true),
	IRON(Material.METAL, MaterialColor.METAL, SoundType.METAL, 5.0F, 6.0F, true, true),
	GOLD(Material.METAL, MaterialColor.GOLD, SoundType.METAL, 3.0F, 6.0F, true, true),
	EMERALD(Material.METAL, MaterialColor.EMERALD, SoundType.METAL, 5.0F, 6.0F, true, true),
	DIAMOND(Material.METAL, MaterialColor.DIAMOND, SoundType.METAL, 5.0F, 6.0F, true, true),
	SMOOTH_SANDSTONE(Material.STONE, MaterialColor.SAND, SoundType.STONE, 2.0F, 6.0F, true, true),
	SANDSTONE(Material.STONE, MaterialColor.SAND, SoundType.STONE, 0.8F, 6.0F, true, true),
	SMOOTH_RED_SANDSTONE(Material.STONE, MaterialColor.COLOR_ORANGE, SoundType.STONE, 2.0F, 6.0F, true, true),
	RED_SANDSTONE(Material.STONE, MaterialColor.COLOR_ORANGE, SoundType.STONE, 0.8F, 6.0F, true, true),
	AMETHYST(Material.AMETHYST, MaterialColor.COLOR_PURPLE, SoundType.AMETHYST, 1.5F, 1.5F, true, true),
	END_STONE(Material.STONE, MaterialColor.SAND, SoundType.STONE, 3.0F, 9.0F, true, true),
	PURPUR(Material.STONE, MaterialColor.COLOR_MAGENTA, SoundType.STONE, 1.5F, 6.0F, true, true),
	BLACKSTONE(Material.STONE, MaterialColor.COLOR_BLACK, SoundType.STONE, 1.5F, 6.0F, true, true),
	POLISHED_BLACKSTONE(Material.STONE, MaterialColor.COLOR_BLACK, SoundType.STONE, 2.0F, 6.0F, true, true),
	GILDED_BLACKSTONE(Material.STONE, MaterialColor.COLOR_BLACK, SoundType.GILDED_BLACKSTONE, 1.5F, 6.0F, true, true),
	WHITE_WOOD(Material.WOOD, MaterialColor.SNOW, SoundType.WOOD, 2.0F, 3.0F, false, true),
	WHITE_SIGN(Material.WOOD, MaterialColor.SNOW, SoundType.WOOD, 1.0F, 1.0F, false, true),
	WHITE_TRAPDOOR(Material.WOOD, MaterialColor.SNOW, SoundType.WOOD, 2.0F, 3.0F, false, false),
	LEADED_GLASS(Material.GLASS, MaterialColor.STONE, SoundType.GLASS, 0.3F, 3.0F, false, false),
	FRAMED_GLASS(Material.GLASS, MaterialColor.WOOD, SoundType.GLASS, 0.3F, 3.0F, false, false);

    public final Material material; //material
    public final MaterialColor color; //map color
    public final SoundType sound; //sound
    public final float hardness; //mining hardness
    public final float resistance; //explosion resistance
	public final boolean tool;
	public final boolean occlusion;

    GufyMaterials(Material material, MaterialColor color, SoundType sound, float hardness, float resistance, boolean tool, boolean occlusion)
    {
        this.material = material;
        this.color = color;
        this.sound = sound;
        this.hardness = hardness;
        this.resistance = resistance;
        this.tool = tool;
        this.occlusion = occlusion;
    }
}

