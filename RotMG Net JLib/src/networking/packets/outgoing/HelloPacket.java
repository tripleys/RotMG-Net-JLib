package networking.packets.outgoing;

import java.io.DataOutputStream;
import java.util.Random;

import networking.OutgoingPacket;
import networking.PacketType;

public class HelloPacket extends OutgoingPacket {

	public String buildVersion;
	public int gameId;
	public String guid;
	public String password;
	public String secret;
	public int keyTime;
	public byte[] key;
	public String mapJSON;
	public String entryTag;
	public String gameNet;
	public String gameNetUserId;
	public String playPlatform;
	public String platformToken;
	public String userToken;
	
	public HelloPacket() {
		keyTime = 0;
		key = new byte[0];
		mapJSON = "";
		entryTag = "";
		gameNet = "";
		gameNetUserId = "";
		playPlatform = "";
		platformToken = "";
		userToken = "";
	}
	
	@Override
	public PacketType getPacketType() {
		// TODO Auto-generated method stub
		return PacketType.HELLO;
	}

	@Override
	public void write(DataOutputStream output) throws Exception {
		// TODO Auto-generated method stub
		output.writeUTF(buildVersion);
		output.writeInt(gameId);
		output.writeUTF(guid);
		Random random = new Random();
		output.writeInt(random.nextInt(1000000000));
		output.writeUTF(password);
		output.writeInt(random.nextInt(1000000000));
		output.writeUTF(secret);
		output.writeInt(keyTime);
		output.writeShort(key.length);
		output.write(key);
		output.writeInt(mapJSON.length());
		output.write(mapJSON.getBytes());
		output.writeUTF(entryTag);
		output.writeUTF(gameNet);
		output.writeUTF(gameNetUserId);
		output.writeUTF(playPlatform);
		output.writeUTF(platformToken);
		output.writeUTF(userToken);
	}

}
