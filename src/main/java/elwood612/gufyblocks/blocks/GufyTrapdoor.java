package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.GufyMaterials;
import net.minecraft.world.level.block.TrapDoorBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;

public class GufyTrapdoor extends TrapDoorBlock
{
    
    public GufyTrapdoor(GufyMaterials block, String name) 
    {
    	//super(BlockBehaviour.Properties.of(block.material, block.color).strength(block.hardness, block.resistance).sound(block.sound).noOcclusion());
        super(GufyMaterials.builder(block, name));
        setRegistryName(name);
	}

}
