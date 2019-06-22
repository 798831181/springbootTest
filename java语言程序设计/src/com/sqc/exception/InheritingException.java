package com.sqc.exception;

/**
 * 自定义的异常
 */
class SimpleException extends Exception{

}


public class InheritingException {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {

        InheritingException inheritingException = new InheritingException();
        try {
            inheritingException.f();
        } catch (SimpleException e) {
            System.out.println("Caught it");
        }
    }
}
