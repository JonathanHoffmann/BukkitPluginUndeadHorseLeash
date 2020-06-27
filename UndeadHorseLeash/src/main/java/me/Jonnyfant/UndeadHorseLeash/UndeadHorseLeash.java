package me.Jonnyfant.UndeadHorseLeash;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class UndeadHorseLeash extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new UndeadHorseLeashListener(), this);
    }
}
