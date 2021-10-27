package com.bala.paypal;

public class MinimumDistanceBetweenTwo {
    public static void main(String[] args) {
        int a[] = {4, 2, 3, 1, 4, 3, 6, 5, 7, 6, 7, 8};
        int x = 3, y = 4;
        int p = -1, minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x || a[i] == y) {
                if (p != -1 && a[i] != a[p]) {
                    int distance = i - p;
//                    System.out.println("index of p & i " + p + " " + i);
                    minDistance = Math.min(minDistance, distance);
                }
                p = i;
            }
        }
        System.out.println(minDistance);
    }
}
