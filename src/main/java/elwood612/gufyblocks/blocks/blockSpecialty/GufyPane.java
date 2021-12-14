package elwood612.gufyblocks.blocks.blockSpecialty;

import elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.IronBarsBlock;

public class GufyPane extends IronBarsBlock {

    public GufyPane(GufyMaterials block, String name)
    {
        super(GufyUtil.builder(block));
        this.registerDefaultState(this.defaultBlockState().setValue(NORTH, Boolean.FALSE).setValue(EAST, Boolean.FALSE).setValue(SOUTH, Boolean.FALSE).setValue(WEST, Boolean.FALSE).setValue(WATERLOGGED, Boolean.FALSE));
        setRegistryName(name);
    }

}
