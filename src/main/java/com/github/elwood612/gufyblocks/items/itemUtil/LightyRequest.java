package com.github.elwood612.gufyblocks.items.itemUtil;

import com.github.elwood612.gufyblocks.GufyBlocks;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record LightyRequest(int duration) implements CustomPacketPayload
{
    public static final Type<LightyRequest> TYPE =
            new Type<>(Identifier.fromNamespaceAndPath(GufyBlocks.MODID, "lighty_request"));

    public static final StreamCodec<ByteBuf, LightyRequest> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.VAR_INT,
                    LightyRequest::duration,
                    LightyRequest::new
            );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
