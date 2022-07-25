package github.totorewa.paper.thugtweaks.features;

public interface ThugtweakFeature {
    default boolean isEnabled() {
        return false;
    }
}
