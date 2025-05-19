package com.github.elwood612.gufyblocks;

import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyBlockTypes;
import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyWeathering;
import com.github.elwood612.gufyblocks.entities.GufySeatEntity;
import com.github.elwood612.gufyblocks.items.GufyHammer;
import com.github.elwood612.gufyblocks.items.GufyMossClump;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyProperties;
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
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.github.elwood612.gufyblocks.GufyBlocks.MODID;
import static com.github.elwood612.gufyblocks.util.GufyUtil.*;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy;


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
    //**************************************************************//


    //***************************BLOCKLIST**************************//

    public static final List<List<DeferredBlock<Block>>> newBlockList = new ArrayList<List<DeferredBlock<Block>>>()
    {{
        // ~~ WOOD ~~ //
        add(familyBuilder("oak", Blocks.OAK_PLANKS, VANILLA_WOOD_TYPES));
        add(familyBuilder("oak_parquet", Blocks.OAK_PLANKS, GUFY_DIRT_TYPES));
        add(familyBuilder("big_oak", Blocks.OAK_PLANKS, GUFY_WOOD_TYPES));
        add(familyBuilder("oak_wood", Blocks.OAK_WOOD, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_oak_wood", Blocks.OAK_WOOD, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_oak_wood", Blocks.OAK_WOOD, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("spruce", Blocks.SPRUCE_PLANKS, VANILLA_WOOD_TYPES));
        add(familyBuilder("spruce_parquet", Blocks.SPRUCE_PLANKS, GUFY_DIRT_TYPES));
        add(familyBuilder("big_spruce", Blocks.SPRUCE_PLANKS, GUFY_WOOD_TYPES));
        add(familyBuilder("spruce_wood", Blocks.SPRUCE_WOOD, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_spruce_wood", Blocks.SPRUCE_WOOD, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_spruce_wood", Blocks.SPRUCE_WOOD, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("birch", Blocks.BIRCH_PLANKS, VANILLA_WOOD_TYPES));
        add(familyBuilder("birch_parquet", Blocks.BIRCH_PLANKS, GUFY_DIRT_TYPES));
        add(familyBuilder("big_birch", Blocks.BIRCH_PLANKS, GUFY_WOOD_TYPES));
        add(familyBuilder("birch_wood", Blocks.BIRCH_WOOD, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_birch_wood", Blocks.BIRCH_WOOD, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_birch_wood", Blocks.BIRCH_WOOD, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("dark_oak", Blocks.DARK_OAK_PLANKS, VANILLA_WOOD_TYPES));
        add(familyBuilder("dark_oak_parquet", Blocks.DARK_OAK_PLANKS, GUFY_DIRT_TYPES));
        add(familyBuilder("big_dark_oak", Blocks.DARK_OAK_PLANKS, GUFY_WOOD_TYPES));
        add(familyBuilder("dark_oak_wood", Blocks.DARK_OAK_WOOD, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_dark_oak_wood", Blocks.DARK_OAK_WOOD, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_dark_oak_wood", Blocks.DARK_OAK_WOOD, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("jungle", Blocks.JUNGLE_PLANKS, VANILLA_WOOD_TYPES));
        add(familyBuilder("jungle_parquet", Blocks.JUNGLE_PLANKS, GUFY_DIRT_TYPES));
        add(familyBuilder("big_jungle", Blocks.JUNGLE_PLANKS, GUFY_WOOD_TYPES));
        add(familyBuilder("jungle_wood", Blocks.JUNGLE_WOOD, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_jungle_wood", Blocks.JUNGLE_WOOD, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_jungle_wood", Blocks.JUNGLE_WOOD, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("acacia", Blocks.ACACIA_PLANKS, VANILLA_WOOD_TYPES));
        add(familyBuilder("acacia_parquet", Blocks.ACACIA_PLANKS, GUFY_DIRT_TYPES));
        add(familyBuilder("big_acacia", Blocks.ACACIA_PLANKS, GUFY_WOOD_TYPES));
        add(familyBuilder("acacia_wood", Blocks.ACACIA_WOOD, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_acacia_wood", Blocks.ACACIA_WOOD, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_acacia_wood", Blocks.ACACIA_WOOD, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("mangrove", Blocks.MANGROVE_PLANKS, VANILLA_WOOD_TYPES));
        add(familyBuilder("mangrove_parquet", Blocks.MANGROVE_PLANKS, GUFY_DIRT_TYPES));
        add(familyBuilder("big_mangrove", Blocks.MANGROVE_PLANKS, GUFY_WOOD_TYPES));
        add(familyBuilder("mangrove_wood", Blocks.MANGROVE_WOOD, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_mangrove_wood", Blocks.MANGROVE_WOOD, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_mangrove_wood", Blocks.MANGROVE_WOOD, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("cherry", Blocks.CHERRY_PLANKS, VANILLA_WOOD_TYPES));
        add(familyBuilder("cherry_parquet", Blocks.CHERRY_PLANKS, GUFY_DIRT_TYPES));
        add(familyBuilder("big_cherry", Blocks.CHERRY_PLANKS, GUFY_WOOD_TYPES));
        add(familyBuilder("cherry_wood", Blocks.CHERRY_WOOD, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_cherry_wood", Blocks.CHERRY_WOOD, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_cherry_wood", Blocks.CHERRY_WOOD, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("bamboo", Blocks.BAMBOO_PLANKS, VANILLA_WOOD_TYPES));
        add(familyBuilder("bamboo_mosaic", Blocks.BAMBOO_PLANKS, GufyBlockTypes.VERTICALSLAB));
        add(familyBuilder("chiseled_stripped_bamboo_block", Blocks.STRIPPED_BAMBOO_BLOCK, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("crimson", Blocks.CRIMSON_PLANKS, VANILLA_WOOD_TYPES));
        add(familyBuilder("crimson_parquet", Blocks.CRIMSON_PLANKS, GUFY_DIRT_TYPES));
        add(familyBuilder("big_crimson", Blocks.CRIMSON_PLANKS, GUFY_WOOD_TYPES));
        add(familyBuilder("crimson_hyphae", Blocks.CRIMSON_HYPHAE, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_crimson_hyphae", Blocks.CRIMSON_HYPHAE, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_crimson_hyphae", Blocks.CRIMSON_HYPHAE, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("warped", Blocks.WARPED_PLANKS, VANILLA_WOOD_TYPES));
        add(familyBuilder("warped_parquet", Blocks.WARPED_PLANKS, GUFY_DIRT_TYPES));
        add(familyBuilder("big_warped", Blocks.WARPED_PLANKS, GUFY_WOOD_TYPES));
        add(familyBuilder("warped_hyphae", Blocks.WARPED_HYPHAE, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_warped_hyphae", Blocks.WARPED_HYPHAE, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_warped_hyphae", Blocks.WARPED_HYPHAE, GufyBlockTypes.CARVED_LOG));
        add(familyBuilder("pale_oak", Blocks.PALE_OAK_PLANKS, VANILLA_WOOD_TYPES));
        add(familyBuilder("pale_oak_parquet", Blocks.PALE_OAK_PLANKS, GUFY_DIRT_TYPES));
        add(familyBuilder("big_pale_oak", Blocks.PALE_OAK_PLANKS, GUFY_WOOD_TYPES));
        add(familyBuilder("pale_oak_wood", Blocks.PALE_OAK_WOOD, VANILLA_STRIPPABLE_WOOD_TYPES_ALL));
        add(familyBuilder("stripped_pale_oak_wood", Blocks.PALE_OAK_WOOD, VANILLA_WOOD_TYPES_ALL));
        add(familyBuilder("chiseled_stripped_pale_oak_wood", Blocks.PALE_OAK_WOOD, GufyBlockTypes.CARVED_LOG));

        // ~~ DIRTS ~~ //
        add(familyBuilder("coarse_dirt", Blocks.COARSE_DIRT, VANILLA_DIRT_TYPES));
        add(familyBuilder("packed_mud", Blocks.PACKED_MUD, VANILLA_DIRT_TYPES));
        add(familyBuilder("mud_bricks", Blocks.MUD_BRICKS, VANILLA_STONE_TYPES));
        add(familyBuilder("hay", Blocks.HAY_BLOCK, VANILLA_DIRT_TYPES));
        add(familyBuilder("moss", Blocks.MOSS_BLOCK, VANILLA_DIRT_TYPES));
        add(familyBuilder("pale_moss", Blocks.PALE_MOSS_BLOCK, VANILLA_DIRT_TYPES));
        add(familyBuilder("rooted_dirt", Blocks.ROOTED_DIRT, VANILLA_DIRT_TYPES));
        add(familyBuilder("nether_wart_block", Blocks.NETHER_WART_BLOCK, VANILLA_DIRT_TYPES));
        add(familyBuilder("warped_wart", Blocks.WARPED_WART_BLOCK, VANILLA_DIRT_TYPES));
        add(familyBuilder("snow", Blocks.SNOW_BLOCK, VANILLA_DIRT_TYPES));
        add(familyBuilder("packed_ice", Blocks.PACKED_ICE, VANILLA_DIRT_TYPES));
        add(familyBuilder("resin", Blocks.RESIN_BLOCK, VANILLA_DIRT_TYPES));
        add(familyBuilder("resin_bricks", Blocks.RESIN_BRICKS, VANILLA_STONE_TYPES));

        // ~~ STONES ~~ //
        add(familyBuilder("stone", Blocks.STONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("smooth_stone", Blocks.SMOOTH_STONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL, GufyBlockTypes.STAIRS)));
        add(familyBuilder("cobblestone", Blocks.COBBLESTONE, VANILLA_STONE_TYPES));
        add(familyBuilder("mossy_cobblestone", Blocks.MOSSY_COBBLESTONE, VANILLA_STONE_TYPES));
        add(familyBuilder("cobblestone_bricks", Blocks.STONE_BRICKS, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_cobblestone_bricks", Blocks.MOSSY_STONE_BRICKS, GUFY_STONE_TYPES));
        add(familyBuilder("cracked_cobblestone_bricks", Blocks.CRACKED_STONE_BRICKS, GUFY_STONE_TYPES));
        add(familyBuilder("stone_bricks", Blocks.STONE_BRICKS, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(familyBuilder("mossy_stone_bricks", Blocks.MOSSY_STONE_BRICKS, VANILLA_STONE_TYPES));
        add(familyBuilder("cracked_stone_bricks", Blocks.CRACKED_STONE_BRICKS, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("diorite", Blocks.DIORITE, VANILLA_STONE_TYPES));
        add(familyBuilder("polished_diorite", Blocks.POLISHED_DIORITE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("diorite_bricks", Blocks.DIORITE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR, GufyBlockTypes.CHISELED)));
        add(familyBuilder("mossy_diorite_bricks", Blocks.DIORITE, GUFY_STONE_TYPES));
        add(familyBuilder("cracked_diorite_bricks", Blocks.DIORITE, GUFY_STONE_TYPES));
        add(familyBuilder("diorite_cobble_bricks", Blocks.DIORITE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_diorite_cobble_bricks", Blocks.DIORITE, GUFY_STONE_TYPES));
        add(familyBuilder("cracked_diorite_cobble_bricks", Blocks.DIORITE, GUFY_STONE_TYPES));
        add(familyBuilder("granite", Blocks.GRANITE, VANILLA_STONE_TYPES));
        add(familyBuilder("polished_granite", Blocks.GRANITE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("granite_bricks", Blocks.GRANITE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR, GufyBlockTypes.CHISELED)));
        add(familyBuilder("cracked_granite_bricks", Blocks.GRANITE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_granite_bricks", Blocks.GRANITE, GUFY_STONE_TYPES));
        add(familyBuilder("granite_cobble_bricks", Blocks.GRANITE, GUFY_STONE_TYPES));
        add(familyBuilder("cracked_granite_cobble_bricks", Blocks.GRANITE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_granite_cobble_bricks", Blocks.GRANITE, GUFY_STONE_TYPES));
        add(familyBuilder("andesite", Blocks.ANDESITE, VANILLA_STONE_TYPES));
        add(familyBuilder("polished_andesite", Blocks.ANDESITE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("andesite_bricks", Blocks.ANDESITE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR, GufyBlockTypes.CHISELED)));
        add(familyBuilder("cracked_andesite_bricks", Blocks.ANDESITE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_andesite_bricks", Blocks.ANDESITE, GUFY_STONE_TYPES));
        add(familyBuilder("brick", Blocks.BRICKS, VANILLA_STONE_TYPES));
        add(familyBuilder("cracked_bricks", Blocks.BRICKS, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_bricks", Blocks.BRICKS, GUFY_STONE_TYPES));
        add(familyBuilder("nether_brick", Blocks.NETHER_BRICKS, GufyBlockTypes.VERTICALSLAB, GufyBlockTypes.HOPPER));
        add(familyBuilder("cracked_nether_bricks", Blocks.NETHER_BRICKS,
                GufyBlockTypes.STAIRS, GufyBlockTypes.SLAB, GufyBlockTypes.WALL, GufyBlockTypes.VERTICALSLAB, GufyBlockTypes.HOPPER, GufyBlockTypes.FENCE));
        add(familyBuilder("red_nether_bricks", Blocks.RED_NETHER_BRICKS, VANILLA_STONE_TYPES));
        add(familyBuilder("calcite", Blocks.CALCITE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("tuff", Blocks.TUFF, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("tuff_bricks", Blocks.TUFF_BRICKS, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(familyBuilder("polished_tuff", Blocks.POLISHED_TUFF, VANILLA_STONE_TYPES));
        add(familyBuilder("smooth_basalt", Blocks.SMOOTH_BASALT, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("deepslate", Blocks.DEEPSLATE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("cobbled_deepslate", Blocks.COBBLED_DEEPSLATE, VANILLA_STONE_TYPES));
        add(familyBuilder("mossy_cobbled_deepslate", Blocks.COBBLED_DEEPSLATE, GUFY_STONE_TYPES));
        add(familyBuilder("deepslate_bricks", Blocks.DEEPSLATE_BRICKS, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(familyBuilder("deepslate_tiles", Blocks.DEEPSLATE_TILES, VANILLA_STONE_TYPES));
        add(familyBuilder("polished_deepslate", Blocks.POLISHED_DEEPSLATE, VANILLA_STONE_TYPES));
        add(familyBuilder("cracked_deepslate_bricks", Blocks.DEEPSLATE_BRICKS, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("cracked_deepslate_tiles", Blocks.DEEPSLATE_TILES, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("mossy_deepslate_bricks", Blocks.DEEPSLATE_BRICKS, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_deepslate_tiles", Blocks.DEEPSLATE_TILES, GUFY_STONE_TYPES));
        add(familyBuilder("quartz", Blocks.QUARTZ_BLOCK, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("smooth_quartz", Blocks.SMOOTH_QUARTZ, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("quartz_bricks", Blocks.QUARTZ_BRICKS, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("iron", Blocks.IRON_BLOCK, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("gold", Blocks.GOLD_BLOCK, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("emerald", Blocks.EMERALD_BLOCK, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("diamond", Blocks.DIAMOND_BLOCK, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("sandstone", Blocks.SANDSTONE, VANILLA_STONE_TYPES));
        add(familyBuilder("cut_sandstone", Blocks.SANDSTONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.STAIRS, GufyBlockTypes.WALL)));
        add(familyBuilder("smooth_sandstone", Blocks.SMOOTH_SANDSTONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("sandstone_bricks", Blocks.SANDSTONE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(familyBuilder("cracked_sandstone_bricks", Blocks.SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_sandstone_bricks", Blocks.SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("sandstone_cobble_bricks", Blocks.SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("cracked_sandstone_cobble_bricks", Blocks.SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_sandstone_cobble_bricks", Blocks.SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("red_sandstone", Blocks.RED_SANDSTONE, VANILLA_STONE_TYPES));
        add(familyBuilder("cut_red_sandstone", Blocks.RED_SANDSTONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.STAIRS, GufyBlockTypes.WALL)));
        add(familyBuilder("smooth_red_sandstone", Blocks.SMOOTH_RED_SANDSTONE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("red_sandstone_bricks", Blocks.RED_SANDSTONE, ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR)));
        add(familyBuilder("cracked_red_sandstone_bricks", Blocks.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_red_sandstone_bricks", Blocks.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("red_sandstone_cobble_bricks", Blocks.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("cracked_red_sandstone_cobble_bricks", Blocks.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("mossy_red_sandstone_cobble_bricks", Blocks.RED_SANDSTONE, GUFY_STONE_TYPES));
        add(familyBuilder("amethyst", Blocks.AMETHYST_BLOCK, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("end_stone", Blocks.END_STONE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("end_stone_brick", Blocks.END_STONE_BRICKS, VANILLA_STONE_TYPES));
        add(familyBuilder("purpur", Blocks.PURPUR_BLOCK, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("blackstone", Blocks.BLACKSTONE, VANILLA_STONE_TYPES));
        add(familyBuilder("polished_blackstone", Blocks.POLISHED_BLACKSTONE, VANILLA_STONE_TYPES));
        add(familyBuilder("polished_blackstone_brick", Blocks.POLISHED_BLACKSTONE_BRICKS, VANILLA_STONE_TYPES));
        add(familyBuilder("cracked_polished_blackstone_brick", Blocks.POLISHED_BLACKSTONE_BRICKS, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("gilded_blackstone", Blocks.GILDED_BLACKSTONE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("dripstone", Blocks.DRIPSTONE_BLOCK, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("stone", GufyProperties.STONE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilder("diorite", GufyProperties.STONE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilder("andesite", GufyProperties.STONE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilder("granite", GufyProperties.STONE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilder("cobbled_deepslate", GufyProperties.STONE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilder("sandstone", GufyProperties.STONE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilder("red_sandstone", GufyProperties.STONE_TRAPDOOR, GufyBlockTypes.STONE_TRAPDOOR));
        add(familyBuilder("prismarine", Blocks.PRISMARINE, VANILLA_STONE_TYPES));
        add(familyBuilder("prismarine_bricks", Blocks.PRISMARINE_BRICKS, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));
        add(familyBuilder("dark_prismarine", Blocks.DARK_PRISMARINE, ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)));

        // ~~ TERRACOTTA ~~ //
        add(familyBuilder("terracotta", Blocks.TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("white_terracotta", Blocks.WHITE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("light_gray_terracotta", Blocks.LIGHT_GRAY_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("gray_terracotta", Blocks.GRAY_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("black_terracotta", Blocks.BLACK_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("brown_terracotta", Blocks.BROWN_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("red_terracotta", Blocks.RED_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("orange_terracotta", Blocks.ORANGE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("yellow_terracotta", Blocks.YELLOW_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("lime_terracotta", Blocks.LIME_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("green_terracotta", Blocks.GREEN_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("cyan_terracotta", Blocks.CYAN_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("light_blue_terracotta", Blocks.LIGHT_BLUE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("blue_terracotta", Blocks.BLUE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("purple_terracotta", Blocks.PURPLE_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("magenta_terracotta", Blocks.MAGENTA_TERRACOTTA, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("pink_terracotta", Blocks.PINK_TERRACOTTA, VANILLA_STONE_TYPES_ALL));

        // ~~ CONCRETE ~~ //
        add(familyBuilder("white_concrete", Blocks.WHITE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("light_gray_concrete", Blocks.LIGHT_GRAY_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("gray_concrete", Blocks.GRAY_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("black_concrete", Blocks.BLACK_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("brown_concrete", Blocks.BROWN_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("red_concrete", Blocks.RED_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("orange_concrete", Blocks.ORANGE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("yellow_concrete", Blocks.YELLOW_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("lime_concrete", Blocks.LIME_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("green_concrete", Blocks.GREEN_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("cyan_concrete", Blocks.CYAN_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("light_blue_concrete", Blocks.LIGHT_BLUE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("blue_concrete", Blocks.BLUE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("purple_concrete", Blocks.PURPLE_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("magenta_concrete", Blocks.MAGENTA_CONCRETE, VANILLA_STONE_TYPES_ALL));
        add(familyBuilder("pink_concrete", Blocks.PINK_CONCRETE, VANILLA_STONE_TYPES_ALL));

        // ~~ WOOL ~~ //
        add(familyBuilder("white_wool", Blocks.WHITE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("light_gray_wool", Blocks.LIGHT_GRAY_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("gray_wool", Blocks.GRAY_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("black_wool", Blocks.BLACK_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("brown_wool", Blocks.BROWN_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("red_wool", Blocks.RED_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("orange_wool", Blocks.ORANGE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("yellow_wool", Blocks.YELLOW_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("lime_wool", Blocks.LIME_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("green_wool", Blocks.GREEN_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("cyan_wool", Blocks.CYAN_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("light_blue_wool", Blocks.LIGHT_BLUE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("blue_wool", Blocks.BLUE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("purple_wool", Blocks.PURPLE_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("magenta_wool", Blocks.MAGENTA_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));
        add(familyBuilder("pink_wool", Blocks.PINK_WOOL, ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)));

        // ~~ GLASS ~~ //
        add(familyBuilder("leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("white_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("light_gray_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("gray_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("black_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("brown_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("red_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("orange_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("yellow_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("lime_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("green_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("cyan_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("light_blue_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("blue_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("purple_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("magenta_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("pink_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("oakfield_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("avalon_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("gufy_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("midland_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("ring_leaded_glass", GufyProperties.LEADED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("oak_framed_glass", GufyProperties.OAK_FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("spruce_framed_glass", GufyProperties.SPRUCE_FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("birch_framed_glass", GufyProperties.BIRCH_FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("dark_oak_framed_glass", GufyProperties.DARK_OAK_FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("jungle_framed_glass", GufyProperties.JUNGLE_FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("acacia_framed_glass", GufyProperties.ACACIA_FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("mangrove_framed_glass", GufyProperties.MANGROVE_FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("cherry_framed_glass", GufyProperties.CHERRY_FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("bamboo_framed_glass", GufyProperties.BAMBOO_FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("crimson_framed_glass", GufyProperties.CRIMSON_FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("warped_framed_glass", GufyProperties.WARPED_FRAMED_GLASS, GufyBlockTypes.PANE));
        add(familyBuilder("pale_oak_framed_glass", GufyProperties.PALE_OAK_FRAMED_GLASS, GufyBlockTypes.PANE));

        // ~~ FRAMED TERRACOTTA ~~ //
        add(familyBuilder("oak_framed_terracotta", GufyProperties.WHITE_FRAMED_TERRACOTTA, FRAMED_BLOCK_TYPES));
        add(familyBuilder("spruce_framed_terracotta", GufyProperties.WHITE_FRAMED_TERRACOTTA, FRAMED_BLOCK_TYPES));
        add(familyBuilder("birch_framed_terracotta", GufyProperties.WHITE_FRAMED_TERRACOTTA, FRAMED_BLOCK_TYPES));
        add(familyBuilder("dark_oak_framed_terracotta", GufyProperties.WHITE_FRAMED_TERRACOTTA, FRAMED_BLOCK_TYPES));
        add(familyBuilder("jungle_framed_terracotta", GufyProperties.WHITE_FRAMED_TERRACOTTA, FRAMED_BLOCK_TYPES));
        add(familyBuilder("acacia_framed_terracotta", GufyProperties.WHITE_FRAMED_TERRACOTTA, FRAMED_BLOCK_TYPES));
        add(familyBuilder("mangrove_framed_terracotta", GufyProperties.WHITE_FRAMED_TERRACOTTA, FRAMED_BLOCK_TYPES));
        add(familyBuilder("cherry_framed_terracotta", GufyProperties.WHITE_FRAMED_TERRACOTTA, FRAMED_BLOCK_TYPES));
        add(familyBuilder("bamboo_framed_terracotta", GufyProperties.WHITE_FRAMED_TERRACOTTA, FRAMED_BLOCK_TYPES));
        add(familyBuilder("crimson_framed_terracotta", GufyProperties.WHITE_FRAMED_TERRACOTTA, FRAMED_BLOCK_TYPES));
        add(familyBuilder("warped_framed_terracotta", GufyProperties.WHITE_FRAMED_TERRACOTTA, FRAMED_BLOCK_TYPES));
        add(familyBuilder("pale_oak_framed_terracotta", GufyProperties.WHITE_FRAMED_TERRACOTTA, FRAMED_BLOCK_TYPES));


        // ~~ COPPER ~~ //
        add(weatheringBuilder("copper", Blocks.COPPER_BLOCK, GufyWeathering.WeatherState.UNAFFECTED, COPPER_TYPES));
        add(weatheringBuilder("exposed_copper", Blocks.EXPOSED_COPPER, GufyWeathering.WeatherState.EXPOSED, COPPER_TYPES));
        add(weatheringBuilder("weathered_copper", Blocks.WEATHERED_COPPER, GufyWeathering.WeatherState.WEATHERED, COPPER_TYPES));
        add(weatheringBuilder("oxidized_copper", Blocks.OXIDIZED_COPPER, GufyWeathering.WeatherState.OXIDIZED, COPPER_TYPES));
        add(weatheringBuilder("cut_copper", Blocks.COPPER_BLOCK, GufyWeathering.WeatherState.UNAFFECTED, CUT_COPPER_TYPES));
        add(weatheringBuilder("exposed_cut_copper", Blocks.EXPOSED_COPPER, GufyWeathering.WeatherState.EXPOSED, CUT_COPPER_TYPES));
        add(weatheringBuilder("weathered_cut_copper", Blocks.WEATHERED_COPPER, GufyWeathering.WeatherState.WEATHERED, CUT_COPPER_TYPES));
        add(weatheringBuilder("oxidized_cut_copper", Blocks.OXIDIZED_COPPER, GufyWeathering.WeatherState.OXIDIZED, CUT_COPPER_TYPES));
        add(familyBuilder("waxed_copper", Blocks.COPPER_BLOCK, WAXED_COPPER_TYPES));
        add(familyBuilder("waxed_exposed_copper", Blocks.EXPOSED_COPPER, WAXED_COPPER_TYPES));
        add(familyBuilder("waxed_weathered_copper", Blocks.WEATHERED_COPPER, WAXED_COPPER_TYPES));
        add(familyBuilder("waxed_oxidized_copper", Blocks.OXIDIZED_COPPER, WAXED_COPPER_TYPES));
        add(familyBuilder("waxed_cut_copper", Blocks.COPPER_BLOCK, WAXED_CUT_COPPER_TYPES));
        add(familyBuilder("waxed_exposed_cut_copper", Blocks.EXPOSED_COPPER, WAXED_CUT_COPPER_TYPES));
        add(familyBuilder("waxed_weathered_cut_copper", Blocks.WEATHERED_COPPER, WAXED_CUT_COPPER_TYPES));
        add(familyBuilder("waxed_oxidized_cut_copper", Blocks.OXIDIZED_COPPER, WAXED_CUT_COPPER_TYPES));

        // ~~ SEATS ~~ //
        add(familyBuilder("seat", GufyProperties.WOODEN_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("white_seat", GufyProperties.WHITE_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("light_gray_seat", GufyProperties.LIGHT_GRAY_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("gray_seat", GufyProperties.GRAY_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("black_seat", GufyProperties.BLACK_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("brown_seat", GufyProperties.BROWN_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("red_seat", GufyProperties.RED_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("orange_seat", GufyProperties.ORANGE_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("yellow_seat", GufyProperties.YELLOW_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("lime_seat", GufyProperties.LIME_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("green_seat", GufyProperties.GREEN_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("cyan_seat", GufyProperties.CYAN_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("light_blue_seat", GufyProperties.LIGHT_BLUE_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("blue_seat", GufyProperties.BLUE_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("purple_seat", GufyProperties.PURPLE_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("magenta_seat", GufyProperties.MAGENTA_SEAT, GufyBlockTypes.SEAT));
        add(familyBuilder("pink_seat", GufyProperties.PINK_SEAT, GufyBlockTypes.SEAT));

        // ~~ MISCELLANEOUS ~~ //
        add(familyBuilder("wattle_fence", GufyProperties.WATTLE, GufyBlockTypes.WATTLEFENCE));
        add(pottedFlowerBuilder("flower_box", Blocks.FLOWER_POT, null, GufyBlockTypes.FLOWER_BOX));
        add(pottedFlowerBuilder("potted_lilac", Blocks.FLOWER_POT, Blocks.LILAC, GufyBlockTypes.FLOWER_BOX));
        add(pottedFlowerBuilder("potted_peony", Blocks.FLOWER_POT, Blocks.PEONY, GufyBlockTypes.FLOWER_BOX));
        add(pottedFlowerBuilder("potted_pitcher_plant", Blocks.FLOWER_POT, Blocks.PITCHER_PLANT, GufyBlockTypes.FLOWER_BOX));
        add(pottedFlowerBuilder("potted_rose_bush", Blocks.FLOWER_POT, Blocks.ROSE_BUSH, GufyBlockTypes.FLOWER_BOX));
        add(pottedFlowerBuilder("potted_sunflower", Blocks.FLOWER_POT, Blocks.SUNFLOWER, GufyBlockTypes.FLOWER_BOX));

        // ~~ DEPRECATED BLOCKS ~~ //
        add(familyBuilder("wagon_wheel", Blocks.SPRUCE_TRAPDOOR, GufyBlockTypes.WAGONWHEEL)); // DEPRECATED
        add(familyBuilder("mossy_oak", Blocks.OAK_PLANKS, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("cracked_oak", Blocks.OAK_PLANKS, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("mossy_spruce", Blocks.SPRUCE_PLANKS, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("cracked_spruce", Blocks.SPRUCE_PLANKS, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("mossy_birch", Blocks.BIRCH_PLANKS, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("cracked_birch", Blocks.BIRCH_PLANKS, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("mossy_dark_oak", Blocks.DARK_OAK_PLANKS, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("cracked_dark_oak", Blocks.DARK_OAK_PLANKS, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("mossy_jungle", Blocks.JUNGLE_PLANKS, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("cracked_jungle", Blocks.JUNGLE_PLANKS, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("mossy_acacia", Blocks.ACACIA_PLANKS, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("cracked_acacia", Blocks.ACACIA_PLANKS, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("mossy_crimson", Blocks.CRIMSON_PLANKS, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("cracked_crimson", Blocks.CRIMSON_PLANKS, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("mossy_warped", Blocks.WARPED_PLANKS, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("cracked_warped", Blocks.WARPED_PLANKS, GUFY_WOOD_TYPES)); // DEPRECATED
        add(familyBuilder("diorite_cobble", Blocks.DIORITE, GUFY_STONE_TYPES)); // DEPRECATED
        add(familyBuilder("mossy_diorite_cobble", Blocks.DIORITE, GUFY_STONE_TYPES)); // DEPRECATED
        add(familyBuilder("oak_framed_daub", Blocks.PACKED_MUD, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilder("spruce_framed_daub", Blocks.PACKED_MUD, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilder("birch_framed_daub", Blocks.PACKED_MUD, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilder("dark_oak_framed_daub", Blocks.PACKED_MUD, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilder("jungle_framed_daub", Blocks.PACKED_MUD, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilder("acacia_framed_daub", Blocks.PACKED_MUD, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilder("crimson_framed_daub", Blocks.PACKED_MUD, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilder("warped_framed_daub", Blocks.PACKED_MUD, FRAMED_BLOCK_TYPES)); // DEPRECATED
        add(familyBuilder("daub", Blocks.PACKED_MUD, GUFY_DIRT_TYPES)); // DEPRECATED
        add(familyBuilder("thatch", Blocks.HAY_BLOCK, GUFY_DIRT_TYPES)); // DEPRECATED
        add(familyBuilder("mushroom_stem", Blocks.BROWN_MUSHROOM_BLOCK, ArrayUtils.addAll(VANILLA_WOOD_TYPES_ALL, GufyBlockTypes.TRAPDOOR))); // DEPRECATED
        add(familyBuilder("mushroom_framed_glass", GufyProperties.MUSHROOM_FRAMED_GLASS, GufyBlockTypes.PANE)); // DEPRECATED
        add(familyBuilder("mushroom_framed_terracotta", GufyProperties.WHITE_FRAMED_TERRACOTTA, FRAMED_BLOCK_TYPES)); // DEPRECATED
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
