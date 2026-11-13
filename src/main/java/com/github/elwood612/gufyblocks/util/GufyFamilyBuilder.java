package com.github.elwood612.gufyblocks.util;

import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyBlockTypes;
import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyColorMap;
import com.github.elwood612.gufyblocks.blocks.blockUtil.GufyColors;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.List;

import static com.github.elwood612.gufyblocks.GufyBlocks.MODID;

public class GufyFamilyBuilder
{
    private String _name;
    private Block _parentBlock;
    private BlockBehaviour.Properties _parentProperties;
    private GufyBlockTypes[] _blockTypes;
    private ResourceKey<ContextIntProvider> _compostable = null;
    private ResourceKey<ContextIntProvider> _furnaceFuel = null;
    private Item _flower = null;

    public GufyFamilyBuilder() {}

    public List<DeferredBlock<Block>> buildFamily() {
        return new ArrayList<>() {{
            for (GufyBlockTypes blockType : _blockTypes) {
                if (_parentBlock == null) _parentBlock = getParent(_name);
                if (_parentProperties == null) _parentProperties = GufyUtil.copyPropertiesOf(_parentBlock);

                add(GufyUtil.getVariant(_name, _parentProperties, _parentBlock, blockType, _compostable, _furnaceFuel));
            }
        }};
    }

    public List<DeferredBlock<Block>> buildFramedFamily() {
        return new ArrayList<>() {{
            BlockBehaviour.Properties framedProperties = GufyUtil.copyPropertiesOf(_parentBlock)
                    .strength(1.5f, 6.0f);
            String framedName = _name + "_framed_terracotta";

            for (GufyBlockTypes blockType: _blockTypes) {
                add(GufyUtil.getVariant(framedName, framedProperties, _parentBlock, blockType, null, null));
            }

            for (GufyColors color : GufyColors.values()) {
                BlockBehaviour.Properties colorBlockProperties = GufyUtil.copyPropertiesOf(_parentBlock)
                        .mapColor(GufyColorMap.TERRACOTTA_COLOR_MAP.get(color))
                        .strength(1.5f, 6.0f);
                String colorName = _name + "_framed_" + color.toString() + "_terracotta";
                for (GufyBlockTypes blockType: _blockTypes) {
                    add(GufyUtil.getVariant(colorName, colorBlockProperties, _parentBlock, blockType, null, null));
                }
            }
        }};
    }

    public List<DeferredBlock<Block>> buildPottedFamily() {
        return new ArrayList<>() {{
            for (GufyBlockTypes blockType : _blockTypes) {
                if (_parentBlock == null) _parentBlock = getParent(_name);
                if (_parentProperties == null) _parentProperties = GufyUtil.copyPropertiesOf(_parentBlock);

                add(GufyUtil.getPottedVariant(_name, _parentProperties, _parentBlock, _flower, blockType));
            }
        }};
    }

    public GufyFamilyBuilder name(String name) {
        this._name = name;
        return this;
    }

    public GufyFamilyBuilder parent(Block parent) {
        this._parentBlock = parent;
        return this;
    }

    public GufyFamilyBuilder properties(BlockBehaviour.Properties properties) {
        this._parentProperties = GufyUtil.copyPropertiesOf(properties);
        return this;
    }

    public GufyFamilyBuilder blockTypes(GufyBlockTypes ... blockTypes) {
        this._blockTypes = blockTypes;
        return this;
    }

    public GufyFamilyBuilder compostable(ResourceKey<ContextIntProvider> compostable) {
        this._compostable = compostable;
        return this;
    }

    public GufyFamilyBuilder furnaceFuel(ResourceKey<ContextIntProvider> furnaceFuel) {
        this._furnaceFuel = furnaceFuel;
        return this;
    }

    public GufyFamilyBuilder flower(Item flower) {
        this._flower = flower;
        return this;
    }

    private Block getParent(String name) {
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

        return Blocks.OAK_PLANKS;
    }
}
