package fr.geeklegend.pvpsmash.player.listener;

import fr.geeklegend.pvpsmash.PvpSmash;
import fr.geeklegend.pvpsmash.game.GameListener;
import fr.geeklegend.pvpsmash.game.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener extends GameListener {

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    GameState gameState = PvpSmash.getInstance().getGameManager().getGameState();

    if (gameState != GameState.IN_GAME) {
      event.setCancelled(true);
    }
  }

}
