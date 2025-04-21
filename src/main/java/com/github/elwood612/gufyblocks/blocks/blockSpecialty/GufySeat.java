package com.github.elwood612.gufyblocks.blocks.blockSpecialty;

import com.github.elwood612.gufyblocks.blocks.blockUtil.GufySeatable;
import com.github.elwood612.gufyblocks.entities.GufySeatEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class GufySeat extends Block implements GufySeatable
{
    public static final VoxelShape SLAB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);

    private boolean HasCushion = true;

    public GufySeat(BlockBehaviour.Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any());

        // if map color is wood, then there is no cushion
        if (this.defaultMapColor() == MapColor.WOOD) {
            HasCushion = false;
        }
    }

    @NotNull
    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide() && !player.isShiftKeyDown() && isPlayerInRange(player, pos)) {
            this.sitOnBlock(level, pos, player);
        }

        return InteractionResult.SUCCESS;
    }

    private static boolean isPlayerInRange(Player player, BlockPos pos) {
        Vec3 position = pos.getCenter();
        int blockReachDistance = 6; // 5 or 6 sounds right

        AABB range = AABB.ofSize(position, blockReachDistance, blockReachDistance, blockReachDistance);
        return range.contains(player.position());
    }

    @Override
    public GufySeatEntity.EjectType getEjectType() {
        return GufySeatEntity.EjectType.ENTITY_HEAD_ROTATION;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        BlockState BlockState = this.defaultBlockState();
        return BlockState;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
    {
        return SLAB;
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
        return super.updateShape(stateIn, levelIn, tick, currentPos, direction, facingPos, facingState, randomSource);
    }

    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (HasCushion){
            super.fallOn(level, state, pos, entity, fallDistance * 0.5F);
        }
    }

    public void updateEntityMovementAfterFallOn(BlockGetter level, Entity entity) {
        if (HasCushion){
            if (entity.isSuppressingBounce()) {
                super.updateEntityMovementAfterFallOn(level, entity);
            } else {
                this.bounceUp(entity);
            }
        }
    }

    private void bounceUp(Entity entity) {
        Vec3 vec3 = entity.getDeltaMovement();
        if (vec3.y < 0.0) {
            double d0 = entity instanceof LivingEntity ? 1.0 : 0.8;
            entity.setDeltaMovement(vec3.x, -vec3.y * 0.6600000262260437 * d0, vec3.z);
        }
    }
}
