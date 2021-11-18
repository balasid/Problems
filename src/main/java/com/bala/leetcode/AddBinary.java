package com.bala.leetcode;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        int sum = 0, carry = 0;
        String toReturn = "";
        int aLength = a.length();
        int bLength = b.length();
        int maxLength = Math.max(aLength, bLength);
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        for (int i = 0 ; i <maxLength; i++) {
            sum = carry;
            if (aLength > i) {
                sum += Integer.parseInt(String.valueOf(a.charAt(i)));
            }
            if (bLength > i) {
                sum += Integer.parseInt(String.valueOf(b.charAt(i)));
            }
            if (sum == 0) {
                carry = 0;
                toReturn = "0" + toReturn;
            } else if (sum == 1) {
                carry = 0;
                toReturn = "1" + toReturn;
            } else if (sum == 2) {
                carry = 1;
                toReturn = "0" + toReturn;
            } else if (sum == 3) {
                carry = 1;
                toReturn = "1" + toReturn;
            }
        }
        if (carry == 1) {
            toReturn = "1" + toReturn;
        }
        return toReturn;
    }
}
