package com.bala.hackerrank.paypal;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class BeautifulNumber {

    private static HashSet<Long> beautifulNum = new HashSet<>();

    public static void main(String[] args) {
        int l = 257, r = 1113; //output = 79702
//        int l = 7, r = 7;
        long out_ = solve(l, r);
        System.out.println("Beautiful Number between " + l + " & " + r + " is " + out_);
    }

    static long solve(int l, int r) {
        AtomicLong beautifyNumber = new AtomicLong();
        IntStream.rangeClosed(l, r).forEach(value -> {
            HashSet<Long> subSet = new HashSet<>();
            int i1 = squareAndAdd(value, subSet);
            if (i1 == 1 || i1 == 7) {
//                beautifulNum.addAll(subSet);
                beautifyNumber.addAndGet(value);
            }
        });
        return beautifyNumber.get();

    }

    private static int squareAndAdd(int num, HashSet<Long> subSet) {
        subSet.add((long) num);
       /* if (beautifulNum.contains(num)) {
            return 1;
        }*/
        int sum = String.valueOf(num)
                .chars()
                .map(operand -> {
                    //  System.out.println(Character.getNumericValue(operand));
                    int numericValue = Character.getNumericValue(operand);
                    return numericValue * numericValue;
                })
                .sum();
//        System.out.println("sum is " + sum);
        while (sum > 9) {
            sum = squareAndAdd(sum, subSet);
        }
        return sum;
    }
}
