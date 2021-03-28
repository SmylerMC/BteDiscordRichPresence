package fr.thesmyler.btedscrchprsc.forge;

import fr.thesmyler.btedscrchprsc.common.BteDscRichPresencePacket;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class BteDscForgePacket extends BteDscRichPresencePacket implements IMessage {

	public BteDscForgePacket(String text) {
		super(text);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
	}

	@Override
	public void toBytes(ByteBuf buf) {
		super.encode(buf);
	}
	
	public static class Handler implements IMessageHandler<BteDscForgePacket, IMessage> {

		//Required by forge
		public Handler(){}
		
		@Override
		public IMessage onMessage(BteDscForgePacket pkt, MessageContext ctx) {
			return null;
		}
		

	}

	@Override
	protected void encodeStringToByteBuf(String str, ByteBuf buf) {
		this.getPacketBuffer(buf).writeString(str);
	}
	
	@Override
	protected String decodeStringFromByteBuf(ByteBuf buf) {
		PacketBuffer packetBuffer = this.getPacketBuffer(buf);
		return packetBuffer.readString(Integer.MAX_VALUE/4);
	}
	
	protected PacketBuffer getPacketBuffer(ByteBuf buf) {
		int readerIndex = buf.readerIndex();
		int writerIndex = buf.writerIndex();
		PacketBuffer packetBuffer = new PacketBuffer(buf);
		packetBuffer.setIndex(readerIndex, writerIndex);
		return packetBuffer;
	}

}
