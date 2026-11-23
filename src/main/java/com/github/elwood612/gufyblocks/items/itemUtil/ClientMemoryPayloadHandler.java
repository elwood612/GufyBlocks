package com.github.elwood612.gufyblocks.items.itemUtil;

import net.neoforged.neoforge.network.handling.IPayloadContext;

public class ClientMemoryPayloadHandler
{
    public static void handle(WorkstationResponse payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            MemoryCharmClient.workstationPos = payload.pos().orElse(null);
        });
    }
}
