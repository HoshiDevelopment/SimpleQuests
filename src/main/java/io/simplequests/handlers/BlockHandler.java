package io.simplequests.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import io.simplequests.SimpleQuests;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;

import java.util.UUID;

public class BlockHandler implements Listener {


    FileConfiguration config = SimpleQuests.plugin.getConfig();

    public BlockHandler(SimpleQuests plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

//    String getData = SimpleQuests.plugin.getConfig().getString("Iron Smelted");

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        UUID playerID = event.getPlayer().getUniqueId();
        int blockBroken;

        try {

            blockBroken = Integer.parseInt(SimpleQuests.plugin.getConfig().getString("blocks_broken." + playerID));

            blockBroken += 1;
            SimpleQuests.plugin.getConfig().set("blocks_broken." + playerID, blockBroken);
            SimpleQuests.plugin.saveConfig();

        } catch (Exception e) {
            SimpleQuests.plugin.getConfig().set("blocks_broken." + playerID, 1);
            SimpleQuests.plugin.saveConfig();
        }


    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        UUID playerID = event.getPlayer().getUniqueId();
        int blockPlaced;

        try {

            blockPlaced = Integer.parseInt(SimpleQuests.plugin.getConfig().getString("blocks_placed." + playerID));

            blockPlaced += 1;
            SimpleQuests.plugin.getConfig().set("blocks_placed." + playerID, blockPlaced);
            SimpleQuests.plugin.saveConfig();

        } catch (Exception e) {
            SimpleQuests.plugin.getConfig().set("blocks_placed." + playerID, 1);
            SimpleQuests.plugin.saveConfig();
        }


    }

    @EventHandler
    public void onSmelt(FurnaceExtractEvent event) {
        UUID playerID = event.getPlayer().getUniqueId();
        int count = event.getItemAmount();
        int addCount;

        String itemName = event.getItemType().toString();

        try {
            addCount = Integer.parseInt(SimpleQuests.plugin.getConfig().getString(itemName.toLowerCase() + "_smelted." + playerID));
            addCount += count;
            SimpleQuests.plugin.getConfig().set(itemName.toLowerCase() + "_smelted." + playerID, addCount);
            SimpleQuests.plugin.saveConfig();


        } catch (Exception e) {
            SimpleQuests.plugin.getConfig().set(itemName.toLowerCase() + "_smelted." + playerID, count);
            SimpleQuests.plugin.saveConfig();
        }

    }

}
