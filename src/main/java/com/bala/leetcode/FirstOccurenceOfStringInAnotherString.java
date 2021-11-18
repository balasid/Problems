package com.bala.leetcode;

public class FirstOccurenceOfStringInAnotherString {
    public static void main(String[] args) {
        FirstOccurenceOfStringInAnotherString firstOccurenceOfStringInAnotherString = new FirstOccurenceOfStringInAnotherString();
        System.out.println(firstOccurenceOfStringInAnotherString.strStr("abcadf", "cab"));
        System.out.println(firstOccurenceOfStringInAnotherString.strStr("mississippi", "issipi"));
    }

    /**
     * Another solution but time exceed.
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        int firstFoundIndex = -1;
        if (needle.length() > haystack.length()) {
            return firstFoundIndex;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        char c = needle.charAt(0);
        boolean isMatched = false;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == c) {
                firstFoundIndex = i;
                isMatched = true;
                for (int j = 1; j < needle.length(); j++) {
                    if ((haystack.length() - (i + j) - 1) < 0) {
                        isMatched = false;
                        break;
                    }
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        isMatched = false;
                        break;
                    }
                }
                if (isMatched) {
                    break;
                }
            }
        }
        if (!isMatched) {
            firstFoundIndex = -1;
        }

        return firstFoundIndex;
    }

    public int strStr(String haystack, String needle) {
        int firstFoundIndex = -1;
        if (needle.length() > haystack.length()) {
            return firstFoundIndex;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        char c = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == c) {
                if (haystack.startsWith(needle, i)) {
                    firstFoundIndex = i;
                    break;
                }
            }
        }
        return firstFoundIndex;
    }
}

