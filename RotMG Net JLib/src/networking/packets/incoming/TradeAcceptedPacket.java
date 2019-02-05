package networking.packets.incoming;

import java.io.DataInputStream;

import networking.IncomingPacket;
import networking.PacketType;

public class TradeAcceptedPacket extends IncomingPacket {

	public boolean[] clientOffer;
	public boolean[] partnerOffer;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.TRADEACCEPTED;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		clientOffer = new boolean[input.readShort()];
		for(short i = 0; i < clientOffer.length; i++)
			clientOffer[i] = input.readBoolean();
		partnerOffer = new boolean[input.readInt()];
		for(short i = 0; i < partnerOffer.length; i++)
			partnerOffer[i] = input.readBoolean();
	}

}
