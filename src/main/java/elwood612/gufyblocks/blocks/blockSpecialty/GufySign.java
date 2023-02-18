package elwood612.gufyblocks.blocks.blockSpecialty;

import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.jetbrains.annotations.NotNull;

public class GufySign extends SignBlock
{
    private final WoodType type;
    public GufySign(BlockBehaviour.Properties properties, WoodType wood)
    {
        super(properties, wood);
        this.type = wood;
    }

    @Override
    @NotNull
    public WoodType type()
    {
        return this.type;
    }
}
