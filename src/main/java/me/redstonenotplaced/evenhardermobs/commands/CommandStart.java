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

public class CommandStart implements CommandExecutor, TabCompleter {
    private final MobManager mobManager;

    public CommandStart(MobManager mobManager) {
        this.mobManager = mobManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(mobManager.getMobState() == MobState.DISABLED) {
                mobManager.setMobState(MobState.ENABLED);
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6&l\u279C CHALLENGE HAS STARTED!!!"));
            } else {
                sender.sendMessage(ChatColor.RED + "The challenge is already started!!!");
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return new ArrayList<>();
    }
}