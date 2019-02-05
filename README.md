# RotMG-Net-JLib
Realm of the Mad God Networking Java Library

You can use this library to implement your own Realm of the Mad God bots.

Check this if you want to use C# library: https://github.com/tripleys/RotMG-Net-Lib

Example class:
```java
import java.io.IOException;

import crypto.RSA;
import data.Reconnect;
import networking.NetClient;
import networking.PacketType;
import networking.packets.incoming.FailurePacket;
import networking.packets.incoming.NewTickPacket;
import networking.packets.outgoing.HelloPacket;
import networking.packets.outgoing.LoadPacket;
import networking.packets.outgoing.UpdateAckPacket;

public class Test {

	public static void main(String[] args) throws IOException {
		NetClient client = new NetClient(new Reconnect("54.93.78.148", 2050, -2, 0, new byte[0]));
		client.hook(PacketType.FAILURE, (p) -> 
			System.out.println("Failure: " + ((FailurePacket)p).errorDescription)
		);
		client.hook(PacketType.MAPINFO, (p) -> {
			LoadPacket load = new LoadPacket();
			load.charId = 2;
			load.isFromArena = false;
			client.sendPacket(load);
		});
		client.hook(PacketType.UPDATE, (p) -> {
			client.sendPacket(new UpdateAckPacket());
		});
		client.hook(PacketType.NEWTICK, (p) -> {
			System.out.println("NEW_TICK, id: " + ((NewTickPacket) p).tickId);
		});
		
		HelloPacket hello = new HelloPacket();
		hello.buildVersion = "X31.3.0";
		hello.gameId = -2;
		hello.guid = RSA.encrypt("your email");
		hello.password = RSA.encrypt("your password");
		hello.secret = RSA.encrypt("");
		hello.gameNet = "rotmg";
		hello.playPlatform = "rotmg";
		
		client.sendPacket(hello);
		
		System.in.read();
	}
}
