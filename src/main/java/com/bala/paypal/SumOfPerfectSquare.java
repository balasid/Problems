package com.bala.paypal;

public class SumOfPerfectSquare {//TODO
    public static void main(String[] args) {
        int[] elem = new int[]{2, 3, 4, 9, 10};
        for (int i = 0; i < elem.length; i++) {
            double sqrt = Math.sqrt(elem[i]);
            double floor = Math.floor(sqrt);
            double ceil = Math.ceil(sqrt);
            System.out.println("Sqrt " + sqrt);
            System.out.println("Floor " + floor);
            System.out.println("ceil " + ceil);
        }
    }
}