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
	COBBLESTONE(Material.ROCK, MaterialColor.STONE, SoundType.STONE, 2.0F, 6.0F, PICKAXE, 0),
	GOLD(Material.IRON, MaterialColor.GOLD, SoundType.METAL, 5.0F, 10.0F, PICKAXE, 2),
	IRON(Material.IRON, MaterialColor.STONE, SoundType.STONE, 2.0F, 3.0F, PICKAXE, 0),
	THATCH(Material.ORGANIC, MaterialColor.YELLOW_TERRACOTTA, SoundType.PLANT, 0.5F, 0.5F, null, 0),
	TERRACOTTA(Material.ROCK, MaterialColor.ADOBE, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	OAK(Material.WOOD, MaterialColor.WOOD, SoundType.WOOD, 2.0F, 3.0F, AXE, 0),
	SPRUCE(Material.WOOD, MaterialColor.OBSIDIAN, SoundType.WOOD, 2.0F, 3.0F, AXE, 0),
	BIRCH(Material.WOOD, MaterialColor.SAND, SoundType.WOOD, 2.0F, 3.0F, AXE, 0),
	JUNGLE(Material.WOOD, MaterialColor.DIRT, SoundType.WOOD, 2.0F, 3.0F, AXE, 0),
	DARK_OAK(Material.WOOD, MaterialColor.BROWN, SoundType.WOOD, 2.0F, 3.0F, AXE, 0),
	ACACIA(Material.WOOD, MaterialColor.ADOBE, SoundType.WOOD, 2.0F, 3.0F, AXE, 0),
	WATTLE(Material.WOOD, MaterialColor.WOOD, SoundType.WOOD, 1.0F, 0.5F, AXE, 0),
	DIRT(Material.EARTH, MaterialColor.DIRT, SoundType.GROUND, 0.5F, 0.5F, SHOVEL, 0),
	CLAY_WHITE(Material.ROCK, MaterialColor.WHITE_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0),
	CLAY_BROWN(Material.ROCK, MaterialColor.BROWN_TERRACOTTA, SoundType.STONE, 1.25F, 4.2F, PICKAXE, 0);

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

