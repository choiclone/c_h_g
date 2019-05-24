package com.socServer;

public class dataDivisor {
    public String DataGetName(String Data){
        String Name = "";
        String DataSplit[] = Data.split(":");
        Name = DataSplit[0];

        return Name;
    }
    public String DataGetMsg(String Data){
        String Msg = "";
        String DataSplit[] = Data.split(":");
        Msg = DataSplit[1];
//        System.out.println(Msg);
        return Msg.trim();
    }
}
