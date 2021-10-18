package cc.happyareabean.testworld;

import cc.happyareabean.testworld.commands.CommandAutoRun;
import cc.happyareabean.testworld.commands.CommandCreate;
import cc.happyareabean.testworld.commands.CommandFullRun;
import cc.happyareabean.testworld.commands.CommandSetup;
import cc.happyareabean.testworld.enums.ImanitySpigotConfig;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TestWorld extends JavaPlugin {

	public static String PREFIX = Color.translate("&8&l[&4TestWorld&8] &e");
	@Getter private static TestWorld instance;

	@Override
	public void onEnable() {
		instance = this;
		try {
			Class.forName("org.imanity.imanityspigot.ImanitySpigot");
			boolean chunkGen = ImanitySpigotConfig.ASYNC_CHUNK_GENERATION.isCurrentStatus();
			Utils.consoleSend("&c---------------------------------------");
			Utils.consoleSend("&4Currently ImanitySpigot Async Chunk Settings");
			Utils.consoleSend("");
			Utils.consoleSend("&a> " + ImanitySpigotConfig.ASYNC_CHUNK_LOADS.getConfigName());
			Utils.consoleSend("  &e- Enabled: " + (ImanitySpigotConfig.ASYNC_CHUNK_LOADS.isCurrentStatus() ? "&atrue" : "&cfalse"));
			Utils.consoleSend("");
			Utils.consoleSend("&b> " + ImanitySpigotConfig.ASYNC_CHUNK_GENERATION.getConfigName());
			Utils.consoleSend("  &e- Enabled: " + (ImanitySpigotConfig.ASYNC_CHUNK_LOADS.isCurrentStatus() ? (chunkGen ? "&atrue" : "&cfalse") : "&cfalse" + (chunkGen ? " &7(" + chunkGen + " in config, show false to looks more reasonable)" : "")));
			Utils.consoleSend("");
			Utils.consoleSend("&c---------------------------------------");
		} catch (Throwable ex) {
			// ignore
		}

		getCommand("fullrun").setExecutor(new CommandFullRun());
		getCommand("autorun").setExecutor(new CommandAutoRun());
		getCommand("setup").setExecutor(new CommandSetup());
		getCommand("ping").setExecutor(new CommandSetup());
		getCommand("create").setExecutor(new CommandCreate());
	}

	public static void printMemoryUsage() {
		int dataSize = 1024 * 1024;
		Bukkit.getConsoleSender().sendMessage(Color.translate(PREFIX + "&cUsed Memory   : &e" + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / dataSize + " MB"));
		Bukkit.getConsoleSender().sendMessage(Color.translate(PREFIX + "&cFree Memory   : &e" + Runtime.getRuntime().freeMemory() / dataSize + " MB"));
		Bukkit.getConsoleSender().sendMessage(Color.translate(PREFIX + "&cTotal Memory  : &e" + Runtime.getRuntime().totalMemory() / dataSize + " MB"));
		Bukkit.getConsoleSender().sendMessage(Color.translate(PREFIX + "&cMax Memory    : &e" + Runtime.getRuntime().maxMemory() / dataSize + " MB"));
	}
}
