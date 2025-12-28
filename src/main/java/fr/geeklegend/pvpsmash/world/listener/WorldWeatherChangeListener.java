package fr.geeklegend.pvpsmash.world.listener;

import fr.geeklegend.pvpsmash.game.GameListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WorldWeatherChangeListener extends GameListener {
    @EventHandler
    public void onWorldWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }
}
