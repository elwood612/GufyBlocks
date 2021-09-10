package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.TrapDoorBlock;

public class GufyTrapdoor extends TrapDoorBlock
{
    
    public GufyTrapdoor(GufyMaterials block, String name)
    {
    	//super(BlockBehaviour.Properties.of(block.material, block.color).strength(block.hardness, block.resistance).sound(block.sound).noOcclusion());
        super(GufyUtil.builder(block, name));
        setRegistryName(name);
	}

}
