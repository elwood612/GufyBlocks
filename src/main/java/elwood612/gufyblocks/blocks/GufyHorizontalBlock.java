package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.GufyMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;

import net.minecraft.world.level.block.state.BlockBehaviour;

public class GufyHorizontalBlock extends HorizontalDirectionalBlock
{
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public GufyHorizontalBlock(GufyMaterials block, String name) 
    {
    	//super(BlockBehaviour.Properties.of(block.material, block.color).strength(block.hardness, block.resistance).sound(block.sound));
        super(GufyMaterials.builder(block, name));
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
        setRegistryName(name);
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) 
    {
        builder.add(FACING);
    }
    
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) 
    {
        BlockState BlockState = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
        return BlockState;
    }
    
    public BlockState rotate(BlockState state, Rotation rot) 
    {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) 
    {
       return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

}
