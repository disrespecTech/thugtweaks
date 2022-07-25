package github.totorewa.paper.thugtweaks.features.impl;

import github.totorewa.paper.thugtweaks.features.SyncDayTime;
import org.bukkit.Server;
import org.bukkit.World;

public class SyncDayTimeImpl implements SyncDayTime {
    private final Server server;

    public SyncDayTimeImpl(Server server) {
        this.server = server;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public void syncAllDayTimes(World world, long offset) {
        if (world.getEnvironment() != World.Environment.NORMAL) return; // Shouldn't happen but w/e

        long dayTime = (world.getFullTime() + offset) % TICKS_PER_DAY;
        for (World otherWorld : server.getWorlds()) {
            if (otherWorld.getUID().equals(world.getUID())) continue;
            // Instead of just setting the world time to match, adjust the time of day.
            long tickAdjustment = otherWorld.getFullTime() % TICKS_PER_DAY;
            tickAdjustment = tickAdjustment > dayTime
                ? (TICKS_PER_DAY - tickAdjustment) + dayTime
                : dayTime - tickAdjustment;
            otherWorld.setFullTime(otherWorld.getFullTime() + tickAdjustment);
        }
    }
}
