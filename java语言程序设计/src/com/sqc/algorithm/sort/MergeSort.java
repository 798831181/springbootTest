package com.sqc.algorithm.sort;

public class MergeSort{
    public static void mergeSort(int[] list){
        if (list.length > 1){
            //mergeSort
            int[] firstHalf = new int[list.length / 2];
            //copy array
            System.arraycopy(list,0,firstHalf,0,list.length/2);
            mergeSort(firstHalf);

            //second half
            int secHalfLen = list.length - list.length/2;
            int[] secondHalf = new int[secHalfLen];
            //copy array
            System.arraycopy(list,list.length/2,secondHalf,0,secHalfLen);
            mergeSort(secondHalf);

            merge(firstHalf,secondHalf,list);

        }

    }

    private static void merge(int[] firstHalf, int[] secondHalf, int[] temp) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;
        while(current1 < firstHalf.length && current2 < secondHalf.length){
            if (firstHalf[current1] < secondHalf[current2]){
                temp[current3++] = firstHalf[current1++];
            }else{
                temp[current3++] = secondHalf[current2++];
            }
        }
        while (current1 < firstHalf.length){
            temp[current3++] = firstHalf[current1++];
        }
        while (current2 < secondHalf.length){
            temp[current3++] = secondHalf[current2++];
        }
    }

    public static void main(String[] args) {
        int[] list = {1,2,4,2,1,4,5,6,32,2,1,9};
        mergeSort(list);
        for (int i = 0; i < list.length;i++){
            System.out.print(list[i] + " ");
        }
    }
}
