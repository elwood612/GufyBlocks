package com.github.elwood612.gufyblocks.util;

import com.github.elwood612.gufyblocks.GufyRegistry;
import com.github.elwood612.gufyblocks.blocks.*;
import com.github.elwood612.gufyblocks.blocks.blockSpecialty.*;
import com.github.elwood612.gufyblocks.blocks.blockUtil.*;
import com.github.elwood612.gufyblocks.blocks.blockWeathering.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.registries.DeferredBlock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

    //***********************FAMILY BUILDER***********************//
    public static List<DeferredBlock<Block>> familyBuilder(String name, GufyMaterials properties, GufyBlockTypes ... blockTypes)
    {
        return new ArrayList<>()
        {{
            for (GufyBlockTypes blockType: blockTypes)
            {
                switch (blockType)
                {
                    case BLOCK -> add(GufyRegistry.registerBlock(name, () -> new Block(propertiesBuilder(properties))));
                    case STAIRS -> add(GufyRegistry.registerBlock(name + "_stairs", () -> new StairBlock(getGufyBlock(name).defaultBlockState(), propertiesBuilder(properties))));
                    case GUFYSTAIRS -> add(GufyRegistry.registerBlock(name + "_stairs", () -> new GufyStairs(getGufyBlock(name).defaultBlockState(), propertiesBuilder(properties))));
                    case SLAB -> add(GufyRegistry.registerBlock(name + "_slab", () -> new SlabBlock(propertiesBuilder(properties))));
                    case GUFYSLAB -> add(GufyRegistry.registerBlock(name + "_slab", () -> new GufySlab(propertiesBuilder(properties))));
                    case VERTICALSLAB -> add(GufyRegistry.registerBlock(name + "_verticalslab", () -> new GufyVerticalSlab(propertiesBuilder(properties))));
                    case WALL -> add(GufyRegistry.registerBlock(name + "_wall", () -> new WallBlock(propertiesBuilder(properties))));
                    case GUFYWALL -> add(GufyRegistry.registerBlock(name + "_wall", () -> new GufyWall(propertiesBuilder(properties))));
                    case HOPPER -> add(GufyRegistry.registerBlock(name + "_hopper", () -> new GufyHopper(propertiesBuilder(properties))));
                    case POST -> add(GufyRegistry.registerBlock(name + "_post", () -> new GufyPost(propertiesBuilder(properties))));
                    case PILLAR -> add(GufyRegistry.registerBlock(name + "_pillar", () -> new RotatedPillarBlock(propertiesBuilder(properties))));
                    case STONE_TRAPDOOR -> add(GufyRegistry.registerBlock(name + "_trapdoor", () -> new TrapDoorBlock(BlockSetType.IRON, propertiesBuilder(GufyMaterials.STONE_TRAPDOOR))));
                    case TRAPDOOR -> add(GufyRegistry.registerBlock(name + "_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, propertiesBuilder(properties))));
                    case WOOL_TRAPDOOR -> add(GufyRegistry.registerBlock(name + "_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, propertiesBuilder(properties).sound(SoundType.WOOL))));
                    case PANEL -> add(GufyRegistry.registerBlock(name + "_panel", () -> new GufyPanel(propertiesBuilder(properties))));
                    case FENCE -> add(GufyRegistry.registerBlock(name + "_fence", () -> new FenceBlock(propertiesBuilder(properties))));
                    case GUFYFENCE -> add(GufyRegistry.registerBlock(name + "_fence", () -> new GufyFence(propertiesBuilder(properties))));
                    case FENCEGATE -> add(GufyRegistry.registerBlock(name + "_fence_gate", () -> new FenceGateBlock(propertiesBuilder(properties), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN)));
                    case PARQUET -> add(GufyRegistry.registerBlock(name + "_parquet", () -> new Block(propertiesBuilder(properties))));
                    case WATTLEFENCE -> add(GufyRegistry.registerBlock(name, () -> new GufyWattleFence(propertiesBuilder(properties))));
                    case WAGONWHEEL -> add(GufyRegistry.registerBlock(name, () -> new TrapDoorBlock(BlockSetType.OAK, propertiesBuilder(properties))));
                    case PANE -> add(GufyRegistry.registerBlock(name + "_pane", () -> new GufyPane(propertiesBuilder(properties))));
                    case HORIZONTALBLOCK -> add(GufyRegistry.registerBlock(name, () -> new GufyHorizontalBlock(propertiesBuilder(properties))));
                    case CHISELED -> add(GufyRegistry.registerBlock("chiseled_" + name, () -> new Block(propertiesBuilder(properties))));
                    case FRAMED_LEFT -> add(GufyRegistry.registerBlock(name + "_left", () -> new Block(propertiesBuilder(properties))));
                    case FRAMED_RIGHT -> add(GufyRegistry.registerBlock(name + "_right", () -> new Block(propertiesBuilder(properties))));
                    case FRAMED_CROSS -> add(GufyRegistry.registerBlock(name + "_cross", () -> new Block(propertiesBuilder(properties))));
                    case CARVED_LOG -> add(GufyRegistry.registerBlock(name, () -> new RotatedPillarBlock(propertiesBuilder(properties))));
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
                switch (blockType)
                {
                    case WEATHERINGSTAIRS -> add(GufyRegistry.registerBlock(name + "_stairs", () -> new GufyWeatheringStairs(getGufyBlock(name).defaultBlockState(), propertiesBuilder(properties), state)));
                    case WEATHERINGSLAB -> add(GufyRegistry.registerBlock(name + "_slab", () -> new GufyWeatheringSlab(propertiesBuilder(properties), state)));
                    case WEATHERINGVERTICALSLAB -> add(GufyRegistry.registerBlock(name + "_verticalslab", () -> new GufyWeatheringVerticalSlab(propertiesBuilder(properties), state)));
                    case WEATHERINGWALL -> add(GufyRegistry.registerBlock(name + "_wall", () -> new GufyWeatheringWall(propertiesBuilder(properties), state)));
                    case WEATHERINGHOPPER -> add(GufyRegistry.registerBlock(name + "_hopper", () -> new GufyWeatheringHopper(propertiesBuilder(properties), state)));
                    case WEATHERINGPOST -> add(GufyRegistry.registerBlock(name + "_post", () -> new GufyWeatheringPost(propertiesBuilder(properties), state)));
                }
            }
        }};
    }


    //************************GET BLOCK***************************//
    public static Block getGufyBlock(String name)
    {
//        DeferredBlock<Block> GUFYBLOCK = DeferredBlock.create(new ResourceLocation(GufyBlocks.MODID, name), ForgeRegistries.BLOCKS);
//        DeferredBlock<Block> VANILLABLOCK = RegistryObject.create(new ResourceLocation(name), ForgeRegistries.BLOCKS);
//        DeferredBlock<Block> VANILLABLOCKALT = RegistryObject.create(new ResourceLocation(name + "_block"), ForgeRegistries.BLOCKS);
//        DeferredBlock<Block> DEFAULT = RegistryObject.create(new ResourceLocation("cobblestone"), ForgeRegistries.BLOCKS);
//
//        if (GUFYBLOCK.isPresent()) return GUFYBLOCK;
//        else if (VANILLABLOCK.isPresent()) return VANILLABLOCK;
//        else if (VANILLABLOCKALT.isPresent()) return VANILLABLOCKALT;
//        else return DEFAULT;

// This is what we want!
        return BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("gufyblocks", name));
    }


    //************************IS DOOR******************************//
    public static boolean isDoorBlock(BlockState blockstate)
    {
        Block block = blockstate.getBlock();
        return block instanceof DoorBlock;
    }

    //*********************IS WOODEN DOOR**************************//
    public static boolean isWoodenDoorBlock(BlockState blockstate){
        Block block = blockstate.getBlock();
        if (block instanceof DoorBlock doorblock) {
            return doorblock.type().canOpenByHand();
        }
        return false;
    }

    public static boolean processDoor(Player player, Level world, BlockPos pos, BlockState state, Boolean isopen, Boolean playsound) {
        Block block = state.getBlock();
        if (block instanceof DoorBlock) {
            if (state.getValue(DoorBlock.HALF).equals(DoubleBlockHalf.UPPER)) {
                pos = pos.below().immutable();
                state = world.getBlockState(pos);
            }
        }

        if (isopen == null) {
            isopen = !state.getValue(BlockStateProperties.OPEN);
        }

        int yoffset = 0;
        if (!(block instanceof DoorBlock)) {
            yoffset = 1;
        }

        Iterator<BlockPos> blocksaround = BlockPos.betweenClosedStream(pos.getX()-1, pos.getY()-1, pos.getZ()-1, pos.getX()+1, pos.getY()+yoffset, pos.getZ()+1).iterator();
        while (blocksaround.hasNext()) {
            BlockPos bpa = blocksaround.next();
            if (bpa.equals(pos)) {
                continue;
            }
            BlockState ostate = world.getBlockState(bpa);
            Block oblock = ostate.getBlock();
            if (GufyUtil.isDoorBlock(ostate)) {
                if (oblock.getName().equals(block.getName())) {
                    if (oblock instanceof DoorBlock) {

                        DoorBlock door = (DoorBlock)oblock;
                        if (state.getValue(DoorBlock.HINGE).equals(ostate.getValue(DoorBlock.HINGE))) {
                            continue;
                        }

                        if (playsound) {
                            door.setOpen(player, world, state, pos, isopen); // toggleDoor
                        }
                        else {
                            world.setBlock(pos, state.setValue(DoorBlock.OPEN, isopen), 10);
                        }
                        world.setBlock(bpa, ostate.setValue(DoorBlock.OPEN, isopen), 10);
                        return true;
                    }
                }
            }
        }

        return false;
    }


    //************************GET WORLD******************************//
    public static Level getWorldIfInstanceOfAndNotRemote(LevelAccessor iworld)
    {
        if (iworld.isClientSide()) {
            return null;
        }
        if (iworld instanceof Level) {
            return ((Level)iworld);
        }
        return null;
    }

    //***********************GET MAPPED BLOCKS*********************************//
    public static Optional<BlockState> getWaxedOn(BlockState blockState)
    {
        return Optional.ofNullable(GufyWaxable.WAXABLES.get().get(blockState.getBlock())).map((newBlockState) ->
                newBlockState.withPropertiesOf(blockState));
    }

    public static Optional<BlockState> getWaxedOnNew(Block block){
        return Optional.ofNullable(GufyWaxable.WAXABLES.get().get(block)).map((newBlockState) ->
                newBlockState.withPropertiesOf(block.defaultBlockState()));
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
}
