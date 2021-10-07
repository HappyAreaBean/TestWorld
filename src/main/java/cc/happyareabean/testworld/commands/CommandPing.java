package cc.happyareabean.testworld.commands;

import cc.happyareabean.testworld.Color;
import cc.happyareabean.testworld.TestWorld;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandPing implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {

		sender.sendMessage("Pong!");

		return false;
	}
}
