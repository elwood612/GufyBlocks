package com.github.elwood612.gufyblocks;

import com.github.elwood612.gufyblocks.util.GufyRendererEvent;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.slf4j.Logger;

@Mod(GufyBlocks.MODID)
public class GufyBlocks
{
	public static final String MODID = "gufyblocks";
	private static final Logger LOGGER = LogUtils.getLogger();


	public GufyBlocks(IEventBus modEventBus)
	{
		GufyRegistry.BLOCKS.register(modEventBus);
		GufyRegistry.ITEMS.register(modEventBus);
//		GufyRegistry.BLOCKITEMS.register(modEventBus);
		GufyRegistry.ENTITIES.register(modEventBus);
		GufyRegistry.TABS.register(modEventBus);

		modEventBus.register(new GufyRendererEvent());
		modEventBus.addListener(this::registerPackets);
	}

	// possibly useless, keep anyway
	private void registerPackets(RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(MODID).versioned("1.0");
	}
}