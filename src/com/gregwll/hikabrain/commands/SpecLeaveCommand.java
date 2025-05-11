package com.gregwll.hikabrain.commands;

import com.gregwll.hikabrain.Main;
import com.gregwll.hikabrain.game.Spectator;
import com.gregwll.hikabrain.utils.IsSpec;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpecLeaveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(IsSpec.isSpec(player.getName())) {
                Spectator.untoggleSpectator(player);
            } else {
                player.sendMessage(Main.getMsgPrefix() + "Vous n'êtes pas en spectateur ! ");
            }
        } else {
            System.out.println("this command is a player command !");
        }



        return false;
    }
}
