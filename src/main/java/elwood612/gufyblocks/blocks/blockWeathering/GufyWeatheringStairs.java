package elwood612.gufyblocks.blocks.blockWeathering;

import elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import elwood612.gufyblocks.blocks.blockUtil.GufyWeathering;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Random;

public class GufyWeatheringStairs extends StairBlock implements GufyWeathering
{
    private final GufyWeathering.WeatherState weatherState;

    public GufyWeatheringStairs(GufyMaterials block, String name, GufyWeathering.WeatherState state) {
        super(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("gufyblocks", name))::defaultBlockState,
                GufyUtil.builder(block));
        this.weatherState = state;
        setRegistryName(name);
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, Level world, BlockPos pos, Player player, ItemStack stack, ToolAction toolAction)
    {
        if (!stack.canPerformAction(toolAction)) return null;
        if (ToolActions.AXE_SCRAPE.equals(toolAction)) return GufyWeathering.getPrevious(state).orElse(null);
        return null;
    }

    @NotNull
    @Override
    public InteractionResult use(BlockState blockState, Level world, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult)
    {
        Item handheldItem = player.getItemInHand(hand).getItem();
        if (Items.HONEYCOMB.equals(handheldItem)) {
            return GufyUtil.getWaxedOn(blockState).map((newBlockState) -> {
                ItemStack itemStack = player.getItemInHand(hand);
                if (!world.isClientSide)
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockPos, itemStack);
                if (!player.isCreative())
                    itemStack.shrink(1);
                world.setBlock(blockPos, newBlockState, 11);
                world.playSound(null, blockPos, SoundEvents.HONEYCOMB_WAX_ON, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.levelEvent(player, 3003, blockPos, 0);
                if (world.isClientSide)
                    ParticleUtils.spawnParticlesOnBlockFaces(world, blockPos, ParticleTypes.WAX_OFF, UniformInt.of(3, 5));
                return InteractionResult.sidedSuccess(world.isClientSide);
            }).orElse(InteractionResult.CONSUME);
        } else
            return InteractionResult.PASS;
    }

    public void randomTick(BlockState p_154929_, ServerLevel p_154930_, BlockPos p_154931_, Random p_154932_) {
        this.onRandomTick(p_154929_, p_154930_, p_154931_, p_154932_);
    }

    public boolean isRandomlyTicking(BlockState state) {
        return GufyWeathering.getNext(state.getBlock()).isPresent();
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
