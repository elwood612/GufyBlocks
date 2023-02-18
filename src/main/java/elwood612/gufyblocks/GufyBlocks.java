package elwood612.gufyblocks;

import elwood612.gufyblocks.items.itemUtil.GufyBlocksItemGroup;
import elwood612.gufyblocks.util.GufyDoorEvent;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

@Mod(GufyBlocks.MODID)
public class GufyBlocks
{
	public static GufyBlocks instance;
	public static final String MODID = "gufyblocks";
	
	//Ensures vanilla clients can't connect to server
	public static final String CHANNEL = "main";
    private static final String PROTOCOL_VERSION = "1.0";
    public static SimpleChannel channel = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(MODID, CHANNEL))
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();

	//Creative Tab
	public static final CreativeModeTab gufygroup = new GufyBlocksItemGroup();
	
	//Constructor
	public GufyBlocks()
	{
		instance = this;
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		GufyRegistry.registerBus(bus);

	    //bus.addListener(this::clientSetup);
		bus.addListener(this::loadComplete);

	}

	//public void clientSetup(final FMLClientSetupEvent clientSetupEvent)
	//{
	//	GufyUtil.renderSetup();
	//}

	private void loadComplete(final FMLLoadCompleteEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new GufyDoorEvent());
	}
}