package com.socServer;

public class dataDivisor {
	//Data = ������̸�:�޽��� 
    //EX)Data = 1:HI
    public String DataGetName(String Data){
        String Name = "";
        String DataSplit[] = Data.split(":");//1 ":" is connected�� �迭 0�� 1�� ��
        Name = DataSplit[0];//1(����� �̸��� �鰨)

        return Name;
    }
    public String DataGetMsg(String Data){
        String Msg = "";
        String DataSplit[] = Data.split(":");
        Msg = DataSplit[1];//HI(�� ����ڰ� �Է��ߴ� �޽����� ��)
        //System.out.println(Msg);
        return Msg.trim();//��ȯ �� ���� �޽����� �յ� ������ ���� �� ������ trim�Լ��� ������ �����ϰ� ������.
    }
}
