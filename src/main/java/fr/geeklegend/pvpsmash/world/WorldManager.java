package fr.geeklegend.pvpsmash.world;

import fr.geeklegend.pvpsmash.IManager;
import fr.geeklegend.pvpsmash.PvpSmash;

import fr.geeklegend.pvpsmash.world.listener.WorldWeatherChangeListener;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class WorldManager implements IManager {

  private final PvpSmash instance;
  private final World world;

  public WorldManager(PvpSmash instance) {
    this.instance = instance;
    this.world = instance.getServer().getWorld(instance.getConfig().getString("lobby.world"));
  }

  @Override
  public void onEnable() {
    world.setSpawnLocation(new Location(
            world,
            instance.getConfig().getDouble("lobby.x"),
            instance.getConfig().getDouble("lobby.y"),
            instance.getConfig().getDouble("lobby.z"),
            (float) instance.getConfig().getDouble("lobby.yaw"),
            (float) instance.getConfig().getDouble("lobby.pitch")));

    setup();
    registerListeners();
  }

  @Override
  public void onDisable() {

  }

  @Override
  public void registerListeners() {
    new WorldWeatherChangeListener();
  }

  private void setup() {
    if (world == null) {
      instance.getServer().getConsoleSender().sendMessage("§c[PvPSmash] Le monde du lobby est introuvable !");
      return;
    }

    world.setFullTime(1000L);
    world.setStorm(false);
    world.setThundering(false);
    world.setThunderDuration(0);
    world.setWeatherDuration(0);

    world.getEntities().stream().filter(entity -> entity.getType() != EntityType.PLAYER)
            .forEach(Entity::remove);

    instance.getServer().getConsoleSender().sendMessage("§a[PvPSmash] Le monde du lobby a été chargé avec succès !");
  }

  public World getWorld() {
    return world;
  }
}
