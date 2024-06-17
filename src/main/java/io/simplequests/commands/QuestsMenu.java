package io.simplequests.commands;


import io.simplequests.SimpleQuests;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class QuestsMenu implements Listener, CommandExecutor {
    private String invName = "§b§lSimpleQuests!";

    public QuestsMenu(SimpleQuests plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(invName)) {
            return;
        }

        int page = 0;

        if (event.getView().getTitle().equals(invName)) {page = 1;}


        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();

        if (slot == 12 && page == 1) {
            page = 2;
            player.sendMessage("this was clicked");
        }
        else if (slot == 14 && page == 1) {


            List<String> userData = new ArrayList<>();
            player.sendMessage("§3Showing the top 10 players...");
            List<?> dataGetter;
            dataGetter = SimpleQuests.plugin.getConfig().getList("players");
            player.sendMessage(String.valueOf(dataGetter));

//            for (int i = 0; i < dataGetter+1; i++) {
//                userData.add((List<String>) SimpleQuests.plugin.getConfig().getList("blocksbrokendata")
//                        + ";"
//                        + SimpleQuests.plugin.getConfig().getInt("blocksbrokendata", dataGetter));
//
//
//            }
            player.sendMessage(userData.toString());


        }

        event.setCancelled(true);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command");
            return true;
        }

        Player player = (Player) sender;

        Inventory inv = Bukkit.createInventory(player, 9 * 3, invName);

        inv.setItem(12, getItem(new ItemStack(Material.ENCHANTED_BOOK), "&3&lQuests Progress", "&bClick to see your quests progress!"));
        inv.setItem(14, getItem(new ItemStack(Material.ENCHANTED_BOOK), "&3&lQuests Leaderboard", "&bClick to see the quests leaderboard!"));


        player.openInventory(inv);

        return true;
    }

    private ItemStack getItem(ItemStack item, String name, String ... lore) {
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        List<String> lores = new ArrayList<>();
        for (String s : lore) {
            lores.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(lores);

        item.setItemMeta(meta);
        return item;
    }
}
