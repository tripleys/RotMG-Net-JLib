package models;

import java.io.DataInput;
import java.io.IOException;

public class ObjectStatusData {

	public int objectId;
	public WorldPosData pos;
	public StatData[] stats;
	
	public void read(DataInput input) throws IOException
    {
        objectId = input.readInt();
        (pos = new WorldPosData()).read(input);
        stats = new StatData[input.readShort()];
        for(int i = 0; i < stats.length; i++)
        {
            (stats[i] = new StatData()).read(input);
        }
    }
}
