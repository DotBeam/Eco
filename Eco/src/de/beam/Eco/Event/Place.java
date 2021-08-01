package de.beam.Eco.Event;

import org.bukkit.entity.Player;

import de.beam.Eco.Mysql.Mysql_Eco;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class Place extends PlaceholderExpansion  {

	@Override
	public  String getAuthor() {
		return "Beam";
	}

	@Override
	public  String getIdentifier() {
		
		return "Eco";
	}

	@Override
	public String getVersion() {
		
		return "1.0.0";
	}
	
	@Override
	public boolean canRegister() {
		return true;
	}
	@Override
	public boolean persist() {
		return true;
	}
	@Override
	public String onPlaceholderRequest(Player p,String params) {
		if(p == null) {
			return "";
		}
		if(params.equals("Bank")) {
			return ""+Mysql_Eco.getBank(p);
		}
		if(params.equals("Konto")) {
			return ""+Mysql_Eco.getKonto(p);
		}
		
		return null;
	}
	
	
	

}
