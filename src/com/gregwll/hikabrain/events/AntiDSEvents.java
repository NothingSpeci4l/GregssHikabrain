package com.gregwll.hikabrain.events;

import com.gregwll.hikabrain.Main;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class AntiDSEvents implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        new BukkitRunnable() {
            public void run() {
                ((CraftPlayer) e.getEntity().getPlayer()).getHandle().playerConnection
                        .a(new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN));
            }
        }.runTaskLater(Main.getInstance(), 2);
    }
}
