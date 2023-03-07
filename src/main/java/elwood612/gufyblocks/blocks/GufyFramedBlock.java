package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class GufyFramedBlock extends HorizontalDirectionalBlock {
    protected GufyFramedBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult)
    {
        Item handheldItem = player.getItemInHand(hand).getItem();
        if (Items.HONEYCOMB.equals(handheldItem)) {
            return GufyUtil.getWaxedOn(blockState).map((newBlockState) -> {
                ItemStack itemStack = player.getItemInHand(hand);
                if (player instanceof ServerPlayer)
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockPos, itemStack);
                if (!player.isCreative())
                    itemStack.shrink(1);
                level.setBlock(blockPos, newBlockState, 11);
                //level.playSound(null, blockPos, SoundEvents.HONEYCOMB_WAX_ON, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3003, blockPos, 0);
                //if (level.isClientSide)
                //    ParticleUtils.spawnParticlesOnBlockFaces(level, blockPos, ParticleTypes.WAX_OFF, UniformInt.of(3, 5));
                return InteractionResult.sidedSuccess(level.isClientSide);
            }).orElse(InteractionResult.CONSUME);
        } else
            return InteractionResult.PASS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    }

    @NotNull
    public BlockState rotate(BlockState state, Rotation rot)
    {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @NotNull
    public BlockState mirror(BlockState state, Mirror mirrorIn)
    {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }
}
