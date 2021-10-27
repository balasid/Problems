package com.bala.leetcode.arrays;

public class RemoveElements {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 2, 3};
        int val = 3;
        System.out.println(new RemoveElements().removeElement(arr, val));
    }

    public int removeElement(int[] nums, int val) {
        int currentIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentData = nums[i];
            if (currentData != val) {
                nums[currentIndex++] = currentData;
            }
        }
        return currentIndex;
    }
}
