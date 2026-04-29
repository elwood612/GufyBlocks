package com.github.elwood612.gufyblocks.packets;

import com.github.elwood612.gufyblocks.GufyBlocks;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

// more robust server-client version check
public record GufyVersionCheckPayload(String serverVersion) implements CustomPacketPayload
{
    public static final Type<GufyVersionCheckPayload> TYPE =
            new Type<>(Identifier.fromNamespaceAndPath(GufyBlocks.MODID, "version_check"));

    public static final StreamCodec<FriendlyByteBuf, GufyVersionCheckPayload> CODEC =
            StreamCodec.of(
                    (buf, payload) -> buf.writeUtf(payload.serverVersion),
                    buf -> new GufyVersionCheckPayload(buf.readUtf())
            );
    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
