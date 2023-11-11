package de.justin.worldguardtabcompletion;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class WorldGuardTabCompletion extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new Listner(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
