package ml.SunProxy.SunProxyAPI;

import cn.nukkit.Player;
import cn.nukkit.Server;

public class SunProxyAPI {

    /**
     * The ID of the SunTransferPacket
     */
    static byte SUN_TRANSFER_PACKET = (byte) 300;

    /**
     * The ID of the SunTextPacket
     */
    static byte SUN_TEXT_PACKET = (byte) 301;

    /**
     * @author Jviguy
     *
     * Registers all the needed packets to begin using the api
     *
     */
    public static void Register() {
        Server.getInstance().getNetwork().registerPacket(SUN_TRANSFER_PACKET, SunTransferPacket.class);
        Server.getInstance().getNetwork().registerPacket(SUN_TEXT_PACKET, SunTextPacket.class);
    }

    /**
     * @author Jviguy
     *
     * Transfers a player to a new server through the SunProxy api
     *
     * @param player - the given player to be fast transferred
     * @param address - the address of the new server
     * @param port - the given uint16 port of the server
     */
    public static void FastTransferPlayer(Player player, String address, int port) {
        SunTransferPacket pk = new SunTransferPacket();
        pk.address = address;
        pk.port = port;
        player.dataPacket(pk);
    }

    /**
     * @author Jviguy
     *
     * Sends a message across the whole proxy
     *
     * @param player - the player to send the packet too
     * @param msg - the said message to be sent across the proxy
     */
    public static void SendProxyWideChat(Player player, String msg) {
        SunTextPacket pk = new SunTextPacket();
        pk.message = msg;
        player.dataPacket(pk);
    }
}
