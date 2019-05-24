package util;

public class dataDivisor {

    /**
     * �뜲�씠�꽣 蹂대궪諛⑹떇
     * �븵�닽�옄�뒗 梨꾪똿諛� 踰덊샇
     * 1_1:Name:Msg
     */
	//data = 0:1:님이 입장하였습니다.
    public int DataGetCnt(String Data){//같은 사용자 검증 cnt
        int Cnt = 9999;
        //데이터를 ':'마다 끊어서 배열에 삽입
        String DataSplit[] = Data.split(":");
        Cnt = Integer.valueOf(DataSplit[0]);//0

        return Cnt;
    }
    public String DataGetName(String Data){//사용자
        String Name = "";
        String DataSplit[] = Data.split(":");//1
        Name = DataSplit[1];

        return Name;
    }
    public String DataGetMsg(String Data){//메시지
        String Msg = "";
        String DataSplit[] = Data.split(":");//님이 입장하였습니다.
        Msg = DataSplit[2];
//        System.out.println(Msg);
        return Msg.trim();
    }
}
