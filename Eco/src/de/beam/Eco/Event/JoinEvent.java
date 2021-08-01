package de.beam.Eco.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.beam.Eco.Mysql.Mysql_create;
import de.beam.Eco.Mysql.Mysql_hasProfile;

public class JoinEvent implements Listener {
	
	
	
	@EventHandler
	public void CreateMYsqlEco(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		
		if(!Mysql_hasProfile.hasPlayerProfiel(player)) {
			Mysql_create.createuser(player);
		}
		
		BankZinsen.zinsHashMap.put(player.getName(),(int) 30);
		
		
		
		
	}
	
	
	

}
