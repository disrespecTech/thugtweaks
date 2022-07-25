package github.totorewa.paper.thugtweaks.adapters.nms;

import github.totorewa.paper.thugtweaks.world.MobCapCategory;
import github.totorewa.paper.thugtweaks.world.MobCategoryProvider;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftLivingEntity;
import org.bukkit.entity.LivingEntity;

public class MobCategoryProviderAdapter implements MobCategoryProvider {
    private static final MobCapCategory[] categories = MobCapCategory.values();
    @Override
    public MobCapCategory getCategory(LivingEntity entity) {
        return categories[((CraftLivingEntity)entity).getHandle().getType().getCategory().ordinal()];
    }
}
