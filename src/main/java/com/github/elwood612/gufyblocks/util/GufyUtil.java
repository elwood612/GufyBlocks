package com.github.elwood612.gufyblocks.util;

import com.github.elwood612.gufyblocks.blocks.*;
import com.github.elwood612.gufyblocks.blocks.blockSpecialty.*;
import com.github.elwood612.gufyblocks.blocks.blockUtil.*;
import com.github.elwood612.gufyblocks.blocks.blockWeathering.*;
import net.minecraft.CrashReport;
import net.minecraft.CrashReportCategory;
import net.minecraft.ReportedException;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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
        properties.hasPostProcess = parent.hasPostProcess;
        properties.isSuffocating = parent.isSuffocating;
        properties.isViewBlocking = parent.isViewBlocking;

        return properties;
    }

    public static BlockBehaviour.Properties copyPropertiesOf(Block block){
        BlockBehaviour.Properties tmp = BlockBehaviour.Properties.ofFullCopy(block);
        return copyPropertiesOf(tmp);
    }

    //***********************FAMILY BUILDER***********************//
    public static List<DeferredBlock<Block>> familyBuilder(String name, Block parentBlock, GufyBlockTypes ... blockTypes) {
        return new ArrayList<>() {{
            for (GufyBlockTypes blockType: blockTypes) {
                BlockBehaviour.Properties blockProperties = copyPropertiesOf(parentBlock);
                add(getVariant(name, blockProperties, parentBlock, blockType));
            }
        }};
    }

    public static List<DeferredBlock<Block>> familyBuilder(String name, BlockBehaviour.Properties parentProperties, GufyBlockTypes ... blockTypes) {
        return new ArrayList<>() {{
            for (GufyBlockTypes blockType: blockTypes) {
                BlockBehaviour.Properties blockProperties = copyPropertiesOf(parentProperties);
                add(getVariant(name, blockProperties, getStairParent(name), blockType));
            }
        }};
    }

    public static List<DeferredBlock<Block>> weatheringBuilder(String name, Block parentBlock, GufyWeathering.WeatherState state, GufyBlockTypes ... blockTypes) {
        return new ArrayList<>() {{
            for (GufyBlockTypes blockType : blockTypes) {
                BlockBehaviour.Properties blockProperties = copyPropertiesOf(parentBlock);
                add(getWeatheringVariant(name, blockProperties, parentBlock, state, blockType));
            }
        }};
    }

    public static List<DeferredBlock<Block>> pottedFlowerBuilder(String name, Block parentBlock, Item flower, GufyBlockTypes ... blockTypes) {
        return new ArrayList<>() {{
            for (GufyBlockTypes blockType : blockTypes) {
                BlockBehaviour.Properties blockProperties = copyPropertiesOf(parentBlock);
                add(getPottedVariant(name, blockProperties, parentBlock, flower, blockType));
            }
        }};
    }

    //************************GET VARIANT***************************//
    public static DeferredBlock<Block> getVariant(String name, BlockBehaviour.Properties blockProperties, Block parentBlock, GufyBlockTypes blockType)
    {
        return switch (blockType) {
            case BLOCK -> createRegistry(name, () -> new Block(blockProperties), blockProperties);
            case STAIRS -> createRegistry(name + "_stairs", () -> new StairBlock(parentBlock.defaultBlockState(), blockProperties), blockProperties);
            case GUFYSTAIRS -> createRegistry(name + "_stairs", () -> new GufyStairs(parentBlock.defaultBlockState(), blockProperties), blockProperties);
            case SLAB -> createRegistry(name + "_slab", () -> new SlabBlock(blockProperties), blockProperties);
            case GUFYSLAB -> createRegistry(name + "_slab", () -> new GufySlab(blockProperties), blockProperties);
            case VERTICALSLAB -> createRegistry(name + "_verticalslab", () -> new GufyVerticalSlab(blockProperties), blockProperties);
            case WALL -> createRegistry(name + "_wall", () -> new WallBlock(blockProperties), blockProperties);
            case GUFYWALL -> createRegistry(name + "_wall", () -> new GufyWall(blockProperties), blockProperties);
            case HOPPER -> createRegistry(name + "_hopper", () -> new GufyHopper(blockProperties), blockProperties);
            case POST -> createRegistry(name + "_post", () -> new GufyPost(blockProperties), blockProperties);
            case PILLAR -> createRegistry(name + "_pillar", () -> new RotatedPillarBlock(blockProperties), blockProperties);
            case TRAPDOOR -> createRegistry(name + "_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, blockProperties), blockProperties);
            case STONE_TRAPDOOR -> createRegistry(name + "_trapdoor", () -> new GufyTrapdoor(BlockSetType.IRON, blockProperties), blockProperties);
            case WOOL_TRAPDOOR -> createRegistry(name + "_trapdoor", () -> new GufyTrapdoor(BlockSetType.OAK, blockProperties), blockProperties);
            case PANEL -> createRegistry(name + "_panel", () -> new GufyPanel(blockProperties), blockProperties);
            case FENCE -> createRegistry(name + "_fence", () -> new FenceBlock(blockProperties), blockProperties);
            case GUFYFENCE -> createRegistry(name + "_fence", () -> new GufyFence(blockProperties), blockProperties);
            case FENCEGATE -> createRegistry(name + "_fence_gate", () -> new FenceGateBlock(blockProperties, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), blockProperties);
            case PARQUET -> createRegistry(name + "_parquet", () -> new Block(blockProperties), blockProperties);
            case WATTLEFENCE -> createRegistry(name, () -> new GufyWattleFence(blockProperties), blockProperties);
            case WAGONWHEEL -> createRegistry(name, () -> new TrapDoorBlock(BlockSetType.OAK, blockProperties), blockProperties);
            case PANE -> createRegistry(name + "_pane", () -> new IronBarsBlock(blockProperties), blockProperties);
            case CHISELED -> createRegistry("chiseled_" + name, () -> new Block(blockProperties), blockProperties);
            case FRAMED_LEFT -> createRegistry(name + "_left", () -> new Block(blockProperties), blockProperties);
            case FRAMED_RIGHT -> createRegistry(name + "_right", () -> new Block(blockProperties), blockProperties);
            case FRAMED_CROSS -> createRegistry(name + "_cross", () -> new Block(blockProperties), blockProperties);
            case CARVED_LOG -> createRegistry(name, () -> new RotatedPillarBlock(blockProperties), blockProperties);
            case SEAT -> createRegistry(name, () -> new GufySeat(blockProperties), blockProperties);
            default -> null;
        };
    }

    public static DeferredBlock<Block> getWeatheringVariant(String name, BlockBehaviour.Properties blockProperties, Block parentBlock, GufyWeathering.WeatherState state, GufyBlockTypes blockType)
    {
        return switch (blockType) {
            case WEATHERINGSTAIRS -> createRegistry(name + "_stairs", () -> new GufyWeatheringStairs(parentBlock.defaultBlockState(), blockProperties, state), blockProperties);
            case WEATHERINGSLAB -> createRegistry(name + "_slab", () -> new GufyWeatheringSlab(blockProperties, state), blockProperties);
            case WEATHERINGVERTICALSLAB -> createRegistry(name + "_verticalslab", () -> new GufyWeatheringVerticalSlab(blockProperties, state), blockProperties);
            case WEATHERINGWALL -> createRegistry(name + "_wall", () -> new GufyWeatheringWall(blockProperties, state), blockProperties);
            case WEATHERINGHOPPER -> createRegistry(name + "_hopper", () -> new GufyWeatheringHopper(blockProperties, state), blockProperties);
            case WEATHERINGPOST -> createRegistry(name + "_post", () -> new GufyWeatheringPost(blockProperties, state), blockProperties);
            default -> null;
        };
    }

    public static DeferredBlock<Block> getPottedVariant(String name, BlockBehaviour.Properties blockProperties, Block parentBlock, Item flower, GufyBlockTypes blockType)
    {
        return switch (blockType) {
            case FLOWER_BOX -> createRegistry(name, () -> new GufyFlowerBox(flower, blockProperties), blockProperties);
            default -> null;
        };
    }

    //************************GET BLOCKS***************************//
    public static Block getGufyBlock(String name)
    {
        return BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(MODID, name));
    }

    public static Block getStairParent(String name)
    {
        if (BuiltInRegistries.BLOCK.containsKey(Identifier.fromNamespaceAndPath(MODID, name)))
            return BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(MODID, name));
        if (BuiltInRegistries.BLOCK.containsKey(Identifier.fromNamespaceAndPath(MODID, name + "s")))
            return BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(MODID, name + "s"));
        if (BuiltInRegistries.BLOCK.containsKey(Identifier.fromNamespaceAndPath("minecraft", name)))
            return BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath("minecraft", name));
        if (BuiltInRegistries.BLOCK.containsKey(Identifier.fromNamespaceAndPath("minecraft", name + "_block")))
            return BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath("minecraft", name + "_block"));
        if (BuiltInRegistries.BLOCK.containsKey(Identifier.fromNamespaceAndPath("minecraft", name + "_planks")))
            return BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath("minecraft", name + "_planks"));
        if (BuiltInRegistries.BLOCK.containsKey(Identifier.fromNamespaceAndPath("minecraft", name + "s")))
            return BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath("minecraft", name + "s"));

        else return Blocks.OAK_PLANKS;
    }


    //***********************GET MAPPED BLOCKS*********************************//
    public static Optional<BlockState> getWaxedOn(BlockState blockState)
    {
        return Optional.ofNullable(GufyWaxable.WAXABLES.get().get(blockState.getBlock())).map((newBlockState) ->
                newBlockState.withPropertiesOf(blockState));
    }

    public static Optional<BlockState> getWaxedOff(BlockState blockState)
    {
        return Optional.ofNullable(GufyWaxable.WAX_OFF_BY_BLOCK.get().get(blockState.getBlock())).map((newBlockState) ->
                newBlockState.withPropertiesOf(blockState));
    }

    public static Optional<BlockState> getMossy(BlockState blockState)
    {
        return Optional.ofNullable(GufyMossable.MOSSABLES.get().get(blockState.getBlock())).map((newBlockState) ->
                newBlockState.withPropertiesOf(blockState));
    }

    public static Optional<BlockState> getCracked(BlockState blockState)
    {
        return Optional.ofNullable(GufyCrackable.CRACKABLES.get().get(blockState.getBlock())).map((newBlockState) ->
                newBlockState.withPropertiesOf(blockState));
    }

    public static Optional<BlockState> getStripped(BlockState blockState)
    {
        return Optional.ofNullable(GufyStrippable.STRIPPABLES.get().get(blockState.getBlock())).map((newBlockState) ->
                newBlockState.withPropertiesOf(blockState));
    }

    public static Optional<BlockState> getPotted(Item item, BlockState state)
    {
        return Optional.ofNullable(GufyPottable.POTTABLES.get().get(item)).map((newBlockState) ->
                newBlockState.withPropertiesOf(state));
    }

    //***********************IS WAXED*******************************//
    public static boolean isScrapeable(BlockState blockState)
    {
        return GufyWaxable.WAXABLES.get().containsValue(blockState.getBlock());
    }

    public static boolean isStrippable(BlockState blockState)
    {
        return GufyStrippable.STRIPPABLES.get().containsKey(blockState.getBlock());
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
                    CommandSource.NULL, Vec3.atCenterOf(pos), Vec2.ZERO, level, LevelBasedPermissionSet.OWNER, name.getString(), name, minecraftserver, castingPlayer);
            minecraftserver.getCommands().performPrefixedCommand(commandsourcestack, command);
        } catch (Throwable throwable) {
            CrashReport crashreport = CrashReport.forThrowable(throwable, "Executing command block");
            CrashReportCategory crashreportcategory = crashreport.addCategory("Command to be executed");
            crashreportcategory.setDetail("Command", () -> command);
            crashreportcategory.setDetail("Name", name::getString);
            throw new ReportedException(crashreport);
        }
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
                    GufyBlockTypes.GUFYSTAIRS,
                    GufyBlockTypes.GUFYSLAB,
                    GufyBlockTypes.VERTICALSLAB,
                    GufyBlockTypes.GUFYWALL,
                    GufyBlockTypes.HOPPER,
                    GufyBlockTypes.POST
            });

            // VANILLA_WAXED_CUT_COPPER_TYPES - 11
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.VERTICALSLAB,
                    GufyBlockTypes.GUFYWALL,
                    GufyBlockTypes.HOPPER,
                    GufyBlockTypes.POST
            });

            // VANILLA_STRIPPABLE_WOOD_TYPES_ALL - 12
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.GUFYSTAIRS,
                    GufyBlockTypes.GUFYSLAB,
                    GufyBlockTypes.VERTICALSLAB,
                    GufyBlockTypes.GUFYWALL,
                    GufyBlockTypes.HOPPER,
                    GufyBlockTypes.GUFYFENCE,
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
        }};
    }
}
