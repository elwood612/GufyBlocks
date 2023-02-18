package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import javax.annotation.Nullable;

public class GufySlab extends SlabBlock
{
    
	public GufySlab(BlockBehaviour.Properties properties)
	{
		super(properties);
	}

	@Nullable
	@Override
	public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate)
	{
		ItemStack itemStack = context.getItemInHand();
		if (!itemStack.canPerformAction(toolAction) || !GufyUtil.isWaxed(state)) return null;
		if(ToolActions.AXE_WAX_OFF.equals(toolAction))
			return GufyUtil.getWaxedOff(state).orElse(null);
		return null;
	}
	
}
