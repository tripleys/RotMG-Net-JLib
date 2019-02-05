package crypto;

public class RC4State {
	
	public byte[] state;
	
	public int x;
	
	public int y;
	
	public RC4State(byte[] state, int x, int y) {
		this.x = x;
		this.y = y;
		this.state = state;
	}
}
