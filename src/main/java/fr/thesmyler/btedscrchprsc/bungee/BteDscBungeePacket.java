package fr.thesmyler.btedscrchprsc.bungee;

import fr.thesmyler.btedscrchprsc.common.BteDscRichPresencePacket;
import fr.thesmyler.bungee2forge.api.ForgePacket;
import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.DefinedPacket;

public class BteDscBungeePacket extends BteDscRichPresencePacket implements ForgePacket {

	public BteDscBungeePacket(String text) {
		super(text);
	}

	@Override
	public void encode(ByteBuf buf) {
		super.encode(buf);
	}

	@Override
	public void decode(ByteBuf buf) {}

	@Override
	protected void encodeStringToByteBuf(String str, ByteBuf buf) {
		DefinedPacket.writeString(str, buf);
	}

	@Override
	protected String decodeStringFromByteBuf(ByteBuf buf) {
		return DefinedPacket.readString(buf);
	}

}
