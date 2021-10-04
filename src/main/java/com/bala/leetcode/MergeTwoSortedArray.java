package com.bala.leetcode;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 7, 0, 0};
        int[] arr = Arrays.copyOf(nums1, nums1.length);
        int nums2[] = {2, 5, 6};
        int m = 4;
        int n = 3;
        int mergeArr[] = new int[m + n];
        int i = 0;
        int currentM = 0;
        int currentN = 0;
        while (i < m + n) {
            if (currentN == n) {
                mergeArr[i] = nums1[currentM];
                currentM++;
            } else if (currentM == m) {
                mergeArr[i] = nums2[currentN];
                currentN++;
            } else if (nums1[currentM] < nums2[currentN]) {
                mergeArr[i] = nums1[currentM];
                currentM++;
            } else {
                mergeArr[i] = nums2[currentN];
                currentN++;
            }
            i++;
        }
        System.out.print("[");
        for (int j = 0; j < mergeArr.length; j++) {
            System.out.print(mergeArr[j] + "" + (j < mergeArr.length - 1 ? "," : ""));
        }
        System.out.print("]");
//        System.out.println(Arrays.toString(mergeArr));
    }
}
