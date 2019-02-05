package networking.packets.incoming;

import java.io.DataInputStream;

import networking.IncomingPacket;
import networking.PacketType;

public class AccountListPacket extends IncomingPacket {

	public int accountListId;
	public String[] accountIds;
	public int lockAction;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.ACCOUNTLIST;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		accountListId = input.readInt();
		accountIds = new String[input.readShort()];
		for(int i = 0; i < accountIds.length; i++)
			accountIds[i] = input.readUTF();
		lockAction = input.readInt();
	}

}
