package com.github.elwood612.gufyblocks.items.itemUtil;

import com.github.elwood612.gufyblocks.GufyBlocks;
import com.github.elwood612.gufyblocks.util.GufyUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.phys.EntityHitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;

@EventBusSubscriber(modid = GufyBlocks.MODID, value = Dist.CLIENT)
public class MemoryCharmClient
{
    public static BlockPos workstationPos = null;
    private static int lastRequestedVillager = -1;

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.level == null) return;

        boolean isHoldingCharm = mc.player.getMainHandItem().is(GufyUtil.getGufyItem("memory_charm"))
                || mc.player.getOffhandItem().is(GufyUtil.getGufyItem("memory_charm"));

        if (!isHoldingCharm
                || !(mc.hitResult instanceof EntityHitResult hit)
                || !(hit.getEntity() instanceof Villager villager)) {
            lastRequestedVillager = -1;
            workstationPos = null;
            return;
        }

        int entityId = villager.getId();

        if (entityId != lastRequestedVillager) {
            lastRequestedVillager = entityId;
            workstationPos = null;
            ClientPacketDistributor.sendToServer(new WorkstationRequest(entityId));
        }
    }
}
