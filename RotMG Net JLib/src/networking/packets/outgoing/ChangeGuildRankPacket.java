package networking.packets.outgoing;

import java.io.DataOutputStream;

import networking.OutgoingPacket;
import networking.PacketType;

public class ChangeGuildRankPacket extends OutgoingPacket {

	public String name;
	public int guildRank;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.CHANGEGUILDRANK;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		output.writeUTF(name);
		output.writeInt(guildRank);
	}

}
