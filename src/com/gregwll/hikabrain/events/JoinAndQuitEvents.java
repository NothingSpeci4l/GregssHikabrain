package com.gregwll.hikabrain.events;

import com.gregwll.hikabrain.Main;
import com.gregwll.hikabrain.game.Game;
import com.gregwll.hikabrain.game.Queue;
import com.gregwll.hikabrain.game.Teams;
import com.gregwll.hikabrain.game.kits.Kits;
import com.gregwll.hikabrain.utils.HashUtils;
import com.gregwll.hikabrain.utils.IsIG;
import net.minecraft.server.v1_8_R3.ItemSaddle;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinAndQuitEvents implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage("");
        player.sendMessage("§f[§6§lHikabrain§f] Bienvenue sur le serveur, bon jeu ! ");
        Bukkit.broadcastMessage("§f[§a+§f] " + player.getName());

        player.getInventory().clear();
        player.setGameMode(GameMode.SURVIVAL);
        player.teleport(Main.getLocations().getLocationFromName("lobby"));

        Kits.giveLobbyKit(player);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage("");
        Bukkit.broadcastMessage("§f[§4-§f] " + player.getName());

        if(IsIG.isIg(player.getName())) {
            Game game = Main.getQueue().getGame();
            Teams leaverTeam = HashUtils.getKey(game.gethashmap(), player);
            if(leaverTeam == (Teams.BLUE)) {
                game.stop(game.gethashmap().get(Teams.RED),player);
            } else if(leaverTeam == (Teams.RED)) {
                game.stop(game.gethashmap().get(Teams.BLUE),player);
            }

        }
    }
}
