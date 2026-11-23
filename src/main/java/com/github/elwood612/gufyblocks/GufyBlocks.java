package com.github.elwood612.gufyblocks;

import com.github.elwood612.gufyblocks.items.itemUtil.ClientMemoryPayloadHandler;
import com.github.elwood612.gufyblocks.items.itemUtil.ServerMemoryPayloadHandler;
import com.github.elwood612.gufyblocks.items.itemUtil.WorkstationRequest;
import com.github.elwood612.gufyblocks.items.itemUtil.WorkstationResponse;
import com.github.elwood612.gufyblocks.network.*;
import com.github.elwood612.gufyblocks.items.itemUtil.ClientLightyPayloadHandler;
import com.github.elwood612.gufyblocks.items.itemUtil.LightyRequest;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.network.event.RegisterClientPayloadHandlersEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.slf4j.Logger;

@Mod(GufyBlocks.MODID)
public class GufyBlocks
{
	public static final String MODID = "gufyblocks";
	public static final String VERSION = ModList.get()
			.getModContainerById(MODID)
			.map(mc -> mc.getModInfo().getVersion().toString())
			.orElse("1.0");
	public static final Logger LOGGER = LogUtils.getLogger();

	public GufyBlocks(IEventBus modEventBus) {
		LOGGER.info("{} mod loading, version {}", MODID, VERSION);

		GufyRegistry.BLOCKS.register(modEventBus);
		GufyRegistry.ITEMS.register(modEventBus);
		GufyRegistry.ENTITIES.register(modEventBus);
		GufyRegistry.TABS.register(modEventBus);
		GufyRegistry.DATA_COMPONENT_TYPES.register(modEventBus);
		GufyRegistry.PARTICLES.register(modEventBus);
		GufyRegistry.MOB_EFFECTS.register(modEventBus);

		modEventBus.addListener(this::registerPackets);
		modEventBus.addListener(this::registerClientPackets);
	}

	private void registerPackets(RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(MODID);

		// gives better error message handling (thru Neoforge)
		// when attempting to connect to the server with vanilla client
		registrar.playToClient(
				GufyVersionCheckPayload.TYPE,
				GufyVersionCheckPayload.CODEC,
				(payload, context) -> {
					if (!payload.serverVersion().equals(VERSION)) {
                        context.disconnect(Component.literal(
								"§cYou need to update your modpack to play on the server!\n\n" +
										"§7Server version: §f" + payload.serverVersion() + "\n" +
										"§7Your version: §f" + VERSION + "\n\n" +
										"§6If you need instructions on how to update," + "\n" +
										"§6head over to the Gufy Server discord -> `Resources` channel"
						));
					}
				}
		);

		// Register both Request and Response for getting a villager's workstation
		// As called in MemoryCharmInteraction
		registrar.playToServer(
				WorkstationRequest.TYPE,
				WorkstationRequest.STREAM_CODEC,
                ServerMemoryPayloadHandler::handle
		);
		registrar.playToClient(
				WorkstationResponse.TYPE,
				WorkstationResponse.STREAM_CODEC
		);

		// Register Lighty payload request
		// As called in GufySpectralGem
		registrar.playToClient(
				LightyRequest.TYPE,
				LightyRequest.STREAM_CODEC,
				ClientLightyPayloadHandler::handle
		);
	}

	private void registerClientPackets(RegisterClientPayloadHandlersEvent event) {
		// Client-side registering for the villager's workstation request
		// As called in GufyClientEvents for the Memory Charm
		event.register(
				WorkstationResponse.TYPE,
				ClientMemoryPayloadHandler::handle
		);
	}
}