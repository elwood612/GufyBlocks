package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.GufyMaterials;
import net.minecraft.world.level.block.RotatedPillarBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;

public class GufyPillar extends RotatedPillarBlock
{
    
    public GufyPillar(GufyMaterials block, String name)
	{
		//super(BlockBehaviour.Properties.of(block.material, block.color).strength(block.hardness, block.resistance).sound(block.sound));
		super(GufyMaterials.builder(block, name));
		setRegistryName(name);
	}
}
