package com.gregwll.hikabrain;

import com.gregwll.hikabrain.commands.Matt;
import com.gregwll.hikabrain.commands.SpecLeaveCommand;
import com.gregwll.hikabrain.commands.staff.GmCommand;
import com.gregwll.hikabrain.events.*;
import com.gregwll.hikabrain.game.Queue;
import com.gregwll.hikabrain.utils.Locations;
import com.gregwll.hikabrain.utils.Log;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {

    private static Locations locations = new Locations();
    private static Queue queue = new Queue();
    public static boolean isGameStarted;
    public static Log logger = new Log("[GregsHikabrain]");
    private static Main instance;

    @EventHandler
    public void onEnable() {
        instance = this;

        isGameStarted = false;
        //declarer les co
        locations.addLocation("lobby", new Location(Bukkit.getWorld("world"), 13, 42, -367, -90f, 0f));
        locations.addLocation("bluespawn", new Location(Bukkit.getWorld("world"), 33, 16, -367, 90f, 0f));
        locations.addLocation("redspawn", new Location(Bukkit.getWorld("world"), -7, 16, -367, -90f, 0f));

        getCommand("matt").setExecutor(new Matt());
        getCommand("specleave").setExecutor(new SpecLeaveCommand());
        getCommand("gm").setExecutor(new GmCommand());

        Bukkit.getPluginManager().registerEvents(new AntiDSEvents(), this);
        Bukkit.getPluginManager().registerEvents(new JoinAndQuitEvents(), this);
        Bukkit.getPluginManager().registerEvents(new ItemInterractionEvents(), this);
        Bukkit.getPluginManager().registerEvents(new ChatEvents(), this);
        Bukkit.getPluginManager().registerEvents(new KitsEvents(), this);
        Bukkit.getPluginManager().registerEvents(new GameDeathKillEvents(), this);
        Bukkit.getPluginManager().registerEvents(new SpawnGameProtection(), this);

    }

    @EventHandler
    public void onDisable() {

    }

    public static Locations getLocations() {
        return locations;
    }

    public static String getMsgPrefix() {
        return ("§f[§6Gregs§lHikabrain§f] ");
    }

    public static Queue getQueue() {
        return queue;
    }

    public static Main getInstance() {
        return instance;
    }





}
