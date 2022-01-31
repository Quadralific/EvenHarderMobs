package me.redstonenotplaced.evenhardermobs.manager;

import me.redstonenotplaced.evenhardermobs.state.MobState;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MobManager {
    private MobState state = MobState.NOT_SUPER;

    /**
     * Gets the current mob state
     *
     * @return Returns the current mob state
     */
    public MobState getMobState() {
        return state;
    }

    /**
     * Sets the current mob state to a new mob state
     *
     * @param state The state that we will set
     */
    public void setMobState(MobState state) {
        if(this.state == state) return;
        this.state = state;
    }

    /**
     * Gives the living entity armor
     *
     * @param entity The entity to give
     * @param helmet The helmet to give
     * @param chestplate The chestplate to give
     * @param leggings The leggings to give
     * @param boots The boots to give
     */
    public void giveArmor(LivingEntity entity, Material helmet, Material chestplate, Material leggings, Material boots) {
        entity.getEquipment().setHelmet(new ItemStack(helmet));
        entity.getEquipment().setChestplate(new ItemStack(chestplate));
        entity.getEquipment().setLeggings(new ItemStack(leggings));
        entity.getEquipment().setBoots(new ItemStack(boots));
        entity.getEquipment().setHelmetDropChance(0.0F);
        entity.getEquipment().setChestplateDropChance(0.0F);
        entity.getEquipment().setLeggingsDropChance(0.0F);
        entity.getEquipment().setBootsDropChance(0.0F);
    }

    /**
     * Gives the living entity armor
     *
     * @param entity The entity to give
     * @param helmet The helmet to give
     * @param chestplate The chestplate to give
     * @param leggings The leggings to give
     * @param boots The boots to give
     */
    public void giveArmor(LivingEntity entity, ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots) {
        entity.getEquipment().setHelmet(helmet);
        entity.getEquipment().setChestplate(chestplate);
        entity.getEquipment().setLeggings(leggings);
        entity.getEquipment().setBoots(boots);
        entity.getEquipment().setHelmetDropChance(0.0F);
        entity.getEquipment().setChestplateDropChance(0.0F);
        entity.getEquipment().setLeggingsDropChance(0.0F);
        entity.getEquipment().setBootsDropChance(0.0F);
    }

    /**
     * Gives the entity a weapon
     *
     * @param entity The entity to give
     * @param weapon The weapon to give to the entity
     */
    public void giveWeapon(LivingEntity entity, ItemStack weapon) {
        entity.getEquipment().setItemInMainHand(weapon);
        entity.getEquipment().setItemInMainHandDropChance(0.0F);
    }

    /**
     * Adds potion effect to the entity with no particles and has infinite time
     *
     * @param entity The entity to give
     * @param type The potion effect type
     * @param amplifier The amplifier
     */
    public void addPotionEffect(LivingEntity entity, PotionEffectType type, int amplifier) {
        entity.addPotionEffect(new PotionEffect(type, Integer.MAX_VALUE, amplifier, false, false));
    }

    /**
     * Adds potion effect to the entity with no particles
     *
     * @param entity The entity to give
     * @param type The potion effect type
     * @param duration the duration of the effect
     * @param amplifier The amplifier
     */
    public void addPotionEffect(LivingEntity entity, PotionEffectType type, int duration, int amplifier) {
        // We must multiply the duration to 20 since it's measured in ticks.
        entity.addPotionEffect(new PotionEffect(type, 20 * duration, amplifier, false, false));
    }
}