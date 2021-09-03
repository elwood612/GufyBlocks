package elwood612.gufyblocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.network.NetworkRegistry;
import net.minecraftforge.fmllegacy.network.simple.SimpleChannel;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

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
	}

	public void clientSetup(final FMLClientSetupEvent clientSetupEvent)
	{
		//Do this for every transparent block
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "wattle_fence"))), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "white_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "light_gray_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "gray_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "black_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "brown_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "red_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "orange_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "yellow_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "lime_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "green_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "cyan_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "light_blue_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "blue_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "purple_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "magenta_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "pink_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "oakfield_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "avalon_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "gufy_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "midland_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "ring_leaded_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "spruce_framed_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "oak_framed_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "birch_framed_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "dark_oak_framed_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "jungle_framed_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "acacia_framed_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "crimson_framed_glass_pane"))), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation
				("gufyblocks", "warped_framed_glass_pane"))), RenderType.translucent());

		ItemBlockRenderTypes.setRenderLayer(Blocks.GLASS, RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Blocks.GLASS_PANE, RenderType.translucent());
	}
}