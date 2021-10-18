package cc.happyareabean.testworld;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Utils {

	public static void consoleSend(String message) {
		Bukkit.getConsoleSender().sendMessage(Color.translate(TestWorld.PREFIX + message));
	}

	public static void consoleSendLine() {
		Bukkit.getConsoleSender().sendMessage(Color.translate(TestWorld.PREFIX + "&c---------------------------------------"));
	}

	public static void createHeapdump() {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spark heapdump --compress gzip");
	}

	public static void createHeapsummary() {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spark heapdumpsummary");
	}

	public static YamlConfiguration getImanitySpigotConfig() {
		return YamlConfiguration.loadConfiguration(new File("imanity/config.yml"));
	}
}
