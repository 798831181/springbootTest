package com.sqc.exception;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 测试受检查的异常和运行时异常
 */
public class Test1 {
    /**
     * 受检查的异常
     */
    @Test
    public void f1(){
        try {
            InputStream inputStream = new FileInputStream("test.txt");//this is a Checked Exception
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 运行时异常
     */
    @Test
    public void f2(){
        int i = 10 / 0;//RuntimeException
    }

    /**
     * 测试j++
     */
    @Test
    public void test3(){
        int j = 0;
        while (true){
            if (j++ > 10){
                break;
            }
            System.out.println(j);
        }
    }
    @Test
    public void test4(){
        boolean flag = false;
        int result = 1;
        if ((flag == true) && result++ > 2){
            System.out.println(result);
        }else {
            System.out.println("false" + result);
        }
    }

    /**
     * 冒泡排序
     */
    @Test
    public void test5(){
//        char c = '子';
//        System.out.println(c);
        int[] arr = {1,4,5,2,1,2,14,5 };
        int temp;
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] < arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
