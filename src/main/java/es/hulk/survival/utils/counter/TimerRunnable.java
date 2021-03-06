package es.hulk.survival.utils.counter;

import es.hulk.survival.Survival;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Hulk
 * at 17/04/2022 15:26
 * Project: Survival
 * Class: TimerRunnable
 */
@Getter
@Setter
public class TimerRunnable extends BukkitRunnable {
    private int seconds = 0;
    @Override
    public void run() {
        if (!Survival.get().isCounterEnabled()) {
            try {
                this.finalize();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        seconds++;
    }
}
