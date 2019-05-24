package com.socServer;

import java.io.IOException;
import java.net.InetAddress;

public class Main extends Socplayer{

    varCollection vC = new varCollection();

    public static void main(String[] args) {
        Main m = new Main();//Main이라는 클래스 객체를 선언
        m.SocServer();
    }

    private void SocServer(){
        try {
            initial(InetAddress.getByName("localhost"/*서버: 127.0.0.1 목적지 주소*/), vC.makeName()/*1*/, this/*패키지.클래스@dummy값*/);//값 초기화
            receivingData();
            //System.out.println();
            while(true){
                String Msg = vC.getString();//hello
                if (!Msg.equalsIgnoreCase("")) { MsgSend(Msg); }//equalsIgnoreCase는 대소문자 구분하지 않음, 공백이 아니면 시작함
                if (Msg.equalsIgnoreCase("exit")){//사용자 설정이 끝나고 일반 대화가 아닌 exit를 입력하면 채팅을 종료되고 꺼진다.
                    stopReceive();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
