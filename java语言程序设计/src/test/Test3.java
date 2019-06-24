package test;

public class Test3 {
    public static void reOrderArray(int [] array) {
        int[] array2 = new int[countNum(array)];//存放偶数
        int[] array1 = new int[array.length - countNum(array)];//存放奇数
        int j = 0;
        int k = 0;




        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 != 0){
                array1[j++] = array[i];
            }else{
                array2[k++] = array[i];
            }
        }
        for(int i = 0; i < array1.length; i++){
            array[i] = array1[i];

        }
        for(int i = 0; i < array2.length; i++){
            array[i + array1.length] = array2[i];
        }
    }
    public static int countNum(int[] array){
        int count  = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {1,4,3,6};
        reOrderArray(array);

    }
}
