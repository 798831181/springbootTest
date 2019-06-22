package xiaozhao2018;

import java.util.Scanner;

public class ZuiDaChengJi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++){
            array[i] = scanner.nextLong();
        }
        long res = getMaxNum(array);
        System.out.println(res);
    }
    public static long getMaxNum(long[] array){
        long max1 = 0, max2 = 0, max3 = 0, min1 = 0, min2 = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == 0){
                continue;
            }
            if (array[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = array[i];
            }else if (array[i] > max2){
                max3 = max2;
                max2 = array[i];
            }else if (array[i] > max3){
                max3 = array[i];
            }else if (array[i] < min1){
                min2 = min1;
                min1 = array[i];
            }else if (array[i] > min1 && array[i] < min2){
                min2  = array[i];
            }

        }
        return (Math.max(max1 * max2 * max3, min1 * min2 * max1));

    }


}
