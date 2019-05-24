package com.socServer;

import util.socketMaker;
import util.dataReceiver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {

    private byte[] data = new byte[6636];
    private DatagramSocket dsoc;
    private DatagramPacket dpac;

    public static void main(String[] args) {
        Main m = new Main();
        m.madeSoc();
    }

    private void madeSoc(){
        socketMaker socMaker = new socketMaker();
        try {
            dsoc = socMaker.makeDsoc(8888);
            dpac = socMaker.makeDPac(data);
            System.out.println("...socketMade...");
        } catch (SocketException e) {
            e.printStackTrace();
        }
        dataReceiver receiver = new dataReceiver();

        receiver.ReceivingData(dsoc,dpac);
    }
}
