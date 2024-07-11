package com.github.elwood612.gufyblocks.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.*;

@EventBusSubscriber
public class GufyDoorEvent {
    private static final List<BlockPos> prevpoweredpos = new ArrayList<BlockPos>();
    private static final HashMap<BlockPos, Integer> prevbuttonpos = new HashMap<BlockPos, Integer>();

    @SubscribeEvent
    public static void onNeighbourNotice(BlockEvent.NeighborNotifyEvent e) {
        Level level = getWorldIfInstanceOfAndNotRemote(e.getLevel());
        if (level == null) {
            return;
        }

        onNeighbourNoticeCustom(level, e.getPos(), e.getState(), e.getNotifiedSides(), e.getForceRedstoneUpdate());
    }

    public static void onNeighbourNoticeCustom(Level level, BlockPos blockPos, BlockState blockState, EnumSet<Direction> notifiedSides, boolean forceRedstoneUpdate) {
        if (level.isClientSide) {
            return;
        }

        BooleanProperty isPoweredProperty = BlockStateProperties.POWERED;
        IntegerProperty weightPowerProperty = BlockStateProperties.POWER;

        Block block = blockState.getBlock();

        if (!(block instanceof PressurePlateBlock) && !(block instanceof WeightedPressurePlateBlock)) {
            if (!(block instanceof ButtonBlock) && !(block instanceof LeverBlock)) {
                return;
            }
            else {
                if (prevbuttonpos.containsKey(blockPos)) {
                    prevbuttonpos.remove(blockPos);
                }
                else {
                    prevbuttonpos.put(blockPos.immutable(), 1);
                    return;
                }

                if (!blockState.getValue(isPoweredProperty)) {
                    if (!prevpoweredpos.contains(blockPos)) {
                        return;
                    }
                    prevpoweredpos.remove(blockPos);
                }
            }
        }
        else if (block instanceof WeightedPressurePlateBlock) {
            if (blockState.getValue(weightPowerProperty) == 0) {
                if (!prevpoweredpos.contains(blockPos)) {
                    return;
                }
            }
        }
        else {
            if (!blockState.getValue(isPoweredProperty)) {
                if (!prevpoweredpos.contains(blockPos)) {
                    return;
                }
            }
        }

        boolean blockStateprop;
        if (block instanceof WeightedPressurePlateBlock) {
            blockStateprop = blockState.getValue(weightPowerProperty) > 0;
        }
        else {
            blockStateprop = blockState.getValue(isPoweredProperty);
        }

        int radius = 1;

        BlockPos doorBlockPos = null;

        for (BlockPos aroundPos : getBlocksAround(blockPos, false)) {
            BlockState oBlockState = level.getBlockState(aroundPos);
            if (isDoorBlock(oBlockState)) {
                doorBlockPos = aroundPos.immutable();
                break;
            }
        }

        if (doorBlockPos == null) {
            for (BlockPos aroundPos : BlockPos.betweenClosed(blockPos.getX() - radius, blockPos.getY() - 1, blockPos.getZ() - radius, blockPos.getX() + radius, blockPos.getY() + 1, blockPos.getZ() + radius)) {
                BlockState oBlockState = level.getBlockState(aroundPos);
                if (isDoorBlock(oBlockState)) {
                    doorBlockPos = aroundPos;
                    break;
                }
            }
        }


        if (doorBlockPos != null) {
            if (processDoor(null, level, doorBlockPos, level.getBlockState(doorBlockPos), blockStateprop)) {
                if (blockStateprop) {
                    prevpoweredpos.add(blockPos.immutable());
                }
            }
        }
    }

    public static void onDoorClick(Level level, Player player, InteractionHand interactionHand, BlockPos blockPos, BlockHitResult blockHitResult) {
        if (level.isClientSide) {
            return;
        }

        if (!interactionHand.equals(InteractionHand.MAIN_HAND)) {
            return;
        }

        if (player.isCrouching()) {
            return;
        }

        BlockState clickState = level.getBlockState(blockPos);

        if (!isDoorBlock(clickState)) {
            return;
        }

//        if (!canOpenByHand(clickState, true)) {
//            return;
//        }

        processDoor(player, level, blockPos, clickState, null);
    }

