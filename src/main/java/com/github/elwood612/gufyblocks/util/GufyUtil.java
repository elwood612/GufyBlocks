package com.github.elwood612.gufyblocks.util;

import com.github.elwood612.gufyblocks.GufyRegistry;
import com.github.elwood612.gufyblocks.blocks.*;
import com.github.elwood612.gufyblocks.blocks.blockUtil.*;
import com.github.elwood612.gufyblocks.blocks.GufyWeatheringHopper;
import com.github.elwood612.gufyblocks.blocks.GufyWeatheringPost;
import com.github.elwood612.gufyblocks.blocks.GufyWeatheringVerticalSlab;
import com.github.elwood612.gufyblocks.blocks.GufyWeatheringWall;
import net.minecraft.CrashReport;
import net.minecraft.CrashReportCategory;
import net.minecraft.ReportedException;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static com.github.elwood612.gufyblocks.GufyBlocks.MODID;
import static com.github.elwood612.gufyblocks.GufyRegistry.createRegistry;

public class GufyUtil
{

    //*******************PROPERTIES BUILDER**************************//
    public static BlockBehaviour.Properties copyPropertiesOf(BlockBehaviour.Properties parent){
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of();

        properties.destroyTime = parent.destroyTime;
        properties.explosionResistance = parent.explosionResistance;
        properties.hasCollision = parent.hasCollision;
        properties.isRandomlyTicking = parent.isRandomlyTicking;
        properties.lightEmission = parent.lightEmission;
        properties.mapColor = parent.mapColor;
        properties.soundType = parent.soundType;
        properties.friction = parent.friction;
        properties.speedFactor = parent.speedFactor;
        properties.dynamicShape = parent.dynamicShape;
        properties.canOcclude = parent.canOcclude;
        properties.isAir = parent.isAir;
        properties.ignitedByLava = parent.ignitedByLava;
        properties.forceSolidOn = parent.forceSolidOn;
        properties.pushReaction = parent.pushReaction;
        properties.requiresCorrectToolForDrops = parent.requiresCorrectToolForDrops;
        properties.spawnTerrainParticles = parent.spawnTerrainParticles;
        properties.emissiveRendering = parent.emissiveRendering;
        properties.instrument = parent.instrument;
        properties.replaceable = parent.replaceable;
        properties.jumpFactor = parent.jumpFactor;
        properties.isRedstoneConductor = parent.isRedstoneConductor;
        properties.isValidSpawn = parent.isValidSpawn;
        properties.isSuffocating = parent.isSuffocating;
        properties.isViewBlocking = parent.isViewBlocking;

        return properties;
    }

    public static BlockBehaviour.Properties copyPropertiesOf(Block block){
        BlockBehaviour.Properties tmp = BlockBehaviour.Properties.ofFullCopy(block);
        return copyPropertiesOf(tmp);
    }

