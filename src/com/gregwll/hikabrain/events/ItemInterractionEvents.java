package com.gregwll.hikabrain.events;

import com.gregwll.hikabrain.Main;
import com.gregwll.hikabrain.game.Queue;
import com.gregwll.hikabrain.game.Spectator;
import com.gregwll.hikabrain.utils.IsIG;
import com.gregwll.hikabrain.utils.IsSpec;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemInterractionEvents implements Listener {
    Queue queue = Main.getQueue();

    @EventHandler
    public void onInterract(PlayerInteractEvent event) {
        ItemStack currentItem = event.getItem();
        Player player = event.getPlayer();
        Action currentAction = event.getAction();


        if(currentAction != Action.LEFT_CLICK_AIR && currentAction != Action.LEFT_CLICK_BLOCK) {
            if(currentItem.getType().equals(Material.NETHER_STAR)) {
                if(!queue.isInQueue(player)) {
                    queue.addPlayer(player);
                } else {
                    queue.removePlayer(player);
                }
            } else if(currentItem.getType().equals(Material.WEB)) {
                if(!IsIG.isIg(player.getName())) {
                    if(!IsSpec.isSpec(player.getName())) {
                        Spectator.toggleSpectator(player);
                    } else {
                        player.sendMessage(Main.getMsgPrefix() + "Vous êtes déjà en spectateur ! ");
                    }
                } else {
                    player.sendMessage(Main.getMsgPrefix() +"Vous ne pouvez pas aller en mode spéctateur durant une partie !");
                }
            }
        }

    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        ItemStack item = event.getItemDrop().getItemStack();
        if(item.getType() == Material.NETHER_STAR) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void inventoryClickEvent(InventoryClickEvent event) {
        ItemStack currentItem = event.getCurrentItem();
        if(currentItem.getType() == Material.NETHER_STAR) {
            event.setCancelled(true);
        }
    }
}
