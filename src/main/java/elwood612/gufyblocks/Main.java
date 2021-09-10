package elwood612.gufyblocks;

import elwood612.gufyblocks.items.itemUtil.GufyBlocksItemGroup;
import elwood612.gufyblocks.util.DoorEvent;
import elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.network.NetworkRegistry;
import net.minecraftforge.fmllegacy.network.simple.SimpleChannel;

@Mod(Main.MODID)
public class Main 
{
	public static Main instance;
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
	public Main() 
	{
		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
	    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
	}

	public void clientSetup(final FMLClientSetupEvent clientSetupEvent)
	{
		GufyUtil.renderSetup();
	}

	private void loadComplete(final FMLLoadCompleteEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new DoorEvent());
	}
}