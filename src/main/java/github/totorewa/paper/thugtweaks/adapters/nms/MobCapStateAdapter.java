package github.totorewa.paper.thugtweaks.adapters.nms;

import github.totorewa.paper.thugtweaks.world.MobCapCategory;
import github.totorewa.paper.thugtweaks.world.MobCapState;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.NaturalSpawner;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;

import java.util.OptionalInt;

public class MobCapStateAdapter implements MobCapState {
    private static final MobCategory[] nmsCategories = MobCategory.values();

    private final NaturalSpawner.SpawnState state;
    private final ServerLevel serverLevel;

    public MobCapStateAdapter(World world) {
        serverLevel = ((CraftWorld)world).getHandle();
        state = serverLevel.getChunkSource().getLastSpawnState();
    }

    @Override
    public boolean isValid() {
        return state != null;
    }

    @Override
    public int getMobCount(MobCapCategory category) {
        if (state == null) return 0;
        return state.getMobCategoryCounts().getOrDefault(nmsCategories[category.ordinal()], 0);
    }

    @Override
    public OptionalInt getGlobalCap(MobCapCategory category) {
        if (state == null) return OptionalInt.empty();
        final int chunks = state.getSpawnableChunkCount();
        if (chunks == 0) return OptionalInt.empty();
        return OptionalInt.of(NaturalSpawner.globalLimitForCategory(serverLevel, nmsCategories[category.ordinal()], chunks));
    }
}
