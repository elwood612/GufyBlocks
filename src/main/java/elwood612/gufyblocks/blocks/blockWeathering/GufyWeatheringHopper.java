package elwood612.gufyblocks.blocks.blockWeathering;

import elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import elwood612.gufyblocks.blocks.blockUtil.GufyWeathering;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.WeatheringCopper;
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
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.common.extensions.IForgeBlock;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Random;

public class GufyWeatheringHopper extends Block implements GufyWeathering, SimpleWaterloggedBlock, IForgeBlock
{
    private final GufyWeathering.WeatherState weatherState;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final VoxelShape HOPPER_TOP = Block.box(0.0D, 10.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    public static final VoxelShape HOPPER_MIDDLE = Block.box(4.0D, 4.0D, 4.0D, 12.0D, 10.0D, 12.0D);
    public static final VoxelShape HOPPER_BOTTOM = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 4.0D, 10.0D);
    public static final VoxelShape HOPPER_FINAL = Shapes.or(HOPPER_TOP, Shapes.or(HOPPER_MIDDLE, HOPPER_BOTTOM));

    public GufyWeatheringHopper(GufyMaterials block, String name, GufyWeathering.WeatherState state) {
        super(GufyUtil.builder(block));
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)));
        this.weatherState = state;
        setRegistryName(name);
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, Level world, BlockPos pos, Player player, ItemStack stack, ToolAction toolAction)
    {
        if (!stack.canPerformAction(toolAction)) return null;
        if (ToolActions.AXE_SCRAPE.equals(toolAction)) return GufyWeathering.getPrevious(state).orElse(null);
        return null;
    }

    @NotNull
    @Override
    public InteractionResult use(BlockState blockState, Level world, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult)
    {
        Item handheldItem = player.getItemInHand(hand).getItem();
        if (Items.HONEYCOMB.equals(handheldItem)) {
            return GufyUtil.getWaxedOn(blockState).map((newBlockState) -> {
                ItemStack itemStack = player.getItemInHand(hand);
                if (!world.isClientSide)
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockPos, itemStack);
                if (!player.isCreative())
                    itemStack.shrink(1);
                world.setBlock(blockPos, newBlockState, 11);
                world.playSound(null, blockPos, SoundEvents.HONEYCOMB_WAX_ON, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.levelEvent(player, 3003, blockPos, 0);
                if (world.isClientSide)
                    ParticleUtils.spawnParticlesOnBlockFaces(world, blockPos, ParticleTypes.WAX_OFF, UniformInt.of(3, 5));
                return InteractionResult.sidedSuccess(world.isClientSide);
            }).orElse(InteractionResult.CONSUME);
        } else
            return InteractionResult.PASS;
    }

    public void randomTick(BlockState p_154929_, ServerLevel p_154930_, BlockPos p_154931_, Random p_154932_)
    {
        this.onRandomTick(p_154929_, p_154930_, p_154931_, p_154932_);
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
    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        if (stateIn.getValue(WATERLOGGED))
        {
            worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
        }

        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state)
    {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

}
