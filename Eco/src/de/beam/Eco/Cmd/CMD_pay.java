package de.beam.Eco.Cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.beam.Eco.Mysql.Mysql_Eco;
import de.beam.Eco.Utility.SaveStrings;

public class CMD_pay implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
		Player player = (Player) cs;
		
		if(!(args.length == 1)) {
			Player tagetPlayer = Bukkit.getPlayer(args[0]);
			if(tagetPlayer != null) {
				int mege = Integer.valueOf(args[1]);
				if(Mysql_Eco.haskonto(player, mege)) {
					
				
				
				Mysql_Eco.AddKonto(tagetPlayer, mege);
				Mysql_Eco.removeKonto(player, mege);
				player.sendMessage(SaveStrings.Kontopr + SaveStrings.paysenderString(mege, tagetPlayer));
				tagetPlayer.sendMessage(SaveStrings.Kontopr + SaveStrings.paytagetString(mege, player));
			}else {
				player.sendMessage(SaveStrings.Kontopr + SaveStrings.nichtgeldaufderhand);
				
			}
			}else {
			   player.sendMessage(SaveStrings.Kontopr + SaveStrings.NoPlayer);
			}
			
			
			
			
			
		}else {
			return false;
		}
		
		
		
		
		
		
		
		
		return false;
	}

}
