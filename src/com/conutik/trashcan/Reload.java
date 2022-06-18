package com.conutik.trashcan;

import com.conutik.trashcan.Main;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            final Player player = (Player) sender;
            Main main = Main.main;

            main.reloadConfig();
            main.saveConfig();

            main.updateConfig();

            player.sendMessage(ChatColor.GREEN + "Config Reloaded!");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 3, 2);
            return true;
        }

        return true;
    }
}
