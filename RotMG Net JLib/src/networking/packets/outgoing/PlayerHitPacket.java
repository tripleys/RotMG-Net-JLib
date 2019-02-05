package networking.packets.outgoing;

import java.io.DataOutputStream;

import networking.OutgoingPacket;
import networking.PacketType;

public class PlayerHitPacket extends OutgoingPacket {

	public int bulletId;
	public int objectId;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.PLAYERHIT;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		output.writeByte(bulletId);
		output.writeInt(objectId);
	}

}
