package es.hulk.survival.managers.warp;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.location.LocationSeralizer;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class WarpManager {

    private final Map<String, Warp> warps = new HashMap<>();
    private ArrayList<String> names = new ArrayList<>();
    private final Survival plugin;

    public WarpManager(Survival plugin) {
        this.plugin = plugin;
    }

    public Warp getWarpByName(String name) {
        return this.warps.get(name);
    }

    public List<String> getWarpListByName() {
        return new ArrayList<>(this.warps.keySet());
    }

    public void createWarp(String warpName, Location location) {
        this.warps.put(warpName, new Warp(warpName, location));
        names.add(warpName);
    }

    public void deleteWarpByName(String warpName) {
        this.warps.remove(warpName);
        names.remove(warpName);
    }

    public void clearWarp() {
        this.warps.clear();
        names.clear();
    }


    public void serializeLocation(Warp warp) {
        FileConfiguration config = plugin.getConfig();
        Location location = warp.getLocation().clone();

        LocationSeralizer.serializeLocation(location);

        String world = location.getWorld().getName();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();
        double yaw = location.getYaw();
        double pitch = location.getPitch();

        config.set("WARPS." + warp.getName() + ".WORLD", world);
        config.set("WARPS." + warp.getName() + ".X", x);
        config.set("WARPS." + warp.getName() + ".Y", y);
        config.set("WARPS." + warp.getName() + ".Z", z);
        config.set("WARPS." + warp.getName() + ".YAW", yaw);
        config.set("WARPS." + warp.getName() + ".PITCH", pitch);

        plugin.saveConfig();
    }

    public void saveWarps() {
        for (String warpName : this.warps.keySet()) {
            this.serializeLocation(this.warps.get(warpName));
        }
    }

    public void loadWarps() {
        FileConfiguration config = plugin.getConfig();
        if(!config.isConfigurationSection("warps")) return;

        for(String warpName : config.getConfigurationSection("warps").getKeys(false)){

            World world = Bukkit.getWorld(config.getString("WARPS." + warpName + ".WORLD"));
            double x = config.getDouble("WARPS." + warpName + ".X");
            double y = config.getDouble("WARPS." + warpName + ".Y");
            double z = config.getDouble("WARPS." + warpName + ".Z");
            float yaw = (float) config.getDouble("WARPS." + warpName + ".YAW");
            float pitch = (float) config.getDouble("WARPS." + warpName + ".PITCH");

            Location location = new Location(world, x, y, z, yaw, pitch);
            this.warps.put(warpName, new Warp(warpName, location));
        }
        config.set("WARPS", null);
        plugin.saveConfig();
    }
}
