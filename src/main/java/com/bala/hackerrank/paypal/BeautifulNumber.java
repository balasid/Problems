package com.bala.hackerrank.paypal;

import java.util.HashSet;

public class BeautifulNumber {

    private static HashSet<Long> beautifulNum = new HashSet<>();

    public static void main(String[] args) {
        int l = 257, r = 1113; //output = 79702
//        int l = 7, r = 7;
        long out_ = solve(l, r);
        System.out.println("Beautiful Number between " + l + " & " + r + " is " + out_);
    }

    static long solve(int l, int r) {
        long beautifyNumber = 0;
        for (int i = l; i <= r; i++) {
            HashSet<Long> subSet = new HashSet<>();
            int i1 = squareAndAdd(i, subSet);
            if (i1 == 1 || i1 == 7) {
                beautifulNum.addAll(subSet);
                beautifyNumber += i;
            }
        }
        return beautifyNumber;

    }

    private static int squareAndAdd(int num, HashSet<Long> subSet) {
        subSet.add((long) num);
        if (beautifulNum.contains(num)) {
            return 1;
        }
        int sum = 0;
        while (num > 0) {
            int i = num % 10;
            sum += (i * i);
            num = num / 10;
        }
        System.out.println("sum is "+sum);
        while (sum > 9) {
            sum = squareAndAdd(sum, subSet);
        }
        return sum;
    }
}
