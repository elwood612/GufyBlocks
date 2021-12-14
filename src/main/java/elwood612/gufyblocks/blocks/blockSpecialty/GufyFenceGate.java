package elwood612.gufyblocks.blocks.blockSpecialty;

import elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.FenceGateBlock;

public class GufyFenceGate extends FenceGateBlock
{
    public GufyFenceGate(GufyMaterials block, String name)
    {
        super(GufyUtil.builder(block));
        setRegistryName(name);
    }

}
