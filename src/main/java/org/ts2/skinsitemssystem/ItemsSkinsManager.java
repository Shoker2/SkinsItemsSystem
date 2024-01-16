package org.ts2.skinsitemssystem;

import org.bukkit.NamespacedKey;
import org.bukkit.configuration.MemorySection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.ts2.skinsitemssystem.SkinsItemsSystem;
import org.ts2.skinsitemssystem.UserDataManager;

import java.util.HashSet;
import java.util.Set;

public class ItemsSkinsManager {
    public static String getItemName(ItemStack itemStack) {
        try {
            String skinName = itemStack.getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString("skinsitemssystem_itemname"), PersistentDataType.STRING);
            if (skinName != null) {
                return skinName;
            }
        } catch (java.lang.NullPointerException e) {}

        return null;
    }

    public static boolean getChangeableSkin(ItemStack itemStack) {
        try {
            boolean changeable = Boolean.parseBoolean(itemStack.getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString("skinsitemssystem_changeable"), PersistentDataType.STRING));

            if (!changeable) {
                boolean changed = Boolean.parseBoolean(itemStack.getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString("skinsitemssystem_changed"), PersistentDataType.STRING));

                if (changed) {
                    return false;
                } else {
                    return true;
                }
            }

            return changeable;

        } catch (java.lang.NullPointerException e) {}

        return true;
    }

    public static int getPlayerSkinCustomModelData(String playerName, String itemName) {
        String skinName = UserDataManager.getSelectedSkin(playerName, itemName);
        int customModelData = SkinsItemsSystem.instance.getConfig().getInt("Items." + itemName + "." + skinName);

        return customModelData;
    }

    public static Set<String> getItemsList() {
        MemorySection itemsMemory = (MemorySection) SkinsItemsSystem.instance.getConfig().get("Items");
        Set<String> items = itemsMemory.getKeys(false);
        if (items == null) {
            items = new HashSet<String>();
        }
        return items;
    }

    public static Set<String> getSkinsList(String itemName) {
        MemorySection skinsMemory = (MemorySection) SkinsItemsSystem.instance.getConfig().get("Items." + itemName);
        Set<String> skins = skinsMemory.getKeys(false);
        if (skins == null) {
            skins = new HashSet<String>();
        }
        return skins;
    }
}
