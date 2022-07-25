package github.totorewa.paper.thugtweaks.features.noop;

import github.totorewa.paper.thugtweaks.features.GlobalMobCapEnforcer;
import org.bukkit.entity.LivingEntity;

public class GlobalMobCapEnforcerNoop implements GlobalMobCapEnforcer {
    @Override
    public boolean isMobCategoryFull(LivingEntity bukkitEntity) {
        return false;
    }
}
