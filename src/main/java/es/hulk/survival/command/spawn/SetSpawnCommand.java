package es.hulk.survival.command.spawn;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SetSpawnCommand extends BaseCommand {

    @Command(name = "setspawn", permission = "survival.command.setspawn")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        Location playerLocation = player.getLocation();
        Survival.get().setCounter(25);

        Survival.get().getSpawnManager().setSpawnLocation(player.getLocation());
        player.sendMessage(Utils.color("&6Spawn location has been set to "
                + playerLocation.getX() + " "
                + playerLocation.getY() + " "
                + playerLocation.getZ() + " ("
                + playerLocation.getWorld().getName() + ")"));
    }
}
