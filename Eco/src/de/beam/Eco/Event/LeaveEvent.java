package de.beam.Eco.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener{
	
	@EventHandler
	public void onquit(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		if(BankZinsen.zinsHashMap.containsKey(player.getName())) {
			BankZinsen.zinsHashMap.remove(player.getName());
		}
		
		
		
		
	}
	
	

}
