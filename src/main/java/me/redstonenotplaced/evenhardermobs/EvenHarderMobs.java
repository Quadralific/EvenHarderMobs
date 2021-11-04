package me.redstonenotplaced.evenhardermobs;

import me.redstonenotplaced.evenhardermobs.commands.CommandEnd;
import me.redstonenotplaced.evenhardermobs.commands.CommandStart;
import me.redstonenotplaced.evenhardermobs.events.SpawnEvent;
import me.redstonenotplaced.evenhardermobs.manager.MobManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class EvenHarderMobs extends JavaPlugin {
    private final MobManager manager = new MobManager();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new SpawnEvent(manager), this);
        getCommand("start").setExecutor(new CommandStart(manager));
        getCommand("end").setExecutor(new CommandEnd(manager));
    }
}