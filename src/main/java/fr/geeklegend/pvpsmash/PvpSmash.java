package fr.geeklegend.pvpsmash;

import fr.geeklegend.pvpsmash.player.PlayerDataManager;
import fr.geeklegend.pvpsmash.world.WorldManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PvpSmash extends JavaPlugin {

  private static PvpSmash instance;

  private WorldManager worldManager;
  private PlayerDataManager playerDataManager;

  @Override
  public void onEnable() {
    instance = this;

    saveDefaultConfig();

    worldManager = new WorldManager(this);
    worldManager.onEnable();

    playerDataManager = new PlayerDataManager();
    playerDataManager.onEnable();

    System.out.println("PvpSmash plugin enabled!");
  }

  @Override
  public void onDisable() {
    playerDataManager.onDisable();
    worldManager.onDisable();

    saveConfig();

    instance = null;

    System.out.println("PvpSmash plugin disabled!");
  }

  public static PvpSmash getInstance() {
    return instance;
  }

  public WorldManager getWorldManager() {
    return worldManager;
  }

  public PlayerDataManager getPlayerDataManager() {
    return playerDataManager;
  }
}
