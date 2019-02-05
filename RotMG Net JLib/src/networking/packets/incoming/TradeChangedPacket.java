package networking.packets.incoming;

import java.io.DataInputStream;

import networking.IncomingPacket;
import networking.PacketType;

public class TradeChangedPacket extends IncomingPacket {

	public boolean[] offer;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.TRADECHANGED;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		offer = new boolean[input.readShort()];
		for(short i = 0; i < offer.length; i++)
			offer[i] = input.readBoolean();
	}

}
