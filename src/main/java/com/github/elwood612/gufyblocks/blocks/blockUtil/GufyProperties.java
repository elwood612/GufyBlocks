package com.github.elwood612.gufyblocks.blocks.blockUtil;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import static com.github.elwood612.gufyblocks.util.GufyUtil.copyPropertiesOf;

public class GufyProperties {

    public static final BlockBehaviour.Properties WATTLE = copyPropertiesOf(Blocks.OAK_FENCE).strength(0.5f).noOcclusion();
    public static final BlockBehaviour.Properties STONE_TRAPDOOR = copyPropertiesOf(Blocks.STONE).noOcclusion();
    public static final BlockBehaviour.Properties LEADED_GLASS = copyPropertiesOf(Blocks.GLASS_PANE).mapColor(MapColor.STONE).strength(2.0f, 0.3f);
    public static final BlockBehaviour.Properties WHITE_FRAMED_TERRACOTTA = copyPropertiesOf(Blocks.DYED_TERRACOTTA.white()).strength(2.0f, 6.0f);
}
