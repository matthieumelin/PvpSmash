package fr.geeklegend.pvpsmash.player.listener;

import fr.geeklegend.pvpsmash.game.GameListener;
import fr.geeklegend.pvpsmash.PvpSmash;
import fr.geeklegend.pvpsmash.player.PlayerManager;
import fr.geeklegend.pvpsmash.utils.MessageUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener extends GameListener {

  private final PlayerManager playerManager;

  public PlayerQuitListener(PlayerManager playerManager) {
    this.playerManager = playerManager;
  }

  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent event) {
    Player player = event.getPlayer();

    event.setQuitMessage(MessageUtil.getMessageFromConfig("messages.quit")
        .replace("%player_name%", player.getName())
        .replace("%online_players%", String.valueOf(PvpSmash.getInstance().getServer().getOnlinePlayers().size() - 1))
        .replace("%max_players%", String.valueOf(PvpSmash.getInstance().getServer().getMaxPlayers())));
  }
}
