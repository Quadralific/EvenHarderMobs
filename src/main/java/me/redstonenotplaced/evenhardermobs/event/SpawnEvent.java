package me.redstonenotplaced.evenhardermobs.event;

import me.redstonenotplaced.evenhardermobs.manager.MobManager;
import me.redstonenotplaced.evenhardermobs.state.MobState;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public final class SpawnEvent implements Listener {
    private final MobManager manager;

    public SpawnEvent(MobManager manager) {
        this.manager = manager;
    }

    // TODO: 1/31/2022 Need to add more super mobs.
    @EventHandler
    public void onSpawn(CreatureSpawnEvent e) {
        // Let see if the current mob state is super. If it is then we will turn the mobs powerful.
        if(manager.getMobState() == MobState.SUPER) {
            switch(e.getEntityType()) {
                case ZOMBIE:
                    // Super Zombie.
                    Zombie zombie = (Zombie) e.getEntity();
                    ItemStack diamondAxe = new ItemStack(Material.DIAMOND_AXE);
                    // Let's give the zombie some diamond armor.
                    manager.giveArmor(zombie, Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS);
                    // Let's add some enchantment on the diamond axe.
                    diamondAxe.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                    // Finally, give the zombie the enchanted diamond axe.
                    manager.giveWeapon(zombie, diamondAxe);
                    break;
                case SKELETON:
                    // Super Skeleton.
                    Skeleton skeleton = (Skeleton) e.getEntity();
                    ItemStack bow = new ItemStack(Material.BOW);
                    // Let's give the skeleton some diamond armor.
                    manager.giveArmor(skeleton, Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS);
                    // Let's add some enchantment on the bow.
                    bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
                    bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
                    // Finally, give the enchanted bow to the skeleton.
                    manager.giveWeapon(skeleton, bow);
                    break;
                case CREEPER:
                    // Super Creeper.
                    Creeper creeper = (Creeper) e.getEntity();
                    // Let's make the creeper supercharged.
                    creeper.setPowered(true);
                    // Let's set the explosion radius of the creeper 15. Might lag the player or the server though.
                    creeper.setExplosionRadius(15);
                    break;
                case SPIDER:
                    // Speedy Spider.
                    Spider spider = (Spider) e.getEntity();
                    // Let's add some potion effects to the spider.
                    manager.addPotionEffect(spider, PotionEffectType.SPEED, 6);
                    manager.addPotionEffect(spider, PotionEffectType.JUMP, 7);
                    break;
                case ENDERMAN:
                    // Super Speedy Enderman.
                    Enderman enderman = (Enderman) e.getEntity();
                    // Speed and Strength potion effects... This seems a little overpowered.
                    manager.addPotionEffect(enderman, PotionEffectType.INCREASE_DAMAGE, 4);
                    manager.addPotionEffect(enderman, PotionEffectType.SPEED, 6);
                    break;
                case DROWNED:
                    // Super Drowned.
                    Drowned drowned = (Drowned) e.getEntity();
                    ItemStack trident = new ItemStack(Material.TRIDENT);
                    // Let's give the drowned some diamond armor.
                    manager.giveArmor(drowned, Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS);
                    // Let's add some enchantments on the trident.
                    trident.addEnchantment(Enchantment.IMPALING, 5);
                    // Finally, give the drowned the enchanted trident.
                    manager.giveWeapon(drowned, trident);
                    break;
                case PHANTOM:
                    // Super Sneaky Speedy Phantom.
                    Phantom phantom = (Phantom) e.getEntity();
                    // Ok this is soo overpowered now.
                    manager.addPotionEffect(phantom, PotionEffectType.INVISIBILITY, 6);
                    manager.addPotionEffect(phantom, PotionEffectType.SPEED, 6);
                    manager.addPotionEffect(phantom, PotionEffectType.INCREASE_DAMAGE, 5);
                    break;
                case SLIME:
                    // Super Speedy Huge Slime?
                    Slime slime = (Slime) e.getEntity();
                    // Let's make the slime's size large.Can cause some lag in the server.
                    slime.setSize(20);
                    // Let's add some potion effects to the slime
                    manager.addPotionEffect(slime, PotionEffectType.SPEED, 4);
                    break;
                case RAVAGER:
                    // Super Ravager.
                    Ravager ravager = (Ravager) e.getEntity();
                    // Let's give the ravager some overpowered potion effects XD.
                    manager.addPotionEffect(ravager, PotionEffectType.INCREASE_DAMAGE, 7);
                    manager.addPotionEffect(ravager, PotionEffectType.SPEED, 8);
                    manager.addPotionEffect(ravager, PotionEffectType.ABSORPTION, 4);
                    break;
                case WITHER_SKELETON:
                    // Super Wither Skeleton.
                    WitherSkeleton witherSkeleton = (WitherSkeleton) e.getEntity();
                    ItemStack netheriteSword = new ItemStack(Material.NETHERITE_SWORD);
                    // Let's give the wither skeleton some diamond armor.
                    manager.giveArmor(witherSkeleton, Material.NETHERITE_HELMET, Material.NETHERITE_CHESTPLATE, Material.NETHERITE_LEGGINGS, Material.NETHERITE_BOOTS);
                    // Let's add some enchantments on the netherite sword.
                    netheriteSword.addEnchantment(Enchantment.FIRE_ASPECT, 3);
                    // Finally, give the sword to the wither skeleton.
                    manager.giveWeapon(witherSkeleton, netheriteSword);
                    break;
                case BLAZE:
                    // Super Blaze.
                    Blaze blaze = (Blaze) e.getEntity();
                    // Let's give the blaze some potion effects.
                    manager.addPotionEffect(blaze, PotionEffectType.ABSORPTION, 5);
                    break;
                case PIGLIN:
                    // Armored Piglin.
                    Piglin piglin = (Piglin) e.getEntity();
                    ItemStack helmet = new ItemStack(Material.GOLDEN_HELMET);
                    ItemStack chestplate = new ItemStack(Material.GOLDEN_CHESTPLATE);
                    ItemStack leggings = new ItemStack(Material.GOLDEN_LEGGINGS);
                    ItemStack boots = new ItemStack(Material.GOLDEN_BOOTS);
                    ItemStack crossBow = new ItemStack(Material.CROSSBOW);
                    // Let's add enchantments to piglin's armor.
                    helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                    chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                    leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                    boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                    helmet.addEnchantment(Enchantment.DURABILITY, 3);
                    chestplate.addEnchantment(Enchantment.DURABILITY, 3);
                    leggings.addEnchantment(Enchantment.DURABILITY, 3);
                    boots.addEnchantment(Enchantment.DURABILITY, 3);
                    // Let's add enchantments to the piglin's crossbow.
                    crossBow.addEnchantment(Enchantment.MULTISHOT, 1);
                    crossBow.addEnchantment(Enchantment.PIERCING, 4);
                    crossBow.addEnchantment(Enchantment.QUICK_CHARGE, 3);
                    // Finally, give the piglin his armor and crossbow.
                    manager.giveArmor(piglin, helmet, chestplate, leggings, boots);
                    manager.giveWeapon(piglin, crossBow);
                    break;
                case PIGLIN_BRUTE:
                    // Super Brute.
                    PiglinBrute piglinBrute = (PiglinBrute) e.getEntity();
                    // Let's give the piglin brute some netherite armor.
                    manager.giveArmor(piglinBrute, Material.NETHERITE_HELMET, Material.NETHERITE_CHESTPLATE, Material.NETHERITE_LEGGINGS, Material.NETHERITE_BOOTS);
                    break;
            }
        }
    }
}