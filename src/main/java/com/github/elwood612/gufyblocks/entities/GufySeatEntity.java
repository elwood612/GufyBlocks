package com.github.elwood612.gufyblocks.entities;

import com.github.elwood612.gufyblocks.GufyRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import com.github.elwood612.gufyblocks.blocks.blockUtil.GufySeatable;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public class GufySeatEntity extends Entity
{
    private EjectType ejectType = EjectType.NORTH;

    public GufySeatEntity(EntityType<?> entityType, Level level) { super(entityType, level); }

    public GufySeatEntity(BlockPos pos, double ridingOffset, Level level, EjectType ejectType) {
        super(GufyRegistry.SEAT.get(), level);
        this.ejectType = ejectType;

        this.setPos(pos.getX() + 0.5D, pos.getY() + ridingOffset, pos.getZ() + 0.5D);
        noPhysics = true;
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide()) {
            BlockPos pos = this.blockPosition();

            if (this.getPassengers().isEmpty() || this.level().isEmptyBlock(pos)) {
                this.discard();

                this.level().updateNeighbourForOutputSignal(pos, this.level().getBlockState(pos).getBlock());
            }
        }
    }

    @Override
    protected void readAdditionalSaveData(ValueInput valueInput) {
        this.ejectType = EjectType.fromName(valueInput.getStringOr("EjectType", "North"));
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput valueOutput) {
        valueOutput.putString("EjectType", this.ejectType.name);
    }

    @Override
    public boolean hurtServer(ServerLevel serverLevel, DamageSource damageSource, float v)
    {
        return false;
    }

    @Override
    public void remove(@NotNull RemovalReason reason) {
        if (reason == RemovalReason.DISCARDED) {
            this.getPassengers().forEach(Entity::stopRiding);
        }
        super.remove(reason);
    }

    @NotNull
    @Override
    public Vec3 getDismountLocationForPassenger(@NotNull LivingEntity livingEntity) {
        BlockPos pos = this.blockPosition();

        if (this.getSeatableBlock(this.level(), pos).isEmpty()) {
            return super.getDismountLocationForPassenger(livingEntity);
        }

        int[][] offsets = DismountHelper.offsetsForDirection(this.ejectType.getPreferredDirection(this.level().getBlockState(pos), livingEntity).getCounterClockWise());
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        for (Pose pose : livingEntity.getDismountPoses()) {
            AABB aabb = livingEntity.getLocalBoundsForPose(pose);

            for (int[] offset : offsets) {
                mutableBlockPos.set(pos.getX() + offset[0], pos.getY(), pos.getZ() + offset[1]);
                double floorHeight = this.level().getBlockFloorHeight(mutableBlockPos);

                if (DismountHelper.isBlockFloorValid(floorHeight)) {
                    Vec3 vec3 = Vec3.upFromBottomCenterOf(mutableBlockPos, floorHeight);

                    if (DismountHelper.canDismountTo(this.level(), livingEntity, aabb.move(vec3))) {
                        livingEntity.setPose(pose);

                        return vec3;
                    }
                }
            }
        }
        return super.getDismountLocationForPassenger(livingEntity);
    }

    private Optional<GufySeatable> getSeatableBlock(Level level, BlockPos pos) {
        return level.getBlockState(pos).getBlock() instanceof GufySeatable seatableBlock ? Optional.of(seatableBlock) : Optional.empty();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }



    public enum EjectType {
        NORTH("north", (state, livingEntity) -> Direction.NORTH),
        ENTITY_HEAD_ROTATION("entity_head_rotation", (state, livingEntity) -> Direction.fromYRot(livingEntity.yHeadRot));

        private final String name;
        private final BiFunction<BlockState, LivingEntity, Direction> preferredDirection;

        EjectType(String name, BiFunction<BlockState, LivingEntity, Direction> preferredDirection) {
            this.name = name;
            this.preferredDirection = preferredDirection;
        }

        public String getName() {
            return this.name;
        }

        public Direction getPreferredDirection(BlockState state, LivingEntity livingEntity) {
            return this.preferredDirection.apply(state, livingEntity);
        }

        public static EjectType fromName(String name) {
            return Arrays.stream(EjectType.values()).filter(ejectType -> ejectType.getName().equals(name)).findFirst().orElse(EjectType.NORTH);
        }
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