    private static boolean isDoorBlock(BlockState blockstate)
    {
        Block block = blockstate.getBlock();
        return (block instanceof DoorBlock);
    }

    private static boolean processDoor(Player player, Level level, BlockPos blockPos, BlockState blockState, Boolean isOpen) {
        Block block = blockState.getBlock();
        if (block instanceof DoorBlock) {
            if (blockState.getValue(DoorBlock.HALF).equals(DoubleBlockHalf.UPPER)) {
                blockPos = blockPos.below().immutable();
                blockState = level.getBlockState(blockPos);
            }
        }

        if (isOpen == null) {
            isOpen = blockState.getValue(BlockStateProperties.OPEN);
        }

        int yOffset = 0;
        if (!(block instanceof DoorBlock)) {
            yOffset = 1;
        }

        List<BlockPos> posToOpenList = recursivelyOpenDoors(new ArrayList<BlockPos>(Arrays.asList(blockPos.immutable())), new ArrayList<BlockPos>(), level, blockPos, blockPos, block, yOffset);
        if (posToOpenList.size() <= 1) {
            return false;
        }

        for (BlockPos toOpenBlockPos : posToOpenList) {
            if (toOpenBlockPos.equals(blockPos)) {
                continue;
            }

            BlockState oBlockState = level.getBlockState(toOpenBlockPos);
            Block oBlock = oBlockState.getBlock();

            if (block instanceof DoorBlock) {
                level.setBlock(toOpenBlockPos, oBlockState.setValue(DoorBlock.OPEN, isOpen), 10);
            }
        }

        if (player != null) {
            player.swing(InteractionHand.MAIN_HAND);
        }

        return posToOpenList.size() > 1;
    }

    private static List<BlockPos> recursivelyOpenDoors(List<BlockPos> posToOpenList, List<BlockPos> ignoreOpenList, Level level, BlockPos originalBlockPos, BlockPos blockPos, Block block, int yOffset) {
        Iterator<BlockPos> blocksaround = BlockPos.betweenClosedStream(blockPos.getX()-1, blockPos.getY()-yOffset, blockPos.getZ()-1, blockPos.getX()+1, blockPos.getY()+yOffset, blockPos.getZ()+1).iterator();
        while (blocksaround.hasNext()) {
            BlockPos bpa = blocksaround.next();
            if (posToOpenList.contains(bpa)) {
                continue;
            }

            if (!withinDistance(originalBlockPos, bpa, 2)) {
                continue;
            }

            BlockState oBlockState = level.getBlockState(bpa);
            Block oBlock = oBlockState.getBlock();
            if (isDoorBlock(oBlockState)) {
                if (oBlock.getName().equals(block.getName())) {
                    posToOpenList.add(bpa.immutable());

//                    if (ConfigHandler.enableRecursiveOpening) {
//                        recursivelyOpenDoors(posToOpenList, ignoreOpenList, level, originalBlockPos, bpa, block, yOffset);
//                    }
                    continue;
                }
            }

            ignoreOpenList.add(bpa.immutable());
        }

        return posToOpenList;
    }

    private static List<BlockPos> getBlocksAround(BlockPos pos, boolean down) {
        List<BlockPos> around = new ArrayList<BlockPos>();
        around.add(pos.north());
        around.add(pos.east());
        around.add(pos.south());
        around.add(pos.west());
        around.add(pos.above());
        if (down) {
            around.add(pos.below());
        }
        return around;
    }

    private static boolean canOpenByHand(BlockState blockState, boolean defaultReturn) {
        Block block = blockState.getBlock();
        if (block instanceof DoorBlock) {
            DoorBlock doorBlock = (DoorBlock)block;
            return doorBlock.type().canOpenByHand();
        }
        return defaultReturn;
    }

    private static Boolean withinDistance(BlockPos start, BlockPos end, double distance) {
        return start.closerThan(end, distance);
    }

    private static Level getWorldIfInstanceOfAndNotRemote(LevelAccessor levelAccessor) {
        if (levelAccessor.isClientSide()) {
            return null;
        }
        if (levelAccessor instanceof Level) {
            return ((Level)levelAccessor);
        }
        return null;
    }

}