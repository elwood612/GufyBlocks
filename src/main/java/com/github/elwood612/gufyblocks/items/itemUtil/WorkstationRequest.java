package com.github.elwood612.gufyblocks.items.itemUtil;

import com.github.elwood612.gufyblocks.GufyBlocks;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record WorkstationRequest(int entityId) implements CustomPacketPayload
{
    public static final Type<WorkstationRequest> TYPE =
            new Type<>(Identifier.fromNamespaceAndPath(GufyBlocks.MODID, "workstation_request"));

    public static final StreamCodec<ByteBuf, WorkstationRequest> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.VAR_INT,
                    WorkstationRequest::entityId,
                    WorkstationRequest::new
            );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
