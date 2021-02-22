package elwood612.gufyblocks;

import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.minecraftforge.registries.ForgeRegistries;

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
	public static final ItemGroup gufygroup = new GufyBlocksItemGroup();
	
	//Constructor
	public Main() 
	{
		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
	    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
	}

	public void clientSetup(final FMLClientSetupEvent clientSetupEvent)
	{
		//Do this for every transparent block
		RenderTypeLookup.setRenderLayer(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("gufyblocks", "wattle_fence")), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(Blocks.GLASS, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(Blocks.GLASS_PANE, RenderType.getTranslucent());
	}
}