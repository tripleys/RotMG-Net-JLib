package networking.packets.incoming;

import java.io.DataInputStream;

import models.GroundTileData;
import models.ObjectData;
import networking.IncomingPacket;
import networking.PacketType;

public class UpdatePacket extends IncomingPacket {

	public GroundTileData[] tiles;
	public ObjectData[] newObjects;
	public int[] drops;
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.UPDATE;
	}

	@Override
	public void read(DataInputStream input) throws Exception {
		// TODO Auto-generated method stub
		tiles = new GroundTileData[input.readShort()];
		for(short i = 0; i < tiles.length; i++)
			(tiles[i] = new GroundTileData()).read(input);
		newObjects = new ObjectData[input.readShort()];
		for(short i = 0; i < newObjects.length; i++)
			(newObjects[i] = new ObjectData()).read(input);
		drops = new int[input.readShort()];
		for(short i = 0; i < drops.length; i++)
			drops[i] = input.readInt();
	}

}
