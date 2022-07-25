package github.totorewa.paper.thugtweaks;

import github.totorewa.paper.thugtweaks.features.GlobalMobCapEnforcer;
import github.totorewa.paper.thugtweaks.features.SyncDayTime;
import github.totorewa.paper.thugtweaks.features.impl.GlobalMobCapEnforcerImpl;
import github.totorewa.paper.thugtweaks.features.impl.SyncDayTimeImpl;
import github.totorewa.paper.thugtweaks.features.noop.GlobalMobCapEnforcerNoop;
import github.totorewa.paper.thugtweaks.features.noop.SyncDayTimeNoop;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ThugTweaksPlugin extends JavaPlugin implements Listener {
    private ThugTweaksConfiguration configuration;
    private GlobalMobCapEnforcer globalMobCapEnforcer;
    private SyncDayTime syncDayTime;

    @Override
    public void onEnable() {
        configuration = new ThugTweaksConfiguration(getConfig());
        saveConfig();
        registerFeatures();
        registerEventListeners();
    }

    public GlobalMobCapEnforcer getGlobalMobCapEnforcer() {
        return globalMobCapEnforcer;
    }

    public SyncDayTime getDayTimeSyncer() {
        return syncDayTime;
    }

    private void registerFeatures() {
        globalMobCapEnforcer = configuration.enforceGlobalMobCap ? new GlobalMobCapEnforcerImpl() : new GlobalMobCapEnforcerNoop();
        syncDayTime = configuration.syncDayTime ? new SyncDayTimeImpl(getServer()) : new SyncDayTimeNoop();
    }

    private void registerEventListeners() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new EventListener(this), this);
    }
}
