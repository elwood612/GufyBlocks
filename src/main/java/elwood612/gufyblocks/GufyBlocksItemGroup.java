package elwood612.gufyblocks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class GufyBlocksItemGroup extends ItemGroup
{
	public GufyBlocksItemGroup() 
	{
		super("gufygroup");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(Item.BLOCK_TO_ITEM.get(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("gufyblocks", "cobblestone_bricks"))));
	}
}
