package fr.thesmyler.btedscrchprsc.common;

public class Formatting {
	
	public static String formatStatus(String pattern, String serverName, String playerName) {
		return pattern.replace("{server}", serverName).replace("{player}", playerName);
	}

}
