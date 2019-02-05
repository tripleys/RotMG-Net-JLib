package networking.packets.incoming;

import java.io.DataInputStream;
import java.io.IOException;

import networking.IncomingPacket;
import networking.PacketType;

public class FailurePacket extends IncomingPacket {

	public int errorId;
	public String errorDescription;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.FAILURE;
	}

	@Override
	public void read(DataInputStream input) throws IOException {
		// TODO Auto-generated method stub
		errorId = input.readInt();
		errorDescription = input.readUTF();
	}

}
