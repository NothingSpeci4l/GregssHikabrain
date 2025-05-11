package com.gregwll.hikabrain.game;

import com.gregwll.hikabrain.Main;
import com.gregwll.hikabrain.game.kits.Kits;
import com.gregwll.hikabrain.utils.IsSpec;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Spectator {

    public static void toggleSpectator(Player player) {
        player.setGameMode(GameMode.SPECTATOR);
        player.setFlying(true);
        player.sendMessage(Main.getMsgPrefix() + "Vous êtes dès à présent en mode spéctateur ! Pour le quitter, faites /specleave !");
        IsSpec.addPlayer(player.getName());
    }

    public static void untoggleSpectator(Player player) {
        player.setFlying(false);
        player.teleport(Main.getLocations().getLocationFromName("lobby"));
        player.getInventory().clear();
        Kits.giveLobbyKit(player);
        IsSpec.removePlayer(player.getName());
        player.sendMessage(Main.getMsgPrefix() + "Vous avez quitté le mode spectateur !");
    }
}
