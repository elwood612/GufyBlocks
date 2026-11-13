package com.github.elwood612.gufyblocks;

import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyBlockTypes;
import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyWeathering;
import com.github.elwood612.gufyblocks.effects.GufyInsomniaEffect;
import com.github.elwood612.gufyblocks.seat.GufySeatEntity;
import com.github.elwood612.gufyblocks.items.*;
import com.github.elwood612.gufyblocks.util.GufyCompassData;
import com.github.elwood612.gufyblocks.util.GufyFamilyBuilder;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyProperties;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
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
import static net.minecraft.world.level.block.Blocks.*;

public class GufyRegistry
{
    //***************************VARIABLES**************************//
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, MODID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, MODID);
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, MODID);
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, MODID);

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
    private static final GufyBlockTypes[] VERTICAL_FRAMED_BLOCK_TYPES = GufyUtil.blocktypeBuilder().get(14);

    private static final ResourceKey<ContextIntProvider> BURN_TIME_300 = ContextIntProviders.COOKING_TIME_WOOD_BLOCKS;
    private static final ResourceKey<ContextIntProvider> BURN_TIME_100 = ContextIntProviders.COOKING_TIME_WOOL;
    private static final ResourceKey<ContextIntProvider> COMPOSTABLE_65 = ContextIntProviders.COMPOSTABLE_MEDIUM;
    private static final ResourceKey<ContextIntProvider> COMPOSTABLE_85 = ContextIntProviders.COMPOSTABLE_MEDIUM_HIGH;

    //**************************************************************//


    //***************************BLOCKLIST**************************//

    public static final List<List<DeferredBlock<Block>>> newBlockList = new ArrayList<List<DeferredBlock<Block>>>()
    {{
        // ~~ WOOD ~~ //
//        add(familyBuilder("oak", OAK_PLANKS, VANILLA_WOOD_TYPES));
        add(new GufyFamilyBuilder().name("oak").parent(OAK_PLANKS).blockTypes(VANILLA_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("oak_parquet").parent(OAK_PLANKS).blockTypes(GUFY_DIRT_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("big_oak").parent(OAK_PLANKS).blockTypes(GUFY_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("oak_wood").parent(OAK_WOOD).blockTypes(VANILLA_STRIPPABLE_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("stripped_oak_wood").parent(OAK_WOOD).blockTypes(VANILLA_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("chiseled_stripped_oak_wood").parent(OAK_WOOD).blockTypes(GufyBlockTypes.CARVED_LOG).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("spruce").parent(SPRUCE_PLANKS).blockTypes(VANILLA_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("spruce_parquet").parent(SPRUCE_PLANKS).blockTypes(GUFY_DIRT_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("big_spruce").parent(SPRUCE_PLANKS).blockTypes(GUFY_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("spruce_wood").parent(SPRUCE_WOOD).blockTypes(VANILLA_STRIPPABLE_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("stripped_spruce_wood").parent(SPRUCE_WOOD).blockTypes(VANILLA_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("chiseled_stripped_spruce_wood").parent(SPRUCE_WOOD).blockTypes(GufyBlockTypes.CARVED_LOG).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("birch").parent(BIRCH_PLANKS).blockTypes(VANILLA_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("birch_parquet").parent(BIRCH_PLANKS).blockTypes(GUFY_DIRT_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("big_birch").parent(BIRCH_PLANKS).blockTypes(GUFY_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("birch_wood").parent(BIRCH_WOOD).blockTypes(VANILLA_STRIPPABLE_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("stripped_birch_wood").parent(BIRCH_WOOD).blockTypes(VANILLA_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("chiseled_stripped_birch_wood").parent(BIRCH_WOOD).blockTypes(GufyBlockTypes.CARVED_LOG).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("dark_oak").parent(DARK_OAK_PLANKS).blockTypes(VANILLA_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("dark_oak_parquet").parent(DARK_OAK_PLANKS).blockTypes(GUFY_DIRT_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("big_dark_oak").parent(DARK_OAK_PLANKS).blockTypes(GUFY_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("dark_oak_wood").parent(DARK_OAK_WOOD).blockTypes(VANILLA_STRIPPABLE_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("stripped_dark_oak_wood").parent(DARK_OAK_WOOD).blockTypes(VANILLA_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("chiseled_stripped_dark_oak_wood").parent(DARK_OAK_WOOD).blockTypes(GufyBlockTypes.CARVED_LOG).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("jungle").parent(JUNGLE_PLANKS).blockTypes(VANILLA_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("jungle_parquet").parent(JUNGLE_PLANKS).blockTypes(GUFY_DIRT_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("big_jungle").parent(JUNGLE_PLANKS).blockTypes(GUFY_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("jungle_wood").parent(JUNGLE_WOOD).blockTypes(VANILLA_STRIPPABLE_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("stripped_jungle_wood").parent(JUNGLE_WOOD).blockTypes(VANILLA_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("chiseled_stripped_jungle_wood").parent(JUNGLE_WOOD).blockTypes(GufyBlockTypes.CARVED_LOG).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("acacia").parent(ACACIA_PLANKS).blockTypes(VANILLA_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("acacia_parquet").parent(ACACIA_PLANKS).blockTypes(GUFY_DIRT_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("big_acacia").parent(ACACIA_PLANKS).blockTypes(GUFY_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("acacia_wood").parent(ACACIA_WOOD).blockTypes(VANILLA_STRIPPABLE_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("stripped_acacia_wood").parent(ACACIA_WOOD).blockTypes(VANILLA_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("chiseled_stripped_acacia_wood").parent(ACACIA_WOOD).blockTypes(GufyBlockTypes.CARVED_LOG).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("mangrove").parent(MANGROVE_PLANKS).blockTypes(VANILLA_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("mangrove_parquet").parent(MANGROVE_PLANKS).blockTypes(GUFY_DIRT_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("big_mangrove").parent(MANGROVE_PLANKS).blockTypes(GUFY_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("mangrove_wood").parent(MANGROVE_WOOD).blockTypes(VANILLA_STRIPPABLE_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("stripped_mangrove_wood").parent(MANGROVE_WOOD).blockTypes(VANILLA_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("chiseled_stripped_mangrove_wood").parent(MANGROVE_WOOD).blockTypes(GufyBlockTypes.CARVED_LOG).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("cherry").parent(CHERRY_PLANKS).blockTypes(VANILLA_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("cherry_parquet").parent(CHERRY_PLANKS).blockTypes(GUFY_DIRT_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("big_cherry").parent(CHERRY_PLANKS).blockTypes(GUFY_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("cherry_wood").parent(CHERRY_WOOD).blockTypes(VANILLA_STRIPPABLE_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("stripped_cherry_wood").parent(CHERRY_WOOD).blockTypes(VANILLA_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("chiseled_stripped_cherry_wood").parent(CHERRY_WOOD).blockTypes(GufyBlockTypes.CARVED_LOG).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("bamboo").parent(BAMBOO_PLANKS).blockTypes(VANILLA_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("bamboo_mosaic").parent(BAMBOO_PLANKS).blockTypes(GufyBlockTypes.VERTICALSLAB).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("chiseled_stripped_bamboo_block").parent(STRIPPED_BAMBOO_BLOCK).blockTypes(GufyBlockTypes.CARVED_LOG).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("crimson").parent(CRIMSON_PLANKS).blockTypes(VANILLA_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("crimson_parquet").parent(CRIMSON_PLANKS).blockTypes(GUFY_DIRT_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("big_crimson").parent(CRIMSON_PLANKS).blockTypes(GUFY_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("crimson_hyphae").parent(CRIMSON_HYPHAE).blockTypes(VANILLA_STRIPPABLE_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("stripped_crimson_hyphae").parent(CRIMSON_HYPHAE).blockTypes(VANILLA_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("chiseled_stripped_crimson_hyphae").parent(CRIMSON_HYPHAE).blockTypes(GufyBlockTypes.CARVED_LOG).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("warped").parent(WARPED_PLANKS).blockTypes(VANILLA_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("warped_parquet").parent(WARPED_PLANKS).blockTypes(GUFY_DIRT_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("big_warped").parent(WARPED_PLANKS).blockTypes(GUFY_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("warped_hyphae").parent(WARPED_HYPHAE).blockTypes(VANILLA_STRIPPABLE_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("stripped_warped_hyphae").parent(WARPED_HYPHAE).blockTypes(VANILLA_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("chiseled_stripped_warped_hyphae").parent(WARPED_HYPHAE).blockTypes(GufyBlockTypes.CARVED_LOG).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("pale_oak").parent(PALE_OAK_PLANKS).blockTypes(VANILLA_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("pale_oak_parquet").parent(PALE_OAK_PLANKS).blockTypes(GUFY_DIRT_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("big_pale_oak").parent(PALE_OAK_PLANKS).blockTypes(GUFY_WOOD_TYPES).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("pale_oak_wood").parent(PALE_OAK_WOOD).blockTypes(VANILLA_STRIPPABLE_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("stripped_pale_oak_wood").parent(PALE_OAK_WOOD).blockTypes(VANILLA_WOOD_TYPES_ALL).furnaceFuel(BURN_TIME_300).buildFamily());
        add(new GufyFamilyBuilder().name("chiseled_stripped_pale_oak_wood").parent(PALE_OAK_WOOD).blockTypes(GufyBlockTypes.CARVED_LOG).furnaceFuel(BURN_TIME_300).buildFamily());

        // ~~ DIRTS ~~ //
        add(new GufyFamilyBuilder().name("coarse_dirt").parent(COARSE_DIRT).blockTypes(VANILLA_DIRT_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("packed_mud").parent(PACKED_MUD).blockTypes(VANILLA_DIRT_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("mud_bricks").parent(MUD_BRICKS).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("hay").parent(HAY_BLOCK).blockTypes(VANILLA_DIRT_TYPES).compostable(COMPOSTABLE_85).buildFamily());
        add(new GufyFamilyBuilder().name("moss").parent(MOSS_BLOCK).blockTypes(VANILLA_DIRT_TYPES).compostable(COMPOSTABLE_65).buildFamily());
        add(new GufyFamilyBuilder().name("pale_moss").parent(PALE_MOSS_BLOCK).blockTypes(VANILLA_DIRT_TYPES).compostable(COMPOSTABLE_65).buildFamily());
        add(new GufyFamilyBuilder().name("rooted_dirt").parent(ROOTED_DIRT).blockTypes(VANILLA_DIRT_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("nether_wart_block").parent(NETHER_WART_BLOCK).blockTypes(VANILLA_DIRT_TYPES).compostable(COMPOSTABLE_85).buildFamily());
        add(new GufyFamilyBuilder().name("warped_wart").parent(WARPED_WART_BLOCK).blockTypes(VANILLA_DIRT_TYPES).compostable(COMPOSTABLE_85).buildFamily());
        add(new GufyFamilyBuilder().name("snow").parent(SNOW_BLOCK).blockTypes(VANILLA_DIRT_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("packed_ice").parent(PACKED_ICE).blockTypes(VANILLA_DIRT_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("resin").parent(RESIN_BLOCK).blockTypes(VANILLA_DIRT_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("resin_bricks").parent(RESIN_BRICKS).blockTypes(VANILLA_STONE_TYPES).buildFamily());

        // ~~ STONES ~~ //
        add(new GufyFamilyBuilder().name("stone").parent(STONE).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)).buildFamily());
        add(new GufyFamilyBuilder().name("smooth_stone").parent(SMOOTH_STONE).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL, GufyBlockTypes.STAIRS)).buildFamily());
        add(new GufyFamilyBuilder().name("cobblestone").parent(COBBLESTONE).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("mossy_cobblestone").parent(MOSSY_COBBLESTONE).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("cobblestone_bricks").parent(STONE_BRICKS).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("mossy_cobblestone_bricks").parent(MOSSY_STONE_BRICKS).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("cracked_cobblestone_bricks").parent(CRACKED_STONE_BRICKS).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("stone_bricks").parent(STONE_BRICKS).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.PILLAR)).buildFamily());
        add(new GufyFamilyBuilder().name("mossy_stone_bricks").parent(MOSSY_STONE_BRICKS).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("cracked_stone_bricks").parent(CRACKED_STONE_BRICKS).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("diorite").parent(DIORITE).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("polished_diorite").parent(POLISHED_DIORITE).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)).buildFamily());
        add(new GufyFamilyBuilder().name("diorite_bricks").parent(DIORITE).blockTypes(ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR, GufyBlockTypes.CHISELED)).buildFamily());
        add(new GufyFamilyBuilder().name("mossy_diorite_bricks").parent(DIORITE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("cracked_diorite_bricks").parent(DIORITE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("diorite_cobble_bricks").parent(DIORITE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("mossy_diorite_cobble_bricks").parent(DIORITE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("cracked_diorite_cobble_bricks").parent(DIORITE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("granite").parent(GRANITE).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("polished_granite").parent(GRANITE).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)).buildFamily());
        add(new GufyFamilyBuilder().name("granite_bricks").parent(GRANITE).blockTypes(ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR, GufyBlockTypes.CHISELED)).buildFamily());
        add(new GufyFamilyBuilder().name("cracked_granite_bricks").parent(GRANITE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("mossy_granite_bricks").parent(GRANITE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("granite_cobble_bricks").parent(GRANITE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("cracked_granite_cobble_bricks").parent(GRANITE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("mossy_granite_cobble_bricks").parent(GRANITE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("andesite").parent(ANDESITE).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("polished_andesite").parent(ANDESITE).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)).buildFamily());
        add(new GufyFamilyBuilder().name("andesite_bricks").parent(ANDESITE).blockTypes(ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR, GufyBlockTypes.CHISELED)).buildFamily());
        add(new GufyFamilyBuilder().name("cracked_andesite_bricks").parent(ANDESITE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("mossy_andesite_bricks").parent(ANDESITE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("brick").parent(BRICKS).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("cracked_bricks").parent(BRICKS).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("mossy_bricks").parent(BRICKS).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("nether_brick").parent(NETHER_BRICKS).blockTypes(GufyBlockTypes.VERTICALSLAB, GufyBlockTypes.HOPPER).buildFamily());
        add(new GufyFamilyBuilder().name("cracked_nether_bricks").parent(NETHER_BRICKS).blockTypes(GufyBlockTypes.STAIRS, GufyBlockTypes.SLAB, GufyBlockTypes.WALL, GufyBlockTypes.VERTICALSLAB, GufyBlockTypes.HOPPER, GufyBlockTypes.FENCE).buildFamily());
        add(new GufyFamilyBuilder().name("red_nether_bricks").parent(RED_NETHER_BRICKS).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("calcite").parent(CALCITE).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("tuff").parent(TUFF).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("tuff_bricks").parent(TUFF_BRICKS).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.PILLAR)).buildFamily());
        add(new GufyFamilyBuilder().name("polished_tuff").parent(POLISHED_TUFF).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("smooth_basalt").parent(SMOOTH_BASALT).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("deepslate").parent(DEEPSLATE).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("cobbled_deepslate").parent(COBBLED_DEEPSLATE).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("mossy_cobbled_deepslate").parent(COBBLED_DEEPSLATE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("deepslate_bricks").parent(DEEPSLATE_BRICKS).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.PILLAR)).buildFamily());
        add(new GufyFamilyBuilder().name("deepslate_tiles").parent(DEEPSLATE_TILES).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("polished_deepslate").parent(POLISHED_DEEPSLATE).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("cracked_deepslate_bricks").parent(DEEPSLATE_BRICKS).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("cracked_deepslate_tiles").parent(DEEPSLATE_TILES).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("mossy_deepslate_bricks").parent(DEEPSLATE_BRICKS).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("mossy_deepslate_tiles").parent(DEEPSLATE_TILES).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("quartz").parent(QUARTZ_BLOCK).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)).buildFamily());
        add(new GufyFamilyBuilder().name("smooth_quartz").parent(SMOOTH_QUARTZ).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)).buildFamily());
        add(new GufyFamilyBuilder().name("quartz_bricks").parent(QUARTZ_BRICKS).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("iron").parent(IRON_BLOCK).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("gold").parent(GOLD_BLOCK).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("emerald").parent(EMERALD_BLOCK).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("diamond").parent(DIAMOND_BLOCK).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("sandstone").parent(SANDSTONE).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("cut_sandstone").parent(SANDSTONE).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.STAIRS, GufyBlockTypes.WALL)).buildFamily());
        add(new GufyFamilyBuilder().name("smooth_sandstone").parent(SMOOTH_SANDSTONE).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)).buildFamily());
        add(new GufyFamilyBuilder().name("sandstone_bricks").parent(SANDSTONE).blockTypes(ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR)).buildFamily());
        add(new GufyFamilyBuilder().name("cracked_sandstone_bricks").parent(SANDSTONE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("mossy_sandstone_bricks").parent(SANDSTONE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("sandstone_cobble_bricks").parent(SANDSTONE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("cracked_sandstone_cobble_bricks").parent(SANDSTONE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("mossy_sandstone_cobble_bricks").parent(SANDSTONE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("red_sandstone").parent(RED_SANDSTONE).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("cut_red_sandstone").parent(RED_SANDSTONE).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.STAIRS, GufyBlockTypes.WALL)).buildFamily());
        add(new GufyFamilyBuilder().name("smooth_red_sandstone").parent(SMOOTH_RED_SANDSTONE).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)).buildFamily());
        add(new GufyFamilyBuilder().name("red_sandstone_bricks").parent(RED_SANDSTONE).blockTypes(ArrayUtils.addAll(GUFY_STONE_TYPES, GufyBlockTypes.PILLAR)).buildFamily());
        add(new GufyFamilyBuilder().name("cracked_red_sandstone_bricks").parent(RED_SANDSTONE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("mossy_red_sandstone_bricks").parent(RED_SANDSTONE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("red_sandstone_cobble_bricks").parent(RED_SANDSTONE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("cracked_red_sandstone_cobble_bricks").parent(RED_SANDSTONE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("mossy_red_sandstone_cobble_bricks").parent(RED_SANDSTONE).blockTypes(GUFY_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("amethyst").parent(AMETHYST_BLOCK).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("end_stone").parent(END_STONE).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("end_stone_brick").parent(END_STONE_BRICKS).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("purpur").parent(PURPUR_BLOCK).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)).buildFamily());
        add(new GufyFamilyBuilder().name("blackstone").parent(BLACKSTONE).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("polished_blackstone").parent(POLISHED_BLACKSTONE).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("polished_blackstone_brick").parent(POLISHED_BLACKSTONE_BRICKS).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("cracked_polished_blackstone_brick").parent(POLISHED_BLACKSTONE_BRICKS).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("gilded_blackstone").parent(GILDED_BLACKSTONE).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("dripstone").parent(DRIPSTONE_BLOCK).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("stone").properties(GufyProperties.STONE_TRAPDOOR).blockTypes(GufyBlockTypes.STONE_TRAPDOOR).buildFamily());
        add(new GufyFamilyBuilder().name("diorite").properties(GufyProperties.STONE_TRAPDOOR).blockTypes(GufyBlockTypes.STONE_TRAPDOOR).buildFamily());
        add(new GufyFamilyBuilder().name("andesite").properties(GufyProperties.STONE_TRAPDOOR).blockTypes(GufyBlockTypes.STONE_TRAPDOOR).buildFamily());
        add(new GufyFamilyBuilder().name("granite").properties(GufyProperties.STONE_TRAPDOOR).blockTypes(GufyBlockTypes.STONE_TRAPDOOR).buildFamily());
        add(new GufyFamilyBuilder().name("cobbled_deepslate").properties(GufyProperties.STONE_TRAPDOOR).blockTypes(GufyBlockTypes.STONE_TRAPDOOR).buildFamily());
        add(new GufyFamilyBuilder().name("sandstone").properties(GufyProperties.STONE_TRAPDOOR).blockTypes(GufyBlockTypes.STONE_TRAPDOOR).buildFamily());
        add(new GufyFamilyBuilder().name("red_sandstone").properties(GufyProperties.STONE_TRAPDOOR).blockTypes(GufyBlockTypes.STONE_TRAPDOOR).buildFamily());
        add(new GufyFamilyBuilder().name("prismarine").parent(PRISMARINE).blockTypes(VANILLA_STONE_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("prismarine_bricks").parent(PRISMARINE_BRICKS).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)).buildFamily());
        add(new GufyFamilyBuilder().name("dark_prismarine").parent(DARK_PRISMARINE).blockTypes(ArrayUtils.addAll(VANILLA_STONE_TYPES, GufyBlockTypes.WALL)).buildFamily());

        // ~~ TERRACOTTA ~~ //
        add(new GufyFamilyBuilder().name("terracotta").parent(TERRACOTTA).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("white_terracotta").parent(DYED_TERRACOTTA.white()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("light_gray_terracotta").parent(DYED_TERRACOTTA.lightGray()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("gray_terracotta").parent(DYED_TERRACOTTA.gray()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("black_terracotta").parent(DYED_TERRACOTTA.black()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("brown_terracotta").parent(DYED_TERRACOTTA.brown()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("red_terracotta").parent(DYED_TERRACOTTA.red()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("orange_terracotta").parent(DYED_TERRACOTTA.orange()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("yellow_terracotta").parent(DYED_TERRACOTTA.yellow()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("lime_terracotta").parent(DYED_TERRACOTTA.lime()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("green_terracotta").parent(DYED_TERRACOTTA.green()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("cyan_terracotta").parent(DYED_TERRACOTTA.cyan()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("light_blue_terracotta").parent(DYED_TERRACOTTA.lightBlue()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("blue_terracotta").parent(DYED_TERRACOTTA.blue()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("purple_terracotta").parent(DYED_TERRACOTTA.purple()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("magenta_terracotta").parent(DYED_TERRACOTTA.magenta()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("pink_terracotta").parent(DYED_TERRACOTTA.pink()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());

        // ~~ CONCRETE ~~ //
        add(new GufyFamilyBuilder().name("white_concrete").parent(CONCRETE.white()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("light_gray_concrete").parent(CONCRETE.lightGray()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("gray_concrete").parent(CONCRETE.gray()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("black_concrete").parent(CONCRETE.black()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("brown_concrete").parent(CONCRETE.brown()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("red_concrete").parent(CONCRETE.red()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("orange_concrete").parent(CONCRETE.orange()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("yellow_concrete").parent(CONCRETE.yellow()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("lime_concrete").parent(CONCRETE.lime()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("green_concrete").parent(CONCRETE.green()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("cyan_concrete").parent(CONCRETE.cyan()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("light_blue_concrete").parent(CONCRETE.lightBlue()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("blue_concrete").parent(CONCRETE.blue()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("purple_concrete").parent(CONCRETE.purple()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("magenta_concrete").parent(CONCRETE.magenta()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());
        add(new GufyFamilyBuilder().name("pink_concrete").parent(CONCRETE.pink()).blockTypes(VANILLA_STONE_TYPES_ALL).buildFamily());

        // ~~ WOOL ~~ //
        add(new GufyFamilyBuilder().name("white_wool").parent(WOOL.white()).blockTypes(ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)).buildFamily());
        add(new GufyFamilyBuilder().name("light_gray_wool").parent(WOOL.lightGray()).blockTypes(ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)).buildFamily());
        add(new GufyFamilyBuilder().name("gray_wool").parent(WOOL.gray()).blockTypes(ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)).buildFamily());
        add(new GufyFamilyBuilder().name("black_wool").parent(WOOL.black()).blockTypes(ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)).buildFamily());
        add(new GufyFamilyBuilder().name("brown_wool").parent(WOOL.brown()).blockTypes(ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)).buildFamily());
        add(new GufyFamilyBuilder().name("red_wool").parent(WOOL.red()).blockTypes(ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)).buildFamily());
        add(new GufyFamilyBuilder().name("orange_wool").parent(WOOL.orange()).blockTypes(ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)).buildFamily());
        add(new GufyFamilyBuilder().name("yellow_wool").parent(WOOL.yellow()).blockTypes(ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)).buildFamily());
        add(new GufyFamilyBuilder().name("lime_wool").parent(WOOL.lime()).blockTypes(ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)).buildFamily());
        add(new GufyFamilyBuilder().name("green_wool").parent(WOOL.green()).blockTypes(ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)).buildFamily());
        add(new GufyFamilyBuilder().name("cyan_wool").parent(WOOL.cyan()).blockTypes(ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)).buildFamily());
        add(new GufyFamilyBuilder().name("light_blue_wool").parent(WOOL.lightBlue()).blockTypes(ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)).buildFamily());
        add(new GufyFamilyBuilder().name("blue_wool").parent(WOOL.blue()).blockTypes(ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)).buildFamily());
        add(new GufyFamilyBuilder().name("purple_wool").parent(WOOL.purple()).blockTypes(ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)).buildFamily());
        add(new GufyFamilyBuilder().name("magenta_wool").parent(WOOL.magenta()).blockTypes(ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)).buildFamily());
        add(new GufyFamilyBuilder().name("pink_wool").parent(WOOL.pink()).blockTypes(ArrayUtils.addAll(VANILLA_DIRT_TYPES, GufyBlockTypes.WOOL_TRAPDOOR)).buildFamily());


        // ~~ FRAMED TERRACOTTA ~~ //
        add(new GufyFamilyBuilder().name("oak").parent(TERRACOTTA).blockTypes(VERTICAL_FRAMED_BLOCK_TYPES).buildFramedFamily());
        add(new GufyFamilyBuilder().name("spruce").parent(TERRACOTTA).blockTypes(VERTICAL_FRAMED_BLOCK_TYPES).buildFramedFamily());
        add(new GufyFamilyBuilder().name("birch").parent(TERRACOTTA).blockTypes(VERTICAL_FRAMED_BLOCK_TYPES).buildFramedFamily());
        add(new GufyFamilyBuilder().name("dark_oak").parent(TERRACOTTA).blockTypes(VERTICAL_FRAMED_BLOCK_TYPES).buildFramedFamily());
        add(new GufyFamilyBuilder().name("jungle").parent(TERRACOTTA).blockTypes(VERTICAL_FRAMED_BLOCK_TYPES).buildFramedFamily());
        add(new GufyFamilyBuilder().name("acacia").parent(TERRACOTTA).blockTypes(VERTICAL_FRAMED_BLOCK_TYPES).buildFramedFamily());
        add(new GufyFamilyBuilder().name("mangrove").parent(TERRACOTTA).blockTypes(VERTICAL_FRAMED_BLOCK_TYPES).buildFramedFamily());
        add(new GufyFamilyBuilder().name("cherry").parent(TERRACOTTA).blockTypes(VERTICAL_FRAMED_BLOCK_TYPES).buildFramedFamily());
        add(new GufyFamilyBuilder().name("bamboo").parent(TERRACOTTA).blockTypes(VERTICAL_FRAMED_BLOCK_TYPES).buildFramedFamily());
        add(new GufyFamilyBuilder().name("crimson").parent(TERRACOTTA).blockTypes(VERTICAL_FRAMED_BLOCK_TYPES).buildFramedFamily());
        add(new GufyFamilyBuilder().name("warped").parent(TERRACOTTA).blockTypes(VERTICAL_FRAMED_BLOCK_TYPES).buildFramedFamily());
        add(new GufyFamilyBuilder().name("pale_oak").parent(TERRACOTTA).blockTypes(VERTICAL_FRAMED_BLOCK_TYPES).buildFramedFamily());


        // ~~ COPPER ~~ //
        // keep these just in case
        add(weatheringBuilder("copper", COPPER_BLOCK.weathering().unaffected(), GufyWeathering.WeatherState.UNAFFECTED, COPPER_TYPES));
        add(weatheringBuilder("exposed_copper", COPPER_BLOCK.weathering().exposed(), GufyWeathering.WeatherState.EXPOSED, COPPER_TYPES));
        add(weatheringBuilder("weathered_copper", COPPER_BLOCK.weathering().weathered(), GufyWeathering.WeatherState.WEATHERED, COPPER_TYPES));
        add(weatheringBuilder("oxidized_copper", COPPER_BLOCK.weathering().oxidized(), GufyWeathering.WeatherState.OXIDIZED, COPPER_TYPES));
        add(weatheringBuilder("cut_copper", COPPER_BLOCK.weathering().unaffected(), GufyWeathering.WeatherState.UNAFFECTED, CUT_COPPER_TYPES));
        add(weatheringBuilder("exposed_cut_copper", COPPER_BLOCK.weathering().exposed(), GufyWeathering.WeatherState.EXPOSED, CUT_COPPER_TYPES));
        add(weatheringBuilder("weathered_cut_copper", COPPER_BLOCK.weathering().weathered(), GufyWeathering.WeatherState.WEATHERED, CUT_COPPER_TYPES));
        add(weatheringBuilder("oxidized_cut_copper", COPPER_BLOCK.weathering().oxidized(), GufyWeathering.WeatherState.OXIDIZED, CUT_COPPER_TYPES));
//        add(new GufyFamilyBuilder().name("copper").parent(COPPER_BLOCK.weathering().unaffected()).blockTypes(COPPER_TYPES).buildFamily());
//        add(new GufyFamilyBuilder().name("exposed_copper").parent(COPPER_BLOCK.weathering().exposed()).blockTypes(COPPER_TYPES).buildFamily());
//        add(new GufyFamilyBuilder().name("weathered_copper").parent(COPPER_BLOCK.weathering().weathered()).blockTypes(COPPER_TYPES).buildFamily());
//        add(new GufyFamilyBuilder().name("oxidized_copper").parent(COPPER_BLOCK.weathering().oxidized()).blockTypes(COPPER_TYPES).buildFamily());
//        add(new GufyFamilyBuilder().name("cut_copper").parent(COPPER_BLOCK.weathering().unaffected()).blockTypes(CUT_COPPER_TYPES).buildFamily());
//        add(new GufyFamilyBuilder().name("exposed_cut_copper").parent(COPPER_BLOCK.weathering().exposed()).blockTypes(CUT_COPPER_TYPES).buildFamily());
//        add(new GufyFamilyBuilder().name("weathered_cut_copper").parent(COPPER_BLOCK.weathering().weathered()).blockTypes(CUT_COPPER_TYPES).buildFamily());
//        add(new GufyFamilyBuilder().name("oxidized_cut_copper").parent(COPPER_BLOCK.weathering().oxidized()).blockTypes(CUT_COPPER_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("waxed_copper").parent(COPPER_BLOCK.weathering().unaffected()).blockTypes(WAXED_COPPER_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("waxed_exposed_copper").parent(COPPER_BLOCK.weathering().exposed()).blockTypes(WAXED_COPPER_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("waxed_weathered_copper").parent(COPPER_BLOCK.weathering().weathered()).blockTypes(WAXED_COPPER_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("waxed_oxidized_copper").parent(COPPER_BLOCK.weathering().oxidized()).blockTypes(WAXED_COPPER_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("waxed_cut_copper").parent(COPPER_BLOCK.weathering().unaffected()).blockTypes(WAXED_CUT_COPPER_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("waxed_exposed_cut_copper").parent(COPPER_BLOCK.weathering().exposed()).blockTypes(WAXED_CUT_COPPER_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("waxed_weathered_cut_copper").parent(COPPER_BLOCK.weathering().weathered()).blockTypes(WAXED_CUT_COPPER_TYPES).buildFamily());
        add(new GufyFamilyBuilder().name("waxed_oxidized_cut_copper").parent(COPPER_BLOCK.weathering().oxidized()).blockTypes(WAXED_CUT_COPPER_TYPES).buildFamily());


        // ~~ POTTED PLANTS ~~ //
        add(new GufyFamilyBuilder().name("flower_box").parent(FLOWER_POT).flower(Items.AIR).blockTypes(GufyBlockTypes.FLOWER_BOX).buildPottedFamily());
        add(new GufyFamilyBuilder().name("potted_large_fern").parent(FLOWER_POT).flower(Items.LARGE_FERN).blockTypes(GufyBlockTypes.FLOWER_BOX).buildPottedFamily());
        add(new GufyFamilyBuilder().name("potted_tall_grass").parent(FLOWER_POT).flower(Items.TALL_GRASS).blockTypes(GufyBlockTypes.FLOWER_BOX).buildPottedFamily());
        add(new GufyFamilyBuilder().name("potted_lilac").parent(FLOWER_POT).flower(Items.LILAC).blockTypes(GufyBlockTypes.FLOWER_BOX).buildPottedFamily());
        add(new GufyFamilyBuilder().name("potted_peony").parent(FLOWER_POT).flower(Items.PEONY).blockTypes(GufyBlockTypes.FLOWER_BOX).buildPottedFamily());
        add(new GufyFamilyBuilder().name("potted_pitcher_plant").parent(FLOWER_POT).flower(Items.PITCHER_PLANT).blockTypes(GufyBlockTypes.FLOWER_BOX).buildPottedFamily());
        add(new GufyFamilyBuilder().name("potted_rose_bush").parent(FLOWER_POT).flower(Items.ROSE_BUSH).blockTypes(GufyBlockTypes.FLOWER_BOX).buildPottedFamily());
        add(new GufyFamilyBuilder().name("potted_sunflower").parent(FLOWER_POT).flower(Items.SUNFLOWER).blockTypes(GufyBlockTypes.FLOWER_BOX).buildPottedFamily());
        add(new GufyFamilyBuilder().name("potted_twisting_vine").parent(FLOWER_POT).flower(Items.TWISTING_VINES).blockTypes(GufyBlockTypes.FLOWER_BOX).buildPottedFamily());
        add(new GufyFamilyBuilder().name("potted_vine").parent(FLOWER_POT).flower(Items.VINE).blockTypes(GufyBlockTypes.FLOWER_BOX).buildPottedFamily());
        add(new GufyFamilyBuilder().name("potted_weeping_vine").parent(FLOWER_POT).flower(Items.WEEPING_VINES).blockTypes(GufyBlockTypes.FLOWER_BOX).buildPottedFamily());


        // ~~ MISCELLANEOUS ~~ //
        add(new GufyFamilyBuilder().name("wattle_fence").properties(GufyProperties.WATTLE).blockTypes(GufyBlockTypes.WATTLEFENCE).furnaceFuel(BURN_TIME_100).buildFamily());

        // ~~ DEPRECATED BLOCKS ~~ //
        add(new GufyFamilyBuilder().name("wagon_wheel").parent(SPRUCE_TRAPDOOR).blockTypes(GufyBlockTypes.WAGONWHEEL).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("mossy_oak").parent(OAK_PLANKS).blockTypes(GUFY_WOOD_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("cracked_oak").parent(OAK_PLANKS).blockTypes(GUFY_WOOD_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("mossy_spruce").parent(SPRUCE_PLANKS).blockTypes(GUFY_WOOD_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("cracked_spruce").parent(SPRUCE_PLANKS).blockTypes(GUFY_WOOD_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("mossy_birch").parent(BIRCH_PLANKS).blockTypes(GUFY_WOOD_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("cracked_birch").parent(BIRCH_PLANKS).blockTypes(GUFY_WOOD_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("mossy_dark_oak").parent(DARK_OAK_PLANKS).blockTypes(GUFY_WOOD_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("cracked_dark_oak").parent(DARK_OAK_PLANKS).blockTypes(GUFY_WOOD_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("mossy_jungle").parent(JUNGLE_PLANKS).blockTypes(GUFY_WOOD_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("cracked_jungle").parent(JUNGLE_PLANKS).blockTypes(GUFY_WOOD_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("mossy_acacia").parent(ACACIA_PLANKS).blockTypes(GUFY_WOOD_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("cracked_acacia").parent(ACACIA_PLANKS).blockTypes(GUFY_WOOD_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("mossy_crimson").parent(CRIMSON_PLANKS).blockTypes(GUFY_WOOD_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("cracked_crimson").parent(CRIMSON_PLANKS).blockTypes(GUFY_WOOD_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("mossy_warped").parent(WARPED_PLANKS).blockTypes(GUFY_WOOD_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("cracked_warped").parent(WARPED_PLANKS).blockTypes(GUFY_WOOD_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("diorite_cobble").parent(DIORITE).blockTypes(GUFY_STONE_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("mossy_diorite_cobble").parent(DIORITE).blockTypes(GUFY_STONE_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("oak_framed_daub").parent(PACKED_MUD).blockTypes(FRAMED_BLOCK_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("spruce_framed_daub").parent(PACKED_MUD).blockTypes(FRAMED_BLOCK_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("birch_framed_daub").parent(PACKED_MUD).blockTypes(FRAMED_BLOCK_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("dark_oak_framed_daub").parent(PACKED_MUD).blockTypes(FRAMED_BLOCK_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("jungle_framed_daub").parent(PACKED_MUD).blockTypes(FRAMED_BLOCK_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("acacia_framed_daub").parent(PACKED_MUD).blockTypes(FRAMED_BLOCK_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("crimson_framed_daub").parent(PACKED_MUD).blockTypes(FRAMED_BLOCK_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("warped_framed_daub").parent(PACKED_MUD).blockTypes(FRAMED_BLOCK_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("daub").parent(PACKED_MUD).blockTypes(GUFY_DIRT_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("thatch").parent(HAY_BLOCK).blockTypes(GUFY_DIRT_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("mushroom_stem").parent(BROWN_MUSHROOM_BLOCK).blockTypes(ArrayUtils.addAll(VANILLA_WOOD_TYPES_ALL, GufyBlockTypes.TRAPDOOR)).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("mushroom_framed_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("mushroom_framed_terracotta").properties(GufyProperties.WHITE_FRAMED_TERRACOTTA).blockTypes(FRAMED_BLOCK_TYPES).buildFamily()); // DEPRECATED
        add(new GufyFamilyBuilder().name("leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("white_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("light_gray_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("gray_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("black_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("brown_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("red_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("orange_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("yellow_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("lime_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("green_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("cyan_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("light_blue_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("blue_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("purple_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("magenta_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("pink_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("oakfield_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("avalon_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("gufy_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("midland_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("ring_leaded_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("oak_framed_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("spruce_framed_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("birch_framed_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("dark_oak_framed_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("jungle_framed_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("acacia_framed_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("mangrove_framed_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("cherry_framed_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("bamboo_framed_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("crimson_framed_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("warped_framed_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("pale_oak_framed_glass").properties(GufyProperties.LEADED_GLASS).blockTypes(GufyBlockTypes.PANE).buildFamily());
        add(new GufyFamilyBuilder().name("seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
        add(new GufyFamilyBuilder().name("white_seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
        add(new GufyFamilyBuilder().name("light_gray_seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
        add(new GufyFamilyBuilder().name("gray_seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
        add(new GufyFamilyBuilder().name("black_seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
        add(new GufyFamilyBuilder().name("brown_seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
        add(new GufyFamilyBuilder().name("red_seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
        add(new GufyFamilyBuilder().name("orange_seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
        add(new GufyFamilyBuilder().name("yellow_seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
        add(new GufyFamilyBuilder().name("lime_seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
        add(new GufyFamilyBuilder().name("green_seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
        add(new GufyFamilyBuilder().name("cyan_seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
        add(new GufyFamilyBuilder().name("light_blue_seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
        add(new GufyFamilyBuilder().name("blue_seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
        add(new GufyFamilyBuilder().name("purple_seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
        add(new GufyFamilyBuilder().name("magenta_seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
        add(new GufyFamilyBuilder().name("pink_seat").parent(OAK_SLAB).blockTypes(GufyBlockTypes.SEAT).buildFamily());
    }};
    //**************************************************************//



    //****************************ITEMS*****************************//
    public static final DeferredItem<Item> MOSS_CLUMP = ITEMS.registerItem(
            "moss_clump",
            GufyMossClump::new,
            () -> new Item.Properties().compostable(ContextIntProviders.COMPOSTABLE_LOW)
    );
    public static final DeferredItem<Item> HAMMER = ITEMS.registerItem(
            "hammer",
            GufyHammer::new,
            () -> new Item.Properties().durability(216)
    );
    public static final DeferredItem<Item> ANCHOR = ITEMS.registerItem(
            "anchor",
            GufyAnchor::new,
            () -> new Item.Properties().stacksTo(16)
    );
    public static final DeferredItem<Item> SUNLIGHT_SHARD = ITEMS.registerItem(
            "sunlight_shard",
            GufySunlightShard::new,
            () -> new Item.Properties().useCooldown(1f).rarity(Rarity.RARE)
    );
    public static final DeferredItem<Item> STORM_ECHO = ITEMS.registerItem(
            "storm_echo",
            GufyStormEcho::new,
            () -> new Item.Properties().stacksTo(16).rarity(Rarity.EPIC)
    );
    public static final DeferredItem<Item> SPECTRAL_GEM = ITEMS.registerItem(
            "spectral_gem",
            GufySpectralGem::new,
            () -> new Item.Properties().useCooldown(1f).rarity(Rarity.RARE)
    );
    public static final DeferredItem<Item> BIOME_SEED = ITEMS.registerItem(
            "biome_seed",
            GufyBiomeSeed::new,
            () -> new Item.Properties().stacksTo(16).useCooldown(1f)
    );
    public static final DeferredItem<Item> INSOMNIA_FRAGMENT = ITEMS.registerItem(
            "insomnia_fragment",
            GufyInsomniaFragment::new,
            () -> new Item.Properties().stacksTo(16).component(DataComponents.CONSUMABLE, Consumables.DEFAULT_DRINK).rarity(Rarity.EPIC)
    );
    public static final DeferredItem<Item> PHASING_VIAL = ITEMS.registerItem(
            "phasing_vial",
            GufyPhasingVial::new,
            () -> new Item.Properties().stacksTo(16).component(DataComponents.CONSUMABLE, Consumables.DEFAULT_DRINK).rarity(Rarity.EPIC)
    );
    public static final DeferredItem<Item> WHISPERING_COMPASS = ITEMS.registerItem(
            "whispering_compass",
            GufyWhisperingCompass::new,
            () -> new Item.Properties()
    );
    public static final DeferredItem<Item> EXPERIENCE_ORB = ITEMS.registerItem(
            "experience_orb",
            GufyExperienceOrb::new,
            () -> new Item.Properties().rarity(Rarity.UNCOMMON)
    );
    public static final DeferredItem<Item> TOTEM_KEEPING = ITEMS.registerItem(
            "totem_keeping",
            GufyTotemKeeping::new,
            () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)
    );
    public static final DeferredItem<Item> SOULBOUND_ANCHOR = ITEMS.registerItem(
            "soulbound_anchor",
            GufySoulboundAnchor::new,
            () -> new Item.Properties().stacksTo(16).useCooldown(1f).rarity(Rarity.EPIC)
    );
    public static final DeferredItem<Item> MEMORY_CHARM = ITEMS.registerItem(
            "memory_charm",
            GufyMemoryCharm::new,
            () -> new Item.Properties().stacksTo(16).useCooldown(1f).rarity(Rarity.RARE)
    );
    public static final DeferredItem<Item> POTENT_SPECTRAL_SHARD = ITEMS.registerItem(
            "potent_spectral_shard",
            GufyPotentSpectralShard::new,
            () -> new Item.Properties().stacksTo(16).useCooldown(1f).rarity(Rarity.EPIC)
    );
    public static final DeferredItem<Item> MONOCLE = ITEMS.registerItem(
            "monocle",
            GufyMonocle::new,
            () -> new Item.Properties().stacksTo(1)
    );
    public static final DeferredItem<Item> STILLSTONE = ITEMS.registerItem(
            "stillstone",
            GufyStillstone::new,
            () -> new Item.Properties().useCooldown(1f).rarity(Rarity.RARE)
    );
    public static final DeferredItem<Item> LEDGER = ITEMS.registerItem(
            "ledger",
            GufyLedger::new,
            () -> new Item.Properties().stacksTo(1).useCooldown(1f).rarity(Rarity.RARE)
    );

    //**************************************************************//


    //****************************MISC******************************//

    public static final DeferredHolder<EntityType<?>, EntityType<GufySeatEntity>> SEAT = ENTITIES.register("seat",
            () -> EntityType.Builder.<GufySeatEntity>of(GufySeatEntity::new, MobCategory.MISC).sized(0.0f, 0.0f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MODID, "seat"))));

    public static final Supplier<SimpleParticleType> MONOCLE_PARTICLE = PARTICLES.register("monocle_particle",
            () -> new SimpleParticleType(false));

    public static final Holder<MobEffect> INSOMNIA = MOB_EFFECTS.register("gufy_insomnia",
            () -> new GufyInsomniaEffect(MobEffectCategory.HARMFUL, 0xBF1DBB));

    //**************************************************************//


    //****************************TABS & UTILITY******************************//
    public static final Supplier<CreativeModeTab> BLOCKS_TAB = TABS.register("gufyblocks_blocks",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + MODID + ".tab"))
                    .icon(() -> new ItemStack(GufyUtil.getGufyBlock("cobblestone_bricks")))
                    .displayItems((params, output) -> {
                        for (DeferredHolder<Block, ? extends Block> block : BLOCKS.getEntries()) {
                            if (!block.getId().toShortString().contains("framed") || block.getId().toShortString().contains("glass")) {
                                output.accept(block.get());
                            }
                        }
                    })
                    .build()
    );
    public static final Supplier<CreativeModeTab> ITEMS_TAB = TABS.register("gufyblocks_items",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + MODID + ".item_tab"))
                    .icon(() -> new ItemStack(GufyUtil.getGufyItem("hammer")))
                    .displayItems((params, output) -> {
                        for (DeferredHolder<Item, ? extends Item> item : ITEMS.getEntries()) {
                            if (!item.getId().toShortString().contains("framed") || item.getId().toShortString().contains("glass")) {
                                if (!BuiltInRegistries.BLOCK.containsKey(item.getId())) {
                                    output.accept(item.get());
                                }
                            }
                        }
                    })
                    .build()
    );
    public static final Supplier<CreativeModeTab> FRAMED_TAB = TABS.register("gufyblocks_framed",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + MODID + ".framed_tab"))
                    .icon(() -> new ItemStack(GufyUtil.getGufyBlock("spruce_framed_white_terracotta")))
                    .displayItems((params, output) -> {
                        for (DeferredHolder<Block, ? extends Block> block : BLOCKS.getEntries()) {
                            if (block.getId().toShortString().contains("framed")
                                    && !block.getId().toShortString().contains("glass")
                                    && !block.getId().toShortString().contains("cross")
                                    && !block.getId().toShortString().contains("left")
                                    && !block.getId().toShortString().contains("right")) {
                                output.accept(block.get());
                            }
                        }
                    })
                    .build()
    );
    public static final Supplier<DataComponentType<String>> OWNER = DATA_COMPONENT_TYPES.register("owner", () ->
            DataComponentType.<String>builder()
                    .persistent(Codec.STRING)
//                    .networkSynchronized(ByteBufCodecs.STRING_UTF8)
                    .networkSynchronized(StreamCodec.of(
                            (buf, value) -> ByteBufCodecs.STRING_UTF8.encode(buf.copy(), value),
                            buf -> ByteBufCodecs.STRING_UTF8.decode(buf.copy())
                    ))
                    .build()
    );
    public static final Supplier<DataComponentType<Identifier>> STORED_BIOME = DATA_COMPONENT_TYPES.register("stored_biome", () ->
            DataComponentType.<Identifier>builder()
                    .persistent(Identifier.CODEC)
//                    .networkSynchronized(Identifier.STREAM_CODEC)
                    .networkSynchronized(StreamCodec.of(
                            (buf, value) -> Identifier.STREAM_CODEC.encode(buf.copy(), value),
                            buf -> Identifier.STREAM_CODEC.decode(buf.copy())
                    ))
                    .build()
    );
    public static final Supplier<DataComponentType<GufyCompassData>> COMPASS_DATA = DATA_COMPONENT_TYPES.register("compass_data", () ->
            DataComponentType.<GufyCompassData>builder()
                    .persistent(GufyCompassData.CODEC)
                    .build()
    );
    //**************************************************************//





    //***********************REGISTRY METHODS***********************//
    public static <T extends Block>DeferredBlock<T> createRegistry(
            String name,
            Supplier<T> blockSupplier,
            BlockBehaviour.Properties blockProperties,
            ResourceKey<ContextIntProvider> compostable,
            ResourceKey<ContextIntProvider> furnaceFuel)
    {
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MODID, name));
        blockProperties.setId(blockKey);

        DeferredBlock<T> block = BLOCKS.register(name, blockSupplier);

        Item.Properties itemProperties = new Item.Properties();
        if (compostable != null) itemProperties.compostable(compostable);
        if (furnaceFuel != null) itemProperties.cookingFuel(furnaceFuel);

        ITEMS.registerSimpleBlockItem(name, block, () -> itemProperties);

        return block;
    }
    //**************************************************************//
}