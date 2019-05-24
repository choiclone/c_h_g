import java.net.*;

import java.io.*;

public class UDPEchoClient{

    private String str;
    private BufferedReader file;
    private static int SERVERPORT=3000;
    public UDPEchoClient(String ip,int port){
        try{     
            InetAddress ia = InetAddress.getByName(ip);//������ ȣ��Ʈ��(localhost)�� ������ ȣ��Ʈ�� IP �ּҸ� ����մϴ�.
            DatagramSocket ds = new DatagramSocket(port);//Ŭ���̾�Ʈ ��Ʈ: 2000
            System.out.print("message : ");
            file = new BufferedReader(new InputStreamReader(System.in));//���� 
            str = file.readLine();// String   
            byte buffer[] = str.getBytes();//String�� Byte���·� ����ȯ            
            DatagramPacket dp = new DatagramPacket(
                    buffer,buffer.length,ia,SERVERPORT);//������ ��
                 //ex)hi                   //port:3000
            ds.send(dp);//���� ���� ������ ������
            buffer = new byte[512];
            dp = new DatagramPacket(buffer,buffer.length);//�迭�� �迭 ũ�⸦ ����
            ds.receive(dp);//�̹� �����ϴ� dp�� �����Ѵ�.
            System.out.println("server ip : "+dp.getAddress() + " , server port : "+dp.getPort());
                                               //127.0.0.1                            //3000
            System.out.println("���ŵ� ������ : "+ new String(dp.getData()).trim());//���������ؼ� ���
        }catch(IOException ioe){//����¿� ���� ���� ó��
            ioe.printStackTrace();          
        }
    }
    public static void main(String[] args){
        new UDPEchoClient("localhost",2000);//ia: 127.0.0.1, Client port:2000        
    }
}