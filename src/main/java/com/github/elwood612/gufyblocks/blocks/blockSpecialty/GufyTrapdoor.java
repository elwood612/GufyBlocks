package com.github.elwood612.gufyblocks.blocks.blockSpecialty;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.function.BiConsumer;

// GufyTrapdoor copies the entire TrapDoorBlock class
// Only two changes:
//      Add a SoundEvent soundEvent and set it to the properties.soundType.getPlaceSound()
//      Modify the playSound method to use soundEvent

public class GufyTrapdoor extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<GufyTrapdoor> CODEC = RecordCodecBuilder.mapCodec((p_368443_) -> p_368443_.group(BlockSetType.CODEC.fieldOf("block_set_type").forGetter((p_304735_) -> p_304735_.type), propertiesCodec()).apply(p_368443_, GufyTrapdoor::new));
    public static final BooleanProperty OPEN;
    public static final EnumProperty<Half> HALF;
    public static final BooleanProperty POWERED;
    public static final BooleanProperty WATERLOGGED;
    protected static final int AABB_THICKNESS = 3;
    protected static final VoxelShape EAST_OPEN_AABB;
    protected static final VoxelShape WEST_OPEN_AABB;
    protected static final VoxelShape SOUTH_OPEN_AABB;
    protected static final VoxelShape NORTH_OPEN_AABB;
    protected static final VoxelShape BOTTOM_AABB;
    protected static final VoxelShape TOP_AABB;
    private final BlockSetType type;
    private final SoundEvent soundEvent;

    public MapCodec<? extends GufyTrapdoor> codec() {
        return CODEC;
    }

    public GufyTrapdoor(BlockSetType type, BlockBehaviour.Properties properties) {
        super(properties);
        this.type = type;
        this.soundEvent = properties.soundType.getPlaceSound();
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(OPEN, false)).setValue(HALF, Half.BOTTOM)).setValue(POWERED, false)).setValue(WATERLOGGED, false));
    }

    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (!(Boolean)state.getValue(OPEN)) {
            return state.getValue(HALF) == Half.TOP ? TOP_AABB : BOTTOM_AABB;
        } else {
            switch ((Direction)state.getValue(FACING)) {
                case NORTH:
                default:
                    return NORTH_OPEN_AABB;
                case SOUTH:
                    return SOUTH_OPEN_AABB;
                case WEST:
                    return WEST_OPEN_AABB;
                case EAST:
                    return EAST_OPEN_AABB;
            }
        }
    }

    protected boolean isPathfindable(BlockState p_57535_, PathComputationType p_57538_) {
        switch (p_57538_) {
            case LAND -> {
                return (Boolean)p_57535_.getValue(OPEN);
            }
            case WATER -> {
                return (Boolean)p_57535_.getValue(WATERLOGGED);
            }
            case AIR -> {
                return (Boolean)p_57535_.getValue(OPEN);
            }
            default -> {
                return false;
            }
        }
    }

    protected InteractionResult useWithoutItem(BlockState p_57540_, Level p_57541_, BlockPos p_57542_, Player p_57543_, BlockHitResult p_57545_) {
        if (!this.type.canOpenByHand()) {
            return InteractionResult.PASS;
        } else {
            this.toggle(p_57540_, p_57541_, p_57542_, p_57543_);
            return InteractionResult.SUCCESS;
        }
    }

    protected void onExplosionHit(BlockState p_312371_, ServerLevel p_360483_, BlockPos p_312879_, Explosion p_312330_, BiConsumer<ItemStack, BlockPos> p_312161_) {
        if (p_312330_.canTriggerBlocks() && this.type.canOpenByWindCharge() && !(Boolean)p_312371_.getValue(POWERED)) {
            this.toggle(p_312371_, p_360483_, p_312879_, (Player)null);
        }

        super.onExplosionHit(p_312371_, p_360483_, p_312879_, p_312330_, p_312161_);
    }

    private void toggle(BlockState state, Level level, BlockPos pos, @Nullable Player player) {
        BlockState blockstate = (BlockState)state.cycle(OPEN);
        level.setBlock(pos, blockstate, 2);
        if ((Boolean)blockstate.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        this.playSound(player, level, pos, (Boolean)blockstate.getValue(OPEN));
    }

    protected void playSound(@Nullable Player player, Level level, BlockPos pos, boolean isOpened) {
        level.playSound(player, pos, soundEvent, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
        level.gameEvent(player, isOpened ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
    }

    protected void neighborChanged(BlockState p_57547_, Level p_57548_, BlockPos p_57549_, Block p_57550_, @Nullable Orientation p_364404_, boolean p_57552_) {
        if (!p_57548_.isClientSide) {
            boolean flag = p_57548_.hasNeighborSignal(p_57549_);
            if (flag != (Boolean)p_57547_.getValue(POWERED)) {
                if ((Boolean)p_57547_.getValue(OPEN) != flag) {
                    p_57547_ = (BlockState)p_57547_.setValue(OPEN, flag);
                    this.playSound((Player)null, p_57548_, p_57549_, flag);
                }

                p_57548_.setBlock(p_57549_, (BlockState)p_57547_.setValue(POWERED, flag), 2);
                if ((Boolean)p_57547_.getValue(WATERLOGGED)) {
                    p_57548_.scheduleTick(p_57549_, Fluids.WATER, Fluids.WATER.getTickDelay(p_57548_));
                }
            }
        }

    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = this.defaultBlockState();
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        Direction direction = context.getClickedFace();
        if (!context.replacingClickedOnBlock() && direction.getAxis().isHorizontal()) {
            blockstate = (BlockState)((BlockState)blockstate.setValue(FACING, direction)).setValue(HALF, context.getClickLocation().y - (double)context.getClickedPos().getY() > (double)0.5F ? Half.TOP : Half.BOTTOM);
        } else {
            blockstate = (BlockState)((BlockState)blockstate.setValue(FACING, context.getHorizontalDirection().getOpposite())).setValue(HALF, direction == Direction.UP ? Half.BOTTOM : Half.TOP);
        }

        if (context.getLevel().hasNeighborSignal(context.getClickedPos())) {
            blockstate = (BlockState)((BlockState)blockstate.setValue(OPEN, true)).setValue(POWERED, true);
        }

        return (BlockState)blockstate.setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, OPEN, HALF, POWERED, WATERLOGGED});
    }

    protected FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    protected BlockState updateShape(BlockState p_57554_, LevelReader p_374386_, ScheduledTickAccess p_374038_, BlockPos p_57558_, Direction p_57555_, BlockPos p_57559_, BlockState p_57556_, RandomSource p_374093_) {
        if ((Boolean)p_57554_.getValue(WATERLOGGED)) {
            p_374038_.scheduleTick(p_57558_, Fluids.WATER, Fluids.WATER.getTickDelay(p_374386_));
        }

        return super.updateShape(p_57554_, p_374386_, p_374038_, p_57558_, p_57555_, p_57559_, p_57556_, p_374093_);
    }

    public boolean isLadder(BlockState state, LevelReader world, BlockPos pos, LivingEntity entity) {
        if ((Boolean)state.getValue(OPEN)) {
            BlockPos downPos = pos.below();
            BlockState down = world.getBlockState(downPos);
            return down.getBlock().makesOpenTrapdoorAboveClimbable(down, world, downPos, state);
        } else {
            return false;
        }
    }

    protected BlockSetType getType() {
        return this.type;
    }

    static {
        OPEN = BlockStateProperties.OPEN;
        HALF = BlockStateProperties.HALF;
        POWERED = BlockStateProperties.POWERED;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        EAST_OPEN_AABB = Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)3.0F, (double)16.0F, (double)16.0F);
        WEST_OPEN_AABB = Block.box((double)13.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)16.0F, (double)16.0F);
        SOUTH_OPEN_AABB = Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)16.0F, (double)3.0F);
        NORTH_OPEN_AABB = Block.box((double)0.0F, (double)0.0F, (double)13.0F, (double)16.0F, (double)16.0F, (double)16.0F);
        BOTTOM_AABB = Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)3.0F, (double)16.0F);
        TOP_AABB = Block.box((double)0.0F, (double)13.0F, (double)0.0F, (double)16.0F, (double)16.0F, (double)16.0F);
    }
}

