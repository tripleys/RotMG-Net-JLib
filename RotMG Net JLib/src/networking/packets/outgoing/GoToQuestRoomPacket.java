package networking.packets.outgoing;

import java.io.DataOutputStream;

import networking.OutgoingPacket;
import networking.PacketType;

public class GoToQuestRoomPacket extends OutgoingPacket {

	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.QUESTROOMMSG;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
