package github.totorewa.paper.thugtweaks.world;

import org.bukkit.entity.LivingEntity;

public interface MobCategoryProvider {
    MobCapCategory getCategory(LivingEntity entity);
}
