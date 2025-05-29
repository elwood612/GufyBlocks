package com.github.elwood612.gufyblocks.events;

import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ScaffoldingBlockItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class GufyScaffoldingEvent
{
    private static final CopyOnWriteArrayList<BlockPos> lastScaffoldings = new CopyOnWriteArrayList<BlockPos>();
    private static final HashMap<BlockPos, Date> lastaction = new HashMap<BlockPos, Date>();

    @SubscribeEvent
    public static void onScaffoldingItem(EntityJoinLevelEvent e) {
        Level level = e.getLevel();
        Entity entity = e.getEntity();
        if (level.isClientSide) { return; }
        if (!(entity instanceof ItemEntity)) { return; }

        ItemEntity ie = (ItemEntity)entity;
        ItemStack itemstack = ie.getItem();
        if (!(itemstack.getItem() instanceof ScaffoldingBlockItem)) { return; }

        Date now = new Date();
        BlockPos scafpos = entity.blockPosition();
        BlockPos lowscafpos = new BlockPos(scafpos.getX(), 1, scafpos.getZ());

        for (BlockPos lspos : lastScaffoldings) {
            if (lastaction.containsKey(lspos)) {
                Date lastdate = lastaction.get(lspos);
                long ms = (now.getTime()-lastdate.getTime());
                if (ms > 2000) {
                    lastScaffoldings.remove(lspos);
                    lastaction.remove(lspos);
                    continue;
                }
            }

            if (lowscafpos.closerThan(new BlockPos(lspos.getX(), 1, lspos.getZ()), 20)) {
                entity.teleportTo(lspos.getX(), lspos.getY()+1, lspos.getZ());
                lastaction.put(lspos.immutable(), now);
            }
        }
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent e) {
        Level level = GufyUtil.getWorldIfInstanceOfAndNotRemote(e.getLevel());
        if (level == null || level.isClientSide) { return; }

        BlockPos blockPos = e.getPos();
        BlockState blockState = e.getState();
        Block block = blockState.getBlock();

        if (block.equals(Blocks.SCAFFOLDING)) {
            lastScaffoldings.add(blockPos);
            lastaction.put(blockPos, new Date());
        }
    }
}
