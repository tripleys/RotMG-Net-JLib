package networking.packets.outgoing;

import java.io.DataOutputStream;

import networking.OutgoingPacket;
import networking.PacketType;

public class CreatePacket extends OutgoingPacket {

	public short classType;
	public short skinType;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.CREATE;
	}
	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		output.writeShort(classType);
		output.writeShort(skinType);
	}
	
	
}
