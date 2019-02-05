package networking.packets.incoming;

import java.io.DataInputStream;

import networking.IncomingPacket;
import networking.PacketType;

public class PingPacket extends IncomingPacket {

	public int serial;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.PING;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		serial = input.readInt();
	}

}
