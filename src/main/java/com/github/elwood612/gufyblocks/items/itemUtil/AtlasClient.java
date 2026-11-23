package com.github.elwood612.gufyblocks.items.itemUtil;

import com.github.elwood612.gufyblocks.GufyBlocks;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;

import java.util.Arrays;

@EventBusSubscriber(modid = GufyBlocks.MODID, value = Dist.CLIENT)
public class AtlasClient {
    public static void openMap() {
        Minecraft mc = Minecraft.getInstance();
        Arrays.stream(mc.options.keyMappings)
                .filter(key -> key.getName().equals("gui.xaero_open_map"))
                .findFirst()
                .ifPresent(mapping -> KeyMapping.click(mapping.getKey()));
    }
}
