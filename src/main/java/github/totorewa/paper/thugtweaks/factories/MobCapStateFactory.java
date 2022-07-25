package github.totorewa.paper.thugtweaks.factories;

import github.totorewa.paper.thugtweaks.adapters.nms.MobCapStateAdapter;
import github.totorewa.paper.thugtweaks.world.MobCapState;
import org.bukkit.World;

public class MobCapStateFactory {
    public MobCapState createState(World world) {
        return new MobCapStateAdapter(world);
    }
}
