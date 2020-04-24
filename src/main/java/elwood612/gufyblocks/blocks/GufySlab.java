package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.GufyMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.BlockState;
import net.minecraftforge.common.ToolType;

public class GufySlab extends SlabBlock
{
	private ToolType toolType;
    private int toolLevel;
    
	public GufySlab(GufyMaterials block, String name) 
	{
	    super(Block.Properties.create(block.material, block.color).hardnessAndResistance(block.hardness, block.resistance).sound(block.sound));
	    this.toolType = block.tool;
        this.toolLevel = block.level;
        setRegistryName(name);
	}
	
	@Override
    public ToolType getHarvestTool(BlockState state) 
	{
        return toolType;
    }

    @Override
    public int getHarvestLevel(BlockState state) 
    {
        return toolLevel;
    }
	
}
