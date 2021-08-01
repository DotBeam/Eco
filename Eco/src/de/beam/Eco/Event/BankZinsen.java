package de.beam.Eco.Event;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.beam.Eco.Main.Eco;
import de.beam.Eco.Mysql.Mysql_Eco;
import de.beam.Eco.Utility.SaveStrings;

public class BankZinsen {
	
	
	public static HashMap<String, Integer> zinsHashMap = new HashMap<String, Integer>();
	
	
	public static void getpayout() {
		
		Bukkit.getScheduler().runTaskTimer(Eco.eco, new Runnable() {
			
			@Override
			public void run() {
				
			for(String foString : zinsHashMap.keySet()) {
				zinsHashMap.put(foString, zinsHashMap.get(foString)-1);
				
				if(zinsHashMap.get(foString) == 0) {
					Player player = Bukkit.getPlayer(foString);
					int Zins = (int) (Mysql_Eco.getBank(player)*SaveStrings.Bankzins);
					player.sendMessage(SaveStrings.Bankpr+SaveStrings.bankzinsString(Zins));
					Mysql_Eco.Addbank(player, Zins);
					zinsHashMap.put(foString, 30);
				}
			}
				
			}
		}, 0, 20*60);
		
		Bukkit.getScheduler().runTaskTimer(Eco.eco, new Runnable() {
			
			@Override
			public void run() {
				for(Player allPlayer : Bukkit.getServer().getOnlinePlayers()) {
					allPlayer.sendMessage(SaveStrings.Bank2h);
					
				}
				
			}
		}, 0, 20*60*120);
		
	}
	
	
	
	
	
	
	

}
