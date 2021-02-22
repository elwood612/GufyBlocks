package elwood612.gufyblocks.blocks;

import elwood612.gufyblocks.GufyMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;

public class GufyPane extends PaneBlock {

    private ToolType toolType;
    private int toolLevel;

    public GufyPane(GufyMaterials block, String name)
    {
        super(Block.Properties.create(block.material, block.color).hardnessAndResistance(block.hardness, block.resistance).sound(block.sound));
        this.toolType = block.tool;
        this.toolLevel = block.level;
        this.setDefaultState(this.getDefaultState().with(NORTH, Boolean.FALSE).with(EAST, Boolean.FALSE).with(SOUTH, Boolean.FALSE).with(WEST, Boolean.FALSE).with(WATERLOGGED, Boolean.FALSE));
        setRegistryName(name);
    }

}
