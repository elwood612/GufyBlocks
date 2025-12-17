package com.github.elwood612.gufyblocks;

import com.github.elwood612.gufyblocks.events.GufyRendererEvent;
import com.github.elwood612.gufyblocks.events.GufyScaffoldingEvent;
import com.github.elwood612.gufyblocks.packets.GufyPayload;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@Mod(GufyBlocks.MODID)
public class GufyBlocks
{
	public static final String MODID = "gufyblocks";
	public static final String VERSION = "1.0";

	public GufyBlocks(IEventBus modEventBus)
	{
		GufyRegistry.BLOCKS.register(modEventBus);
		GufyRegistry.ITEMS.register(modEventBus);
		GufyRegistry.ENTITIES.register(modEventBus);
		GufyRegistry.TABS.register(modEventBus);

		modEventBus.register(new GufyRendererEvent());
		modEventBus.addListener(this::registerPackets);
		modEventBus.addListener(this::loadComplete);
	}

	// prevents vanilla clients from connecting to the server
	private void registerPackets(RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(MODID).versioned(VERSION);
		registrar.configurationToClient(
				GufyPayload.TYPE,
				GufyPayload.CODEC,
				(gufyPayload, iPayloadContext) -> {}
		);
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
		NeoForge.EVENT_BUS.register(GufyScaffoldingEvent.class);
	}
}