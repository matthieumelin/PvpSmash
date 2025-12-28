package fr.geeklegend.pvpsmash.world.listener;

import fr.geeklegend.pvpsmash.game.GameListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener extends GameListener {

  @EventHandler
  public void onBlockPlace(BlockPlaceEvent event) {
    event.setCancelled(true);
  }
}
