package github.totorewa.paper.thugtweaks.features.noop;

import github.totorewa.paper.thugtweaks.features.SyncDayTime;
import org.bukkit.World;

public class SyncDayTimeNoop implements SyncDayTime {
    @Override
    public void syncAllDayTimes(World world, long offset) {
    }
}
