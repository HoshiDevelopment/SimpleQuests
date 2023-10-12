package io.simplequests.handlers;

import io.simplequests.SimpleQuests;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class NewPlayerJoin implements Listener {

    public NewPlayerJoin(SimpleQuests plugin) {Bukkit.getPluginManager().registerEvents(this, plugin);}

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPlayedBefore()) {
            UUID playerID = event.getPlayer().getUniqueId();
            SimpleQuests.plugin.getConfig().set("blocksbrokendata." + playerID, 0);
            SimpleQuests.plugin.getConfig().set("blocksplaceddata." + playerID, 0);
            SimpleQuests.plugin.saveConfig();
        }
    }

}
