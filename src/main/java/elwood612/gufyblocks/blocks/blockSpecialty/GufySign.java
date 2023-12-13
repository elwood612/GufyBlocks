package elwood612.gufyblocks.blocks.blockSpecialty;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.contents.LiteralContents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SignApplicator;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.UUID;

public class GufySign extends BaseEntityBlock implements SimpleWaterloggedBlock
{
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;
    protected static final float AABB_OFFSET = 4.0F;
    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public GufySign(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(ROTATION, Integer.valueOf(0)).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

//    public BlockState updateShape(BlockState state1, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos1, BlockPos pos2) {
//        if (state1.getValue(WATERLOGGED)) {
//            level.scheduleTick(pos1, Fluids.WATER, Fluids.WATER.getTickDelay(level));
//        }
//
//        return super.updateShape(state1, direction, state2, level, pos1, pos2);
//    }

    public BlockState updateShape(BlockState state1, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos1, BlockPos pos2) {
        return direction == Direction.DOWN && !this.canSurvive(state1, level, pos1) ?
                Blocks.AIR.defaultBlockState() :
                super.updateShape(state1, direction, state2, level, pos1, pos2);
    }

    public VoxelShape getShape(BlockState p_56293_, BlockGetter p_56294_, BlockPos p_56295_, CollisionContext p_56296_) {
        return SHAPE;
    }

    public boolean isPossibleToRespawnInThis(BlockState p_279137_) {
        return true;
    }

    public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
        return new SignBlockEntity(p_154556_, p_154557_);
    }

    public InteractionResult use(BlockState p_56278_, Level p_56279_, BlockPos p_56280_, Player p_56281_, InteractionHand p_56282_, BlockHitResult p_56283_) {
        ItemStack itemstack = p_56281_.getItemInHand(p_56282_);
        Item item = itemstack.getItem();
        Item $$11 = itemstack.getItem();
        SignApplicator signapplicator2;
        if ($$11 instanceof SignApplicator signapplicator1) {
            signapplicator2 = signapplicator1;
        } else {
            signapplicator2 = null;
        }

        SignApplicator signapplicator = signapplicator2;
        boolean flag1 = signapplicator != null && p_56281_.mayBuild();
        BlockEntity $$12 = p_56279_.getBlockEntity(p_56280_);
        if ($$12 instanceof SignBlockEntity signblockentity) {
            if (!p_56279_.isClientSide) {
                boolean flag2 = signblockentity.isFacingFrontText(p_56281_);
                SignText signtext = signblockentity.getText(flag2);
                boolean flag = signblockentity.executeClickCommandsIfPresent(p_56281_, p_56279_, p_56280_, flag2);
                if (signblockentity.isWaxed()) {
                    p_56279_.playSound((Player)null, signblockentity.getBlockPos(), SoundEvents.WAXED_SIGN_INTERACT_FAIL, SoundSource.BLOCKS);
                    return InteractionResult.PASS;
                } else if (flag1 && !this.otherPlayerIsEditingSign(p_56281_, signblockentity) && signapplicator.canApplyToSign(signtext, p_56281_) && signapplicator.tryApplyToSign(p_56279_, signblockentity, flag2, p_56281_)) {
                    if (!p_56281_.isCreative()) {
                        itemstack.shrink(1);
                    }

                    p_56279_.gameEvent(GameEvent.BLOCK_CHANGE, signblockentity.getBlockPos(), GameEvent.Context.of(p_56281_, signblockentity.getBlockState()));
                    p_56281_.awardStat(Stats.ITEM_USED.get(item));
                    return InteractionResult.SUCCESS;
                } else if (flag) {
                    return InteractionResult.SUCCESS;
                } else if (!this.otherPlayerIsEditingSign(p_56281_, signblockentity) && p_56281_.mayBuild() && this.hasEditableText(p_56281_, signblockentity, flag2)) {
                    this.openTextEdit(p_56281_, signblockentity, flag2);
                    return InteractionResult.SUCCESS;
                } else {
                    return InteractionResult.PASS;
                }
            } else {
                return !flag1 && !signblockentity.isWaxed() ? InteractionResult.CONSUME : InteractionResult.SUCCESS;
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    private boolean hasEditableText(Player p_279394_, SignBlockEntity p_279187_, boolean p_279225_) {
        SignText signtext = p_279187_.getText(p_279225_);
        return Arrays.stream(signtext.getMessages(p_279394_.isTextFilteringEnabled())).allMatch((p_279411_) -> {
            return p_279411_.equals(CommonComponents.EMPTY) || p_279411_.getContents() instanceof LiteralContents;
        });
    }

//    public abstract float getYRotationDegrees(BlockState p_277705_);

    public Vec3 getSignHitboxCenterPosition(BlockState p_278294_) {
        return new Vec3(0.5D, 0.5D, 0.5D);
    }

    public FluidState getFluidState(BlockState p_56299_) {
        return p_56299_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_56299_);
    }

//    public WoodType type() {
//        return this.type;
//    }

    public static WoodType getWoodType(Block p_251096_) {
        WoodType woodtype;
        if (p_251096_ instanceof SignBlock) {
            woodtype = ((SignBlock)p_251096_).type();
        } else {
            woodtype = WoodType.OAK;
        }

        return woodtype;
    }

    public void openTextEdit(Player p_277738_, SignBlockEntity p_277467_, boolean p_277771_) {
        p_277467_.setAllowedPlayerEditor(p_277738_.getUUID());
        p_277738_.openTextEdit(p_277467_, p_277771_);
    }

    private boolean otherPlayerIsEditingSign(Player p_277952_, SignBlockEntity p_277599_) {
        UUID uuid = p_277599_.getPlayerWhoMayEdit();
        return uuid != null && !uuid.equals(p_277952_.getUUID());
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_277367_, BlockState p_277896_, BlockEntityType<T> p_277724_) {
        return createTickerHelper(p_277724_, BlockEntityType.SIGN, SignBlockEntity::tick);
    }




    public boolean canSurvive(BlockState p_56995_, LevelReader p_56996_, BlockPos p_56997_) {
        return p_56996_.getBlockState(p_56997_.below()).isSolid();
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_56993_) {
        FluidState fluidstate = p_56993_.getLevel().getFluidState(p_56993_.getClickedPos());
        return this.defaultBlockState().setValue(ROTATION, Integer.valueOf(RotationSegment.convertToSegment(p_56993_.getRotation() + 180.0F))).setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
    }

    public float getYRotationDegrees(BlockState p_277795_) {
        return RotationSegment.convertToDegrees(p_277795_.getValue(ROTATION));
    }

    public BlockState rotate(BlockState p_57002_, Rotation p_57003_) {
        return p_57002_.setValue(ROTATION, Integer.valueOf(p_57003_.rotate(p_57002_.getValue(ROTATION), 16)));
    }

    public BlockState mirror(BlockState p_56999_, Mirror p_57000_) {
        return p_56999_.setValue(ROTATION, Integer.valueOf(p_57000_.mirror(p_56999_.getValue(ROTATION), 16)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57012_) {
        p_57012_.add(ROTATION, WATERLOGGED);
    }
}
