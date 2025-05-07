package com.github.elwood612.gufyblocks;

import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyBlockTypes;
import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyWeathering;
import com.github.elwood612.gufyblocks.entities.GufySeatEntity;
import com.github.elwood612.gufyblocks.items.GufyHammer;
import com.github.elwood612.gufyblocks.items.GufyMossClump;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.github.elwood612.gufyblocks.GufyBlocks.MODID;
import static com.github.elwood612.gufyblocks.util.GufyUtil.familyBuilder;

public class GufyRegistry
{
    //***************************VARIABLES**************************//
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
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
        add(familyBuilder("wattle_fence", GufyMaterials.WATTLE, GufyBlockTypes.WATTLEFENCE));
        add(familyBuilder("oak", GufyMaterials.OAK, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilder("oak_parquet", GufyMaterials.OAK, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilder("big_oak", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(familyBuilder("oak_wood", GufyMaterials.OAK, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_oak_wood", GufyMaterials.OAK, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_oak_wood", GufyMaterials.OAK, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("spruce", GufyMaterials.SPRUCE, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilder("spruce_parquet", GufyMaterials.SPRUCE, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilder("big_spruce", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(familyBuilder("spruce_wood", GufyMaterials.SPRUCE, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_spruce_wood", GufyMaterials.SPRUCE, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_spruce_wood", GufyMaterials.SPRUCE, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("birch", GufyMaterials.BIRCH, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilder("birch_parquet", GufyMaterials.BIRCH, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilder("big_birch", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(familyBuilder("birch_wood", GufyMaterials.BIRCH, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_birch_wood", GufyMaterials.BIRCH, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_birch_wood", GufyMaterials.BIRCH, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("dark_oak", GufyMaterials.DARK_OAK, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilder("dark_oak_parquet", GufyMaterials.DARK_OAK, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilder("big_dark_oak", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(familyBuilder("dark_oak_wood", GufyMaterials.DARK_OAK, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_dark_oak_wood", GufyMaterials.DARK_OAK, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_dark_oak_wood", GufyMaterials.DARK_OAK, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("jungle", GufyMaterials.JUNGLE, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilder("jungle_parquet", GufyMaterials.OAK, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilder("big_jungle", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(familyBuilder("jungle_wood", GufyMaterials.JUNGLE, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_jungle_wood", GufyMaterials.JUNGLE, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_jungle_wood", GufyMaterials.JUNGLE, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("acacia", GufyMaterials.ACACIA, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilder("acacia_parquet", GufyMaterials.ACACIA, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilder("big_acacia", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(familyBuilder("acacia_wood", GufyMaterials.ACACIA, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_acacia_wood", GufyMaterials.ACACIA, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_acacia_wood", GufyMaterials.ACACIA, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("mangrove", GufyMaterials.MANGROVE, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilder("mangrove_parquet", GufyMaterials.MANGROVE, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilder("big_mangrove", GufyMaterials.MANGROVE, GUFY_WOOD_TYPES));
        add(familyBuilder("mangrove_wood", GufyMaterials.MANGROVE, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_mangrove_wood", GufyMaterials.MANGROVE, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_mangrove_wood", GufyMaterials.MANGROVE, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("cherry", GufyMaterials.CHERRY, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilder("cherry_parquet", GufyMaterials.CHERRY, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilder("big_cherry", GufyMaterials.CHERRY, GUFY_WOOD_TYPES));
        add(familyBuilder("cherry_wood", GufyMaterials.CHERRY, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_cherry_wood", GufyMaterials.CHERRY, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_cherry_wood", GufyMaterials.CHERRY, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("bamboo", GufyMaterials.BAMBOO, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilder("bamboo_mosaic", GufyMaterials.BAMBOO, GufyBlockTypes.VERTICALSLAB));
        add(familyBuilder("chiseled_stripped_bamboo_block", GufyMaterials.BAMBOO, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("crimson", GufyMaterials.CRIMSON, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilder("crimson_parquet", GufyMaterials.CRIMSON, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilder("big_crimson", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(familyBuilder("crimson_hyphae", GufyMaterials.CRIMSON, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_crimson_hyphae", GufyMaterials.CRIMSON, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_crimson_hyphae", GufyMaterials.CRIMSON, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("warped", GufyMaterials.WARPED, ArrayUtils.addAll(VANILLA_WOOD_TYPES)));
        add(familyBuilder("warped_parquet", GufyMaterials.WARPED, ArrayUtils.addAll(GUFY_DIRT_TYPES)));
        add(familyBuilder("big_warped", GufyMaterials.OAK, GUFY_WOOD_TYPES));
        add(familyBuilder("warped_hyphae", GufyMaterials.WARPED, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_warped_hyphae", GufyMaterials.WARPED, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_warped_hyphae", GufyMaterials.WARPED, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("mushroom_stem", GufyMaterials.MUSHROOM, ArrayUtils.addAll(VANILLA_WOOD_TYPES_ALL, GufyBlockTypes.TRAPDOOR)));

        // ~~ DIRTS ~~ //
        add(familyBuilder("coarse_dirt", GufyMaterials.DIRT, VANILLA_DIRT_TYPES));
        add(familyBuilder("packed_mud", GufyMaterials.PACKED_MUD, VANILLA_DIRT_TYPES));
        add(familyBuilder("mud_bricks", GufyMaterials.MUD_BRICKS, VANILLA_STONE_TYPES));
        add(familyBuilder("hay", GufyMaterials.THATCH, VANILLA_DIRT_TYPES));
        add(familyBuilder("moss", GufyMaterials.MOSS, VANILLA_DIRT_TYPES));
        add(familyBuilder("rooted_dirt", GufyMaterials.ROOTED_DIRT, VANILLA_DIRT_TYPES));
        add(familyBuilder("nether_wart_block", GufyMaterials.NETHER_WART, VANILLA_DIRT_TYPES));
        add(familyBuilder("warped_wart", GufyMaterials.WARPED_WART, VANILLA_DIRT_TYPES));
        add(familyBuilder("snow", GufyMaterials.SNOW, VANILLA_DIRT_TYPES));
        add(familyBuilder("packed_ice", GufyMaterials.ICE, PACKED_ICE_TYPES));

        // ~~ STONES ~~ //
        add(familyBuilder("stone", GufyMaterials.STONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("smooth_stone", GufyMaterials.STONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL, GufyBlockTypes.STAIRS)));
        add(familyBuilder("cobblestone", GufyMaterials.COBBLESTONE, VANILLA_STONE_TYPES));
        add(familyBuilder("mossy_cobblestone", GufyMaterials.COBBLESTONE, VANILLA_STONE_TYPES));
        add(familyBuilder("cobblestone_bricks", GufyMaterials.STONE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_cobblestone_bricks", GufyMaterials.STONE, GUFY_STONE_TYPES));
        add(familyBuilder("cracked_cobblestone_bricks", GufyMaterials.STONE, GUFY_STONE_TYPES));
        add(familyBuilder("stone_bricks", GufyMaterials.STONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(familyBuilder("mossy_stone_bricks", GufyMaterials.STONE, VANILLA_STONE_TYPES));
        add(familyBuilder("cracked_stone_bricks", GufyMaterials.STONE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("diorite", GufyMaterials.DIORITE, VANILLA_STONE_TYPES));
        add(familyBuilder("polished_diorite", GufyMaterials.DIORITE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("diorite_bricks", GufyMaterials.DIORITE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR, GufyBlockTypes.CHISELED)));
        add(familyBuilder("mossy_diorite_bricks", GufyMaterials.DIORITE, GUFY_STONE_TYPES));
        add(familyBuilder("cracked_diorite_bricks", GufyMaterials.DIORITE, GUFY_STONE_TYPES));
        add(familyBuilder("diorite_cobble_bricks", GufyMaterials.DIORITE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_diorite_cobble_bricks", GufyMaterials.DIORITE, GUFY_STONE_TYPES));
        add(familyBuilder("cracked_diorite_cobble_bricks", GufyMaterials.DIORITE, GUFY_STONE_TYPES));
        add(familyBuilder("granite", GufyMaterials.GRANITE, VANILLA_STONE_TYPES));
        add(familyBuilder("polished_granite", GufyMaterials.GRANITE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("granite_bricks", GufyMaterials.GRANITE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR, GufyBlockTypes.CHISELED)));
        add(familyBuilder("cracked_granite_bricks", GufyMaterials.GRANITE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_granite_bricks", GufyMaterials.GRANITE, GUFY_STONE_TYPES));
        add(familyBuilder("granite_cobble_bricks", GufyMaterials.GRANITE, GUFY_STONE_TYPES));
        add(familyBuilder("cracked_granite_cobble_bricks", GufyMaterials.GRANITE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_granite_cobble_bricks", GufyMaterials.GRANITE, GUFY_STONE_TYPES));
        add(familyBuilder("andesite", GufyMaterials.ANDESITE, VANILLA_STONE_TYPES));
        add(familyBuilder("polished_andesite", GufyMaterials.ANDESITE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("andesite_bricks", GufyMaterials.ANDESITE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR, GufyBlockTypes.CHISELED)));
        add(familyBuilder("cracked_andesite_bricks", GufyMaterials.ANDESITE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_andesite_bricks", GufyMaterials.ANDESITE, GUFY_STONE_TYPES));
        add(familyBuilder("brick", GufyMaterials.BRICK, VANILLA_STONE_TYPES));
        add(familyBuilder("cracked_bricks", GufyMaterials.BRICK, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_bricks", GufyMaterials.BRICK, GUFY_STONE_TYPES));
        add(familyBuilder("nether_brick", GufyMaterials.NETHER_BRICKS, GufyBlockTypes.VERTICALSLAB, GufyBlockTypes.HOPPER));
        add(familyBuilder("cracked_nether_bricks", GufyMaterials.NETHER_BRICKS,
                GufyBlockTypes.STAIRS, GufyBlockTypes.SLAB, GufyBlockTypes.WALL, GufyBlockTypes.VERTICALSLAB, GufyBlockTypes.HOPPER, GufyBlockTypes.FENCE));
        add(familyBuilder("red_nether_bricks", GufyMaterials.NETHER_BRICKS, VANILLA_STONE_TYPES));
        add(familyBuilder("calcite", GufyMaterials.CALCITE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("tuff", GufyMaterials.TUFF, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("tuff_bricks", GufyMaterials.TUFF, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(familyBuilder("polished_tuff", GufyMaterials.TUFF, VANILLA_STONE_TYPES));
        add(familyBuilder("smooth_basalt", GufyMaterials.BASALT, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("deepslate", GufyMaterials.COBBLED_DEEPSLATE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("cobbled_deepslate", GufyMaterials.COBBLED_DEEPSLATE, VANILLA_STONE_TYPES));
        add(familyBuilder("mossy_cobbled_deepslate", GufyMaterials.COBBLED_DEEPSLATE, GUFY_STONE_TYPES));
        add(familyBuilder("deepslate_bricks", GufyMaterials.DEEPSLATE_BRICK, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(familyBuilder("deepslate_tiles", GufyMaterials.TILED_DEEPSLATE, VANILLA_STONE_TYPES));
        add(familyBuilder("polished_deepslate", GufyMaterials.POLISHED_DEEPSLATE, VANILLA_STONE_TYPES));
        add(familyBuilder("cracked_deepslate_bricks", GufyMaterials.DEEPSLATE_BRICK, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("cracked_deepslate_tiles", GufyMaterials.TILED_DEEPSLATE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("mossy_deepslate_bricks", GufyMaterials.DEEPSLATE_BRICK, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_deepslate_tiles", GufyMaterials.TILED_DEEPSLATE, GUFY_STONE_TYPES));
        add(familyBuilder("quartz", GufyMaterials.QUARTZ, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("smooth_quartz", GufyMaterials.QUARTZ, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("quartz_bricks", GufyMaterials.QUARTZ, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("iron", GufyMaterials.IRON, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("gold", GufyMaterials.GOLD, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("emerald", GufyMaterials.EMERALD, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("diamond", GufyMaterials.DIAMOND, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("sandstone", GufyMaterials.SANDSTONE, VANILLA_STONE_TYPES));
        add(familyBuilder("cut_sandstone", GufyMaterials.SANDSTONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("smooth_sandstone", GufyMaterials.SMOOTH_SANDSTONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("sandstone_bricks", GufyMaterials.SANDSTONE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(familyBuilder("cracked_sandstone_bricks", GufyMaterials.SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_sandstone_bricks", GufyMaterials.SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("sandstone_cobble_bricks", GufyMaterials.SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("cracked_sandstone_cobble_bricks", GufyMaterials.SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_sandstone_cobble_bricks", GufyMaterials.SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("red_sandstone", GufyMaterials.RED_SANDSTONE, VANILLA_STONE_TYPES));
        add(familyBuilder("cut_red_sandstone", GufyMaterials.RED_SANDSTONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("smooth_red_sandstone", GufyMaterials.SMOOTH_RED_SANDSTONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("red_sandstone_bricks", GufyMaterials.RED_SANDSTONE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(familyBuilder("cracked_red_sandstone_bricks", GufyMaterials.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_red_sandstone_bricks", GufyMaterials.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("red_sandstone_cobble_bricks", GufyMaterials.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("cracked_red_sandstone_cobble_bricks", GufyMaterials.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_red_sandstone_cobble_bricks", GufyMaterials.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("amethyst", GufyMaterials.AMETHYST, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("end_stone", GufyMaterials.END_STONE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("end_stone_brick", GufyMaterials.END_STONE, VANILLA_STONE_TYPES));
        add(familyBuilder("purpur", GufyMaterials.PURPUR, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("blackstone", GufyMaterials.BLACKSTONE, VANILLA_STONE_TYPES));
        add(familyBuilder("polished_blackstone", GufyMaterials.POLISHED_BLACKSTONE, VANILLA_STONE_TYPES));
        add(familyBuilder("polished_blackstone_brick", GufyMaterials.BLACKSTONE, VANILLA_STONE_TYPES));
        add(familyBuilder("cracked_polished_blackstone_brick", GufyMaterials.BLACKSTONE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("gilded_blackstone", GufyMaterials.GILDED_BLACKSTONE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("dripstone", GufyMaterials.DRIPSTONE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("stone", GufyMaterials.STONE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilder("diorite", GufyMaterials.DIORITE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilder("andesite", GufyMaterials.ANDESITE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilder("granite", GufyMaterials.GRANITE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilder("cobbled_deepslate", GufyMaterials.COBBLED_DEEPSLATE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilder("sandstone", GufyMaterials.SANDSTONE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilder("red_sandstone", GufyMaterials.RED_SANDSTONE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilder("prismarine", GufyMaterials.PRISMARINE, VANILLA_STONE_TYPES));
        add(familyBuilder("prismarine_bricks", GufyMaterials.PRISMARINE_BRICKS, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("dark_prismarine", GufyMaterials.PRISMARINE_BRICKS, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));

        // ~~ TERRACOTTA ~~ //
        add(familyBuilder("terracotta", GufyMaterials.TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("white_terracotta", GufyMaterials.WHITE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("light_gray_terracotta", GufyMaterials.LIGHT_GRAY_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("gray_terracotta", GufyMaterials.GRAY_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("black_terracotta", GufyMaterials.BLACK_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("brown_terracotta", GufyMaterials.BROWN_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("red_terracotta", GufyMaterials.RED_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("orange_terracotta", GufyMaterials.ORANGE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("yellow_terracotta", GufyMaterials.YELLOW_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("lime_terracotta", GufyMaterials.LIME_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("green_terracotta", GufyMaterials.GREEN_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("cyan_terracotta", GufyMaterials.CYAN_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("light_blue_terracotta", GufyMaterials.LIGHT_BLUE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("blue_terracotta", GufyMaterials.BLUE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("purple_terracotta", GufyMaterials.PURPLE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("magenta_terracotta", GufyMaterials.MAGENTA_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("pink_terracotta", GufyMaterials.PINK_TERRACOTTA, VANILLA_STONE_TYPES_ALL));

        // ~~ CONCRETE ~~ //
        add(familyBuilder("white_concrete", GufyMaterials.WHITE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("light_gray_concrete", GufyMaterials.LIGHT_GRAY_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("gray_concrete", GufyMaterials.GRAY_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("black_concrete", GufyMaterials.BLACK_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("brown_concrete", GufyMaterials.BROWN_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("red_concrete", GufyMaterials.RED_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("orange_concrete", GufyMaterials.ORANGE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("yellow_concrete", GufyMaterials.YELLOW_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("lime_concrete", GufyMaterials.LIME_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("green_concrete", GufyMaterials.GREEN_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("cyan_concrete", GufyMaterials.CYAN_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("light_blue_concrete", GufyMaterials.LIGHT_BLUE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("blue_concrete", GufyMaterials.BLUE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("purple_concrete", GufyMaterials.PURPLE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("magenta_concrete", GufyMaterials.MAGENTA_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("pink_concrete", GufyMaterials.PINK_CONCRETE, VANILLA_STONE_TYPES_ALL));

        // ~~ WOOL ~~ //
        add(familyBuilder("white_wool", GufyMaterials.WHITE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("light_gray_wool", GufyMaterials.LIGHT_GRAY_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("gray_wool", GufyMaterials.GRAY_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("black_wool", GufyMaterials.BLACK_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("brown_wool", GufyMaterials.BROWN_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("red_wool", GufyMaterials.RED_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("orange_wool", GufyMaterials.ORANGE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("yellow_wool", GufyMaterials.YELLOW_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("lime_wool", GufyMaterials.LIME_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("green_wool", GufyMaterials.GREEN_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("cyan_wool", GufyMaterials.CYAN_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("light_blue_wool", GufyMaterials.LIGHT_BLUE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("blue_wool", GufyMaterials.BLUE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("purple_wool", GufyMaterials.PURPLE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("magenta_wool", GufyMaterials.MAGENTA_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("pink_wool", GufyMaterials.PINK_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));

        // ~~ GLASS ~~ //
        add(familyBuilder("leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("white_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("light_gray_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("gray_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("black_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("brown_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("red_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("orange_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("yellow_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("lime_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("green_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("cyan_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("light_blue_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("blue_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("purple_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("magenta_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("pink_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("oakfield_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("avalon_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("gufy_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("midland_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("ring_leaded_glass", GufyMaterials.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("oak_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("spruce_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("birch_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("dark_oak_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("jungle_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("acacia_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("mangrove_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("cherry_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("bamboo_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("crimson_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("warped_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("mushroom_framed_glass", GufyMaterials.FRAMED_GLASS, GufyBlockTypes.PANE));

        // ~~ FRAMED TERRACOTTA ~~ //
        add(familyBuilder("oak_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilder("spruce_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilder("birch_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilder("dark_oak_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilder("jungle_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilder("acacia_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilder("mangrove_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilder("cherry_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilder("bamboo_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilder("crimson_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilder("warped_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));
        add(familyBuilder("mushroom_framed_terracotta", GufyMaterials.FRAMED_WHITE, FRAMED_BLOCK_TYPES));

        // ~~ COPPER ~~ //
        add(familyBuilder("copper", GufyMaterials.COPPER, GufyWeathering.WeatherState.UNAFFECTED, COPPER_TYPES));
        add(familyBuilder("exposed_copper", GufyMaterials.EXPOSED_COPPER, GufyWeathering.WeatherState.EXPOSED, COPPER_TYPES));
        add(familyBuilder("weathered_copper", GufyMaterials.WEATHERED_COPPER, GufyWeathering.WeatherState.WEATHERED, COPPER_TYPES));
        add(familyBuilder("oxidized_copper", GufyMaterials.OXIDIZED_COPPER, GufyWeathering.WeatherState.OXIDIZED, COPPER_TYPES));
        add(familyBuilder("cut_copper", GufyMaterials.COPPER, GufyWeathering.WeatherState.UNAFFECTED, CUT_COPPER_TYPES));
        add(familyBuilder("exposed_cut_copper", GufyMaterials.EXPOSED_COPPER, GufyWeathering.WeatherState.EXPOSED, CUT_COPPER_TYPES));
        add(familyBuilder("weathered_cut_copper", GufyMaterials.WEATHERED_COPPER, GufyWeathering.WeatherState.WEATHERED, CUT_COPPER_TYPES));
        add(familyBuilder("oxidized_cut_copper", GufyMaterials.OXIDIZED_COPPER, GufyWeathering.WeatherState.OXIDIZED, CUT_COPPER_TYPES));
        add(familyBuilder("waxed_copper", GufyMaterials.COPPER, WAXED_COPPER_TYPES));
        add(familyBuilder("waxed_exposed_copper", GufyMaterials.EXPOSED_COPPER, WAXED_COPPER_TYPES));
        add(familyBuilder("waxed_weathered_copper", GufyMaterials.WEATHERED_COPPER, WAXED_COPPER_TYPES));
        add(familyBuilder("waxed_oxidized_copper", GufyMaterials.OXIDIZED_COPPER, WAXED_COPPER_TYPES));
        add(familyBuilder("waxed_cut_copper", GufyMaterials.COPPER, WAXED_CUT_COPPER_TYPES));
        add(familyBuilder("waxed_exposed_cut_copper", GufyMaterials.EXPOSED_COPPER, WAXED_CUT_COPPER_TYPES));
        add(familyBuilder("waxed_weathered_cut_copper", GufyMaterials.WEATHERED_COPPER, WAXED_CUT_COPPER_TYPES));
        add(familyBuilder("waxed_oxidized_cut_copper", GufyMaterials.OXIDIZED_COPPER, WAXED_CUT_COPPER_TYPES));

        // ~~ SEATS ~~ //
        add(familyBuilder("seat", GufyMaterials.OAK, GufyBlockTypes.SEAT));
        add(familyBuilder("white_seat", GufyMaterials.WHITE_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("light_gray_seat", GufyMaterials.LIGHT_GRAY_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("gray_seat", GufyMaterials.GRAY_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("black_seat", GufyMaterials.BLACK_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("brown_seat", GufyMaterials.BROWN_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("red_seat", GufyMaterials.RED_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("orange_seat", GufyMaterials.ORANGE_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("yellow_seat", GufyMaterials.YELLOW_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("lime_seat", GufyMaterials.LIME_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("green_seat", GufyMaterials.GREEN_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("cyan_seat", GufyMaterials.CYAN_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("light_blue_seat", GufyMaterials.LIGHT_BLUE_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("blue_seat", GufyMaterials.BLUE_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("purple_seat", GufyMaterials.PURPLE_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("magenta_seat", GufyMaterials.MAGENTA_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("pink_seat", GufyMaterials.PINK_SEAT, GufyBlockTypes.SEAT));

        // ~~ DEPRECATED BLOCKS ~~ //
        add(familyBuilder("wagon_wheel", GufyMaterials.SPRUCE_TRAPDOOR, GufyBlockTypes.WAGONWHEEL)); // DEPRECATED
        add(familyBuilder("mossy_oak", GufyMaterials.OAK, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("cracked_oak", GufyMaterials.OAK, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("mossy_spruce", GufyMaterials.SPRUCE, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("cracked_spruce", GufyMaterials.SPRUCE, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("mossy_birch", GufyMaterials.BIRCH, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("cracked_birch", GufyMaterials.BIRCH, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("mossy_dark_oak", GufyMaterials.DARK_OAK, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("cracked_dark_oak", GufyMaterials.DARK_OAK, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("mossy_jungle", GufyMaterials.JUNGLE, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("cracked_jungle", GufyMaterials.JUNGLE, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("mossy_acacia", GufyMaterials.ACACIA, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("cracked_acacia", GufyMaterials.ACACIA, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("mossy_crimson", GufyMaterials.CRIMSON, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("cracked_crimson", GufyMaterials.CRIMSON, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("mossy_warped", GufyMaterials.WARPED, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("cracked_warped", GufyMaterials.WARPED, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("diorite_cobble", GufyMaterials.DIORITE, GUFY_STONE_TYPES)); // DEPRECATED
        add(familyBuilder("mossy_diorite_cobble", GufyMaterials.DIORITE, GUFY_STONE_TYPES)); // DEPRECATED
        add(familyBuilder("oak_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilder("spruce_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilder("birch_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilder("dark_oak_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilder("jungle_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilder("acacia_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilder("crimson_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilder("warped_framed_daub", GufyMaterials.FRAMED_BROWN, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilder("daub", GufyMaterials.DAUB, GUFY_DIRT_TYPES)); // DEPRECATED
        add(familyBuilder("thatch", GufyMaterials.THATCH, GUFY_DIRT_TYPES)); // DEPRECATED
    }};
    //**************************************************************//



    //****************************ITEMS*****************************//
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
    public static <T extends Block>DeferredBlock<T> createRegistry(String name, Supplier<T> blockSupplier, BlockBehaviour.Properties blockProperties)
    {
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, name));
        blockProperties.setId(blockKey);

        DeferredBlock<T> block = BLOCKS.register(name, blockSupplier);
        ITEMS.registerSimpleBlockItem(name, block, new Item.Properties());

        return block;
    }
    //**************************************************************//
}
