package me.redstonenotplaced.evenhardermobs.events;

import me.redstonenotplaced.evenhardermobs.manager.MobManager;
import me.redstonenotplaced.evenhardermobs.state.MobState;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
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

    //TODO: I plan to add more mobs powerful.
    @EventHandler
    public void onSpawn(CreatureSpawnEvent e) {
        if(mobManager.getMobState() == MobState.ENABLED) {
            switch(e.getEntityType()) {
                case ZOMBIE:
                    Zombie zombie = (Zombie) e.getEntity();
                    ItemStack diamondAxe = new ItemStack(Material.DIAMOND_AXE);
                    mobManager.giveArmor(zombie, Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE,
                            Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS);
                    diamondAxe.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                    mobManager.giveWeapon(zombie, diamondAxe);
                    break;
                case SKELETON:
                    Skeleton skeleton = (Skeleton) e.getEntity();
                    ItemStack bow = new ItemStack(Material.BOW);
                    mobManager.giveArmor(skeleton, Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE,
                            Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS);
                    bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
                    bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
                    mobManager.giveWeapon(skeleton, bow);
                    break;
                case CREEPER:
                    Creeper creeper = (Creeper) e.getEntity();
                    creeper.setPowered(true);
                    creeper.setExplosionRadius(10);
                    break;
                case SPIDER:
                    Spider spider = (Spider) e.getEntity();
                    spider.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 4, true, false));
                    spider.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 4, true, false));
                    break;
                case ENDERMAN:
                    Enderman enderman = (Enderman) e.getEntity();
                    enderman.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999, 4, true, false));
                    break;
                case DROWNED:
                    Drowned drowned = (Drowned) e.getEntity();
                    ItemStack trident = new ItemStack(Material.TRIDENT);
                    mobManager.giveArmor(drowned, Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS,
                            Material.DIAMOND_BOOTS);
                    trident.addEnchantment(Enchantment.IMPALING, 5);
                    mobManager.giveWeapon(drowned, trident);
                    break;
                case RAVAGER:
                    Ravager ravager = (Ravager) e.getEntity();
                    ravager.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999, 9, true, false));
                    break;
                case PHANTOM:
                    Phantom phantom = (Phantom) e.getEntity();
                    phantom.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 5, true, false));
                    phantom.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 5, true, false));
                    phantom.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999, 5, true, false));
                    break;
            }
        }
    }
}
