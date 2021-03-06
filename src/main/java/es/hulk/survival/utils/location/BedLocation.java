package es.hulk.survival.utils.location;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class BedLocation {

    private Location location;

    public static int bedCoordinateX(Player player) {
        return (int) player.getBedSpawnLocation().getX();
    }

    public static int bedCoordinateY(Player player) {
        return (int) player.getBedSpawnLocation().getY();
    }

    public static int bedCoordinateZ(Player player) {
        return (int) player.getBedSpawnLocation().getZ();
    }

    public static String getBedWorld(Player player) {
        switch (player.getBedSpawnLocation().getWorld().getName()) {
            case "world":
                return "Overworld";
            case "world_nether":
                return "Nether";
            case "world_the_end":
                return "The End";
            default:
                return "No World Found";
        }
    }

    public static Location getBedLocation(Player player) {
        if (player.getBedSpawnLocation() != null) {
            return new Location(player.getBedSpawnLocation().getWorld(), bedCoordinateX(player), bedCoordinateY(player), bedCoordinateZ(player));
        }
        return null;
    }

}
