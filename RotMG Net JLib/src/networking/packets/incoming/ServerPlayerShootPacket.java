package networking.packets.incoming;

import java.io.DataInputStream;

import models.WorldPosData;
import networking.IncomingPacket;
import networking.PacketType;

public class ServerPlayerShootPacket extends IncomingPacket {

	public byte bulletId;
	public int ownerId;
	public int containerType;
	public WorldPosData startingPos;
	public float angle;
	public short damage;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.SERVERPLAYERSHOOT;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		bulletId = input.readByte();
		ownerId = input.readInt();
		containerType = input.readInt();
		(startingPos = new WorldPosData()).read(input);
		angle = input.readFloat();
		damage = input.readShort();
	}

}
