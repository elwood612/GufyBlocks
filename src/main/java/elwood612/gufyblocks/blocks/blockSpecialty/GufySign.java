package elwood612.gufyblocks.blocks.blockSpecialty;

import elwood612.gufyblocks.blocks.blockUtil.GufyMaterials;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;

public class GufySign extends SignBlock
{
    private final WoodType type;
    public GufySign(GufyMaterials block, String name, WoodType wood)
    {
        super(GufyUtil.builder(block), wood);
        setRegistryName(name);
        this.type = wood;
    }

    @Override
    @NotNull
    public WoodType type()
    {
        return this.type;
    }
}
