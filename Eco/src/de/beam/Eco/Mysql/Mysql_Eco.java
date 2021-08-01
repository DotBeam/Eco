package de.beam.Eco.Mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;



public class Mysql_Eco {
	
	public static int getKonto(Player p) {
		
	    try
	    {
	      Statement s = Mysql.con.createStatement();
	      ResultSet rs = s.executeQuery("SELECT Konto FROM Eco WHERE UUID= '" + p.getUniqueId() + "'");
	      if (rs.next()) {
	        return rs.getInt("Konto");
	      }
	      s.close();
	    }
	    catch (SQLException e)
	    {
	      Bukkit.getConsoleSender().sendMessage("§c" + e);
	    }
	    return 0;
	  }
	public static int getBank(Player p) {
		
	    try
	    {
	      Statement s = Mysql.con.createStatement();
	      ResultSet rs = s.executeQuery("SELECT Bank FROM Eco WHERE UUID= '" + p.getUniqueId() + "'");
	      if (rs.next()) {
	        return rs.getInt("Bank");
	      }
	      s.close();
	    }
	    catch (SQLException e)
	    {
	      Bukkit.getConsoleSender().sendMessage("§c" + e);
	    }
	    return 0;
	  }

	public static void AddKonto(Player p,int num) {
		
		int z = getKonto(p)+num;
		
		try
	    {
	      Statement s = Mysql.con.createStatement();
	      s.executeUpdate("UPDATE Eco SET Konto = " + z + " WHERE UUID= '" +p.getUniqueId() + "'");
	    }
	    catch (SQLException e)
	    {
	    	 Bukkit.getConsoleSender().sendMessage("§c" + e);
	    }
	
	}
	public static void Addbank(Player p,int num) {
		
		int z = getBank(p)+num;
		
		try
	    {
	      Statement s = Mysql.con.createStatement();
	      s.executeUpdate("UPDATE Eco SET Bank = " + z + " WHERE UUID= '" +p.getUniqueId() + "'");
	    }
	    catch (SQLException e)
	    {
	    	 Bukkit.getConsoleSender().sendMessage("§c" + e);
	    }
	
	}
	public static void removeKonto(Player p,int num) {
		
		int z = getKonto(p)-num;
		
		try
	    {
	      Statement s = Mysql.con.createStatement();
	      s.executeUpdate("UPDATE Eco SET Konto = " + z + " WHERE UUID= '" +p.getUniqueId() + "'");
	    }
	    catch (SQLException e)
	    {
	    	 Bukkit.getConsoleSender().sendMessage("§c" + e);
	    }
	
	}
	public static void removebank(Player p,int num) {
		
		int z = getBank(p)-num;
		
		try
	    {
	      Statement s = Mysql.con.createStatement();
	      s.executeUpdate("UPDATE Eco SET Bank = " + z + " WHERE UUID= '" +p.getUniqueId() + "'");
	    }
	    catch (SQLException e)
	    {
	    	 Bukkit.getConsoleSender().sendMessage("§c" + e);
	    }
	
	}
	public static void setKonto(Player p,int num) {
		
		
		
		try
	    {
	      Statement s = Mysql.con.createStatement();
	      s.executeUpdate("UPDATE Eco SET Konto = " + num + " WHERE UUID= '" +p.getUniqueId() + "'");
	    }
	    catch (SQLException e)
	    {
	    	 Bukkit.getConsoleSender().sendMessage("§c" + e);
	    }
	
	}
	public static void stetbank(Player p,int num) {
		
		
		
		try
	    {
	      Statement s = Mysql.con.createStatement();
	      s.executeUpdate("UPDATE Eco SET Bank = " + num + " WHERE UUID= '" +p.getUniqueId() + "'");
	    }
	    catch (SQLException e)
	    {
	    	 Bukkit.getConsoleSender().sendMessage("§c" + e);
	    }
	
	}
	public static void resetKonto(Player p) {
		
		
		
		try
	    {
	      Statement s = Mysql.con.createStatement();
	      s.executeUpdate("UPDATE Eco SET Konto = " + 0 + " WHERE UUID= '" +p.getUniqueId() + "'");
	    }
	    catch (SQLException e)
	    {
	    	 Bukkit.getConsoleSender().sendMessage("§c" + e);
	    }
	
	}
	public static void restetbank(Player p) {
		
		
		
		try
	    {
	      Statement s = Mysql.con.createStatement();
	      s.executeUpdate("UPDATE Eco SET Bank = " + 0 + " WHERE UUID= '" +p.getUniqueId() + "'");
	    }
	    catch (SQLException e)
	    {
	    	 Bukkit.getConsoleSender().sendMessage("§c" + e);
	    }
	
	}
	public static HashMap<String,Integer> Kontotop10() {
		
		
		 Map<String,Integer> thisHashMap = new HashMap<>();
	      try {
	    	Statement s = Mysql.con.createStatement();
	    	 ResultSet rs = s.executeQuery("SELECT Username,Konto FROM Eco ORDER BY Konto DESC LIMIT 10");
	    	 while (rs.next()) {
	    		
	    		 thisHashMap.put(rs.getString("Username"), rs.getInt("Konto"));
	    		 
	    		 
	    	 }
	    	 return (HashMap<String, Integer>) thisHashMap;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return null;
	}
	public static HashMap<String,Integer> Banktop10() {
		
		
		 Map<String,Integer> thisHashMap = new HashMap<>();
	      try {
	    	Statement s = Mysql.con.createStatement();
	    	 ResultSet rs = s.executeQuery("SELECT Username,Bank FROM Eco ORDER BY Bank DESC LIMIT 10");
	    	 while (rs.next()) {
	    		
	    		 thisHashMap.put(rs.getString("Username"), rs.getInt("Bank"));
	    		 
	    		 
	    	 }
	    	 return (HashMap<String, Integer>) thisHashMap;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return null;
	}
	public static boolean hasbank(Player player, int Menge) {
		
		if(getBank(player) >= Menge) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean haskonto(Player player, int Menge) {
		
		if(getKonto(player) >= Menge) {
			return true;
		}else {
			return false;
		}
	}
}
