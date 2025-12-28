package fr.geeklegend.pvpsmash.player;

import fr.geeklegend.pvpsmash.IManager;
import fr.geeklegend.pvpsmash.PvpSmash;
import fr.geeklegend.pvpsmash.player.listener.EntityDamageListener;
import fr.geeklegend.pvpsmash.player.listener.FoodLevelChangeListener;
import fr.geeklegend.pvpsmash.player.listener.InventoryClickListener;
import fr.geeklegend.pvpsmash.player.listener.PlayerDropItemListener;
import fr.geeklegend.pvpsmash.player.listener.PlayerInteractListener;
import fr.geeklegend.pvpsmash.player.listener.PlayerJoinListener;
import fr.geeklegend.pvpsmash.player.listener.PlayerQuitListener;

import fr.geeklegend.pvpsmash.utils.ItemBuilder;
import fr.geeklegend.pvpsmash.utils.MessageUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerManager implements IManager {

  private final List<PlayerData> playerDatas;

  public PlayerManager() {
    this.playerDatas = new ArrayList<>();
  }

  @Override
  public void onEnable() {
    registerListeners();
  }

  @Override
  public void onDisable() {

  }

  @Override
  public void registerListeners() {
    new PlayerJoinListener(this);
    new PlayerQuitListener(this);
    new PlayerDropItemListener();
    new PlayerInteractListener();
    new EntityDamageListener();
    new FoodLevelChangeListener();
    new InventoryClickListener();
  }

  private void giveLobbyItem(Player player, String key) {
    boolean enabled = PvpSmash.getInstance().getConfig().getBoolean("lobby.items." + key + ".enabled");

    if (!enabled) {
      return;
    }

    int slot = PvpSmash.getInstance().getConfig().getInt("lobby.items." + key + ".slot");
    Material material = Material.getMaterial(PvpSmash.getInstance().getConfig().getString("lobby.items." + key + ".material"));
    String name = MessageUtil.translateColorCodes(PvpSmash.getInstance().getConfig().getString("lobby.items." + key + ".name"));
    List<String> lore = MessageUtil.getListMessageFromConfig("lobby.items." + key + ".lore");
    ItemStack itemStack = new ItemBuilder(material).setName(name).setLore(lore).toItemStack();

    player.getInventory().setItem(slot, itemStack);
  }

  public void setupPlayerForLobby(Player player) {
    player.setFoodLevel(20);
    player.setHealth(20.0);
    player.setGameMode(GameMode.ADVENTURE);
    player.getInventory().clear();
    player.getEquipment().clear();
    player.teleport(PvpSmash.getInstance().getWorldManager().getWorld().getSpawnLocation());

    giveLobbyItem(player, "return_to_lobby");
  }

  public void initPlayerData(UUID uuid) {
    PlayerData playerData = getPlayerData(uuid);
    if (playerData == null) {
      playerDatas.add(new PlayerData(uuid));
    }
  }

  public void deletePlayerData(UUID uuid) {
    PlayerData playerData = getPlayerData(uuid);
    if (playerData != null) {
      playerDatas.remove(playerData);
    }
  }

  public PlayerData getPlayerData(UUID uuid) {
    return playerDatas.stream().filter(playerData -> playerData.getUuid() == uuid).findFirst().orElse(null);
  }

}
