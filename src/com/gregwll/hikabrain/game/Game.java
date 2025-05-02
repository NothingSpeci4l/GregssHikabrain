package com.gregwll.hikabrain.game;

import com.gregwll.hikabrain.Main;
import com.gregwll.hikabrain.game.kits.Kits;
import com.gregwll.hikabrain.utils.HashUtils;
import com.gregwll.hikabrain.utils.IsIG;
import com.gregwll.hikabrain.utils.Locations;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Game {

    HashMap<Teams, Player> players = new HashMap<>();
    HashMap<Teams, Integer> score = new HashMap<>();
    Locations loc = Main.getLocations();

    public Game(Player p1, Player p2) {
        players.put(Teams.BLUE, p1);
        players.put(Teams.RED, p2);
        score.put(Teams.BLUE, 0);
        score.put(Teams.RED, 0);
    }

    public void start() {
        Player playerBlue = players.get(Teams.BLUE);
        Player playerRed = players.get(Teams.RED);

        IsIG.addPlayer(playerBlue.getName());
        IsIG.addPlayer(playerRed.getName());

        playerRed.sendMessage(Main.getMsgPrefix() + "La partie va débuter");
        playerBlue.sendMessage(Main.getMsgPrefix() + "La partie va débuter");

        playerBlue.teleport(loc.getLocationFromName("bluespawn"));
        playerBlue.getInventory().clear();
        playerRed.teleport(loc.getLocationFromName("redspawn"));
        playerRed.getInventory().clear();

        Kits.giveRedStuff(playerRed);
        Kits.giveBlueStuff(playerBlue);

        Main.isGameStarted = true;

    }

    public void stop(Player winner, Player looser) {
        if(IsIG.isIg(winner.getName())) {
            Teams winnerTeam = HashUtils.getKey(players, winner);
            Teams looserTeam = HashUtils.getKey(players, looser);

            Main.isGameStarted = false;
            winner.getInventory().clear();
            looser.getInventory().clear();
            winner.teleport(Main.getLocations().getLocationFromName("lobby"));
            looser.teleport(Main.getLocations().getLocationFromName("lobby"));
            Kits.giveLobbyKit(winner);
            Kits.giveLobbyKit(looser);

            players.clear();
            IsIG.clear();

            if (winnerTeam == Teams.BLUE) {
                Bukkit.broadcastMessage(Main.getMsgPrefix() + "La partie est terminé, l'équipe§1 Blue§f à gagné !");
            } else if(winnerTeam == Teams.RED) {
                Bukkit.broadcastMessage(Main.getMsgPrefix() + "La partie est terminé, l'équipe§c Rouge§f à gagné !");
            }

        }
    }

    public HashMap<Teams,Player> gethashmap() {
        return players;
    }

    public void addPoint(Teams team) {
        int old = score.get(team);
        int niou = old + 1;

        if(niou < 5) {
            score.remove(team);
            score.put(team, niou);

            players.get(Teams.BLUE).teleport(loc.getLocationFromName("bluespawn"));
            players.get(Teams.RED).teleport(loc.getLocationFromName("redspawn"));
        } else {
            score.remove(team);
            score.put(team, niou);

            if(team == Teams.BLUE) {
                stop(players.get(team), players.get(Teams.RED));
            } else if(team == Teams.RED) {
                stop(players.get(team), players.get(Teams.BLUE));
            }
        }
    }

    public Teams getTeam(Player player) {
        return HashUtils.getKey(players, player);
    }
}
