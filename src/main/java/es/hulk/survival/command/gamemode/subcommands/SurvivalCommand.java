package es.hulk.survival.command.gamemode.subcommands;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.GameMode;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class SurvivalCommand extends BaseCommand {

    @Command(name = "survivalm", aliases = "sm")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        Survival.get().setCounter(20);

        if (player.getStatistic(Statistic.PLAY_ONE_MINUTE) >= 2160000) {
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage(Utils.color("&aYou are being putted into Survival Mode"));
        } else {
            player.sendMessage(Utils.color(Utils.getPREFIX() + "&cNecesitas minimo 30h dentro del servidor &7(Usa el comando /playtime para ver el tiempo que llevas jugado)"));
        }
    }

}
