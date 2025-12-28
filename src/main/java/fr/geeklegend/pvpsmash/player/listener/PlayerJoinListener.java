package fr.geeklegend.pvpsmash.player.listener;

import fr.geeklegend.pvpsmash.game.GameListener;
import fr.geeklegend.pvpsmash.PvpSmash;
import fr.geeklegend.pvpsmash.game.GameManager;
import fr.geeklegend.pvpsmash.game.GameState;
import fr.geeklegend.pvpsmash.player.PlayerManager;
import fr.geeklegend.pvpsmash.scheduler.WaitingCountdownScheduler;
import fr.geeklegend.pvpsmash.utils.MessageUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener extends GameListener {

  private final PlayerManager playerManager;

  public PlayerJoinListener(PlayerManager playerManager) {
    this.playerManager = playerManager;
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();

    GameManager gameManager = PvpSmash.getInstance().getGameManager();
    GameState gameState = gameManager.getGameState();

    if (gameState == GameState.WAITING) {
      if (gameManager.canStartGame()) {
        gameManager.setStartingWaitingCountdown(true);

        PvpSmash.getInstance().getSchedulerManager().startScheduler("waiting_countdown", new WaitingCountdownScheduler());
      }

      playerManager.setupPlayerForLobby(player);

      PvpSmash.getInstance().getScoreboardManager().createScoreboard(player,
          MessageUtil.getMessageFromConfig("lobby.scoreboard.title"),
          MessageUtil.getListMessageFromConfig("lobby.scoreboard.lines", "%online_players%",
              String.valueOf(PvpSmash.getInstance().getServer().getOnlinePlayers().size()), "%max_players%",
              String.valueOf(PvpSmash.getInstance().getServer().getMaxPlayers()),
              "%game_status%", MessageUtil.getMessageFromConfig("lobby.scoreboard.status_messages.waiting")));

      event.setJoinMessage(MessageUtil.getMessageFromConfig("messages.join")
          .replace("%player_name%", player.getName())
          .replace("%online_players%", String.valueOf(PvpSmash.getInstance().getServer().getOnlinePlayers().size()))
          .replace("%max_players%", String.valueOf(PvpSmash.getInstance().getServer().getMaxPlayers())));
    }
  }
}
