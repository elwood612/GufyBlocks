package elwood612.gufyblocks.items;

import java.util.Map;

import elwood612.gufyblocks.util.GufyUtil;
import com.google.common.collect.ImmutableMap;
import net.minecraft.Util;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

import net.minecraft.world.InteractionResult;

public class GufyMallet extends TieredItem
{
	protected static final Map<Block, Block> CRACKABLES = (new ImmutableMap.Builder<Block, Block>())
			.put(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS)
			.put(GufyUtil.getGufyBlock("cobblestone_bricks").get(), GufyUtil.getGufyBlock("cracked_cobblestone_bricks").get())
			.build();

	public GufyMallet(Tier tier, Item.Properties properties)
	{
		super(tier, properties);
	}

	public InteractionResult useOn(UseOnContext context) {
		Player player = context.getPlayer();
		Level level = context.getLevel();
		BlockPos pos = context.getClickedPos();
		BlockState state = level.getBlockState(pos);
		//Block block = state.getBlock();
		DirectionProperty facing = BlockStateProperties.FACING;
		BlockState newState = null;
		ItemStack itemStack = context.getItemInHand();

		if(isRotationAllowed(state) && player.isShiftKeyDown()) {
			cycleState(state, facing, player.isSecondaryUseActive());
			if (player != null) {
				itemStack.hurtAndBreak(1, player, (player1) -> {
					player1.broadcastBreakEvent(context.getHand());
				});
			}
			/*
			if(newState == null) {
				newState = rotateSlabType(level, pos, state);
			}

			// try rotate direction
			if(newState == null) {
				newState = rotateDirection(level, pos, state);
			}

			// try rotate axis
			if(newState == null) {
				newState = rotateAxis(level, pos, state);
			}

			// try rotate rotation
			if(newState == null) {
				newState = rotateRotation(level, pos, state);
			}

			if(newState != null) {
				// fixes stairs and other blocks
				newState = updatePostPlacement(level, pos, newState);

				SoundType soundType = state.getSoundType(level, pos, player);

				level.setBlock(pos, newState, 11);
				//0.5f should be random below
				level.playSound(player, pos, soundType.getPlaceSound(), SoundSource.BLOCKS, 1.0f, 0.5f * 0.4f + 0.8f);

				if(player != null) {
					// deal damage to item
					context.getItemInHand().setDamageValue(1, player, (player2) -> {
						player2.sendBreakAnimation(context.getHand());
					});
				}

				return InteractionResult.SUCCESS;
			}

			 */
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.FAIL;

	}

	protected static boolean isRotationAllowed(BlockState state) {
		Block block = state.getBlock();

		if(block instanceof BedBlock || block instanceof PistonHeadBlock) {
			return false;
		}

		// check block is not extended (e.g. pistons)
		if(state.hasProperty(BlockStateProperties.EXTENDED) && state.getValue(BlockStateProperties.EXTENDED)) {
			return false;
		}

		// check block is not a part of a chest
		if(state.hasProperty(BlockStateProperties.CHEST_TYPE) && state.getValue(BlockStateProperties.CHEST_TYPE) != ChestType.SINGLE) {
			return false;
		}

		// check if double slab
		if(state.hasProperty(BlockStateProperties.SLAB_TYPE) && state.getValue(BlockStateProperties.SLAB_TYPE) == SlabType.DOUBLE) {
			return false;
		}

		return true;
	}

	/*
	protected static BlockState updatePostPlacement(Level level, BlockPos pos, BlockState state) {
		DirectionProperty directionProperty = getDirectionProperty(state);

		// check facing property
		if(directionProperty != null) {
			Direction facing = state.getValue(directionProperty);

			if(facing != null) {
				BlockPos facingPos = pos.offset(facing);
				BlockState facingState = level.getBlockState(facingPos);

				state = state.updateShape(facing, facingState, level, pos, facingPos);
			}
		}

		return state;
	}

	protected static <T extends Comparable<T>> BlockState rotateProperty(BlockState state, Property<T> property, Predicate<T> filter) {
		if(!state.hasProperty(property)) {
			return null;
		}

		T currentValue = state.getValue(property);
		List<T> array = new ArrayList<>(property.getPossibleValues());

		for(int i = array.size() - 1; i >= 0; i--) {
			T value = array.get(i);

			// skip checking existing value
			if(value == currentValue) {
				continue;
			}

			// check if value is applicable
			if(filter != null && filter.test(value)) {
				array.remove(value);
			}
		}

		// cannot rotate array of 1
		if(array.size() <= 1) {
			return null;
		}

		int index = array.indexOf(currentValue);
		index = (index + 1) % array.size();

		T newValue = array.get(index);
		BlockState newState = state.setValue(property, newValue);

		return newState;
	}

	protected static BlockState rotateDirection(Level level, BlockPos pos, BlockState state) {
		DirectionProperty directionProperty = getDirectionProperty(state);

		// check facing property
		if(directionProperty == null) {
			return null;
		}

		Block block = state.getBlock();
		Direction direction = state.getValue(directionProperty);

		return rotateProperty(state, directionProperty, (dir) -> {
			if(dir == direction) {
				return false;
			}

			BlockState tmpState = state.setValue(directionProperty, dir);
			boolean isValidPos = tmpState.isValidPosition(level, pos);

			BlockState facingState = level.getBlockState(pos.offset(dir, -1));
			Block facingBlock = facingState.getBlock();

			// check that signs are not now attached to eachother
			if(isValidPos && facingBlock instanceof WallSignBlock && block instanceof WallSignBlock) {
				if(facingState.getValue(directionProperty).getOpposite().equals(dir)) {
					isValidPos = false;
				}
			}

			return !isValidPos;
		});
	}

	protected static BlockState rotateAxis(Level level, BlockPos pos, BlockState state) {
		EnumProperty<Direction.Axis> axisProperty = getAxisProperty(state);

		// check facing property
		if(axisProperty == null) {
			return null;
		}

		return rotateProperty(state, axisProperty, null);
	}

	protected static BlockState rotateSlabType(Level level, BlockPos pos, BlockState state) {
		EnumProperty<SlabType> slabTypeProperty = getSlabTypeProperty(state);

		// check facing property
		if(slabTypeProperty == null) {
			return null;
		}

		// remove double slab from rotation
		return rotateProperty(state, slabTypeProperty, (slabType) -> slabType == SlabType.DOUBLE);
	}

	protected static BlockState rotateRotation(Level level, BlockPos pos, BlockState state) {
		return rotateProperty(state, BlockStateProperties.ROTATION_16, null);
	}

	protected static DirectionProperty getDirectionProperty(BlockState state) {
		if(state.hasProperty(BlockStateProperties.FACING)) {
			return BlockStateProperties.FACING;
		} else if(state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
			return BlockStateProperties.HORIZONTAL_FACING;
		} else {
			return null;
		}
	}

	protected static EnumProperty<Direction.Axis> getAxisProperty(BlockState state) {
		if(state.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
			return BlockStateProperties.HORIZONTAL_AXIS;
		} else if(state.hasProperty(BlockStateProperties.AXIS)) {
			return BlockStateProperties.AXIS;
		} else {
			return null;
		}
	}

	protected static EnumProperty<SlabType> getSlabTypeProperty(BlockState state) {
		if(state.hasProperty(BlockStateProperties.SLAB_TYPE)) {
			return BlockStateProperties.SLAB_TYPE;
		} else {
			return null;
		}
	}

	 */


	private static <T extends Comparable<T>> BlockState cycleState(BlockState p_40970_, Property<T> p_40971_, boolean p_40972_) {
		return p_40970_.setValue(p_40971_, getRelative(p_40971_.getPossibleValues(), p_40970_.getValue(p_40971_), p_40972_));
	}

	private static <T> T getRelative(Iterable<T> p_40974_, @Nullable T p_40975_, boolean p_40976_) {
		return (T)(p_40976_ ? Util.findPreviousInIterable(p_40974_, p_40975_) : Util.findNextInIterable(p_40974_, p_40975_));
	}



	/*
	private static void message(Player p_40957_, Component p_40958_) {
		((ServerPlayer)p_40957_).sendMessage(p_40958_, ChatType.GAME_INFO, Util.NIL_UUID);
	}

	private static <T extends Comparable<T>> String getNameHelper(BlockState p_40967_, Property<T> p_40968_) {
		return p_40968_.getName(p_40967_.getValue(p_40968_));
	}

	 */




	//****************************************************************************************************************//
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
}
