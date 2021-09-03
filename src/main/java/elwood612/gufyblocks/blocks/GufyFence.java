package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.GufyMaterials;
import net.minecraft.world.level.block.FenceBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;

public class GufyFence extends FenceBlock
{
	public GufyFence(GufyMaterials block, String name) {
		//super(BlockBehaviour.Properties.of(block.material, block.color).strength(block.hardness, block.resistance).sound(block.sound));
		super(GufyMaterials.builder(block, name));
        setRegistryName(name);
	}
}
