package com.socServer;

public class dataDivisor {
	//Data = 사용자이름:메시지 
    //EX)Data = 1:HI
    public String DataGetName(String Data){
        String Name = "";
        String DataSplit[] = Data.split(":");//1 ":" is connected가 배열 0과 1에 들어감
        Name = DataSplit[0];//1(사용자 이름이 들감)

        return Name;
    }
    public String DataGetMsg(String Data){
        String Msg = "";
        String DataSplit[] = Data.split(":");
        Msg = DataSplit[1];//HI(그 사용자가 입력했던 메시지가 들어감)
        //System.out.println(Msg);
        return Msg.trim();//반환 할 때는 메시지에 앞뒤 공백이 있을 수 있으니 trim함수로 공백을 제거하고 보낸다.
    }
}
