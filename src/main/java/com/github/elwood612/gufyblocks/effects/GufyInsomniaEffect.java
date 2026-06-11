package com.github.elwood612.gufyblocks.effects;

import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.clock.ServerClockManager;
import net.minecraft.world.clock.WorldClock;
import net.minecraft.world.clock.WorldClocks;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class GufyInsomniaEffect extends MobEffect {

    private boolean spawnImmediately = false;
    private int delay = 10;

    public GufyInsomniaEffect (MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {

        BlockPos pos = entity.getOnPos();
        delay = level.getRandom().nextInt(200, 1200);

        if (!(entity instanceof ServerPlayer player)) return false;

        if (level.dimension() != Level.OVERWORLD) {
            player.sendSystemMessage(Component.translatable("message.gufyblocks.insomnia_effect_dimension"));
            return true;
        }
        if (!level.canSeeSky(pos.above())) {
            player.sendSystemMessage(Component.translatable("message.gufyblocks.insomnia_effect_skyLight"));
            return true;
        }
        if (pos.getY() < 64) {
            player.sendSystemMessage(Component.translatable("message.gufyblocks.insomnia_effect_yLevel"));
            return true;
        }

        Holder.Reference<WorldClock> worldClock = level.registryAccess().getOrThrow(WorldClocks.OVERWORLD);
        ServerClockManager clockManager = level.clockManager();
        if ((clockManager.getTotalTicks(worldClock) % 24000 < 13000 || clockManager.getTotalTicks(worldClock) % 24000 > 22500)) {
            player.sendSystemMessage(Component.translatable("message.gufyblocks.insomnia_effect_time"));
            return true;
        }

        spawnPhantoms(level, pos, player);

        // If this returns false when shouldApplyEffectTickThisTick returns true, the effect will immediately be removed
        return true;
    }

    // Whether the effect should apply this tick. Used e.g. by the Regeneration effect that only applies
    // once every x ticks, depending on the tick count and amplifier.
    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        if (spawnImmediately) {
            spawnImmediately = false;
            return true;
        }

        return tickCount % delay == 0;
    }

    // Utility method that is called when the effect is first added to the entity.
    // This does not get called again until all instances of this effect have been removed from the entity.
    @Override
    public void onEffectAdded(LivingEntity entity, int amplifier) {
        super.onEffectAdded(entity, amplifier);
    }

    // Utility method that is called when the effect is added to the entity.
    // This gets called every time this effect is added to the entity.
    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
        spawnImmediately = true;
    }

    private void spawnPhantoms(ServerLevel level, BlockPos position, ServerPlayer player) {
        int numSpawns = level.getRandom().nextInt(1, 4);
        for (int i = 0; i < numSpawns; i++) {
            GufyUtil.execute("summon minecraft:phantom ~ ~20 ~", level, position, player);
        }
    }
}
