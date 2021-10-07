package cc.happyareabean.testworld.commands;

import cc.happyareabean.testworld.Color;
import cc.happyareabean.testworld.TestWorld;
import cc.happyareabean.testworld.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Random;

public class CommandAutoRun implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {

		if (args[0].equalsIgnoreCase("off")) {
			TestWorld.AUTORUNNING = false;
			return true;
		}

		TestWorld.AUTORUNNING = true;

		while (TestWorld.AUTORUNNING) {
			String worldName = args[0];

			Utils.consoleSend("&c---------------------------------------");
			Utils.consoleSend("&cWorld Name: " + worldName);
			Utils.consoleSend("&cGenerate a random world number...");

			Random random = new Random();
			int worldNum = random.nextInt(Integer.parseInt(args[1]) + 1);
			if (worldNum == 0) worldNum ++;

			String worldFull = worldName + worldNum;
			String worldFullDisplay = "[" + worldName + worldNum + "]";

			Utils.consoleSend("&cNumber: " + worldNum);

			Utils.consoleSend("&c---------------------------------------");
			Utils.consoleSend("&cCurrent Memory Usage - &6Before Unload " + worldFullDisplay);
			TestWorld.printMemoryUsage();
			if (check()) {
				Utils.consoleSend("&e[Before Unload] Auto generate spark heapdump");
				Utils.createHeapdump();
				break;
			}
			Utils.consoleSend("&c---------------------------------------");
			Utils.consoleSend("&cUnloading world: " + worldFullDisplay);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv unload " + worldFull);
			Utils.consoleSend("&c---------------------------------------");

			Utils.consoleSend("&cCurrent Memory Usage - &bAfter Unload " + worldFullDisplay);
			TestWorld.printMemoryUsage();

			if (check()) {
				Utils.consoleSend("&e[After Unload] Auto generate spark heapdump");
				Utils.createHeapdump();
				break;
			}

			Utils.consoleSend("&c---------------------------------------");
			Utils.consoleSend("&cLoading world: " + worldFullDisplay);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv load " + worldFull);
			Utils.consoleSend("&c---------------------------------------");

			Utils.consoleSend("&cCurrent Memory Usage - &dAfter Loaded " + worldFullDisplay);
			TestWorld.printMemoryUsage();

			if (check()) {
				Utils.consoleSend(TestWorld.PREFIX + "&e[After Loaded] Auto generate spark heapdump");
				Utils.createHeapdump();
				break;
			}

			Utils.consoleSend("&c---------------------------------------");
		}

		return false;
	}

	private boolean check() {
		return Runtime.getRuntime().freeMemory() / (1024 * 1024) <= 50;
	}

	private int getFree() {
		return (int) Runtime.getRuntime().freeMemory() / (1024 * 1024);
	}
}
