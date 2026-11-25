package com.github.elwood612.gufyblocks.items.itemUtil;

import com.github.elwood612.gufyblocks.GufyBlocks;
import com.github.elwood612.gufyblocks.items.GufyMemoryCharm;
import com.github.elwood612.gufyblocks.util.GufyScheduler;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = GufyBlocks.MODID)
public class MemoryCharmInteraction
{
    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        Level level = event.getLevel();
        Player player = event.getEntity();
        ItemStack stack = event.getItemStack();
        Entity target = event.getTarget();
        InteractionHand handIn = event.getHand();

        if (!(target instanceof LivingEntity living)) return;

        if (stack.getItem() instanceof GufyMemoryCharm) {
            if (!(level.isClientSide())
                    && level instanceof ServerLevel serverLevel
                    && target instanceof Villager villager
                    && player instanceof ServerPlayer serverPlayer) {

                downgradeVillager(villager, serverLevel, serverPlayer);
                player.swing(handIn, SwingAnimation.DEFAULT, true);

                if (!player.getAbilities().instabuild) {
                    stack.consume(1, player);
                    AdvancementHolder advancementHolder = serverLevel.getServer().getAdvancements().get(Identifier.fromNamespaceAndPath("gufyblocks", "undo_trade"));
                    if (advancementHolder != null) serverPlayer.getAdvancements().award(advancementHolder, "undo_trade");
                }

                serverLevel.playSound(null, villager.blockPosition(), SoundEvents.VILLAGER_YES, SoundSource.NEUTRAL);
                serverLevel.playSound((Player) null, villager.blockPosition(), SoundEvents.TUFF_BRICKS_BREAK, SoundSource.NEUTRAL, 0.9f, 1.2f);
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

    private static void downgradeVillager(Villager villager, ServerLevel serverLevel, ServerPlayer serverPlayer) {
        int initialVillagerLevel = villager.getVillagerData().level();

        // If already at level 1, perform a full reset instead
        if (initialVillagerLevel <= 1) {
            resetVillager(villager, serverLevel, serverPlayer);
            return;
        }

        MerchantOffers offers = villager.getOffers();

        // For now, remove 2 trades
        // If villager trade rebalance happens,
        // might need to adjust based on profession too
        int tradesToRemove = switch (initialVillagerLevel) {
            case 5 -> 2; // Master
            case 4 -> 2; // Expert
            case 3 -> 2; // Journeyman
            case 2 -> 2; // Apprentice
            default -> 0;
        };
        for (int i = 0; i < tradesToRemove && !offers.isEmpty(); i++) {
            offers.remove(offers.size() - 1);
        }

        // Downgrade the villager and reset XP.
        villager.setVillagerData(villager.getVillagerData().withLevel(initialVillagerLevel - 1));
        villager.setVillagerXp(initialVillagerLevel == 2 ? 1 : 0);
        villager.playWorkSound();
    }

    private static void resetVillager(Villager villager, ServerLevel serverLevel, ServerPlayer serverPlayer) {
        // Release POIs first
        villager.releasePoi(MemoryModuleType.JOB_SITE);
        villager.releasePoi(MemoryModuleType.POTENTIAL_JOB_SITE);

        // Reset profession to NONE
        Holder<VillagerProfession> prof = BuiltInRegistries.VILLAGER_PROFESSION.getOrThrow(VillagerProfession.NONE);
        villager.setVillagerData(villager.getVillagerData().withProfession(prof).withLevel(1));
        serverLevel.playSound(null, villager.blockPosition(), SoundEvents.VILLAGER_NO, SoundSource.NEUTRAL);

        // Reset XP & inventory & trades
        villager.setVillagerXp(0);
        villager.getInventory().clearContent();

        // Forget job site after 3 seconds
        GufyScheduler.schedule(serverLevel, 60, serverPlayer.getUUID(), () -> {
            villager.refreshBrain(serverLevel);
        });
    }


}
