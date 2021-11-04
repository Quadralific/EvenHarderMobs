package me.redstonenotplaced.evenhardermobs.commands;

import me.redstonenotplaced.evenhardermobs.manager.MobManager;
import me.redstonenotplaced.evenhardermobs.state.MobState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandEnd implements CommandExecutor, TabCompleter {
    private final MobManager mobManager;

    public CommandEnd(MobManager mobManager) {
        this.mobManager = mobManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(mobManager.getMobState() == MobState.ENABLED) {
                mobManager.setMobState(MobState.DISABLED);
                Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "\u279C THE CHALLENGE HAS ENDED!!!");
            } else {
                sender.sendMessage(ChatColor.RED + "The challenge is already disabled!!!");
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return new ArrayList<>();
    }
}