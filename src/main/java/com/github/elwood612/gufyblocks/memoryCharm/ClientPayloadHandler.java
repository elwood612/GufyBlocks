package com.github.elwood612.gufyblocks.memoryCharm;

import net.neoforged.neoforge.network.handling.IPayloadContext;

public class ClientPayloadHandler
{
    public static void handle(WorkstationResponse payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            MemoryCharmClient.workstationPos = payload.pos().orElse(null);
        });
    }
}
