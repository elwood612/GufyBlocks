package com.github.elwood612.gufyblocks.packets;

import com.github.elwood612.gufyblocks.GufyBlocks;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

// simply for the client-server handshake
public record GufyPayload() implements CustomPacketPayload
{
    public static final Type<GufyPayload> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(GufyBlocks.MODID, "required"));

    public static final StreamCodec<ByteBuf, GufyPayload> CODEC =
            StreamCodec.unit(new GufyPayload());

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
