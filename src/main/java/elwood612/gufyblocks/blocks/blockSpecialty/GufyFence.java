package elwood612.gufyblocks.blocks.blockSpecialty;

import elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.FenceBlock;

public class GufyFence extends FenceBlock
{
	public GufyFence(GufyMaterials block, String name) {
		super(GufyUtil.builder(block));
        setRegistryName(name);
	}
}
