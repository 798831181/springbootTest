package test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            char[] c = scanner.next().toCharArray();
            StringBuffer stringBuffer = new StringBuffer();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < c.length; i++){
                if (set.add(c[i])){
                    stringBuffer.append(c[i]);
                }
            }
            System.out.println(stringBuffer.toString());
        }
    }
}
