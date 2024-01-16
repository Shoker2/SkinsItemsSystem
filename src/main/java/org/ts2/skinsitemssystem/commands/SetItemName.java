package org.ts2.skinsitemssystem.commands;

import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.ts2.skinsitemssystem.SkinsItemsSystem;

public class SetItemName implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.hasPermission("skinsitemssystem.setitemname")) {
            if (strings.length == 2) {
                String skinName = strings[0];
                String changeable = strings[1];

                Player player = (Player) commandSender;
                ItemStack itemStack = player.getItemInHand();
                ItemMeta meta = itemStack.getItemMeta();

                meta.getPersistentDataContainer().set(NamespacedKey.fromString("skinsitemssystem_itemname"), PersistentDataType.STRING, skinName);
                meta.getPersistentDataContainer().set(NamespacedKey.fromString("skinsitemssystem_changeable"), PersistentDataType.STRING, changeable);
                meta.getPersistentDataContainer().set(NamespacedKey.fromString("skinsitemssystem_changed"), PersistentDataType.STRING, "false");
                itemStack.setItemMeta(meta);

                return true;
            }
        } else {
            commandSender.sendMessage(SkinsItemsSystem.color(SkinsItemsSystem.instance.getConfig().getString("Messages.NotAvailableSkins")));
            return true;
        }

        return false;
    }
}
