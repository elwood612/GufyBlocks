package com.github.elwood612.gufyblocks.items;

import com.github.elwood612.gufyblocks.GufyRegistry;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Optional;

public class GufyBiomeSeed extends Item
{
    public GufyBiomeSeed(Item.Properties properties) { super(properties); }

    @NotNull
    @Override
//    public InteractionResult use(Level level, Player player, @NotNull InteractionHand handIn) {
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        InteractionHand handIn = context.getHand();
        ItemStack itemstack = player.getItemInHand(handIn);
        Level level = context.getLevel();
        BlockPos position = context.getClickedPos();
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer && level instanceof ServerLevel serverLevel) {
            Holder<Biome> biomeHolder = level.getBiome(player.blockPosition());
            Identifier biomeID = biomeHolder.unwrapKey().get().identifier();

            player.swing(handIn, true);

            if (level.dimension() != Level.OVERWORLD) {
                serverPlayer.sendSystemMessage(Component.translatable("message.gufyblocks.weather_dimension"));
                level.playSound((Player) null, position, SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 0.5f, 0.4f);
                return InteractionResult.FAIL;
            }

            if (!itemstack.has(GufyRegistry.STORED_BIOME.get())){
                if (itemstack.getCount() > 1) {
                    ItemStack single = itemstack.split(1);
                    single.set(GufyRegistry.STORED_BIOME.get(), biomeID);
                    if (!player.getInventory().add(single)) {
                        player.drop(single, false);
                    }
                } else {
                    itemstack.set(GufyRegistry.STORED_BIOME.get(), biomeID);
                }
                serverLevel.sendParticles(
                        ParticleTypes.COMPOSTER,
                        position.getX(), position.getY() + 1, position.getZ(),
                        10,          // count
                        0.3, 0.3, 0.3, // spread
                        0.02         // speed
                );

//                ParticleUtils.spawnParticlesOnBlockFaces(level, position, ParticleTypes.POOF, UniformInt.of(3, 5));

                level.playSound((Player) null, position, SoundEvents.ALLAY_ITEM_GIVEN, SoundSource.NEUTRAL, 0.6f, 0.8f);
                level.playSound((Player) null, position, SoundEvents.COMPOSTER_READY, SoundSource.NEUTRAL, 1f, 0.8f);
                return InteractionResult.SUCCESS;
            } else {
                if (Objects.equals(itemstack.get(GufyRegistry.STORED_BIOME.get()), biomeID) && !player.isShiftKeyDown()) {
                    serverPlayer.sendSystemMessage(Component.translatable("message.gufyblocks.biome_same"));
                    level.playSound((Player) null, position, SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 0.5f, 0.4f);
                    return InteractionResult.FAIL;
                }

                int r = 8;
                Identifier newBiome = itemstack.get(GufyRegistry.STORED_BIOME.get());
                if (newBiome == null) { return InteractionResult.FAIL; }

                BlockPos from = position.offset(-r, -r, -r);
                BlockPos to   = position.offset(r, r, r);
                String command = String.format(
                        "fillbiome %d %d %d %d %d %d %s",
                        from.getX(), from.getY(), from.getZ(),
                        to.getX(), to.getY(), to.getZ(),
                        newBiome.toString()
                );

                GufyUtil.execute(command, serverLevel, position, serverPlayer);

                serverLevel.sendParticles(
                        ParticleTypes.COMPOSTER,
                        player.getX(), player.getY() + 1, player.getZ(),
                        10,          // count
                        0.3, 0.3, 0.3, // spread
                        0.2         // speed
                );
                serverLevel.sendParticles(
                        ParticleTypes.HAPPY_VILLAGER,
                        player.getX(), player.getY() + 1, player.getZ(),
                        40,
                        0.8, 0.5, 0.8,
                        0.1
                );
                serverLevel.sendParticles(
                        ParticleTypes.END_ROD,
                        player.getX(), player.getY() + 1, player.getZ(),
                        10,
                        0.6, 0.6, 0.6,
                        0.05
                );

                level.playSound((Player) null, position, SoundEvents.ALLAY_AMBIENT_WITHOUT_ITEM, SoundSource.NEUTRAL, 0.6f, 0.4f);
                level.playSound((Player) null, position, SoundEvents.COMPOSTER_FILL_SUCCESS, SoundSource.NEUTRAL, 1f, 0.8f);

                if (!player.getAbilities().instabuild) {
                    itemstack.consume(1, player);
                }
            }

            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.FAIL;
        }
    }

    @NotNull
    @Override
    public Component getName(ItemStack stack) {
        if (stack.has(GufyRegistry.STORED_BIOME.get())) {
            Identifier biomeID = stack.get(GufyRegistry.STORED_BIOME.get());
            if (biomeID == null) { return super.getName(stack); }
            String biomeKey = "biome." + biomeID.getNamespace() + "." + biomeID.getPath();
            return Component.translatable(biomeKey).copy().append(Component.translatable("tooltip.gufyblocks.biome_seed_title")).withStyle(ChatFormatting.AQUA);
        } else {
            return super.getName(stack);
        }
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return stack.has(GufyRegistry.STORED_BIOME.get());
    }
}
