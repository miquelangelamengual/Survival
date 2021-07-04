package es.hulk.survival.utils.location;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class OfflinePlayerLocation {

    private static String getWorldName(Player player) {
        return LocationUtils.getWorld(player);
    }

    public static String getWorld(OfflinePlayer offlinePlayer) {
        Player player = offlinePlayer.getPlayer();
        switch (getWorldName(player)) {
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

    public static String coordinateX(OfflinePlayer offlinePlayer) {
        Player player = offlinePlayer.getPlayer();
        return String.valueOf(player.getLocation().getX());
    }

    public static String coordinateY(OfflinePlayer offlinePlayer) {
        Player player = offlinePlayer.getPlayer();
        return String.valueOf(player.getLocation().getY());
    }

    public static String coordinateZ(OfflinePlayer offlinePlayer) {
        Player player = offlinePlayer.getPlayer();
        return String.valueOf(player.getLocation().getZ());
    }

}