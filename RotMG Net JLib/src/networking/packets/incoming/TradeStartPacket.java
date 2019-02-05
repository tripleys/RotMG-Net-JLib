package networking.packets.incoming;

import java.io.DataInputStream;

import models.TradeItem;
import networking.IncomingPacket;
import networking.PacketType;

public class TradeStartPacket extends IncomingPacket {

	public TradeItem[] clientItems;
	public String partnerName;
	public TradeItem[] partnerItems;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.TRADESTART;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		clientItems = new TradeItem[input.readShort()];
		for(short i = 0; i < clientItems.length; i++)
			(clientItems[i] = new TradeItem()).read(input);
		partnerName = input.readUTF();
		partnerItems = new TradeItem[input.readShort()];
		for(short i = 0; i < partnerItems.length; i++)
			(partnerItems[i] = new TradeItem()).read(input);
	}

}
