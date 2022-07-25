package github.totorewa.paper.thugtweaks.features.impl;

import github.totorewa.paper.thugtweaks.adapters.nms.MobCategoryProviderAdapter;
import github.totorewa.paper.thugtweaks.factories.MobCapStateFactory;
import github.totorewa.paper.thugtweaks.features.GlobalMobCapEnforcer;
import github.totorewa.paper.thugtweaks.world.MobCapCategory;
import github.totorewa.paper.thugtweaks.world.MobCapState;
import github.totorewa.paper.thugtweaks.world.MobCategoryProvider;
import org.bukkit.entity.LivingEntity;

import java.util.OptionalInt;

public class GlobalMobCapEnforcerImpl implements GlobalMobCapEnforcer {
    private final MobCapStateFactory mobCapStateFactory;
    private final MobCategoryProvider categoryProvider;

    public GlobalMobCapEnforcerImpl(MobCapStateFactory factory, MobCategoryProvider categoryProvider) {
        this.mobCapStateFactory = factory;
        this.categoryProvider = categoryProvider;
    }

    public GlobalMobCapEnforcerImpl() {
        this(new MobCapStateFactory(), new MobCategoryProviderAdapter());
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isMobCategoryFull(LivingEntity bukkitEntity) {
        MobCapState mobCapState = mobCapStateFactory.createState(bukkitEntity.getWorld());
        if (!mobCapState.isValid()) return false;
        MobCapCategory category = categoryProvider.getCategory(bukkitEntity);
        OptionalInt globalLimit = mobCapState.getGlobalCap(category);
        return globalLimit.isPresent() && mobCapState.getMobCount(category) >= globalLimit.getAsInt();
    }
}
