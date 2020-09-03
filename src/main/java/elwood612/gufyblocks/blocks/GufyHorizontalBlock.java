package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.GufyMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraftforge.common.ToolType;

public class GufyHorizontalBlock extends HorizontalBlock
{
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	private ToolType toolType;
    private int toolLevel;

    public GufyHorizontalBlock(GufyMaterials block, String name) 
    {
    	super(Block.Properties.create(block.material, block.color).hardnessAndResistance(block.hardness, block.resistance).sound(block.sound));
	    this.toolType = block.tool;
        this.toolLevel = block.level;
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
        setRegistryName(name);
    }
    
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) 
    {
        builder.add(FACING);
    }
    
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) 
    {
        BlockState BlockState = this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing());
        return BlockState;
    }
    
    public BlockState rotate(BlockState state, Rotation rot) 
    {
        return state.with(HORIZONTAL_FACING, rot.rotate(state.get(HORIZONTAL_FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) 
    {
       return state.rotate(mirrorIn.toRotation(state.get(HORIZONTAL_FACING)));
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
