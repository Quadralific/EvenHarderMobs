package me.redstonenotplaced.evenhardermobs.event;

import me.redstonenotplaced.evenhardermobs.manager.MobManager;
import me.redstonenotplaced.evenhardermobs.state.MobState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffectType;

public class DamageEvent implements Listener {
    private final MobManager manager;

    public DamageEvent(MobManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        // if the entity that is being damage is not a player, then will do nothing.
        if(!(e.getEntity() instanceof Player)) return;
        Player player = (Player) e.getEntity();

        // Checks if the current mob state is super.
        if(manager.getMobState() == MobState.SUPER) {
            switch(e.getDamager().getType()) {
                // If the entity that damage the player is an enderman, then we will give the player blindness for 10 seconds.
                case ENDERMAN:
                    manager.addPotionEffect(player, PotionEffectType.BLINDNESS, 10, 5);
                    break;
                // If the entity that damage the player is a zombie, then we will give the player confusion (nausea) for 5 seconds.
                case ZOMBIE:
                    manager.addPotionEffect(player, PotionEffectType.CONFUSION, 5, 10);
                    break;
                // If the entity that damage the player is a phantom, then we will give the player levitation for 6 seconds.
                case PHANTOM:
                    manager.addPotionEffect(player, PotionEffectType.LEVITATION, 6, 4);
                    break;
                // If the entity that damage the player is a piglin brute, then we will give the player confusion (nausea) for 6 seconds.
                case PIGLIN_BRUTE:
                    manager.addPotionEffect(player, PotionEffectType.CONFUSION, 6, 15);
                    break;
            }
        }
    }
}