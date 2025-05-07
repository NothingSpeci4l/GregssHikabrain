package com.gregwll.hikabrain.game;

import com.gregwll.hikabrain.Main;
import com.gregwll.hikabrain.game.kits.Kits;
import com.gregwll.hikabrain.utils.IsIG;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Death {

    public static void reSpawnMethod(Player player) {

        if(IsIG.isIg(player.getName())) {
            Game game = Main.getQueue().getGame();
            Teams team = game.getTeam(player);

            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                if(team == Teams.BLUE) {
                    player.teleport(Main.getLocations().getLocationFromName("bluespawn"));
                    player.getInventory().clear();
                    Kits.giveBlueStuff(player);
                    if(player.getLastDamageCause() instanceof Player) {
                        Bukkit.broadcastMessage(Main.getMsgPrefix() + "§6§l" + player.getPlayer() +"§f à été tué par §6§l" + game.gethashmap().get(Teams.RED));
                    }
                } else if(team == Teams.RED) {
                    player.teleport(Main.getLocations().getLocationFromName("redspawn"));
                    Kits.giveRedStuff(player);
                    if(player.getLastDamageCause() instanceof Player) {
                        Bukkit.broadcastMessage(Main.getMsgPrefix() + "§6§l" + player.getPlayer() +"§f à été tué par §6§l" + game.gethashmap().get(Teams.BLUE));
                    }
                }
            }, 5L);
        }

    }
}
