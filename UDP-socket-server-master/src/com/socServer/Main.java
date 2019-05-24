package com.socServer;

import util.socketMaker;
import util.dataReceiver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {

    private byte[] data = new byte[6636];
    private DatagramSocket dsoc;//실제 데이터 전송을 담당함
    private DatagramPacket dpac;//에플리케이션에서 주고 받을 데이터와 관련된 클래스

    public static void main(String[] args) {
        Main m = new Main();
        m.madeSoc();
    }

    private void madeSoc(){
        socketMaker socMaker = new socketMaker();
        try {
            dsoc = socMaker.makeDsoc(8888);//포트
            dpac = socMaker.makeDPac(data);//넣을 수 있도록 빈 바이트 배열인 data를 만듦
            System.out.println("...socketMade...");
        } catch (SocketException e) {
            e.printStackTrace();
        }
        dataReceiver receiver = new dataReceiver();

        receiver.ReceivingData(dsoc,dpac);
    }
}
