package com.socServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Socplayer {
	private Main m;

	private int cnt = 0;
	private static final int port = 8888;//서버 포트

	private DatagramSocket soc;
	private InetAddress ip;
	private Thread RCThread;

	private ReceivingThread ThreadReciver;

	protected void initial(InetAddress ip/*127.0.0.1*/, String name/*정한 이름*/, Main m/*Main클래스에 주소 값*/) throws SocketException {
		//보내기만 한다면 굳이 포트번호 쓸 필요없지만 그렇다고 해서 포트번호가 없는것은 아님(임시 포트번호가 따로 이동함)
		soc = new DatagramSocket();//데이터를 받아야하면 포트번호기재하고
		this.ip = ip;//목적지 주소
		this.m = m;//클래스 Main의 주소
		String_variable.userName = name;//앞서 정한 이름을 저장
		MsgSend(String_variable.initUserTxt);// 님이 입장하셨습니다. 가 매개변수 값으로 들어감
	}

	protected void Rename(String name) {// 이름 바꿀 경우에는 cnt를 0으로 다시 초기화 시키고 함
		cnt = 0;
		String_variable.userName = name;
		MsgSend(String_variable.initUserTxt);
	}

	public void MsgSend(String Msg) {// 입벌려 메세지 들간다.
		try {
			Msg = cnt + ":" + String_variable.userName + ":" + Msg + "";// 0:1:hello
//        System.out.println("보내실 메세지 : "+Msg);
			byte[] buf = Msg.getBytes("UTF-8");//바이트 배열로 바꿈
//        System.out.println(ip+":"+port);
			DatagramPacket dp = new DatagramPacket(buf, buf.length, ip, port);//서버 포트로 8888이 클라이언트에겐 출력됨
			soc.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		cnt++;// 사용자가 둘이라면 둘이서 정보를 한 번씩 주고 받으면 카운트1함
	}

	protected void receivingData() {// Main클래스에서 호출함
		ThreadReciver = new ReceivingThread(soc/*서버에서 새로운 값을 가져옴 2:is connected*/, m);
		RCThread = new Thread(ThreadReciver);
		RCThread.start();
	}

	protected void stopReceive() {
		ThreadReciver.setDataReceive(false);
	}
}
