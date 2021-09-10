package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.Block;

public class GufyBlock extends Block
{
	public GufyBlock(GufyMaterials block, String name)
	{
		super(GufyUtil.builder(block, name));
		setRegistryName(name);
	}

}