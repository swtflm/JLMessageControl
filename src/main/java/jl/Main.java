package jl;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        this.saveDefaultConfig();
        getCommand("reloadjl").setExecutor(this);
        getServer().getPluginManager().registerEvents(new JoinLeave(), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("reloadjl")) {
            if (plugin.getConfig().getBoolean("reloadmsg.enabled") == true) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        Main.plugin.getConfig().getString("reloadmsg.message")));
            }
            this.reloadConfig();
            return true;
        }
        return false;
    }
}

