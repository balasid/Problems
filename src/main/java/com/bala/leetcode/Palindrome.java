package com.bala.leetcode;

/**
 * Given an integer x, return true if x is palindrome integer.
 * <p>
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 121
 * Output: true
 * Example 2:
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Example 4:
 * <p>
 * Input: x = -101
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <html>-2<sup>31</sup> <= x <= 2<sup>31</sup>-1</html>
 * <p>
 * <p>
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int rev = 0;
        while (temp != 0) {
            int rem = temp % 10;
            temp = temp / 10;
            rev = rev * 10 + rem;
        }
        System.out.println(rev);
        if (x == rev) {
            return true;
        }
        return false;
    }
}
