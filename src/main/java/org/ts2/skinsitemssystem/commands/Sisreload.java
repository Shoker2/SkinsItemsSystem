package org.ts2.skinsitemssystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.ts2.skinsitemssystem.SkinsItemsSystem;

public class Sisreload implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender.hasPermission("skinsitemssystem.sisreload")) {
           SkinsItemsSystem.instance.reloadConfig();
            return true;
        }

        return false;
    }
}
