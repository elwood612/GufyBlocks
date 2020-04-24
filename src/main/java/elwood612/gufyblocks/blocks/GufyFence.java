package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.GufyMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.BlockState;
import net.minecraftforge.common.ToolType;

public class GufyFence extends FenceBlock
{
	private ToolType toolType;
    private int toolLevel;
    
	public GufyFence(GufyMaterials block, String name) {
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
