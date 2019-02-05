package networking.packets.incoming;

import java.io.DataInputStream;

import models.TradeResult;
import networking.IncomingPacket;
import networking.PacketType;

public class TradeDonePacket extends IncomingPacket {

	public TradeResult result;
	public String description;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.TRADEDONE;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		result = TradeResult.as(input.readInt());
		description = input.readUTF();
	}

}
