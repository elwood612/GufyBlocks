package com.github.elwood612.gufyblocks;

import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyBlockTypes;
import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyWeathering;
import com.github.elwood612.gufyblocks.entities.GufySeatEntity;
import com.github.elwood612.gufyblocks.items.GufyHammer;
import com.github.elwood612.gufyblocks.items.GufyMossClump;
import com.github.elwood612.gufyblocks.util.GufyRendererEvent;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
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
        add(GufyUtil.familyBuilder("wattle_fence", GufyMaterials.WATTLE, GufyBlockTypes.WATTLEFENCE));
        add(GufyUtil.familyBuilder("oak", GufyMaterials.OAK, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(GufyUtil.familyBuilder("oak_parquet", GufyMaterials.OAK, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(GufyUtil.familyBuilder("big_oak", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(GufyUtil.familyBuilder("oak_wood", GufyMaterials.OAK, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("stripped_oak_wood", GufyMaterials.OAK, VANILLA_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("chiseled_stripped_oak_wood", GufyMaterials.OAK, GufyBlockTypes.CARVED_LOG));
        add(GufyUtil.familyBuilder("spruce", GufyMaterials.SPRUCE, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(GufyUtil.familyBuilder("spruce_parquet", GufyMaterials.SPRUCE, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(GufyUtil.familyBuilder("big_spruce", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(GufyUtil.familyBuilder("spruce_wood", GufyMaterials.SPRUCE, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("stripped_spruce_wood", GufyMaterials.SPRUCE, VANILLA_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("chiseled_stripped_spruce_wood", GufyMaterials.SPRUCE, GufyBlockTypes.CARVED_LOG));
        add(GufyUtil.familyBuilder("birch", GufyMaterials.BIRCH, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(GufyUtil.familyBuilder("birch_parquet", GufyMaterials.BIRCH, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(GufyUtil.familyBuilder("big_birch", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(GufyUtil.familyBuilder("birch_wood", GufyMaterials.BIRCH, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("stripped_birch_wood", GufyMaterials.BIRCH, VANILLA_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("chiseled_stripped_birch_wood", GufyMaterials.BIRCH, GufyBlockTypes.CARVED_LOG));
        add(GufyUtil.familyBuilder("dark_oak", GufyMaterials.DARK_OAK, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(GufyUtil.familyBuilder("dark_oak_parquet", GufyMaterials.DARK_OAK, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(GufyUtil.familyBuilder("big_dark_oak", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(GufyUtil.familyBuilder("dark_oak_wood", GufyMaterials.DARK_OAK, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("stripped_dark_oak_wood", GufyMaterials.DARK_OAK, VANILLA_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("chiseled_stripped_dark_oak_wood", GufyMaterials.DARK_OAK, GufyBlockTypes.CARVED_LOG));
        add(GufyUtil.familyBuilder("jungle", GufyMaterials.JUNGLE, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(GufyUtil.familyBuilder("jungle_parquet", GufyMaterials.OAK, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(GufyUtil.familyBuilder("big_jungle", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(GufyUtil.familyBuilder("jungle_wood", GufyMaterials.JUNGLE, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("stripped_jungle_wood", GufyMaterials.JUNGLE, VANILLA_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("chiseled_stripped_jungle_wood", GufyMaterials.JUNGLE, GufyBlockTypes.CARVED_LOG));
        add(GufyUtil.familyBuilder("acacia", GufyMaterials.ACACIA, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(GufyUtil.familyBuilder("acacia_parquet", GufyMaterials.ACACIA, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(GufyUtil.familyBuilder("big_acacia", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(GufyUtil.familyBuilder("acacia_wood", GufyMaterials.ACACIA, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("stripped_acacia_wood", GufyMaterials.ACACIA, VANILLA_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("chiseled_stripped_acacia_wood", GufyMaterials.ACACIA, GufyBlockTypes.CARVED_LOG));
        add(GufyUtil.familyBuilder("mangrove", GufyMaterials.MANGROVE, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(GufyUtil.familyBuilder("mangrove_parquet", GufyMaterials.MANGROVE, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(GufyUtil.familyBuilder("big_mangrove", GufyMaterials.MANGROVE, GUFY_WOOD_TYPES));
        add(GufyUtil.familyBuilder("mangrove_wood", GufyMaterials.MANGROVE, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("stripped_mangrove_wood", GufyMaterials.MANGROVE, VANILLA_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("chiseled_stripped_mangrove_wood", GufyMaterials.MANGROVE, GufyBlockTypes.CARVED_LOG));
        add(GufyUtil.familyBuilder("cherry", GufyMaterials.CHERRY, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(GufyUtil.familyBuilder("cherry_parquet", GufyMaterials.CHERRY, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(GufyUtil.familyBuilder("big_cherry", GufyMaterials.CHERRY, GUFY_WOOD_TYPES));
        add(GufyUtil.familyBuilder("cherry_wood", GufyMaterials.CHERRY, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("stripped_cherry_wood", GufyMaterials.CHERRY, VANILLA_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("chiseled_stripped_cherry_wood", GufyMaterials.CHERRY, GufyBlockTypes.CARVED_LOG));
        add(GufyUtil.familyBuilder("bamboo", GufyMaterials.BAMBOO, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(GufyUtil.familyBuilder("bamboo_mosaic", GufyMaterials.BAMBOO, GufyBlockTypes.VERTICALSLAB));
        add(GufyUtil.familyBuilder("chiseled_stripped_bamboo_block", GufyMaterials.BAMBOO, GufyBlockTypes.CARVED_LOG));
        add(GufyUtil.familyBuilder("crimson", GufyMaterials.CRIMSON, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(GufyUtil.familyBuilder("crimson_parquet", GufyMaterials.CRIMSON, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(GufyUtil.familyBuilder("big_crimson", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(GufyUtil.familyBuilder("crimson_hyphae", GufyMaterials.CRIMSON, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("stripped_crimson_hyphae", GufyMaterials.CRIMSON, VANILLA_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("chiseled_stripped_crimson_hyphae", GufyMaterials.CRIMSON, GufyBlockTypes.CARVED_LOG));
        add(GufyUtil.familyBuilder("warped", GufyMaterials.WARPED, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(GufyUtil.familyBuilder("warped_parquet", GufyMaterials.WARPED, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(GufyUtil.familyBuilder("big_warped", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(GufyUtil.familyBuilder("warped_hyphae", GufyMaterials.WARPED, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("stripped_warped_hyphae", GufyMaterials.WARPED, VANILLA_WOOD_TYPES_ALL));
        add(GufyUtil.familyBuilder("chiseled_stripped_warped_hyphae", GufyMaterials.WARPED, GufyBlockTypes.CARVED_LOG));
        add(GufyUtil.familyBuilder("mushroom_stem", GufyMaterials.MUSHROOM, ArrayUtils.addAll(VANILLA_WOOD_TYPES_ALL, GufyBlockTypes.TRAPDOOR)));

        // ~~ DIRTS ~~ //
        add(GufyUtil.familyBuilder("coarse_dirt", GufyMaterials.DIRT, VANILLA_DIRT_TYPES));
        add(GufyUtil.familyBuilder("packed_mud", GufyMaterials.PACKED_MUD, VANILLA_DIRT_TYPES));
        add(GufyUtil.familyBuilder("mud_bricks", GufyMaterials.MUD_BRICKS, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("hay", GufyMaterials.THATCH, VANILLA_DIRT_TYPES));
        add(GufyUtil.familyBuilder("moss", GufyMaterials.MOSS, VANILLA_DIRT_TYPES));
        add(GufyUtil.familyBuilder("rooted_dirt", GufyMaterials.ROOTED_DIRT, VANILLA_DIRT_TYPES));
        add(GufyUtil.familyBuilder("nether_wart_block", GufyMaterials.NETHER_WART, VANILLA_DIRT_TYPES));
        add(GufyUtil.familyBuilder("warped_wart", GufyMaterials.WARPED_WART, VANILLA_DIRT_TYPES));
        add(GufyUtil.familyBuilder("snow", GufyMaterials.SNOW, VANILLA_DIRT_TYPES));
        add(GufyUtil.familyBuilder("packed_ice", GufyMaterials.ICE, PACKED_ICE_TYPES));

        // ~~ STONES ~~ //
        add(GufyUtil.familyBuilder("stone", GufyMaterials.STONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(GufyUtil.familyBuilder("smooth_stone", GufyMaterials.STONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL, GufyBlockTypes.STAIRS)));
        add(GufyUtil.familyBuilder("cobblestone", GufyMaterials.COBBLESTONE, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("mossy_cobblestone", GufyMaterials.COBBLESTONE, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("cobblestone_bricks", GufyMaterials.STONE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("mossy_cobblestone_bricks", GufyMaterials.STONE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("cracked_cobblestone_bricks", GufyMaterials.STONE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("stone_bricks", GufyMaterials.STONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(GufyUtil.familyBuilder("mossy_stone_bricks", GufyMaterials.STONE, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("cracked_stone_bricks", GufyMaterials.STONE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("diorite", GufyMaterials.DIORITE, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("polished_diorite", GufyMaterials.DIORITE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(GufyUtil.familyBuilder("diorite_bricks", GufyMaterials.DIORITE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR, GufyBlockTypes.CHISELED)));
        add(GufyUtil.familyBuilder("mossy_diorite_bricks", GufyMaterials.DIORITE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("cracked_diorite_bricks", GufyMaterials.DIORITE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("diorite_cobble_bricks", GufyMaterials.DIORITE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("mossy_diorite_cobble_bricks", GufyMaterials.DIORITE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("cracked_diorite_cobble_bricks", GufyMaterials.DIORITE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("granite", GufyMaterials.GRANITE, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("polished_granite", GufyMaterials.GRANITE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(GufyUtil.familyBuilder("granite_bricks", GufyMaterials.GRANITE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR, GufyBlockTypes.CHISELED)));
        add(GufyUtil.familyBuilder("cracked_granite_bricks", GufyMaterials.GRANITE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("mossy_granite_bricks", GufyMaterials.GRANITE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("granite_cobble_bricks", GufyMaterials.GRANITE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("cracked_granite_cobble_bricks", GufyMaterials.GRANITE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("mossy_granite_cobble_bricks", GufyMaterials.GRANITE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("andesite", GufyMaterials.ANDESITE, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("polished_andesite", GufyMaterials.ANDESITE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(GufyUtil.familyBuilder("andesite_bricks", GufyMaterials.ANDESITE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR, GufyBlockTypes.CHISELED)));
        add(GufyUtil.familyBuilder("cracked_andesite_bricks", GufyMaterials.ANDESITE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("mossy_andesite_bricks", GufyMaterials.ANDESITE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("brick", GufyMaterials.BRICK, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("cracked_bricks", GufyMaterials.BRICK, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("mossy_bricks", GufyMaterials.BRICK, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("nether_brick", GufyMaterials.NETHER_BRICKS, GufyBlockTypes.VERTICALSLAB, GufyBlockTypes.HOPPER));
        add(GufyUtil.familyBuilder("cracked_nether_bricks", GufyMaterials.NETHER_BRICKS,
                GufyBlockTypes.STAIRS, GufyBlockTypes.SLAB, GufyBlockTypes.WALL, GufyBlockTypes.VERTICALSLAB, GufyBlockTypes.HOPPER, GufyBlockTypes.FENCE));
        add(GufyUtil.familyBuilder("red_nether_bricks", GufyMaterials.NETHER_BRICKS, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("calcite", GufyMaterials.CALCITE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("tuff", GufyMaterials.TUFF, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("tuff_bricks", GufyMaterials.TUFF, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(GufyUtil.familyBuilder("polished_tuff", GufyMaterials.TUFF, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("smooth_basalt", GufyMaterials.BASALT, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("deepslate", GufyMaterials.COBBLED_DEEPSLATE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("cobbled_deepslate", GufyMaterials.COBBLED_DEEPSLATE, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("mossy_cobbled_deepslate", GufyMaterials.COBBLED_DEEPSLATE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("deepslate_bricks", GufyMaterials.DEEPSLATE_BRICK, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(GufyUtil.familyBuilder("deepslate_tiles", GufyMaterials.TILED_DEEPSLATE, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("polished_deepslate", GufyMaterials.POLISHED_DEEPSLATE, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("cracked_deepslate_bricks", GufyMaterials.DEEPSLATE_BRICK, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("cracked_deepslate_tiles", GufyMaterials.TILED_DEEPSLATE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("mossy_deepslate_bricks", GufyMaterials.DEEPSLATE_BRICK, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("mossy_deepslate_tiles", GufyMaterials.TILED_DEEPSLATE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("quartz", GufyMaterials.QUARTZ, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(GufyUtil.familyBuilder("smooth_quartz", GufyMaterials.QUARTZ, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(GufyUtil.familyBuilder("quartz_bricks", GufyMaterials.QUARTZ, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("iron", GufyMaterials.IRON, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("gold", GufyMaterials.GOLD, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("emerald", GufyMaterials.EMERALD, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("diamond", GufyMaterials.DIAMOND, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("sandstone", GufyMaterials.SANDSTONE, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("cut_sandstone", GufyMaterials.SANDSTONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(GufyUtil.familyBuilder("smooth_sandstone", GufyMaterials.SMOOTH_SANDSTONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(GufyUtil.familyBuilder("sandstone_bricks", GufyMaterials.SANDSTONE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(GufyUtil.familyBuilder("cracked_sandstone_bricks", GufyMaterials.SANDSTONE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("mossy_sandstone_bricks", GufyMaterials.SANDSTONE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("sandstone_cobble_bricks", GufyMaterials.SANDSTONE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("cracked_sandstone_cobble_bricks", GufyMaterials.SANDSTONE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("mossy_sandstone_cobble_bricks", GufyMaterials.SANDSTONE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("red_sandstone", GufyMaterials.RED_SANDSTONE, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("cut_red_sandstone", GufyMaterials.RED_SANDSTONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(GufyUtil.familyBuilder("smooth_red_sandstone", GufyMaterials.SMOOTH_RED_SANDSTONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(GufyUtil.familyBuilder("red_sandstone_bricks", GufyMaterials.RED_SANDSTONE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(GufyUtil.familyBuilder("cracked_red_sandstone_bricks", GufyMaterials.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("mossy_red_sandstone_bricks", GufyMaterials.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("red_sandstone_cobble_bricks", GufyMaterials.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("cracked_red_sandstone_cobble_bricks", GufyMaterials.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("mossy_red_sandstone_cobble_bricks", GufyMaterials.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(GufyUtil.familyBuilder("amethyst", GufyMaterials.AMETHYST, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("end_stone", GufyMaterials.END_STONE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("end_stone_brick", GufyMaterials.END_STONE, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("purpur", GufyMaterials.PURPUR, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(GufyUtil.familyBuilder("blackstone", GufyMaterials.BLACKSTONE, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("polished_blackstone", GufyMaterials.POLISHED_BLACKSTONE, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("polished_blackstone_brick", GufyMaterials.BLACKSTONE, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("cracked_polished_blackstone_brick", GufyMaterials.BLACKSTONE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("gilded_blackstone", GufyMaterials.GILDED_BLACKSTONE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("dripstone", GufyMaterials.DRIPSTONE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("stone", GufyMaterials.STONE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(GufyUtil.familyBuilder("diorite", GufyMaterials.DIORITE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(GufyUtil.familyBuilder("andesite", GufyMaterials.ANDESITE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(GufyUtil.familyBuilder("granite", GufyMaterials.GRANITE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(GufyUtil.familyBuilder("cobbled_deepslate", GufyMaterials.COBBLED_DEEPSLATE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(GufyUtil.familyBuilder("sandstone", GufyMaterials.SANDSTONE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(GufyUtil.familyBuilder("red_sandstone", GufyMaterials.RED_SANDSTONE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(GufyUtil.familyBuilder("prismarine", GufyMaterials.PRISMARINE, VANILLA_STONE_TYPES));
        add(GufyUtil.familyBuilder("prismarine_bricks", GufyMaterials.PRISMARINE_BRICKS, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(GufyUtil.familyBuilder("dark_prismarine", GufyMaterials.PRISMARINE_BRICKS, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));

        // ~~ TERRACOTTA ~~ //
        add(GufyUtil.familyBuilder("terracotta", GufyMaterials.TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("white_terracotta", GufyMaterials.WHITE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("light_gray_terracotta", GufyMaterials.LIGHT_GRAY_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("gray_terracotta", GufyMaterials.GRAY_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("black_terracotta", GufyMaterials.BLACK_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("brown_terracotta", GufyMaterials.BROWN_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("red_terracotta", GufyMaterials.RED_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("orange_terracotta", GufyMaterials.ORANGE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("yellow_terracotta", GufyMaterials.YELLOW_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("lime_terracotta", GufyMaterials.LIME_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("green_terracotta", GufyMaterials.GREEN_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("cyan_terracotta", GufyMaterials.CYAN_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("light_blue_terracotta", GufyMaterials.LIGHT_BLUE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("blue_terracotta", GufyMaterials.BLUE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("purple_terracotta", GufyMaterials.PURPLE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("magenta_terracotta", GufyMaterials.MAGENTA_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("pink_terracotta", GufyMaterials.PINK_TERRACOTTA, VANILLA_STONE_TYPES_ALL));

        // ~~ CONCRETE ~~ //
        add(GufyUtil.familyBuilder("white_concrete", GufyMaterials.WHITE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("light_gray_concrete", GufyMaterials.LIGHT_GRAY_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("gray_concrete", GufyMaterials.GRAY_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("black_concrete", GufyMaterials.BLACK_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("brown_concrete", GufyMaterials.BROWN_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("red_concrete", GufyMaterials.RED_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("orange_concrete", GufyMaterials.ORANGE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("yellow_concrete", GufyMaterials.YELLOW_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("lime_concrete", GufyMaterials.LIME_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("green_concrete", GufyMaterials.GREEN_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("cyan_concrete", GufyMaterials.CYAN_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("light_blue_concrete", GufyMaterials.LIGHT_BLUE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("blue_concrete", GufyMaterials.BLUE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("purple_concrete", GufyMaterials.PURPLE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("magenta_concrete", GufyMaterials.MAGENTA_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(GufyUtil.familyBuilder("pink_concrete", GufyMaterials.PINK_CONCRETE, VANILLA_STONE_TYPES_ALL));

        // ~~ WOOL ~~ //
        add(GufyUtil.familyBuilder("white_wool", GufyMaterials.WHITE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(GufyUtil.familyBuilder("light_gray_wool", GufyMaterials.LIGHT_GRAY_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(GufyUtil.familyBuilder("gray_wool", GufyMaterials.GRAY_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(GufyUtil.familyBuilder("black_wool", GufyMaterials.BLACK_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(GufyUtil.familyBuilder("brown_wool", GufyMaterials.BROWN_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(GufyUtil.familyBuilder("red_wool", GufyMaterials.RED_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(GufyUtil.familyBuilder("orange_wool", GufyMaterials.ORANGE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(GufyUtil.familyBuilder("yellow_wool", GufyMaterials.YELLOW_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(GufyUtil.familyBuilder("lime_wool", GufyMaterials.LIME_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(GufyUtil.familyBuilder("green_wool", GufyMaterials.GREEN_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(GufyUtil.familyBuilder("cyan_wool", GufyMaterials.CYAN_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(GufyUtil.familyBuilder("light_blue_wool", GufyMaterials.LIGHT_BLUE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(GufyUtil.familyBuilder("blue_wool", GufyMaterials.BLUE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(GufyUtil.familyBuilder("purple_wool", GufyMaterials.PURPLE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(GufyUtil.familyBuilder("magenta_wool", GufyMaterials.MAGENTA_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(GufyUtil.familyBuilder("pink_wool", GufyMaterials.PINK_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));

        // ~~ GLASS ~~ //
        add(GufyUtil.familyBuilder("leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("white_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("light_gray_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("gray_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("black_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("brown_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("red_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("orange_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("yellow_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("lime_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("green_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("cyan_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("light_blue_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("blue_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("purple_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("magenta_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("pink_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("oakfield_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("avalon_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("gufy_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("midland_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("ring_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("oak_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("spruce_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("birch_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("dark_oak_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("jungle_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("acacia_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("mangrove_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("cherry_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("bamboo_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("crimson_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("warped_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(GufyUtil.familyBuilder("mushroom_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));

        // ~~ FRAMED TERRACOTTA ~~ //
        add(GufyUtil.familyBuilder("oak_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(GufyUtil.familyBuilder("spruce_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(GufyUtil.familyBuilder("birch_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(GufyUtil.familyBuilder("dark_oak_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(GufyUtil.familyBuilder("jungle_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(GufyUtil.familyBuilder("acacia_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(GufyUtil.familyBuilder("mangrove_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(GufyUtil.familyBuilder("cherry_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(GufyUtil.familyBuilder("bamboo_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(GufyUtil.familyBuilder("crimson_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(GufyUtil.familyBuilder("warped_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(GufyUtil.familyBuilder("mushroom_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));

        // ~~ COPPER ~~ //
        add(GufyUtil.familyBuilder("copper", GufyMaterials.COPPER, GufyWeathering.WeatherState.UNAFFECTED, COPPER_TYPES));
        add(GufyUtil.familyBuilder("exposed_copper", GufyMaterials.EXPOSED_COPPER, GufyWeathering.WeatherState.EXPOSED, COPPER_TYPES));
        add(GufyUtil.familyBuilder("weathered_copper", GufyMaterials.WEATHERED_COPPER, GufyWeathering.WeatherState.WEATHERED, COPPER_TYPES));
        add(GufyUtil.familyBuilder("oxidized_copper", GufyMaterials.OXIDIZED_COPPER, GufyWeathering.WeatherState.OXIDIZED, COPPER_TYPES));
        add(GufyUtil.familyBuilder("cut_copper", GufyMaterials.COPPER, GufyWeathering.WeatherState.UNAFFECTED, CUT_COPPER_TYPES));
        add(GufyUtil.familyBuilder("exposed_cut_copper", GufyMaterials.EXPOSED_COPPER, GufyWeathering.WeatherState.EXPOSED, CUT_COPPER_TYPES));
        add(GufyUtil.familyBuilder("weathered_cut_copper", GufyMaterials.WEATHERED_COPPER, GufyWeathering.WeatherState.WEATHERED, CUT_COPPER_TYPES));
        add(GufyUtil.familyBuilder("oxidized_cut_copper", GufyMaterials.OXIDIZED_COPPER, GufyWeathering.WeatherState.OXIDIZED, CUT_COPPER_TYPES));
        add(GufyUtil.familyBuilder("waxed_copper", GufyMaterials.COPPER, WAXED_COPPER_TYPES));
        add(GufyUtil.familyBuilder("waxed_exposed_copper", GufyMaterials.EXPOSED_COPPER, WAXED_COPPER_TYPES));
        add(GufyUtil.familyBuilder("waxed_weathered_copper", GufyMaterials.WEATHERED_COPPER, WAXED_COPPER_TYPES));
        add(GufyUtil.familyBuilder("waxed_oxidized_copper", GufyMaterials.OXIDIZED_COPPER, WAXED_COPPER_TYPES));
        add(GufyUtil.familyBuilder("waxed_cut_copper", GufyMaterials.COPPER, WAXED_CUT_COPPER_TYPES));
        add(GufyUtil.familyBuilder("waxed_exposed_cut_copper", GufyMaterials.EXPOSED_COPPER, WAXED_CUT_COPPER_TYPES));
        add(GufyUtil.familyBuilder("waxed_weathered_cut_copper", GufyMaterials.WEATHERED_COPPER, WAXED_CUT_COPPER_TYPES));
        add(GufyUtil.familyBuilder("waxed_oxidized_cut_copper", GufyMaterials.OXIDIZED_COPPER, WAXED_CUT_COPPER_TYPES));

        // ~~ SEATS ~~ //
        add(GufyUtil.familyBuilder("seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(GufyUtil.familyBuilder("white_seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(GufyUtil.familyBuilder("light_gray_seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(GufyUtil.familyBuilder("gray_seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(GufyUtil.familyBuilder("black_seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(GufyUtil.familyBuilder("brown_seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(GufyUtil.familyBuilder("red_seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(GufyUtil.familyBuilder("orange_seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(GufyUtil.familyBuilder("yellow_seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(GufyUtil.familyBuilder("lime_seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(GufyUtil.familyBuilder("green_seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(GufyUtil.familyBuilder("cyan_seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(GufyUtil.familyBuilder("light_blue_seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(GufyUtil.familyBuilder("blue_seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(GufyUtil.familyBuilder("purple_seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(GufyUtil.familyBuilder("magenta_seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(GufyUtil.familyBuilder("pink_seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));

        // ~~ DEPRECATED BLOCKS ~~ //
        add(GufyUtil.familyBuilder("wagon_wheel", GufyMaterials.SPRUCE_TRAPDOOR, GufyBlockTypes.WAGONWHEEL)); // DEPRECATED
        add(GufyUtil.familyBuilder("mossy_oak", GufyMaterials.OAK, GUFY_WOOD_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("cracked_oak", GufyMaterials.OAK, GUFY_WOOD_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("mossy_spruce", GufyMaterials.SPRUCE, GUFY_WOOD_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("cracked_spruce", GufyMaterials.SPRUCE, GUFY_WOOD_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("mossy_birch", GufyMaterials.BIRCH, GUFY_WOOD_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("cracked_birch", GufyMaterials.BIRCH, GUFY_WOOD_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("mossy_dark_oak", GufyMaterials.DARK_OAK, GUFY_WOOD_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("cracked_dark_oak", GufyMaterials.DARK_OAK, GUFY_WOOD_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("mossy_jungle", GufyMaterials.JUNGLE, GUFY_WOOD_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("cracked_jungle", GufyMaterials.JUNGLE, GUFY_WOOD_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("mossy_acacia", GufyMaterials.ACACIA, GUFY_WOOD_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("cracked_acacia", GufyMaterials.ACACIA, GUFY_WOOD_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("mossy_crimson", GufyMaterials.CRIMSON, GUFY_WOOD_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("cracked_crimson", GufyMaterials.CRIMSON, GUFY_WOOD_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("mossy_warped", GufyMaterials.WARPED, GUFY_WOOD_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("cracked_warped", GufyMaterials.WARPED, GUFY_WOOD_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("diorite_cobble", GufyMaterials.DIORITE, GUFY_STONE_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("mossy_diorite_cobble", GufyMaterials.DIORITE, GUFY_STONE_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("oak_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("spruce_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("birch_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("dark_oak_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("jungle_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("acacia_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("crimson_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("warped_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("daub", GufyMaterials.DAUB, GUFY_DIRT_TYPES)); // DEPRECATED
        add(GufyUtil.familyBuilder("thatch", GufyMaterials.THATCH, GUFY_DIRT_TYPES)); // DEPRECATED
    }};
    //**************************************************************//



    //****************************ITEMS*****************************//
    public static final DeferredItem<Item> MOSS_CLUMP = ITEMS.register("moss_clump",
            () -> new GufyMossClump(new Item.Properties()));
    public static final DeferredItem<Item> HAMMER = ITEMS.register("hammer",
            () -> new GufyHammer(new Item.Properties().durability(216)));
    public static final DeferredHolder<EntityType<?>, EntityType<GufySeatEntity>> SEAT = ENTITIES.register("seat",
            () -> EntityType.Builder.<GufySeatEntity>of(GufySeatEntity::new, MobCategory.MISC).sized(0.0f, 0.0f).build(MODID + "seat"));

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
    public static <T extends Block>DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        BLOCKITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    //**************************************************************//
}
