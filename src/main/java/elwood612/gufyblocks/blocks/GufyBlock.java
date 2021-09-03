package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.GufyMaterials;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.block.state.BlockBehaviour;

public class GufyBlock extends Block
{
	public GufyBlock(GufyMaterials block, String name)
	{
		//super(BlockBehaviour.Properties.of(block.material, block.color)
		//		.strength(block.hardness, block.resistance).sound(block.sound));
		super(GufyMaterials.builder(block, name));
		setRegistryName(name);
	}

}