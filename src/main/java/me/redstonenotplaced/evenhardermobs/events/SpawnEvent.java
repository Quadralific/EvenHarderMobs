package me.redstonenotplaced.evenhardermobs.events;

import me.redstonenotplaced.evenhardermobs.manager.MobManager;
import me.redstonenotplaced.evenhardermobs.state.MobState;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpawnEvent implements Listener {
    private final MobManager mobManager;

    public SpawnEvent(MobManager manager) {
        this.mobManager = manager;
    }

    //TODO: I plan to add more mobs
    @EventHandler
    public void onSpawn(CreatureSpawnEvent e) {
        if(mobManager.getMobState() == MobState.ENABLED) {
            switch(e.getEntityType()) {
                case ZOMBIE:
                    mobManager.giveArmor((Zombie) e.getEntity(), Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE,
                            Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS);
                    mobManager.giveWeapon((Zombie) e.getEntity(), new ItemStack(Material.DIAMOND_AXE), Enchantment.DAMAGE_ALL, 5);
                    break;
                case SKELETON:
                    mobManager.giveArmor((Skeleton) e.getEntity(), Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE,
                            Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS);
                    mobManager.giveWeapon((Skeleton) e.getEntity(), new ItemStack(Material.BOW), Enchantment.ARROW_KNOCKBACK, 2);
                    break;
                case CREEPER:
                    Creeper creeper = (Creeper) e.getEntity();
                    creeper.setPowered(true);
                    creeper.setExplosionRadius(10);
                    break;
                case SPIDER:
                    Spider spider = (Spider) e.getEntity();
                    spider.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 4, true, true));
                    spider.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 4, true, true));
                    break;
            }
        }
    }
}
