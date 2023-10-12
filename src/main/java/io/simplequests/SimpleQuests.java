package io.simplequests;

import io.simplequests.commands.ViewStats;
import io.simplequests.handlers.BlockHandler;
import io.simplequests.handlers.NewPlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleQuests extends JavaPlugin {

    public static SimpleQuests plugin;

    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        Bukkit.getLogger().info("SimpleQuests Loaded!");

        saveDefaultConfig();

        // import commands
        getCommand("stats").setExecutor(new ViewStats(this));

        //import events/handlers
        new NewPlayerJoin(this);
        new BlockHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("SimpleQuests shutting down...");
    }
}
