package fr.geeklegend.pvpsmash.player.listener;

import fr.geeklegend.pvpsmash.GameListener;
import fr.geeklegend.pvpsmash.PvpSmash;
import fr.geeklegend.pvpsmash.utils.MessageUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener extends GameListener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage(MessageUtil.getMessageFromConfig("messages.join")
                .replace("%player_name%", player.getName())
                .replace("%online_players%", String.valueOf(PvpSmash.getInstance().getServer().getOnlinePlayers().size()))
                .replace("%max_players%", String.valueOf(PvpSmash.getInstance().getServer().getMaxPlayers())));
    }
}
