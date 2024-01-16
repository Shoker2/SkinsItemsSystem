package org.ts2.skinsitemssystem;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getCurrentItem() != null) {
            ItemStack itemStack = event.getCurrentItem();

            if (itemStack.getType().equals(Material.AIR)) {
                itemStack = event.getCursor();
            }

            Player player = (Player) event.getWhoClicked();
            if (player != null) {
                SkinsItemsSystem.changeSkin(player, itemStack);
            }
        }
    }

    @EventHandler
    public void onDrag(InventoryDragEvent event) {
        ItemStack itemStack = event.getOldCursor();
        Player player = (Player) event.getWhoClicked();
        if (player != null) {
            SkinsItemsSystem.changeSkin(player, itemStack);
        }
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent event) {
        SkinsItemsSystem.changeSkin(event.getPlayer(), event.getItem().getItemStack());
    }

    @EventHandler
    public static void onJoin(PlayerJoinEvent event) {
        for (String itemName: ItemsSkinsManager.getItemsList()) {
            if (!UserDataManager.isAvailableSkin(event.getPlayer().getName(), itemName, "default")) {
                UserDataManager.addAvailableSkin(event.getPlayer().getName(), itemName, "default");
            }
        }
    }
}
