package com.gregwll.hikabrain.utils;

import com.gregwll.hikabrain.Main;

import java.util.ArrayList;

public class IsSpec {
    private static ArrayList<String> playersig = new ArrayList<>();

    public static void addPlayer(String player) {
        playersig.add(player);
    }

    public static void removePlayer(String player) {
        if(!playersig.contains(player)) {
            playersig.remove(player);
        } else {
            Main.logger.sendError("Player isn't in spec, you can't remove him from list");
        }
    }

    public static boolean isSpec(String player) {
        return playersig.contains(player);
    }

    public static void clear() {
        playersig.clear();
    }
}
