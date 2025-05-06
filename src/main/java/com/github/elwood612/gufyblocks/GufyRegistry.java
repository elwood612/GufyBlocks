package com.github.elwood612.gufyblocks;

import com.github.elwood612.gufyblocks.blocks.*;
import com.github.elwood612.gufyblocks.blocks.blockSpecialty.GufyPane;
import com.github.elwood612.gufyblocks.blocks.blockSpecialty.GufyPanel;
import com.github.elwood612.gufyblocks.blocks.blockSpecialty.GufySeat;
import com.github.elwood612.gufyblocks.blocks.blockSpecialty.GufyWattleFence;
import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyBlockTypes;
import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyWeathering;
import com.github.elwood612.gufyblocks.entities.GufySeatEntity;
import com.github.elwood612.gufyblocks.items.GufyHammer;
import com.github.elwood612.gufyblocks.items.GufyMossClump;
import com.github.elwood612.gufyblocks.util.GufyRendererEvent;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.github.elwood612.gufyblocks.GufyBlocks.MODID;

public class GufyRegistry
{
    //***************************VARIABLES**************************//
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister.Items BLOCKITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, MODID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    private static final GufyBlockTypes[] GUFY_STONE_TYPES = GufyUtil.blocktypeBuilder().get(0);
    private static final GufyBlockTypes[] VANILLA_STONE_TYPES = GufyUtil.blocktypeBuilder().get(1);
    private static final GufyBlockTypes[] GUFY_WOOD_TYPES = GufyUtil.blocktypeBuilder().get(2);
    private static final GufyBlockTypes[] VANILLA_WOOD_TYPES = GufyUtil.blocktypeBuilder().get(3);
    private static final GufyBlockTypes[] GUFY_DIRT_TYPES = GufyUtil.blocktypeBuilder().get(4);
    private static final GufyBlockTypes[] VANILLA_DIRT_TYPES = GufyUtil.blocktypeBuilder().get(5);
    private static final GufyBlockTypes[] VANILLA_STONE_TYPES_ALL = GufyUtil.blocktypeBuilder().get(6);
    private static final GufyBlockTypes[] VANILLA_WOOD_TYPES_ALL = GufyUtil.blocktypeBuilder().get(7);
    private static final GufyBlockTypes[] COPPER_TYPES = GufyUtil.blocktypeBuilder().get(8);
    private static final GufyBlockTypes[] CUT_COPPER_TYPES = GufyUtil.blocktypeBuilder().get(9);
    private static final GufyBlockTypes[] WAXED_COPPER_TYPES = GufyUtil.blocktypeBuilder().get(10);
    private static final GufyBlockTypes[] WAXED_CUT_COPPER_TYPES = GufyUtil.blocktypeBuilder().get(11);
    private static final GufyBlockTypes[] VANILLA_STRIPPABLE_WOOD_TYPES_ALL = GufyUtil.blocktypeBuilder().get(12);
    private static final GufyBlockTypes[] FRAMED_BLOCK_TYPES = GufyUtil.blocktypeBuilder().get(13);
    private static final GufyBlockTypes[] PACKED_ICE_TYPES = GufyUtil.blocktypeBuilder().get(14);
    //**************************************************************//


    //***************************BLOCKLIST**************************//

