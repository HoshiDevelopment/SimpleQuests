package io.simplequests.handlers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import io.simplequests.SimpleQuests;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.UUID;

public class BlockHandler implements Listener {


    FileConfiguration config = SimpleQuests.plugin.getConfig();

    public BlockHandler(SimpleQuests plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    String getData = SimpleQuests.plugin.getConfig().getString("Iron Smelted");

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        UUID playerID = event.getPlayer().getUniqueId();

        int blockBroken;

        blockBroken = Integer.parseInt(SimpleQuests.plugin.getConfig().getString("blocksbrokendata." + playerID));

        blockBroken += 1;
        SimpleQuests.plugin.getConfig().set("blocksbrokendata." + playerID, blockBroken);
        SimpleQuests.plugin.saveConfig();
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        UUID playerID = event.getPlayer().getUniqueId();

        int blockPlaced;

        blockPlaced = Integer.parseInt(SimpleQuests.plugin.getConfig().getString("blocksplaceddata." + playerID));

        blockPlaced +=1;
        SimpleQuests.plugin.getConfig().set("blocksplaceddata." + playerID, blockPlaced);
        SimpleQuests.plugin.saveConfig();
    }

}
