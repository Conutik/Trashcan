package com.conutik.trashcan;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public static Main main;
    public FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        main = this;
        config.addDefault("inventoryname", "'Trashcan'");
        config.addDefault("trashblock", "CAULDRON");
        config.options().copyDefaults(true);
        saveConfig();

        Bukkit.getPluginManager().registerEvents(this, this);
        getCommand("reload").setExecutor(new Reload());
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Trashcan is now working");
    }

    @EventHandler
    public void onRightClick(final PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(!e.getClickedBlock().getType().equals(Material.getMaterial(getConfig().getString("trashblock", "CAULDRON")))) return;
            Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', getConfig().getString("inventoryname", "Trashcan")));
            e.getPlayer().openInventory(inv);
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Trashcan has stopped");
    }

    public void updateConfig() {
        config = getConfig();
    }


}
