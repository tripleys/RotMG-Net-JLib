package networking.packets.incoming;

import java.io.DataInputStream;

import networking.IncomingPacket;
import networking.PacketType;

public class MapInfoPacket extends IncomingPacket {

	public int width;
	public int height;
	public String name;
	public String displayName;
	public int difficulty;
	public long seed;
	public int background;
	public boolean allowPlayerTeleport;
	public boolean showDisplays;
	public String[] clientXML;
	public String[] extraXML;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.MAPINFO;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		width = input.readInt();
		height = input.readInt();
		name = input.readUTF();
		displayName = input.readUTF();
		seed = Integer.toUnsignedLong(input.readInt());
		background = input.readInt();
		difficulty = input.readInt();
		allowPlayerTeleport = input.readBoolean();
		showDisplays = input.readBoolean();
		clientXML = new String[input.readShort()];
		for(short i = 0; i < clientXML.length; i++) {
			byte[] b = new byte[input.readInt()];
			input.read(b);
			clientXML[i] = new String(b);
		}
		extraXML = new String[input.readShort()];
		for(short i = 0; i < extraXML.length; i++) {
			byte[] b = new byte[input.readInt()];
			input.read(b);
			extraXML[i] = new String(b);
		}
	}

}
