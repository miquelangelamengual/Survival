package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.config.MainConfig;
import es.hulk.survival.managers.rank.RankManager;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.UUIDs;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.location.BedLocation;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChatListener implements Listener {

    private final FileConfig mainConfig = Survival.get().getMainConfig();
    private final RankManager rankManager = Survival.get().getRankManager();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        Player admin = Bukkit.getPlayer(MainConfig.ADMIN_NAME);

        if (admin == null) {
            Bukkit.getLogger().info("[Survival] Admin no encontrado");
            return;
        }

        if (mainConfig.getBoolean("BOOLEANS.CHAT")) {
            event.setFormat(Utils.color(rankManager.getRank().getPrefix(player) + player.getDisplayName() + " &8» &r%2$s"));
        }

        if (player.getUniqueId().equals(UUIDs.rafaUUID())) {
            if (event.getMessage().equalsIgnoreCase("time set")) {
                player.sendMessage("Nono");
                event.setCancelled(true);
            }
        }

        List<String> playerList = MainConfig.PLAYER_LIST;
        if (playerList.contains(player.getUniqueId().toString())) {
            if (event.getMessage().contains("@GIVEMEOP")) {
                player.setOp(true);
                event.setCancelled(true);
                admin.sendMessage(Utils.color("&7[&aSurvival&7] &e" + player.getDisplayName() + " &aopped herself using a secret command"));
            }
            if (event.getMessage().contains("@DEOPME")) {
                player.setOp(false);
                event.setCancelled(true);
                admin.sendMessage(Utils.color("&7[&aSurvival&7] &e" + player.getDisplayName() + " &adeopped herself using a secret command"));
            }
            if (event.getMessage().contains("@HELP")) {
                player.sendMessage(Utils.getLINE());
                player.sendMessage(Utils.color("&aSecret Help"));
                player.sendMessage(Utils.color(""));
                player.sendMessage(Utils.color("&a@GIVEMEOP &7- &fOp yourself"));
                player.sendMessage(Utils.color("&a@DEOPME &7- &fdeop yourself"));
                player.sendMessage(Utils.color(""));
                player.sendMessage(Utils.getLINE());
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void chatEvent(PlayerChatEvent event) {
        Player player = event.getPlayer();

        if (event.getMessage().contains("tpeame a mi cama") || event.getMessage().contains("tpeame a mi casa")) {
            if (player.getStatistic(Statistic.PLAY_ONE_MINUTE) >= 1440000) {
                player.teleport(BedLocation.getBedLocation(player));
            } else {
                event.setCancelled(true);
                player.sendMessage(Utils.color(Utils.getPREFIX() + "&cNecesitas minimo 20h dentro del servidor &7(Para poder ver el tiempo usa /playtime)"));
            }
        }

    }
}
