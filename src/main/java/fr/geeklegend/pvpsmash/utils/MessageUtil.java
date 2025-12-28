package fr.geeklegend.pvpsmash.utils;

import fr.geeklegend.pvpsmash.PvpSmash;
import java.util.List;
import org.bukkit.ChatColor;

public class MessageUtil {

  public static String translateColorCodes(String message) {
    return ChatColor.translateAlternateColorCodes('&', message);
  }

  public static String getMessageFromConfig(String path) {
    return translateColorCodes(PvpSmash.getInstance().getConfig().getString(path)
        .replace("%prefix%", PvpSmash.getInstance().getConfig().getString("messages.prefix")));
  }

  public static List<String> getListMessageFromConfig(String path) {
    List<String> messages = PvpSmash.getInstance().getConfig().getStringList(path);
    return messages.stream()
        .map(MessageUtil::translateColorCodes)
        .toList();
  }

  public static List<String> getListMessageFromConfig(String path, String... replacements) {
    List<String> messages = PvpSmash.getInstance().getConfig().getStringList(path);
    for (int i = 0; i < replacements.length; i += 2) {
      String placeholder = replacements[i];
      String value = replacements[i + 1];
      messages.replaceAll(line -> line.replace(placeholder, value));
    }
    return messages.stream()
        .map(MessageUtil::translateColorCodes)
        .toList();
  }

}
