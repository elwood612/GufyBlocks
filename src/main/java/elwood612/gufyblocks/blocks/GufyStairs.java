package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class GufyStairs extends StairBlock
{
    
	public GufyStairs(GufyMaterials block, String name)
	{
		super(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("gufyblocks", name))::defaultBlockState,
				GufyUtil.builder(block, name));
        //        BlockBehaviour.Properties.of(block.material, block.color).strength(block.hardness, block.resistance).sound(block.sound));
		setRegistryName(name);
	}
	
}
