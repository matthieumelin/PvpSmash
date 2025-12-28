package fr.geeklegend.pvpsmash.scheduler;

import fr.geeklegend.pvpsmash.PvpSmash;
import fr.geeklegend.pvpsmash.utils.MessageUtil;

public class WaitingCountdownScheduler extends Scheduler {

  public WaitingCountdownScheduler() {
    super(PvpSmash.getInstance().getConfig().getInt("lobby.game_start.countdown", 10));
  }

  @Override
  public void run() {
    if (timer <= 0) {
      PvpSmash.getInstance().getSchedulerManager().stopScheduler("waiting_countdown");
      return;
    }

    timer--;

    if (timer <= 3) {
      PvpSmash.getInstance().getServer().getOnlinePlayers().forEach(player -> {
        player.sendTitle(MessageUtil.translateColorCodes(PvpSmash.getInstance().getConfig().getString("lobby.game_start.titles.countdown.title")),
            MessageUtil.translateColorCodes(PvpSmash.getInstance().getConfig().getString("llobby.game_start.titles.countdown.subtitle")), 20, 20, 20);
      });
    }

    PvpSmash.getInstance().getServer().getOnlinePlayers().forEach(player -> {
      player.setLevel(timer);
    });
  }
}
