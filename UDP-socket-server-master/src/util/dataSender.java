package util;

import DataModel.UserData;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.Charset;

public class dataSender {

    private DatagramSocket dsoc;

    dataSender(DatagramSocket dsoc){
        this.dsoc = dsoc;
    }

    public void dataSend(UserData uData, String Name, String Msg) throws IOException {
        System.out.println("...Data Send...");

        Msg = Name+":"+Msg;
        byte[] MsgB = Msg.getBytes(Charset.forName("UTF-8"));
        DatagramPacket dp = new DatagramPacket(MsgB, MsgB.length, uData.getIp(), uData.getPort());

        dsoc.send(dp);
    }

    public void backToUser(InetAddress ip, int port) throws IOException{
        String value = "false";
        byte[] MsgB = value.getBytes(Charset.forName("UTF-8"));
        DatagramPacket dp = new DatagramPacket(MsgB, MsgB.length, ip, port);

        dsoc.send(dp);
    }
}
