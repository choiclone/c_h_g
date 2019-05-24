package com.socServer;

import java.util.Scanner;

public class varCollection {//이름 입력하는 프로그램을 따로 클래스로 생성

    Scanner sc = new Scanner(System.in);

    String makeName(){
        String name;
        System.out.println("이름을 정해주세요.");
        name = sc.next();
        System.out.println("정하신 이름 :"+name);
        return name;
    }

    String getString(){
        String str = sc.nextLine();
        return str;
    }

}
