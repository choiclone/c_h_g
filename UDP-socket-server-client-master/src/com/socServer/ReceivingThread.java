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

    ReceivingThread(DatagramSocket soc/*������ ���배�� �͵��� ����*/, Main m){
        this.m = m;
        setDataReceive(true);
        buf = new byte[6636];
        dp = new DatagramPacket(buf, buf.length);//byte������ ���ְ�, ���� �� �ִ� �� ����Ʈ �迭�� ����
        this.soc = soc;//�Ű������� �ҷ��� ���� ����
    }

    public void setDataReceive(boolean condition){
        dataReceive = condition;//�ʱ⿡�� true���� ���� �־���
    }

    @Override//�ֻ��� Thread��� �θ� Ŭ�������� run
    public void run(){//��
        super.run();//Runnalbe�� ȣ���� �� �� ���ۿ��� ������ ����
        System.out.println("...������ �ޱ� ����...");
        while(dataReceive){
            try {
                soc.receive(dp);//���� ���� ���� �����
                String data = new String(dp.getData(), 0, dp.getLength());//1:is connected = 14(0~13)
//                System.out.println(new String(dp.getData()));
//                System.out.print(dp.getLength());
                //������ ���纸���� �� 
                if (NameChk/*true*/ && data.equalsIgnoreCase("false")){m.Rename(vC.makeName());}
                //��ҹ��� ���������� �ʰ� ����~
                if (!dDvisor.DataGetName(data).equalsIgnoreCase(String_variable.userName)) {
                    System.out.println(data);//����� �̸��� �޼��� ���(2:is connected)
                    NameChk = false;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

