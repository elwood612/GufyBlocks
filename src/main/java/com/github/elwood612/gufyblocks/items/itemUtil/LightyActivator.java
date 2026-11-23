package com.github.elwood612.gufyblocks.items.itemUtil;

import net.minecraft.client.Minecraft;
import net.neoforged.fml.ModList;

import java.lang.reflect.Method;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class LightyActivator
{
    private static Method toggleMethod;
    private static Method getStateMethod;
    private static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(r -> {
        Thread thread = new Thread(r, "LightyCompat-Timer");
        thread.setDaemon(true);
        return thread;
    });
    private static ScheduledFuture<?> deactivationTimer;

    public static boolean isLightyLoaded;

    public static void initialize() {
        isLightyLoaded = ModList.get().isLoaded("lighty");
        if (!isLightyLoaded) return;

        try {
            Class<?> smach = Class.forName("dev.schmarrn.lighty.overlaystate.SMACH");
            getStateMethod = smach.getMethod("getState");
            toggleMethod = smach.getMethod("toggle");

            if (Minecraft.getInstance().player == null) return;
            if (getState().equals("ON")) toggle(); // turn it off if for some reason it's already on

        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    public static void activate(int duration) {
        if (!isLightyLoaded) return;
        if (toggleMethod == null) return;
        if (getStateMethod == null) return;

        Minecraft.getInstance().execute(() -> {
            String state = getState();

            if (state.equals("OFF")) toggle();

            if (deactivationTimer != null) {
                deactivationTimer.cancel(false);
            }

            deactivationTimer = scheduler.schedule(() -> {
                Minecraft.getInstance().execute(() -> {
                    if (getState().equals("ON")) toggle();
                });
            }, duration, TimeUnit.SECONDS);
        });
    }

    public static void cleanup() {
        if (toggleMethod != null) toggleMethod = null;
        if (getStateMethod != null) getStateMethod = null;
        if (deactivationTimer != null) {
            deactivationTimer.cancel(false);
            deactivationTimer = null;
        }
    }

    private static void toggle() {
        if (toggleMethod == null) return;

        Minecraft.getInstance().execute(() -> {
            try {
                toggleMethod.invoke(null);
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        });
    }

    private static String getState() {
        if (getStateMethod == null) return "UNAVAILABLE";

        try {
            return getStateMethod.invoke(null).toString();
        } catch (ReflectiveOperationException e) {
            return "UNAVAILABLE";
        }
    }
}
