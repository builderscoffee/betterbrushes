package eu.builderscoffee.betterbrushes;

import com.thevoxelbox.voxelsniper.VoxelSniperPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private VoxelSniperPlugin voxelSniper;

    public void onEnable() {
        voxelSniper = (VoxelSniperPlugin) VoxelSniperPlugin.getPlugin();
        voxelSniper.getBrushRegistry().register(ErodeBlendBallBrush.properties());
    }
}
