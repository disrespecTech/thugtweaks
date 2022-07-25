package github.totorewa.paper.thugtweaks;

import org.bukkit.configuration.file.FileConfiguration;

public class ThugTweaksConfiguration {
    private final FileConfiguration config;

    public final boolean enforceGlobalMobCap;
    public final boolean syncDayTime;

    public ThugTweaksConfiguration(FileConfiguration config) {
        this.config = config;

        config.addDefault("version", 1);
        config.addDefault("version-readme", "Please don't update the version");

        config.addDefault("spawning.enforce-global-mobcap", false);
        config.addDefault("world.synchronize-day-time", false);
        config.options().copyDefaults(true);

        this.enforceGlobalMobCap = config.getBoolean("spawning.enforce-global-mobcap", false);
        this.syncDayTime = config.getBoolean("world.synchronize-day-time", false);
    }
}
