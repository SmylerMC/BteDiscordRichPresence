# BteDscRchPrsc
Control the Discord rich presence status displayed by the BTE modpack when players are on your server or network.
This is intended to be used by teams whose servers are not linked to the `buildtheearth.net` network, or that have an alternative Proxy, since bte.net already offers that functionality.

This is both a Forge mod and a BungeeCord plugin.
If your server is on `buildtheearth.net`, you should not be using the mod version as it would conflict with the network. Use the bungee plugin instead.

## Bungee Plugin
The Bungee plugin has a dependency that needs to be installed as well in order to communicate with the Forge mod: https://www.spigotmc.org/resources/bungeetoforgechannels.90675/

Drop the dependency as well as the BteDscRchPrsc jars in you bungee plugin folder, and restart the proxy. Then edit the new `plugins/BteDiscordRichPresence/config.yml` file to your convenience.

The `{server}` and `{player}` token will be respectively replaced with the name of the server is connected to as defined in the BungeeCord config, and with the player's display name.

Restart or reload the proxy for the changes to take effect.

## Forge mod
This is a server side only mod.

Drop the bteDscRchPrsc jar in your mod folder, and restart the server. Then edit the new `config/btedscrchprsc.cfg`  file to your convenience.

The `{server}` and `{player}` token will be respectively replaced with the server's hostname as defined in server.properties, and with the player's display name.

Restart the server for the changes to take effect.