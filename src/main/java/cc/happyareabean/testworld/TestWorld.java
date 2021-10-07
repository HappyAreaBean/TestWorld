package cc.happyareabean.testworld;

import cc.happyareabean.testworld.commands.CommandAutoRun;
import cc.happyareabean.testworld.commands.CommandFullRun;
import cc.happyareabean.testworld.commands.CommandSetup;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TestWorld extends JavaPlugin {

	public static boolean AUTORUNNING = false;
	public static String PREFIX = Color.translate("&8&l[&4TestWorld&8] &e");

	@Override
	public void onEnable() {
		getCommand("fullrun").setExecutor(new CommandFullRun());
		getCommand("autorun").setExecutor(new CommandAutoRun());
		getCommand("setup").setExecutor(new CommandSetup());
		getCommand("ping").setExecutor(new CommandSetup());
	}

	public static void printMemoryUsage() {
		int dataSize = 1024 * 1024;
		Bukkit.getConsoleSender().sendMessage(Color.translate(PREFIX + "&cUsed Memory   : &e" + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / dataSize + " MB"));
		Bukkit.getConsoleSender().sendMessage(Color.translate(PREFIX + "&cFree Memory   : &e" + Runtime.getRuntime().freeMemory() / dataSize + " MB"));
		Bukkit.getConsoleSender().sendMessage(Color.translate(PREFIX + "&cTotal Memory  : &e" + Runtime.getRuntime().totalMemory() / dataSize + " MB"));
		Bukkit.getConsoleSender().sendMessage(Color.translate(PREFIX + "&cMax Memory    : &e" + Runtime.getRuntime().maxMemory() / dataSize + " MB"));
	}
}
