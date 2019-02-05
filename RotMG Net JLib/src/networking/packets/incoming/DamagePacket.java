package networking.packets.incoming;

import java.io.DataInputStream;

import networking.IncomingPacket;
import networking.PacketType;

public class DamagePacket extends IncomingPacket {

	public int targetId;
	public byte[] effects;
	public int damageAmount;
	public boolean kill;
	public boolean armorPierce;
	public byte bulletId;
	public int objectId;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.DAMAGE;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		targetId = input.readInt();
		effects = new byte[input.readByte()];
		for(byte b = 0; b < effects.length; b++) {
			effects[b] = input.readByte();
		}
		damageAmount = input.readUnsignedShort();
		kill = input.readBoolean();
		armorPierce = input.readBoolean();
		bulletId = input.readByte();
		objectId = input.readInt();
	}

}
