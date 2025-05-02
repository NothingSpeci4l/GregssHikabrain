package com.gregwll.hikabrain.game;

import com.gregwll.hikabrain.Main;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Queue {

    ArrayList<Player> list = new ArrayList<>();

    public Queue() {

    }

    public void addPlayer(Player player) {
        if(!list.isEmpty()) {
            list.add(player);

            if(!Main.isGameStarted) {
                lancer(player);
                list.clear();
            }
        } else {
            list.add(player);
            player.sendMessage(Main.getMsgPrefix() + "Vous avez rejoins la file d'attente !");
        }
    }

    public void removePlayer(Player player) {
        if(list.contains(player)) {
            list.remove(player);
            player.sendMessage(Main.getMsgPrefix() + "Vous avez quitté la file d'attente !");
        } else {
            Main.logger.sendError("this player isnt in queue");
        }
    }

    public boolean isInQueue(Player player) {
        if(list.contains(player)) {
            return true;
        } else {
            return false;
        }
    }
    Game game;
    private void lancer(Player player) {
        game = new Game(list.get(0), list.get(1));
        game.start();
    }

    public Game getGame() {
        return game;
    }
}
