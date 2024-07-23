package com.github.elwood612.gufyblocks.blocks.blockUtil;


import com.github.elwood612.gufyblocks.entities.GufySeatEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.EntityGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public interface GufySeatable
{
    GufySeatEntity.EjectType getEjectType();

    default double getRidingOffset() {
        return 0.4D;
    }

    default boolean isSeatOccupied(EntityGetter entityGetter, BlockPos pos) {
        return !entityGetter.getEntitiesOfClass(GufySeatEntity.class, new AABB(pos)).isEmpty();
    }

    default void sitOnBlock(Level level, BlockPos pos, LivingEntity entity) {
        if (!this.isSeatOccupied(level, pos)) {
            GufySeatEntity chair = new GufySeatEntity(pos, this.getRidingOffset(), level, this.getEjectType());

            level.addFreshEntity(chair);
            entity.startRiding(chair);

            level.updateNeighbourForOutputSignal(pos, level.getBlockState(pos).getBlock());
        }
    }
}
