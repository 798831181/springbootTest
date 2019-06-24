package array;

/**
 * 使用copyarray方法复制数组
 */
public class CopyArray {
    public static void main(String[] args) {
        int[] a = {3,4,5};
        int[] b = new int[3];
        System.arraycopy(a,0, b, 0,3 );
        for(int i = 0; i < b.length; i++){
            System.out.println(b[i]);
        }
    }
}
