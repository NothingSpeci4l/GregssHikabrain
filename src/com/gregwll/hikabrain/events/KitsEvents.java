package com.gregwll.hikabrain.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitsEvents implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Inventory inv = player.getInventory();
        Block block = event.getBlockPlaced();

        if(block.getType() == Material.SANDSTONE) {
            ItemStack blocka = new ItemStack(Material.SANDSTONE, 64);
            ItemMeta metaBlock = blocka.getItemMeta();
            metaBlock.setDisplayName("§2§lBetonDePortugais");
            blocka.setItemMeta(metaBlock);
            inv.setItem(1, blocka);
        }
    }
}
