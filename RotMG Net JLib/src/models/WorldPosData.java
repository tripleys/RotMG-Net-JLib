package models;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class WorldPosData {

	public float x;
	public float y;
	
	public WorldPosData() {
		
	}
	
	public WorldPosData(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void read(DataInput input) throws IOException {
		x = input.readFloat();
		y = input.readFloat();
	}
	
	public void write(DataOutput output) throws IOException {
		output.writeFloat(x);
		output.writeFloat(y);
	}
	
	public float distanceTo(WorldPosData wp)
    {
        float dx = wp.x - x;
        float dy = wp.x - y;
        return (float)Math.sqrt(dx * dx + dy * dy);
    }

    public float distanceTo(float x, float y)
    {
        float dx = x - this.x;
        float dy = y - this.y;
        return (float)Math.sqrt(dx * dx + dy * dy);
    }
}
