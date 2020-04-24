package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.GufyMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.BlockState;
import net.minecraftforge.common.ToolType;

public class GufyStairs extends StairsBlock
{
	private ToolType toolType;
    private int toolLevel;
    
	@SuppressWarnings("deprecation")
	public GufyStairs(BlockState state, GufyMaterials block, String name) 
	{
		super(state, Block.Properties.create(block.material, block.color).hardnessAndResistance(block.hardness, block.resistance).sound(block.sound));
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
