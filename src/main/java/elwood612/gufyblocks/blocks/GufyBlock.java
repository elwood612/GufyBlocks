package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import javax.annotation.Nullable;

public class GufyBlock extends Block
{
	public GufyBlock(BlockBehaviour.Properties properties)
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