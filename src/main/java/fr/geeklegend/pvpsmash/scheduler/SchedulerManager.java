package fr.geeklegend.pvpsmash.scheduler;

import fr.geeklegend.pvpsmash.IManager;
import fr.geeklegend.pvpsmash.PvpSmash;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.scheduler.BukkitRunnable;

public class SchedulerManager implements IManager {

  private final Map<String, BukkitRunnable> schedulers;

  public SchedulerManager() {
    this.schedulers = new HashMap<>();
  }

  @Override
  public void onEnable() {

  }

  @Override
  public void onDisable() {

  }

  @Override
  public void registerListeners() {

  }

  public void startScheduler(String name, BukkitRunnable runnable) {
    if (!schedulers.containsKey(name)) {
      runnable.runTaskTimerAsynchronously(PvpSmash.getInstance(), 0L, 20L);
    }
    schedulers.put(name, runnable);
  }

  public void stopScheduler(String name) {
    if (schedulers.containsKey(name)) {
      schedulers.get(name).cancel();
      schedulers.remove(name);
    }
  }

  public Map<String, BukkitRunnable> getSchedulers() {
    return schedulers;
  }

  public BukkitRunnable getScheduler(String name) {
    return schedulers.get(name);
  }

}
