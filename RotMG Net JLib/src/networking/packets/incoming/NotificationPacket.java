package networking.packets.incoming;

import java.io.DataInputStream;

import networking.IncomingPacket;
import networking.PacketType;

public class NotificationPacket extends IncomingPacket {

	public int objectId;
	public String message;
	public int color;
	
	@Override
	public PacketType getPacketType() {
		return PacketType.NOTIFICATION;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		objectId = input.readInt();
		message = input.readUTF();
		color = input.readInt();
	}

}
