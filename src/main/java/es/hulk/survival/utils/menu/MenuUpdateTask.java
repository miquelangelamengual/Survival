package es.hulk.survival.utils.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class MenuUpdateTask implements Runnable {

    @Override
    public void run() {
        Menu.currentlyOpenedMenus.forEach((key, value) -> {
            Player player = Bukkit.getPlayer(key);
            if (player != null) {
                if (value.isAutoUpdate()) {
                    value.openMenu(player);
                }
            }
        });
    }
}