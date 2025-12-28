package fr.geeklegend.pvpsmash.scoreboard;

import fr.geeklegend.pvpsmash.IManager;
import fr.mrmicky.fastboard.FastBoard;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.entity.Player;

public class ScoreboardManager implements IManager {

  private final Map<UUID, FastBoard> scoreboards;

  public ScoreboardManager() {
    this.scoreboards = new HashMap<>();
  }

  @Override
  public void onEnable() {
  }

  @Override
  public void onDisable() {

  }

  @Override
  public void registerListeners() {
  }

  public void createScoreboard(Player player, String title, List<String> lines) {
    UUID playerUuid = player.getUniqueId();

    if (!scoreboards.containsKey(playerUuid)) {
      FastBoard board = new FastBoard(player);
      board.updateTitle(title);
      board.updateLines(lines);
      scoreboards.put(playerUuid, board);
    }
  }

  public void updateScoreboard(UUID uuid, String... lines) {
    FastBoard board = scoreboards.get(uuid);
    if (board != null) {
      board.updateLines(lines);
    }
  }

  public void deleteScoreboard(UUID uuid) {
    FastBoard board = scoreboards.remove(uuid);
    if (board != null) {
      board.delete();
    }
  }

  public Map<UUID, FastBoard> getScoreboards() {
    return scoreboards;
  }
}
