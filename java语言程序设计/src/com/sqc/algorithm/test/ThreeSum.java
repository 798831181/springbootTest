package com.sqc.algorithm.test;

/**
 * 查找三个元素，相加等于指定数
 */
public class ThreeSum {
    public static int[] f1(int[] arr, int target){
        int[] result = new int[3];
        for (int i = 0; i < arr.length - 2; i++){
            result[0] = arr[i];
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right){
                if (arr[i] + arr[left] + arr[right] == target) {
                     result[1] = arr[left];
                     result[2] = arr[right];
                     return result;
                }else if ((arr[i] + arr[left] + arr[right]) < target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] ints = {5,1,0,-1,-2,-4};
        int[] result = f1(ints, 2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
