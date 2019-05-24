package util;

public class dataDivisor {

    /**
     * �뜲�씠�꽣 蹂대궪諛⑹떇
     * �븵�닽�옄�뒗 梨꾪똿諛� 踰덊샇
     * 1_1:Name:Msg
     */

    public int DataGetCnt(String Data){
        int Cnt = 9999;
        String DataSplit[] = Data.split(":");
        Cnt = Integer.valueOf(DataSplit[0]);

        return Cnt;
    }
    public String DataGetName(String Data){
        String Name = "";
        String DataSplit[] = Data.split(":");
        Name = DataSplit[1];

        return Name;
    }
    public String DataGetMsg(String Data){
        String Msg = "";
        String DataSplit[] = Data.split(":");
        Msg = DataSplit[2];
//        System.out.println(Msg);
        return Msg.trim();
    }
}
