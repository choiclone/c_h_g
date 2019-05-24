package util;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class socketMaker {

    public DatagramSocket makeDsoc(int port) throws SocketException {
        return new DatagramSocket(port);//8888포트를 넣음
    }

    public DatagramPacket makeDPac(byte[] data){
        return new DatagramPacket(data, data.length);//data의 값과 data의 길이를 넣는다.
    }
}
