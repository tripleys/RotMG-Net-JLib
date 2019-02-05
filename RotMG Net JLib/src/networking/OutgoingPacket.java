package networking;

import java.io.DataOutputStream;

public abstract class OutgoingPacket {

	public abstract PacketType getPacketType();
	public abstract void write(DataOutputStream output) throws Exception;
}
