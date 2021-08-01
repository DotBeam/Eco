package de.beam.Eco.Main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;

import de.beam.Eco.Cmd.CMD_Konto;
import de.beam.Eco.Cmd.CMD_bank;
import de.beam.Eco.Cmd.CMD_pay;
import de.beam.Eco.Cmd.CMD_payall;
import de.beam.Eco.Event.BankZinsen;
import de.beam.Eco.Event.JoinEvent;
import de.beam.Eco.Event.LeaveEvent;
import de.beam.Eco.Event.Place;
import de.beam.Eco.Mysql.Mysql_create;
import de.beam.Eco.Utility.Config;
import de.beam.Eco.Utility.SaveStrings;


public class Register {

	
	
	private static final PluginDescriptionFile pdf = Eco.eco.getDescription();
    private static final ConsoleCommandSender send = Bukkit.getConsoleSender();
    private static final String pr = SaveStrings.pr;
	
	
    public static void Starter() {
    	final String Autor = pdf.getAuthors().toString().replace("[", " ").replace("]", " ");
    	
    	Config.CreateCfgs();    	
    	
    	send.sendMessage(pr+"§7┌──────────────────────────────────────────►");
		send.sendMessage(pr+"§7│");
		send.sendMessage(pr+"§7├►  §aName:    §5 "+pdf.getName());
		send.sendMessage(pr+"§7├►  §aAuthor: §5 "+Autor);
		send.sendMessage(pr+"§7├►  §aVersion: §5 "+pdf.getVersion());
		send.sendMessage(pr+"§7│");
		send.sendMessage(pr+"§7├──────────────────────────────────────────►");
		send.sendMessage(pr+"§7│");
		send.sendMessage(pr+"§7├►    Commands Werden Geladen");
		send.sendMessage(pr+"§7│");
		cmds();
		send.sendMessage(pr+"§7├──────────────────────────────────────────►");
		send.sendMessage(pr+"§7│");
		send.sendMessage(pr+"§7├►    Events Werden Geladen");
		send.sendMessage(pr+"§7│");
        Events();
        send.sendMessage(pr+"§7├──────────────────────────────────────────►");
		send.sendMessage(pr+"§7│");
		send.sendMessage(pr+"§7├►    Mysql Connecton Wird gestart");
		send.sendMessage(pr+"§7│");
		Mysql();
		send.sendMessage(pr+"§7├──────────────────────────────────────────►");
	    send.sendMessage(pr+"§7│");
	    send.sendMessage(pr+"§7├►    Addones Werden Geladen");
		send.sendMessage(pr+"§7│");
		PlaceHolder();
        send.sendMessage(pr+"§7└──────────────────────────────────────────►");
    }
    
    
    private static void cmds() {
    	loadCommand("pay", new CMD_pay());
    	loadCommand("payall", new CMD_payall());
    	loadCommand("konto", new CMD_Konto());
    	loadCommand("Bank", new CMD_bank());
    	
    }
    private static void Events() {
    	loadEvent(new JoinEvent());
    	loadEvent(new LeaveEvent());
    	BankZinsen.getpayout();
    }
    private static void Mysql() {
    	de.beam.Eco.Mysql.Mysql.connectMySQL();
    	if(de.beam.Eco.Mysql.Mysql.isConnected()) {
    		Mysql_create.createbase();
    		  send.sendMessage(pr+"§7├► §a Verbindung zu Datenbank Wurde hergestllt");
              send.sendMessage(pr+"§7│");
    	}else {
    		 send.sendMessage(pr+"§7├► §c Verbindung zu Datenbank konnte nicht hergestllt werden");
             send.sendMessage(pr+"§7│");
    	}
      
    	
    }
    private static void PlaceHolder() {
    	
    	if(Bukkit.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")) {
    		
    		try{
    		new Place();
    			  send.sendMessage(pr+"§7├► §a PlaceholderAPI Wurde EingeBunden");
                  send.sendMessage(pr+"§7│");
    			
    			
    		}catch(Exception e) {
    			send.sendMessage(""+e);
    			send.sendMessage(pr+"§7├► §c PlaceHolderAPI konnte nicht Eingebunden Werden");
                send.sendMessage(pr+"§7│");
    			
    		}
    		
    		
    		
    	}else {
    		send.sendMessage(pr+"§7├► §c Keine Zusatz Plugins Gefunden");
            send.sendMessage(pr+"§7│");
   	
    	}
    	
    	
    	
    	
    		
    		 
      
    	
    }
	private static void loadCommand(String command, CommandExecutor commandExecutor) {
        try{
        	Eco.eco.getCommand(command).setExecutor(commandExecutor);
            send.sendMessage(pr+"§7├► §aDie Classe "+commandExecutor.getClass().getSimpleName()+" wurde geladen");
            send.sendMessage(pr+"§7│");
            return;
        }catch (Exception e) {
        	send.sendMessage(pr+"§7├► §cDie Classe "+commandExecutor.getClass().getSimpleName()+" konnte nicht geladen werden!");
            e.printStackTrace();
            send.sendMessage(pr+"§7│");
            return;
        }
        
    }
	private static void loadEvent(Listener listener) {
        try{
            PluginManager pluginManager = Bukkit.getPluginManager();
            pluginManager.registerEvents(listener,  Eco.eco);
            send.sendMessage(pr+"§7├► §aDie Classe "+listener.getClass().getSimpleName()+" wurde geladen");
            send.sendMessage(pr+"§7│");
        }catch (Exception e) {
        	send.sendMessage(pr+"§7├► §cDie Classe "+listener.getClass().getSimpleName()+" konnte nicht geladen werden!");
        	send.sendMessage(pr+"§7│");
        }
       
    }
}
