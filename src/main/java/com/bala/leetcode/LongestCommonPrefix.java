package com.bala.leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{""}));
    }

    private String longestCommonPrefix(String[] strs) {
        int itemsLength = strs.length;
        if (itemsLength <= 0) {
            return "";
        }
        int index = 0;
        int arrayIndex = 0;
        String toReturn = "";
        String currentChar = "";
        while (true) {
            String item = strs[arrayIndex];
            if (item.length() <= index) {
                return toReturn;
            }
            if (arrayIndex == 0) {
                currentChar = String.valueOf(item.charAt(index));
            }
            if (!currentChar.equals(String.valueOf(item.charAt(index)))) {
                return toReturn;
            }
            if (arrayIndex == (itemsLength - 1)) {
                arrayIndex = 0;
                toReturn += currentChar;
                index++;
            } else {
                arrayIndex++;
            }
        }
    }

    public String longestCommonPrefix1(String[] strs) {
        int length = strs.length;
        if (length <= 0) {
            return "";
        }
        StringBuilder toReturn = new StringBuilder();
        String currentChar = "";
        int index = 0;
        int i = 0;
        for (i = 0; i < length; i++) {
            String str = strs[i];
            if (str.length() > 0 && i == 0) {
                currentChar = String.valueOf(str.charAt(index));
            }
            if (!str.isEmpty()) {
                if (str.length() <= index) {
                    break;
                }
                String currentChar1 = String.valueOf(str.charAt(index));
                if (!currentChar.equals(currentChar1)) {
                    break;
                }
            } else {
                break;
            }
            if (i == length - 1) {
                i = -1;
                index++;
                toReturn.append(currentChar);
            }
        }
        return toReturn.toString();
    }
}
