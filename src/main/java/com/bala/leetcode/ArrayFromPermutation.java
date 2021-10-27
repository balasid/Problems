package com.bala.leetcode;

import java.util.Arrays;

public class ArrayFromPermutation {
    public static void main(String[] args) {
        int[] ints = new ArrayFromPermutation().buildArray(new int[]{0, 2, 1, 5, 3, 4});
        System.out.println(Arrays.toString(ints));
    }

    public int[] buildArray(int[] nums) {
        int[] ints = new int[nums.length];
        for (int j = 0, i = 0; j < nums.length; j++, i++) {
            ints[j] = nums[nums[i]];
        }
        return ints;
    }
}
