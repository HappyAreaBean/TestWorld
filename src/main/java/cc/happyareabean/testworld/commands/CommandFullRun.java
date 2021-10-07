package cc.happyareabean.testworld.commands;

import cc.happyareabean.testworld.Color;
import cc.happyareabean.testworld.TestWorld;
import cc.happyareabean.testworld.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Random;

public class CommandFullRun implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {

		String worldName = args[1];

		Utils.consoleSend("&c---------------------------------------");
		Utils.consoleSend("&cWorld Name: " + worldName);
		Utils.consoleSend("&c---------------------------------------");
		Utils.consoleSend("&cGenerate a random world number...");

		Random random = new Random();
		int worldNum = random.nextInt(Integer.parseInt(args[0]) + 1);
		if (worldNum == 0) worldNum ++;

		String worldFull = worldName + worldNum;

		Utils.consoleSend("&cNumber: " + worldNum);

		Utils.consoleSend("&c---------------------------------------");
		Utils.consoleSend("&cCurrent Memory Usage - &6Before Unload " + worldFull);
		TestWorld.printMemoryUsage();
		Utils.consoleSend("&c---------------------------------------");
		Utils.consoleSend("&cUnloading world: " + worldFull);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv unload " + worldFull);
		Utils.consoleSend("&c---------------------------------------");

		Utils.consoleSend("&cCurrent Memory Usage - &bAfter Unload " + worldFull);
		TestWorld.printMemoryUsage();

		Utils.consoleSend("&c---------------------------------------");
		Utils.consoleSend("&cLoading world: " + worldFull);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv load " + worldFull);
		Utils.consoleSend("&c---------------------------------------");

		Utils.consoleSend("&cCurrent Memory Usage - &dAfter Loaded " + worldFull);
		TestWorld.printMemoryUsage();

		Utils.consoleSend("&c---------------------------------------");

		return false;
	}
}
