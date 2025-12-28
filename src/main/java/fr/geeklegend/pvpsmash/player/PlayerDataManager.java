package fr.geeklegend.pvpsmash.player;

import fr.geeklegend.pvpsmash.IManager;
import fr.geeklegend.pvpsmash.player.listener.PlayerJoinListener;
import fr.geeklegend.pvpsmash.player.listener.PlayerQuitListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerDataManager implements IManager {
    private final List<PlayerData> playerDatas;

    public PlayerDataManager() {
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
        new PlayerJoinListener();
        new PlayerQuitListener();
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
