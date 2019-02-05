package networking.packets.incoming;

import java.io.DataInputStream;

import models.WorldPosData;
import networking.IncomingPacket;
import networking.PacketType;

public class EnemyShootPacket extends IncomingPacket {

	public byte bulletId;
	public int ownerId;
	public byte bulletType;
	public WorldPosData startingPos;
	public float angle;
	public short damage;
	public byte numShots;
	public float angleInc;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.ENEMYSHOOT;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		bulletId = input.readByte();
		ownerId = input.readInt();
		bulletType = input.readByte();
		(startingPos = new WorldPosData()).read(input);
		angle = input.readFloat();
		damage = input.readShort();
		if (input.available() > 0) {
			numShots = input.readByte();
			angleInc = input.readFloat();
		}
		else
		{
			numShots = 1;
			angleInc = 0;
		}
	}

}
