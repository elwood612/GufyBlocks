package com.github.elwood612.gufyblocks.items;

import com.github.elwood612.gufyblocks.blocks.GufyVerticalConnectedBlock;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class GufyHammer extends Item
{
    public GufyHammer(Item.Properties properties) { super(properties); }

    @NotNull
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        Optional<BlockState> crackedVersion = GufyUtil.getCracked(blockstate);

        if (playerHasShieldUseIntent(context)) {
            return InteractionResult.PASS;
        }
        else {
            if (crackedVersion.isEmpty()) {
                return InteractionResult.PASS;
            } else {
                Player player = context.getPlayer();
                ItemStack itemstack = context.getItemInHand();
                SoundType soundType = blockstate.getSoundType(level, blockpos, player);
                SoundEvent soundEvent = soundType.getBreakSound();

                if (player instanceof ServerPlayer serverPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, blockpos, itemstack);
                    itemstack.hurtAndBreak(1, player, context.getHand().asEquipmentSlot());
                    if (level instanceof ServerLevel serverLevel) {
                        if (crackedVersion.get().getBlock() instanceof GufyVerticalConnectedBlock) {
                            GufyUtil.awardAdvancement(serverLevel, serverPlayer, "change_framed");
                        }
                        else {
                            GufyUtil.awardAdvancement(serverLevel, serverPlayer, "make_cracked");
                        }
                    }
                }
                level.setBlock(blockpos, (BlockState)crackedVersion.get(), 11);
                level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, (BlockState)crackedVersion.get()));
                level.playSound(player, blockpos, soundEvent, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
                level.levelEvent(player, 2001, blockpos, Block.BLOCK_STATE_REGISTRY.getId(blockstate));

                return InteractionResult.SUCCESS;
            }
        }
    }

    private static boolean playerHasShieldUseIntent(UseOnContext context) {
        Player player = context.getPlayer();
        return context.getHand().equals(InteractionHand.MAIN_HAND) && player.getOffhandItem().is(Items.SHIELD) && !player.isSecondaryUseActive();
    }

//    @Override
//    public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
//        return false;
//    }
}
