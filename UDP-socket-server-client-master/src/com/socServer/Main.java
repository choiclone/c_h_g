package com.socServer;

import java.io.IOException;
import java.net.InetAddress;

public class Main extends Socplayer{

    varCollection vC = new varCollection();

    public static void main(String[] args) {
        Main m = new Main();//Main�̶�� Ŭ���� ��ü�� ����
        m.SocServer();
    }

    private void SocServer(){
        try {
            initial(InetAddress.getByName("localhost"/*����: 127.0.0.1 ������ �ּ�*/), vC.makeName()/*1*/, this/*��Ű��.Ŭ����@dummy��*/);//�� �ʱ�ȭ
            receivingData();
            //System.out.println();
            while(true){
                String Msg = vC.getString();//hello
                if (!Msg.equalsIgnoreCase("")) { MsgSend(Msg); }//equalsIgnoreCase�� ��ҹ��� �������� ����, ������ �ƴϸ� ������
                if (Msg.equalsIgnoreCase("exit")){//����� ������ ������ �Ϲ� ��ȭ�� �ƴ� exit�� �Է��ϸ� ä���� ����ǰ� ������.
                    stopReceive();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
