package elwood612.gufyblocks.util;

import elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import elwood612.gufyblocks.blocks.blockUtil.GufyWaxable;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.texture.AtlasSet;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Optional;

public class GufyUtil
{

    //************************BUILDER******************************//
    public static BlockBehaviour.Properties builder(GufyMaterials block) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties
                .of(block.material, block.color)
                .strength(block.hardness, block.resistance)
                .sound(block.sound);
        if (block.tool) properties = properties.requiresCorrectToolForDrops();
        if (!block.occlusion) properties = properties.noOcclusion();
        return properties;
    }


    //*****************RENDER LAYER SETUP*************************//
    public static void renderSetup() {
        //Do this for every transparent block
        ItemBlockRenderTypes.setRenderLayer(getBlock("wattle_fence"), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(getBlock("white_wood_trapdoor"), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(getBlock("leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("white_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("light_gray_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("gray_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("black_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("brown_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("red_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("orange_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("yellow_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("lime_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("green_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("cyan_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("light_blue_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("blue_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("purple_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("magenta_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("pink_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("avalon_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("oakfield_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("gufy_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("ring_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("midland_leaded_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("spruce_framed_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("oak_framed_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("dark_oak_framed_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("birch_framed_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("jungle_framed_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("acacia_framed_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("crimson_framed_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("warped_framed_glass_pane"), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(getBlock("white_wood_framed_glass_pane"), RenderType.translucent());

        //Vanilla Blocks
        ItemBlockRenderTypes.setRenderLayer(net.minecraft.world.level.block.Blocks.GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(net.minecraft.world.level.block.Blocks.GLASS_PANE, RenderType.translucent());

    }


    //************************GET BLOCK******************************//
    public static Block getBlock(String name) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation("gufyblocks", name));
    }

    //************************GET ITEM*******************************//
    public static Item getItem(String name) {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation("gufyblocks", name));
    }

    //************************IS DOOR******************************//
    public static boolean isDoorBlock(BlockState blockstate) {
        Block block = blockstate.getBlock();
        if (block instanceof DoorBlock) {
            //if (blockstate.has(BlockStateProperties.OPEN)) {
            return true;
        }
        return false;
    }

    //************************GET WORLD******************************//
    public static Level getWorldIfInstanceOfAndNotRemote(LevelAccessor iworld) {
        if (iworld.isClientSide()) {
            return null;
        }
        if (iworld instanceof Level) {
            return ((Level)iworld);
        }
        return null;
    }

    //***********************WAX ON*********************************//
    public static Optional<BlockState> getWaxedOn(BlockState blockState) {
        return Optional.ofNullable(GufyWaxable.WAXABLES.get().get(blockState.getBlock())).map((newBlockState) ->
                newBlockState.withPropertiesOf(blockState));
    }

    //***********************WAX OFF*******************************//
    public static Optional<BlockState> getWaxedOff(BlockState blockState) {
        return Optional.ofNullable(GufyWaxable.WAX_OFF_BY_BLOCK.get().get(blockState.getBlock())).map((newBlockState) ->
                newBlockState.withPropertiesOf(blockState));
    }

    //***********************IS WAXED*******************************//
    public static boolean isWaxed(BlockState blockState) {
        return GufyWaxable.WAXABLES.get().containsValue(blockState.getBlock());
    }
}
