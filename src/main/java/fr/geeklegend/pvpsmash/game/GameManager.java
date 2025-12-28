package fr.geeklegend.pvpsmash.game;

import fr.geeklegend.pvpsmash.IManager;
import fr.geeklegend.pvpsmash.PvpSmash;

public class GameManager implements IManager {

  private GameState gameState;

  private boolean startingWaitingCountdown;
  private final int minPlayers;

  public GameManager() {
    this.gameState = GameState.WAITING;
    this.startingWaitingCountdown = false;
    this.minPlayers = PvpSmash.getInstance().getConfig().getInt("lobby.game_start.min_players", 16);
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

  }

  public GameState getGameState() {
    return gameState;
  }

  public void setGameState(GameState gameState) {
    this.gameState = gameState;
  }

  public boolean canStartGame() {
    return PvpSmash.getInstance().getServer().getOnlinePlayers().size() >= minPlayers && !startingWaitingCountdown;
  }

  public void setStartingWaitingCountdown(boolean startingWaitingCountdown) {
    this.startingWaitingCountdown = startingWaitingCountdown;
  }
}
