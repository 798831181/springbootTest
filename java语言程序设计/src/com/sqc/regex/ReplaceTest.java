package com.sqc.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTest {

    public static void main(String[] args) {
        String[] msgs = {
                "Java has regular expression in 1.4",
                "regular expression now expressing in Java",
                "Java represses oracular expressions"
        };
        Pattern pattern = Pattern.compile("re\\w*");
        Matcher matcher = null;
        for(int i = 0; i < msgs.length; i++){
            if (matcher == null){
                matcher = pattern.matcher(msgs[i]);
            }else {
                matcher.reset(msgs[i]);
            }
//            matcher = pattern.matcher(msgs[i]);

            while (matcher.find()){
                System.out.println(matcher.group());
            }
            System.out.println(matcher.replaceAll("哈哈"));
        }
        System.out.println("----------------------------");
        for (String string : msgs){
            System.out.println(string.replaceFirst("re\\w*","哈哈"));
            System.out.println(Arrays.toString(string.split(" ")));
        }
    }
}
