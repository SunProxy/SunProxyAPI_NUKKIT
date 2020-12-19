package ml.SunProxy.SunProxyAPI;

import cn.nukkit.network.protocol.DataPacket;

public class SunTransferPacket extends DataPacket {

    public static final byte NETWORK_ID = SunProxyAPI.SUN_TRANSFER_PACKET;

    /**
     * A string representing the Address of the server
     */
    public String address;

    /**
     * A uint16 representing the port of the server
     */
    public int port = 19132;

    public void decode() {
        this.address = this.getString();
        this.port = (short)this.getLShort();
    }

    public void encode() {
        //Reset buffer
        this.reset();
        //Add the address to the buffer
        this.putString(this.address);
        //Put port
        this.putLShort(this.port);
    }

    public byte pid() {
        return SunProxyAPI.SUN_TRANSFER_PACKET;
    }

    public String toString() {
        return "SunTransferPacket(address=" + this.address + ", port=" + this.port + ")";
    }

}
