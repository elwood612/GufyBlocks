package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class GufyStairs extends StairBlock
{
    
	public GufyStairs(GufyMaterials block, String name)
	{
		super((GufyUtil.getBlock(name))::defaultBlockState, GufyUtil.builder(block));
        setRegistryName(name);
	}

	@Nullable
	@Override
	public BlockState getToolModifiedState(BlockState state, Level world, BlockPos pos, Player player, ItemStack stack, ToolAction toolAction)
	{
		if (!stack.canPerformAction(toolAction) || !GufyUtil.isWaxed(state)) return null;
		if(ToolActions.AXE_WAX_OFF.equals(toolAction))
			return GufyUtil.getWaxedOff(state).orElse(null);
		return null;
	}
	
}
