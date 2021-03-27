package fr.thesmyler.btedscrchprsc;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BteDscRchPrsMod.MODID, name = BteDscRchPrsMod.NAME, useMetadata = true)
public class BteDscRchPrsMod
{
    public static final String MODID = "btedscrchprsc";
    public static final String NAME = "BTE Discord Rich Presence";
    private static String version;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        version = event.getModMetadata().version;
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
    
    public static String version() {
    	return version;
    }
    
    public static Logger logger() {
    	return logger;
    }
    
}
