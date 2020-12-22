package ml.SunProxy.SunProxyAPI;

import cn.nukkit.network.protocol.DataPacket;

/**
 * @author Jviguy
 *
 * A packet used to send Proxy wide Messages!
 *
 * @see SunProxyAPI
 */
public class SunTextPacket extends DataPacket {

    public static final byte NETWORK_ID = SunProxyAPI.SUN_TEXT_PACKET;

    /**
     * A string representing the Message to be sent across the Proxy.
     */
    public String message;

    /**
     * An array of ips representing the certain servers to send the messages to.
     */
    public String[] servers;

    public void decode() {
        //read message
        this.message = this.getString();
        long count = this.getUnsignedVarInt();
        for (int i = 0; i < count; i++) {
            this.servers[i] = this.getString();
        }
    }

    public void encode() {
        //Reset buffer
        this.reset();
        //Write the message
        this.putString(this.message);
        //Write the count
        this.putUnsignedVarInt(this.servers.length);
        for (String server: servers) {
            this.putString(server);
        }
    }

    public byte pid() {
        return SunProxyAPI.SUN_TEXT_PACKET;
    }

    public String toString() {
        return "SunTextPacket(message=" + this.message+")";
    }

}
