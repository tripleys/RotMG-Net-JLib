package networking.packets.outgoing;

import java.io.DataOutputStream;
import java.util.ArrayList;

import models.MoveRecord;
import models.WorldPosData;
import networking.OutgoingPacket;
import networking.PacketType;

public class MovePacket extends OutgoingPacket {

	public int tickId;
	public int time;
	public WorldPosData newPosition;
	public ArrayList<MoveRecord> records;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.MOVE;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		output.writeInt(tickId);
		output.writeInt(time);
		newPosition.write(output);
		output.writeShort(records.size());
		for(MoveRecord r : records)
			r.write(output);
	}

}
