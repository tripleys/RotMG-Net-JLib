package networking.packets.outgoing;

import java.io.DataOutputStream;

import networking.OutgoingPacket;
import networking.PacketType;

public class ChangePetSkinPacket extends OutgoingPacket {

	public int petId;
	public int skinType;
	public int currency;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.PETCHANGESKINMSG;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		output.writeInt(petId);
		output.writeInt(skinType);
		output.writeInt(currency);
	}

}
