package util;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class socketMaker {

    public DatagramSocket makeDsoc(int port) throws SocketException {
        return new DatagramSocket(port);
    }

    public DatagramPacket makeDPac(byte[] data){
        return new DatagramPacket(data, data.length);
    }
}
