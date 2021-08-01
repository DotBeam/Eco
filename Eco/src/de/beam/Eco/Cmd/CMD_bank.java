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

public class CMD_bank implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
		Player player = (Player) cs;
		//  0    1    2      3
		//args   0    1      2
		//Bank  
		//Bank Top
		//Bank Help
		//Bank speler
		//Bank Einzahlen Mege
		//Bank auszahlen Mege
		//bank Reset Spieler
		//Bank Set Spieler Menge
		//Bank add Spieler Menge
		//Bank remove Spieler Menge
		
		
		
		
		if(args.length == 0) {
			player.sendMessage(SaveStrings.Bankpr+SaveStrings.BankseeString(Mysql_Eco.getBank(player)));
		}
		if(args.length == 1) {
			
			if(args[0].equalsIgnoreCase("top")) {
			
				
				if(!player.hasPermission("system.bank.top")) {player.sendMessage(SaveStrings.Bankpr+SaveStrings.NoPermission);
				}else {
					HashMap<String, Integer> map =  Mysql_Eco.Banktop10();
					ArrayList<String> list = new ArrayList<String>();
					for(String i : map.keySet()) {
						  list.add("Der Spieler "+i+" hat "+map.get(i));
						 
					}
					for(int i=0;i< list.size();i++) {
						int num = i+1;
						player.sendMessage(SaveStrings.Bankpr+num+"." +list.get(i));
					}
				}
			}else if(args[0].equalsIgnoreCase("Help")) {
				
				
				if(SaveStrings.Help1 != "null") {
					player.sendMessage(SaveStrings.Bankpr+SaveStrings.Help1);
				}
				if(SaveStrings.Help2 != "null") {
					player.sendMessage(SaveStrings.Bankpr+SaveStrings.Help2);
				}
				if(SaveStrings.Help3 != "null") {
					player.sendMessage(SaveStrings.Bankpr+SaveStrings.Help3);
				}
				if(SaveStrings.Help4 != "null") {
					player.sendMessage(SaveStrings.Bankpr+SaveStrings.Help4);
				}
				if(SaveStrings.Help5 != "null") {
					player.sendMessage(SaveStrings.Bankpr+SaveStrings.Help5);
				}
				if(SaveStrings.Help6 != "null") {
					player.sendMessage(SaveStrings.Bankpr+SaveStrings.Help6);
				}
				if(SaveStrings.Help7 != "null") {
					player.sendMessage(SaveStrings.Bankpr+SaveStrings.Help7);
				}
				if(SaveStrings.Help8 != "null") {
					player.sendMessage(SaveStrings.Bankpr+SaveStrings.Help8);
				}
				if(SaveStrings.Help9 != "null") {
					player.sendMessage(SaveStrings.Bankpr+SaveStrings.Help9);
				}
				if(SaveStrings.Help10 != "null") {
					player.sendMessage(SaveStrings.Bankpr+SaveStrings.Help10);
				}
				if(SaveStrings.Help11 != "null") {
					player.sendMessage(SaveStrings.Bankpr+SaveStrings.Help11);
				}
				if(SaveStrings.Help12 != "null") {
					player.sendMessage(SaveStrings.Bankpr+SaveStrings.Help12);
				}
				
				
				
			}else {
				
				
		
			
			
			
			try {
			Player tagetPlayer = Bukkit.getPlayer(args[0]);
			player.sendMessage(SaveStrings.Bankpr+SaveStrings.BankseeotherString(Mysql_Eco.getBank(tagetPlayer), tagetPlayer));
			
			
			
			}catch(Exception e) {
				player.sendMessage(SaveStrings.Bankpr+SaveStrings.NoPlayer);
			}

			
		}
		}
		if(args.length == 2) {
				if(!player.hasPermission("system.Bank.reset")) {player.sendMessage(SaveStrings.Bankpr+SaveStrings.NoPermission);
				}else {
					try {
						Player tagetPlayer = Bukkit.getPlayer(args[1]);
		
						Mysql_Eco.restetbank(tagetPlayer);
						Mysql_log.Addlog(player, tagetPlayer, "Bank_rest", 0);
						player.sendMessage(SaveStrings.Bankpr+SaveStrings.BankresetString(tagetPlayer));
						tagetPlayer.sendMessage(SaveStrings.Bankpr+SaveStrings.BankresetTagetString());

						}catch(Exception e) {
							player.sendMessage(SaveStrings.Bankpr+SaveStrings.NoPlayer);
						}
					
					
				}
				String cmdString = args[0];
				if(cmdString.equalsIgnoreCase("einzahlen")||cmdString.equalsIgnoreCase("d")) {
					try {
						int menge = Integer.valueOf(args[1]);
						
						if(Mysql_Eco.haskonto(player, menge)) {
							
							Mysql_Eco.removeKonto(player, menge);
							Mysql_Eco.Addbank(player, menge);
							player.sendMessage(SaveStrings.Bankpr+SaveStrings.TransConfirm);

						}else {
							player.sendMessage(SaveStrings.Bankpr+SaveStrings.nichtgeldaufderhand);
						}
						
						
						
					}catch(NumberFormatException e) {
						player.sendMessage(SaveStrings.Bankpr+SaveStrings.NoNumber);
					}
				}
				if(cmdString.equalsIgnoreCase("auszahlen")||cmdString.equalsIgnoreCase("w")) {
					try {
						int menge = Integer.valueOf(args[1]);
						
						if(Mysql_Eco.hasbank(player, menge)) {
							
							Mysql_Eco.AddKonto(player, menge);
							Mysql_Eco.removebank(player, menge);
							player.sendMessage(SaveStrings.Bankpr+SaveStrings.TransConfirm);

						}else {
							player.sendMessage(SaveStrings.Bankpr+SaveStrings.nichtgeldaufderbank);
						}
						
						
					}catch(NumberFormatException e) {
						player.sendMessage(SaveStrings.Bankpr+SaveStrings.NoNumber);
					}
				}
			}
		
		if(args.length == 3) {
			String cmdString = args[0];
			if(cmdString.equalsIgnoreCase("Set")) {
				
				if(!player.hasPermission("system.Bank.set")) {player.sendMessage(SaveStrings.Bankpr+SaveStrings.NoPermission);
				}else {
					try {
						Player tagetPlayer = Bukkit.getPlayer(args[1]);
						try {
							int menge = Integer.valueOf(args[2]);
							
							Mysql_Eco.stetbank(tagetPlayer, menge);
							Mysql_log.Addlog(player, tagetPlayer, "Bank_set", menge);
							player.sendMessage(SaveStrings.Bankpr+SaveStrings.BanksetString(menge, tagetPlayer));
							tagetPlayer.sendMessage(SaveStrings.Bankpr+SaveStrings.BanksetTagetString(menge));
							
						}catch(NumberFormatException e) {
							player.sendMessage(SaveStrings.Bankpr+SaveStrings.NoNumber);
						}
						}catch(Exception e) {
							player.sendMessage(SaveStrings.Bankpr+SaveStrings.NoPlayer);
						}
				}
			}
			
			if(cmdString.equalsIgnoreCase("give") || cmdString.equalsIgnoreCase("add")) {
				if(!player.hasPermission("system.Bank.give")) {player.sendMessage(SaveStrings.Bankpr+SaveStrings.NoPermission);
				}else {
					try {
						Player tagetPlayer = Bukkit.getPlayer(args[1]);
						try {
							int menge = Integer.valueOf(args[2]);
							
							Mysql_Eco.Addbank(tagetPlayer, menge);
							Mysql_log.Addlog(player, tagetPlayer, "Bank_Add", menge);
							player.sendMessage(SaveStrings.Bankpr+SaveStrings.BankaddString(menge, tagetPlayer));
							tagetPlayer.sendMessage(SaveStrings.Bankpr+SaveStrings.BankaddTagetString(menge));
							
	
						}catch(NumberFormatException e) {
							player.sendMessage(SaveStrings.Bankpr+SaveStrings.NoNumber);
						}
						}catch(Exception e) {
							player.sendMessage(SaveStrings.Bankpr+SaveStrings.NoPlayer);
						}
					
					
				}
			}
			if(cmdString.equalsIgnoreCase("remove") || cmdString.equalsIgnoreCase("take")) {
				if(!player.hasPermission("system.Bank.take")) {player.sendMessage(SaveStrings.Bankpr+SaveStrings.NoPermission);
				}else {
					try {
						Player tagetPlayer = Bukkit.getPlayer(args[1]);
						
						try {
							int menge = Integer.valueOf(args[2]);
							
							Mysql_Eco.removebank(tagetPlayer, menge);
							Mysql_log.Addlog(player, tagetPlayer, "Bank_remove", menge);
							player.sendMessage(SaveStrings.Bankpr+SaveStrings.BanktakeString(menge, tagetPlayer));
							tagetPlayer.sendMessage(SaveStrings.Bankpr+SaveStrings.BanktakeTagetString(menge));
							
						}catch(NumberFormatException e) {
							player.sendMessage(SaveStrings.Bankpr+SaveStrings.NoNumber);
						}
						
						
						
						}catch(Exception e) {
							player.sendMessage(SaveStrings.Bankpr+SaveStrings.NoPlayer);
						}
					
					
				}
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return false;
	}
}
