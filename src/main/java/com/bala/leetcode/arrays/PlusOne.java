package com.bala.leetcode.arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class PlusOne {
    public static void main(String[] args) {
        int[] plusOne = new PlusOne().plusOne(new int[]{1, 9, 3});
        System.out.println(Arrays.toString(plusOne));
    }

    public int[] plusOne1(int[] digits) {
        LinkedList<Integer> integers = new LinkedList<>();
        int previousQuotient = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (i == digits.length - 1)
                digit += 1;
            digit += previousQuotient;
            int currentQuo = 0;
            if (digit > 9) {
                currentQuo = digit / 10;
                digit = digit % 10;
            }
            integers.addFirst(digit);
            previousQuotient = currentQuo;
        }
        if (previousQuotient != 0) {
            integers.addFirst(previousQuotient);
        }
//        System.out.println(integers);
        return integers.stream().mapToInt(i -> i).toArray();
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}