    //************************GET VARIANT***************************//
    public static DeferredBlock<Block> getVariant(
            String name,
            BlockBehaviour.Properties blockProperties,
            Block parentBlock,
            GufyBlockTypes blockType,
            ResourceKey<ContextIntProvider> compostableBlock,
            ResourceKey<ContextIntProvider> furnaceFuelBlock)
    {
        ResourceKey<ContextIntProvider> furnaceFuelSlab = null;
        if (furnaceFuelBlock == ContextIntProviders.COOKING_TIME_WOOD_BLOCKS) furnaceFuelSlab = ContextIntProviders.COOKING_TIME_WOOD_SLABS;
        if (furnaceFuelBlock == ContextIntProviders.COOKING_TIME_WOOL) furnaceFuelSlab = ContextIntProviders.COOKING_TIME_WOOL_SLABS;

        ResourceKey<ContextIntProvider> compostableSlab = null;
        if (compostableBlock == ContextIntProviders.COMPOSTABLE_MEDIUM) compostableSlab = ContextIntProviders.COMPOSTABLE_LOW_MEDIUM;
        if (compostableBlock == ContextIntProviders.COMPOSTABLE_MEDIUM_HIGH) compostableSlab = ContextIntProviders.COMPOSTABLE_MEDIUM;
        if (compostableBlock == ContextIntProviders.COMPOSTABLE_ALWAYS_ADD_ONE) compostableSlab = ContextIntProviders.COMPOSTABLE_MEDIUM_HIGH;

        return switch (blockType) {
            case BLOCK -> createRegistry(name, () -> new Block(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case STAIRS -> createRegistry(name + "_stairs", () -> new StairBlock(parentBlock.defaultBlockState(), blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case SLAB -> createRegistry(name + "_slab", () -> new SlabBlock(blockProperties), blockProperties, compostableSlab, furnaceFuelSlab);
            case VERTICALSLAB -> createRegistry(name + "_verticalslab", () -> new GufyVerticalSlab(blockProperties), blockProperties, compostableSlab, furnaceFuelSlab);
            case WALL -> createRegistry(name + "_wall", () -> new WallBlock(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case HOPPER -> createRegistry(name + "_hopper", () -> new GufyHopper(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case POST -> createRegistry(name + "_post", () -> new GufyPost(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case PILLAR -> createRegistry(name + "_pillar", () -> new RotatedPillarBlock(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case TRAPDOOR -> createRegistry(name + "_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case STONE_TRAPDOOR -> createRegistry(name + "_trapdoor", () -> new GufyTrapdoor(BlockSetType.IRON, blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case WOOL_TRAPDOOR -> createRegistry(name + "_trapdoor", () -> new GufyTrapdoor(BlockSetType.OAK, blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case PANEL -> createRegistry(name + "_panel", () -> new GufyPanel(blockProperties), blockProperties, compostableSlab, furnaceFuelSlab);
            case FENCE -> createRegistry(name + "_fence", () -> new FenceBlock(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case FENCEGATE -> createRegistry(name + "_fence_gate", () -> new FenceGateBlock(blockProperties, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), blockProperties, compostableBlock, furnaceFuelBlock);
            case PARQUET -> createRegistry(name + "_parquet", () -> new Block(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case WATTLEFENCE -> createRegistry(name, () -> new GufyWattleFence(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case WAGONWHEEL -> createRegistry(name, () -> new TrapDoorBlock(BlockSetType.OAK, blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case PANE -> createRegistry(name + "_pane", () -> new IronBarsBlock(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case CHISELED -> createRegistry("chiseled_" + name, () -> new Block(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case FRAMED_LEFT -> createRegistry(name + "_left", () -> new Block(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case FRAMED_RIGHT -> createRegistry(name + "_right", () -> new Block(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case FRAMED_CROSS -> createRegistry(name + "_cross", () -> new Block(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case CARVED_LOG -> createRegistry(name, () -> new RotatedPillarBlock(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case SEAT -> createRegistry(name, () -> new GufySeat(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case VERTICAL_CONNECTED_BLOCK -> createRegistry(name, () -> new GufyVerticalConnectedBlock(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case VERTICAL_CONNECTED_LEFT -> createRegistry(name + "_left", () -> new GufyVerticalConnectedBlock(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case VERTICAL_CONNECTED_RIGHT -> createRegistry(name + "_right", () -> new GufyVerticalConnectedBlock(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            case VERTICAL_CONNECTED_CROSS -> createRegistry(name + "_cross", () -> new GufyVerticalConnectedBlock(blockProperties), blockProperties, compostableBlock, furnaceFuelBlock);
            default -> null;
        };
    }

    public static DeferredBlock<Block> getWeatheringVariant(
            String name,
            BlockBehaviour.Properties blockProperties,
            Block parentBlock,
            WeatheringCopper.WeatherState state,
            GufyBlockTypes blockType)
    {
        return switch (blockType) {
            case WEATHERINGSTAIRS -> createRegistry(name + "_stairs", () -> new WeatheringCopperStairBlock(state, parentBlock.defaultBlockState(), blockProperties), blockProperties, null, null);
            case WEATHERINGSLAB -> createRegistry(name + "_slab", () -> new WeatheringCopperSlabBlock(state, blockProperties), blockProperties, null, null);
            case WEATHERINGVERTICALSLAB -> createRegistry(name + "_verticalslab", () -> new GufyWeatheringVerticalSlab(state, blockProperties), blockProperties, null, null);
            case WEATHERINGWALL -> createRegistry(name + "_wall", () -> new GufyWeatheringWall(state, blockProperties), blockProperties, null, null);
            case WEATHERINGHOPPER -> createRegistry(name + "_hopper", () -> new GufyWeatheringHopper(state, blockProperties), blockProperties, null, null);
            case WEATHERINGPOST -> createRegistry(name + "_post", () -> new GufyWeatheringPost(state, blockProperties), blockProperties, null, null);
            default -> null;
        };
    }

    public static DeferredBlock<Block> getPottedVariant(
            String name,
            BlockBehaviour.Properties blockProperties,
            Block parentBlock,
            Item flower,
            GufyBlockTypes blockType)
    {
        return switch (blockType) {
            case FLOWER_BOX -> createRegistry(name, () -> new GufyFlowerBox(flower, blockProperties), blockProperties, null, null);
            default -> null;
        };
    }

    //************************BLOCK UTIL***************************//
    public static Block getGufyBlock(String name) {
        return BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(MODID, name));
    }

    public static Item getGufyItem(String name) {
        return BuiltInRegistries.ITEM.getValue(Identifier.fromNamespaceAndPath(MODID, name));
    }


    //***********************GET MAPPED BLOCKS*********************************//
    public static Optional<BlockState> getMossy(BlockState blockState) {
        return Optional.ofNullable(GufyMossable.MOSSABLES.get().get(blockState.getBlock())).map((newBlockState) ->
                newBlockState.withPropertiesOf(blockState));
    }

    public static Optional<BlockState> getCracked(BlockState blockState) {
        return Optional.ofNullable(GufyCrackable.CRACKABLES.get().get(blockState.getBlock())).map((newBlockState) ->
                newBlockState.withPropertiesOf(blockState));
    }

    public static Optional<BlockState> getPotted(Item item, BlockState state) {
        return Optional.ofNullable(GufyPottable.POTTABLES.get().get(item)).map((newBlockState) ->
                newBlockState.withPropertiesOf(state));
    }


    //***********************GET LEVEL FROM ACCCESSOR*******************************//
    public static Level getWorldIfInstanceOfAndNotRemote(LevelAccessor levelAccessor) {
        if (levelAccessor.isClientSide()) {
            return null;
        }
        if (levelAccessor instanceof Level) {
            return ((Level)levelAccessor);
        }
        return null;
    }

    //***********************PLAYER UTIL*******************************//
    @Nullable
    public static Player getPlayerEntityByName(Level level, String name) {
        return level.players().stream().filter(player -> player.getName().getString().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public static void execute(String command, ServerLevel level, BlockPos pos, Player castingPlayer) {
        MinecraftServer minecraftserver = level.getServer();
        var name = Component.literal("@");
        try {
            CommandSourceStack commandsourcestack = new CommandSourceStack(
                    CommandSource.NULL, Vec3.atCenterOf(pos), Vec2.ZERO, level, LevelBasedPermissionSet.OWNER, minecraftserver, castingPlayer);
            minecraftserver.getCommands().performPrefixedCommand(commandsourcestack, command);
        } catch (Throwable throwable) {
            CrashReport crashreport = CrashReport.forThrowable(throwable, "Executing command block");
            CrashReportCategory crashreportcategory = crashreport.addCategory("Command to be executed");
            crashreportcategory.setDetail("Command", () -> command);
            crashreportcategory.setDetail("Name", name::getString);
            throw new ReportedException(crashreport);
        }
    }

    public static boolean hasTotemOfKeeping(Player player) {
        ItemStack main = player.getMainHandItem();
        ItemStack off = player.getOffhandItem();
        return main.getItem() == GufyRegistry.TOTEM_KEEPING.get() || off.getItem() == GufyRegistry.TOTEM_KEEPING.get();
    }

    public static void consumeTotem(Player player) {
        ItemStack main = player.getMainHandItem();
        ItemStack off = player.getOffhandItem();

        if (main.getItem() == GufyRegistry.TOTEM_KEEPING.get()) {
            main.shrink(1);
        } else if (off.getItem() == GufyRegistry.TOTEM_KEEPING.get()) {
            off.shrink(1);
        }
        if (!(player.level() instanceof ServerLevel level)) return;
        level.broadcastEntityEvent(player, (byte)35);
        level.playSound(null, player.blockPosition(), SoundEvents.TOTEM_USE, SoundSource.PLAYERS);
    }

    //*******************BLOCKTYPES BUILDER**************************//
    public static List<GufyBlockTypes[]> blocktypeBuilder()
    {
        return new ArrayList<>()
        {{
            // GUFY_STONE_TYPES - 0
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.BLOCK,
                    GufyBlockTypes.STAIRS,
                    GufyBlockTypes.SLAB,
                    GufyBlockTypes.VERTICALSLAB,
                    GufyBlockTypes.WALL,
                    GufyBlockTypes.HOPPER,
                    GufyBlockTypes.POST
            });

            // VANILLA_STONE_TYPES - 1
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.VERTICALSLAB,
                    GufyBlockTypes.HOPPER,
                    GufyBlockTypes.POST
            });

            // GUFY_WOOD_TYPES - 2
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.BLOCK,
                    GufyBlockTypes.STAIRS,
                    GufyBlockTypes.SLAB,
                    GufyBlockTypes.VERTICALSLAB,
                    GufyBlockTypes.WALL,
                    GufyBlockTypes.HOPPER,
                    GufyBlockTypes.FENCE,
                    GufyBlockTypes.FENCEGATE,
                    GufyBlockTypes.PANEL
            });

            // VANILLA_WOOD_TYPES - 3
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.VERTICALSLAB,
                    GufyBlockTypes.WALL,
                    GufyBlockTypes.HOPPER,
                    GufyBlockTypes.PANEL
            });

            // GUFY_DIRT_TYPES - 4
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.BLOCK,
                    GufyBlockTypes.STAIRS,
                    GufyBlockTypes.SLAB,
                    GufyBlockTypes.VERTICALSLAB
            });

            // VANILLA_DIRT_TYPES - 5
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.STAIRS,
                    GufyBlockTypes.SLAB,
                    GufyBlockTypes.VERTICALSLAB,
            });

            // VANILLA_STONE_TYPES_ALL - 6
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.STAIRS,
                    GufyBlockTypes.SLAB,
                    GufyBlockTypes.VERTICALSLAB,
                    GufyBlockTypes.WALL,
                    GufyBlockTypes.HOPPER,
                    GufyBlockTypes.POST
            });

            // VANILLA_WOOD_TYPES_ALL - 7
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.STAIRS,
                    GufyBlockTypes.SLAB,
                    GufyBlockTypes.VERTICALSLAB,
                    GufyBlockTypes.WALL,
                    GufyBlockTypes.HOPPER,
                    GufyBlockTypes.FENCE,
                    GufyBlockTypes.FENCEGATE,
                    GufyBlockTypes.PANEL
            });

            // VANILLA_COPPER_TYPES - 8
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.WEATHERINGSTAIRS,
                    GufyBlockTypes.WEATHERINGSLAB,
                    GufyBlockTypes.WEATHERINGVERTICALSLAB,
                    GufyBlockTypes.WEATHERINGWALL,
                    GufyBlockTypes.WEATHERINGHOPPER,
                    GufyBlockTypes.WEATHERINGPOST
            });

            // VANILLA_CUT_COPPER_TYPES - 9
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.WEATHERINGVERTICALSLAB,
                    GufyBlockTypes.WEATHERINGWALL,
                    GufyBlockTypes.WEATHERINGHOPPER,
                    GufyBlockTypes.WEATHERINGPOST
            });

            // VANILLA_WAXED_COPPER_TYPES - 10
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.STAIRS,
                    GufyBlockTypes.SLAB,
                    GufyBlockTypes.VERTICALSLAB,
                    GufyBlockTypes.WALL,
                    GufyBlockTypes.HOPPER,
                    GufyBlockTypes.POST
            });

            // VANILLA_WAXED_CUT_COPPER_TYPES - 11
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.VERTICALSLAB,
                    GufyBlockTypes.WALL,
                    GufyBlockTypes.HOPPER,
                    GufyBlockTypes.POST
            });

            // VANILLA_STRIPPABLE_WOOD_TYPES_ALL - 12
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.STAIRS,
                    GufyBlockTypes.SLAB,
                    GufyBlockTypes.VERTICALSLAB,
                    GufyBlockTypes.WALL,
                    GufyBlockTypes.HOPPER,
                    GufyBlockTypes.FENCE,
                    GufyBlockTypes.FENCEGATE,
                    GufyBlockTypes.PANEL
            });

            // FRAMED_BLOCK_TYPES - 13
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.BLOCK,
                    GufyBlockTypes.FRAMED_LEFT,
                    GufyBlockTypes.FRAMED_RIGHT,
                    GufyBlockTypes.FRAMED_CROSS
            });

            // FRAMED_BLOCK_TYPES - 14
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.VERTICAL_CONNECTED_BLOCK,
                    GufyBlockTypes.VERTICAL_CONNECTED_LEFT,
                    GufyBlockTypes.VERTICAL_CONNECTED_RIGHT,
                    GufyBlockTypes.VERTICAL_CONNECTED_CROSS
            });
        }};
    }
}
