package elwood612.gufyblocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GufyMod.MODID)
public class GufyMod 
{
	public static GufyMod instance;
	public static final String MODID = "gufyblocks";
	private static final Logger LOGGER = LogManager.getLogger(MODID);
	
	//Creative Tab
	public static final ItemGroup gufygroup = new GufyBlocksItemGroup();
	
	//Constructor
	public GufyMod() 
	{
		instance = this;
	
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	//Used to be pre-init
	private void setup(final FMLCommonSetupEvent event)
	{
		LOGGER.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		LOGGER.info("ClientRegistries method registered.");
	}
}
