package de.beam.Eco.Main;

import org.bukkit.plugin.java.JavaPlugin;

public class Eco extends JavaPlugin{
	
public static Eco eco;
	
	
	@Override
    public void onEnable() {
    	eco = this;
    	Register.Starter();
   
    }

}
