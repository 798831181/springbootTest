package com.sqc.algorithm.test;

/**
 * test temp[current++]的表示效果
 */
public class Test1 {
    public static void main(String[] args) {
        int[] list = new int[]{
                1,2,3,4,5,6
        };
        int current = 0;
        System.out.println(list[current++]);//先输出list[current]后，current再自加1
        System.out.println(current);
    }
}
