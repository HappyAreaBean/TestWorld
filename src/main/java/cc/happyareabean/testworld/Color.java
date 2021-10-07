package cc.happyareabean.testworld;

import org.bukkit.ChatColor;

public class Color {

	public static String translate(String input) {
		return ChatColor.translateAlternateColorCodes('&', input);
	}
}
