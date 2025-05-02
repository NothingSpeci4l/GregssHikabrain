package com.gregwll.hikabrain.events;

import com.gregwll.hikabrain.Main;
import com.gregwll.hikabrain.game.Game;
import com.gregwll.hikabrain.game.Teams;
import com.gregwll.hikabrain.utils.IsIG;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatEvents implements Listener {

    @EventHandler
    public void onChat(PlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        Game game = Main.getQueue().getGame();
        event.setCancelled(true);
        if(!IsIG.isIg(player.getName())) {
            Bukkit.broadcastMessage("§f[§7Sans equipe§f] " + player.getName() + "§7: " + message);
        } else {
            if(game.getTeam(player) == Teams.BLUE) {
                Bukkit.broadcastMessage("§f[§1Bleu§f] " + player.getName() + "§7: " + message);
            } else {
                Bukkit.broadcastMessage("§f[§4Red§f] " + player.getName() + "§7: " + message);
            }
        }

    }
}
