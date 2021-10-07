package cc.happyareabean.testworld.commands;

import cc.happyareabean.testworld.Color;
import cc.happyareabean.testworld.TestWorld;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Random;

public class CommandSetup implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {

		String worldName = args[1];
		int worldAmount = Integer.parseInt(args[2]);

		if (args[0].equalsIgnoreCase("create")) {

			for (int i = 0; i < worldAmount + 1; i++) {
				if (i == 0) continue;
				String command = "mv create " + worldName + i + " normal";
				Bukkit.getConsoleSender().sendMessage(Color.translate("&cRunning Command: " + command));
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
			}
		} else if (args[0].equalsIgnoreCase("delete")) {

			for (int i = 0; i < worldAmount + 1; i++) {
				if (i == 0) continue;
				String command = "mv delete " + worldName + i;
				Bukkit.getConsoleSender().sendMessage(Color.translate("&cRunning Command: " + command));
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv confirm");
			}
		} else if (args[0].equalsIgnoreCase("unload")) {

			for (int i = 0; i < worldAmount + 1; i++) {
				if (i == 0) continue;
				String worldFull = worldName + i;
				Bukkit.getConsoleSender().sendMessage(Color.translate("&c---------------------------------------"));
				Bukkit.getConsoleSender().sendMessage(Color.translate("&cCurrent Memory Usage - &6Before Unload World " + worldFull));
				TestWorld.printMemoryUsage();
				Bukkit.getConsoleSender().sendMessage(Color.translate("&c---------------------------------------"));
				String command = "mv unload " + worldName + i;
				Bukkit.getConsoleSender().sendMessage(Color.translate("&cRunning Command: " + command));
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
				Bukkit.getConsoleSender().sendMessage(Color.translate("&c---------------------------------------"));
				Bukkit.getConsoleSender().sendMessage(Color.translate("&cCurrent Memory Usage - &dAfter UnLoaded World " + worldFull));
				TestWorld.printMemoryUsage();
				Bukkit.getConsoleSender().sendMessage(Color.translate("&c---------------------------------------"));
			}
		} else if (args[0].equalsIgnoreCase("load")) {

			for (int i = 0; i < worldAmount + 1; i++) {
				if (i == 0) continue;
				String worldFull = worldName + i;
				Bukkit.getConsoleSender().sendMessage(Color.translate("&c---------------------------------------"));
				Bukkit.getConsoleSender().sendMessage(Color.translate("&cCurrent Memory Usage - &6Before Load World " + worldFull));
				TestWorld.printMemoryUsage();
				Bukkit.getConsoleSender().sendMessage(Color.translate("&c---------------------------------------"));
				String command = "mv load " + worldName + i;
				Bukkit.getConsoleSender().sendMessage(Color.translate("&cRunning Command: " + command));
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
				Bukkit.getConsoleSender().sendMessage(Color.translate("&c---------------------------------------"));
				Bukkit.getConsoleSender().sendMessage(Color.translate("&cCurrent Memory Usage - &dAfter Loaded World " + worldFull));
				TestWorld.printMemoryUsage();
				Bukkit.getConsoleSender().sendMessage(Color.translate("&c---------------------------------------"));
			}
		}

		return false;
	}
}
