package networking.packets.outgoing;

import java.io.DataOutputStream;

import networking.OutgoingPacket;
import networking.PacketType;

public class OtherHitPacket extends OutgoingPacket {

	public int time;
	public int bulletId;
	public int objectId;
	public int targetId;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.OTHERHIT;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		output.writeInt(time);
		output.writeByte(bulletId);
		output.writeInt(objectId);
		output.writeInt(targetId);
	}

}
