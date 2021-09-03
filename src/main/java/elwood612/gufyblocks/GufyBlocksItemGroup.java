package elwood612.gufyblocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class GufyBlocksItemGroup extends CreativeModeTab
{
	public GufyBlocksItemGroup() 
	{
		super("gufygroup");
	}

	@Override
	public ItemStack makeIcon() 
	{
		return new ItemStack(Item.BY_BLOCK.get(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("gufyblocks", "cobblestone_bricks"))));
	}
}
