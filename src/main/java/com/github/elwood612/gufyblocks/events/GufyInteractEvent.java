package com.github.elwood612.gufyblocks.events;

import com.github.elwood612.gufyblocks.GufyBlocks;
import com.github.elwood612.gufyblocks.items.GufyMemoryCharm;
import com.github.elwood612.gufyblocks.items.GufyStillstone;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.Optional;

@EventBusSubscriber(modid = GufyBlocks.MODID)
public class GufyInteractEvent
{
    // Used for Amulet of Peace and Memory Charm
    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        Level level = event.getLevel();
        Player player = event.getEntity();
        ItemStack stack = event.getItemStack();
        Entity target = event.getTarget();

        if (!(target instanceof LivingEntity living)) return;

        // Amulet of Peace
        if (stack.getItem() instanceof GufyStillstone) {
            if (!(level.isClientSide()) && level instanceof ServerLevel serverLevel && target instanceof Mob mob) {
                if (player instanceof ServerPlayer serverPlayer &&
                        (mob instanceof Warden || mob instanceof EnderDragon || mob instanceof WitherBoss)) {
                    level.playSound((Player) null, player.blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 0.5f, 0.4f);
                    serverPlayer.sendSystemMessage(Component.translatable("message.gufyblocks.stillstone_resisted"));
                    event.setCanceled(true);
                    event.setCancellationResult(InteractionResult.FAIL);
                }

                pacifyMob(serverLevel, mob, player);

                if (!player.getAbilities().instabuild) {
                    stack.consume(1, player);
                }

                event.setCanceled(true);
                event.setCancellationResult(InteractionResult.SUCCESS);
            }
        }

        // Memory Charm
        if (stack.getItem() instanceof GufyMemoryCharm) {
            if (!(level.isClientSide()) && level instanceof ServerLevel serverLevel && target instanceof Villager villager) {

                resetVillager(villager);

                if (!player.getAbilities().instabuild) {
                    stack.consume(1, player);
                }

                serverLevel.playSound(null, villager.blockPosition(), SoundEvents.VILLAGER_YES, SoundSource.NEUTRAL);
                serverLevel.playSound((Player) null, villager.blockPosition(), SoundEvents.DECORATED_POT_SHATTER, SoundSource.NEUTRAL, 0.6f, 1.2f);
                serverLevel.playSound((Player) null, villager.blockPosition(), SoundEvents.BEACON_ACTIVATE, SoundSource.NEUTRAL, 0.5f, 1.5f);
                serverLevel.sendParticles(
                        ParticleTypes.HAPPY_VILLAGER,
                        villager.getX(), villager.getY() + 1, villager.getZ(),
                        20, 0.5, 0.5, 0.5, 0.02
                );
                serverLevel.sendParticles(
                        ParticleTypes.END_ROD,
                        player.getX(), player.getY(), player.getZ(),
                        10,
                        0.5, 0.5, 0.5,
                        0.1
                );
                villager.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0));
                villager.addEffect(new MobEffectInstance(MobEffects.GLOWING, 40, 0));

                event.setCanceled(true);
                event.setCancellationResult(InteractionResult.SUCCESS);
            }
        }
    }

    private static void pacifyMob(ServerLevel serverLevel, Mob mob, Player player) {
        mob.setSilent(true);
        mob.addEffect(new MobEffectInstance(MobEffects.GLOWING, 40, 0));

        addToTeam(serverLevel, player, mob);

        serverLevel.playSound(null, mob.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.NEUTRAL);
        serverLevel.playSound((Player) null, mob.blockPosition(), SoundEvents.GLASS_BREAK, SoundSource.NEUTRAL, 0.6f, 1.5f);
        serverLevel.sendParticles(
                ParticleTypes.COMPOSTER,
                player.getX(), player.getY(), player.getZ(),
                40,
                0.5, 0.5, 0.5,
                0.1
        );
        serverLevel.sendParticles(
                ParticleTypes.END_ROD,
                mob.getX(), mob.getY(), mob.getZ(),
                20,
                0.5, 0.5, 0.5,
                0.1
        );
    }

    private static void addToTeam(Level level, Player player, Mob mob) {
        Scoreboard scoreboard = level.getScoreboard();
        PlayerTeam team = scoreboard.getPlayersTeam(player.getScoreboardName());

        if (team == null) {
            team = scoreboard.getPlayerTeam("pacified_mobs");
            if (team == null) {
                team = scoreboard.addPlayerTeam("pacified_mobs");
            }
            scoreboard.addPlayerToTeam(player.getScoreboardName(), team);
        }
        scoreboard.addPlayerToTeam(mob.getScoreboardName(), team);
        mob.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0));
    }

    private static void resetVillager (Villager villager) {
        // 0. Release POIs first
        villager.releasePoi(MemoryModuleType.JOB_SITE);
        villager.releasePoi(MemoryModuleType.POTENTIAL_JOB_SITE);

        // 1. Reset profession to NONE
        HolderGetter<VillagerProfession> professions = villager.registryAccess().lookupOrThrow(Registries.VILLAGER_PROFESSION);
        Holder<VillagerProfession> noneProfession = professions.getOrThrow(VillagerProfession.NONE);
        villager.setVillagerData(villager.getVillagerData().withProfession(noneProfession).withLevel(1));

        // 2. Clear all trades
        villager.setOffers(new MerchantOffers());

        // 3. Reset XP
        villager.setVillagerXp(0);

        // 4. Clear inventory
        villager.getInventory().clearContent();

        // 5. Forget job site
        Brain<Villager> brain = villager.getBrain();
        brain.eraseMemory(MemoryModuleType.JOB_SITE);
        brain.eraseMemory(MemoryModuleType.POTENTIAL_JOB_SITE);

        // 6. Force brain refresh (important)
        villager.refreshBrain((ServerLevel) villager.level());
    }
}
