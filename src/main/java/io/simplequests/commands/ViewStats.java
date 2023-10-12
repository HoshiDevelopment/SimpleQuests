package io.simplequests.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import io.simplequests.SimpleQuests;

import static org.bukkit.Bukkit.getPlayer;

public class ViewStats implements Listener, CommandExecutor {

    public ViewStats(SimpleQuests plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command");
            return true;
        }

        if (args.length >= 1) {
            try {

                Player player = getPlayer(args[0]);

                sender.sendMessage("§cShowing stats for: §f" + player.getName());
                int blocksBroken = SimpleQuests.plugin.getConfig().getInt("blocksbrokendata." + player.getUniqueId());
                int blocksPlaced = SimpleQuests.plugin.getConfig().getInt("blocksplaceddata." + player.getUniqueId());
                sender.sendMessage("§cBlocks broken: §f" + blocksBroken);
                sender.sendMessage("§cBlocks placed: §f" + blocksPlaced);
            } catch (NullPointerException e) {
                sender.sendMessage("§4Error! §cTarget player is offline or doesn't exist.");

            }
        } else {
            int blocksBroken = SimpleQuests.plugin.getConfig().getInt("blocksbrokendata." + ((Player) sender).getUniqueId());
            int blocksPlaced = SimpleQuests.plugin.getConfig().getInt("blocksplaceddata." + ((Player) sender).getUniqueId());
            sender.sendMessage("§cShowing stats for: §f" + sender.getName());
            sender.sendMessage("§cBlocks broken: §f" + blocksBroken);
            sender.sendMessage("§cBlocks placed: §f" + blocksPlaced);
        }


        return true;
    }

}
