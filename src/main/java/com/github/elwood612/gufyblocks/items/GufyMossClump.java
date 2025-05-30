package com.github.elwood612.gufyblocks.items;

import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class GufyMossClump extends Item
{
    public GufyMossClump(Item.Properties properties) { super(properties); }

    @NotNull
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        Optional<BlockState> optional = GufyUtil.getMossy(blockstate);

        if (optional.isEmpty()) {
            return InteractionResult.PASS;
        } else {
            Player player = context.getPlayer();
            ItemStack itemstack = context.getItemInHand();
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockpos, itemstack);
                itemstack.shrink(1);
            }
            level.setBlock(blockpos, (BlockState)optional.get(), 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, (BlockState)optional.get()));
            level.playSound(player, blockpos, SoundEvents.MOSS_BREAK, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
            if (level.isClientSide)
                ParticleUtils.spawnParticlesOnBlockFaces(level, blockpos, ParticleTypes.COMPOSTER, UniformInt.of(3, 5));

            return InteractionResult.SUCCESS;
        }
    }
}
