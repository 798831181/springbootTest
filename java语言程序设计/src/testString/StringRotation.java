package testString;

import java.util.Scanner;

public class StringRotation {
    public String rotateString(String A, int n, int p) {
        // write code here
        if (A == null)
            return null;
        //字符串的右半部分
        String strRight = A.substring(p +  1);
//        字符串的左半部分
        String strLeft =  A.substring(0,p + 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = p; i >= 0; i--){
            stringBuilder.append(strLeft.charAt(i));
        }
        return  strRight + stringBuilder.toString();
    }

    public static void main(String[] args) {
        StringRotation stringRotation = new StringRotation();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String string = scanner.nextLine();
            String str = stringRotation.rotateString(string,8,5);
            System.out.println(str);

        }
    }
}