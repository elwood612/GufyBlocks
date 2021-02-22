package elwood612.gufyblocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

import static net.minecraftforge.common.ToolType.*;

public enum GufyMaterials 
{
	//Create Materials in here
	//Copy values from Blocks.class
	STONE(Material.ROCK, MaterialColor.STONE, SoundType.STONE, 1.5F, 6.0F, PICKAXE, 0),
	STONE_TRAPDOOR(Material.IRON, MaterialColor.STONE, SoundType.STONE, 1.5F, 6.0F, PICKAXE, 0),
	COBBLESTONE(Material.ROCK, MaterialColor.STONE, SoundType.STONE, 2.0F, 6.0F, PICKAXE, 0),
	DIORITE(Material.ROCK, MaterialColor.QUARTZ, SoundType.STONE, 1.5F, 6.0F, PICKAXE, 0),
	DIORITE_TRAPDOOR(Material.IRON, MaterialColor.QUARTZ, SoundType.STONE, 1.5F, 6.0F, PICKAXE, 0),
	DIORITE_COBBLE(Material.ROCK, MaterialColor.QUARTZ, SoundType.STONE, 2.0F, 6.0F, PICKAXE, 0),
	GRANITE(Material.ROCK, MaterialColor.DIRT, SoundType.STONE, 1.5F, 6.0F, PICKAXE, 0),
	GRANITE_TRAPDOOR(Material.IRON, MaterialColor.DIRT, SoundType.STONE, 1.5F, 6.0F, PICKAXE, 0),
	GRANITE_COBBLE(Material.ROCK, MaterialColor.DIRT, SoundType.STONE, 2.0F, 6.0F, PICKAXE, 0),
	THATCH(Material.ORGANIC, MaterialColor.YELLOW_TERRACOTTA, SoundType.PLANT, 0.5F, 0.5F, null, 0),
	TERRACOTTA(Material.ROCK, MaterialColor.ADOBE, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	WHITE_TERRACOTTA(Material.ROCK, MaterialColor.WHITE_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	LIGHT_GRAY_TERRACOTTA(Material.ROCK, MaterialColor.LIGHT_GRAY_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	GRAY_TERRACOTTA(Material.ROCK, MaterialColor.GRAY_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	BLACK_TERRACOTTA(Material.ROCK, MaterialColor.BLACK_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	BROWN_TERRACOTTA(Material.ROCK, MaterialColor.BROWN_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	RED_TERRACOTTA(Material.ROCK, MaterialColor.RED_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	ORANGE_TERRACOTTA(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	YELLOW_TERRACOTTA(Material.ROCK, MaterialColor.YELLOW_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	LIME_TERRACOTTA(Material.ROCK, MaterialColor.LIME_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	GREEN_TERRACOTTA(Material.ROCK, MaterialColor.GREEN_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	CYAN_TERRACOTTA(Material.ROCK, MaterialColor.CYAN_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	LIGHT_BLUE_TERRACOTTA(Material.ROCK, MaterialColor.LIGHT_BLUE_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	BLUE_TERRACOTTA(Material.ROCK, MaterialColor.BLUE_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	PURPLE_TERRACOTTA(Material.ROCK, MaterialColor.PURPLE_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	MAGENTA_TERRACOTTA(Material.ROCK, MaterialColor.MAGENTA_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	PINK_TERRACOTTA(Material.ROCK, MaterialColor.PINK_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	WHITE_CONCRETE(Material.ROCK, MaterialColor.SNOW, SoundType.STONE, 1.8F, 1.8F, PICKAXE, 0),
	LIGHT_GRAY_CONCRETE(Material.ROCK, MaterialColor.LIGHT_GRAY, SoundType.STONE, 1.8F, 1.8F, PICKAXE, 0),
	GRAY_CONCRETE(Material.ROCK, MaterialColor.GRAY, SoundType.STONE, 1.8F, 1.8F, PICKAXE, 0),
	BLACK_CONCRETE(Material.ROCK, MaterialColor.BLACK, SoundType.STONE, 1.8F, 1.8F, PICKAXE, 0),
	BROWN_CONCRETE(Material.ROCK, MaterialColor.BROWN, SoundType.STONE, 1.8F, 1.8F, PICKAXE, 0),
	RED_CONCRETE(Material.ROCK, MaterialColor.RED, SoundType.STONE, 1.8F, 1.8F, PICKAXE, 0),
	ORANGE_CONCRETE(Material.ROCK, MaterialColor.ADOBE, SoundType.STONE, 1.8F, 1.8F, PICKAXE, 0),
	YELLOW_CONCRETE(Material.ROCK, MaterialColor.YELLOW, SoundType.STONE, 1.8F, 1.8F, PICKAXE, 0),
	LIME_CONCRETE(Material.ROCK, MaterialColor.LIME, SoundType.STONE, 1.8F, 1.8F, PICKAXE, 0),
	GREEN_CONCRETE(Material.ROCK, MaterialColor.GREEN, SoundType.STONE, 1.8F, 1.8F, PICKAXE, 0),
	CYAN_CONCRETE(Material.ROCK, MaterialColor.CYAN, SoundType.STONE, 1.8F, 1.8F, PICKAXE, 0),
	LIGHT_BLUE_CONCRETE(Material.ROCK, MaterialColor.LIGHT_BLUE, SoundType.STONE, 1.8F, 1.8F, PICKAXE, 0),
	BLUE_CONCRETE(Material.ROCK, MaterialColor.BLUE, SoundType.STONE, 1.8F, 1.8F, PICKAXE, 0),
	PURPLE_CONCRETE(Material.ROCK, MaterialColor.PURPLE, SoundType.STONE, 1.8F, 1.8F, PICKAXE, 0),
	MAGENTA_CONCRETE(Material.ROCK, MaterialColor.MAGENTA, SoundType.STONE, 1.8F, 1.8F, PICKAXE, 0),
	PINK_CONCRETE(Material.ROCK, MaterialColor.PINK, SoundType.STONE, 1.8F, 1.8F, PICKAXE, 0),
	WHITE_WOOL(Material.WOOL, MaterialColor.SNOW, SoundType.CLOTH, 0.8F, 0.8F, null, 0),
	LIGHT_GRAY_WOOL(Material.WOOL, MaterialColor.LIGHT_GRAY, SoundType.CLOTH, 0.8F, 0.8F, null, 0),
	GRAY_WOOL(Material.WOOL, MaterialColor.GRAY, SoundType.CLOTH, 0.8F, 0.8F, null, 0),
	BLACK_WOOL(Material.WOOL, MaterialColor.BLACK, SoundType.CLOTH, 0.8F, 0.8F, null, 0),
	BROWN_WOOL(Material.WOOL, MaterialColor.BROWN, SoundType.CLOTH, 0.8F, 0.8F, null, 0),
	RED_WOOL(Material.WOOL, MaterialColor.RED, SoundType.CLOTH, 0.8F, 0.8F, null, 0),
	ORANGE_WOOL(Material.WOOL, MaterialColor.ADOBE, SoundType.CLOTH, 0.8F, 0.8F, null, 0),
	YELLOW_WOOL(Material.WOOL, MaterialColor.YELLOW, SoundType.CLOTH, 0.8F, 0.8F, null, 0),
	LIME_WOOL(Material.WOOL, MaterialColor.LIME, SoundType.CLOTH, 0.8F, 0.8F, null, 0),
	GREEN_WOOL(Material.WOOL, MaterialColor.GREEN, SoundType.CLOTH, 0.8F, 0.8F, null, 0),
	CYAN_WOOL(Material.WOOL, MaterialColor.CYAN, SoundType.CLOTH, 0.8F, 0.8F, null, 0),
	LIGHT_BLUE_WOOL(Material.WOOL, MaterialColor.LIGHT_BLUE, SoundType.CLOTH, 0.8F, 0.8F, null, 0),
	BLUE_WOOL(Material.WOOL, MaterialColor.BLUE, SoundType.CLOTH, 0.8F, 0.8F, null, 0),
	PURPLE_WOOL(Material.WOOL, MaterialColor.PURPLE, SoundType.CLOTH, 0.8F, 0.8F, null, 0),
	MAGENTA_WOOL(Material.WOOL, MaterialColor.MAGENTA, SoundType.CLOTH, 0.8F, 0.8F, null, 0),
	PINK_WOOL(Material.WOOL, MaterialColor.PINK, SoundType.CLOTH, 0.8F, 0.8F, null, 0),
	OAK(Material.WOOD, MaterialColor.WOOD, SoundType.WOOD, 2.0F, 3.0F, AXE, 0),
	SPRUCE(Material.WOOD, MaterialColor.OBSIDIAN, SoundType.WOOD, 2.0F, 3.0F, AXE, 0),
	BIRCH(Material.WOOD, MaterialColor.SAND, SoundType.WOOD, 2.0F, 3.0F, AXE, 0),
	JUNGLE(Material.WOOD, MaterialColor.DIRT, SoundType.WOOD, 2.0F, 3.0F, AXE, 0),
	DARK_OAK(Material.WOOD, MaterialColor.BROWN, SoundType.WOOD, 2.0F, 3.0F, AXE, 0),
	ACACIA(Material.WOOD, MaterialColor.ADOBE, SoundType.WOOD, 2.0F, 3.0F, AXE, 0),
	CRIMSON(Material.NETHER_WOOD, MaterialColor.CRIMSON_STEM, SoundType.WOOD, 2.0F, 3.0F, AXE, 0),
	WARPED(Material.NETHER_WOOD, MaterialColor.WARPED_STEM, SoundType.WOOD, 2.0F, 3.0F, AXE, 0),
	NETHER_WART(Material.ORGANIC, MaterialColor.RED, SoundType.WART, 1.0F, 1.0F, HOE, 0),
	WARPED_WART(Material.ORGANIC, MaterialColor.WARPED_WART, SoundType.WART, 1.0F, 1.0F, HOE, 0),
	WATTLE(Material.WOOD, MaterialColor.WOOD, SoundType.WOOD, 0.5F, 0.5F, AXE, 0),
	DIRT(Material.EARTH, MaterialColor.DIRT, SoundType.GROUND, 0.5F, 0.5F, SHOVEL, 0),
	FRAME_WHITE(Material.WOOD, MaterialColor.WHITE_TERRACOTTA, SoundType.WOOD, 2.0F, 3.0F, AXE, 0),
	FRAME_BROWN(Material.WOOD, MaterialColor.BROWN_TERRACOTTA, SoundType.WOOD, 2.0F, 3.0F, AXE, 0),
	CLAY_WHITE(Material.ROCK, MaterialColor.WHITE_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	DAUB(Material.EARTH, MaterialColor.LIGHT_GRAY_TERRACOTTA, SoundType.GROUND, 1.0F, 1.0F, SHOVEL, 0),
	GLASS_CLEAR(Material.GLASS, MaterialColor.WHITE_TERRACOTTA, SoundType.GLASS, 0.3F, 0.3F, null, 0);


    public final Material material; //material
    public final MaterialColor color; //map color
    public final SoundType sound; //sound
    public final float hardness; //mining hardness
    public final float resistance; //explosion resistance
    public final ToolType tool; //tool type
    public final int level; //tool level

    GufyMaterials(Material material, MaterialColor color, SoundType sound, float hardness, float resistance, ToolType tool, int level) 
    {
        this.material = material;
        this.color = color;
        this.sound = sound;
        this.hardness = hardness;
        this.resistance = resistance;
        this.tool = tool;
        this.level = level;
    }
}

