package cc.happyareabean.testworld.commands;

import cc.happyareabean.testworld.Color;
import cc.happyareabean.testworld.TestWorld;
import cc.happyareabean.testworld.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandCreate implements CommandExecutor {

	private static int currentAmount = 1;
	private static int maxAmount = 0;
	private static boolean canceled = false;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {

		String worldName = args[0];
		String worldAmount = args[1];

		maxAmount = Integer.parseInt(worldAmount);

		creatWorld(worldName, currentAmount);


		return false;
	}

	public void creatWorld(String worldName, int worldNumber) {
		if (worldNumber >= maxAmount) {
			Utils.consoleSend("&cMax world amount reached!");
			return;
		}

		String worldNameFull = worldName + worldNumber;
		boolean isLowMemory = check();
		if (canceled || isLowMemory) {
			Utils.consoleSendLine();
			Utils.consoleSend(canceled ? "&cTask canceled when before creating world &b" + worldNameFull + "&c." : "&eLow Memory Detected: &cAuto generating spark heapdump");
			if (isLowMemory) {
				Utils.createHeapdump();
			}
			Utils.consoleSendLine();
			return;
		}

		Utils.consoleSend("");
		Utils.consoleSendLine();
		Utils.consoleSend("&cCurrent world number going to create: &b" + worldNumber);
		Utils.consoleSend("");
		Utils.consoleSend("&eMemory before create a new world &b" + worldNameFull);
		TestWorld.printMemoryUsage();
		Utils.consoleSendLine();

		String command = "mv create " + worldNameFull + " normal";
		Utils.consoleSend("&cRunning Command: " + command);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
		Utils.consoleSend("");
		Utils.consoleSend("&eMemory after created the world &b" + worldNameFull);
		TestWorld.printMemoryUsage();
		Utils.consoleSendLine();
		if (check()) {
			Utils.consoleSend("&e[After Create] Auto generate spark heapdump after created world: &c" + worldNameFull);
			Utils.createHeapdump();
			return;
		}

		currentAmount++;

		Bukkit.getScheduler().runTaskLater(TestWorld.getInstance(),() -> creatWorld(worldName, currentAmount), 40L);
	}

	private boolean check() {
		return Runtime.getRuntime().freeMemory() / (1024 * 1024) <= 64;
	}
}
