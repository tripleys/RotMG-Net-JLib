package models;

import java.io.DataInput;
import java.io.IOException;

public class ObjectData {

	public int objectType;
	public ObjectStatusData status;
	
	public void read(DataInput input) throws IOException {
		objectType = input.readUnsignedShort();
		(status = new ObjectStatusData()).read(input);
	}
}
