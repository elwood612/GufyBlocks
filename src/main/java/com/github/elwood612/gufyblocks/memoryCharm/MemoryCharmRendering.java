package com.github.elwood612.gufyblocks.memoryCharm;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.SubmitCustomGeometryEvent;

public class MemoryCharmRendering
{
    @SubscribeEvent
    public static void onRender(SubmitCustomGeometryEvent event) {
        BlockPos pos = MemoryCharmClient.workstationPos;
        if (pos == null) return;

        Vec3 cameraPos = event.getLevelRenderState().cameraRenderState.pos;
        PoseStack poseStack = event.getPoseStack();
        poseStack.pushPose();
        poseStack.translate(
                pos.getX() - cameraPos.x,
                pos.getY() - cameraPos.y,
                pos.getZ() - cameraPos.z
        );

        event.getSubmitNodeCollector().submitShapeOutline(
                poseStack,
                Shapes.block(),
                RenderTypes.lines(),
                0xFFFFFFFF, // White
                8.0F,       // Line width
                true
        );

        poseStack.popPose();
    }
}
