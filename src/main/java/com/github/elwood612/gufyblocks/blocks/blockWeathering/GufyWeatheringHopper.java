package com.github.elwood612.gufyblocks.blocks.blockWeathering;

import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyWeathering;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import javax.annotation.Nullable;

public class GufyWeatheringHopper extends Block implements GufyWeathering, SimpleWaterloggedBlock
{
    private final GufyWeathering.WeatherState weatherState;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final VoxelShape HOPPER_TOP = Block.box(0.0D, 10.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    public static final VoxelShape HOPPER_MIDDLE = Block.box(4.0D, 4.0D, 4.0D, 12.0D, 10.0D, 12.0D);
    public static final VoxelShape HOPPER_BOTTOM = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 4.0D, 10.0D);
    public static final VoxelShape HOPPER_FINAL = Shapes.or(HOPPER_TOP, Shapes.or(HOPPER_MIDDLE, HOPPER_BOTTOM));

    public GufyWeatheringHopper(BlockBehaviour.Properties properties, GufyWeathering.WeatherState state) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)));
        this.weatherState = state;
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility toolAction, boolean simulate)
    {
        ItemStack itemStack = context.getItemInHand();
        if (!itemStack.canPerformAction(toolAction)) return null;
        if (ItemAbilities.AXE_SCRAPE.equals(toolAction)) return GufyWeathering.getPrevious(state).orElse(null);
        return null;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult)
    {
        Item handheldItem = player.getItemInHand(hand).getItem();
        if (Items.HONEYCOMB.equals(handheldItem)) {
            return GufyUtil.getWaxedOn(state).map((newBlockState) -> {
                ItemStack itemStack = player.getItemInHand(hand);
                if (player instanceof ServerPlayer)
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, pos, itemStack);
                if (!player.isCreative())
                    itemStack.shrink(1);
                level.setBlock(pos, newBlockState, 11);
                level.levelEvent(player, 3003, pos, 0);
                return InteractionResult.SUCCESS;
            }).orElse(InteractionResult.CONSUME);
        } else
            return InteractionResult.PASS;
    }

    public void randomTick(BlockState p_154929_, ServerLevel p_154930_, BlockPos p_154931_, RandomSource p_154932_)
    {
        this.changeOverTime(p_154929_, p_154930_, p_154931_, p_154932_);
    }

    public boolean isRandomlyTicking(BlockState p_154935_)
    {
        return GufyWeathering.getNext(p_154935_.getBlock()).isPresent();
    }

    public WeatheringCopper.WeatherState getAge()
    {
        switch (this.weatherState) {
            case UNAFFECTED:
                return WeatheringCopper.WeatherState.UNAFFECTED;
            case EXPOSED:
                return WeatheringCopper.WeatherState.EXPOSED;
            case WEATHERED:
                return WeatheringCopper.WeatherState.WEATHERED;
            case OXIDIZED:
                return WeatheringCopper.WeatherState.OXIDIZED;
            default:
                return WeatheringCopper.WeatherState.UNAFFECTED;
        }
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
        BlockState BlockState = this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.getType() == Fluids.WATER));
        return BlockState;
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
    {
        return HOPPER_FINAL;
    }

    //Directional Light Blocking
    public boolean useShapeForLightOcclusion(BlockState p_220074_1_)
    {
        return true;
    }

    public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type)
    {
        return false;
    }

    @Override
    protected BlockState updateShape(
            BlockState stateIn,
            LevelReader levelIn,
            ScheduledTickAccess tick,
            BlockPos currentPos,
            Direction direction,
            BlockPos facingPos,
            BlockState facingState,
            RandomSource randomSource
    ) {
        if (stateIn.getValue(WATERLOGGED)) {
            tick.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelIn));
        }

        return super.updateShape(stateIn, levelIn, tick, currentPos, direction, facingPos, facingState, randomSource);
    }

    @Override
    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state)
    {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

}
