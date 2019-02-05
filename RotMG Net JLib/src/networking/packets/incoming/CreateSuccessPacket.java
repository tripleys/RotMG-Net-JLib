package networking.packets.incoming;

import java.io.DataInputStream;

import networking.IncomingPacket;
import networking.PacketType;

public class CreateSuccessPacket extends IncomingPacket {

	public int objectId;
	public int charId;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.CREATESUCCESS;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		objectId = input.readInt();
		charId = input.readInt();
	}

}
