package me.Jonnyfant.UndeadHorseLeash;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class UndeadHorseLeashListener implements Listener {
    @EventHandler
    public void onLeashing(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        if (entity != null) {
            if (entity instanceof ZombieHorse || entity instanceof SkeletonHorse) {
                ((AbstractHorse) entity).setTamed(true);
                Player player = event.getPlayer();
                PlayerInventory inventory = player.getInventory();
                ItemStack itemInHand = inventory.getItemInMainHand();
                ItemStack itemInOffHand = inventory.getItemInOffHand();
                if (itemInHand.getType().equals(Material.LEAD)) {
                    ((LivingEntity) entity).setLeashHolder((Entity) player);
                    inventory.setItemInMainHand(new ItemStack(Material.LEAD, inventory.getItemInMainHand().getAmount() - 1));
                    event.setCancelled(true);
                } else if (itemInOffHand.getType().equals(Material.LEAD)) {
                    ((LivingEntity) entity).setLeashHolder((Entity) player);
                    inventory.setItemInOffHand(new ItemStack(Material.LEAD, inventory.getItemInOffHand().getAmount() - 1));
                    event.setCancelled(true);
                }
            }
        }
    }
}
