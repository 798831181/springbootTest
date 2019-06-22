package com.sqc.algorithm.sort;

/**
 * 快速排序【复杂度为O(n)】
 */
public class QuickSort {
    public static void quickSort(int[] list,int first, int last){

        if (last > first){
            int pivotIndex = partition(list,first,last);
            quickSort(list,first,pivotIndex - 1);
            quickSort(list,pivotIndex + 1,last);
        }
    }
    public static int partition(int[] list, int first, int last){
        int pivot = list[first];
        int low = first + 1;
        int high = last;
        while(high > low){
            while (low <= high && list[low] < pivot){
                low++;
            }
            while (low <= high && list[high] > pivot){
                high--;
            }
            //swap two element in the list
            if (high > low){
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        while(high > first && list[high] > pivot){
            high--;
        }
        if (pivot > list[high]){
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }else {
            return first;
        }
    }
    //test
    public static void main(String[] args) {
        int[] list = {
                5,2,9,3,8,4,0,1,6,7
        };
        quickSort(list,0,list.length-1);
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
    }
}
