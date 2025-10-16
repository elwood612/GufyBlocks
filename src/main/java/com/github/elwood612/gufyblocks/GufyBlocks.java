package com.github.elwood612.gufyblocks;

import com.github.elwood612.gufyblocks.events.GufyRendererEvent;
import com.github.elwood612.gufyblocks.events.GufyScaffoldingEvent;
import com.github.elwood612.gufyblocks.util.GufyTintHandler;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.slf4j.Logger;

@Mod(GufyBlocks.MODID)
public class GufyBlocks
{
	public static final String MODID = "gufyblocks";

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

	// possibly useless, keep anyway
	private void registerPackets(RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(MODID).versioned("1.0");
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
		NeoForge.EVENT_BUS.register(GufyScaffoldingEvent.class);
	}
}