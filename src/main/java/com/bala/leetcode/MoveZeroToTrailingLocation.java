package com.bala.leetcode;

import java.util.Arrays;

public class MoveZeroToTrailingLocation {
    public static void main(String[] args) {
        int a[] = {1, 0, 3, 4, 0, 0, 5, 0};
        System.out.println(Arrays.toString(a));
        int currentIndex = 0;
        for (int i = 0; i < a.length; i++) {
            int currentElm = a[i];
            if (currentElm != 0) {
                a[currentIndex++] = a[i];
            }
        }
        for (int i = currentIndex; i < a.length; i++) {
            a[i] = 0;
        }
        System.out.println(Arrays.toString(a));
    }
}
