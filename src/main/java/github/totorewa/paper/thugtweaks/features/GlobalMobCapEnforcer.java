package github.totorewa.paper.thugtweaks.features;

import org.bukkit.entity.LivingEntity;

public interface GlobalMobCapEnforcer extends ThugtweakFeature {
    boolean isMobCategoryFull(LivingEntity bukkitEntity);
}
