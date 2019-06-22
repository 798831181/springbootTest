package com.sqc.algorithm.test;

import java.util.Scanner;

public class Dex2Bin {
    public static void main(String[] args) {
        System.out.println("输入一个整数：");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        System.out.println("转换之后是：");

        f1(i);


    }

    /**
     * 十进制转换为而二进制
     */
    public static void f1(int i){
        if (i == 0){
            return;
        }else{
           f1(i/2);
            System.out.print(i%2);
            return;
        }
    }
}
