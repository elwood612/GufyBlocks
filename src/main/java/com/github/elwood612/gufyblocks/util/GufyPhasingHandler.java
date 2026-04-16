package com.github.elwood612.gufyblocks.util;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GufyPhasingHandler
{
    public static final Map<UUID, BlockPos> activePhasing = new HashMap<>();
    public static GameType originalMode = GameType.DEFAULT_MODE;

    public static void returnPlayer(ServerPlayer player) {
        BlockPos origin = activePhasing.remove(player.getUUID());
        Level level = player.level();
        if (origin == null) return;

        player.teleportTo(origin.getX() + 0.5, origin.getY() + 1, origin.getZ() + 0.5);
        player.setGameMode(originalMode);
        player.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 60, 0));

        level.playSound((Player) null,
                player.getOnPos(),
                SoundEvents.PLAYER_TELEPORT,
                SoundSource.PLAYERS);
        level.explode(null, // no entity source
                origin.getX() + 0.5,
                origin.getY() + 2,
                origin.getZ() + 0.5,
                1.0f,
                true,
                Level.ExplosionInteraction.MOB
        );
    }
}
