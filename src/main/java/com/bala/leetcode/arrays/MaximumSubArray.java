package com.bala.leetcode.arrays;

public class MaximumSubArray {
    public static void main(String[] args) {
        int maxSubArray = new MaximumSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(maxSubArray);
    }

    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxCurrElm = 0;
        for (int i = 0; i < nums.length; i++) {
            maxCurrElm += nums[i];
            if (maxSoFar < maxCurrElm) {
                maxSoFar = maxCurrElm;
            }
            if (maxCurrElm < 0) {
                maxCurrElm = 0;
            }
        }
        return maxSoFar;
    }
}
