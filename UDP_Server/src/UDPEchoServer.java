import java.net.*;
import java.io.*;

public class UDPEchoServer {
    public UDPEchoServer(int port) {
        try {
            DatagramSocket ds = new DatagramSocket(port);//3000으로 연관되어있는 port를 찾음
            while (true) {
                byte buffer[] = new byte[512];//512byte로 설정
                DatagramPacket dp = new DatagramPacket(buffer,buffer.length);//전송받을 것	
                System.out.println("ready");
                ds.receive(dp);//클라이언트에서 가져온 dp 데이터를 서버 dp에 저장한다.
                String str = new String(dp.getData());//String 형으로 변환하고
                System.out.println("수신된 데이터 : " + str);

                InetAddress ia = dp.getAddress();//ip: 127.0.0.1
                port = dp.getPort();//클라이언트 포트: 2000
                System.out.println("client ip : " + ia + " , client port : " + dp.getPort());
                dp = new DatagramPacket(dp.getData(),dp.getData().length, ia,port);
                                          //hi        //hi에 길이                      //2000       
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
