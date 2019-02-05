package networking.packets.incoming;

import java.io.DataInputStream;

import networking.IncomingPacket;
import networking.PacketType;

public class ReconnectPacket extends IncomingPacket {

	public String name;
	public String host;
	public String stats;
	public int port;
	public int gameId;
	public int keyTime;
	public byte[] key;
	public boolean isFromArena;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.RECONNECT;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		name = input.readUTF();
		host = input.readUTF();
		stats = input.readUTF();
		port = input.readInt();
		gameId = input.readInt();
		keyTime = input.readInt();
		isFromArena = input.readBoolean();
		key = new byte[input.readShort()];
		input.read(key);
	}

}
