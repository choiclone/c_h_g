package com.socServer;

import java.io.IOException;
import java.net.InetAddress;

public class Main extends Socplayer{

    varCollection vC = new varCollection();

    public static void main(String[] args) {
        Main m = new Main();
        m.SocServer();
    }

    private void SocServer(){
        try {
            initial(InetAddress.getByName("localhost"), vC.makeName(), this);
            receivingData();
//            System.out.println("hhh");
            while(true){
                String Msg = vC.getString();
                if (!Msg.equalsIgnoreCase("")) { MsgSend(Msg); }
                if (Msg.equalsIgnoreCase("exit")){
                    stopReceive();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
