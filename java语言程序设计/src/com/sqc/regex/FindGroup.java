package com.sqc.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindGroup {
    public static void main(String[] args) {
        String s = "电话113900001111" + "电话213500008888" + "电话315099992222";
        Pattern pattern = Pattern.compile("(13\\d)\\d{8}|(15\\d)\\d{8}");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
