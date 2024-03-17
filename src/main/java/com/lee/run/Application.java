package com.lee.run;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        MenuController menuController = new MenuController();
        do{

            System.out.println("==================================");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when,otherwise)");
            System.out.println("3.foreach 확인하기");
            System.out.println("4.trim(where,set)");
            System.out.println("9.종료하기");
            System.out.print("메뉴를 선택하세요 : ");
            int no = scr.nextInt();
            switch (no){
                case 1 :
                    menuController.ifSub();
                    break;
                case 2 :
                    menuController.chooseSub();
                    break;
                case 3 :
                    menuController.foreach();
                    break;
                case 4 :
                    menuController.trimSub();
                    break;
                case 9 : return;
            }

        }while(true);


    }
}
