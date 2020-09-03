package elwood612.gufyblocks.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap.Builder;

import elwood612.gufyblocks.Main;
import elwood612.gufyblocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.MODID)
public class GufyHammer extends Item
{
	private Block stone_bricks = Blocks.STONE_BRICKS;
	private Block cracked_stone_bricks = Blocks.CRACKED_STONE_BRICKS;
	//private Block cobblestone_bricks = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("gufyblocks", "cobblestone_bricks"));
	//private Block cracked_cobblestone_bricks = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("gufyblocks", "cracked_cobblestone_bricks"));
	//private Block cobblestone_bricks = ModBlocks.getBlock("cobblestone_bricks");
	//private Block cracked_cobblestone_bricks = ModBlocks.getBlock("cracked_cobblestone_bricks");
	private Block cobblestone_bricks;
	private Block cracked_cobblestone_bricks;
	protected final Map<Block, Block> HAMMER_LOOKUP = (new Builder<Block, Block>())
			.put(stone_bricks, cracked_stone_bricks)
			.put(cobblestone_bricks, cracked_cobblestone_bricks)
			.build();

	public GufyHammer(String name, Item.Properties builder)
	{
		super(builder);
		setRegistryName(name);
	}

	public ActionResultType onItemUse(ItemUseContext context) {
	      World world = context.getWorld();
	      BlockPos blockpos = context.getPos();
	      BlockState blockstate = world.getBlockState(blockpos);
	      Block block = HAMMER_LOOKUP.get(blockstate.getBlock());
	      if (block != null) {
	         PlayerEntity playerentity = context.getPlayer();
	         world.playSound(playerentity, blockpos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
	         if (!world.isRemote) {
	            world.setBlockState(blockpos, block.getDefaultState(), 11);
	            if (playerentity != null) {
	               context.getItem().damageItem(1, playerentity, (p_220040_1_) -> {
	                  p_220040_1_.sendBreakAnimation(context.getHand());
	               });
	            }
	         }

	         return ActionResultType.SUCCESS;
	      } else {
	         return ActionResultType.PASS;
	      }
	   }

}
