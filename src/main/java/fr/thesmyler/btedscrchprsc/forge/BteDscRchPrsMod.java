package fr.thesmyler.btedscrchprsc.forge;

import org.apache.logging.log4j.Logger;

import fr.thesmyler.btedscrchprsc.common.Constants;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = BteDscRchPrsMod.MODID, name = BteDscRchPrsMod.NAME, useMetadata = true, acceptableRemoteVersions = "*")
public class BteDscRchPrsMod {
	
    public static final String MODID = "btedscrchprsc";
    public static final String NAME = "BTE Discord Rich Presence";
    
    private static String version;
    
    public static final SimpleNetworkWrapper CHANNEL = NetworkRegistry.INSTANCE.newSimpleChannel(Constants.CHANNEL_NAME);

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        version = event.getModMetadata().version;
        CHANNEL.registerMessage(BteDscForgePacket.Handler.class, BteDscForgePacket.class, Constants.PACKET_DISCRIMINATOR, Side.CLIENT);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	MinecraftForge.EVENT_BUS.register(this);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
    
    @SubscribeEvent
    public void onPlayerJoin(PlayerLoggedInEvent event) {
    	CHANNEL.sendTo(new BteDscForgePacket("TEST"), (EntityPlayerMP) event.player); //FIXME Do not hard code status
    }
    
    public static String version() {
    	return version;
    }
    
    public static Logger logger() {
    	return logger;
    }
    
}
