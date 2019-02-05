package networking.packets.incoming;

import java.io.DataInputStream;

import networking.IncomingPacket;
import networking.PacketType;

public class AllyShootPacket extends IncomingPacket {

	public byte bulletId;
	public int ownerId;
	public short containerType;
	public float angle;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.ALLYSHOOT;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		bulletId = input.readByte();
		ownerId = input.readInt();
		containerType = input.readShort();
		angle = input.readFloat();
	}

}
