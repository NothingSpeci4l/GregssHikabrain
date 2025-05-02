package com.gregwll.hikabrain.utils;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.HashMap;

public class Locations {
    HashMap<String, Location> map = new HashMap<>();

    public Locations() {

    }

    public void addLocation(String name, Location location) {
        map.put(name, location);
    }

    public Location getLocationFromName(String name) {
        return map.get(name);
    }

    public void removeLocation(String name) {
        map.remove(name);
    }
}
