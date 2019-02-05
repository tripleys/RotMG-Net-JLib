package networking.packets.outgoing;

import java.io.DataOutputStream;

import networking.OutgoingPacket;
import networking.PacketType;

public class ChangeTradePacket extends OutgoingPacket {

	public boolean[] offer;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.CHANGETRADE;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		output.writeShort(offer.length);
		for(boolean slot : offer)
			output.writeBoolean(slot);
	}

}
