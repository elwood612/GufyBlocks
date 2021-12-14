package elwood612.gufyblocks.blocks.blockSpecialty;

import elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.TrapDoorBlock;

public class GufyTrapdoor extends TrapDoorBlock
{
    public GufyTrapdoor(GufyMaterials block, String name)
    {
        super(GufyUtil.builder(block));
        setRegistryName(name);
	}

}
