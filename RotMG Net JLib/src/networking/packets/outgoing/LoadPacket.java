package networking.packets.outgoing;

import java.io.DataOutputStream;
import java.io.IOException;

import networking.OutgoingPacket;
import networking.PacketType;

public class LoadPacket extends OutgoingPacket {

	public int charId;
	public boolean isFromArena;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.LOAD;
	}

	@Override
	public void write(DataOutputStream output) throws IOException {
		// TODO Auto-generated method stub
		output.writeInt(charId);
		output.writeBoolean(isFromArena);
	}

}
