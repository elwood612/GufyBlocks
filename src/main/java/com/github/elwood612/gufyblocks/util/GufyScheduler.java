package com.github.elwood612.gufyblocks.util;

import net.minecraft.server.level.ServerLevel;

import java.util.*;

public class GufyScheduler
{
    private static final Map<Long, List<ScheduledTask>> TASKS = new HashMap<>();
    private static final Map<UUID, List<ScheduledTask>> PLAYER_TASKS = new HashMap<>();

    public static class ScheduledTask {
        public final Runnable task;
        public final UUID owner;
        public boolean canceled = false;

        public ScheduledTask(Runnable task, UUID owner) {
            this.task = task;
            this.owner = owner;
        }
    }

    public static void schedule(ServerLevel level, int delayTicks, UUID owner, Runnable task) {
        long executeTick = level.getGameTime() + delayTicks;

        ScheduledTask scheduled = new ScheduledTask(task, owner);

        TASKS.computeIfAbsent(executeTick, k -> new ArrayList<>()).add(scheduled);

        if (owner != null) {
            PLAYER_TASKS.computeIfAbsent(owner, k -> new ArrayList<>()).add(scheduled);
        }
    }

    public static void tick(ServerLevel level) {
        long currentTick = level.getGameTime();

        List<ScheduledTask> scheduledTasks = TASKS.remove(currentTick);
        if (scheduledTasks == null) return;

        for (ScheduledTask scheduledTask : scheduledTasks) {
            if (!scheduledTask.canceled) {
                scheduledTask.task.run();
            }
        }
    }

    public static void cancelPlayerTasks(UUID playerID) {
        List<ScheduledTask> tasks = PLAYER_TASKS.remove(playerID);
        if (tasks == null) return;

        for (ScheduledTask task : tasks) {
            task.canceled = true;
        }
    }
}
