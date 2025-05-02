package com.gregwll.hikabrain.game.kits;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import static org.bukkit.Color.RED;

public class Kits {

    public static void giveLobbyKit(Player player) {
        Inventory inv = player.getInventory();

        ItemStack queue = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta metaQueue = queue.getItemMeta();
        metaQueue.setDisplayName("§6§lRejoindre la file d'attente");
        queue.setItemMeta(metaQueue);

        inv.setItem(4, queue);
    }

    public static void giveRedStuff(Player player) {
        Inventory inv = player.getInventory();

        ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
        ItemMeta metaSword = sword.getItemMeta();
        metaSword.setDisplayName("§4§lEl PRIMOOO");
        metaSword.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
        sword.setItemMeta(metaSword);

        ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE, 1 );
        ItemMeta metaPickaxe = pickaxe.getItemMeta();
        metaPickaxe.setDisplayName("§f§lTopikeur");
        pickaxe.setItemMeta(metaPickaxe);

        ItemStack block = new ItemStack(Material.SANDSTONE, 64);
        ItemMeta metaBlock = block.getItemMeta();
        metaBlock.setDisplayName("§2§lBetonDePortugais");
        block.setItemMeta(metaBlock);

        ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 4);
        ItemMeta metaGapple = gapple.getItemMeta();
        metaGapple.setDisplayName("§6§lLa pomme du seigneur");
        gapple.setItemMeta(metaGapple);

        ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
        ItemMeta metaHelmet = helmet.getItemMeta();
        metaHelmet.setDisplayName("§3§lLe casque du mineur");
        helmet.setItemMeta(metaHelmet);

        ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
        ItemMeta metaBoots = boots.getItemMeta();
        metaBoots.setDisplayName("§f§lNike §7 Air Force 2");
        boots.setItemMeta(metaBlock);

        ItemStack Chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) Chestplate.getItemMeta();
        meta.setDisplayName("§c§lNorthFace");
        meta.setColor(Color.RED);
        Chestplate.setItemMeta(meta);

        ItemStack legging = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta lmeta = (LeatherArmorMeta) legging.getItemMeta();
        lmeta.setDisplayName("§1§lLe short gouffy de matt");
        lmeta.setColor(Color.RED);
        legging.setItemMeta(lmeta);

        inv.setItem(0, sword);
        inv.setItem(1, block);
        inv.setItem(2, pickaxe);
        inv.setItem(3, gapple);
        player.getInventory().setHelmet(helmet);
        player.getInventory().setBoots(boots);
        player.getInventory().setChestplate(Chestplate);
        player.getInventory().setLeggings(legging);
    }

    public static void giveBlueStuff(Player player) {
        Inventory inv = player.getInventory();

        ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
        ItemMeta metaSword = sword.getItemMeta();
        metaSword.setDisplayName("§4§lEl PRIMOOO");
        metaSword.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
        sword.setItemMeta(metaSword);

        ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE, 1 );
        ItemMeta metaPickaxe = pickaxe.getItemMeta();
        metaPickaxe.setDisplayName("§f§lTopikeur");
        pickaxe.setItemMeta(metaPickaxe);

        ItemStack block = new ItemStack(Material.SANDSTONE, 64);
        ItemMeta metaBlock = block.getItemMeta();
        metaBlock.setDisplayName("§2§lBetonDePortugais");
        block.setItemMeta(metaBlock);

        ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 4);
        ItemMeta metaGapple = gapple.getItemMeta();
        metaGapple.setDisplayName("§6§lLa pomme du seigneur");
        gapple.setItemMeta(metaGapple);

        ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
        ItemMeta metaHelmet = helmet.getItemMeta();
        metaHelmet.setDisplayName("§3§lLe casque du mineur");
        helmet.setItemMeta(metaHelmet);

        ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
        ItemMeta metaBoots = boots.getItemMeta();
        metaBoots.setDisplayName("§f§lNike §7 Air Force 2");
        boots.setItemMeta(metaBlock);

        ItemStack Chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) Chestplate.getItemMeta();
        meta.setDisplayName("§c§lNorthFace");
        meta.setColor(Color.BLUE);
        Chestplate.setItemMeta(meta);

        ItemStack legging = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta lmeta = (LeatherArmorMeta) legging.getItemMeta();
        lmeta.setDisplayName("§1§lLe short gouffy de matt");
        lmeta.setColor(Color.BLUE);
        legging.setItemMeta(lmeta);

        inv.setItem(0, sword);
        inv.setItem(1, block);
        inv.setItem(2, pickaxe);
        inv.setItem(3, gapple);
        player.getInventory().setHelmet(helmet);
        player.getInventory().setBoots(boots);
        player.getInventory().setChestplate(Chestplate);
        player.getInventory().setLeggings(legging);
    }
}
