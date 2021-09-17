package com.bala.tryout;

public class ReturnInTryAndFinal {
    public static void main(String[] args) {
        System.out.println(main2());
    }

    public static String main2() {
        try {
            System.out.println("HelloWorld");
            return "Hello";
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            System.out.println("From final");
            return "helloWorld";
        }
    }
}
