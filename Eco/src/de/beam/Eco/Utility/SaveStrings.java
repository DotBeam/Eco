package de.beam.Eco.Utility;

import org.bukkit.entity.Player;

import de.beam.Eco.Api.FileManager;

public class SaveStrings {
	
	public static String pr = FileManager.getString("Config", "Config.Prefix");
	public static String Bankpr = FileManager.getString("Config", "Config.Bank.Prefix");
	public static String Kontopr = FileManager.getString("Config", "Config.Konto.Prefix");
	public static String NoPlayer = FileManager.getString("Config", "Config.NoPlayer");
	public static String NoNumber = FileManager.getString("Config", "Config.NoNumber");
	public static String NoPermission = FileManager.getString("Config", "Config.NoPermission");
	public static String nichtgeldaufderhand = FileManager.getString("Config", "Config.CMD.Bank.einzahlen");
	public static String nichtgeldaufderbank = FileManager.getString("Config", "Config.CMD.Bank.auszahlen");
	public static String TransConfirm = FileManager.getString("Config", "Config.CMD.Bank.confirm");
	
	
	public static String Bank2h = FileManager.getString("Config", "Config.CMD.Bank.2h");
	public static double Bankzins = FileManager.getdouble("Config", "Config.BankZins");
	
	
	public static String Help1 = FileManager.getString("Config", "Config.CMD.Bank.Help1");
	public static String Help2 = FileManager.getString("Config", "Config.CMD.Bank.Help2");
	public static String Help3 = FileManager.getString("Config", "Config.CMD.Bank.Help3");
	public static String Help4 = FileManager.getString("Config", "Config.CMD.Bank.Help4");
	public static String Help5 = FileManager.getString("Config", "Config.CMD.Bank.Help5");
	public static String Help6 = FileManager.getString("Config", "Config.CMD.Bank.Help6");
	public static String Help7 = FileManager.getString("Config", "Config.CMD.Bank.Help7");
	public static String Help8 = FileManager.getString("Config", "Config.CMD.Bank.Help8");
	public static String Help9 = FileManager.getString("Config", "Config.CMD.Bank.Help9");
	public static String Help10 = FileManager.getString("Config", "Config.CMD.Bank.Help10");
	public static String Help11 = FileManager.getString("Config", "Config.CMD.Bank.Help11");
	public static String Help12 = FileManager.getString("Config", "Config.CMD.Bank.Help12");

	
	
	
	
	
	
	
	
	
	
	
	
	public static String kontoseeString(int mege) {
		return FileManager.getString("Config", "Config.CMD.Konto.Kontosee.sender").replace("{Mege}", String.valueOf(mege));
	}
	public static String kontoseeotherString(int mege,Player Taget) {
		return FileManager.getString("Config", "Config.CMD.Konto.Kontosee.Taget").replace("{Mege}",String.valueOf(mege)).replace("{Player}", Taget.getName());
	}
	public static String paysenderString(int mege,Player Taget) {
		return FileManager.getString("Config", "Config.CMD.Konto.pay.sender").replace("{Mege}", String.valueOf(mege)).replace("{Player}", Taget.getName());
	}
	public static String paytagetString(int mege,Player p) {
		return FileManager.getString("Config", "Config.CMD.Konto.pay.Taget").replace("{Mege}", String.valueOf(mege)).replace("{Player}", p.getName());
	}
	public static String payallString(int mege) {
		return FileManager.getString("Config", "Config.CMD.Konto.payall.sender").replace("{Mege}", String.valueOf(mege));
	}
	public static String payallallString(int mege) {
		return FileManager.getString("Config", "Config.CMD.Konto.payall.all").replace("{Mege}", String.valueOf(mege));
	}
	
	//konto set
	public static String kontosetString(int mege,Player Taget) {
		return FileManager.getString("Config", "Config.CMD.Konto.set.sender").replace("{Mege}", String.valueOf(mege)).replace("{Player}", Taget.getName());
	}
	public static String kontosetTagetString(int mege) {
		return FileManager.getString("Config", "Config.CMD.Konto.set.Taget").replace("{Mege}", String.valueOf(mege));
	}
	//konto reset
	public static String kontoresetString(Player Taget) {
		return FileManager.getString("Config", "Config.CMD.Konto.reset.sender").replace("{Player}", Taget.getName());
	}
	public static String kontoresetTagetString() {
		return FileManager.getString("Config", "Config.CMD.Konto.reset.Taget");
	}
	//konto take
	public static String kontotakeString(int mege,Player Taget) {
		return FileManager.getString("Config", "Config.CMD.Konto.take.sender").replace("{Mege}", String.valueOf(mege)).replace("{Player}", Taget.getName());
	}
	public static String kontotakeTagetString(int mege) {
		return FileManager.getString("Config", "Config.CMD.Konto.take.Taget").replace("{Mege}", String.valueOf(mege));
	}
	//konto add
	public static String kontoaddString(int mege,Player Taget) {
		return FileManager.getString("Config", "Config.CMD.Konto.add.sender").replace("{Mege}", String.valueOf(mege)).replace("{Player}", Taget.getName());
	}
	public static String kontoaddTagetString(int mege) {
	   return FileManager.getString("Config", "Config.CMD.Konto.add.Taget").replace("{Mege}", String.valueOf(mege));
	}
	
	
	
	
	//bank see
	public static String BankseeString(int mege) {
		return FileManager.getString("Config", "Config.CMD.Bank.see.sender").replace("{Mege}", String.valueOf(mege));
	}
	public static String BankseeotherString(int mege,Player Taget) {
		return FileManager.getString("Config", "Config.CMD.Bank.see.Taget").replace("{Mege}",String.valueOf(mege)).replace("{Player}", Taget.getName());
	}
	//Bank set
		public static String BanksetString(int mege,Player Taget) {
			return FileManager.getString("Config", "Config.CMD.Bank.set.sender").replace("{Mege}", String.valueOf(mege)).replace("{Player}", Taget.getName());
		}
		public static String BanksetTagetString(int mege) {
			return FileManager.getString("Config", "Config.CMD.Bank.set.Taget").replace("{Mege}", String.valueOf(mege));
		}
		//Bank reset
		public static String BankresetString(Player Taget) {
			return FileManager.getString("Config", "Config.CMD.Bank.reset.sender").replace("{Player}", Taget.getName());
		}
		public static String BankresetTagetString() {
			return FileManager.getString("Config", "Config.CMD.Bank.reset.Taget");
		}
		//Bank take
		public static String BanktakeString(int mege,Player Taget) {
			return FileManager.getString("Config", "Config.CMD.Bank.take.sender").replace("{Mege}", String.valueOf(mege)).replace("{Player}", Taget.getName());
		}
		public static String BanktakeTagetString(int mege) {
			return FileManager.getString("Config", "Config.CMD.Bank.take.Taget").replace("{Mege}", String.valueOf(mege));
		}
		//Bank add
		public static String BankaddString(int mege,Player Taget) {
			return FileManager.getString("Config", "Config.CMD.Bank.add.sender").replace("{Mege}", String.valueOf(mege)).replace("{Player}", Taget.getName());
		}
		public static String BankaddTagetString(int mege) {
		   return FileManager.getString("Config", "Config.CMD.Bank.add.Taget").replace("{Mege}", String.valueOf(mege));
		}
		//bank Zinsen
		public static String bankzinsString(int mege) {
			   return FileManager.getString("Config", "Config.CMD.Bank.Zinsaus").replace("{Mege}", String.valueOf(mege));
			}
	
	
	
	
	
	
	
	
	
	
	
	

}
