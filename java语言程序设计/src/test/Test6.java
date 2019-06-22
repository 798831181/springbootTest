package test;

public class Test6 {
    public void swapWithZero(int[] array, int len, int n){
        int temp1 = 0;
        int temp2 = 0;
        for(int i = 0; i < len; i++){
            if(array[i] == n){
               temp1 = i;
            }
            if (array[i] == 0){
               temp2 = i;
            }
        }
        int temp = array[temp1];
        array[temp1] = array[temp2];
        array[temp2] = temp;
    }
    public void sort(int[] array, int len){
        for (int i = 0; i < len; i++){
            if (array[i] == 0){
                swapWithZero(array,len,array[0]);
            }
        }
        for (int i = 1; i < len; i++){
            for (int j = 1; j < len - i; j++){
                if (array[j] > array[j + 1]){
                    swapWithZero(array,len,array[j]);
                    swapWithZero(array,len,array[j + 1]);
                    swapWithZero(array,len, array[0]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Test6 test6 = new Test6();
        int[] a = {1, 4, 2, 3, 0};
        test6.sort(a, 5);
        for (int i = 0; i < 5; i++){
            System.out.println(a[i]);
        }

    }

}
