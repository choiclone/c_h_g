package com.socServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Socplayer {
    private Main m;

    private int cnt = 0;
    private int port = 8888;

    private DatagramSocket soc;
    private InetAddress ip;
    private Thread RCThread;

    private ReceivingThread ThreadReciver;

    protected void initial(InetAddress ip, String name, Main m) throws SocketException {
        soc = new DatagramSocket();
        this.ip = ip;
        this.m = m;
        String_variable.userName = name;
        MsgSend(String_variable.initUserTxt);
    }

    protected void Rename(String name){
        cnt = 0;
        String_variable.userName = name;
        MsgSend(String_variable.initUserTxt);
    }

    public void MsgSend(String Msg){
        try {
        Msg = cnt+":"+String_variable.userName+":"+Msg+"";
//        System.out.println("보내실 메세지 : "+Msg);
        byte[] buf = Msg.getBytes("UTF-8");
//        System.out.println(ip+":"+port);
        DatagramPacket dp = new DatagramPacket(buf, buf.length, ip, port);
        soc.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        cnt++;
    }

    protected void receivingData() {
        ThreadReciver = new ReceivingThread(soc, m);
        RCThread = new Thread(ThreadReciver);
        RCThread.start();
    }

    protected void stopReceive(){
        ThreadReciver.setDataReceive(false);
    }
}
