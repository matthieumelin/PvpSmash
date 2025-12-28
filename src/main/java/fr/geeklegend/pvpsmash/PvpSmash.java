package fr.geeklegend.pvpsmash;

import org.bukkit.plugin.java.JavaPlugin;

public class PvpSmash extends JavaPlugin {

  private static PvpSmash instance;

  @Override
  public void onEnable() {
    instance = this;

    saveDefaultConfig();

    System.out.println("PvpSmash plugin enabled!");
  }

  @Override
  public void onDisable() {
    saveConfig();

    instance = null;

    System.out.println("PvpSmash plugin disabled!");
  }

  public static PvpSmash getInstance() {
    return instance;
  }
}
