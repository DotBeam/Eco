package de.beam.Eco.Cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import de.beam.Eco.Mysql.Mysql_Eco;
import de.beam.Eco.Mysql.Mysql_log;
import de.beam.Eco.Utility.SaveStrings;



public class CMD_payall implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
		Player player = (Player) cs;
		
		if(player.hasPermission("system.konto.payall") || player.hasPermission("system.Admin")) {
			
			try {
				
				int menge = Integer.valueOf(args[0]);
				for(Player allPlayer : Bukkit.getOnlinePlayers()) {
					
					Mysql_Eco.AddKonto(allPlayer, menge);
					allPlayer.sendMessage(SaveStrings.Kontopr+SaveStrings.payallallString(menge));
				}
				Mysql_log.Addlog(player, player, "Payall", menge);
				player.sendMessage(SaveStrings.Kontopr+SaveStrings.payallString(menge));
				
				
			}catch(NumberFormatException e) {
				player.sendMessage(SaveStrings.Kontopr+SaveStrings.NoNumber);
			}
			
			
			
			
			
			
			
			
			
		}else {
			player.sendMessage(SaveStrings.Kontopr+SaveStrings.NoPermission);
			
		}
		
		
		
		
		
		
		
		
		return false;
	}
	
	
	
	

}
