package com.github.elwood612.gufyblocks.events;

import com.github.elwood612.gufyblocks.GufyBlocks;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockDropsEvent;

@EventBusSubscriber(modid = GufyBlocks.MODID)
public class GufyBlockDropsEvents
{
    // Make spawners drop their eggs
    @SubscribeEvent
    public static void onBreakSpawner(BlockDropsEvent event) {
        if (!(event.getBlockEntity() instanceof SpawnerBlockEntity spawner))
            return;

        Entity entity = spawner.getSpawner().getOrCreateDisplayEntity(
                event.getLevel(),
                event.getPos()
        );
        if (entity == null) return;

        EntityType<?> entityType = entity.getType();
        Item egg = SpawnEggItem.byId(entityType).get().value();

        if (egg == null) return;

        ItemStack eggStack = new ItemStack(egg);

        event.getDrops().add(new ItemEntity(
                event.getLevel(),
                event.getPos().getX() + 0.5,
                event.getPos().getY() + 0.5,
                event.getPos().getZ() + 0.5,
                eggStack
        ));
    }
}
