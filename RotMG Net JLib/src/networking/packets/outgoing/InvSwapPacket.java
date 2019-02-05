package networking.packets.outgoing;

import java.io.DataOutputStream;

import models.SlotObjectData;
import models.WorldPosData;
import networking.OutgoingPacket;
import networking.PacketType;

public class InvSwapPacket extends OutgoingPacket {

	public int time;
	public WorldPosData position;
	public SlotObjectData slotObject1;
	public SlotObjectData slotObject2;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.INVSWAP;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		output.writeInt(time);
		position.write(output);
		slotObject1.write(output);
		slotObject2.write(output);
	}

}
