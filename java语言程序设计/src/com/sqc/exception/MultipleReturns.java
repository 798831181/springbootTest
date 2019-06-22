package com.sqc.exception;

public class MultipleReturns {
    public static int f(int i){
        try {
            if (i == 0){
                return i;
            }
        } finally {

            return 100;
        }
    }
    public static void main(String[] args) {
        for(int i = 0; i < 4; i++ ){
            System.out.println(f(i));
        }
    }
}
