package com.github.elwood612.gufyblocks.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class GufyDoorHandler
{
    public static void onDoorStateChange(Level level, BlockPos blockPos, BlockState state, boolean isOpening)
    {
        if (level.isClientSide()) { return; }

        BlockPos neighborPos = getConnectedDoorPos(level, blockPos, state);
        if (neighborPos != null) {
            processDoor(level, neighborPos, level.getBlockState(neighborPos), isOpening);
        }
    }

    public static BlockPos getConnectedDoorPos(Level level, BlockPos blockPos, BlockState door) {
        BlockPos neighborPos = null;

        if (door.getValue(DoorBlock.HALF).equals(DoubleBlockHalf.UPPER)) {
            blockPos = blockPos.below().immutable();
            door = level.getBlockState(blockPos);
        }

        BlockPos[] blocksaround = getBlocksAround(blockPos);
        for (int i = 0; i < 4; i++) {
            BlockState currentNeighbor = level.getBlockState(blocksaround[i]);
            if (isConnectedDoor(level, blocksaround[i], door, currentNeighbor)) {
                neighborPos = blocksaround[i];
                break;
            }
        }

        return neighborPos;
    }

    public static boolean isConnectedDoor(Level level, BlockPos pos, BlockState myState, BlockState neighborState){
        if (!(myState.getBlock() instanceof DoorBlock) || !(neighborState.getBlock() instanceof DoorBlock)) { return false; }

        return  ((DoorBlock) neighborState.getBlock()).type() == ((DoorBlock) myState.getBlock()).type() &&
                neighborState.getValue(DoorBlock.FACING) == myState.getValue(DoorBlock.FACING) &&
                neighborState.getValue(DoorBlock.HINGE) != myState.getValue(DoorBlock.HINGE);
    }

    public static void processDoor(Level level, BlockPos blockPos, BlockState door, boolean isOpening) {
        level.setBlock(blockPos, door.setValue(DoorBlock.OPEN, isOpening), 10);
    }

    private static BlockPos[] getBlocksAround(BlockPos pos) {
        // Just as a backup, could also use: (would rather not, though)
        // Iterator<BlockPos> blocksaround = BlockPos.betweenClosedStream(blockPos.getX()-1, blockPos.getY(), blockPos.getZ()-1, blockPos.getX()+1, blockPos.getY(), blockPos.getZ()+1).iterator();
        BlockPos[] around = new BlockPos[4];
        around[0] = pos.north();
        around[1] = pos.east();
        around[2] = pos.south();
        around[3] = pos.west();
        return around;
    }
}