    public static final List<List<DeferredBlock<Block>>> newBlockList = new ArrayList<List<DeferredBlock<Block>>>()
    {{
        // ~~ WOOD ~~ //
        add(familyBuilderNEW("wattle_fence", GufyMaterials.WATTLE, GufyBlockTypes.WATTLEFENCE));
        add(familyBuilderNEW("oak", GufyMaterials.OAK, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilderNEW("oak_parquet", GufyMaterials.OAK, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilderNEW("big_oak", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(familyBuilderNEW("oak_wood", GufyMaterials.OAK, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilderNEW("stripped_oak_wood", GufyMaterials.OAK, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilderNEW("chiseled_stripped_oak_wood", GufyMaterials.OAK, GufyBlockTypes.CARVED_LOG));
        add(familyBuilderNEW("spruce", GufyMaterials.SPRUCE, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilderNEW("spruce_parquet", GufyMaterials.SPRUCE, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilderNEW("big_spruce", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(familyBuilderNEW("spruce_wood", GufyMaterials.SPRUCE, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilderNEW("stripped_spruce_wood", GufyMaterials.SPRUCE, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilderNEW("chiseled_stripped_spruce_wood", GufyMaterials.SPRUCE, GufyBlockTypes.CARVED_LOG));
        add(familyBuilderNEW("birch", GufyMaterials.BIRCH, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilderNEW("birch_parquet", GufyMaterials.BIRCH, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilderNEW("big_birch", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(familyBuilderNEW("birch_wood", GufyMaterials.BIRCH, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilderNEW("stripped_birch_wood", GufyMaterials.BIRCH, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilderNEW("chiseled_stripped_birch_wood", GufyMaterials.BIRCH, GufyBlockTypes.CARVED_LOG));
        add(familyBuilderNEW("dark_oak", GufyMaterials.DARK_OAK, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilderNEW("dark_oak_parquet", GufyMaterials.DARK_OAK, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilderNEW("big_dark_oak", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(familyBuilderNEW("dark_oak_wood", GufyMaterials.DARK_OAK, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilderNEW("stripped_dark_oak_wood", GufyMaterials.DARK_OAK, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilderNEW("chiseled_stripped_dark_oak_wood", GufyMaterials.DARK_OAK, GufyBlockTypes.CARVED_LOG));
        add(familyBuilderNEW("jungle", GufyMaterials.JUNGLE, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilderNEW("jungle_parquet", GufyMaterials.OAK, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilderNEW("big_jungle", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(familyBuilderNEW("jungle_wood", GufyMaterials.JUNGLE, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilderNEW("stripped_jungle_wood", GufyMaterials.JUNGLE, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilderNEW("chiseled_stripped_jungle_wood", GufyMaterials.JUNGLE, GufyBlockTypes.CARVED_LOG));
        add(familyBuilderNEW("acacia", GufyMaterials.ACACIA, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilderNEW("acacia_parquet", GufyMaterials.ACACIA, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilderNEW("big_acacia", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(familyBuilderNEW("acacia_wood", GufyMaterials.ACACIA, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilderNEW("stripped_acacia_wood", GufyMaterials.ACACIA, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilderNEW("chiseled_stripped_acacia_wood", GufyMaterials.ACACIA, GufyBlockTypes.CARVED_LOG));
        add(familyBuilderNEW("mangrove", GufyMaterials.MANGROVE, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilderNEW("mangrove_parquet", GufyMaterials.MANGROVE, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilderNEW("big_mangrove", GufyMaterials.MANGROVE, GUFY_WOOD_TYPES));
        add(familyBuilderNEW("mangrove_wood", GufyMaterials.MANGROVE, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilderNEW("stripped_mangrove_wood", GufyMaterials.MANGROVE, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilderNEW("chiseled_stripped_mangrove_wood", GufyMaterials.MANGROVE, GufyBlockTypes.CARVED_LOG));
        add(familyBuilderNEW("cherry", GufyMaterials.CHERRY, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilderNEW("cherry_parquet", GufyMaterials.CHERRY, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilderNEW("big_cherry", GufyMaterials.CHERRY, GUFY_WOOD_TYPES));
        add(familyBuilderNEW("cherry_wood", GufyMaterials.CHERRY, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilderNEW("stripped_cherry_wood", GufyMaterials.CHERRY, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilderNEW("chiseled_stripped_cherry_wood", GufyMaterials.CHERRY, GufyBlockTypes.CARVED_LOG));
        add(familyBuilderNEW("bamboo", GufyMaterials.BAMBOO, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilderNEW("bamboo_mosaic", GufyMaterials.BAMBOO, GufyBlockTypes.VERTICALSLAB));
        add(familyBuilderNEW("chiseled_stripped_bamboo_block", GufyMaterials.BAMBOO, GufyBlockTypes.CARVED_LOG));
        add(familyBuilderNEW("crimson", GufyMaterials.CRIMSON, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilderNEW("crimson_parquet", GufyMaterials.CRIMSON, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilderNEW("big_crimson", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(familyBuilderNEW("crimson_hyphae", GufyMaterials.CRIMSON, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilderNEW("stripped_crimson_hyphae", GufyMaterials.CRIMSON, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilderNEW("chiseled_stripped_crimson_hyphae", GufyMaterials.CRIMSON, GufyBlockTypes.CARVED_LOG));
        add(familyBuilderNEW("warped", GufyMaterials.WARPED, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilderNEW("warped_parquet", GufyMaterials.WARPED, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilderNEW("big_warped", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(familyBuilderNEW("warped_hyphae", GufyMaterials.WARPED, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilderNEW("stripped_warped_hyphae", GufyMaterials.WARPED, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilderNEW("chiseled_stripped_warped_hyphae", GufyMaterials.WARPED, GufyBlockTypes.CARVED_LOG));
        add(familyBuilderNEW("mushroom_stem", GufyMaterials.MUSHROOM, ArrayUtils.addAll(VANILLA_WOOD_TYPES_ALL, GufyBlockTypes.TRAPDOOR)));

        // ~~ DIRTS ~~ //
        add(familyBuilderNEW("coarse_dirt", GufyMaterials.DIRT, VANILLA_DIRT_TYPES));
        add(familyBuilderNEW("packed_mud", GufyMaterials.PACKED_MUD, VANILLA_DIRT_TYPES));
        add(familyBuilderNEW("mud_bricks", GufyMaterials.MUD_BRICKS, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("hay", GufyMaterials.THATCH, VANILLA_DIRT_TYPES));
        add(familyBuilderNEW("moss", GufyMaterials.MOSS, VANILLA_DIRT_TYPES));
        add(familyBuilderNEW("rooted_dirt", GufyMaterials.ROOTED_DIRT, VANILLA_DIRT_TYPES));
        add(familyBuilderNEW("nether_wart_block", GufyMaterials.NETHER_WART, VANILLA_DIRT_TYPES));
        add(familyBuilderNEW("warped_wart", GufyMaterials.WARPED_WART, VANILLA_DIRT_TYPES));
        add(familyBuilderNEW("snow", GufyMaterials.SNOW, VANILLA_DIRT_TYPES));
        add(familyBuilderNEW("packed_ice", GufyMaterials.ICE, PACKED_ICE_TYPES));

        // ~~ STONES ~~ //
        add(familyBuilderNEW("stone", GufyMaterials.STONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilderNEW("smooth_stone", GufyMaterials.STONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL, GufyBlockTypes.STAIRS)));
        add(familyBuilderNEW("cobblestone", GufyMaterials.COBBLESTONE, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("mossy_cobblestone", GufyMaterials.COBBLESTONE, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("cobblestone_bricks", GufyMaterials.STONE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("mossy_cobblestone_bricks", GufyMaterials.STONE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("cracked_cobblestone_bricks", GufyMaterials.STONE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("stone_bricks", GufyMaterials.STONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(familyBuilderNEW("mossy_stone_bricks", GufyMaterials.STONE, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("cracked_stone_bricks", GufyMaterials.STONE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("diorite", GufyMaterials.DIORITE, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("polished_diorite", GufyMaterials.DIORITE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilderNEW("diorite_bricks", GufyMaterials.DIORITE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR, GufyBlockTypes.CHISELED)));
        add(familyBuilderNEW("mossy_diorite_bricks", GufyMaterials.DIORITE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("cracked_diorite_bricks", GufyMaterials.DIORITE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("diorite_cobble_bricks", GufyMaterials.DIORITE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("mossy_diorite_cobble_bricks", GufyMaterials.DIORITE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("cracked_diorite_cobble_bricks", GufyMaterials.DIORITE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("granite", GufyMaterials.GRANITE, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("polished_granite", GufyMaterials.GRANITE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilderNEW("granite_bricks", GufyMaterials.GRANITE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR, GufyBlockTypes.CHISELED)));
        add(familyBuilderNEW("cracked_granite_bricks", GufyMaterials.GRANITE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("mossy_granite_bricks", GufyMaterials.GRANITE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("granite_cobble_bricks", GufyMaterials.GRANITE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("cracked_granite_cobble_bricks", GufyMaterials.GRANITE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("mossy_granite_cobble_bricks", GufyMaterials.GRANITE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("andesite", GufyMaterials.ANDESITE, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("polished_andesite", GufyMaterials.ANDESITE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilderNEW("andesite_bricks", GufyMaterials.ANDESITE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR, GufyBlockTypes.CHISELED)));
        add(familyBuilderNEW("cracked_andesite_bricks", GufyMaterials.ANDESITE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("mossy_andesite_bricks", GufyMaterials.ANDESITE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("brick", GufyMaterials.BRICK, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("cracked_bricks", GufyMaterials.BRICK, GUFY_STONE_TYPES));
        add(familyBuilderNEW("mossy_bricks", GufyMaterials.BRICK, GUFY_STONE_TYPES));
        add(familyBuilderNEW("nether_brick", GufyMaterials.NETHER_BRICKS, GufyBlockTypes.VERTICALSLAB, GufyBlockTypes.HOPPER));
        add(familyBuilderNEW("cracked_nether_bricks", GufyMaterials.NETHER_BRICKS,
                GufyBlockTypes.STAIRS, GufyBlockTypes.SLAB, GufyBlockTypes.WALL, GufyBlockTypes.VERTICALSLAB, GufyBlockTypes.HOPPER, GufyBlockTypes.FENCE));
        add(familyBuilderNEW("red_nether_bricks", GufyMaterials.NETHER_BRICKS, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("calcite", GufyMaterials.CALCITE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("tuff", GufyMaterials.TUFF, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("tuff_bricks", GufyMaterials.TUFF, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(familyBuilderNEW("polished_tuff", GufyMaterials.TUFF, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("smooth_basalt", GufyMaterials.BASALT, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("deepslate", GufyMaterials.COBBLED_DEEPSLATE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("cobbled_deepslate", GufyMaterials.COBBLED_DEEPSLATE, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("mossy_cobbled_deepslate", GufyMaterials.COBBLED_DEEPSLATE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("deepslate_bricks", GufyMaterials.DEEPSLATE_BRICK, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(familyBuilderNEW("deepslate_tiles", GufyMaterials.TILED_DEEPSLATE, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("polished_deepslate", GufyMaterials.POLISHED_DEEPSLATE, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("cracked_deepslate_bricks", GufyMaterials.DEEPSLATE_BRICK, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("cracked_deepslate_tiles", GufyMaterials.TILED_DEEPSLATE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("mossy_deepslate_bricks", GufyMaterials.DEEPSLATE_BRICK, GUFY_STONE_TYPES));
        add(familyBuilderNEW("mossy_deepslate_tiles", GufyMaterials.TILED_DEEPSLATE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("quartz", GufyMaterials.QUARTZ, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilderNEW("smooth_quartz", GufyMaterials.QUARTZ, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilderNEW("quartz_bricks", GufyMaterials.QUARTZ, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("iron", GufyMaterials.IRON, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("gold", GufyMaterials.GOLD, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("emerald", GufyMaterials.EMERALD, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("diamond", GufyMaterials.DIAMOND, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("sandstone", GufyMaterials.SANDSTONE, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("cut_sandstone", GufyMaterials.SANDSTONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilderNEW("smooth_sandstone", GufyMaterials.SMOOTH_SANDSTONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilderNEW("sandstone_bricks", GufyMaterials.SANDSTONE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(familyBuilderNEW("cracked_sandstone_bricks", GufyMaterials.SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("mossy_sandstone_bricks", GufyMaterials.SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("sandstone_cobble_bricks", GufyMaterials.SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("cracked_sandstone_cobble_bricks", GufyMaterials.SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("mossy_sandstone_cobble_bricks", GufyMaterials.SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("red_sandstone", GufyMaterials.RED_SANDSTONE, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("cut_red_sandstone", GufyMaterials.RED_SANDSTONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilderNEW("smooth_red_sandstone", GufyMaterials.SMOOTH_RED_SANDSTONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilderNEW("red_sandstone_bricks", GufyMaterials.RED_SANDSTONE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(familyBuilderNEW("cracked_red_sandstone_bricks", GufyMaterials.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("mossy_red_sandstone_bricks", GufyMaterials.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("red_sandstone_cobble_bricks", GufyMaterials.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("cracked_red_sandstone_cobble_bricks", GufyMaterials.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("mossy_red_sandstone_cobble_bricks", GufyMaterials.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilderNEW("amethyst", GufyMaterials.AMETHYST, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("end_stone", GufyMaterials.END_STONE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("end_stone_brick", GufyMaterials.END_STONE, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("purpur", GufyMaterials.PURPUR, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilderNEW("blackstone", GufyMaterials.BLACKSTONE, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("polished_blackstone", GufyMaterials.POLISHED_BLACKSTONE, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("polished_blackstone_brick", GufyMaterials.BLACKSTONE, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("cracked_polished_blackstone_brick", GufyMaterials.BLACKSTONE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("gilded_blackstone", GufyMaterials.GILDED_BLACKSTONE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("dripstone", GufyMaterials.DRIPSTONE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("stone", GufyMaterials.STONE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilderNEW("diorite", GufyMaterials.DIORITE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilderNEW("andesite", GufyMaterials.ANDESITE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilderNEW("granite", GufyMaterials.GRANITE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilderNEW("cobbled_deepslate", GufyMaterials.COBBLED_DEEPSLATE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilderNEW("sandstone", GufyMaterials.SANDSTONE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilderNEW("red_sandstone", GufyMaterials.RED_SANDSTONE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilderNEW("prismarine", GufyMaterials.PRISMARINE, VANILLA_STONE_TYPES));
        add(familyBuilderNEW("prismarine_bricks", GufyMaterials.PRISMARINE_BRICKS, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilderNEW("dark_prismarine", GufyMaterials.PRISMARINE_BRICKS, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));

        // ~~ TERRACOTTA ~~ //
        add(familyBuilderNEW("terracotta", GufyMaterials.TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("white_terracotta", GufyMaterials.WHITE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("light_gray_terracotta", GufyMaterials.LIGHT_GRAY_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("gray_terracotta", GufyMaterials.GRAY_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("black_terracotta", GufyMaterials.BLACK_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("brown_terracotta", GufyMaterials.BROWN_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("red_terracotta", GufyMaterials.RED_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("orange_terracotta", GufyMaterials.ORANGE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("yellow_terracotta", GufyMaterials.YELLOW_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("lime_terracotta", GufyMaterials.LIME_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("green_terracotta", GufyMaterials.GREEN_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("cyan_terracotta", GufyMaterials.CYAN_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("light_blue_terracotta", GufyMaterials.LIGHT_BLUE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("blue_terracotta", GufyMaterials.BLUE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("purple_terracotta", GufyMaterials.PURPLE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("magenta_terracotta", GufyMaterials.MAGENTA_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("pink_terracotta", GufyMaterials.PINK_TERRACOTTA, VANILLA_STONE_TYPES_ALL));

        // ~~ CONCRETE ~~ //
        add(familyBuilderNEW("white_concrete", GufyMaterials.WHITE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("light_gray_concrete", GufyMaterials.LIGHT_GRAY_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("gray_concrete", GufyMaterials.GRAY_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("black_concrete", GufyMaterials.BLACK_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("brown_concrete", GufyMaterials.BROWN_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("red_concrete", GufyMaterials.RED_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("orange_concrete", GufyMaterials.ORANGE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("yellow_concrete", GufyMaterials.YELLOW_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("lime_concrete", GufyMaterials.LIME_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("green_concrete", GufyMaterials.GREEN_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("cyan_concrete", GufyMaterials.CYAN_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("light_blue_concrete", GufyMaterials.LIGHT_BLUE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("blue_concrete", GufyMaterials.BLUE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("purple_concrete", GufyMaterials.PURPLE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("magenta_concrete", GufyMaterials.MAGENTA_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilderNEW("pink_concrete", GufyMaterials.PINK_CONCRETE, VANILLA_STONE_TYPES_ALL));

        // ~~ WOOL ~~ //
        add(familyBuilderNEW("white_wool", GufyMaterials.WHITE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilderNEW("light_gray_wool", GufyMaterials.LIGHT_GRAY_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilderNEW("gray_wool", GufyMaterials.GRAY_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilderNEW("black_wool", GufyMaterials.BLACK_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilderNEW("brown_wool", GufyMaterials.BROWN_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilderNEW("red_wool", GufyMaterials.RED_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilderNEW("orange_wool", GufyMaterials.ORANGE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilderNEW("yellow_wool", GufyMaterials.YELLOW_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilderNEW("lime_wool", GufyMaterials.LIME_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilderNEW("green_wool", GufyMaterials.GREEN_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilderNEW("cyan_wool", GufyMaterials.CYAN_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilderNEW("light_blue_wool", GufyMaterials.LIGHT_BLUE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilderNEW("blue_wool", GufyMaterials.BLUE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilderNEW("purple_wool", GufyMaterials.PURPLE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilderNEW("magenta_wool", GufyMaterials.MAGENTA_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilderNEW("pink_wool", GufyMaterials.PINK_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));

        // ~~ GLASS ~~ //
        add(familyBuilderNEW("leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("white_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("light_gray_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("gray_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("black_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("brown_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("red_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("orange_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("yellow_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("lime_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("green_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("cyan_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("light_blue_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("blue_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("purple_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("magenta_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("pink_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("oakfield_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("avalon_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("gufy_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("midland_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("ring_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("oak_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("spruce_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("birch_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("dark_oak_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("jungle_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("acacia_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("mangrove_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("cherry_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("bamboo_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("crimson_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("warped_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilderNEW("mushroom_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));

        // ~~ FRAMED TERRACOTTA ~~ //
        add(familyBuilderNEW("oak_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilderNEW("spruce_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilderNEW("birch_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilderNEW("dark_oak_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilderNEW("jungle_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilderNEW("acacia_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilderNEW("mangrove_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilderNEW("cherry_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilderNEW("bamboo_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilderNEW("crimson_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilderNEW("warped_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilderNEW("mushroom_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));

        // ~~ COPPER ~~ //
        add(familyBuilderNEW("copper", GufyMaterials.COPPER, GufyWeathering.WeatherState.UNAFFECTED, COPPER_TYPES));
        add(familyBuilderNEW("exposed_copper", GufyMaterials.EXPOSED_COPPER, GufyWeathering.WeatherState.EXPOSED, COPPER_TYPES));
        add(familyBuilderNEW("weathered_copper", GufyMaterials.WEATHERED_COPPER, GufyWeathering.WeatherState.WEATHERED, COPPER_TYPES));
        add(familyBuilderNEW("oxidized_copper", GufyMaterials.OXIDIZED_COPPER, GufyWeathering.WeatherState.OXIDIZED, COPPER_TYPES));
        add(familyBuilderNEW("cut_copper", GufyMaterials.COPPER, GufyWeathering.WeatherState.UNAFFECTED, CUT_COPPER_TYPES));
        add(familyBuilderNEW("exposed_cut_copper", GufyMaterials.EXPOSED_COPPER, GufyWeathering.WeatherState.EXPOSED, CUT_COPPER_TYPES));
        add(familyBuilderNEW("weathered_cut_copper", GufyMaterials.WEATHERED_COPPER, GufyWeathering.WeatherState.WEATHERED, CUT_COPPER_TYPES));
        add(familyBuilderNEW("oxidized_cut_copper", GufyMaterials.OXIDIZED_COPPER, GufyWeathering.WeatherState.OXIDIZED, CUT_COPPER_TYPES));
        add(familyBuilderNEW("waxed_copper", GufyMaterials.COPPER, WAXED_COPPER_TYPES));
        add(familyBuilderNEW("waxed_exposed_copper", GufyMaterials.EXPOSED_COPPER, WAXED_COPPER_TYPES));
        add(familyBuilderNEW("waxed_weathered_copper", GufyMaterials.WEATHERED_COPPER, WAXED_COPPER_TYPES));
        add(familyBuilderNEW("waxed_oxidized_copper", GufyMaterials.OXIDIZED_COPPER, WAXED_COPPER_TYPES));
        add(familyBuilderNEW("waxed_cut_copper", GufyMaterials.COPPER, WAXED_CUT_COPPER_TYPES));
        add(familyBuilderNEW("waxed_exposed_cut_copper", GufyMaterials.EXPOSED_COPPER, WAXED_CUT_COPPER_TYPES));
        add(familyBuilderNEW("waxed_weathered_cut_copper", GufyMaterials.WEATHERED_COPPER, WAXED_CUT_COPPER_TYPES));
        add(familyBuilderNEW("waxed_oxidized_cut_copper", GufyMaterials.OXIDIZED_COPPER, WAXED_CUT_COPPER_TYPES));

        // ~~ SEATS ~~ //
        add(familyBuilderNEW("seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(familyBuilderNEW("white_seat", GufyMaterials.WHITE_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilderNEW("light_gray_seat", GufyMaterials.LIGHT_GRAY_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilderNEW("gray_seat", GufyMaterials.GRAY_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilderNEW("black_seat", GufyMaterials.BLACK_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilderNEW("brown_seat", GufyMaterials.BROWN_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilderNEW("red_seat", GufyMaterials.RED_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilderNEW("orange_seat", GufyMaterials.ORANGE_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilderNEW("yellow_seat", GufyMaterials.YELLOW_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilderNEW("lime_seat", GufyMaterials.LIME_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilderNEW("green_seat", GufyMaterials.GREEN_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilderNEW("cyan_seat", GufyMaterials.CYAN_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilderNEW("light_blue_seat", GufyMaterials.LIGHT_BLUE_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilderNEW("blue_seat", GufyMaterials.BLUE_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilderNEW("purple_seat", GufyMaterials.PURPLE_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilderNEW("magenta_seat", GufyMaterials.MAGENTA_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilderNEW("pink_seat", GufyMaterials.PINK_SEAT, GufyBlockTypes.SEAT));

        // ~~ DEPRECATED BLOCKS ~~ //
        add(familyBuilderNEW("wagon_wheel", GufyMaterials.SPRUCE_TRAPDOOR, GufyBlockTypes.WAGONWHEEL)); // DEPRECATED
        add(familyBuilderNEW("mossy_oak", GufyMaterials.OAK, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilderNEW("cracked_oak", GufyMaterials.OAK, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilderNEW("mossy_spruce", GufyMaterials.SPRUCE, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilderNEW("cracked_spruce", GufyMaterials.SPRUCE, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilderNEW("mossy_birch", GufyMaterials.BIRCH, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilderNEW("cracked_birch", GufyMaterials.BIRCH, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilderNEW("mossy_dark_oak", GufyMaterials.DARK_OAK, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilderNEW("cracked_dark_oak", GufyMaterials.DARK_OAK, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilderNEW("mossy_jungle", GufyMaterials.JUNGLE, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilderNEW("cracked_jungle", GufyMaterials.JUNGLE, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilderNEW("mossy_acacia", GufyMaterials.ACACIA, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilderNEW("cracked_acacia", GufyMaterials.ACACIA, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilderNEW("mossy_crimson", GufyMaterials.CRIMSON, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilderNEW("cracked_crimson", GufyMaterials.CRIMSON, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilderNEW("mossy_warped", GufyMaterials.WARPED, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilderNEW("cracked_warped", GufyMaterials.WARPED, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilderNEW("diorite_cobble", GufyMaterials.DIORITE, GUFY_STONE_TYPES)); // DEPRECATED
        add(familyBuilderNEW("mossy_diorite_cobble", GufyMaterials.DIORITE, GUFY_STONE_TYPES)); // DEPRECATED
        add(familyBuilderNEW("oak_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilderNEW("spruce_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilderNEW("birch_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilderNEW("dark_oak_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilderNEW("jungle_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilderNEW("acacia_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilderNEW("crimson_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilderNEW("warped_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilderNEW("daub", GufyMaterials.DAUB, GUFY_DIRT_TYPES)); // DEPRECATED
        add(familyBuilderNEW("thatch", GufyMaterials.THATCH, GUFY_DIRT_TYPES)); // DEPRECATED
    }};
    //**************************************************************//



    //****************************ITEMS*****************************//
//    public static final DeferredItem<Item> MOSS_CLUMP = ITEMS.register("moss_clump",
//            () -> new GufyMossClump(new Item.Properties()));
//    public static final DeferredItem<Item> HAMMER = ITEMS.register("hammer",
//            () -> new GufyHammer(new Item.Properties().durability(216)));
    public static final DeferredItem<Item> MOSS_CLUMP = ITEMS.registerItem(
            "moss_clump",
            GufyMossClump::new,
            new Item.Properties()
    );
    public static final DeferredItem<Item> HAMMER = ITEMS.registerItem(
            "hammer",
            GufyHammer::new,
            new Item.Properties().durability(216)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<GufySeatEntity>> SEAT = ENTITIES.register("seat",
            () -> EntityType.Builder.<GufySeatEntity>of(GufySeatEntity::new, MobCategory.MISC).sized(0.0f, 0.0f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MODID, "seat"))));

    //**************************************************************//


    //****************************TABS******************************//
    public static final Supplier<CreativeModeTab> GUFY_TAB = TABS.register("gufyblocks",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + MODID + ".tab"))
                    .icon(() -> new ItemStack(GufyUtil.getGufyBlock("cobblestone_bricks")))
                    .displayItems((params, output) -> {
                        for (DeferredHolder<Block, ? extends Block> block : GufyRegistry.BLOCKS.getEntries())
                        {
                            output.accept(block.get());
                        }
                        for (DeferredHolder<Item, ? extends Item> item : GufyRegistry.ITEMS.getEntries())
                        {
                            output.accept(item.get());
                        }
                    })
                    .build()
    );
    //**************************************************************//


    //***********************REGISTRY METHODS***********************//
    // to remove
    public static <T extends Block>DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, block);
        return toReturn;
    }

    // to remove
    public static <T extends Block> void registerBlockItem(String name, Supplier<T> block) {
        BLOCKITEMS.registerSimpleBlockItem(
                name,
                block,
                new Item.Properties()
        );
    }

    public static List<DeferredBlock<Block>> familyBuilderNEW(String name, GufyMaterials properties, GufyBlockTypes ... blockTypes)
    {
        return new ArrayList<>()
        {{
            for (GufyBlockTypes blockType: blockTypes)
            {
                DeferredBlock<Block> newBlock = null;
                switch (blockType)
                {
                    case BLOCK -> newBlock = BLOCKS.registerBlock(name, Block::new, GufyUtil.propertiesBuilder(properties));
                    case STAIRS -> newBlock = BLOCKS.registerBlock(
                            name + "_stairs",
                            StairBlock::new,
                            GufyUtil.propertiesBuilder(properties));
                    case GUFYSTAIRS -> newBlock = BLOCKS.registerBlock(name + "_stairs", GufyStairs::new, GufyUtil.getGufyBlock(name).defaultBlockState(), GufyUtil.propertiesBuilder(properties));
                    case ICE_STAIRS -> newBlock = BLOCKS.registerBlock(name + "_stairs", StairBlock::new, GufyUtil.getGufyBlock(name).defaultBlockState(), GufyUtil.propertiesBuilder(properties).friction(0.98f));
                    case SLAB -> newBlock = BLOCKS.registerBlock(name + "_slab", SlabBlock::new, GufyUtil.propertiesBuilder(properties));
                    case ICE_SLAB -> newBlock = BLOCKS.registerBlock(name + "_slab", SlabBlock::new, GufyUtil.propertiesBuilder(properties).friction(0.98f));
                    case GUFYSLAB -> newBlock = BLOCKS.registerBlock(name + "_slab", GufySlab::new, GufyUtil.propertiesBuilder(properties));
                    case VERTICALSLAB -> newBlock = BLOCKS.registerBlock(name + "_verticalslab", GufyVerticalSlab::new, GufyUtil.propertiesBuilder(properties));
                    case ICE_VERTICALSLAB -> newBlock = BLOCKS.registerBlock(name + "_verticalslab", GufyVerticalSlab::new, (GufyUtil.propertiesBuilder(properties).friction(0.98f)));
                    case WALL -> newBlock = BLOCKS.registerBlock(name + "_wall", WallBlock::new, GufyUtil.propertiesBuilder(properties));
                    case GUFYWALL -> newBlock = BLOCKS.registerBlock(name + "_wall", GufyWall::new, GufyUtil.propertiesBuilder(properties));
                    case HOPPER -> newBlock = BLOCKS.registerBlock(name + "_hopper", GufyHopper::new, GufyUtil.propertiesBuilder(properties));
                    case POST -> newBlock = BLOCKS.registerBlock(name + "_post", GufyPost::new, GufyUtil.propertiesBuilder(properties));
                    case PILLAR -> newBlock = BLOCKS.registerBlock(name + "_pillar", RotatedPillarBlock::new, GufyUtil.propertiesBuilder(properties));
                    case STONE_TRAPDOOR -> newBlock = BLOCKS.registerBlock(name + "_trapdoor", TrapDoorBlock::new, BlockSetType.IRON, GufyUtil.propertiesBuilder(GufyMaterials.STONE_TRAPDOOR));
                    case TRAPDOOR -> newBlock = BLOCKS.registerBlock(name + "_trapdoor", TrapDoorBlock::new, BlockSetType.OAK, GufyUtil.propertiesBuilder(properties));
                    case WOOL_TRAPDOOR -> newBlock = BLOCKS.registerBlock(name + "_trapdoor", TrapDoorBlock::new, BlockSetType.OAK, GufyUtil.propertiesBuilder(properties).sound(SoundType.WOOL));
                    case PANEL -> newBlock = BLOCKS.registerBlock(name + "_panel", GufyPanel::new, GufyUtil.propertiesBuilder(properties));
                    case FENCE -> newBlock = BLOCKS.registerBlock(name + "_fence", FenceBlock::new, GufyUtil.propertiesBuilder(properties));
                    case GUFYFENCE -> newBlock = BLOCKS.registerBlock(name + "_fence", GufyFence::new, GufyUtil.propertiesBuilder(properties));
                    case FENCEGATE -> newBlock = BLOCKS.registerBlock(name + "_fence_gate", FenceGateBlock::new, GufyUtil.propertiesBuilder(properties), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN);
                    case PARQUET -> newBlock = BLOCKS.registerBlock(name + "_parquet", Block::new, GufyUtil.propertiesBuilder(properties));
                    case WATTLEFENCE -> newBlock = BLOCKS.registerBlock(name, GufyWattleFence::new, GufyUtil.propertiesBuilder(properties);
                    case WAGONWHEEL -> newBlock = BLOCKS.registerBlock(name, TrapDoorBlock::new, BlockSetType.OAK, GufyUtil.propertiesBuilder(properties));
                    case PANE -> newBlock = BLOCKS.registerBlock(name + "_pane", GufyPane::new, GufyUtil.propertiesBuilder(properties));
                    case CHISELED -> newBlock = BLOCKS.registerBlock("chiseled_" + name, Block::new, GufyUtil.propertiesBuilder(properties));
                    case FRAMED_LEFT -> newBlock = BLOCKS.registerBlock(name + "_left", Block::new, GufyUtil.propertiesBuilder(properties));
                    case FRAMED_RIGHT -> newBlock = BLOCKS.registerBlock(name + "_right", Block::new, GufyUtil.propertiesBuilder(properties));
                    case FRAMED_CROSS -> newBlock = BLOCKS.registerBlock(name + "_cross", Block::new, GufyUtil.propertiesBuilder(properties));
                    case CARVED_LOG -> newBlock = BLOCKS.registerBlock(name, RotatedPillarBlock::new, GufyUtil.propertiesBuilder(properties));
                    case SEAT -> newBlock = BLOCKS.registerBlock(name, GufySeat::new, GufyUtil.propertiesBuilder(properties).pushReaction(PushReaction.DESTROY));
                }
                if (newBlock == null) continue;
                
                add(newBlock);
                BLOCKITEMS.registerSimpleBlockItem(name, newBlock);
            }
        }};
    }
    //**************************************************************//
}
