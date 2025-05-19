package com.github.elwood612.gufyblocks.blocks.blockSpecialty;

import com.github.elwood612.gufyblocks.util.GufyUtil;
import com.mojang.serialization.MapCodec;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Optional;

public class GufyFlowerBox extends HorizontalDirectionalBlock // implements some kind of entity block + probably wants to extend HorizontalDirectionalBlock
{
    protected static final VoxelShape NORTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 6.0D);
    protected static final VoxelShape SOUTH_SHAPE = Block.box(0.0D, 0.0D, 10.0D, 16.0D, 6.0D, 16.0D);
    protected static final VoxelShape WEST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 6.0D, 6.0D, 16.0D);
    protected static final VoxelShape EAST_SHAPE = Block.box(10.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);

    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    private final Block flower;

    public GufyFlowerBox(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
        this.flower = null;
    }

    public GufyFlowerBox(Block flower, Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
        this.flower = flower;
    }


    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec()
    {
        return null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        BlockState BlockState = this.defaultBlockState();
        Direction direction = context.getClickedFace();

        if (direction.getAxis().isHorizontal()) { BlockState = BlockState.setValue(FACING, direction); }
        else { BlockState = BlockState.setValue(FACING, context.getHorizontalDirection().getOpposite()); }

        return BlockState;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
    {
        switch((Direction)state.getValue(FACING).getOpposite())
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

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult)
    {
        Optional<BlockState> optional = GufyUtil.getPotted(state);
        if (optional.isEmpty()) { return InteractionResult.PASS; }

        return optional.map((newBlockState) ->
                {
                    ItemStack itemStack = player.getItemInHand(hand);
                    if (player instanceof ServerPlayer)
                        CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, pos, itemStack);
//                    if (!player.isCreative())
//                        itemStack.shrink(1);
                    level.setBlock(pos, newBlockState, 3);
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                    stack.consume(1, player);
                    return InteractionResult.SUCCESS;
                }).orElse(InteractionResult.CONSUME);
    }

//    protected InteractionResult useWithoutItem(BlockState p_316363_, Level p_316655_, BlockPos p_316654_, Player p_316338_, BlockHitResult p_316518_)
//    {

//    }

//    @Override
//    protected BlockState updateShape(
//            BlockState stateIn,
//            LevelReader levelIn,
//            ScheduledTickAccess tick,
//            BlockPos currentPos,
//            Direction direction,
//            BlockPos facingPos,
//            BlockState facingState,
//            RandomSource randomSource
//    ) {
//        if (stateIn.getValue(WATERLOGGED)) {
//            tick.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelIn));
//        }
//
//        return super.updateShape(stateIn, levelIn, tick, currentPos, direction, facingPos, facingState, randomSource);
//    }

}
