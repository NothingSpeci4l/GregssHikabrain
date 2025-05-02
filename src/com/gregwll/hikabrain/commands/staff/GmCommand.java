package com.gregwll.hikabrain.commands.staff;

import com.gregwll.hikabrain.Main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.isOp()) {
                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("0")) {
                        player.setGameMode(GameMode.SURVIVAL);
                    } else if(args[0].equalsIgnoreCase("1")) {
                        player.setGameMode(GameMode.CREATIVE);
                    } else if(args[0].equalsIgnoreCase("2")) {
                        player.setGameMode(GameMode.ADVENTURE);
                    } else if(args[0].equalsIgnoreCase("3")) {
                        player.setGameMode(GameMode.SPECTATOR);
                    }
                } else {
                    player.sendMessage(Main.getMsgPrefix() + "Mauvaise syntaxe, /gm <gm>");
                }
            } else {
                player.sendMessage(Main.getMsgPrefix() + "Vous n'avez pas la permission d'executer cette commande !");
            }
        }

        return false;
    }
}
