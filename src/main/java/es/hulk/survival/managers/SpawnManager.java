package es.hulk.survival.managers;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;


public class SpawnManager {

    private final FileConfig spawnConfig = Survival.get().getSpawnConfig();
    @Getter private Location location;

    public void getSpawnLocation() {
        World world = Bukkit.getWorld(spawnConfig.getString("SPAWN_LOCATION.WORLD"));
        double x = spawnConfig.getDouble("SPAWN_LOCATION.X");
        double y = spawnConfig.getDouble("SPAWN_LOCATION.Y");
        double z = spawnConfig.getDouble("SPAWN_LOCATION.Z");
        double yaw = spawnConfig.getDouble("SPAWN_LOCATION.YAW");
        double pitch = spawnConfig.getDouble("SPAWN_LOCATION.PITCH");
        this.location = new Location(world, x, y, z, (float) yaw, (float) pitch);
    }

    public void setSpawnLocation(Location location) {
        spawnConfig.getConfiguration().set("SPAWN_LOCATION.WORLD", location.getWorld().getName());
        spawnConfig.getConfiguration().set("SPAWN_LOCATION.X", location.getX());
        spawnConfig.getConfiguration().set("SPAWN_LOCATION.Y", location.getY());
        spawnConfig.getConfiguration().set("SPAWN_LOCATION.Z", location.getZ());
        spawnConfig.getConfiguration().set("SPAWN_LOCATION.YAW", location.getYaw());
        spawnConfig.getConfiguration().set("SPAWN_LOCATION.PITCH", location.getPitch());
        spawnConfig.save();
    }

}
