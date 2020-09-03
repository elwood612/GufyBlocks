package elwood612.gufyblocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.material.Material;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OpenDoor 
{
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onPlayerInteract(PlayerInteractEvent.RightClickBlock event) {
		if(!event.getWorld().isRemote || event.getPlayer().isDiscrete() || event.isCanceled() || event.getResult() == Result.DENY || event.getUseBlock() == Result.DENY)
			return;

		World world = event.getWorld();
		BlockPos pos = event.getPos();
		
		if(world.getBlockState(pos).getBlock() instanceof DoorBlock) {
			openDoor(world, pos);
		}
	}
	
	//Double door opening
	public static void openDoor(World world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		Direction direction = state.get(DoorBlock.FACING);
		boolean isOpen = state.get(DoorBlock.OPEN);
		DoorHingeSide isMirrored = state.get(DoorBlock.HINGE);
		BlockPos mirrorPos = pos.offset(isMirrored == DoorHingeSide.RIGHT ? direction.rotateYCCW() : direction.rotateY());
		BlockPos doorPos = state.get(DoorBlock.HALF) == DoubleBlockHalf.LOWER ? mirrorPos : mirrorPos.down();
		BlockState other = world.getBlockState(doorPos);
		if(state.getMaterial() != Material.IRON && other.getBlock() == state.getBlock() && other.get(DoorBlock.FACING) == direction && other.get(DoorBlock.OPEN) == isOpen && other.get(DoorBlock.HINGE) != isMirrored) {
			BlockState newState = other.func_235896_a_(DoorBlock.OPEN); // cycle
			world.setBlockState(doorPos, newState);
		}
	}
}
