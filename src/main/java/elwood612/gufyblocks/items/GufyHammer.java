package elwood612.gufyblocks.items;

import java.util.Collection;
import java.util.Map;

import com.google.common.collect.ImmutableMap.Builder;

import elwood612.gufyblocks.Main;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nullable;

import net.minecraft.Util;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.block.Rotation;

@ObjectHolder(Main.MODID)
public class GufyHammer extends Item
{
	/*
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

	 */

	public GufyHammer(String name, Item.Properties builder)
	{
		super(builder);
		setRegistryName(name);
	}

	public InteractionResult useOn(UseOnContext context) {
		Level world = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		BlockState blockstate = world.getBlockState(blockpos);
		Player playerentity = context.getPlayer();
		if (context.getHorizontalDirection() == Direction.DOWN || context.getHorizontalDirection() == Direction.UP || context.getHorizontalDirection() == null) {
			return InteractionResult.PASS;
		} else {
			if (!world.isClientSide && playerentity != null) {
				world.playSound(playerentity, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
				BlockState block = blockstate.rotate(world, blockpos, Rotation.CLOCKWISE_90);
				world.setBlock(blockpos, block, 11);
				//this.handleClick(playerentity, world.getBlockState(blockpos), world, blockpos, true, context.getItem());
			}
		}
		return InteractionResult.sidedSuccess(world.isClientSide);
	}

	private void handleClick(Player player, BlockState state, LevelAccessor worldIn, BlockPos pos, boolean rightClick, ItemStack stack) {
		if (player.canUseGameMasterBlocks()) {
			Block block = state.getBlock();
			StateDefinition<Block, BlockState> statecontainer = block.getStateDefinition();
			Collection<Property<?>> collection = statecontainer.getProperties();
			String s = Registry.BLOCK.getKey(block).toString();
			if (collection.isEmpty()) {
				//sendMessage(player, new TranslationTextComponent(this.getTranslationKey() + ".empty", s));
			} else {
				CompoundTag compoundnbt = stack.getOrCreateTagElement("DebugProperty");
				String s1 = compoundnbt.getString(s);
				Property<?> property = statecontainer.getProperty(s1);
				if (rightClick) {
					if (property == null) {
						property = collection.iterator().next();
					}

					BlockState blockstate = cycleProperty(state, property, player.isSecondaryUseActive());
					worldIn.setBlock(pos, blockstate, 18);
					//sendMessage(player, new TranslationTextComponent(this.getTranslationKey() + ".update", property.getName(), getNameHelper(blockstate, property)));
				} else {
					property = getAdjacentValue(collection, property, player.isSecondaryUseActive());
					String s2 = property.getName();
					compoundnbt.putString(s, s2);
					//sendMessage(player, new TranslationTextComponent(this.getTranslationKey() + ".select", s2, getNameHelper(state, property)));
				}

			}
		}
	}

	private static void sendMessage(Player player, Component text) {
		((ServerPlayer)player).sendMessage(text, ChatType.GAME_INFO, Util.NIL_UUID);
	}

	private static <T extends Comparable<T>> BlockState cycleProperty(BlockState state, Property<T> propertyIn, boolean backwards) {
		return state.setValue(propertyIn, getAdjacentValue(propertyIn.getPossibleValues(), state.getValue(propertyIn), backwards));
	}

	private static <T> T getAdjacentValue(Iterable<T> allowedValues, @Nullable T currentValue, boolean backwards) {
		return (T)(backwards ? Util.findPreviousInIterable(allowedValues, currentValue) : Util.findNextInIterable(allowedValues, currentValue));
	}

	private static <T extends Comparable<T>> String getNameHelper(BlockState state, Property<T> propertyIn) {
		return propertyIn.getName(state.getValue(propertyIn));
	}

	/*
	* Old code
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

	 */

}
