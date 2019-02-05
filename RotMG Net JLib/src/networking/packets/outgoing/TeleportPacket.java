package networking.packets.outgoing;

import java.io.DataOutputStream;

import networking.OutgoingPacket;
import networking.PacketType;

public class TeleportPacket extends OutgoingPacket {

	public int objectId;

	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.TELEPORT;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		output.writeInt(objectId);
	}
}
