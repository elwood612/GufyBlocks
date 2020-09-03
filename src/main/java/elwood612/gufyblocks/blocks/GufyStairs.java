package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.GufyMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.BlockState;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.ForgeRegistries;

public class GufyStairs extends StairsBlock
{
	private ToolType toolType;
    private int toolLevel;
    
	public GufyStairs(GufyMaterials block, String name) 
	{
		super(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("gufyblocks", name))::getDefaultState, Block.Properties.create(block.material, block.color).hardnessAndResistance(block.hardness, block.resistance).sound(block.sound));
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
