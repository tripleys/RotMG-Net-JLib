package models;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class SlotObjectData {

	public int objectId;
	public byte slotId;
	public int objectType;
	
	public void read(DataInput input) throws IOException {
		objectId = input.readInt();
		slotId = input.readByte();
		objectType = input.readInt();
	}
	
	public void write(DataOutput output) throws IOException {
		output.writeInt(objectId);
		output.writeByte(slotId);
		output.writeInt(objectType);
	}
}
