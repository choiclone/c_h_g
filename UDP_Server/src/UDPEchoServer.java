import java.net.*;
import java.io.*;

public class UDPEchoServer {
    public UDPEchoServer(int port) {
        try {
            DatagramSocket ds = new DatagramSocket(port);//3000���� �����Ǿ��ִ� port�� ã��
            while (true) {
                byte buffer[] = new byte[512];//512byte�� ����
                DatagramPacket dp = new DatagramPacket(buffer,buffer.length);//���۹��� ��	
                System.out.println("ready");
                ds.receive(dp);//Ŭ���̾�Ʈ���� ������ dp �����͸� ���� dp�� �����Ѵ�.
                String str = new String(dp.getData());//String ������ ��ȯ�ϰ�
                System.out.println("���ŵ� ������ : " + str);

                InetAddress ia = dp.getAddress();//ip: 127.0.0.1
                port = dp.getPort();//Ŭ���̾�Ʈ ��Ʈ: 2000
                System.out.println("client ip : " + ia + " , client port : " + dp.getPort());
                dp = new DatagramPacket(dp.getData(),dp.getData().length, ia,port);
                                          //hi        //hi�� ����                      //2000       
                ds.send(dp);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new UDPEchoServer(3000);
    }
}
