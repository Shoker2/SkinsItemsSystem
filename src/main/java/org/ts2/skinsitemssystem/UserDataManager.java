package org.ts2.skinsitemssystem;

import org.bukkit.configuration.MemorySection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDataManager {
    public static void setSelectedSkin(String playerName, String item, String skinName) {
        SkinsItemsSystem.UsersData.getConfig().set("UsersData." + playerName + ".SelectedSkins." + item, skinName);
        SkinsItemsSystem.UsersData.save();
    }

    public static String getSelectedSkin(String playerName, String item) {
        String skinName = SkinsItemsSystem.UsersData.getConfig().getString("UsersData." + playerName + ".SelectedSkins." + item);
        if (skinName == null) {
            return "default";
        }

        return skinName;
    }

    public static void addAvailableSkin(String playerName, String item, String skinName) {
        List<String> skins = getAvailableSkinsList(playerName, item);
        if (!skins.contains(skinName)) {
            skins.add(skinName);
            setAvailableSkinList(playerName, item, skins);
        }
    }

    public static boolean isAvailableSkin(String playerName, String item, String skinName) {
        List<String> skins = getAvailableSkinsList(playerName, item);
        if (skins.contains(skinName)) {
            return true;
        }

        return false;
    }

    public static boolean isSelectedSkin(String playerName, String item, String skinName) {
        if (getSelectedSkin(playerName, item).equals(skinName)) {
            return true;
        }

        return false;
    }

    public static void removeAvailableSkin(String playerName, String item, String skinName) {
        List<String> skins = getAvailableSkinsList(playerName, item);
        if (skins.contains(skinName)) {
            skins.remove(skinName);
            setAvailableSkinList(playerName, item, skins);
        }
    }

    private static void setAvailableSkinList(String playerName, String item, List<String> newSkinsList) {
        SkinsItemsSystem.UsersData.getConfig().set("UsersData." + playerName + ".AvailableSkins." + item, newSkinsList);
        SkinsItemsSystem.UsersData.save();
    }

    public static List<String> getAvailableSkinsList(String playerName, String item) {
        List<String> skins = SkinsItemsSystem.UsersData.getConfig().getStringList("UsersData." + playerName + ".AvailableSkins." + item);
        if (skins == null) {
            skins = new ArrayList<String>();
        }
        return skins;
    }
}
