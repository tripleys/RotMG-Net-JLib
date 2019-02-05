package models;

public enum TradeResult {

	SUCCESSFUL(0),
	CANCELED(1);
	
	public final int code;
	
	private TradeResult(int code) {
		this.code = code;
	}
	
	public static TradeResult as(int code) {
		for(TradeResult result : TradeResult.values()) {
			if (result.code == code) return result;
		}
		return null;
	}
}
