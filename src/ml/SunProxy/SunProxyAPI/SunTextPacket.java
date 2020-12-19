package ml.SunProxy.SunProxyAPI;

import cn.nukkit.network.protocol.DataPacket;

/**
 * @author Jviguy
 *
 * A packet used to send Proxy wide Messages!
 *
 * @see SunProxyAPI.SendProxyWideMessage
 */
public class SunTextPacket extends DataPacket {

    public static final byte NETWORK_ID = SunProxyAPI.SUN_TEXT_PACKET;

    /**
     * A string representing the Message to be sent across the Proxy
     */
    public String message;


    public void decode() {
        //read message
        this.message = this.getString();
    }

    public void encode() {
        //Reset buffer
        this.reset();
        //Write the message
        this.putString(this.message);
    }

    public byte pid() {
        return SunProxyAPI.SUN_TEXT_PACKET;
    }

    public String toString() {
        return "SunTextPacket(message=" + this.message+")";
    }

}
