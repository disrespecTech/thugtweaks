package github.totorewa.paper.thugtweaks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.world.TimeSkipEvent;

public class EventListener implements Listener {
    private final ThugTweaksPlugin plugin;

    public EventListener(ThugTweaksPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true)
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL && plugin.getGlobalMobCapEnforcer().isMobCategoryFull(event.getEntity()))
            event.setCancelled(true);
    }

    @EventHandler
    public void onSleepSkip(TimeSkipEvent event) {
        if (event.getSkipReason() == TimeSkipEvent.SkipReason.NIGHT_SKIP)
            plugin.getDayTimeSyncer().syncAllDayTimes(event.getWorld(), event.getSkipAmount());
    }
}
