package com.github.elwood612.gufyblocks;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

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
	}
}