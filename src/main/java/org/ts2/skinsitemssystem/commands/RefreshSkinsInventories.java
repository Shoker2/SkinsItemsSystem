package org.ts2.skinsitemssystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.ts2.skinsitemssystem.SkinsItemsSystem;

public class RefreshSkinsInventories implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender.hasPermission("skinsitemssystem.refreshskinsinventories")) {
            World world;
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                world = player.getWorld();

            } else if (commandSender instanceof BlockCommandSender) {
                BlockCommandSender blockCommandSender = (BlockCommandSender) commandSender;
                world = blockCommandSender.getBlock().getWorld();
            } else {world = Bukkit.getWorld("world");}

            for(Player p: world.getPlayers()) {
                for (int i=0; i<41; i++) {
                    ItemStack itemStack = p.getInventory().getItem(i);
                    if (itemStack != null) {
                        SkinsItemsSystem.changeSkin(p, itemStack);
                    }
                }
                p.updateInventory();
            }

        } else {
            commandSender.sendMessage(SkinsItemsSystem.color(SkinsItemsSystem.instance.getConfig().getString("Messages.NotAvailableSkins")));
            return true;
        }

        return false;
    }
}
