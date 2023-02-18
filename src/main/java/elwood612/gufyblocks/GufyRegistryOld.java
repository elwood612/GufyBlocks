package elwood612.gufyblocks;

import static elwood612.gufyblocks.blocks.blockUtil.GufyMaterials.*;

import com.google.common.base.Preconditions;

import elwood612.gufyblocks.blocks.*;
//import elwood612.gufyblocks.items.*;
import elwood612.gufyblocks.blocks.blockSpecialty.*;
import elwood612.gufyblocks.blocks.blockUtil.GufyWeathering;
import elwood612.gufyblocks.blocks.blockWeathering.*;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
//import net.minecraftforge.event.RegistryEvent;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

//@ObjectHolder(GufyBlocks.MODID)
//@Mod.EventBusSubscriber(modid = GufyBlocks.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GufyRegistryOld
{
	//************************DECLARE BLOCKS******************************//
	public static final Block[] blockList = 
	{
			/*
		//miscellaneous
			new GufyWattleFence(WATTLE, "wattle_fence"),
			new GufyStairs(DIRT, "coarse_dirt_stairs"),
			new GufySlab(DIRT, "coarse_dirt_slab"),
			new GufyVerticalSlab(DIRT, "coarse_dirt_verticalslab"),
			new GufyBlock(DAUB, "daub"),
			new GufyStairs(DAUB, "daub_stairs"),
			new GufySlab(DAUB, "daub_slab"),
			new GufyVerticalSlab(DAUB, "daub_verticalslab"),
			new GufyBlock(THATCH, "thatch"),
			new GufyStairs(THATCH, "thatch_stairs"),
			new GufySlab(THATCH, "thatch_slab"),
			new GufyVerticalSlab(THATCH, "thatch_verticalslab"),
		//stone
			new GufyVerticalSlab(STONE, "stone_verticalslab"),
			new GufyWall(STONE, "stone_wall"),
			new GufyHopper(STONE, "stone_hopper"),
			new GufyPost(STONE, "stone_post"),
			new GufyTrapdoor(STONE_TRAPDOOR, "stone_trapdoor"),
		//smooth_stone
			new GufyStairs(STONE, "smooth_stone_stairs"),
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
			new GufyStairs(COBBLESTONE, "cobblestone_bricks_stairs"),
			new GufySlab(COBBLESTONE, "cobblestone_bricks_slab"),
			new GufyVerticalSlab(COBBLESTONE, "cobblestone_bricks_verticalslab"),
			new GufyWall(COBBLESTONE, "cobblestone_bricks_wall"),
			new GufyHopper(COBBLESTONE, "cobblestone_bricks_hopper"),
			new GufyPost(COBBLESTONE, "cobblestone_bricks_post"),
		//mossy_cobblestone_bricks
			new GufyBlock(COBBLESTONE, "mossy_cobblestone_bricks"),
			new GufyStairs(COBBLESTONE, "mossy_cobblestone_bricks_stairs"),
			new GufySlab(COBBLESTONE, "mossy_cobblestone_bricks_slab"),
			new GufyVerticalSlab(COBBLESTONE, "mossy_cobblestone_bricks_verticalslab"),
			new GufyWall(COBBLESTONE, "mossy_cobblestone_bricks_wall"),
			new GufyHopper(COBBLESTONE, "mossy_cobblestone_bricks_hopper"),
			new GufyPost(COBBLESTONE, "mossy_cobblestone_bricks_post"),
		//cracked_cobblestone_bricks
			new GufyBlock(COBBLESTONE, "cracked_cobblestone_bricks"),
			new GufyStairs(COBBLESTONE, "cracked_cobblestone_bricks_stairs"),
			new GufySlab(COBBLESTONE, "cracked_cobblestone_bricks_slab"),
			new GufyVerticalSlab(COBBLESTONE, "cracked_cobblestone_bricks_verticalslab"),
			new GufyWall(COBBLESTONE, "cracked_cobblestone_bricks_wall"),
			new GufyHopper(COBBLESTONE, "cracked_cobblestone_bricks_hopper"),
			new GufyPost(COBBLESTONE, "cracked_cobblestone_bricks_post"),
		//stone_bricks
			new GufyVerticalSlab(STONE, "stone_bricks_verticalslab"),
			new GufyHopper(STONE, "stone_bricks_hopper"),
			new GufyPillar(STONE, "stone_bricks_pillar"),
			new GufyPost(STONE, "stone_bricks_post"),
		//mossy_stone_bricks
			new GufyVerticalSlab(STONE, "mossy_stone_bricks_verticalslab"),
			new GufyHopper(STONE, "mossy_stone_bricks_hopper"),
			new GufyPost(STONE, "mossy_stone_bricks_post"),
		//cracked_stone_bricks
			new GufyStairs(STONE, "cracked_stone_bricks_stairs"),
			new GufySlab(STONE, "cracked_stone_bricks_slab"),
			new GufyVerticalSlab(STONE, "cracked_stone_bricks_verticalslab"),
			new GufyWall(STONE, "cracked_stone_bricks_wall"),
			new GufyHopper(STONE, "cracked_stone_bricks_hopper"),
			new GufyPost(STONE, "cracked_stone_bricks_post"),
		//spruce
			new GufyVerticalSlab(SPRUCE, "spruce_verticalslab"),
			new GufyWall(SPRUCE, "spruce_wall"),
			new GufyHopper(SPRUCE, "spruce_hopper"),
			new GufyPanel(SPRUCE, "spruce_panel"),
		//cracked_spruce
			new GufyBlock(SPRUCE, "cracked_spruce"),
			new GufyStairs(SPRUCE, "cracked_spruce_stairs"),
			new GufySlab(SPRUCE, "cracked_spruce_slab"),
			new GufyVerticalSlab(SPRUCE, "cracked_spruce_verticalslab"),
			new GufyWall(SPRUCE, "cracked_spruce_wall"),
			new GufyHopper(SPRUCE, "cracked_spruce_hopper"),
			new GufyFence(SPRUCE, "cracked_spruce_fence"),
			new GufyPanel(SPRUCE, "cracked_spruce_panel"),
		//mossy_spruce
			new GufyBlock(SPRUCE, "mossy_spruce"),
			new GufyStairs(SPRUCE, "mossy_spruce_stairs"),
			new GufySlab(SPRUCE, "mossy_spruce_slab"),
			new GufyVerticalSlab(SPRUCE, "mossy_spruce_verticalslab"),
			new GufyWall(SPRUCE, "mossy_spruce_wall"),
			new GufyHopper(SPRUCE, "mossy_spruce_hopper"),
			new GufyFence(SPRUCE, "mossy_spruce_fence"),
			new GufyPanel(SPRUCE, "mossy_spruce_panel"),
		//spruce_parquet
			new GufyHorizontalBlock(SPRUCE, "spruce_parquet"),
		//spruce_wood
			new GufyStairs(SPRUCE, "spruce_wood_stairs"),
			new GufySlab(SPRUCE, "spruce_wood_slab"),
			new GufyVerticalSlab(SPRUCE, "spruce_wood_verticalslab"),
			new GufyWall(SPRUCE, "spruce_wood_wall"),
			new GufyHopper(SPRUCE, "spruce_wood_hopper"),
			new GufyFence(SPRUCE, "spruce_wood_fence"),
			new GufyPanel(SPRUCE, "spruce_wood_panel"),
		//stripped_spruce_wood
			new GufyStairs(SPRUCE, "stripped_spruce_wood_stairs"),
			new GufySlab(SPRUCE, "stripped_spruce_wood_slab"),
			new GufyVerticalSlab(SPRUCE, "stripped_spruce_wood_verticalslab"),
			new GufyWall(SPRUCE, "stripped_spruce_wood_wall"),
			new GufyHopper(SPRUCE, "stripped_spruce_wood_hopper"),
			new GufyFence(SPRUCE, "stripped_spruce_wood_fence"),
			new GufyPanel(SPRUCE, "stripped_spruce_wood_panel"),
		//oak
			new GufyVerticalSlab(OAK, "oak_verticalslab"),
			new GufyWall(OAK, "oak_wall"),
			new GufyHopper(OAK, "oak_hopper"),
			new GufyPanel(OAK, "oak_panel"),
		//cracked_oak
			new GufyBlock(OAK, "cracked_oak"),
			new GufyStairs(OAK, "cracked_oak_stairs"),
			new GufySlab(OAK, "cracked_oak_slab"),
			new GufyVerticalSlab(OAK, "cracked_oak_verticalslab"),
			new GufyWall(OAK, "cracked_oak_wall"),
			new GufyHopper(OAK, "cracked_oak_hopper"),
			new GufyFence(OAK, "cracked_oak_fence"),
			new GufyPanel(OAK, "cracked_oak_panel"),
		//mossy_oak
			new GufyBlock(OAK, "mossy_oak"),
			new GufyStairs(OAK, "mossy_oak_stairs"),
			new GufySlab(OAK, "mossy_oak_slab"),
			new GufyVerticalSlab(OAK, "mossy_oak_verticalslab"),
			new GufyWall(OAK, "mossy_oak_wall"),
			new GufyHopper(OAK, "mossy_oak_hopper"),
			new GufyFence(OAK, "mossy_oak_fence"),
			new GufyPanel(OAK, "mossy_oak_panel"),
		//oak_parquet
			new GufyHorizontalBlock(OAK, "oak_parquet"),
		//oak_wood
			new GufyStairs(OAK, "oak_wood_stairs"),
			new GufySlab(OAK, "oak_wood_slab"),
			new GufyVerticalSlab(OAK, "oak_wood_verticalslab"),
			new GufyWall(OAK, "oak_wood_wall"),
			new GufyHopper(OAK, "oak_wood_hopper"),
			new GufyFence(OAK, "oak_wood_fence"),
			new GufyPanel(OAK, "oak_wood_panel"),
		//stripped_oak_wood
			new GufyStairs(OAK, "stripped_oak_wood_stairs"),
			new GufySlab(OAK, "stripped_oak_wood_slab"),
			new GufyVerticalSlab(OAK, "stripped_oak_wood_verticalslab"),
			new GufyWall(OAK, "stripped_oak_wood_wall"),
			new GufyHopper(OAK, "stripped_oak_wood_hopper"),
			new GufyFence(OAK, "stripped_oak_wood_fence"),
			new GufyPanel(OAK, "stripped_oak_wood_panel"),
		//jungle
			new GufyVerticalSlab(JUNGLE, "jungle_verticalslab"),
			new GufyWall(JUNGLE, "jungle_wall"),
			new GufyHopper(JUNGLE, "jungle_hopper"),
			new GufyPanel(JUNGLE, "jungle_panel"),
		//cracked_jungle
			new GufyBlock(JUNGLE, "cracked_jungle"),
			new GufyStairs(JUNGLE, "cracked_jungle_stairs"),
			new GufySlab(JUNGLE, "cracked_jungle_slab"),
			new GufyVerticalSlab(JUNGLE, "cracked_jungle_verticalslab"),
			new GufyWall(JUNGLE, "cracked_jungle_wall"),
			new GufyHopper(JUNGLE, "cracked_jungle_hopper"),
			new GufyFence(JUNGLE, "cracked_jungle_fence"),
			new GufyPanel(JUNGLE, "cracked_jungle_panel"),
		//mossy_jungle
			new GufyBlock(JUNGLE, "mossy_jungle"),
			new GufyStairs(JUNGLE, "mossy_jungle_stairs"),
			new GufySlab(JUNGLE, "mossy_jungle_slab"),
			new GufyVerticalSlab(JUNGLE, "mossy_jungle_verticalslab"),
			new GufyWall(JUNGLE, "mossy_jungle_wall"),
			new GufyHopper(JUNGLE, "mossy_jungle_hopper"),
			new GufyFence(JUNGLE, "mossy_jungle_fence"),
			new GufyPanel(JUNGLE, "mossy_jungle_panel"),
		//jungle_parquet
			new GufyHorizontalBlock(JUNGLE, "jungle_parquet"),
		//jungle_wood
			new GufyStairs(JUNGLE, "jungle_wood_stairs"),
			new GufySlab(JUNGLE, "jungle_wood_slab"),
			new GufyVerticalSlab(JUNGLE, "jungle_wood_verticalslab"),
			new GufyWall(JUNGLE, "jungle_wood_wall"),
			new GufyHopper(JUNGLE, "jungle_wood_hopper"),
			new GufyFence(JUNGLE, "jungle_wood_fence"),
			new GufyPanel(JUNGLE, "jungle_wood_panel"),
		//stripped_jungle_wood
			new GufyStairs(JUNGLE, "stripped_jungle_wood_stairs"),
			new GufySlab(JUNGLE, "stripped_jungle_wood_slab"),
			new GufyVerticalSlab(JUNGLE, "stripped_jungle_wood_verticalslab"),
			new GufyWall(JUNGLE, "stripped_jungle_wood_wall"),
			new GufyHopper(JUNGLE, "stripped_jungle_wood_hopper"),
			new GufyFence(JUNGLE, "stripped_jungle_wood_fence"),
			new GufyPanel(JUNGLE, "stripped_jungle_wood_panel"),
		//birch
			new GufyVerticalSlab(BIRCH, "birch_verticalslab"),
			new GufyWall(BIRCH, "birch_wall"),
			new GufyHopper(BIRCH, "birch_hopper"),
			new GufyPanel(BIRCH, "birch_panel"),
		//cracked_birch
			new GufyBlock(BIRCH, "cracked_birch"),
			new GufyStairs(BIRCH, "cracked_birch_stairs"),
			new GufySlab(BIRCH, "cracked_birch_slab"),
			new GufyVerticalSlab(BIRCH, "cracked_birch_verticalslab"),
			new GufyWall(BIRCH, "cracked_birch_wall"),
			new GufyHopper(BIRCH, "cracked_birch_hopper"),
			new GufyFence(BIRCH, "cracked_birch_fence"),
			new GufyPanel(BIRCH, "cracked_birch_panel"),
		//mossy_birch
			new GufyBlock(BIRCH, "mossy_birch"),
			new GufyStairs(BIRCH, "mossy_birch_stairs"),
			new GufySlab(BIRCH, "mossy_birch_slab"),
			new GufyVerticalSlab(BIRCH, "mossy_birch_verticalslab"),
			new GufyWall(BIRCH, "mossy_birch_wall"),
			new GufyHopper(BIRCH, "mossy_birch_hopper"),
			new GufyFence(BIRCH, "mossy_birch_fence"),
			new GufyPanel(BIRCH, "mossy_birch_panel"),
		//birch_parquet
			new GufyHorizontalBlock(BIRCH, "birch_parquet"),
		//birch_wood
			new GufyStairs(BIRCH, "birch_wood_stairs"),
			new GufySlab(BIRCH, "birch_wood_slab"),
			new GufyVerticalSlab(BIRCH, "birch_wood_verticalslab"),
			new GufyWall(BIRCH, "birch_wood_wall"),
			new GufyHopper(BIRCH, "birch_wood_hopper"),
			new GufyFence(BIRCH, "birch_wood_fence"),
			new GufyPanel(BIRCH, "birch_wood_panel"),
		//stripped_birch_wood
			new GufyStairs(BIRCH, "stripped_birch_wood_stairs"),
			new GufySlab(BIRCH, "stripped_birch_wood_slab"),
			new GufyVerticalSlab(BIRCH, "stripped_birch_wood_verticalslab"),
			new GufyWall(BIRCH, "stripped_birch_wood_wall"),
			new GufyHopper(BIRCH, "stripped_birch_wood_hopper"),
			new GufyFence(BIRCH, "stripped_birch_wood_fence"),
			new GufyPanel(BIRCH, "stripped_birch_wood_panel"),
		//dark_oak
			new GufyVerticalSlab(DARK_OAK, "dark_oak_verticalslab"),
			new GufyWall(DARK_OAK, "dark_oak_wall"),
			new GufyHopper(DARK_OAK, "dark_oak_hopper"),
			new GufyPanel(DARK_OAK, "dark_oak_panel"),
		//cracked_dark_oak
			new GufyBlock(DARK_OAK, "cracked_dark_oak"),
			new GufyStairs(DARK_OAK, "cracked_dark_oak_stairs"),
			new GufySlab(DARK_OAK, "cracked_dark_oak_slab"),
			new GufyVerticalSlab(DARK_OAK, "cracked_dark_oak_verticalslab"),
			new GufyWall(DARK_OAK, "cracked_dark_oak_wall"),
			new GufyHopper(DARK_OAK, "cracked_dark_oak_hopper"),
			new GufyFence(DARK_OAK, "cracked_dark_oak_fence"),
			new GufyPanel(DARK_OAK, "cracked_dark_oak_panel"),
		//mossy_dark_oak
			new GufyBlock(DARK_OAK, "mossy_dark_oak"),
			new GufyStairs(DARK_OAK, "mossy_dark_oak_stairs"),
			new GufySlab(DARK_OAK, "mossy_dark_oak_slab"),
			new GufyVerticalSlab(DARK_OAK, "mossy_dark_oak_verticalslab"),
			new GufyWall(DARK_OAK, "mossy_dark_oak_wall"),
			new GufyHopper(DARK_OAK, "mossy_dark_oak_hopper"),
			new GufyFence(DARK_OAK, "mossy_dark_oak_fence"),
			new GufyPanel(DARK_OAK, "mossy_dark_oak_panel"),
		//dark_oak_parquet
			new GufyHorizontalBlock(DARK_OAK, "dark_oak_parquet"),
		//dark_oak_wood
			new GufyStairs(DARK_OAK, "dark_oak_wood_stairs"),
			new GufySlab(DARK_OAK, "dark_oak_wood_slab"),
			new GufyVerticalSlab(DARK_OAK, "dark_oak_wood_verticalslab"),
			new GufyWall(DARK_OAK, "dark_oak_wood_wall"),
			new GufyHopper(DARK_OAK, "dark_oak_wood_hopper"),
			new GufyFence(DARK_OAK, "dark_oak_wood_fence"),
			new GufyPanel(DARK_OAK, "dark_oak_wood_panel"),
		//stripped_dark_oak_wood
			new GufyStairs(DARK_OAK, "stripped_dark_oak_wood_stairs"),
			new GufySlab(DARK_OAK, "stripped_dark_oak_wood_slab"),
			new GufyVerticalSlab(DARK_OAK, "stripped_dark_oak_wood_verticalslab"),
			new GufyWall(DARK_OAK, "stripped_dark_oak_wood_wall"),
			new GufyHopper(DARK_OAK, "stripped_dark_oak_wood_hopper"),
			new GufyFence(DARK_OAK, "stripped_dark_oak_wood_fence"),
			new GufyPanel(DARK_OAK, "stripped_dark_oak_wood_panel"),
		//acacia
			new GufyVerticalSlab(ACACIA, "acacia_verticalslab"),
			new GufyWall(ACACIA, "acacia_wall"),
			new GufyHopper(ACACIA, "acacia_hopper"),
			new GufyPanel(ACACIA, "acacia_panel"),
		//cracked_acacia
			new GufyBlock(ACACIA, "cracked_acacia"),
			new GufyStairs(ACACIA, "cracked_acacia_stairs"),
			new GufySlab(ACACIA, "cracked_acacia_slab"),
			new GufyVerticalSlab(ACACIA, "cracked_acacia_verticalslab"),
			new GufyWall(ACACIA, "cracked_acacia_wall"),
			new GufyHopper(ACACIA, "cracked_acacia_hopper"),
			new GufyFence(ACACIA, "cracked_acacia_fence"),
			new GufyPanel(ACACIA, "cracked_acacia_panel"),
		//mossy_acacia
			new GufyBlock(ACACIA, "mossy_acacia"),
			new GufyStairs(ACACIA, "mossy_acacia_stairs"),
			new GufySlab(ACACIA, "mossy_acacia_slab"),
			new GufyVerticalSlab(ACACIA, "mossy_acacia_verticalslab"),
			new GufyWall(ACACIA, "mossy_acacia_wall"),
			new GufyHopper(ACACIA, "mossy_acacia_hopper"),
			new GufyFence(ACACIA, "mossy_acacia_fence"),
			new GufyPanel(ACACIA, "mossy_acacia_panel"),
		//acacia_parquet
			new GufyHorizontalBlock(ACACIA, "acacia_parquet"),
		//acacia_wood
			new GufyStairs(ACACIA, "acacia_wood_stairs"),
			new GufySlab(ACACIA, "acacia_wood_slab"),
			new GufyVerticalSlab(ACACIA, "acacia_wood_verticalslab"),
			new GufyWall(ACACIA, "acacia_wood_wall"),
			new GufyHopper(ACACIA, "acacia_wood_hopper"),
			new GufyFence(ACACIA, "acacia_wood_fence"),
			new GufyPanel(ACACIA, "acacia_wood_panel"),
		//stripped_acacia_wood
			new GufyStairs(ACACIA, "stripped_acacia_wood_stairs"),
			new GufySlab(ACACIA, "stripped_acacia_wood_slab"),
			new GufyVerticalSlab(ACACIA, "stripped_acacia_wood_verticalslab"),
			new GufyWall(ACACIA, "stripped_acacia_wood_wall"),
			new GufyHopper(ACACIA, "stripped_acacia_wood_hopper"),
			new GufyFence(ACACIA, "stripped_acacia_wood_fence"),
			new GufyPanel(ACACIA, "stripped_acacia_wood_panel"),
		//diorite
			new GufyVerticalSlab(DIORITE, "diorite_verticalslab"),
			new GufyHopper(DIORITE, "diorite_hopper"),
			new GufyPost(DIORITE, "diorite_post"),
			new GufyTrapdoor(DIORITE_TRAPDOOR, "diorite_trapdoor"),
		//polished_diorite
			new GufyVerticalSlab(DIORITE, "polished_diorite_verticalslab"),
			new GufyHopper(DIORITE, "polished_diorite_hopper"),
			new GufyWall(DIORITE, "polished_diorite_wall"),
			new GufyPost(DIORITE, "polished_diorite_post"),
		//diorite_bricks
			new GufyBlock(DIORITE, "diorite_bricks"),
			new GufyStairs(DIORITE, "diorite_bricks_stairs"),
			new GufySlab(DIORITE, "diorite_bricks_slab"),
			new GufyVerticalSlab(DIORITE, "diorite_bricks_verticalslab"),
			new GufyWall(DIORITE, "diorite_bricks_wall"),
			new GufyHopper(DIORITE, "diorite_bricks_hopper"),
			new GufyPost(DIORITE, "diorite_bricks_post"),
			new GufyPillar(DIORITE, "diorite_bricks_pillar"),
			new GufyBlock(DIORITE, "chiseled_diorite_bricks"),
		//cracked_diorite_bricks
			new GufyBlock(DIORITE, "cracked_diorite_bricks"),
			new GufyStairs(DIORITE, "cracked_diorite_bricks_stairs"),
			new GufySlab(DIORITE, "cracked_diorite_bricks_slab"),
			new GufyVerticalSlab(DIORITE, "cracked_diorite_bricks_verticalslab"),
			new GufyWall(DIORITE, "cracked_diorite_bricks_wall"),
			new GufyHopper(DIORITE, "cracked_diorite_bricks_hopper"),
			new GufyPost(DIORITE, "cracked_diorite_bricks_post"),
		//mossy_diorite_bricks
			new GufyBlock(DIORITE, "mossy_diorite_bricks"),
			new GufyStairs(DIORITE, "mossy_diorite_bricks_stairs"),
			new GufySlab(DIORITE, "mossy_diorite_bricks_slab"),
			new GufyVerticalSlab(DIORITE, "mossy_diorite_bricks_verticalslab"),
			new GufyWall(DIORITE, "mossy_diorite_bricks_wall"),
			new GufyHopper(DIORITE, "mossy_diorite_bricks_hopper"),
			new GufyPost(DIORITE, "mossy_diorite_bricks_post"),
		//diorite_cobble_bricks
			new GufyBlock(DIORITE_COBBLE, "diorite_cobble_bricks"),
			new GufyStairs(DIORITE_COBBLE, "diorite_cobble_bricks_stairs"),
			new GufySlab(DIORITE_COBBLE, "diorite_cobble_bricks_slab"),
			new GufyVerticalSlab(DIORITE_COBBLE, "diorite_cobble_bricks_verticalslab"),
			new GufyWall(DIORITE_COBBLE, "diorite_cobble_bricks_wall"),
			new GufyHopper(DIORITE_COBBLE, "diorite_cobble_bricks_hopper"),
			new GufyPost(DIORITE_COBBLE, "diorite_cobble_bricks_post"),
		//cracked_diorite_cobble_bricks
			new GufyBlock(DIORITE_COBBLE, "cracked_diorite_cobble_bricks"),
			new GufyStairs(DIORITE_COBBLE, "cracked_diorite_cobble_bricks_stairs"),
			new GufySlab(DIORITE_COBBLE, "cracked_diorite_cobble_bricks_slab"),
			new GufyVerticalSlab(DIORITE_COBBLE, "cracked_diorite_cobble_bricks_verticalslab"),
			new GufyWall(DIORITE_COBBLE, "cracked_diorite_cobble_bricks_wall"),
			new GufyHopper(DIORITE_COBBLE, "cracked_diorite_cobble_bricks_hopper"),
			new GufyPost(DIORITE_COBBLE, "cracked_diorite_cobble_bricks_post"),
		//mossy_diorite_cobble_bricks
			new GufyBlock(DIORITE_COBBLE, "mossy_diorite_cobble_bricks"),
			new GufyStairs(DIORITE_COBBLE, "mossy_diorite_cobble_bricks_stairs"),
			new GufySlab(DIORITE_COBBLE, "mossy_diorite_cobble_bricks_slab"),
			new GufyVerticalSlab(DIORITE_COBBLE, "mossy_diorite_cobble_bricks_verticalslab"),
			new GufyWall(DIORITE_COBBLE, "mossy_diorite_cobble_bricks_wall"),
			new GufyHopper(DIORITE_COBBLE, "mossy_diorite_cobble_bricks_hopper"),
			new GufyPost(DIORITE_COBBLE, "mossy_diorite_cobble_bricks_post"),
		//diorite_cobble
			new GufyBlock(DIORITE_COBBLE, "diorite_cobble"),
			new GufyStairs(DIORITE_COBBLE, "diorite_cobble_stairs"),
			new GufySlab(DIORITE_COBBLE, "diorite_cobble_slab"),
			new GufyVerticalSlab(DIORITE_COBBLE, "diorite_cobble_verticalslab"),
			new GufyWall(DIORITE_COBBLE, "diorite_cobble_wall"),
			new GufyHopper(DIORITE_COBBLE, "diorite_cobble_hopper"),
			new GufyPost(DIORITE_COBBLE, "diorite_cobble_post"),
		//mossy_diorite_cobble
			new GufyBlock(DIORITE_COBBLE, "mossy_diorite_cobble"),
			new GufyStairs(DIORITE_COBBLE, "mossy_diorite_cobble_stairs"),
			new GufySlab(DIORITE_COBBLE, "mossy_diorite_cobble_slab"),
			new GufyVerticalSlab(DIORITE_COBBLE, "mossy_diorite_cobble_verticalslab"),
			new GufyWall(DIORITE_COBBLE, "mossy_diorite_cobble_wall"),
			new GufyHopper(DIORITE_COBBLE, "mossy_diorite_cobble_hopper"),
			new GufyPost(DIORITE_COBBLE, "mossy_diorite_cobble_post"),
		//terracotta
			new GufyStairs(TERRACOTTA, "terracotta_stairs"),
			new GufySlab(TERRACOTTA, "terracotta_slab"),
			new GufyVerticalSlab(TERRACOTTA, "terracotta_verticalslab"),
			new GufyWall(TERRACOTTA, "terracotta_wall"),
			new GufyHopper(TERRACOTTA, "terracotta_hopper"),
			new GufyPost(TERRACOTTA, "terracotta_post"),
		//white_terracotta
			new GufyStairs(WHITE_TERRACOTTA, "white_terracotta_stairs"),
			new GufySlab(WHITE_TERRACOTTA, "white_terracotta_slab"),
			new GufyVerticalSlab(WHITE_TERRACOTTA, "white_terracotta_verticalslab"),
			new GufyWall(WHITE_TERRACOTTA, "white_terracotta_wall"),
			new GufyHopper(WHITE_TERRACOTTA, "white_terracotta_hopper"),
			new GufyPost(WHITE_TERRACOTTA, "white_terracotta_post"),
		//light_gray_terracotta
			new GufyStairs(LIGHT_GRAY_TERRACOTTA, "light_gray_terracotta_stairs"),
			new GufySlab(LIGHT_GRAY_TERRACOTTA, "light_gray_terracotta_slab"),
			new GufyVerticalSlab(LIGHT_GRAY_TERRACOTTA, "light_gray_terracotta_verticalslab"),
			new GufyWall(LIGHT_GRAY_TERRACOTTA, "light_gray_terracotta_wall"),
			new GufyHopper(LIGHT_GRAY_TERRACOTTA, "light_gray_terracotta_hopper"),
			new GufyPost(LIGHT_GRAY_TERRACOTTA, "light_gray_terracotta_post"),
		//gray_terracotta
			new GufyStairs(GRAY_TERRACOTTA, "gray_terracotta_stairs"),
			new GufySlab(GRAY_TERRACOTTA, "gray_terracotta_slab"),
			new GufyVerticalSlab(GRAY_TERRACOTTA, "gray_terracotta_verticalslab"),
			new GufyWall(GRAY_TERRACOTTA, "gray_terracotta_wall"),
			new GufyHopper(GRAY_TERRACOTTA, "gray_terracotta_hopper"),
			new GufyPost(GRAY_TERRACOTTA, "gray_terracotta_post"),
		//black_terracotta
			new GufyStairs(BLACK_TERRACOTTA, "black_terracotta_stairs"),
			new GufySlab(BLACK_TERRACOTTA, "black_terracotta_slab"),
			new GufyVerticalSlab(BLACK_TERRACOTTA, "black_terracotta_verticalslab"),
			new GufyWall(BLACK_TERRACOTTA, "black_terracotta_wall"),
			new GufyHopper(BLACK_TERRACOTTA, "black_terracotta_hopper"),
			new GufyPost(BLACK_TERRACOTTA, "black_terracotta_post"),
		//brown_terracotta
			new GufyStairs(BROWN_TERRACOTTA, "brown_terracotta_stairs"),
			new GufySlab(BROWN_TERRACOTTA, "brown_terracotta_slab"),
			new GufyVerticalSlab(BROWN_TERRACOTTA, "brown_terracotta_verticalslab"),
			new GufyWall(BROWN_TERRACOTTA, "brown_terracotta_wall"),
			new GufyHopper(BROWN_TERRACOTTA, "brown_terracotta_hopper"),
			new GufyPost(BROWN_TERRACOTTA, "brown_terracotta_post"),
		//red_terracotta
			new GufyStairs(RED_TERRACOTTA, "red_terracotta_stairs"),
			new GufySlab(RED_TERRACOTTA, "red_terracotta_slab"),
			new GufyVerticalSlab(RED_TERRACOTTA, "red_terracotta_verticalslab"),
			new GufyWall(RED_TERRACOTTA, "red_terracotta_wall"),
			new GufyHopper(RED_TERRACOTTA, "red_terracotta_hopper"),
			new GufyPost(RED_TERRACOTTA, "red_terracotta_post"),
		//orange_terracotta
			new GufyStairs(ORANGE_TERRACOTTA, "orange_terracotta_stairs"),
			new GufySlab(ORANGE_TERRACOTTA, "orange_terracotta_slab"),
			new GufyVerticalSlab(ORANGE_TERRACOTTA, "orange_terracotta_verticalslab"),
			new GufyWall(ORANGE_TERRACOTTA, "orange_terracotta_wall"),
			new GufyHopper(ORANGE_TERRACOTTA, "orange_terracotta_hopper"),
			new GufyPost(ORANGE_TERRACOTTA, "orange_terracotta_post"),
		//yellow_terracotta
			new GufyStairs(YELLOW_TERRACOTTA, "yellow_terracotta_stairs"),
			new GufySlab(YELLOW_TERRACOTTA, "yellow_terracotta_slab"),
			new GufyVerticalSlab(YELLOW_TERRACOTTA, "yellow_terracotta_verticalslab"),
			new GufyWall(YELLOW_TERRACOTTA, "yellow_terracotta_wall"),
			new GufyHopper(YELLOW_TERRACOTTA, "yellow_terracotta_hopper"),
			new GufyPost(YELLOW_TERRACOTTA, "yellow_terracotta_post"),
		//lime_terracotta
			new GufyStairs(LIME_TERRACOTTA, "lime_terracotta_stairs"),
			new GufySlab(LIME_TERRACOTTA, "lime_terracotta_slab"),
			new GufyVerticalSlab(LIME_TERRACOTTA, "lime_terracotta_verticalslab"),
			new GufyWall(LIME_TERRACOTTA, "lime_terracotta_wall"),
			new GufyHopper(LIME_TERRACOTTA, "lime_terracotta_hopper"),
			new GufyPost(LIME_TERRACOTTA, "lime_terracotta_post"),
		//green_terracotta
			new GufyStairs(GREEN_TERRACOTTA, "green_terracotta_stairs"),
			new GufySlab(GREEN_TERRACOTTA, "green_terracotta_slab"),
			new GufyVerticalSlab(GREEN_TERRACOTTA, "green_terracotta_verticalslab"),
			new GufyWall(GREEN_TERRACOTTA, "green_terracotta_wall"),
			new GufyHopper(GREEN_TERRACOTTA, "green_terracotta_hopper"),
			new GufyPost(GREEN_TERRACOTTA, "green_terracotta_post"),
		//cyan_terracotta
			new GufyStairs(CYAN_TERRACOTTA, "cyan_terracotta_stairs"),
			new GufySlab(CYAN_TERRACOTTA, "cyan_terracotta_slab"),
			new GufyVerticalSlab(CYAN_TERRACOTTA, "cyan_terracotta_verticalslab"),
			new GufyWall(CYAN_TERRACOTTA, "cyan_terracotta_wall"),
			new GufyHopper(CYAN_TERRACOTTA, "cyan_terracotta_hopper"),
			new GufyPost(CYAN_TERRACOTTA, "cyan_terracotta_post"),
		//light_blue_terracotta
			new GufyStairs(LIGHT_BLUE_TERRACOTTA, "light_blue_terracotta_stairs"),
			new GufySlab(LIGHT_BLUE_TERRACOTTA, "light_blue_terracotta_slab"),
			new GufyVerticalSlab(LIGHT_BLUE_TERRACOTTA, "light_blue_terracotta_verticalslab"),
			new GufyWall(LIGHT_BLUE_TERRACOTTA, "light_blue_terracotta_wall"),
			new GufyHopper(LIGHT_BLUE_TERRACOTTA, "light_blue_terracotta_hopper"),
			new GufyPost(LIGHT_BLUE_TERRACOTTA, "light_blue_terracotta_post"),
		//blue_terracotta
			new GufyStairs(BLUE_TERRACOTTA, "blue_terracotta_stairs"),
			new GufySlab(BLUE_TERRACOTTA, "blue_terracotta_slab"),
			new GufyVerticalSlab(BLUE_TERRACOTTA, "blue_terracotta_verticalslab"),
			new GufyWall(BLUE_TERRACOTTA, "blue_terracotta_wall"),
			new GufyHopper(BLUE_TERRACOTTA, "blue_terracotta_hopper"),
			new GufyPost(BLUE_TERRACOTTA, "blue_terracotta_post"),
		//purple_terracotta
			new GufyStairs(PURPLE_TERRACOTTA, "purple_terracotta_stairs"),
			new GufySlab(PURPLE_TERRACOTTA, "purple_terracotta_slab"),
			new GufyVerticalSlab(PURPLE_TERRACOTTA, "purple_terracotta_verticalslab"),
			new GufyWall(PURPLE_TERRACOTTA, "purple_terracotta_wall"),
			new GufyHopper(PURPLE_TERRACOTTA, "purple_terracotta_hopper"),
			new GufyPost(PURPLE_TERRACOTTA, "purple_terracotta_post"),
		//magenta_terracotta
			new GufyStairs(MAGENTA_TERRACOTTA, "magenta_terracotta_stairs"),
			new GufySlab(MAGENTA_TERRACOTTA, "magenta_terracotta_slab"),
			new GufyVerticalSlab(MAGENTA_TERRACOTTA, "magenta_terracotta_verticalslab"),
			new GufyWall(MAGENTA_TERRACOTTA, "magenta_terracotta_wall"),
			new GufyHopper(MAGENTA_TERRACOTTA, "magenta_terracotta_hopper"),
			new GufyPost(MAGENTA_TERRACOTTA, "magenta_terracotta_post"),
		//pink_terracotta
			new GufyStairs(PINK_TERRACOTTA, "pink_terracotta_stairs"),
			new GufySlab(PINK_TERRACOTTA, "pink_terracotta_slab"),
			new GufyVerticalSlab(PINK_TERRACOTTA, "pink_terracotta_verticalslab"),
			new GufyWall(PINK_TERRACOTTA, "pink_terracotta_wall"),
			new GufyHopper(PINK_TERRACOTTA, "pink_terracotta_hopper"),
			new GufyPost(PINK_TERRACOTTA, "pink_terracotta_post"),
		//white_concrete
			new GufyStairs(WHITE_CONCRETE, "white_concrete_stairs"),
			new GufySlab(WHITE_CONCRETE, "white_concrete_slab"),
			new GufyVerticalSlab(WHITE_CONCRETE, "white_concrete_verticalslab"),
			new GufyWall(WHITE_CONCRETE, "white_concrete_wall"),
			new GufyHopper(WHITE_CONCRETE, "white_concrete_hopper"),
			new GufyPost(WHITE_CONCRETE, "white_concrete_post"),
		//light_gray_concrete
			new GufyStairs(LIGHT_GRAY_CONCRETE, "light_gray_concrete_stairs"),
			new GufySlab(LIGHT_GRAY_CONCRETE, "light_gray_concrete_slab"),
			new GufyVerticalSlab(LIGHT_GRAY_CONCRETE, "light_gray_concrete_verticalslab"),
			new GufyWall(LIGHT_GRAY_CONCRETE, "light_gray_concrete_wall"),
			new GufyHopper(LIGHT_GRAY_CONCRETE, "light_gray_concrete_hopper"),
			new GufyPost(LIGHT_GRAY_CONCRETE, "light_gray_concrete_post"),
		//gray_concrete
			new GufyStairs(GRAY_CONCRETE, "gray_concrete_stairs"),
			new GufySlab(GRAY_CONCRETE, "gray_concrete_slab"),
			new GufyVerticalSlab(GRAY_CONCRETE, "gray_concrete_verticalslab"),
			new GufyWall(GRAY_CONCRETE, "gray_concrete_wall"),
			new GufyHopper(GRAY_CONCRETE, "gray_concrete_hopper"),
			new GufyPost(GRAY_CONCRETE, "gray_concrete_post"),
		//black_concrete
			new GufyStairs(BLACK_CONCRETE, "black_concrete_stairs"),
			new GufySlab(BLACK_CONCRETE, "black_concrete_slab"),
			new GufyVerticalSlab(BLACK_CONCRETE, "black_concrete_verticalslab"),
			new GufyWall(BLACK_CONCRETE, "black_concrete_wall"),
			new GufyHopper(BLACK_CONCRETE, "black_concrete_hopper"),
			new GufyPost(BLACK_CONCRETE, "black_concrete_post"),
		//brown_concrete
			new GufyStairs(BROWN_CONCRETE, "brown_concrete_stairs"),
			new GufySlab(BROWN_CONCRETE, "brown_concrete_slab"),
			new GufyVerticalSlab(BROWN_CONCRETE, "brown_concrete_verticalslab"),
			new GufyWall(BROWN_CONCRETE, "brown_concrete_wall"),
			new GufyHopper(BROWN_CONCRETE, "brown_concrete_hopper"),
			new GufyPost(BROWN_CONCRETE, "brown_concrete_post"),
		//red_concrete
			new GufyStairs(RED_CONCRETE, "red_concrete_stairs"),
			new GufySlab(RED_CONCRETE, "red_concrete_slab"),
			new GufyVerticalSlab(RED_CONCRETE, "red_concrete_verticalslab"),
			new GufyWall(RED_CONCRETE, "red_concrete_wall"),
			new GufyHopper(RED_CONCRETE, "red_concrete_hopper"),
			new GufyPost(RED_CONCRETE, "red_concrete_post"),
		//orange_concrete
			new GufyStairs(ORANGE_CONCRETE, "orange_concrete_stairs"),
			new GufySlab(ORANGE_CONCRETE, "orange_concrete_slab"),
			new GufyVerticalSlab(ORANGE_CONCRETE, "orange_concrete_verticalslab"),
			new GufyWall(ORANGE_CONCRETE, "orange_concrete_wall"),
			new GufyHopper(ORANGE_CONCRETE, "orange_concrete_hopper"),
			new GufyPost(ORANGE_CONCRETE, "orange_concrete_post"),
		//yellow_concrete
			new GufyStairs(YELLOW_CONCRETE, "yellow_concrete_stairs"),
			new GufySlab(YELLOW_CONCRETE, "yellow_concrete_slab"),
			new GufyVerticalSlab(YELLOW_CONCRETE, "yellow_concrete_verticalslab"),
			new GufyWall(YELLOW_CONCRETE, "yellow_concrete_wall"),
			new GufyHopper(YELLOW_CONCRETE, "yellow_concrete_hopper"),
			new GufyPost(YELLOW_CONCRETE, "yellow_concrete_post"),
		//lime_concrete
			new GufyStairs(LIME_CONCRETE, "lime_concrete_stairs"),
			new GufySlab(LIME_CONCRETE, "lime_concrete_slab"),
			new GufyVerticalSlab(LIME_CONCRETE, "lime_concrete_verticalslab"),
			new GufyWall(LIME_CONCRETE, "lime_concrete_wall"),
			new GufyHopper(LIME_CONCRETE, "lime_concrete_hopper"),
			new GufyPost(LIME_CONCRETE, "lime_concrete_post"),
		//green_concrete
			new GufyStairs(GREEN_CONCRETE, "green_concrete_stairs"),
			new GufySlab(GREEN_CONCRETE, "green_concrete_slab"),
			new GufyVerticalSlab(GREEN_CONCRETE, "green_concrete_verticalslab"),
			new GufyWall(GREEN_CONCRETE, "green_concrete_wall"),
			new GufyHopper(GREEN_CONCRETE, "green_concrete_hopper"),
			new GufyPost(GREEN_CONCRETE, "green_concrete_post"),
		//cyan_concrete
			new GufyStairs(CYAN_CONCRETE, "cyan_concrete_stairs"),
			new GufySlab(CYAN_CONCRETE, "cyan_concrete_slab"),
			new GufyVerticalSlab(CYAN_CONCRETE, "cyan_concrete_verticalslab"),
			new GufyWall(CYAN_CONCRETE, "cyan_concrete_wall"),
			new GufyHopper(CYAN_CONCRETE, "cyan_concrete_hopper"),
			new GufyPost(CYAN_CONCRETE, "cyan_concrete_post"),
		//light_blue_concrete
			new GufyStairs(LIGHT_BLUE_CONCRETE, "light_blue_concrete_stairs"),
			new GufySlab(LIGHT_BLUE_CONCRETE, "light_blue_concrete_slab"),
			new GufyVerticalSlab(LIGHT_BLUE_CONCRETE, "light_blue_concrete_verticalslab"),
			new GufyWall(LIGHT_BLUE_CONCRETE, "light_blue_concrete_wall"),
			new GufyHopper(LIGHT_BLUE_CONCRETE, "light_blue_concrete_hopper"),
			new GufyPost(LIGHT_BLUE_CONCRETE, "light_blue_concrete_post"),
		//blue_concrete
			new GufyStairs(BLUE_CONCRETE, "blue_concrete_stairs"),
			new GufySlab(BLUE_CONCRETE, "blue_concrete_slab"),
			new GufyVerticalSlab(BLUE_CONCRETE, "blue_concrete_verticalslab"),
			new GufyWall(BLUE_CONCRETE, "blue_concrete_wall"),
			new GufyHopper(BLUE_CONCRETE, "blue_concrete_hopper"),
			new GufyPost(BLUE_CONCRETE, "blue_concrete_post"),
		//purple_concrete
			new GufyStairs(PURPLE_CONCRETE, "purple_concrete_stairs"),
			new GufySlab(PURPLE_CONCRETE, "purple_concrete_slab"),
			new GufyVerticalSlab(PURPLE_CONCRETE, "purple_concrete_verticalslab"),
			new GufyWall(PURPLE_CONCRETE, "purple_concrete_wall"),
			new GufyHopper(PURPLE_CONCRETE, "purple_concrete_hopper"),
			new GufyPost(PURPLE_CONCRETE, "purple_concrete_post"),
		//magenta_concrete
			new GufyStairs(MAGENTA_CONCRETE, "magenta_concrete_stairs"),
			new GufySlab(MAGENTA_CONCRETE, "magenta_concrete_slab"),
			new GufyVerticalSlab(MAGENTA_CONCRETE, "magenta_concrete_verticalslab"),
			new GufyWall(MAGENTA_CONCRETE, "magenta_concrete_wall"),
			new GufyHopper(MAGENTA_CONCRETE, "magenta_concrete_hopper"),
			new GufyPost(MAGENTA_CONCRETE, "magenta_concrete_post"),
		//pink_concrete
			new GufyStairs(PINK_CONCRETE, "pink_concrete_stairs"),
			new GufySlab(PINK_CONCRETE, "pink_concrete_slab"),
			new GufyVerticalSlab(PINK_CONCRETE, "pink_concrete_verticalslab"),
			new GufyWall(PINK_CONCRETE, "pink_concrete_wall"),
			new GufyHopper(PINK_CONCRETE, "pink_concrete_hopper"),
			new GufyPost(PINK_CONCRETE, "pink_concrete_post"),
		//white_wool
			new GufyStairs(WHITE_WOOL, "white_wool_stairs"),
			new GufySlab(WHITE_WOOL, "white_wool_slab"),
			new GufyVerticalSlab(WHITE_WOOL, "white_wool_verticalslab"),
			new GufyTrapdoor(WHITE_WOOL, "white_wool_trapdoor"),
		//light_gray_wool
			new GufyStairs(LIGHT_GRAY_WOOL, "light_gray_wool_stairs"),
			new GufySlab(LIGHT_GRAY_WOOL, "light_gray_wool_slab"),
			new GufyVerticalSlab(LIGHT_GRAY_WOOL, "light_gray_wool_verticalslab"),
			new GufyTrapdoor(LIGHT_GRAY_WOOL, "light_gray_wool_trapdoor"),
		//gray_wool
			new GufyStairs(GRAY_WOOL, "gray_wool_stairs"),
			new GufySlab(GRAY_WOOL, "gray_wool_slab"),
			new GufyVerticalSlab(GRAY_WOOL, "gray_wool_verticalslab"),
			new GufyTrapdoor(GRAY_WOOL, "gray_wool_trapdoor"),
		//black_wool
			new GufyStairs(BLACK_WOOL, "black_wool_stairs"),
			new GufySlab(BLACK_WOOL, "black_wool_slab"),
			new GufyVerticalSlab(BLACK_WOOL, "black_wool_verticalslab"),
			new GufyTrapdoor(BLACK_WOOL, "black_wool_trapdoor"),
		//brown_wool
			new GufyStairs(BROWN_WOOL, "brown_wool_stairs"),
			new GufySlab(BROWN_WOOL, "brown_wool_slab"),
			new GufyVerticalSlab(BROWN_WOOL, "brown_wool_verticalslab"),
			new GufyTrapdoor(BROWN_WOOL, "brown_wool_trapdoor"),
		//red_wool
			new GufyStairs(RED_WOOL, "red_wool_stairs"),
			new GufySlab(RED_WOOL, "red_wool_slab"),
			new GufyVerticalSlab(RED_WOOL, "red_wool_verticalslab"),
			new GufyTrapdoor(RED_WOOL, "red_wool_trapdoor"),
		//orange_wool
			new GufyStairs(ORANGE_WOOL, "orange_wool_stairs"),
			new GufySlab(ORANGE_WOOL, "orange_wool_slab"),
			new GufyVerticalSlab(ORANGE_WOOL, "orange_wool_verticalslab"),
			new GufyTrapdoor(ORANGE_WOOL, "orange_wool_trapdoor"),
		//yellow_wool
			new GufyStairs(YELLOW_WOOL, "yellow_wool_stairs"),
			new GufySlab(YELLOW_WOOL, "yellow_wool_slab"),
			new GufyVerticalSlab(YELLOW_WOOL, "yellow_wool_verticalslab"),
			new GufyTrapdoor(YELLOW_WOOL, "yellow_wool_trapdoor"),
		//lime_wool
			new GufyStairs(LIME_WOOL, "lime_wool_stairs"),
			new GufySlab(LIME_WOOL, "lime_wool_slab"),
			new GufyVerticalSlab(LIME_WOOL, "lime_wool_verticalslab"),
			new GufyTrapdoor(LIME_WOOL, "lime_wool_trapdoor"),
		//green_wool
			new GufyStairs(GREEN_WOOL, "green_wool_stairs"),
			new GufySlab(GREEN_WOOL, "green_wool_slab"),
			new GufyVerticalSlab(GREEN_WOOL, "green_wool_verticalslab"),
			new GufyTrapdoor(GREEN_WOOL, "green_wool_trapdoor"),
		//cyan_wool
			new GufyStairs(CYAN_WOOL, "cyan_wool_stairs"),
			new GufySlab(CYAN_WOOL, "cyan_wool_slab"),
			new GufyVerticalSlab(CYAN_WOOL, "cyan_wool_verticalslab"),
			new GufyTrapdoor(CYAN_WOOL, "cyan_wool_trapdoor"),
		//light_blue_wool
			new GufyStairs(LIGHT_BLUE_WOOL, "light_blue_wool_stairs"),
			new GufySlab(LIGHT_BLUE_WOOL, "light_blue_wool_slab"),
			new GufyVerticalSlab(LIGHT_BLUE_WOOL, "light_blue_wool_verticalslab"),
			new GufyTrapdoor(LIGHT_BLUE_WOOL, "light_blue_wool_trapdoor"),
		//blue_wool
			new GufyStairs(BLUE_WOOL, "blue_wool_stairs"),
			new GufySlab(BLUE_WOOL, "blue_wool_slab"),
			new GufyVerticalSlab(BLUE_WOOL, "blue_wool_verticalslab"),
			new GufyTrapdoor(BLUE_WOOL, "blue_wool_trapdoor"),
		//purple_wool
			new GufyStairs(PURPLE_WOOL, "purple_wool_stairs"),
			new GufySlab(PURPLE_WOOL, "purple_wool_slab"),
			new GufyVerticalSlab(PURPLE_WOOL, "purple_wool_verticalslab"),
			new GufyTrapdoor(PURPLE_WOOL, "purple_wool_trapdoor"),
		//magenta_wool
			new GufyStairs(MAGENTA_WOOL, "magenta_wool_stairs"),
			new GufySlab(MAGENTA_WOOL, "magenta_wool_slab"),
			new GufyVerticalSlab(MAGENTA_WOOL, "magenta_wool_verticalslab"),
			new GufyTrapdoor(MAGENTA_WOOL, "magenta_wool_trapdoor"),
		//pink_wool
			new GufyStairs(PINK_WOOL, "pink_wool_stairs"),
			new GufySlab(PINK_WOOL, "pink_wool_slab"),
			new GufyVerticalSlab(PINK_WOOL, "pink_wool_verticalslab"),
			new GufyTrapdoor(PINK_WOOL, "pink_wool_trapdoor"),
		//crimson
			new GufyVerticalSlab(CRIMSON, "crimson_verticalslab"),
			new GufyWall(CRIMSON, "crimson_wall"),
			new GufyHopper(CRIMSON, "crimson_hopper"),
			new GufyPanel(CRIMSON, "crimson_panel"),
		//cracked_crimson
			new GufyBlock(CRIMSON, "cracked_crimson"),
			new GufyStairs(CRIMSON, "cracked_crimson_stairs"),
			new GufySlab(CRIMSON, "cracked_crimson_slab"),
			new GufyVerticalSlab(CRIMSON, "cracked_crimson_verticalslab"),
			new GufyWall(CRIMSON, "cracked_crimson_wall"),
			new GufyHopper(CRIMSON, "cracked_crimson_hopper"),
			new GufyFence(CRIMSON, "cracked_crimson_fence"),
			new GufyPanel(CRIMSON, "cracked_crimson_panel"),
		//mossy_crimson
			new GufyBlock(CRIMSON, "mossy_crimson"),
			new GufyStairs(CRIMSON, "mossy_crimson_stairs"),
			new GufySlab(CRIMSON, "mossy_crimson_slab"),
			new GufyVerticalSlab(CRIMSON, "mossy_crimson_verticalslab"),
			new GufyWall(CRIMSON, "mossy_crimson_wall"),
			new GufyHopper(CRIMSON, "mossy_crimson_hopper"),
			new GufyFence(CRIMSON, "mossy_crimson_fence"),
			new GufyPanel(CRIMSON, "mossy_crimson_panel"),
		//crimson_parquet
			new GufyHorizontalBlock(CRIMSON, "crimson_parquet"),
		//crimson_hyphae
			new GufyStairs(CRIMSON, "crimson_hyphae_stairs"),
			new GufySlab(CRIMSON, "crimson_hyphae_slab"),
			new GufyVerticalSlab(CRIMSON, "crimson_hyphae_verticalslab"),
			new GufyWall(CRIMSON, "crimson_hyphae_wall"),
			new GufyHopper(CRIMSON, "crimson_hyphae_hopper"),
			new GufyFence(CRIMSON, "crimson_hyphae_fence"),
			new GufyPanel(CRIMSON, "crimson_hyphae_panel"),
		//stripped_crimson_hyphae
			new GufyStairs(CRIMSON, "stripped_crimson_hyphae_stairs"),
			new GufySlab(CRIMSON, "stripped_crimson_hyphae_slab"),
			new GufyVerticalSlab(CRIMSON, "stripped_crimson_hyphae_verticalslab"),
			new GufyWall(CRIMSON, "stripped_crimson_hyphae_wall"),
			new GufyHopper(CRIMSON, "stripped_crimson_hyphae_hopper"),
			new GufyFence(CRIMSON, "stripped_crimson_hyphae_fence"),
			new GufyPanel(CRIMSON, "stripped_crimson_hyphae_panel"),
		//warped
			new GufyVerticalSlab(WARPED, "warped_verticalslab"),
			new GufyWall(WARPED, "warped_wall"),
			new GufyHopper(WARPED, "warped_hopper"),
			new GufyPanel(WARPED, "warped_panel"),
		//cracked_warped
			new GufyBlock(WARPED, "cracked_warped"),
			new GufyStairs(WARPED, "cracked_warped_stairs"),
			new GufySlab(WARPED, "cracked_warped_slab"),
			new GufyVerticalSlab(WARPED, "cracked_warped_verticalslab"),
			new GufyWall(WARPED, "cracked_warped_wall"),
			new GufyHopper(WARPED, "cracked_warped_hopper"),
			new GufyFence(WARPED, "cracked_warped_fence"),
			new GufyPanel(WARPED, "cracked_warped_panel"),
		//mossy_warped
			new GufyBlock(WARPED, "mossy_warped"),
			new GufyStairs(WARPED, "mossy_warped_stairs"),
			new GufySlab(WARPED, "mossy_warped_slab"),
			new GufyVerticalSlab(WARPED, "mossy_warped_verticalslab"),
			new GufyWall(WARPED, "mossy_warped_wall"),
			new GufyHopper(WARPED, "mossy_warped_hopper"),
			new GufyFence(WARPED, "mossy_warped_fence"),
			new GufyPanel(WARPED, "mossy_warped_panel"),
		//warped_parquet
			new GufyHorizontalBlock(WARPED, "warped_parquet"),
		//warped_hyphae
			new GufyStairs(WARPED, "warped_hyphae_stairs"),
			new GufySlab(WARPED, "warped_hyphae_slab"),
			new GufyVerticalSlab(WARPED, "warped_hyphae_verticalslab"),
			new GufyWall(WARPED, "warped_hyphae_wall"),
			new GufyHopper(WARPED, "warped_hyphae_hopper"),
			new GufyFence(WARPED, "warped_hyphae_fence"),
			new GufyPanel(WARPED, "warped_hyphae_panel"),
		//stripped_warped_hyphae
			new GufyStairs(WARPED, "stripped_warped_hyphae_stairs"),
			new GufySlab(WARPED, "stripped_warped_hyphae_slab"),
			new GufyVerticalSlab(WARPED, "stripped_warped_hyphae_verticalslab"),
			new GufyWall(WARPED, "stripped_warped_hyphae_wall"),
			new GufyHopper(WARPED, "stripped_warped_hyphae_hopper"),
			new GufyFence(WARPED, "stripped_warped_hyphae_fence"),
			new GufyPanel(WARPED, "stripped_warped_hyphae_panel"),
		//nether_wart
			new GufyStairs(NETHER_WART, "nether_wart_stairs"),
			new GufySlab(NETHER_WART, "nether_wart_slab"),
			new GufyVerticalSlab(NETHER_WART, "nether_wart_verticalslab"),
		//warped_wart
			new GufyStairs(WARPED_WART, "warped_wart_stairs"),
			new GufySlab(WARPED_WART, "warped_wart_slab"),
			new GufyVerticalSlab(WARPED_WART, "warped_wart_verticalslab"),
		//wagon_wheel
			new GufyTrapdoor(SPRUCE_TRAPDOOR, "wagon_wheel"),
		//granite_cobble_bricks
			new GufyBlock(GRANITE_COBBLE, "granite_cobble_bricks"),
			new GufyStairs(GRANITE_COBBLE, "granite_cobble_bricks_stairs"),
			new GufySlab(GRANITE_COBBLE, "granite_cobble_bricks_slab"),
			new GufyVerticalSlab(GRANITE_COBBLE, "granite_cobble_bricks_verticalslab"),
			new GufyWall(GRANITE_COBBLE, "granite_cobble_bricks_wall"),
			new GufyHopper(GRANITE_COBBLE, "granite_cobble_bricks_hopper"),
			new GufyPost(GRANITE_COBBLE, "granite_cobble_bricks_post"),
		//leaded_glass
			new GufyPane(LEADED_GLASS, "leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "white_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "light_gray_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "gray_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "black_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "brown_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "red_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "orange_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "yellow_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "lime_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "green_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "cyan_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "light_blue_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "blue_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "purple_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "magenta_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "pink_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "oakfield_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "avalon_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "gufy_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "midland_leaded_glass_pane"),
			new GufyPane(LEADED_GLASS, "ring_leaded_glass_pane"),
		//framed_glass
			new GufyPane(FRAMED_GLASS, "spruce_framed_glass_pane"),
			new GufyPane(FRAMED_GLASS, "oak_framed_glass_pane"),
			new GufyPane(FRAMED_GLASS, "birch_framed_glass_pane"),
			new GufyPane(FRAMED_GLASS, "dark_oak_framed_glass_pane"),
			new GufyPane(FRAMED_GLASS, "jungle_framed_glass_pane"),
			new GufyPane(FRAMED_GLASS, "acacia_framed_glass_pane"),
			new GufyPane(FRAMED_GLASS, "crimson_framed_glass_pane"),
			new GufyPane(FRAMED_GLASS, "warped_framed_glass_pane"),
		//framed_daub
			new GufyHorizontalBlock(FRAMED_BROWN, "spruce_framed_daub"),
			new GufyHorizontalBlock(FRAMED_BROWN, "oak_framed_daub"),
			new GufyHorizontalBlock(FRAMED_BROWN, "birch_framed_daub"),
			new GufyHorizontalBlock(FRAMED_BROWN, "dark_oak_framed_daub"),
			new GufyHorizontalBlock(FRAMED_BROWN, "jungle_framed_daub"),
			new GufyHorizontalBlock(FRAMED_BROWN, "acacia_framed_daub"),
			new GufyHorizontalBlock(FRAMED_BROWN, "crimson_framed_daub"),
			new GufyHorizontalBlock(FRAMED_BROWN, "warped_framed_daub"),
		//framed_terracotta
			new GufyHorizontalBlock(FRAMED_WHITE, "spruce_framed_terracotta"),
			new GufyHorizontalBlock(FRAMED_WHITE, "oak_framed_terracotta"),
			new GufyHorizontalBlock(FRAMED_WHITE, "birch_framed_terracotta"),
			new GufyHorizontalBlock(FRAMED_WHITE, "dark_oak_framed_terracotta"),
			new GufyHorizontalBlock(FRAMED_WHITE, "jungle_framed_terracotta"),
			new GufyHorizontalBlock(FRAMED_WHITE, "acacia_framed_terracotta"),
			new GufyHorizontalBlock(FRAMED_WHITE, "crimson_framed_terracotta"),
			new GufyHorizontalBlock(FRAMED_WHITE, "warped_framed_terracotta"),
		//brick
			new GufyVerticalSlab(BRICK, "brick_verticalslab"),
			new GufyHopper(BRICK, "brick_hopper"),
			new GufyPost(BRICK, "brick_post"),
		//granite
			new GufyVerticalSlab(GRANITE, "granite_verticalslab"),
			new GufyHopper(GRANITE, "granite_hopper"),
			new GufyPost(GRANITE, "granite_post"),
			new GufyTrapdoor(GRANITE_TRAPDOOR, "granite_trapdoor"),
		//andesite
			new GufyVerticalSlab(GRANITE, "andesite_verticalslab"),
			new GufyHopper(GRANITE, "andesite_hopper"),
			new GufyPost(GRANITE, "andesite_post"),
			new GufyTrapdoor(ANDESITE_TRAPDOOR, "andesite_trapdoor"),
		//polished_andesite
			new GufyVerticalSlab(ANDESITE, "polished_andesite_verticalslab"),
			new GufyHopper(ANDESITE, "polished_andesite_hopper"),
			new GufyPost(ANDESITE, "polished_andesite_post"),
			new GufyWall(ANDESITE, "polished_andesite_wall"),
		//calcite
			new GufyStairs(CALCITE, "calcite_stairs"),
			new GufySlab(CALCITE, "calcite_slab"),
			new GufyVerticalSlab(CALCITE, "calcite_verticalslab"),
			new GufyWall(CALCITE, "calcite_wall"),
			new GufyHopper(CALCITE, "calcite_hopper"),
			new GufyPost(CALCITE, "calcite_post"),
		//smooth_basalt
			new GufyStairs(BASALT, "smooth_basalt_stairs"),
			new GufySlab(BASALT, "smooth_basalt_slab"),
			new GufyVerticalSlab(BASALT, "smooth_basalt_verticalslab"),
			new GufyWall(BASALT, "smooth_basalt_wall"),
			new GufyHopper(BASALT, "smooth_basalt_hopper"),
			new GufyPost(BASALT, "smooth_basalt_post"),
		//moss
			new GufyStairs(MOSS, "moss_stairs"),
			new GufySlab(MOSS, "moss_slab"),
			new GufyVerticalSlab(MOSS, "moss_verticalslab"),
		//rooted_dirt
			new GufyStairs(ROOTED_DIRT, "rooted_dirt_stairs"),
			new GufySlab(ROOTED_DIRT, "rooted_dirt_slab"),
			new GufyVerticalSlab(ROOTED_DIRT, "rooted_dirt_verticalslab"),



		// !!!! HERE !!!! //
		//cobbled_deepslate
			new GufyVerticalSlab(COBBLED_DEEPSLATE, "cobbled_deepslate_verticalslab"),
			new GufyHopper(COBBLED_DEEPSLATE, "cobbled_deepslate_hopper"),
			new GufyPost(COBBLED_DEEPSLATE, "cobbled_deepslate_post"),
		//deepslate_bricks
			new GufyVerticalSlab(DEEPSLATE_BRICK, "deepslate_bricks_verticalslab"),
			new GufyHopper(DEEPSLATE_BRICK, "deepslate_bricks_hopper"),
			new GufyPost(DEEPSLATE_BRICK, "deepslate_bricks_post"),
		//deepslate_tiles
			new GufyVerticalSlab(TILED_DEEPSLATE, "deepslate_tiles_verticalslab"),
			new GufyHopper(TILED_DEEPSLATE, "deepslate_tiles_hopper"),
			new GufyPost(TILED_DEEPSLATE, "deepslate_tiles_post"),
		//polished_deepslate
			new GufyVerticalSlab(POLISHED_DEEPSLATE, "polished_deepslate_verticalslab"),
			new GufyHopper(POLISHED_DEEPSLATE, "polished_deepslate_hopper"),
			new GufyPost(POLISHED_DEEPSLATE, "polished_deepslate_post"),
		//cracked_deepslate_bricks
			new GufyStairs(DEEPSLATE_BRICK, "cracked_deepslate_bricks_stairs"),
			new GufySlab(DEEPSLATE_BRICK, "cracked_deepslate_bricks_slab"),
			new GufyVerticalSlab(DEEPSLATE_BRICK, "cracked_deepslate_bricks_verticalslab"),
			new GufyWall(DEEPSLATE_BRICK, "cracked_deepslate_bricks_wall"),
			new GufyHopper(DEEPSLATE_BRICK, "cracked_deepslate_bricks_hopper"),
			new GufyPost(DEEPSLATE_BRICK, "cracked_deepslate_bricks_post"),
		//cracked_deepslate_tiles
			new GufyStairs(TILED_DEEPSLATE, "cracked_deepslate_tiles_stairs"),
			new GufySlab(TILED_DEEPSLATE, "cracked_deepslate_tiles_slab"),
			new GufyVerticalSlab(TILED_DEEPSLATE, "cracked_deepslate_tiles_verticalslab"),
			new GufyWall(TILED_DEEPSLATE, "cracked_deepslate_tiles_wall"),
			new GufyHopper(TILED_DEEPSLATE, "cracked_deepslate_tiles_hopper"),
			new GufyPost(TILED_DEEPSLATE, "cracked_deepslate_tiles_post"),
		//quartz
			new GufyVerticalSlab(QUARTZ, "quartz_verticalslab"),
			new GufyWall(QUARTZ, "quartz_wall"),
			new GufyHopper(QUARTZ, "quartz_hopper"),
			new GufyPost(QUARTZ, "quartz_post"),
		//smooth_quartz
			new GufyVerticalSlab(QUARTZ, "smooth_quartz_verticalslab"),
			new GufyWall(QUARTZ, "smooth_quartz_wall"),
			new GufyHopper(QUARTZ, "smooth_quartz_hopper"),
			new GufyPost(QUARTZ, "smooth_quartz_post"),
		//quartz_bricks
			new GufyStairs(QUARTZ, "quartz_bricks_stairs"),
			new GufySlab(QUARTZ, "quartz_bricks_slab"),
			new GufyVerticalSlab(QUARTZ, "quartz_bricks_verticalslab"),
			new GufyWall(QUARTZ, "quartz_bricks_wall"),
			new GufyHopper(QUARTZ, "quartz_bricks_hopper"),
			new GufyPost(QUARTZ, "quartz_bricks_post"),
		//iron
			new GufyStairs(IRON, "iron_stairs"),
			new GufySlab(IRON, "iron_slab"),
			new GufyVerticalSlab(IRON, "iron_verticalslab"),
			new GufyWall(IRON, "iron_wall"),
			new GufyHopper(IRON, "iron_hopper"),
			new GufyPost(IRON, "iron_post"),
		//gold
			new GufyStairs(GOLD, "gold_stairs"),
			new GufySlab(GOLD, "gold_slab"),
			new GufyVerticalSlab(GOLD, "gold_verticalslab"),
			new GufyWall(GOLD, "gold_wall"),
			new GufyHopper(GOLD, "gold_hopper"),
			new GufyPost(GOLD, "gold_post"),
		//emerald
			new GufyStairs(EMERALD, "emerald_stairs"),
			new GufySlab(EMERALD, "emerald_slab"),
			new GufyVerticalSlab(EMERALD, "emerald_verticalslab"),
			new GufyWall(EMERALD, "emerald_wall"),
			new GufyHopper(EMERALD, "emerald_hopper"),
			new GufyPost(EMERALD, "emerald_post"),
		//diamond
			new GufyStairs(DIAMOND, "diamond_stairs"),
			new GufySlab(DIAMOND, "diamond_slab"),
			new GufyVerticalSlab(DIAMOND, "diamond_verticalslab"),
			new GufyWall(DIAMOND, "diamond_wall"),
			new GufyHopper(DIAMOND, "diamond_hopper"),
			new GufyPost(DIAMOND, "diamond_post"),
		//nether_brick
			new GufyVerticalSlab(NETHER_BRICKS, "nether_brick_verticalslab"),
			new GufyHopper(NETHER_BRICKS, "nether_brick_hopper"),
		//sandstone
			new GufyVerticalSlab(SANDSTONE, "sandstone_verticalslab"),
			new GufyHopper(SANDSTONE, "sandstone_hopper"),
			new GufyPost(SANDSTONE, "sandstone_post"),
		//smooth_sandstone
			new GufyVerticalSlab(SMOOTH_SANDSTONE, "smooth_sandstone_verticalslab"),
			new GufyWall(SMOOTH_SANDSTONE, "smooth_sandstone_wall"),
			new GufyHopper(SMOOTH_SANDSTONE, "smooth_sandstone_hopper"),
			new GufyPost(SMOOTH_SANDSTONE, "smooth_sandstone_post"),
		//cut_sandstone
			new GufyVerticalSlab(SANDSTONE, "cut_sandstone_verticalslab"),
			new GufyWall(SANDSTONE, "cut_sandstone_wall"),
			new GufyHopper(SANDSTONE, "cut_sandstone_hopper"),
			new GufyPost(SANDSTONE, "cut_sandstone_post"),
		//red_sandstone
			new GufyVerticalSlab(RED_SANDSTONE, "red_sandstone_verticalslab"),
			new GufyHopper(RED_SANDSTONE, "red_sandstone_hopper"),
			new GufyPost(RED_SANDSTONE, "red_sandstone_post"),
		//smooth_red_sandstone
			new GufyVerticalSlab(SMOOTH_RED_SANDSTONE, "smooth_red_sandstone_verticalslab"),
			new GufyWall(SMOOTH_RED_SANDSTONE, "smooth_red_sandstone_wall"),
			new GufyHopper(SMOOTH_RED_SANDSTONE, "smooth_red_sandstone_hopper"),
			new GufyPost(SMOOTH_RED_SANDSTONE, "smooth_red_sandstone_post"),
		//cut_red_sandstone
			new GufyVerticalSlab(RED_SANDSTONE, "cut_red_sandstone_verticalslab"),
			new GufyWall(RED_SANDSTONE, "cut_red_sandstone_wall"),
			new GufyHopper(RED_SANDSTONE, "cut_red_sandstone_hopper"),
			new GufyPost(RED_SANDSTONE, "cut_red_sandstone_post"),


			// HERE //
		//copper
			new GufyWeatheringStairs(COPPER, "copper_stairs", GufyWeathering.WeatherState.UNAFFECTED),
			new GufyWeatheringSlab(COPPER, "copper_slab", GufyWeathering.WeatherState.UNAFFECTED),
			new GufyWeatheringVerticalSlab(COPPER, "copper_verticalslab", GufyWeathering.WeatherState.UNAFFECTED),
			new GufyWeatheringWall(COPPER, "copper_wall", GufyWeathering.WeatherState.UNAFFECTED),
			new GufyWeatheringHopper(COPPER, "copper_hopper", GufyWeathering.WeatherState.UNAFFECTED),
			new GufyWeatheringPost(COPPER, "copper_post", GufyWeathering.WeatherState.UNAFFECTED),
		//cut_copper
			new GufyWeatheringVerticalSlab(COPPER, "cut_copper_verticalslab", GufyWeathering.WeatherState.UNAFFECTED),
			new GufyWeatheringWall(COPPER, "cut_copper_wall", GufyWeathering.WeatherState.UNAFFECTED),
			new GufyWeatheringHopper(COPPER, "cut_copper_hopper", GufyWeathering.WeatherState.UNAFFECTED),
			new GufyWeatheringPost(COPPER, "cut_copper_post", GufyWeathering.WeatherState.UNAFFECTED),
		//exposed_copper
			new GufyWeatheringStairs(EXPOSED_COPPER, "exposed_copper_stairs", GufyWeathering.WeatherState.EXPOSED),
			new GufyWeatheringSlab(EXPOSED_COPPER, "exposed_copper_slab", GufyWeathering.WeatherState.EXPOSED),
			new GufyWeatheringVerticalSlab(EXPOSED_COPPER, "exposed_copper_verticalslab", GufyWeathering.WeatherState.EXPOSED),
			new GufyWeatheringWall(EXPOSED_COPPER, "exposed_copper_wall", GufyWeathering.WeatherState.EXPOSED),
			new GufyWeatheringHopper(EXPOSED_COPPER, "exposed_copper_hopper", GufyWeathering.WeatherState.EXPOSED),
			new GufyWeatheringPost(EXPOSED_COPPER, "exposed_copper_post", GufyWeathering.WeatherState.EXPOSED),
		//exposed_cut_copper
			new GufyWeatheringVerticalSlab(EXPOSED_COPPER, "exposed_cut_copper_verticalslab", GufyWeathering.WeatherState.EXPOSED),
			new GufyWeatheringWall(EXPOSED_COPPER, "exposed_cut_copper_wall", GufyWeathering.WeatherState.EXPOSED),
			new GufyWeatheringHopper(EXPOSED_COPPER, "exposed_cut_copper_hopper", GufyWeathering.WeatherState.EXPOSED),
			new GufyWeatheringPost(EXPOSED_COPPER, "exposed_cut_copper_post", GufyWeathering.WeatherState.EXPOSED),
		//weathered_copper
			new GufyWeatheringStairs(WEATHERED_COPPER, "weathered_copper_stairs", GufyWeathering.WeatherState.WEATHERED),
			new GufyWeatheringSlab(WEATHERED_COPPER, "weathered_copper_slab", GufyWeathering.WeatherState.WEATHERED),
			new GufyWeatheringVerticalSlab(WEATHERED_COPPER, "weathered_copper_verticalslab", GufyWeathering.WeatherState.WEATHERED),
			new GufyWeatheringWall(WEATHERED_COPPER, "weathered_copper_wall", GufyWeathering.WeatherState.WEATHERED),
			new GufyWeatheringHopper(WEATHERED_COPPER, "weathered_copper_hopper", GufyWeathering.WeatherState.WEATHERED),
			new GufyWeatheringPost(WEATHERED_COPPER, "weathered_copper_post", GufyWeathering.WeatherState.WEATHERED),
		//weathered_cut_copper
			new GufyWeatheringVerticalSlab(WEATHERED_COPPER, "weathered_cut_copper_verticalslab", GufyWeathering.WeatherState.WEATHERED),
			new GufyWeatheringWall(WEATHERED_COPPER, "weathered_cut_copper_wall", GufyWeathering.WeatherState.WEATHERED),
			new GufyWeatheringHopper(WEATHERED_COPPER, "weathered_cut_copper_hopper", GufyWeathering.WeatherState.WEATHERED),
			new GufyWeatheringPost(WEATHERED_COPPER, "weathered_cut_copper_post", GufyWeathering.WeatherState.WEATHERED),
		//oxidized_copper
			new GufyWeatheringStairs(OXIDIZED_COPPER, "oxidized_copper_stairs", GufyWeathering.WeatherState.OXIDIZED),
			new GufyWeatheringSlab(OXIDIZED_COPPER, "oxidized_copper_slab", GufyWeathering.WeatherState.OXIDIZED),
			new GufyWeatheringVerticalSlab(OXIDIZED_COPPER, "oxidized_copper_verticalslab", GufyWeathering.WeatherState.OXIDIZED),
			new GufyWeatheringWall(OXIDIZED_COPPER, "oxidized_copper_wall", GufyWeathering.WeatherState.OXIDIZED),
			new GufyWeatheringHopper(OXIDIZED_COPPER, "oxidized_copper_hopper", GufyWeathering.WeatherState.OXIDIZED),
			new GufyWeatheringPost(OXIDIZED_COPPER, "oxidized_copper_post", GufyWeathering.WeatherState.OXIDIZED),
		//oxidized_cut_copper
			new GufyWeatheringVerticalSlab(OXIDIZED_COPPER, "oxidized_cut_copper_verticalslab", GufyWeathering.WeatherState.OXIDIZED),
			new GufyWeatheringWall(OXIDIZED_COPPER, "oxidized_cut_copper_wall", GufyWeathering.WeatherState.OXIDIZED),
			new GufyWeatheringHopper(OXIDIZED_COPPER, "oxidized_cut_copper_hopper", GufyWeathering.WeatherState.OXIDIZED),
			new GufyWeatheringPost(OXIDIZED_COPPER, "oxidized_cut_copper_post", GufyWeathering.WeatherState.OXIDIZED),
		//waxed_copper
			new GufyStairs(COPPER, "waxed_copper_stairs"),
			new GufySlab(COPPER, "waxed_copper_slab"),
			new GufyVerticalSlab(COPPER, "waxed_copper_verticalslab"),
			new GufyWall(COPPER, "waxed_copper_wall"),
			new GufyHopper(COPPER, "waxed_copper_hopper"),
			new GufyPost(COPPER, "waxed_copper_post"),
		//waxed_cut_copper
			new GufyVerticalSlab(COPPER, "waxed_cut_copper_verticalslab"),
			new GufyWall(COPPER, "waxed_cut_copper_wall"),
			new GufyHopper(COPPER, "waxed_cut_copper_hopper"),
			new GufyPost(COPPER, "waxed_cut_copper_post"),
		//waxed_exposed_copper
			new GufyStairs(EXPOSED_COPPER, "waxed_exposed_copper_stairs"),
			new GufySlab(EXPOSED_COPPER, "waxed_exposed_copper_slab"),
			new GufyVerticalSlab(EXPOSED_COPPER, "waxed_exposed_copper_verticalslab"),
			new GufyWall(EXPOSED_COPPER, "waxed_exposed_copper_wall"),
			new GufyHopper(EXPOSED_COPPER, "waxed_exposed_copper_hopper"),
			new GufyPost(EXPOSED_COPPER, "waxed_exposed_copper_post"),
		//waxed_exposed_cut_copper
			new GufyVerticalSlab(EXPOSED_COPPER, "waxed_exposed_cut_copper_verticalslab"),
			new GufyWall(EXPOSED_COPPER, "waxed_exposed_cut_copper_wall"),
			new GufyHopper(EXPOSED_COPPER, "waxed_exposed_cut_copper_hopper"),
			new GufyPost(EXPOSED_COPPER, "waxed_exposed_cut_copper_post"),
		//waxed_weathered_copper
			new GufyStairs(WEATHERED_COPPER, "waxed_weathered_copper_stairs"),
			new GufySlab(WEATHERED_COPPER, "waxed_weathered_copper_slab"),
			new GufyVerticalSlab(WEATHERED_COPPER, "waxed_weathered_copper_verticalslab"),
			new GufyWall(WEATHERED_COPPER, "waxed_weathered_copper_wall"),
			new GufyHopper(WEATHERED_COPPER, "waxed_weathered_copper_hopper"),
			new GufyPost(WEATHERED_COPPER, "waxed_weathered_copper_post"),
		//waxed_weathered_cut_copper
			new GufyVerticalSlab(WEATHERED_COPPER, "waxed_weathered_cut_copper_verticalslab"),
			new GufyWall(WEATHERED_COPPER, "waxed_weathered_cut_copper_wall"),
			new GufyHopper(WEATHERED_COPPER, "waxed_weathered_cut_copper_hopper"),
			new GufyPost(WEATHERED_COPPER, "waxed_weathered_cut_copper_post"),
		//waxed_oxidized_copper
			new GufyStairs(OXIDIZED_COPPER, "waxed_oxidized_copper_stairs"),
			new GufySlab(OXIDIZED_COPPER, "waxed_oxidized_copper_slab"),
			new GufyVerticalSlab(OXIDIZED_COPPER, "waxed_oxidized_copper_verticalslab"),
			new GufyWall(OXIDIZED_COPPER, "waxed_oxidized_copper_wall"),
			new GufyHopper(OXIDIZED_COPPER, "waxed_oxidized_copper_hopper"),
			new GufyPost(OXIDIZED_COPPER, "waxed_oxidized_copper_post"),
		//waxed_oxidized_cut_copper
			new GufyVerticalSlab(OXIDIZED_COPPER, "waxed_oxidized_cut_copper_verticalslab"),
			new GufyWall(OXIDIZED_COPPER, "waxed_oxidized_cut_copper_wall"),
			new GufyHopper(OXIDIZED_COPPER, "waxed_oxidized_cut_copper_hopper"),
			new GufyPost(OXIDIZED_COPPER, "waxed_oxidized_cut_copper_post"),


		//amethyst
			new GufyStairs(AMETHYST, "amethyst_stairs"),
			new GufySlab(AMETHYST, "amethyst_slab"),
			new GufyVerticalSlab(AMETHYST, "amethyst_verticalslab"),
			new GufyWall(AMETHYST, "amethyst_wall"),
			new GufyHopper(AMETHYST, "amethyst_hopper"),
			new GufyPost(AMETHYST, "amethyst_post"),
		//end_stone
			new GufyStairs(END_STONE, "end_stone_stairs"),
			new GufySlab(END_STONE, "end_stone_slab"),
			new GufyVerticalSlab(END_STONE, "end_stone_verticalslab"),
			new GufyWall(END_STONE, "end_stone_wall"),
			new GufyHopper(END_STONE, "end_stone_hopper"),
			new GufyPost(END_STONE, "end_stone_post"),
		//end_stone_brick
			new GufyVerticalSlab(END_STONE, "end_stone_brick_verticalslab"),
			new GufyHopper(END_STONE, "end_stone_brick_hopper"),
			new GufyPost(END_STONE, "end_stone_brick_post"),
		//purpur
			new GufyWall(PURPUR, "purpur_wall"),
			new GufyHopper(PURPUR, "purpur_hopper"),
			new GufyVerticalSlab(PURPUR, "purpur_verticalslab"),
			new GufyPost(PURPUR, "purpur_post"),
		//blackstone
			new GufyVerticalSlab(BLACKSTONE, "blackstone_verticalslab"),
			new GufyHopper(BLACKSTONE, "blackstone_hopper"),
			new GufyPost(BLACKSTONE, "blackstone_post"),
		//polished_blackstone
			new GufyVerticalSlab(POLISHED_BLACKSTONE, "polished_blackstone_verticalslab"),
			new GufyHopper(POLISHED_BLACKSTONE, "polished_blackstone_hopper"),
			new GufyPost(POLISHED_BLACKSTONE, "polished_blackstone_post"),
		//polished_blackstone_brick
			new GufyVerticalSlab(BLACKSTONE, "polished_blackstone_brick_verticalslab"),
			new GufyHopper(BLACKSTONE, "polished_blackstone_brick_hopper"),
			new GufyPost(BLACKSTONE, "polished_blackstone_brick_post"),
		//cracked_polished_blackstone_brick
			new GufyStairs(BLACKSTONE, "cracked_polished_blackstone_brick_stairs"),
			new GufySlab(BLACKSTONE, "cracked_polished_blackstone_brick_slab"),
			new GufyVerticalSlab(BLACKSTONE, "cracked_polished_blackstone_brick_verticalslab"),
			new GufyWall(BLACKSTONE, "cracked_polished_blackstone_brick_wall"),
			new GufyHopper(BLACKSTONE, "cracked_polished_blackstone_brick_hopper"),
			new GufyPost(BLACKSTONE, "cracked_polished_blackstone_brick_post"),
		//gilded_blackstone
			new GufyStairs(GILDED_BLACKSTONE, "gilded_blackstone_stairs"),
			new GufySlab(GILDED_BLACKSTONE, "gilded_blackstone_slab"),
			new GufyVerticalSlab(GILDED_BLACKSTONE, "gilded_blackstone_verticalslab"),
			new GufyWall(GILDED_BLACKSTONE, "gilded_blackstone_wall"),
			new GufyHopper(GILDED_BLACKSTONE, "gilded_blackstone_hopper"),
			new GufyPost(GILDED_BLACKSTONE, "gilded_blackstone_post"),
		//fence_gates
			new GufyFenceGate(ACACIA, "acacia_wood_fence_gate"),
			new GufyFenceGate(BIRCH, "birch_wood_fence_gate"),
			new GufyFenceGate(CRIMSON, "crimson_hyphae_fence_gate"),
			new GufyFenceGate(DARK_OAK, "dark_oak_wood_fence_gate"),
			new GufyFenceGate(JUNGLE, "jungle_wood_fence_gate"),
			new GufyFenceGate(OAK, "oak_wood_fence_gate"),
			new GufyFenceGate(SPRUCE, "spruce_wood_fence_gate"),
			new GufyFenceGate(WARPED, "warped_hyphae_fence_gate"),
			new GufyFenceGate(ACACIA, "stripped_acacia_wood_fence_gate"),
			new GufyFenceGate(BIRCH, "stripped_birch_wood_fence_gate"),
			new GufyFenceGate(CRIMSON, "stripped_crimson_hyphae_fence_gate"),
			new GufyFenceGate(DARK_OAK, "stripped_dark_oak_wood_fence_gate"),
			new GufyFenceGate(JUNGLE, "stripped_jungle_wood_fence_gate"),
			new GufyFenceGate(OAK, "stripped_oak_wood_fence_gate"),
			new GufyFenceGate(SPRUCE, "stripped_spruce_wood_fence_gate"),
			new GufyFenceGate(WARPED, "stripped_warped_hyphae_fence_gate"),
			new GufyFenceGate(ACACIA, "mossy_acacia_fence_gate"),
			new GufyFenceGate(BIRCH, "mossy_birch_fence_gate"),
			new GufyFenceGate(CRIMSON, "mossy_crimson_fence_gate"),
			new GufyFenceGate(DARK_OAK, "mossy_dark_oak_fence_gate"),
			new GufyFenceGate(JUNGLE, "mossy_jungle_fence_gate"),
			new GufyFenceGate(OAK, "mossy_oak_fence_gate"),
			new GufyFenceGate(SPRUCE, "mossy_spruce_fence_gate"),
			new GufyFenceGate(WARPED, "mossy_warped_fence_gate"),
			new GufyFenceGate(ACACIA, "cracked_acacia_fence_gate"),
			new GufyFenceGate(BIRCH, "cracked_birch_fence_gate"),
			new GufyFenceGate(CRIMSON, "cracked_crimson_fence_gate"),
			new GufyFenceGate(DARK_OAK, "cracked_dark_oak_fence_gate"),
			new GufyFenceGate(JUNGLE, "cracked_jungle_fence_gate"),
			new GufyFenceGate(OAK, "cracked_oak_fence_gate"),
			new GufyFenceGate(SPRUCE, "cracked_spruce_fence_gate"),
			new GufyFenceGate(WARPED, "cracked_warped_fence_gate"),
			
			
		//white_planks
			//new GufyBlock(WHITE_PLANKS, "white_planks"),
			//new GufyStairs(WHITE_PLANKS, "white_plank_stairs"),
			//new GufySlab(WHITE_PLANKS, "white_plank_slab"),
			//new GufyVerticalSlab(WHITE_PLANKS, "white_plank_verticalslab"),
			//new GufyWall(WHITE_PLANKS, "white_plank_wall"),
			//new GufyHopper(WHITE_PLANKS, "white_plank_hopper"),
			//new GufyFence(WHITE_PLANKS, "white_plank_fence"),
			//new GufyFenceGate(WHITE_PLANKS, "white_plank_fence_gate"),
			//new GufyPanel(WHITE_PLANKS, "white_plank_panel"),
			//new GufyTrapdoor(WHITE_PLANKS, "white_plank_trapdoor"),
			//new GufyPressurePlate(WHITE_PRESSUREPLATE, "white_planks_pressureplate", PressurePlateBlock.Sensitivity.EVERYTHING),
			//new GufyButton(WHITE_PRESSUREPLATE, "white_plank_button"),
		//white_wood
			//new GufyFence(WHITE_WOOD, "white_wood_fence"),
			//new GufyFenceGate(WHITE_WOOD, "white_wood_fence_gate"),
			//new GufyTrapdoor(WHITE_TRAPDOOR, "white_wood_trapdoor"),
			//new GufyPane(FRAMED_GLASS, "white_wood_framed_glass_pane"),
			//new GufySign(WHITE_SIGN, "white_wood_sign", GufyUtil.whiteWood),

			*/
	};
	
	
	//************************DECLARE ITEMS******************************//
	public static final Item[] itemList = 
	{
		//mallet
			/*
			new GufyMallet("wooden_mallet", Tiers.WOOD, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)),
			new GufyMallet("golden_mallet", Tiers.GOLD, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)),
			new GufyMallet("stone_mallet", Tiers.STONE, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)),
			new GufyMallet("iron_mallet", Tiers.IRON, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)),
			new GufyMallet("diamond_mallet", Tiers.DIAMOND, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)),
			new GufyMallet("netherite_mallet", Tiers.NETHERITE, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)),

			 */
	};

	
	//************************REGISTER BLOCKS******************************//
	/*
	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
	{	
		for (final Block block: blockList) {
			Preconditions.checkNotNull(block.getRegistryName(), "Block: %s has a NULL registry name", block);
            event.getRegistry().register(block);
		}
	}
	*/

	//************************REGISTER ITEMS******************************//
	/*
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		for (final Block block: blockList)
		{
			final BlockItem item = new BlockItem(block, new Item.Properties().tab(GufyBlocks.gufygroup));
            final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "BlockItem: %s has a NULL registry name", block);
            event.getRegistry().register(item.setRegistryName(registryName));
        }
		for (final Item item: itemList) 
		{
			Preconditions.checkNotNull(item.getRegistryName(), "Item: %s has a NULL registry name", item);
            event.getRegistry().register(item);
		}
	}
	*/

}
