package es.hulk.survival.command;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.menu.SettingsMenu;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class SettingsCommand extends BaseCommand {

    @Command(name = "settings", aliases = "opciones")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        Survival.get().setCounter(34);
        new SettingsMenu().openMenu(player);
    }
}
