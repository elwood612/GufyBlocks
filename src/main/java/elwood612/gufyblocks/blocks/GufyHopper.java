package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.GufyMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.ToolType;

public class GufyHopper extends Block implements IWaterLoggable
{
	private ToolType toolType;
    private int toolLevel;
    
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    
    public static final VoxelShape HOPPER_TOP = Block.makeCuboidShape(0.0D, 10.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    public static final VoxelShape HOPPER_MIDDLE = Block.makeCuboidShape(4.0D, 4.0D, 4.0D, 12.0D, 10.0D, 12.0D);
    public static final VoxelShape HOPPER_BOTTOM = Block.makeCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 4.0D, 10.0D);
    public static final VoxelShape HOPPER_FINAL = VoxelShapes.or(HOPPER_TOP, VoxelShapes.or(HOPPER_MIDDLE, HOPPER_BOTTOM));
    
	public GufyHopper(GufyMaterials block, String name) 
	{
		super(Block.Properties.create(block.material, block.color).hardnessAndResistance(block.hardness, block.resistance).sound(block.sound));
	    this.toolType = block.tool;
        this.toolLevel = block.level;
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(false)));
        setRegistryName(name);
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) 
	{
		builder.add(WATERLOGGED);
	}
	
	@Override
    public BlockState getStateForPlacement(BlockItemUseContext context) 
    {
        FluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
        BlockState BlockState = this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
        return BlockState;
    }
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		return HOPPER_FINAL;
	}
	
	//Directional Light Blocking
    public boolean func_220074_n(BlockState p_220074_1_) 
    {
        return true;
    }
    
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) 
    {
        return false;
    }
    
    @Override
    @SuppressWarnings("deprecation")
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) 
    {
        if (stateIn.get(WATERLOGGED)) 
        {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state) 
    {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
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
