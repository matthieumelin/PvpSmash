package fr.geeklegend.pvpsmash;

import org.bukkit.event.Listener;

public class GameListener implements Listener {
    public GameListener() {
        PvpSmash.getInstance().getServer().getPluginManager().registerEvents(this, PvpSmash.getInstance());
    }
}
