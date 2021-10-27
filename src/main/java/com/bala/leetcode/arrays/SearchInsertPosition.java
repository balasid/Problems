package com.bala.leetcode.arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int searchInsert = searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 0);
        System.out.println(searchInsert);
    }

    public int searchInsert(int[] nums, int target) {
        int startIndex = 0, endIndex = nums.length - 1;
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                startIndex = mid + 1;
            } else {
                endIndex = mid - 1;
            }
        }
        return endIndex + 1;
    }
}
