package com.github.elwood612.gufyblocks.items;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

public class GufyMemoryCharm extends Item
{
    public GufyMemoryCharm(Item.Properties properties) { super(properties); }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        Level level = player.level();

        if (!(level.isClientSide()) && level instanceof ServerLevel serverLevel && target instanceof Villager villager && player.isShiftKeyDown()) {

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

            return InteractionResult.CONSUME;
        } else {
            return InteractionResult.FAIL;
        }
    }

    private void resetVillager (Villager villager) {
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

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

}
