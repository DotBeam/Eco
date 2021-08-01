package de.beam.Eco.Cmd;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import de.beam.Eco.Mysql.Mysql_Eco;
import de.beam.Eco.Mysql.Mysql_log;
import de.beam.Eco.Utility.SaveStrings;


public class CMD_Konto implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
		Player player = (Player) cs;
		//  0    1    2      3
		//args   0    1      2
		//konto  
		//konto speler		
		//Konto Set Spieler Menge
		//konto add Spieler Menge
		//Konto remove Spieler Menge
		
		
		
		
		if(args.length == 0) {
			player.sendMessage(SaveStrings.Kontopr+SaveStrings.kontoseeString(Mysql_Eco.getKonto(player)));
		}
		if(args.length == 1) {
			
			if(args[0].equalsIgnoreCase("top")) {
			
				
				if(!player.hasPermission("system.konto.top")) {player.sendMessage(SaveStrings.Kontopr+SaveStrings.NoPermission);
				}else {
					HashMap<String, Integer> map =  Mysql_Eco.Kontotop10();
					ArrayList<String> list = new ArrayList<String>();
					for(String i : map.keySet()) {
						  list.add("Der Spieler "+i+" hat "+map.get(i));
						 
					}
					for(int i=0;i< list.size();i++) {
						int num = i+1;
						player.sendMessage(SaveStrings.Kontopr+num+"." +list.get(i));
					}
				}
			}else {
				
		
			
			
			
			try {
			Player tagetPlayer = Bukkit.getPlayer(args[0]);
			player.sendMessage(SaveStrings.Kontopr+SaveStrings.kontoseeotherString(Mysql_Eco.getKonto(tagetPlayer), tagetPlayer));
			
			
			
			}catch(Exception e) {
				player.sendMessage(SaveStrings.Kontopr+SaveStrings.NoPlayer);
			}

			
		}
		}
		if(args.length == 2) {
				if(!player.hasPermission("system.konto.reset")) {player.sendMessage(SaveStrings.Kontopr+SaveStrings.NoPermission);
				}else {
					try {
						Player tagetPlayer = Bukkit.getPlayer(args[1]);
		
						Mysql_Eco.resetKonto(tagetPlayer);
						Mysql_log.Addlog(player, tagetPlayer, "Konto_rest", 0);
						player.sendMessage(SaveStrings.Kontopr+SaveStrings.kontoresetString(tagetPlayer));
						tagetPlayer.sendMessage(SaveStrings.Kontopr+SaveStrings.kontoresetTagetString());

						}catch(Exception e) {
							player.sendMessage(SaveStrings.Kontopr+SaveStrings.NoPlayer);
						}
					
					
				}
			}
		
		if(args.length == 3) {
			String cmdString = args[0];
			if(cmdString.equalsIgnoreCase("Set")) {
				
				if(!player.hasPermission("system.konto.set")) {player.sendMessage(SaveStrings.Kontopr+SaveStrings.NoPermission);
				}else {
					try {
						Player tagetPlayer = Bukkit.getPlayer(args[1]);
						try {
							int menge = Integer.valueOf(args[2]);
							
							Mysql_Eco.setKonto(tagetPlayer, menge);
							Mysql_log.Addlog(player, tagetPlayer, "Konto_set", menge);
							player.sendMessage(SaveStrings.Kontopr+SaveStrings.kontosetString(menge, tagetPlayer));
							tagetPlayer.sendMessage(SaveStrings.Kontopr+SaveStrings.kontosetTagetString(menge));
							
						}catch(NumberFormatException e) {
							player.sendMessage(SaveStrings.Kontopr+SaveStrings.NoNumber);
						}
						}catch(Exception e) {
							player.sendMessage(SaveStrings.Kontopr+SaveStrings.NoPlayer);
						}
				}
			}
			
			if(cmdString.equalsIgnoreCase("give") || cmdString.equalsIgnoreCase("add")) {
				if(!player.hasPermission("system.konto.give")) {player.sendMessage(SaveStrings.Kontopr+SaveStrings.NoPermission);
				}else {
					try {
						Player tagetPlayer = Bukkit.getPlayer(args[1]);
						try {
							int menge = Integer.valueOf(args[2]);
							
							Mysql_Eco.AddKonto(tagetPlayer, menge);
							Mysql_log.Addlog(player, tagetPlayer, "Konto_Add", menge);
							player.sendMessage(SaveStrings.Kontopr+SaveStrings.kontoaddString(menge, tagetPlayer));
							tagetPlayer.sendMessage(SaveStrings.Kontopr+SaveStrings.kontoaddTagetString(menge));
							
	
						}catch(NumberFormatException e) {
							player.sendMessage(SaveStrings.Kontopr+SaveStrings.NoNumber);
						}
						}catch(Exception e) {
							player.sendMessage(SaveStrings.Kontopr+SaveStrings.NoPlayer);
						}
					
					
				}
			}
			if(cmdString.equalsIgnoreCase("remove") || cmdString.equalsIgnoreCase("take")) {
				if(!player.hasPermission("system.konto.take")) {player.sendMessage(SaveStrings.Kontopr+SaveStrings.NoPermission);
				}else {
					try {
						Player tagetPlayer = Bukkit.getPlayer(args[1]);
						
						try {
							int menge = Integer.valueOf(args[2]);
							
							Mysql_Eco.removeKonto(tagetPlayer, menge);
							Mysql_log.Addlog(player, tagetPlayer, "Konto_remove", menge);
							player.sendMessage(SaveStrings.Kontopr+SaveStrings.kontotakeString(menge, tagetPlayer));
							tagetPlayer.sendMessage(SaveStrings.Kontopr+SaveStrings.kontotakeTagetString(menge));
							
						}catch(NumberFormatException e) {
							player.sendMessage(SaveStrings.Kontopr+SaveStrings.NoNumber);
						}
						
						
						
						}catch(Exception e) {
							player.sendMessage(SaveStrings.Kontopr+SaveStrings.NoPlayer);
						}
					
					
				}
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return false;
	}

}
