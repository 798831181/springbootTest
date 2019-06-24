package com.sqc.exception;

public class Whocalles {
    static void f(){
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()){
                System.out.println(stackTraceElement.getMethodName());
            }
        }
    }
    static void g(){
        f();
    }
    static void h(){
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("----------------");
        g();
        System.out.println("---------------");
        h();
    }
}
