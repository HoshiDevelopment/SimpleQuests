package io.simplequests.commands;

import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import io.simplequests.SimpleQuests;

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

                Player player = Bukkit.getPlayer(args[0]);

                sender.sendMessage("§cShowing stats for: §f" + player.getName());
                int blocksBroken = SimpleQuests.plugin.getConfig().getInt("blocks_broken." + player.getUniqueId());
                int blocksPlaced = SimpleQuests.plugin.getConfig().getInt("blocks_placed." + player.getUniqueId());
                int ironSmelt = SimpleQuests.plugin.getConfig().getInt("iron_ingot_smelted." + player.getUniqueId());
                int goldSmelt = SimpleQuests.plugin.getConfig().getInt("gold_ingot_smelted." + player.getUniqueId());
                int copperSmelt = SimpleQuests.plugin.getConfig().getInt("copper_ingot_smelted." + player.getUniqueId());
                int kelpSmelt = SimpleQuests.plugin.getConfig().getInt("dried_kelp_smelted." + player.getUniqueId());
                int claySmelt = SimpleQuests.plugin.getConfig().getInt("brick_smelted." + player.getUniqueId());
                int glassMade = SimpleQuests.plugin.getConfig().getInt("glass_smelted." + player.getUniqueId());
                int cobbleSmelt = SimpleQuests.plugin.getConfig().getInt("stone_smelted." + player.getUniqueId());
                int logsBurned = SimpleQuests.plugin.getConfig().getInt("charcoal_smelted." + player.getUniqueId());;

                int count = 0;
                count += SimpleQuests.plugin.getConfig().getInt("cooked_rabbit_smelted." + player.getUniqueId());
                count += SimpleQuests.plugin.getConfig().getInt("cooked_cod_smelted." + player.getUniqueId());
                count += SimpleQuests.plugin.getConfig().getInt("cooked_porkchop_smelted." + player.getUniqueId());
                count += SimpleQuests.plugin.getConfig().getInt("cooked_mutton_smelted." + player.getUniqueId());
                count += SimpleQuests.plugin.getConfig().getInt("cooked_chicken_smelted." + player.getUniqueId());
                count += SimpleQuests.plugin.getConfig().getInt("cooked_beef_smelted." + player.getUniqueId());
                count += SimpleQuests.plugin.getConfig().getInt("cooked_salmon_smelted." + player.getUniqueId());
                count += SimpleQuests.plugin.getConfig().getInt("baked_potato_smelted." + player.getUniqueId());
                count += SimpleQuests.plugin.getConfig().getInt("dried_kelp_smelted." + player.getUniqueId());
                int foodCooked = count;



                sender.sendMessage("§cBlocks broken: §f" + blocksBroken);
                sender.sendMessage("§cBlocks placed: §f" + blocksPlaced);
                sender.sendMessage("§cIron ingots smelted: §f" + ironSmelt);
                sender.sendMessage("§cGold ingots smelted: §f" + goldSmelt);
                sender.sendMessage("§cCopper ingots smelted: §f" + copperSmelt);
                sender.sendMessage("§cClay smelted: §f" + claySmelt);
                sender.sendMessage("§cStone smelted: §f" + cobbleSmelt);
                sender.sendMessage("§cKelp cooked: §f" + kelpSmelt);
                sender.sendMessage("§cGlass cooked: §f" + glassMade);
                sender.sendMessage("§cFood cooked: §f" + foodCooked);
                sender.sendMessage("§cLogs burned: §f" + logsBurned);
            } catch (NullPointerException e) {
                sender.sendMessage("§4Error! §cTarget player is offline or doesn't exist.");

            }
        } else {



            int blocksBroken = SimpleQuests.plugin.getConfig().getInt("blocks_broken." + ((Player) sender).getUniqueId());
            int blocksPlaced = SimpleQuests.plugin.getConfig().getInt("blocks_placed." + ((Player) sender).getUniqueId());
            int ironSmelt = SimpleQuests.plugin.getConfig().getInt("iron_ingot_smelted." + ((Player) sender).getUniqueId());
            int goldSmelt = SimpleQuests.plugin.getConfig().getInt("gold_ingot_smelted." + ((Player) sender).getUniqueId());
            int copperSmelt = SimpleQuests.plugin.getConfig().getInt("copper_ingot_smelted." + ((Player) sender).getUniqueId());
            int kelpSmelt = SimpleQuests.plugin.getConfig().getInt("dried_kelp_smelted." + ((Player) sender).getUniqueId());
            int claySmelt = SimpleQuests.plugin.getConfig().getInt("brick_smelted." + ((Player) sender).getUniqueId());
            int glassMade = SimpleQuests.plugin.getConfig().getInt("glass_smelted." + ((Player) sender).getUniqueId());
            int cobbleSmelt = SimpleQuests.plugin.getConfig().getInt("stone_smelted." + ((Player) sender).getUniqueId());
            int logsBurned = SimpleQuests.plugin.getConfig().getInt("charcoal_smelted." + ((Player) sender).getUniqueId());;

            int count = 0;
            count += SimpleQuests.plugin.getConfig().getInt("cooked_rabbit_smelted." + ((Player) sender).getUniqueId());
            count += SimpleQuests.plugin.getConfig().getInt("cooked_cod_smelted." + ((Player) sender).getUniqueId());
            count += SimpleQuests.plugin.getConfig().getInt("cooked_porkchop_smelted." + ((Player) sender).getUniqueId());
            count += SimpleQuests.plugin.getConfig().getInt("cooked_mutton_smelted." + ((Player) sender).getUniqueId());
            count += SimpleQuests.plugin.getConfig().getInt("cooked_chicken_smelted." + ((Player) sender).getUniqueId());
            count += SimpleQuests.plugin.getConfig().getInt("cooked_beef_smelted." + ((Player) sender).getUniqueId());
            count += SimpleQuests.plugin.getConfig().getInt("cooked_salmon_smelted." + ((Player) sender).getUniqueId());
            count += SimpleQuests.plugin.getConfig().getInt("baked_potato_smelted." + ((Player) sender).getUniqueId());
            count += SimpleQuests.plugin.getConfig().getInt("dried_kelp_smelted." + ((Player) sender).getUniqueId());
            int foodCooked = count;



            sender.sendMessage("§cShowing stats for: §f" + sender.getName());
            sender.sendMessage("§cBlocks broken: §f" + blocksBroken);
            sender.sendMessage("§cBlocks placed: §f" + blocksPlaced);
            sender.sendMessage("§cIron ingots smelted: §f" + ironSmelt);
            sender.sendMessage("§cGold ingots smelted: §f" + goldSmelt);
            sender.sendMessage("§cCopper ingots smelted: §f" + copperSmelt);
            sender.sendMessage("§cClay smelted: §f" + claySmelt);
            sender.sendMessage("§cStone smelted: §f" + cobbleSmelt);
            sender.sendMessage("§cKelp cooked: §f" + kelpSmelt);
            sender.sendMessage("§cGlass cooked: §f" + glassMade);
            sender.sendMessage("§cFood cooked: §f" + foodCooked);
            sender.sendMessage("§cLogs burned: §f" + logsBurned);
        }


        return true;
    }

}
