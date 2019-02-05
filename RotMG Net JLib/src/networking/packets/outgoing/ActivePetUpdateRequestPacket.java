package networking.packets.outgoing;

import java.io.DataOutputStream;

import networking.OutgoingPacket;
import networking.PacketType;

public class ActivePetUpdateRequestPacket extends OutgoingPacket {

	public int commandType;
	public int instanceId;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.ACTIVEPETUPDATEREQUEST;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		output.writeByte(commandType);
		output.writeInt(instanceId);
	}

}
