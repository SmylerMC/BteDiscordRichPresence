package fr.thesmyler.btedscrchprsc.bungee;

import fr.thesmyler.btedscrchprsc.common.Constants;
import fr.thesmyler.bungee2forge.api.ForgeChannel;
import fr.thesmyler.bungee2forge.api.ForgeChannelRegistry;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class BteDscRchPrsPlugin extends Plugin implements Listener {
	
	private ForgeChannel channel;

	@Override
	public void onEnable() {
		this.channel = ForgeChannelRegistry.instance().get(Constants.CHANNEL_NAME);
		this.channel.registerPacket(Constants.PACKET_DISCRIMINATOR, BteDscBungeePacket.class);
		this.getProxy().getPluginManager().registerListener(this, this);
	}

	@Override
	public void onDisable() {
		this.getProxy().getPluginManager().unregisterListeners(this);
		ForgeChannelRegistry.instance().deregister(this.channel);
		this.channel = null;
	}
	
	@EventHandler
	public void onPlayerJoins(ServerConnectedEvent event) {
		this.channel.send(new BteDscBungeePacket("Test from bungee"), event.getPlayer());
	}

}
