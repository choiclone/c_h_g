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

    ReceivingThread(DatagramSocket soc, Main m){
        this.m = m;
        setDataReceive(true);
        buf = new byte[6636];
        dp = new DatagramPacket(buf, buf.length);
        this.soc = soc;
    }

    public void setDataReceive(boolean condition){
        dataReceive = condition;
    }

    @Override
    public void run(){
        super.run();
        System.out.println("...데이터 받기 시작...");
        while(dataReceive){
            try {
                soc.receive(dp);
                String data = new String(dp.getData(), 0, dp.getLength());
                if (NameChk && data.equalsIgnoreCase("false")){m.Rename(vC.makeName());}
                if (!dDvisor.DataGetName(data).equalsIgnoreCase(String_variable.userName)) {
                    System.out.println(data);
                    NameChk = false;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

