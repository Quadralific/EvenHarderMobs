package me.redstonenotplaced.evenhardermobs;

import me.redstonenotplaced.evenhardermobs.commands.CommandEnd;
import me.redstonenotplaced.evenhardermobs.commands.CommandStart;
import me.redstonenotplaced.evenhardermobs.event.DamageEvent;
import me.redstonenotplaced.evenhardermobs.event.SpawnEvent;
import me.redstonenotplaced.evenhardermobs.manager.MobManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class EvenHarderMobs extends JavaPlugin {
    private MobManager manager;

    @Override
    public void onEnable() {
        manager = new MobManager();
        getServer().getPluginManager().registerEvents(new SpawnEvent(manager), this);
        getServer().getPluginManager().registerEvents(new DamageEvent(manager), this);
        getCommand("start").setExecutor(new CommandStart(manager));
        getCommand("end").setExecutor(new CommandEnd(manager));
    }
}