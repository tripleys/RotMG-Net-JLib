package networking.packets.incoming;

import java.io.DataInputStream;

import networking.IncomingPacket;
import networking.PacketType;

public class TextPacket extends IncomingPacket {

	public String name;
	public int objectId;
	public int numStars;
	public byte bubbleTime;
	public String recipient;
	public String text;
	public String cleanText;
	public boolean isSupporter;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.TEXT;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		name = input.readUTF();
		objectId = input.readInt();
		numStars = input.readInt();
		bubbleTime = input.readByte();
		recipient = input.readUTF();
		text = input.readUTF();
		cleanText = input.readUTF();
		isSupporter = input.readBoolean();
	}

}
