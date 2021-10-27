package com.bala.hackerrank.paypal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class BeautifulNumber {

    static Map<Integer, Integer> beautifulNum = new HashMap<>();

    public static void main(String[] args) {
        int l = 257, r = 1113; //output = 79702
//        int l = 7, r = 7;
        long out_ = solve(l, r);
        System.out.println("Beautiful Number between " + l + " & " + r + " is " + out_);
    }

    private static int squareAndAdd(int num) {
        int sum = 0;
        Integer integer = beautifulNum.get(num);
        if (integer != null) {
            return integer;
        }
        while (num > 0) {
            int i = num % 10;
            sum += (i * i);
            num = num / 10;
        }
        while (sum > 9) {
            sum = squareAndAdd(sum);
        }
        return sum;
    }

    static long solve(int l, int r) {
        AtomicLong beautifyNumber = new AtomicLong();
        IntStream.rangeClosed(l, r).parallel().forEach(value -> {
//            System.out.println("Start " + System.currentTimeMillis());
            int i1 = squareAndAdd(value);
//            System.out.println("End " + System.currentTimeMillis());
            if (i1 == 1 || i1 == 7) {
                beautifyNumber.addAndGet(value);
            }
            beautifulNum.put(value, i1);
        });
        return beautifyNumber.get();

    }

    private static int squareAndAdd1(int num) {
        int sum = String.valueOf(num)
                .chars()
                .map(operand -> {
                    int numericValue = Character.getNumericValue(operand);
                    return numericValue * numericValue;
                })
                .sum();
        while (sum > 9) {
            sum = squareAndAdd(sum);
        }
        return sum;
    }
}
