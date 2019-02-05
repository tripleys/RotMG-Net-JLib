package networking;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

import crypto.RC4;
import data.Reconnect;
import util.Utility;

public class NetClient implements Runnable {

	public static final String INCOMING_KEY = "c79332b197f92ba85ed281a023";
    public static final String OUTGOING_KEY = "6a39570cc9de4ec71d64821894";
    
    private Socket socket;
    private RC4 incomingEncryption;
    private RC4 outgoingEncryption;
    private DataInputStream input;
	private DataOutputStream output;
    private HashMap<PacketType, ArrayList<Consumer<IncomingPacket>>> hooks = new HashMap<PacketType, ArrayList<Consumer<IncomingPacket>>>();
    private Consumer<?> onConnect;
    private Consumer<?> onDisconnect;
    
    public boolean disconnected = true;
    
    public NetClient() {
    	
    }
    
    public NetClient(Reconnect reconnect) {
    	connect(reconnect);
    }
    
    public void connect(Reconnect reconnect) {
    	incomingEncryption = new RC4(Utility.hexStringToBytes(INCOMING_KEY));
    	outgoingEncryption = new RC4(Utility.hexStringToBytes(OUTGOING_KEY));
    	try {
    		socket = new Socket(reconnect.host, reconnect.port);
    		disconnected = false;
			socket.setTcpNoDelay(true);
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (onDisconnect != null) onDisconnect.accept(null); 
			return;
		}
    	
    	start();
    	if (onConnect != null) onConnect.accept(null);
    }
    
    public void addConnectionListener(Consumer<?> onConnect) {
    	this.onConnect = onConnect;
    }
    
    public void addDisconnectListener(Consumer<?> onDisconnect) {
    	this.onDisconnect = onDisconnect;
    }
    
    private void start() {
    	Thread thread = new Thread(this);
    	thread.setDaemon(true);
    	thread.start();
    }
    
    public void disconnect() {
    	try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	disconnected = true;
    	if (onDisconnect != null) onDisconnect.accept(null);
    }
    
    public void hook(PacketType type, Consumer<IncomingPacket> consumer) {
    	if (!hooks.containsKey(type)) {
    		hooks.put(type, new ArrayList<Consumer<IncomingPacket>>());
    	}
    	hooks.get(type).add(consumer);
    }

	@Override
	public void run() {
		try {
			while(!disconnected) {
				int length = input.readInt();
				int type = input.readUnsignedByte();
				byte[] buf = new byte[length - 5];
				input.readFully(buf);
				processPacket(type, this.incomingEncryption.rc4(buf));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	private void processPacket(int type, byte[] buffer) {
		PacketType packetType = PacketType.as(type);
		IncomingPacket packet = IncomingPacket.create(packetType);
		// if no packet hook exists what is the point to read and process the packet?
		if (packet != null && hooks.containsKey(packetType)) {
			ByteArrayInputStream bs = new ByteArrayInputStream(buffer);
			try(DataInputStream in = new DataInputStream(bs)) {
				packet.read(in);
				hooks.get(packetType).forEach(hook -> hook.accept(packet));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendPacket(OutgoingPacket packet) {
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		try(DataOutputStream dos = new DataOutputStream(bs)) {
			packet.write(dos);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		byte[] buffer = outgoingEncryption.rc4(bs.toByteArray());
		try {
			output.writeInt(buffer.length + 5);
			output.writeByte(packet.getPacketType().type);
			output.write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
