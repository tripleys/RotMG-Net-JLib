package models;

import java.io.DataInput;
import java.io.IOException;

public class GroundTileData {
	
	public short x;
	public short y;
	public int type;
	
	public void read(DataInput input) throws IOException {
		x = input.readShort();
		y = input.readShort();
		type = input.readUnsignedShort();
	}
}
