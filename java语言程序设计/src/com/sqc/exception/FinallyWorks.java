package com.sqc.exception;

class ThreeException extends Exception{

}

/**
 * 测试finally总是会执行。
 */
public class FinallyWorks {
    private static int count = 0;

    public static void main(String[] args) {
        while (true){
            try {
                if (count++ == 0){
                    throw new ThreeException();
                }
                System.out.println("NoException");
            } catch (ThreeException e) {
                System.out.println("ThreeException");
            } finally {
                System.out.println("In Finally Clause");
                if (count == 2){
                    break;
                }
            }

        }
    }
}
