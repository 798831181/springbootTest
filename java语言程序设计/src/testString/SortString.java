package testString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            string = sort(string);
            System.out.println(string);
        }
    }

    private static String sort(String string) {
        char[] chars = string.toCharArray();
        //存放字母的Index
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                indexList.add(i);
            }
        }
        //存放排序后的字符
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char patten = (char) ('a' + i);
            for (int j = 0; j < chars.length; j++) {
                if (Character.isLetter(chars[j]) && Character.toLowerCase(chars[j]) == patten) {
                    charList.add(chars[j]);
                }
            }
        }
        for (int i = 0; i < indexList.size(); i++) {
            int index = indexList.get(i);
            chars[index] = charList.get(i);
        }

        String str = String.valueOf(chars);
        return str;
    }
}

