package github.totorewa.paper.thugtweaks.features;

import org.bukkit.World;

public interface SyncDayTime extends ThugtweakFeature {
    long TICKS_PER_DAY = 24000;

    void syncAllDayTimes(World world, long offset);
}
