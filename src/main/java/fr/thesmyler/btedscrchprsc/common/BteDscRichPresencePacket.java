package fr.thesmyler.btedscrchprsc.common;

import io.netty.buffer.ByteBuf;

public abstract class BteDscRichPresencePacket {
	
	protected final String richPresenceText;
	
	public BteDscRichPresencePacket(String text) {
		this.richPresenceText = text;
	}
	
	protected void encode(ByteBuf buf) {
		this.encodeStringToByteBuf(this.richPresenceText, buf);
	}
	
	protected abstract void encodeStringToByteBuf(String str, ByteBuf buf);
	
	protected abstract String decodeStringFromByteBuf(ByteBuf buf);
	
}
