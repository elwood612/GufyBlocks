package com.github.elwood612.gufyblocks.items;

import com.github.elwood612.gufyblocks.events.GufyPlayerEvents;
import com.github.elwood612.gufyblocks.util.GufyTags;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.LodestoneTracker;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.BuiltinStructureSets;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class GufyWhisperingCompass extends Item
{
    public GufyWhisperingCompass(Item.Properties properties) { super(properties); }

    private BlockPos lastSuccessfulSearchPos = null;
    private ResourceKey<Level> lastSuccessfulSearchDimension = null;
    private GlobalPos lastSuccessfulTarget = null;

    @Override
    public void inventoryTick(@NotNull ItemStack stack, ServerLevel level, @NotNull Entity entity, @Nullable EquipmentSlot slot) {
        if (!level.isClientSide() && entity instanceof Player player && level.getGameTime() % (80 + player.getId() % 20) == 0) {
            BlockPos playerPos = player.blockPosition();
            RegistryAccess registryAccess = level.registryAccess();
            HolderLookup.RegistryLookup<Structure> structureLookup = registryAccess.lookupOrThrow(Registries.STRUCTURE);
            HolderSet<Structure> targets = structureLookup.getOrThrow(GufyTags.ALL_COMPASS_TARGETS);
            long averageTickTime = level.getServer().getAverageTickTimeNanos();
            int radius = averageTickTime > 40_000_000L ? 2 : 3; // would be nice to actually measure this

            if (lastSuccessfulSearchPos != null && lastSuccessfulSearchDimension != null &&
                    (lastSuccessfulSearchDimension.equals(level.dimension()) && playerPos.distSqr(lastSuccessfulSearchPos) < 32 * 32)){
//                System.out.println("Skipping compass search - haven't moved far enough");
                return;
            }
            if (level.getGameTime() < GufyPlayerEvents.lastGlobalLoginTick) {
//                System.out.println("Skipping compass search - too soon after player login");
                return;
            }
            if (averageTickTime > 50_000_000L && level.random.nextFloat() < 0.5f) {
//                System.out.println("Skipping compass search - too much server lag");
                return;
            }

            Pair<BlockPos, Holder<Structure>> result =
                    level.getChunkSource().getGenerator().findNearestMapStructure(
                            level,
                            targets,
                            playerPos,
                            radius,
                            false
                    );

            lastSuccessfulSearchPos = playerPos;
            lastSuccessfulSearchDimension = level.dimension();

            if (result != null) {
                BlockPos candidatePos = result.getFirst();
                GlobalPos targetPos = GlobalPos.of(level.dimension(), result.getFirst());

                double maxDistance = 28 * 16;
                double distSqr = candidatePos.distSqr(playerPos);
                int surfaceY = level.getHeight(Heightmap.Types.WORLD_SURFACE, candidatePos.getX(), candidatePos.getZ());
                boolean isUndergroundPortal = false;
                if (result.getSecond().is(BuiltinStructureSets.RUINED_PORTALS.identifier()) && candidatePos.getY() < surfaceY - 8) {
                    isUndergroundPortal = true;
                }

                if (distSqr <= maxDistance * maxDistance && !isUndergroundPortal) {
                    LodestoneTracker tracker = new LodestoneTracker(Optional.of(targetPos), true);
                    stack.set(DataComponents.LODESTONE_TRACKER, tracker);
//                    System.out.println("Found valid compass target");
                    if (lastSuccessfulTarget == null || !lastSuccessfulTarget.equals(targetPos)) {
                        level.playSound((Player) null,
                                playerPos,
                                SoundEvents.SPYGLASS_USE,
                                SoundSource.PLAYERS,
                                1f, 1.5f);
                    }
                    lastSuccessfulTarget = targetPos;

                } else {
                    stack.remove(DataComponents.LODESTONE_TRACKER);
//                    System.out.println("No valid compass target");
                    if (lastSuccessfulTarget != null) {
                        level.playSound((Player) null,
                                playerPos,
                                SoundEvents.SPYGLASS_STOP_USING,
                                SoundSource.PLAYERS,
                                1f, 1.2f);
                        level.playSound((Player) null,
                                playerPos,
                                SoundEvents.NOTE_BLOCK_HAT.value(),
                                SoundSource.PLAYERS,
                                0.3f, 1.2f);
                    }
                    lastSuccessfulTarget = null;
                }
            } else {
                stack.remove(DataComponents.LODESTONE_TRACKER);
//                System.out.println("No valid compass target");
                if (lastSuccessfulTarget != null) {
                    level.playSound((Player) null,
                            playerPos,
                            SoundEvents.SPYGLASS_STOP_USING,
                            SoundSource.PLAYERS,
                            1f, 1.2f);
                    level.playSound((Player) null,
                            playerPos,
                            SoundEvents.NOTE_BLOCK_HAT.value(),
                            SoundSource.PLAYERS,
                            0.3f, 1.2f);
                }
                lastSuccessfulTarget = null;
            }
        }
        super.inventoryTick(stack, level, entity, slot);
    }
}
