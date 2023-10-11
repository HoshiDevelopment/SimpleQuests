package nuqluy.simplequests;

import nuqluy.simplequests.handlers.NewPlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleQuests extends JavaPlugin {

    public static SimpleQuests plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("SimpleQuests Loaded!");

        saveDefaultConfig();

        new NewPlayerJoin(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("SimpleQuests shutting down...");
    }
}
