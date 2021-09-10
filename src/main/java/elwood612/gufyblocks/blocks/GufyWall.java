package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.WallBlock;

public class GufyWall extends WallBlock
{
    
    public GufyWall (GufyMaterials block, String name)
    {
    	//super(BlockBehaviour.Properties.of(block.material, block.color).strength(block.hardness, block.resistance).sound(block.sound));
        super(GufyUtil.builder(block, name));
        setRegistryName(name);
    }

}
