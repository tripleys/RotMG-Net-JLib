package networking.packets.incoming;

import java.io.DataInputStream;

import models.ObjectStatusData;
import networking.IncomingPacket;
import networking.PacketType;

public class NewTickPacket extends IncomingPacket {

	public int tickId;
	public int tickTime;
	public ObjectStatusData[] statuses;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.NEWTICK;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		tickId = input.readInt();
		tickTime = input.readInt();
		statuses = new ObjectStatusData[input.readShort()];
		for(short i = 0; i < statuses.length; i++)
			(statuses[i] = new ObjectStatusData()).read(input);
	}

}
