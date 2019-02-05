package networking.packets.outgoing;

import java.io.DataOutputStream;

import models.WorldPosData;
import networking.OutgoingPacket;
import networking.PacketType;

public class GroundDamagePacket extends OutgoingPacket {

	public int time;
	public WorldPosData position;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.GROUNDDAMAGE;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		output.writeInt(time);
		position.write(output);
	}

}
