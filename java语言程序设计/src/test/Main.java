package test;

import java.util.ArrayList;
import java.util.List;




public class Main {

    private static String string = "a b 23";

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
            char[] line = string.toCharArray();
            List<Integer> replaceIndex = new ArrayList<>();
            List<Character> allLetters = new ArrayList<>();
            for (int i = 0; i < line.length; i++)
                if (Character.isLetter(line[i]))
                    replaceIndex.add(i);
            for (int i = 0; i < 26; i++) {
                char pattern = (char) ('a' + i);
                for (int j = 0; j < line.length; j++) {
                    if (Character.isLetter(line[j]) && Character.toLowerCase(line[j]) == pattern)
                        allLetters.add(line[j]);
                }
            }
            for (int i = 0; i < replaceIndex.size(); i++) {
                int index = replaceIndex.get(i);
                line[index] = allLetters.get(i);
            }
            for (char c : line)
                System.out.print(c);
            System.out.println();
        }
//        scanner.close();
//    }
}