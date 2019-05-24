package com.socServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceivingThread extends Thread{
    private boolean dataReceive = true;
    private boolean NameChk = true;
    private DatagramPacket dp;
    private byte[] buf;
    private DatagramSocket soc;
    private dataDivisor dDvisor = new dataDivisor();
    private Main m;
    private varCollection vC = new varCollection();

    ReceivingThread(DatagramSocket soc/*서버의 내용같은 것들이 들어옴*/, Main m){
        this.m = m;
        setDataReceive(true);
        buf = new byte[6636];
        dp = new DatagramPacket(buf, buf.length);//byte형으로 해주고, 넣을 수 있는 빈 바이트 배열을 생성
        this.soc = soc;//매개변수로 불러온 값을 넣음
    }

    public void setDataReceive(boolean condition){
        dataReceive = condition;//초기에는 true값을 먼저 넣어줌
    }

    @Override//최상위 Thread라는 부모 클래스에서 run
    public void run(){//엌
        super.run();//Runnalbe을 호출한 것 뿐 동작에는 영향이 없음
        System.out.println("...데이터 받기 시작...");
        while(dataReceive){
            try {
                soc.receive(dp);//원래 값을 덮어 씌우고
                String data = new String(dp.getData(), 0, dp.getLength());//1:is connected = 14(0~13)
//                System.out.println(new String(dp.getData()));
//                System.out.print(dp.getLength());
                //조건을 맞춰보았을 때 
                if (NameChk/*true*/ && data.equalsIgnoreCase("false")){m.Rename(vC.makeName());}
                //대소문자 구분하지는 않고 같냐~
                if (!dDvisor.DataGetName(data).equalsIgnoreCase(String_variable.userName)) {
                    System.out.println(data);//사용자 이름과 메세지 출력(2:is connected)
                    NameChk = false;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

