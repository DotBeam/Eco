package de.beam.Eco.Mysql;

import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.entity.Player;


public class Mysql_create {
	
public static void createbase() {
		
		try {
			 Statement s = Mysql.con.createStatement();
		      
		      s.executeUpdate("CREATE TABLE IF NOT EXISTS Eco (UUID VARCHAR(100),Username VARCHAR(32),Konto INT(20),Bank INT(20))");
		      s.executeUpdate("CREATE TABLE IF NOT EXISTS Logs (Date VARCHAR(40),Action VARCHAR(20),Amount INT(20),Player VARCHAR(32),Admin VARCHAR(32))");
		    
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void createuser(Player p) {
	
	if(Mysql.isConnected()) {
		
		
		try {
			Statement s = Mysql.con.createStatement();
	        
	        s.executeUpdate("INSERT INTO Eco (UUID, Username, Konto, Bank) VALUES ('" + p.getUniqueId() +"','"+p.getName()+"','3500','500')");
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

}
