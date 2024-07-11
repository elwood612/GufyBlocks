package com.github.elwood612.gufyblocks.blocks;

import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.ToolActions;

import javax.annotation.Nullable;

public class GufyWall extends WallBlock
{
    public GufyWall (BlockBehaviour.Properties properties)
    {
        super(properties);
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate)
    {
        ItemStack itemStack = context.getItemInHand();
        if (!itemStack.canPerformAction(toolAction)) return null;
        if(ToolActions.AXE_STRIP.equals(toolAction) && GufyUtil.isStrippable(state))
            return GufyUtil.getStripped(state).orElse(null);
        if(ToolActions.AXE_WAX_OFF.equals(toolAction) && GufyUtil.isScrapeable(state))
            return GufyUtil.getWaxedOff(state).orElse(null);
        return null;
    }

}
