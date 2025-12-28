package fr.geeklegend.pvpsmash.player;

import java.util.UUID;

public class PlayerData {
    private final UUID uuid;
    private int kills;

    public PlayerData(UUID uuid) {
        this.uuid = uuid;
        this.kills = 0;
    }

    public void addKill() {
        kills++;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getKills() {
        return kills;
    }
}
