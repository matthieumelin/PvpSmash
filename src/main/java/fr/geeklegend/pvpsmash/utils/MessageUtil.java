package fr.geeklegend.pvpsmash.utils;

import fr.geeklegend.pvpsmash.PvpSmash;
import org.bukkit.ChatColor;

public class MessageUtil {
    public static String translateColorCodes(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String getMessageFromConfig(String path) {
        return translateColorCodes(PvpSmash.getInstance().getConfig().getString(path)
                .replace("%prefix%", PvpSmash.getInstance().getConfig().getString("messages.prefix")));
    }

}
