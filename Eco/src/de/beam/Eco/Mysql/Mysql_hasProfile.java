package de.beam.Eco.Mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.entity.Player;

public class Mysql_hasProfile {
	
	 public static boolean hasPlayerProfiel(Player player)
	  {
	    if (Mysql.isConnected()) {
	      try
	      {
	        Statement s = Mysql.con.createStatement();
	        ResultSet rs = s.executeQuery("SELECT UUID FROM Eco WHERE UUID = '"+player.getUniqueId()+"'");
	        while(rs.next()) {
				 return true;
			 }
	        s.close();
	      }
	      catch (SQLException e)
	      {
	        
	      }
	    }
	    return false;
	  }
	

}
