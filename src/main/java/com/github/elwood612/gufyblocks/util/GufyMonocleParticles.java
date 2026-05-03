package com.github.elwood612.gufyblocks.util;

import com.github.elwood612.gufyblocks.GufyRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.*;

public class GufyMonocleParticles
{
    public static boolean OVERRIDE = true;
    private static final List<Particle> myParticles = new ArrayList<>();
    public static final Set<UUID> HIGHLIGHTED = new HashSet<>();

    public static void showLightLevelParticles(Level level, Player player) {
        if (OVERRIDE) {
            // instantly clear particles if they exist
            if (!myParticles.isEmpty()) {
                for (Particle p : myParticles) {
                    p.remove();
                }
                myParticles.clear();
            }
            return;
        }

        BlockPos center = player.blockPosition();
        int r = 10;

        for (BlockPos pos : BlockPos.betweenClosed(
                center.offset(-r, -r, -r),
                center.offset(r, r, r))) {

            if (!isHostileSpawnable(level, pos)) continue;

            double x = pos.getX() + 0.5;
            double y = pos.getY() + 1.01;
            double z = pos.getZ() + 0.5;

            if (level.random.nextInt(3) == 0) {
                spawnSmallParticles(level, pos, x, y, z);
            }
            if ((pos.asLong() % 20) == Math.max(level.getGameTime() % 40, 1)) {
//                spawnBigParticles(level, pos, x, y, z);
            }
        }
    }

    public static void highlightNearbyMobs(Level level, Player player) {
        if (OVERRIDE) return;

        HIGHLIGHTED.clear();
        AABB box = player.getBoundingBox().inflate(10);

        if (level.getGameTime() % 5 == 0) {
            for (Mob mob : level.getEntitiesOfClass(Mob.class, box)) {
                HIGHLIGHTED.add(mob.getUUID());
            }
        }



//        BlockPos center = player.blockPosition();
//        AABB box = new AABB(center).inflate(10);
//        List<Mob> mobs = level.getEntitiesOfClass(Mob.class, box);
//
//        if (level.getGameTime() % 5 == 0) {
//            for (Mob mob : mobs) {
//                mob.addEffect(new MobEffectInstance(MobEffects.GLOWING, 5, 0));
//            }
//        }
    }

    private static boolean isHostileSpawnable(Level level, BlockPos pos) {
        if (level.getBrightness(LightLayer.BLOCK, pos.above()) != 0) return false;
        if (!level.isEmptyBlock(pos.above())) return false;
        BlockState state = level.getBlockState(pos);
        return state.isSolidRender();
//        return state.isCollisionShapeFullBlock(level, pos);
    }

    private static void spawnSmallParticles(Level level, BlockPos pos, double x, double y, double z) {
        Particle p = Minecraft.getInstance().particleEngine.createParticle(
                GufyRegistry.MONOCLE_PARTICLE.get(),
                pos.getX() + level.random.nextDouble(),
                pos.getY() + 1.1,
                pos.getZ() + level.random.nextDouble(),
                0.0,
                0.05,
                0.0);
        if (p!= null) myParticles.add(p);
    }

    private static void spawnBigParticles(Level level, BlockPos pos, double x, double y, double z) {
        float scale = 1 + (level.random.nextFloat() / 3);
        float xSpeed = level.random.nextFloat() / 8;
        float ySpeed = level.random.nextFloat() / 4;
        float zSpeed = level.random.nextFloat() / 8;

        Particle p = Minecraft.getInstance().particleEngine.createParticle(new DustParticleOptions(0xFF0000, scale), x, y, z, xSpeed, ySpeed, zSpeed);
        if (p != null) myParticles.add(p);
    }
}
