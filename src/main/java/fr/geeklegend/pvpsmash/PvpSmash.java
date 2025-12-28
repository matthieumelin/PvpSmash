package fr.geeklegend.pvpsmash;

import fr.geeklegend.pvpsmash.game.GameManager;
import fr.geeklegend.pvpsmash.player.PlayerManager;
import fr.geeklegend.pvpsmash.scheduler.SchedulerManager;
import fr.geeklegend.pvpsmash.scoreboard.ScoreboardManager;
import fr.geeklegend.pvpsmash.world.WorldManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PvpSmash extends JavaPlugin {

  private static PvpSmash instance;

  private WorldManager worldManager;
  private PlayerManager playerManager;
  private ScoreboardManager scoreboardManager;
  private SchedulerManager schedulerManager;
  private GameManager gameManager;

  @Override
  public void onEnable() {
    instance = this;

    saveDefaultConfig();

    worldManager = new WorldManager(this);
    worldManager.onEnable();

    playerManager = new PlayerManager();
    playerManager.onEnable();

    scoreboardManager = new ScoreboardManager();
    scoreboardManager.onEnable();

    schedulerManager = new SchedulerManager();
    schedulerManager.onEnable();

    gameManager = new GameManager();
    gameManager.onEnable();
  }

  @Override
  public void onDisable() {
    gameManager.onDisable();
    schedulerManager.onDisable();
    scoreboardManager.onDisable();
    playerManager.onDisable();
    worldManager.onDisable();

    saveConfig();

    instance = null;
  }

  public static PvpSmash getInstance() {
    return instance;
  }

  public WorldManager getWorldManager() {
    return worldManager;
  }

  public PlayerManager getPlayerDataManager() {
    return playerManager;
  }

  public ScoreboardManager getScoreboardManager() {
    return scoreboardManager;
  }

  public SchedulerManager getSchedulerManager() {
    return schedulerManager;
  }

  public GameManager getGameManager() {
    return gameManager;
  }
}
