package networking.packets.outgoing;

import java.io.DataOutputStream;

import networking.OutgoingPacket;
import networking.PacketType;

public class EnemyHitPacket extends OutgoingPacket {

	public int time;
	public int bulletId;
	public int targetId;
	public boolean kill;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.ENEMYHIT;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		output.writeInt(time);
		output.writeByte(bulletId);
		output.writeInt(targetId);
		output.writeBoolean(kill);
	}

}
