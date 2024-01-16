package org.ts2.skinsitemssystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.ts2.skinsitemssystem.SkinsItemsSystem;
import org.ts2.skinsitemssystem.UserDataManager;

public class SetSkin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.hasPermission("skinsitemssystem.setskin")) {
            if (strings.length == 3) {
                String playerName = strings[0];
                String itemName = strings[1];
                String skinName = strings[2];

                UserDataManager.setSelectedSkin(playerName, itemName, skinName);
                return true;
            }
        } else {
            commandSender.sendMessage(SkinsItemsSystem.color(SkinsItemsSystem.instance.getConfig().getString("Messages.NotAvailableSkins")));
            return true;
        }

        return false;
    }
}
