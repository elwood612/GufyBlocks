package com.github.elwood612.gufyblocks.blocks.blockWeathering;

import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyWeathering;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.ItemAbilities;

import javax.annotation.Nullable;

public class GufyWeatheringBlock extends Block implements GufyWeathering
{
    private final GufyWeathering.WeatherState weatherState;

    public GufyWeatheringBlock(BlockBehaviour.Properties properties, GufyWeathering.WeatherState state) {
        super(properties);
        this.weatherState = state;
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility toolAction, boolean simulate)
    {
        ItemStack itemStack = context.getItemInHand();
        if (!itemStack.canPerformAction(toolAction)) return null;
        if (ItemAbilities.AXE_SCRAPE.equals(toolAction)) return GufyWeathering.getPrevious(state).orElse(null);
        return null;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult)
    {
        Item handheldItem = player.getItemInHand(hand).getItem();
        if (Items.HONEYCOMB.equals(handheldItem)) {
            return GufyUtil.getWaxedOn(state).map((newBlockState) ->
            {
                ItemStack itemStack = player.getItemInHand(hand);
                if (player instanceof ServerPlayer)
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, pos, itemStack);
                if (!player.isCreative())
                    itemStack.shrink(1);
                level.setBlock(pos, newBlockState, 11);
                level.levelEvent(player, 3003, pos, 0);
                //    return ItemInteractionResult.sidedSuccess(level.isClientSide);
                return InteractionResult.SUCCESS;
            }).orElse(InteractionResult.CONSUME);
        } else
            return InteractionResult.PASS;
    }


    @Override
    public void randomTick(BlockState p_154929_, ServerLevel p_154930_, BlockPos p_154931_, RandomSource p_154932_) {
        this.changeOverTime(p_154929_, p_154930_, p_154931_, p_154932_);
    }

    public boolean isRandomlyTicking(BlockState p_154935_) {
        return GufyWeathering.getNext(p_154935_.getBlock()).isPresent();
    }

    public WeatheringCopper.WeatherState getAge() {
        switch (this.weatherState) {
            case UNAFFECTED:
                return WeatheringCopper.WeatherState.UNAFFECTED;
            case EXPOSED:
                return WeatheringCopper.WeatherState.EXPOSED;
            case WEATHERED:
                return WeatheringCopper.WeatherState.WEATHERED;
            case OXIDIZED:
                return WeatheringCopper.WeatherState.OXIDIZED;
            default:
                return WeatheringCopper.WeatherState.UNAFFECTED;
        }
    }
}
