package elwood612.gufyblocks.items.itemUtil;

import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class GufyBlocksItemGroup extends CreativeModeTab
{
	public GufyBlocksItemGroup() 
	{
		super("gufygroup");
	}

	@Override
	public ItemStack makeIcon()
	{
		//return new ItemStack(Item.BY_BLOCK.get(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("gufyblocks", "cobblestone_bricks"))));
		return new ItemStack(GufyUtil.getGufyBlock("cobblestone_bricks").get());
	}
}
