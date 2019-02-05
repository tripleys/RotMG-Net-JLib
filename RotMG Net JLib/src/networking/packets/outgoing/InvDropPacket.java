package networking.packets.outgoing;

import java.io.DataOutputStream;

import models.SlotObjectData;
import networking.OutgoingPacket;
import networking.PacketType;

public class InvDropPacket extends OutgoingPacket {

	public SlotObjectData slotObject;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.INVDROP;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		slotObject.write(output);
	}

}
