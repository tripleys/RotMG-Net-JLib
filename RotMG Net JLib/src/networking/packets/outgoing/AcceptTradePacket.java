package networking.packets.outgoing;

import java.io.DataOutputStream;

import networking.OutgoingPacket;
import networking.PacketType;

public class AcceptTradePacket extends OutgoingPacket {

	public boolean[] clientOffer;
	public boolean[] partnerOffer;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.ACCEPTTRADE;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		output.writeShort(clientOffer.length);
		for(boolean b : clientOffer)
			output.writeBoolean(b);
		output.writeShort(partnerOffer.length);
		for(boolean b : partnerOffer)
			output.writeBoolean(b);
	}

}
