package elwood612.gufyblocks.blocks.blockSpecialty;

import elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.RotatedPillarBlock;

public class GufyPillar extends RotatedPillarBlock
{
    
    public GufyPillar(GufyMaterials block, String name)
	{
		//super(BlockBehaviour.Properties.of(block.material, block.color).strength(block.hardness, block.resistance).sound(block.sound));
		super(GufyUtil.builder(block));
		setRegistryName(name);
	}
}
