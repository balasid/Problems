package com.bala.algoexpect;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Write a function that takes in a non-empty array of distinct integers and an
 * integer representing a target sum. If any two numbers in the input array sum
 * up to the target sum, the function should return them in an array, in any
 * order. If no two numbers sum up to the target sum, the function should return
 * an empty array.
 * <p>
 * Note that the target sum has to be obtained by summing two different integers
 * in the array; you can't add a single integer to itself in order to obtain the
 * target sum.
 * <p>
 * You can assume that there will be at most one pair of numbers summing up to
 * the target sum.
 * <p>
 * Sample Input
 * array = [3, 5, -4, 8, 11, 1, -1, 6]
 * targetSum = 10
 * <p>
 * Sample Output
 * [-1, 11]
 */
public class TwoNumberSum {
    public static void main(String[] args) {
        int[] ints = twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(Arrays.toString(ints));
    }

    /*
    Solution 0 - Brute Force
     */
    static int[] twoNumberSum0(int[] num, int sum) {
        for (int i = 0; i < num.length; i++) {
            for (int i1 = 0; i1 < num.length; i1++) {
                if (num[i] != num[i1]) {
                    if (num[i] + num[i1] == sum) {
                        return new int[]{num[i], num[i1]};
                    }
                }
            }
        }
        return new int[]{};
    }

    /*
    Solution 1 - Brute Force
     */
    static int[] twoNumberSum1(int[] num, int sum) {
        for (int i = 0; i < num.length; i++) {
            int y = sum - num[i];
            for (int j = 0; j < num.length; j++) {
                if (y == num[j] && num[i] != num[j]) {
                    return new int[]{num[i], num[j]};
                }
            }
        }
        return new int[]{};
    }

    /*
    Solution 2 - Brute Force
     */
    static int[] twoNumberSum(int[] num, int sum) {
        HashMap<Integer, Integer> diffMap = new HashMap<>();
        final int[][] a = new int[1][1];
        for (int i = 0; i < num.length; i++) {
            int currentElm = num[i];
            int y = sum - currentElm;
            Integer integer = diffMap.get(currentElm);
            if (integer != null) {
                return new int[]{integer, currentElm};
            }
            diffMap.put(y, currentElm);
        }
        return new int[]{};
    }
}
