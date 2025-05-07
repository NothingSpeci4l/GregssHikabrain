package com.gregwll.hikabrain.events;

import com.gregwll.hikabrain.utils.IsIG;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class SpawnGameProtection implements Listener {
    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        ItemStack currentItem = event.getItemDrop().getItemStack();
        if(!currentItem.getType().equals(Material.GOLDEN_APPLE)) {event.setCancelled(true);}
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        if(event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if(!IsIG.isIg(player.getName())) {
                event.setCancelled(true);
            }
        }
    }
}
