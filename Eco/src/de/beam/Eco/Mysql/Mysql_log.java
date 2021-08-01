package de.beam.Eco.Mysql;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import org.bukkit.entity.Player;



public class Mysql_log {

	
	
	public static void Addlog(Player p,Player Taget,String CMD,int am) {
		
		if(Mysql.isConnected()) {
			   LocalDateTime now = LocalDateTime.now();  
			
			try {
				Statement s = Mysql.con.createStatement();
				 //s.executeUpdate("CREATE TABLE IF NOT EXISTS Logs (Date VARCHAR(20),Action VARCHAR(20),Amount INT(20),Player VARCHAR(32),Admin VARCHAR(32))");
		        s.executeUpdate("INSERT INTO Logs (Date, Action, Amount, Player, Admin) VALUES ('"+now.toString()+"','"+CMD+"','"+am+"','"+Taget.getName()+"','"+p.getName()+"')");
				
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
