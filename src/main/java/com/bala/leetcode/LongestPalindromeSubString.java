package com.bala.leetcode;

public class LongestPalindromeSubString {
    public static void main(String[] args) {
        String babad = new LongestPalindromeSubString().longestPalindrome("cbbd");
        System.out.println(babad);
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        String longestPal = "";
        for (int i = 0; i < length; i++) {
            String subString = computeLongestPalindrome(i, i, s);
            if (subString.length() > longestPal.length()) {
                longestPal = subString;
            }
            subString = computeLongestPalindrome(i, i + 1, s);
            if (subString.length() > longestPal.length()) {
                longestPal = subString;
            }
        }
        return longestPal;
    }

    private String computeLongestPalindrome(int low, int high, String string) {
        String longestSubPalin = "";
        while (low >= 0 && high < string.length() && string.charAt(low) == string.charAt(high)) {
            String substring = string.substring(low, high + 1);
//            System.out.println(substring);
            if (!substring.isEmpty() && substring.length() > longestSubPalin.length()) {
                longestSubPalin = substring;
            }
            low--;
            high++;
        }
        return longestSubPalin;

    }
}
