package elwood612.gufyblocks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GufyBlocksItemGroup extends ItemGroup
{
	public GufyBlocksItemGroup() 
	{
		super("gufygroup");
	}

	@Override
	public ItemStack createIcon() 
	{
		// TODO Auto-generated method stub
		return new ItemStack(Item.BLOCK_TO_ITEM.get(ModBlocks.cobblestone_bricks));
	}
}
