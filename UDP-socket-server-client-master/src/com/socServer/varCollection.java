package com.socServer;

import java.util.Scanner;

public class varCollection {

    Scanner sc = new Scanner(System.in);

    String makeName(){
        String name;
        System.out.println("�̸��� �����ּ���.");
        name = sc.next();
        System.out.println("���Ͻ� �̸� :"+name);
        return name;
    }

    String getString(){
        String str = sc.nextLine();
        return str;
    }

}
