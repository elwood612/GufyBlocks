package elwood612.gufyblocks.items.itemUtil;

import elwood612.gufyblocks.GufyBlocks;
import elwood612.gufyblocks.GufyRegistry;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = GufyBlocks.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GufyBlocksItemGroup{
	public static CreativeModeTab TAB;

	@SubscribeEvent
	public static void registerTab(CreativeModeTabEvent.Register event) {
		TAB = event.registerCreativeModeTab(
				new ResourceLocation(GufyBlocks.MODID, "gufygroup"), builder -> builder
						.icon(() -> new ItemStack(GufyUtil.getGufyBlock("cobblestone_bricks").get()))
						.title(Component.translatable("Gufy Blocks"))
						.displayItems((featureFlags, output, hasOp) ->
						{
							for (RegistryObject<Block> block : GufyRegistry.BLOCKS.getEntries())
							{
								output.accept(block.get());
							}
						})
		);
	}
}












/*
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class GufyBlocksItemGroup extends CreativeModeTab
{
	public GufyBlocksItemGroup()
	{
		super("gufygroup");
	}

	@Override
	public ItemStack makeIcon()
	{
		return new ItemStack(GufyUtil.getGufyBlock("cobblestone_bricks").get());
	}
}
*/