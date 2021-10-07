package cc.happyareabean.testworld;

import org.bukkit.Bukkit;

public class Utils {

	public static void consoleSend(String message) {
		Bukkit.getConsoleSender().sendMessage(Color.translate(TestWorld.PREFIX + message));
	}

	public static void createHeapdump() {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spark heapdump --compress gzip");
	}

	public static void createHeapsummary() {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spark heapdumpsummary");
	}
}
