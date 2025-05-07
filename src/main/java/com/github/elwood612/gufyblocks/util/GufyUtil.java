package com.github.elwood612.gufyblocks.util;

import com.github.elwood612.gufyblocks.GufyRegistry;
import com.github.elwood612.gufyblocks.blocks.*;
import com.github.elwood612.gufyblocks.blocks.blockSpecialty.*;
import com.github.elwood612.gufyblocks.blocks.blockUtil.*;
import com.github.elwood612.gufyblocks.blocks.blockWeathering.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.github.elwood612.gufyblocks.GufyBlocks.MODID;

public class GufyUtil
{

    //*******************PROPERTIES BUILDER**************************//
    public static BlockBehaviour.Properties propertiesBuilder(GufyMaterials block)
    {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties
                .of()
                .mapColor(block.color)
                .strength(block.hardness, block.resistance)
                .sound(block.sound);
        if (block.tool) properties = properties.requiresCorrectToolForDrops();
        if (!block.occlusion) properties = properties.noOcclusion();

        return properties;
    }


    //***********************FAMILY BUILDER***********************//
    public static List<DeferredBlock<Block>> familyBuilder(String name, GufyMaterials properties, GufyBlockTypes ... blockTypes)
    {
        return new ArrayList<>()
        {{
            for (GufyBlockTypes blockType: blockTypes)
            {
                BlockBehaviour.Properties blockProperties = propertiesBuilder(properties);
                switch (blockType)
                {
                    case BLOCK -> add(GufyRegistry.createRegistry(name, () -> new Block(blockProperties), blockProperties));
                    case STAIRS -> add(GufyRegistry.createRegistry(name + "_stairs", () -> new StairBlock(getGufyBlock(name).defaultBlockState(), blockProperties), blockProperties));
                    case GUFYSTAIRS -> add(GufyRegistry.createRegistry(name + "_stairs", () -> new GufyStairs(getGufyBlock(name).defaultBlockState(), blockProperties), blockProperties));
                    case ICE_STAIRS -> add(GufyRegistry.createRegistry(name + "_stairs", () -> new StairBlock(getGufyBlock(name).defaultBlockState(), blockProperties.friction(0.98f)), blockProperties.friction(0.98f)));
                    case SLAB -> add(GufyRegistry.createRegistry(name + "_slab", () -> new SlabBlock(blockProperties), blockProperties));
                    case ICE_SLAB -> add(GufyRegistry.createRegistry(name + "_slab", () -> new SlabBlock(blockProperties.friction(0.98f)), blockProperties.friction(0.98f)));
                    case GUFYSLAB -> add(GufyRegistry.createRegistry(name + "_slab", () -> new GufySlab(blockProperties), blockProperties));
                    case VERTICALSLAB -> add(GufyRegistry.createRegistry(name + "_verticalslab", () -> new GufyVerticalSlab(blockProperties), blockProperties));
                    case ICE_VERTICALSLAB -> add(GufyRegistry.createRegistry(name + "_verticalslab", () -> new GufyVerticalSlab(blockProperties.friction(0.98f)), blockProperties.friction(0.98f)));
                    case WALL -> add(GufyRegistry.createRegistry(name + "_wall", () -> new WallBlock(blockProperties), blockProperties));
                    case GUFYWALL -> add(GufyRegistry.createRegistry(name + "_wall", () -> new GufyWall(blockProperties), blockProperties));
                    case HOPPER -> add(GufyRegistry.createRegistry(name + "_hopper", () -> new GufyHopper(blockProperties), blockProperties));
                    case POST -> add(GufyRegistry.createRegistry(name + "_post", () -> new GufyPost(blockProperties), blockProperties));
                    case PILLAR -> add(GufyRegistry.createRegistry(name + "_pillar", () -> new RotatedPillarBlock(blockProperties), blockProperties));
                    case STONE_TRAPDOOR -> add(GufyRegistry.createRegistry(name + "_trapdoor", () -> new TrapDoorBlock(BlockSetType.IRON, blockProperties), blockProperties));
                    case TRAPDOOR -> add(GufyRegistry.createRegistry(name + "_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, blockProperties), blockProperties));
                    case WOOL_TRAPDOOR -> add(GufyRegistry.createRegistry(name + "_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, blockProperties.sound(SoundType.WOOL)), blockProperties.sound(SoundType.WOOL)));
                    case PANEL -> add(GufyRegistry.createRegistry(name + "_panel", () -> new GufyPanel(blockProperties), blockProperties));
                    case FENCE -> add(GufyRegistry.createRegistry(name + "_fence", () -> new FenceBlock(blockProperties), blockProperties));
                    case GUFYFENCE -> add(GufyRegistry.createRegistry(name + "_fence", () -> new GufyFence(blockProperties), blockProperties));
                    case FENCEGATE -> add(GufyRegistry.createRegistry(name + "_fence_gate", () -> new FenceGateBlock(blockProperties, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), blockProperties));
                    case PARQUET -> add(GufyRegistry.createRegistry(name + "_parquet", () -> new Block(blockProperties), blockProperties));
                    case WATTLEFENCE -> add(GufyRegistry.createRegistry(name, () -> new GufyWattleFence(blockProperties), blockProperties));
                    case WAGONWHEEL -> add(GufyRegistry.createRegistry(name, () -> new TrapDoorBlock(BlockSetType.OAK, blockProperties), blockProperties));
                    case PANE -> add(GufyRegistry.createRegistry(name + "_pane", () -> new GufyPane(blockProperties), blockProperties));
                    case CHISELED -> add(GufyRegistry.createRegistry("chiseled_" + name, () -> new Block(blockProperties), blockProperties));
                    case FRAMED_LEFT -> add(GufyRegistry.createRegistry(name + "_left", () -> new Block(blockProperties), blockProperties));
                    case FRAMED_RIGHT -> add(GufyRegistry.createRegistry(name + "_right", () -> new Block(blockProperties), blockProperties));
                    case FRAMED_CROSS -> add(GufyRegistry.createRegistry(name + "_cross", () -> new Block(blockProperties), blockProperties));
                    case CARVED_LOG -> add(GufyRegistry.createRegistry(name, () -> new RotatedPillarBlock(blockProperties), blockProperties));
                    case SEAT -> add(GufyRegistry.createRegistry(name, () -> new GufySeat(blockProperties.pushReaction(PushReaction.DESTROY)), blockProperties));
                }
            }
        }};
    }

    //********************FAMILY COPPER BUILDER********************//
    public static List<DeferredBlock<Block>> familyBuilder(String name, GufyMaterials properties, GufyWeathering.WeatherState state, GufyBlockTypes ... blockTypes)
    {
        return new ArrayList<>()
        {{
            for (GufyBlockTypes blockType : blockTypes)
            {
                BlockBehaviour.Properties blockProperties = propertiesBuilder(properties);
                switch (blockType)
                {
                    case WEATHERINGSTAIRS -> add(GufyRegistry.createRegistry(name + "_stairs", () -> new GufyWeatheringStairs(getGufyBlock(name).defaultBlockState(), blockProperties, state), blockProperties));
                    case WEATHERINGSLAB -> add(GufyRegistry.createRegistry(name + "_slab", () -> new GufyWeatheringSlab(blockProperties, state), blockProperties));
                    case WEATHERINGVERTICALSLAB -> add(GufyRegistry.createRegistry(name + "_verticalslab", () -> new GufyWeatheringVerticalSlab(blockProperties, state), blockProperties));
                    case WEATHERINGWALL -> add(GufyRegistry.createRegistry(name + "_wall", () -> new GufyWeatheringWall(blockProperties, state), blockProperties));
                    case WEATHERINGHOPPER -> add(GufyRegistry.createRegistry(name + "_hopper", () -> new GufyWeatheringHopper(blockProperties, state), blockProperties));
                    case WEATHERINGPOST -> add(GufyRegistry.createRegistry(name + "_post", () -> new GufyWeatheringPost(blockProperties, state), blockProperties));
                }
            }
        }};
    }


    //************************GET BLOCK***************************//
    public static Block getGufyBlock(String name)
    {
        return BuiltInRegistries.BLOCK.getValue(ResourceLocation.fromNamespaceAndPath(MODID, name));
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

    //***********************IS WAXED*******************************//
    public static boolean isScrapeable(BlockState blockState)
    {
        return GufyWaxable.WAXABLES.get().containsValue(blockState.getBlock());
    }

    public static boolean isStrippable(BlockState blockState)
    {
        return GufyStrippable.STRIPPABLES.get().containsKey(blockState.getBlock());
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

            // PACKED_ICE_TYPES - 14
            add(new GufyBlockTypes[] {
                    GufyBlockTypes.ICE_STAIRS,
                    GufyBlockTypes.ICE_SLAB,
                    GufyBlockTypes.ICE_VERTICALSLAB
            });
        }};
    }
}
