package fr.geeklegend.pvpsmash.world;

import fr.geeklegend.pvpsmash.IManager;
import fr.geeklegend.pvpsmash.PvpSmash;
import java.io.File;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public class WorldManager implements IManager {

  private final PvpSmash instance;
  private World world;
  private Location location;

  public WorldManager(PvpSmash instance) {
    this.instance = instance;
    this.world = instance.getServer().getWorld(instance.getConfig().getString("lobby.world"));
    this.location = new Location(
        world,
        instance.getConfig().getDouble("lobby.x"),
        instance.getConfig().getDouble("lobby.y"),
        instance.getConfig().getDouble("lobby.z"),
        (float) instance.getConfig().getDouble("lobby.yaw"),
        (float) instance.getConfig().getDouble("lobby.pitch")
    );

    setup();
  }

  @Override
  public void onEnable() {
  }

  @Override
  public void onDisable() {

  }

  private void setup() {
    if (world == null) {
      instance.getServer().getConsoleSender().sendMessage("§c[PvPSmash] Le monde du lobby est introuvable !");
      return;
    }

    instance.getServer().getConsoleSender().sendMessage("§a[PvPSmash] Le monde du lobby a été chargé avec succès !");
  }
}
