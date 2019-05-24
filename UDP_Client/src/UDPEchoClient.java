import java.net.*;

import java.io.*;

public class UDPEchoClient{

    private String str;
    private BufferedReader file;
    private static int SERVERPORT=3000;
    public UDPEchoClient(String ip,int port){
        try{     
            InetAddress ia = InetAddress.getByName(ip);//지정된 호스트명(localhost)을 가지는 호스트의 IP 주소를 취득합니다.
            DatagramSocket ds = new DatagramSocket(port);//클라이언트 포트: 2000
            System.out.print("message : ");
            file = new BufferedReader(new InputStreamReader(System.in));//선언 
            str = file.readLine();// String   
            byte buffer[] = str.getBytes();//String을 Byte형태로 형변환            
            DatagramPacket dp = new DatagramPacket(
                    buffer,buffer.length,ia,SERVERPORT);//전송할 것
                 //ex)hi                   //port:3000
            ds.send(dp);//받을 곳인 서버로 보내고
            buffer = new byte[512];
            dp = new DatagramPacket(buffer,buffer.length);//배열과 배열 크기를 전송
            ds.receive(dp);//이미 존재하는 dp에 저장한다.
            System.out.println("server ip : "+dp.getAddress() + " , server port : "+dp.getPort());
                                               //127.0.0.1                            //3000
            System.out.println("수신된 데이터 : "+ new String(dp.getData()).trim());//공백제거해서 출력
        }catch(IOException ioe){//입출력에 대한 예외 처리
            ioe.printStackTrace();          
        }
    }
    public static void main(String[] args){
        new UDPEchoClient("localhost",2000);//ia: 127.0.0.1, Client port:2000        
    }
}