package io.simplequests.handlers;

import io.simplequests.SimpleQuests;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class NewPlayerJoin implements Listener {

    public NewPlayerJoin(SimpleQuests plugin) {Bukkit.getPluginManager().registerEvents(this, plugin);}

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        try {
            if (!e.getPlayer().hasPlayedBefore()) {
                UUID playerID = e.getPlayer().getUniqueId();
                SimpleQuests.plugin.getConfig().set("blocks_broken." + playerID, 0);
                SimpleQuests.plugin.getConfig().set("blocks_placed." + playerID, 0);
            }
            SimpleQuests.plugin.getConfig().set("players."+e.getPlayer().getUniqueId(), e.getPlayer().getName());

        } catch (Exception err) {
            Bukkit.getLogger().info("err");
        }
    }


}
