package com.github.elwood612.gufyblocks.items;

import com.github.elwood612.gufyblocks.items.itemUtil.AtlasClient;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.neoforged.fml.ModList;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class GufyAtlas extends Item
{
    private static boolean isXaeroLoaded;

    public GufyAtlas(Item.Properties properties) {
        super(properties);
        isXaeroLoaded = ModList.get().isLoaded("xaeroworldmap");
    }

    @NotNull
    @Override
    public InteractionResult use(Level level, Player player, @NotNull InteractionHand handIn) {
        if (!isXaeroLoaded) {
            player.sendSystemMessage(Component.translatable("message.gufyblocks.atlas_no_xaero"));
            return InteractionResult.CONSUME;
        }

        if (level.isClientSide()) AtlasClient.openMap();

        level.playSound((Player) null, player.blockPosition(), SoundEvents.BOOK_PAGE_TURN, SoundSource.NEUTRAL, 1f, 1f);

        if (!player.getAbilities().instabuild && level instanceof ServerLevel serverLevel && player instanceof ServerPlayer serverPlayer) {
            GufyUtil.awardAdvancement(serverLevel, serverPlayer, "use_atlas");
        }

        return InteractionResult.SUCCESS;
    }
}
