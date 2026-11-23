package com.github.elwood612.gufyblocks.items.itemUtil;

import com.github.elwood612.gufyblocks.GufyBlocks;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

import java.util.Optional;

public record WorkstationResponse(Optional<BlockPos> pos) implements CustomPacketPayload
{
    public static final Type<WorkstationResponse> TYPE =
            new Type<>(Identifier.fromNamespaceAndPath(GufyBlocks.MODID, "workstation_response"));

    public static final StreamCodec<ByteBuf, WorkstationResponse> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.optional(BlockPos.STREAM_CODEC),
                    WorkstationResponse::pos,
                    WorkstationResponse::new
            );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
