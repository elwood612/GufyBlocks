package com.github.elwood612.gufyblocks.spectralChime;

import net.neoforged.neoforge.network.handling.IPayloadContext;

public class ClientLightyPayloadHandler
{
    public static void handle(LightyRequest payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            LightyActivator.activate(payload.duration());
        });
    }
}
