package com.bala.leetcode;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x
 * causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * Example 1:
 * <p>
 * Input: x = 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: x = -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: x = 120
 * Output: 21
 * Example 4:
 * <p>
 * Input: x = 0
 * Output: 0
 * <p>
 * Constraints:
 * <p>
 * <html>-2<sup>31</sup> <= x <= 2<sup>31</sup>-1</html>
 * <p>
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(1534236469));
    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int reverse = 0;
        while (x != 0) {
            int remain = x % 10;
            x = x / 10;
            try {
                reverse = Math.multiplyExact(reverse, 10) + remain;
            } catch (Exception exception) {
                return 0;
            }
        }
        double pow = Math.pow(2, 31);
        System.out.println(pow);
        if (!((-(pow) <= x) && x <= (pow - 1))) {
            return 0;
        }
        return reverse;
    }

}
