package github.totorewa.paper.thugtweaks.world;

import java.util.OptionalInt;

public interface MobCapState {
    boolean isValid();
    int getMobCount(MobCapCategory category);
    OptionalInt getGlobalCap(MobCapCategory category);
}
