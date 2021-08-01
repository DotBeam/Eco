package de.beam.Eco.Utility;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import de.beam.Eco.Main.Eco;


public class Config {
	
	 public static void CreateCfgs() {
			
			File file = new File(Eco.eco.getDataFolder(), "Mysql.yml");
		    if(!file.exists()) {
		    	Createmysqlcfg();
		    	Bukkit.getConsoleSender().sendMessage(SaveStrings.pr+"§c Bitte trage Deine Mysql Daten Ein");
		    	Bukkit.shutdown();
		    }
			CreateCfg();
		}
		
		private static void Createmysqlcfg() {
			File file = new File(Eco.eco.getDataFolder(), "Mysql.yml");
		    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		    if(!file.exists()) {
		    	cfg.set("Mysql.Host", "localhost");
			    cfg.set("Mysql.Port", "3306");
			    cfg.set("Mysql.User", "root");
			    cfg.set("Mysql.Pass", "");
			    cfg.set("Mysql.Database", "");
			    try {
					cfg.save(file);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		    }
		    
			
			
		}
		private static void CreateCfg() {
			File file = new File(Eco.eco.getDataFolder(), "Config.yml");
		    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		    if(!file.exists()) {
		    	cfg.set("Config.Prefix","§d§lSystem §8>> §7");
		    	cfg.set("Config.Bank.Prefix","§d§lSystem §8>> §7");
		    	cfg.set("Config.Konto.Prefix","§d§lSystem §8>> §7");
		    	cfg.set("Config.BankZins",0.02);
		    	cfg.set("Config.NoPermission","No Permission");
		    	cfg.set("Config.NoPlayer","No Player");
		    	cfg.set("Config.NoNumber","No Number");
		    	
		    	cfg.set("Config.CMD.Konto.payall.sender","Du hast allen Spielern {Mege} $ gegeben");
		    	cfg.set("Config.CMD.Konto.payall.all","allen Spieler haben {Mege} $ bekommen");
		    	//Konto Pay
		    	cfg.set("Config.CMD.Konto.pay.Taget","Du hast von denn Spieler {Player} {Mege} $ erhalten");
		    	cfg.set("Config.CMD.Konto.pay.sender","Du hast denn Spieler {Player} {Mege} $ überwisen");
		    	//Konto
		    	cfg.set("Config.CMD.Konto.Kontosee.sender","Du hast {Mege} $ auf der hand");
		    	cfg.set("Config.CMD.Konto.Kontosee.Taget","Der Spieler {Player} hat {Mege} $ auf der hand");
		    	//konto set
		    	cfg.set("Config.CMD.Konto.set.sender","Du hast das konto von {Player} auf {Mege} $ gesetz");
		    	cfg.set("Config.CMD.Konto.set.Taget","dein konto wurde auf {Mege} $ gesetz");
		    	//konto reset
		    	cfg.set("Config.CMD.Konto.reset.sender","Du hast das konto von {Player} resetz");
		    	cfg.set("Config.CMD.Konto.reset.Taget","dein konto wurde auf resetz");
		    	//konto take
		    	cfg.set("Config.CMD.Konto.take.sender","Du hast denn spieler {Player} {Mege} vom konto abgezogen");
		    	cfg.set("Config.CMD.Konto.take.Taget","von deiem konto qurden {Mege} abgezogen");
		    	//konto add
		    	cfg.set("Config.CMD.Konto.add.sender","Du hast denn spieler {Player} {Mege} zum Konto hinzugefügt");
		    	cfg.set("Config.CMD.Konto.add.Taget","deiem konto wurden {Mege} hinzugefügt");

		    	
		    	//Bank
		    	cfg.set("Config.CMD.Bank.see.sender","Du hast {Mege} $ auf der Bank");
		    	cfg.set("Config.CMD.Bank.see.Taget","Der Spieler {Player} hat {Mege} $ auf der Bank");
		    	//Bank set
		    	cfg.set("Config.CMD.Bank.set.sender","Du hast das Bank von {Player} auf {Mege} $ gesetz");
		    	cfg.set("Config.CMD.Bank.set.Taget","dein Bank wurde auf {Mege} $ gesetz");
		    	//Bank reset
		    	cfg.set("Config.CMD.Bank.reset.sender","Du hast das Bank von {Player} resetz");
		    	cfg.set("Config.CMD.Bank.reset.Taget","dein Bank wurde auf resetz");
		    	//Bank take
		    	cfg.set("Config.CMD.Bank.take.sender","Du hast denn spieler {Player} {Mege} vom Bank abgezogen");
		    	cfg.set("Config.CMD.Bank.take.Taget","von deiem Bank qurden {Mege} abgezogen");
		    	//Bank add
		    	cfg.set("Config.CMD.Bank.add.sender","Du hast denn spieler {Player} {Mege} zum Bank hinzugefügt");
		    	cfg.set("Config.CMD.Bank.add.Taget","deiem Bank wurden {Mege} hinzugefügt");
		    	//Bank Ein
		    	cfg.set("Config.CMD.Bank.einzahlen","Du hast nicht genung geld auf der hand");
		    	//bank aus
		    	cfg.set("Config.CMD.Bank.auszahlen","Du hast nicht genung geld auf der bank");
		    	//bank erfolg
		    	cfg.set("Config.CMD.Bank.confirm","Deine Zahlung hat stad gefunden");
		    	//Bank Zinsen
		    	cfg.set("Config.CMD.Bank.2h","Du bekommst alle 2h ");
		    	cfg.set("Config.CMD.Bank.Zinsaus","Du hast {Mege} Zinsen bekommen");
		    	
		    	
		    	//Bank Help
		    	cfg.set("Config.CMD.Bank.Help1","null");
		    	cfg.set("Config.CMD.Bank.Help2","null");
		    	cfg.set("Config.CMD.Bank.Help3","null");
		    	cfg.set("Config.CMD.Bank.Help4","null");
		    	cfg.set("Config.CMD.Bank.Help5","null");
		    	cfg.set("Config.CMD.Bank.Help6","null");
		    	cfg.set("Config.CMD.Bank.Help7","null");
		    	cfg.set("Config.CMD.Bank.Help8","null");
		    	cfg.set("Config.CMD.Bank.Help9","null");
		    	cfg.set("Config.CMD.Bank.Help10","null");
		    	cfg.set("Config.CMD.Bank.Help11","null");
		    	cfg.set("Config.CMD.Bank.Help12","null");
		    	
			try {
				cfg.save(file);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
		    }
		}

}
