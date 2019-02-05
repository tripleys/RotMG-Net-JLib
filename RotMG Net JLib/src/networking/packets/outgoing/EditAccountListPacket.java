package networking.packets.outgoing;

import java.io.DataOutputStream;

import networking.OutgoingPacket;
import networking.PacketType;

public class EditAccountListPacket extends OutgoingPacket {

	public int accountListId;
	public boolean add;
	public int objectId;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.EDITACCOUNTLIST;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		output.writeInt(accountListId);
		output.writeBoolean(add);
		output.writeInt(objectId);
	}

}
