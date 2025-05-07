package com.gregwll.hikabrain.events;

import com.gregwll.hikabrain.Main;
import com.gregwll.hikabrain.game.Game;
import com.gregwll.hikabrain.game.Queue;
import com.gregwll.hikabrain.game.Teams;
import com.gregwll.hikabrain.game.kits.Kits;
import com.gregwll.hikabrain.utils.IsIG;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scoreboard.Team;

public class GameDeathKillEvents implements Listener {

    //no death screen
    @EventHandler
    public void onDeatsh(PlayerDeathEvent event) {
        event.getEntity().getPlayer().spigot().respawn();
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        event.setDeathMessage("");

        if(IsIG.isIg(player.getName())) {
            Game game = Main.getQueue().getGame();
            Teams team = game.getTeam(player);


            if(team == Teams.BLUE) {
                player.teleport(Main.getLocations().getLocationFromName("bluespawn"));
                player.getInventory().clear();
                Kits.giveBlueStuff(player);
            } else if(team == Teams.RED) {
                player.teleport(Main.getLocations().getLocationFromName("redspawn"));
                Kits.giveRedStuff(player);
            }


        }
    }

    @EventHandler
    public void onMoove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if(event.getFrom().getY() < 5) {
            player.getInventory().clear();
            player.setHealth(0);
            Bukkit.broadcastMessage(Main.getMsgPrefix() + "§6§l" + player.getName() + "§f est tombé chef !");
        }

    }
}
