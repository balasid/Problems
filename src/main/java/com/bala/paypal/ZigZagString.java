package com.bala.paypal;

import java.util.Arrays;

public class ZigZagString {
    public static void main(String[] args) {
        String str = "GEEKSFORGEEKS";
        int n = 3;
        System.out.println(computeZigZag(str, n));
    }

    private static String computeZigZag(String str, int n) {
        char[] chars = str.toCharArray();
        String[] strings = new String[n];
        Arrays.fill(strings, "");
        int row = 0;
        boolean down = true;
        for (int i = 0; i < chars.length; i++) {
            strings[row] += chars[i];
            if (row == (n - 1)) {
                down = false;
            } else if (row == 0) {
                down = true;
            }
            if (down) {
                row++;
            } else {
                row--;
            }
            System.out.println(Arrays.toString(strings));
        }
        return String.join("", strings);
    }
}
