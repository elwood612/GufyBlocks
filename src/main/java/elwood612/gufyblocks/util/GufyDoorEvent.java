package elwood612.gufyblocks.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.ButtonBlock;
//import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class GufyDoorEvent {
    private static List<BlockPos> prevpoweredpos = new ArrayList<BlockPos>();
    private static HashMap<BlockPos, Integer> prevbuttonpos = new HashMap<BlockPos, Integer>();

    @SubscribeEvent
    public void onNeighbourNotice(BlockEvent.NeighborNotifyEvent e) {
        Level world = GufyUtil.getWorldIfInstanceOfAndNotRemote(e.getLevel());
        if (world == null) {
            return;
        }

        BooleanProperty proppowered = BlockStateProperties.POWERED;
        BlockPos pos = e.getPos().immutable();
        BlockState state = e.getState();
        Block block = state.getBlock();

        if (!(block instanceof PressurePlateBlock)) {
            if (!(block instanceof ButtonBlock)) {
                return;
            }
            else {
                if (prevbuttonpos.containsKey(pos)) {
                    prevbuttonpos.remove(pos);
                }
                else {
                    prevbuttonpos.put(pos, 1);
                    return;
                }

                if (!state.getValue(proppowered)) {
                    if (!prevpoweredpos.contains(pos)) {
                        return;
                    }
                    prevpoweredpos.remove(pos);
                }
            }
        }
        else {
            if (!state.getValue(proppowered)) {
                if (!prevpoweredpos.contains(pos)) {
                    return;
                }
            }
        }

        boolean playsound = true;
        boolean stateprop = state.getValue(proppowered);

        Iterator<BlockPos> blocksaround = BlockPos.betweenClosedStream(pos.getX()-1, pos.getY(), pos.getZ()-1, pos.getX()+1, pos.getY()+1, pos.getZ()+1).iterator();

        BlockPos doorpos = null;
        while (blocksaround.hasNext()) {
            BlockPos npos = blocksaround.next().immutable();
            BlockState ostate = world.getBlockState(npos);
            if (GufyUtil.isDoorBlock(ostate)) {
                doorpos = npos;
                break;
            }
        }

        if (doorpos != null) {
            if (processDoor(null, world, doorpos, world.getBlockState(doorpos), stateprop, playsound)) {
                if (stateprop) {
                    prevpoweredpos.add(pos);
                }
            }
        }
    }

    @SubscribeEvent
    public void onDoorClick(PlayerInteractEvent.RightClickBlock e) {
        Level world = e.getLevel();
        if (world.isClientSide && e.getHand().equals(InteractionHand.MAIN_HAND)) {
            return;
        }

        Player player = e.getEntity();
        if (player.isShiftKeyDown()) {
            return;
        }

        BlockPos cpos = e.getPos();
        BlockState clickstate = world.getBlockState(cpos);

        if (!GufyUtil.isDoorBlock(clickstate)) {
            return;
        }
        if (clickstate.getMaterial().equals(Material.METAL)) {
            return;
        }

        if (processDoor(player, world, cpos, clickstate, null, false)) {
            e.setUseBlock(Result.DENY);
            e.setCanceled(true);
        }

    }

    private boolean processDoor(Player player, Level world, BlockPos pos, BlockState state, Boolean isopen, Boolean playsound) {
        Block block = state.getBlock();
        if (block instanceof DoorBlock) {
            if (state.getValue(DoorBlock.HALF).equals(DoubleBlockHalf.UPPER)) {
                pos = pos.below().immutable();
                state = world.getBlockState(pos);
            }
        }

        if (isopen == null) {
            isopen = !state.getValue(BlockStateProperties.OPEN);
        }

        int yoffset = 0;
        if (!(block instanceof DoorBlock)) {
            yoffset = 1;
        }

        Iterator<BlockPos> blocksaround = BlockPos.betweenClosedStream(pos.getX()-1, pos.getY()-1, pos.getZ()-1, pos.getX()+1, pos.getY()+yoffset, pos.getZ()+1).iterator();
        while (blocksaround.hasNext()) {
            BlockPos bpa = blocksaround.next();
            if (bpa.equals(pos)) {
                continue;
            }
            BlockState ostate = world.getBlockState(bpa);
            Block oblock = ostate.getBlock();
            if (GufyUtil.isDoorBlock(ostate)) {
                if (oblock.getName().equals(block.getName())) {
                    if (oblock instanceof DoorBlock) {

                        DoorBlock door = (DoorBlock)oblock;
                        if (state.getValue(DoorBlock.HINGE).equals(ostate.getValue(DoorBlock.HINGE))) {
                            continue;
                        }

                        if (playsound) {
                            door.setOpen(player, world, state, pos, isopen); // toggleDoor
                        }
                        else {
                            world.setBlock(pos, state.setValue(DoorBlock.OPEN, isopen), 10);
                        }
                        world.setBlock(bpa, ostate.setValue(DoorBlock.OPEN, isopen), 10);
                        return true;
                    }
                }
            }
        }

        return false;
    }

}