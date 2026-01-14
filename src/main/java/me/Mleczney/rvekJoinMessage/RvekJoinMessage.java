package me.Mleczney.rvekJoinMessage;

import org.bukkit.plugin.java.JavaPlugin;

public class RvekJoinMessage extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("RvekJoinMessage enabled!");

        // Registrace listeneru
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("RvekJoinMessage disabled!");
    }
}
