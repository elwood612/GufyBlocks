package com.github.elwood612.gufyblocks.memoryCharm;

import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.npc.villager.Villager;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.Optional;

public class ServerPayloadHandler
{
    public static void handle(WorkstationRequest payload, IPayloadContext context) {
        if (!(context.player() instanceof ServerPlayer player)) return;
        Minecraft mc = Minecraft.getInstance();

        // Verify the player is holding the Charm
        boolean isHoldingCharm = mc.player.getMainHandItem().is(GufyUtil.getGufyItem("memory_charm"))
                || mc.player.getOffhandItem().is(GufyUtil.getGufyItem("memory_charm"));
        if (!isHoldingCharm) return;

        // Find the villager
        Entity entity = player.level().getEntity(payload.entityId());
        if (!(entity instanceof Villager villager)) return;

        // Basic distance validation
        if (player.distanceToSqr(villager) > 64) return;

        // Read JOB_SITE
        Optional<GlobalPos> jobSite = villager.getBrain()
                .getMemory(MemoryModuleType.JOB_SITE);

        BlockPos pos = null;

        if (jobSite.isPresent() &&
                jobSite.get().dimension().equals(player.level().dimension())) {
            pos = jobSite.get().pos();
        }

        // Reply to the client
        context.reply(new WorkstationResponse(Optional.ofNullable(pos)));
    }
}
