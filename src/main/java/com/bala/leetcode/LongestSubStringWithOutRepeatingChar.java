package com.bala.leetcode;

import java.util.HashMap;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 * <p>
 * Input: s = ""
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubStringWithOutRepeatingChar {
    public static void main(String[] args) {
        int length = new LongestSubStringWithOutRepeatingChar().lengthOfLongestSubstring("abcabcd");
        System.out.println(length);
    }

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        HashMap<Character, Integer> position = new HashMap<>();
        int start = 0;
        int st = 0;
        int maxlen = 0;
        int currntLen = 0;
        int i = 0;
        position.put(s.charAt(0), 0);
        for (i = 1; i < length; i++) {
            char key = s.charAt(i);
            Integer previousPosition = position.get(key);
            if (previousPosition == null) {
                position.put(key, i);
            } else {
                if (previousPosition >= st) {
                    currntLen = i - st;
                    if (maxlen < currntLen) {
                        maxlen = currntLen;
                        start = st;
                    }
                    st = previousPosition + 1;
                }
                position.replace(key, i);
            }
        }
        if (maxlen < (i - st)) {
            start = st;
            maxlen = i - st;
        }
        System.out.println(maxlen);
        System.out.println(start);
        String substring = s.substring(start, start + maxlen);
        System.out.println(substring);
        return substring.length();
    }
}
