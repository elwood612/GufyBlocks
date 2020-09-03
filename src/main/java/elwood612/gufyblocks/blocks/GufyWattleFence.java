package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.GufyMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.ToolType;

public class GufyWattleFence extends HorizontalBlock implements IWaterLoggable
{
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	protected static final VoxelShape WEST_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_SHAPE = Block.makeCuboidShape(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
    protected static final VoxelShape SOUTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
    
    protected static final VoxelShape COLLISION_WEST_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 24.0D, 16.0D);
    protected static final VoxelShape COLLISION_EAST_SHAPE = Block.makeCuboidShape(15.0D, 0.0D, 0.0D, 16.0D, 24.0D, 16.0D);
    protected static final VoxelShape COLLISION_NORTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 24.0D, 1.0D);
    protected static final VoxelShape COLLISION_SOUTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 15.0D, 16.0D, 24.0D, 16.0D);
    
    private ToolType toolType;
    private int toolLevel;
    
    public GufyWattleFence(GufyMaterials block, String name) 
    {
    	super(Block.Properties.create(block.material, block.color).hardnessAndResistance(block.hardness, block.resistance).sound(block.sound).notSolid());
	    this.toolType = block.tool;
        this.toolLevel = block.level;
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
        setRegistryName(name);
	}
    
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) 
    {
        builder.add(HORIZONTAL_FACING, WATERLOGGED);
    }
	
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) 
    {
    	BlockState BlockState = this.getDefaultState();
        FluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
        Direction direction = context.getFace();
        
        if (direction.getAxis().isHorizontal()) { BlockState = BlockState.with(HORIZONTAL_FACING, direction); } 
        else { BlockState = BlockState.with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
        
        return BlockState.with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
    }
	
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
    {
    	switch((Direction)state.get(HORIZONTAL_FACING).getOpposite())
        {
            case WEST:
                return (VoxelShape) WEST_SHAPE;
            case EAST:
                return (VoxelShape) EAST_SHAPE;
            case SOUTH:
                return (VoxelShape) SOUTH_SHAPE;
            default:
                return (VoxelShape) NORTH_SHAPE;
        }
    }
    
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
    	switch((Direction)state.get(HORIZONTAL_FACING).getOpposite())
        {
            case WEST:
                return (VoxelShape) COLLISION_WEST_SHAPE;
            case EAST:
                return (VoxelShape) COLLISION_EAST_SHAPE;
            case SOUTH:
                return (VoxelShape) COLLISION_SOUTH_SHAPE;
            default:
                return (VoxelShape) COLLISION_NORTH_SHAPE;
        }
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

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) 
    {
        return false;
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
