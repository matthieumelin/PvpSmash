package fr.geeklegend.pvpsmash.world.listener;

import fr.geeklegend.pvpsmash.game.GameListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener extends GameListener {

  @EventHandler
  public void onBlockBreak(BlockBreakEvent event) {
    event.setCancelled(true);
  }
}
