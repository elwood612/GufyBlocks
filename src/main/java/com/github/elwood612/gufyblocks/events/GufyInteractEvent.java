package com.github.elwood612.gufyblocks.events;

import com.github.elwood612.gufyblocks.GufyBlocks;
import com.github.elwood612.gufyblocks.items.GufyStillstone;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = GufyBlocks.MODID)
public class GufyInteractEvent
{
    // Used for Amulet of Peace
    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        Level level = event.getLevel();
        Player player = event.getEntity();
        ItemStack stack = event.getItemStack();
        Entity target = event.getTarget();
        InteractionHand handIn = event.getHand();

        if (!(target instanceof LivingEntity living)) return;

        // Quelling Amulet
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
                player.swing(handIn, SwingAnimation.DEFAULT, true);

                mob.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0));
                mob.addEffect(new MobEffectInstance(MobEffects.GLOWING, 40, 0));

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

                if (!player.getAbilities().instabuild) {
                    stack.consume(1, player);
                }

                event.setCanceled(true);
                event.setCancellationResult(InteractionResult.SUCCESS);
            }
        }
    }

    private static void pacifyMob(ServerLevel serverLevel, Mob mob, Player player) {
        mob.setSilent(true);

        Scoreboard scoreboard = serverLevel.getScoreboard();
        PlayerTeam team = scoreboard.getPlayersTeam(player.getScoreboardName());

        if (team == null) {
            team = scoreboard.getPlayerTeam("pacified_mobs");
            if (team == null) {
                team = scoreboard.addPlayerTeam("pacified_mobs");
            }
            scoreboard.addPlayerToTeam(player.getScoreboardName(), team);
        }
        scoreboard.addPlayerToTeam(mob.getScoreboardName(), team);
    }
}
