package es.hulk.survival.command.essential;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class KillCommand extends BaseCommand {

    private final FileConfig messagesConfig = Survival.get().getMessagesConfig();
    @Command(name = "suicide")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        Survival.get().setCounter(15);

        player.setHealth(0.0D);
        Bukkit.broadcastMessage(Utils.color(messagesConfig.getString("KILL_COMMAND.BROADCAST")).replace("<player>", player.getDisplayName()));
    }
}
