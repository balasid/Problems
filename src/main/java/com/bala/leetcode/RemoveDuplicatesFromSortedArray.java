package com.bala.leetcode;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 0) {
            return 0;
        }
        int currentIndex = 0;
        int currentData = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > currentData) {
                nums[++currentIndex] = nums[i];
                currentData = nums[i];
            }
        }
        return currentIndex+1;
    }
}
