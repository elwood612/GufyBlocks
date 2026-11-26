package com.github.elwood612.gufyblocks.events;

import com.github.elwood612.gufyblocks.GufyBlocks;
import com.github.elwood612.gufyblocks.GufyRegistry;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.npc.wanderingtrader.WanderingTrader;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.TradeWithVillagerEvent;

@EventBusSubscriber(modid = GufyBlocks.MODID)
public class GufyTradeEvent {
    @SubscribeEvent
    public static void onTrade(TradeWithVillagerEvent event) {
        if (event.getAbstractVillager() instanceof WanderingTrader && event.getMerchantOffer().getCostA().is(GufyRegistry.STILLSTONE)) {
            if (event.getEntity() instanceof ServerPlayer player) {
                GufyUtil.awardAdvancement(player.level(), player, "trade_coin");
            }
        }
    }
}
