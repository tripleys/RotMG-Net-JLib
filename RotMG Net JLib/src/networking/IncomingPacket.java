package networking;

import java.io.DataInputStream;

import networking.packets.incoming.*;

public abstract class IncomingPacket {

	public static IncomingPacket create(PacketType type)
    {
        switch(type)
        {
            case FAILURE:
                return new FailurePacket();
            case MAPINFO:
                return new MapInfoPacket();
            case UPDATE:
                return new UpdatePacket();
            case NEWTICK:
                return new NewTickPacket();
            case GOTO:
                return new GotoPacket();
            case PING:
                return new PingPacket();
            case CREATESUCCESS:
                return new CreateSuccessPacket();
            case NOTIFICATION:
                return new NotificationPacket();
            case DAMAGE:
                return new DamagePacket();
            case TEXT:
                return new TextPacket();
            case RECONNECT:
                return new ReconnectPacket();
            case ACCOUNTLIST:
                return new AccountListPacket();
            case SERVERPLAYERSHOOT:
                return new ServerPlayerShootPacket();
            case TRADEREQUESTED:
                return new TradeRequestedPacket();
            case TRADESTART:
                return new TradeStartPacket();
            case TRADEDONE:
                return new TradeDonePacket();
            case TRADECHANGED:
                return new TradeChangedPacket();
            case TRADEACCEPTED:
                return new TradeAcceptedPacket();
            default:
                return null;
        }
    }
	
	public abstract PacketType getPacketType();
	public abstract void read(DataInputStream input) throws Exception;
}
