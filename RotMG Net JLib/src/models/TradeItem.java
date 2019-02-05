package models;

import java.io.DataInput;
import java.io.IOException;

public class TradeItem {

	public int item;
	public int slotType;
	public boolean tradeable;
	public boolean included;
	
	public void read(DataInput input) throws IOException {
		item = input.readInt();
		slotType = input.readInt();
		tradeable = input.readBoolean();
		included = input.readBoolean();
	}
}
