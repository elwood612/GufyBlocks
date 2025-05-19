package com.github.elwood612.gufyblocks.blocks.blockSpecialty;

import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GufyPane extends IronBarsBlock {

    public GufyPane(BlockBehaviour.Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(NORTH, Boolean.FALSE).setValue(EAST, Boolean.FALSE).setValue(SOUTH, Boolean.FALSE).setValue(WEST, Boolean.FALSE).setValue(WATERLOGGED, Boolean.FALSE));
    }
}
