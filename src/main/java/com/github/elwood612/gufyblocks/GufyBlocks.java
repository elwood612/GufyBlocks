package com.github.elwood612.gufyblocks;

import com.github.elwood612.gufyblocks.util.GufyDoorEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
//import net.minecraftforge.network.NetworkRegistry;
//import net.minecraftforge.network.simple.SimpleChannel;

@Mod(GufyBlocks.MODID)
public class GufyBlocks
{
	public static final String MODID = "gufyblocks";
	
	//Ensures vanilla clients can't connect to server
//	public static final String CHANNEL = "main";
//    private static final String PROTOCOL_VERSION = "1.0";
//    public static SimpleChannel channel = NetworkRegistry.ChannelBuilder
//            .named(new ResourceLocation(MODID, CHANNEL))
//            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
//            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
//            .networkProtocolVersion(() -> PROTOCOL_VERSION)
//            .simpleChannel();
	
	//Constructor
	public GufyBlocks(IEventBus modEventBus)
	{
		GufyRegistry.registerBus(modEventBus);
		modEventBus.addListener(this::loadComplete);
	}

	private void loadComplete(final FMLCommonSetupEvent event)
	{
		NeoForge.EVENT_BUS.register(GufyDoorEvent.class);
	}
}