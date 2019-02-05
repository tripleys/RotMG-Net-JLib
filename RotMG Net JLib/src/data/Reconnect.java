package data;

public class Reconnect {

	public String host;
	public int port;
	public int gameId;
	public int keyTime;
	public byte[] key;
	
	public Reconnect() {
		
	}
	
	public Reconnect(String host, int port, int gameId, int keyTime, byte[] key) {
		this.host = host;
		this.port = port;
		this.gameId = gameId;
		this.keyTime = keyTime;
		this.key = key;
	}
}
