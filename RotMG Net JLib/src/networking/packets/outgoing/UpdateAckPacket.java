package networking.packets.outgoing;

import java.io.DataOutputStream;

import networking.OutgoingPacket;
import networking.PacketType;

public class UpdateAckPacket extends OutgoingPacket {

	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.UPDATEACK;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
