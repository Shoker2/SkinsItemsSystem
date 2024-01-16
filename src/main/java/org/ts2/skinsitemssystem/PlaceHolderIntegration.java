package org.ts2.skinsitemssystem;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class PlaceHolderIntegration extends PlaceholderExpansion {

    @Override
    public @NotNull String getIdentifier() {
        return "skinsitemssystem";
    }

    @Override
    public @NotNull String getAuthor() {
        return "TS2_YourGame";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if (params.equals("")) {return null;}
        List<String> args = Arrays.asList(params.split(";"));

        if (args.get(0).equalsIgnoreCase("checkavailableskin") && args.size() == 3) {
            String itemName = args.get(1);
            String skinName = args.get(2);
            return String.valueOf(UserDataManager.isAvailableSkin(player.getName(), itemName, skinName));
        } else if (args.get(0).equalsIgnoreCase("getskincustommodeldata") && args.size() == 2) {
            String itemName = args.get(1);
            return String.valueOf(ItemsSkinsManager.getPlayerSkinCustomModelData(player.getName(), itemName));
        } else if (args.get(0).equalsIgnoreCase("getstatusavailableskin") && args.size() == 3) {
            String itemName = args.get(1);
            String skinName = args.get(2);

            if (UserDataManager.isSelectedSkin(player.getName(), itemName, skinName)) {
                return SkinsItemsSystem.instance.getConfig().getString("StatusAvailableSkin.Selected");
            } else if (UserDataManager.isAvailableSkin(player.getName(), itemName, skinName)) {
                return SkinsItemsSystem.instance.getConfig().getString("StatusAvailableSkin.Available");
            }
            return SkinsItemsSystem.instance.getConfig().getString("StatusAvailableSkin.NotAvailable");
        }

        return null;
    }
}
