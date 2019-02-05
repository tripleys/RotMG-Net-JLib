package models;

import java.io.DataOutput;
import java.io.IOException;

public class MoveRecord {

	public int time;
	public float x;
	public float y;
	
	public MoveRecord(int time, float x, float y) {
		this.time = time;
		this.x = x;
		this.y = y;
	}
	
	public void write(DataOutput output) throws IOException {
		output.writeInt(time);
		output.writeFloat(x);
		output.writeFloat(y);
	}
}
