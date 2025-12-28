package fr.geeklegend.pvpsmash.player.listener;

import fr.geeklegend.pvpsmash.PvpSmash;
import fr.geeklegend.pvpsmash.game.GameListener;
import fr.geeklegend.pvpsmash.game.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener extends GameListener {

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event) {
    GameState gameState = PvpSmash.getInstance().getGameManager().getGameState();

    if (gameState != GameState.IN_GAME) {
      if (event.getAction() == Action.PHYSICAL) {
        event.setCancelled(true);
      }
    }
  }
}
