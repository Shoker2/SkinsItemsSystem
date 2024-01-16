package org.ts2.skinsitemssystem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.ts2.skinsitemssystem.commands.*;

import java.util.ArrayList;
import java.util.List;

public final class SkinsItemsSystem extends JavaPlugin {
    public static Plugin instance;
    public static CustomFileConfiguration UsersData;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.instance = this;
        this.UsersData = new CustomFileConfiguration("UsersData.yml");
        Bukkit.getPluginManager().registerEvents(new Events(), this);

        getCommand("setskin").setExecutor(new SetSkin());
        getCommand("addavailableskin").setExecutor(new AddAvailableSkin());
        getCommand("removeavailableskin").setExecutor(new RemoveAvailableSkin());
        getCommand("setitemname").setExecutor(new SetItemName());
        getCommand("sisreload").setExecutor(new Sisreload());
        getCommand("refreshskinsinventories").setExecutor(new RefreshSkinsInventories());

        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PlaceHolderIntegration().register();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static String color(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static List<String> color(List<String> lore){
        List<String> clore = new ArrayList<>();
        for(String s : lore){
            clore.add(color(s));
        }
        return clore;
    }

    public static void changeSkin(Player player, ItemStack itemStack) {
        boolean changeable = ItemsSkinsManager.getChangeableSkin(itemStack);
        if (changeable) {
            String itemName = ItemsSkinsManager.getItemName(itemStack);

            if (itemName != null) {
                int skinModel = ItemsSkinsManager.getPlayerSkinCustomModelData(player.getName(), itemName);
                ItemMeta itemMeta = itemStack.getItemMeta();

                itemMeta.setCustomModelData(skinModel);
                itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("skinsitemssystem_changed"), PersistentDataType.STRING, "true");

                itemStack.setItemMeta(itemMeta);
            }
        }
    }
}
