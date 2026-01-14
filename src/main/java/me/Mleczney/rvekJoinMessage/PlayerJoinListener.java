package me.Mleczney.rvekJoinMessage;

import me.Mleczney.rvekCore.RvekCore;
import me.Mleczney.rvekCore.api.MessageAPI;
import me.Mleczney.rvekCore.api.SoundAPI;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);

        var player = event.getPlayer();
        var cfg = RvekCore.get().getConfig();

        // Zpráva hráči
        String joinMsg = cfg.getString("join-message")
                .replace("%player%", player.getName());
        MessageAPI.send(player, joinMsg);

        // Broadcast
        String broadcastMsg = cfg.getString("broadcast-message")
                .replace("%player%", player.getName());
        MessageAPI.broadcast(broadcastMsg);

        // Zvuk
        String sound = cfg.getString("sound.name");
        float volume = (float) cfg.getDouble("sound.volume");
        float pitch = (float) cfg.getDouble("sound.pitch");

        SoundAPI.play(player, sound, volume, pitch);
    }
}
