package com.sqc.algorithm.sort;

/**
 * 插入排序
 */
public class InsertionSort {
    /**
     * 插排过程
     * @param list
     */
    public static void insertionSort(int[] list){
        for(int i = 1; i < list.length; i++){
            int currentElement = list[i];
            int k ;
            for (k = i -1; k >= 0 && list[k] > currentElement; k-- ){
                list[k + 1] = list[k];
            }
            list[k+1] = currentElement;
        }
    }

    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        int[] list = new int[]{1, 3, 4 ,5,2,1,3,9,4 };
        insertionSort(list);
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i]);
        }
     }
}
