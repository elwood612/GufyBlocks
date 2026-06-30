package com.github.elwood612.gufyblocks.packets;

import com.github.elwood612.gufyblocks.GufyBlocks;
import com.github.elwood612.gufyblocks.util.GufyHighlightRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record GufyHighlightWorkstationPacket(BlockPos pos) implements CustomPacketPayload
{
    public static final Type<GufyHighlightWorkstationPacket> TYPE =
            new Type<>(Identifier.fromNamespaceAndPath(GufyBlocks.MODID, "highlight_workstation"));

    public static final StreamCodec<FriendlyByteBuf, GufyHighlightWorkstationPacket> CODEC =
            StreamCodec.of(
                    (buf, payload) -> buf.writeBlockPos(payload.pos),
                    buf -> new GufyHighlightWorkstationPacket(buf.readBlockPos())
            );
    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(GufyHighlightWorkstationPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> GufyHighlightRenderer.highlight(packet.pos));
    }
}
