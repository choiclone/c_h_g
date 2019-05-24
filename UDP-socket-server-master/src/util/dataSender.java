package util;

import DataModel.UserData;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.Charset;

public class dataSender {

    private DatagramSocket dsoc;

    dataSender(DatagramSocket dsoc){//8888
        this.dsoc = dsoc;//8888�� ���� this.dsoc�� ��
    }

    public void dataSend(UserData uData, String Name, String Msg) throws IOException {
        System.out.println("...Data Send...");

        Msg = Name+":"+Msg;//Ŭ���̾�Ʈ�� ������ �޽���(2:is connected)
        byte[] MsgB = Msg.getBytes(Charset.forName("UTF-8"));
        DatagramPacket dp = new DatagramPacket(MsgB, MsgB.length, uData.getIp()/*127.0.0.1*/, uData.getPort());
        System.out.println(uData.getPort());
        dsoc.send(dp);//Ŭ���̾�Ʈ���� Msg�� �κ��� �ٲ��ش�
    }

    public void backToUser(InetAddress ip, int port) throws IOException{//�ߺ� ����ڰ� ������ ��
        String value = "false";
        byte[] MsgB = value.getBytes(Charset.forName("UTF-8"));
        DatagramPacket dp = new DatagramPacket(MsgB, MsgB.length, ip, port);

        dsoc.send(dp);
    }
}
