package networking.packets.incoming;

import java.io.DataInputStream;

import models.WorldPosData;
import networking.IncomingPacket;
import networking.PacketType;

public class GotoPacket extends IncomingPacket {

	public int objectId;
	public WorldPosData pos;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.GOTO;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		objectId = input.readInt();
		(pos = new WorldPosData()).read(input);
	}

}
