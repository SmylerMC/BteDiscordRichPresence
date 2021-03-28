package fr.thesmyler.btedscrchprsc.forge;

import net.minecraftforge.common.config.Config;

@Config(modid = BteDscRchPrscMod.MODID)
public class BteDscRchPrscModConfig {

	@Config.Name("status")
	@Config.Comment("The status that will be displayed by the BTE modpack."
			+ "\"{server}\" and \"{player}\" will respectively be preplaced with the server hostname and the player's displaye name.")
	public static String pattern = "Playing on a BTE server";
	
}
