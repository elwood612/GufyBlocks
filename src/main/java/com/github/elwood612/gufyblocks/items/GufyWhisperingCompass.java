package com.github.elwood612.gufyblocks.items;

import com.github.elwood612.gufyblocks.GufyRegistry;
import com.github.elwood612.gufyblocks.events.GufyClientEvents;
import com.github.elwood612.gufyblocks.events.GufyPlayerEvents;
import com.github.elwood612.gufyblocks.util.GufyCompassData;
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
import net.minecraft.world.level.levelgen.structure.Structure;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class GufyWhisperingCompass extends Item
{
    public GufyWhisperingCompass(Item.Properties properties) { super(properties); }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, ServerLevel level, @NotNull Entity entity, @Nullable EquipmentSlot slot) {

        // Every time a player logs in, including you, close & reset the compass
        if (level.getGameTime() < GufyPlayerEvents.lastGlobalLoginTick) {
            if (stack.get(DataComponents.LODESTONE_TRACKER) != null) {
                stack.remove(DataComponents.LODESTONE_TRACKER);
            }
            if (stack.get(GufyRegistry.COMPASS_DATA.get()) != null) {
                stack.remove(GufyRegistry.COMPASS_DATA);
            }
            return;
        }

        if (entity instanceof Player player && level.getGameTime() % (80 + player.getId() % 20) == 0) {
            BlockPos playerPos = player.blockPosition();
            RegistryAccess registryAccess = level.registryAccess();
            HolderLookup.RegistryLookup<Structure> structureLookup = registryAccess.lookupOrThrow(Registries.STRUCTURE);
            HolderSet<Structure> targets = structureLookup.getOrThrow(GufyTags.ALL_COMPASS_TARGETS);
            long averageTickTime = level.getServer().getAverageTickTimeNanos();
            int radius = averageTickTime > 40_000_000L ? 2 : 3; // would be nice to actually measure this
            GufyCompassData lastSearchData = stack.get(GufyRegistry.COMPASS_DATA.get());

            // if we haven't moved far enough - skip search
            if (lastSearchData != null && (lastSearchData.lastSuccessfulSearchDimension().equals(level.dimension()) &&
                            playerPos.distSqr(lastSearchData.lastSuccessfulSearchPos()) < 32 * 32)){
                return;
            }
            // if server is struggling - skip half the searches
            if (averageTickTime > 50_000_000L && level.random.nextFloat() < 0.5f) {
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

            GlobalPos newTarget = null;

            if (result != null) {
                BlockPos candidatePos = result.getFirst();
                double distSqr = candidatePos.distSqr(playerPos);
                double maxDistance = 28 * 16;
                int surfaceY = level.getHeight(Heightmap.Types.WORLD_SURFACE, candidatePos.getX(), candidatePos.getZ());
                boolean isUndergroundPortal =
                        result.getSecond().is(BuiltinStructureSets.RUINED_PORTALS.identifier()) && candidatePos.getY() < surfaceY - 8;

                if (distSqr <= maxDistance * maxDistance && !isUndergroundPortal) {
                    newTarget = GlobalPos.of(level.dimension(), result.getFirst());
                    stack.set(DataComponents.LODESTONE_TRACKER,
                            new LodestoneTracker(Optional.of(newTarget), true));
                } else {
                    stack.remove(DataComponents.LODESTONE_TRACKER);
                }
            } else {
                stack.remove(DataComponents.LODESTONE_TRACKER);
            }

            GlobalPos oldTarget = lastSearchData != null ? lastSearchData.lastSuccessfulTarget() : null;

            if (newTarget != null && (oldTarget == null || !oldTarget.equals(newTarget))) {
                level.playSound(null, playerPos, SoundEvents.SPYGLASS_USE, SoundSource.NEUTRAL, 1f, 1.5f);
            } else if (oldTarget != null && newTarget == null) {
                level.playSound(null, playerPos, SoundEvents.SPYGLASS_STOP_USING, SoundSource.NEUTRAL, 1f, 1.2f);
                level.playSound(null, playerPos, SoundEvents.NOTE_BLOCK_HAT.value(), SoundSource.NEUTRAL, 0.4f, 1.2f);
            }

            stack.set(GufyRegistry.COMPASS_DATA.get(),
                    new GufyCompassData(playerPos, level.dimension(), newTarget));
        }
        super.inventoryTick(stack, level, entity, slot);
    }
}
