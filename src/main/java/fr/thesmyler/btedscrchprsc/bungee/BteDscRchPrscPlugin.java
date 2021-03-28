package fr.thesmyler.btedscrchprsc.bungee;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import fr.thesmyler.btedscrchprsc.common.Constants;
import fr.thesmyler.btedscrchprsc.common.Formatting;
import fr.thesmyler.bungee2forge.api.ForgeChannel;
import fr.thesmyler.bungee2forge.api.ForgeChannelRegistry;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;

public class BteDscRchPrscPlugin extends Plugin implements Listener {
	
	private ForgeChannel channel;
	private Configuration configuration;

	@Override
	public void onEnable() {
		try {
			this.loadConfig();
		} catch (IOException e) {
			this.getLogger().warning("Failed to load configuration!");
			e.printStackTrace();
		}
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
		String status = Formatting.formatStatus(this.configuration.getString("status", ""), event.getServer().getInfo().getName(), event.getPlayer().getDisplayName());
		this.channel.send(new BteDscBungeePacket(status), event.getPlayer());
	}
	
	private void loadConfig() throws IOException {
		if(!this.getDataFolder().exists()) this.getDataFolder().mkdir();
        File file = new File(this.getDataFolder(), "config.yml");
        
        if(!file.exists()) {
        	try (InputStream in = this.getResourceAsStream("default_config.yml")) {
                Files.copy(in, file.toPath());
            }
        }
        
        this.configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));

	}

}
