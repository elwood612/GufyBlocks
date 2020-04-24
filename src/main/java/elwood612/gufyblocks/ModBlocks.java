package elwood612.gufyblocks;

import static elwood612.gufyblocks.GufyMaterials.*;

import com.google.common.base.Preconditions;

import elwood612.gufyblocks.blocks.GufyBlock;
import elwood612.gufyblocks.blocks.GufyHopper;
//import elwood612.gufyblocks.blocks.GufyPanel;
import elwood612.gufyblocks.blocks.GufyPillar;
import elwood612.gufyblocks.blocks.GufyPost;
import elwood612.gufyblocks.blocks.GufySlab;
import elwood612.gufyblocks.blocks.GufyStairs;
import elwood612.gufyblocks.blocks.GufyTrapdoor;
import elwood612.gufyblocks.blocks.GufyVerticalSlab;
import elwood612.gufyblocks.blocks.GufyWall;
//import elwood612.gufyblocks.blocks.GufyWattleFence;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(GufyMod.MODID)
@Mod.EventBusSubscriber(modid = GufyMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks
{
	//************************VANILLA_DUPLICATES******************************//
		//Used internally for stairs
		//Keep private!!
	//private static Block gufyTerracotta = new Block(Block.Properties.create(Material.CLAY, MaterialColor.ADOBE));
	private static Block gufyCobblestone = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE));
	//private static Block gufyHay = new Block(Block.Properties.create(Material.ORGANIC, MaterialColor.YELLOW_TERRACOTTA));
	//private static Block gufyDirt = new Block(Block.Properties.create(Material.EARTH, MaterialColor.DIRT));
	
	
	//************************VERSION 1.0 - STONE******************************//
	//stone
	public static final Block stone_verticalslab = null;
	public static final Block stone_wall = null;
	public static final Block stone_hopper = null;
	public static final Block stone_post = null;
	public static final Block stone_trapdoor = null;
	//smooth_stone
	public static final Block smooth_stone_stairs = null;
	public static final Block smooth_stone_verticalslab = null;
	public static final Block smooth_stone_wall = null;
	public static final Block smooth_stone_hopper = null;
	public static final Block smooth_stone_post = null;
	//cobblestone
	public static final Block cobblestone_verticalslab = null;
	public static final Block cobblestone_hopper = null;
	public static final Block cobblestone_post = null;
	//cobblestone_mossy
	public static final Block mossy_cobblestone_verticalslab = null;
	public static final Block mossy_cobblestone_hopper = null;
	public static final Block mossy_cobblestone_post = null;
	//cobblestone_bricks
	public static final Block cobblestone_bricks = null;
	public static final Block cobblestone_bricks_stairs = null;
	public static final Block cobblestone_bricks_slab = null;
	public static final Block cobblestone_bricks_verticalslab = null;
	public static final Block cobblestone_bricks_wall = null;
	public static final Block cobblestone_bricks_hopper = null;
	public static final Block cobblestone_bricks_post = null;
	//mossy_cobblestone_bricks
	public static final Block mossy_cobblestone_bricks = null;
	public static final Block mossy_cobblestone_bricks_stairs = null;
	public static final Block mossy_cobblestone_bricks_slab = null;
	public static final Block mossy_cobblestone_bricks_verticalslab = null;
	public static final Block mossy_cobblestone_bricks_wall = null;
	public static final Block mossy_cobblestone_bricks_hopper = null;	
	public static final Block mossy_cobblestone_bricks_post = null;
	//cracked_cobblestone_bricks
	public static final Block cracked_cobblestone_bricks  = null;
	public static final Block cracked_cobblestone_bricks_stairs = null;
	public static final Block cracked_cobblestone_bricks_slab = null;
	public static final Block cracked_cobblestone_bricks_verticalslab = null;
	public static final Block cracked_cobblestone_bricks_wall = null;
	public static final Block cracked_cobblestone_bricks_hopper = null;
	public static final Block cracked_cobblestone_bricks_post = null;
	//stone_bricks
	public static final Block stone_bricks_verticalslab = null;
	public static final Block stone_bricks_hopper = null;
	public static final Block stone_bricks_pillar = null;
	public static final Block stone_bricks_post = null;
	//mossy_stone_bricks
	public static final Block mossy_stone_bricks_verticalslab = null;
	public static final Block mossy_stone_bricks_hopper = null;
	public static final Block mossy_stone_bricks_post = null;
	//cracked_stone_bricks
	public static final Block cracked_stone_bricks_stairs = null;
	public static final Block cracked_stone_bricks_slab = null;
	public static final Block cracked_stone_bricks_verticalslab = null;
	public static final Block cracked_stone_bricks_wall = null;
	public static final Block cracked_stone_bricks_hopper = null;
	public static final Block cracked_stone_bricks_post = null;
	
	
	

	//************************REGISTER_BLOCKS******************************//
	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) 
	{	
		final Block[] blocks =
		{
			//stone
			new GufyVerticalSlab(STONE, "stone_verticalslab"),
			new GufyWall(STONE, "stone_wall"),
			new GufyHopper(STONE, "stone_hopper"),
			new GufyPost(STONE, "stone_post"),
			new GufyTrapdoor(STONE, "stone_trapdoor"),	
			//smooth_stone
			new GufyStairs(gufyCobblestone.getDefaultState(), STONE, "smooth_stone_stairs"),
			new GufyVerticalSlab(STONE, "smooth_stone_verticalslab"),
			new GufyWall(STONE, "smooth_stone_wall"),
			new GufyHopper(STONE, "smooth_stone_hopper"),
			new GufyPost(STONE, "smooth_stone_post"),
			//cobblestone
			new GufyVerticalSlab(COBBLESTONE, "cobblestone_verticalslab"),
			new GufyHopper(COBBLESTONE, "cobblestone_hopper"),
			new GufyPost(COBBLESTONE, "cobblestone_post"),
			//cobblestone_mossy
			new GufyVerticalSlab(COBBLESTONE, "mossy_cobblestone_verticalslab"),
			new GufyHopper(COBBLESTONE, "mossy_cobblestone_hopper"),
			new GufyPost(COBBLESTONE, "mossy_cobblestone_post"),			
			//cobblestone_bricks
			new GufyBlock(COBBLESTONE, "cobblestone_bricks"),
			new GufyStairs(gufyCobblestone.getDefaultState(), COBBLESTONE, "cobblestone_bricks_stairs"),
			new GufySlab(COBBLESTONE, "cobblestone_bricks_slab"),
			new GufyVerticalSlab(COBBLESTONE, "cobblestone_bricks_verticalslab"),
			new GufyWall(COBBLESTONE, "cobblestone_bricks_wall"),
			new GufyHopper(COBBLESTONE, "cobblestone_bricks_hopper"),
			new GufyPost(COBBLESTONE, "cobblestone_bricks_post"),
			//mossy_cobblestone_bricks
			new GufyBlock(COBBLESTONE, "mossy_cobblestone_bricks"),
			new GufyStairs(gufyCobblestone.getDefaultState(), COBBLESTONE, "mossy_cobblestone_bricks_stairs"),
			new GufySlab(COBBLESTONE, "mossy_cobblestone_bricks_slab"),
			new GufyVerticalSlab(COBBLESTONE, "mossy_cobblestone_bricks_verticalslab"),
			new GufyWall(COBBLESTONE, "mossy_cobblestone_bricks_wall"),
			new GufyHopper(COBBLESTONE, "mossy_cobblestone_bricks_hopper"),
			new GufyPost(COBBLESTONE, "mossy_cobblestone_bricks_post"),
			//cracked_cobblestone_bricks
			new GufyBlock(COBBLESTONE, "cracked_cobblestone_bricks"),
			new GufyStairs(gufyCobblestone.getDefaultState(), COBBLESTONE, "cracked_cobblestone_bricks_stairs"),
			new GufySlab(COBBLESTONE, "cracked_cobblestone_bricks_slab"),
			new GufyVerticalSlab(COBBLESTONE, "cracked_cobblestone_bricks_verticalslab"),
			new GufyWall(COBBLESTONE, "cracked_cobblestone_bricks_wall"),
			new GufyHopper(COBBLESTONE, "cracked_cobblestone_bricks_hopper"),
			new GufyPost(COBBLESTONE, "cracked_cobblestone_bricks_post"),
			//stone_bricks
			new GufyVerticalSlab(COBBLESTONE, "stone_bricks_verticalslab"),
			new GufyHopper(COBBLESTONE, "stone_bricks_hopper"),
			new GufyPillar(COBBLESTONE, "stone_bricks_pillar"),
			new GufyPost(COBBLESTONE, "stone_bricks_post"),
			//mossy_stone_bricks
			new GufyVerticalSlab(COBBLESTONE, "mossy_stone_bricks_verticalslab"),
			new GufyHopper(COBBLESTONE, "mossy_stone_bricks_hopper"),
			new GufyPost(COBBLESTONE, "mossy_stone_bricks_post"),
			//cracked_stone_bricks
			new GufyStairs(gufyCobblestone.getDefaultState(), COBBLESTONE, "cracked_stone_bricks_stairs"),
			new GufySlab(COBBLESTONE, "cracked_stone_bricks_slab"),
			new GufyVerticalSlab(COBBLESTONE, "cracked_stone_bricks_verticalslab"),
			new GufyWall(COBBLESTONE, "cracked_stone_bricks_wall"),
			new GufyHopper(COBBLESTONE, "cracked_stone_bricks_hopper"),
			new GufyPost(COBBLESTONE, "cracked_stone_bricks_post"),
			
		};
		
		for (final Block block: blocks)
		{
			Preconditions.checkNotNull(block.getRegistryName(), "Block: %s has a NULL registry name", block);
            event.getRegistry().register(block);
        }

	}
	
	//************************REGISTER_ITEMS******************************//
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		final BlockItem[] items = 
		{
			//stone
			createBlockItem(stone_verticalslab),
			createBlockItem(stone_wall),
			createBlockItem(stone_hopper),
			createBlockItem(stone_post),
			createBlockItem(stone_trapdoor),
			//smooth_stone
			createBlockItem(smooth_stone_stairs),
			createBlockItem(smooth_stone_verticalslab),
			createBlockItem(smooth_stone_wall),
			createBlockItem(smooth_stone_hopper),
			createBlockItem(smooth_stone_post),
			//cobblestone
			createBlockItem(cobblestone_verticalslab),
			createBlockItem(cobblestone_hopper),
			createBlockItem(cobblestone_post),
			//cobblestone_mossy
			createBlockItem(mossy_cobblestone_verticalslab),
			createBlockItem(mossy_cobblestone_hopper),
			createBlockItem(mossy_cobblestone_post),
			//cobblestone_bricks
			createBlockItem(cobblestone_bricks),
			createBlockItem(cobblestone_bricks_stairs),
			createBlockItem(cobblestone_bricks_slab),
			createBlockItem(cobblestone_bricks_verticalslab),
			createBlockItem(cobblestone_bricks_wall),
			createBlockItem(cobblestone_bricks_hopper),
			createBlockItem(cobblestone_bricks_post),
			//mossy_cobblestone_bricks
			createBlockItem(mossy_cobblestone_bricks),
			createBlockItem(mossy_cobblestone_bricks_stairs),
			createBlockItem(mossy_cobblestone_bricks_slab),
			createBlockItem(mossy_cobblestone_bricks_verticalslab),
			createBlockItem(mossy_cobblestone_bricks_wall),
			createBlockItem(mossy_cobblestone_bricks_hopper),
			createBlockItem(mossy_cobblestone_bricks_post),
			//cracked_cobblestone_bricks
			createBlockItem(cracked_cobblestone_bricks),
			createBlockItem(cracked_cobblestone_bricks_stairs),
			createBlockItem(cracked_cobblestone_bricks_slab),
			createBlockItem(cracked_cobblestone_bricks_verticalslab),
			createBlockItem(cracked_cobblestone_bricks_wall),
			createBlockItem(cracked_cobblestone_bricks_hopper),
			createBlockItem(cracked_cobblestone_bricks_post),
			//stone_bricks
			createBlockItem(stone_bricks_verticalslab),
			createBlockItem(stone_bricks_hopper),
			createBlockItem(stone_bricks_pillar),
			createBlockItem(stone_bricks_post),
			//mossy_stone_bricks
			createBlockItem(mossy_stone_bricks_verticalslab),
			createBlockItem(mossy_stone_bricks_hopper),
			createBlockItem(mossy_stone_bricks_post),
			//cracked_stone_bricks
			createBlockItem(cracked_stone_bricks_stairs),
			createBlockItem(cracked_stone_bricks_slab),
			createBlockItem(cracked_stone_bricks_verticalslab),
			createBlockItem(cracked_stone_bricks_wall),
			createBlockItem(cracked_stone_bricks_hopper),
			createBlockItem(cracked_stone_bricks_post),
			
		};
		
		//BlockItemS
		for (final BlockItem item: items)
		{
            final Block block = item.getBlock();
            final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "BlockItem: %s has a NULL registry name", block);
            event.getRegistry().register(item.setRegistryName(registryName));
        }
		
		/*
		//ITEMS
		event.getRegistry().registerAll
		(
			new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("coin_gold")
		);
		*/
	}
	
	//Dynamically create BlockItems
	private static BlockItem createBlockItem(Block block)
	{
        return (BlockItem) new BlockItem(block, new Item.Properties().group(GufyMod.gufygroup));
    }
    
}
