package fr.geeklegend.pvpsmash.scheduler;

import org.bukkit.scheduler.BukkitRunnable;

public abstract class Scheduler extends BukkitRunnable {

  protected int timer;

  public Scheduler(int timer) {
    this.timer = timer;
  }

  public int getTimer() {
    return timer;
  }
}
