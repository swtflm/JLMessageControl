package jl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.*;

public class JoinLeave implements Listener {

    @EventHandler
    public void onPlayerJoinMessage(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPlayedBefore()) {
            if (Main.plugin.getConfig().getBoolean("joinmsg.enabled") == true) {
                event.setJoinMessage("");
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
                        Main.plugin.getConfig().getString("joinmsg.message").replace("%p%", event.getPlayer().getName())));
            } else {
                event.setJoinMessage("");
            }
            if (Main.plugin.getConfig().getBoolean("pjoinmsg.enabled") == true) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        Main.plugin.getConfig().getString("pjoinmsg.message").replace("%p%", event.getPlayer().getName())));
            }
        } else {
            event.setJoinMessage("");
            if (Main.plugin.getConfig().getBoolean("firstjoinmsg.enabled") == true) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
                        Main.plugin.getConfig().getString("firstjoinmsg.message").replace("%p%", event.getPlayer().getName())));
            }
            if (Main.plugin.getConfig().getBoolean("pfirstjoinmsg.enabled") == true) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        Main.plugin.getConfig().getString("pfirstjoinmsg.message").replace("%p%", event.getPlayer().getName())));
            }
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        if (Main.plugin.getConfig().getBoolean("leavemsg.enabled") == true) {
            event.setQuitMessage(ChatColor.translateAlternateColorCodes('&',
                    Main.plugin.getConfig().getString("leavemsg.message").replace("%p%", event.getPlayer().getName())));
        } else {
            event.setQuitMessage("");
        }
    }
}