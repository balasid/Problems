package com.bala.leetcode;

import java.util.Arrays;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 * <p>
 * Input: s = "A", numRows = 1
 * Output: "A"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(new ZigZagConversion().convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        String[] str = new String[numRows];
        Arrays.fill(str, "");
        int row = 0;
        boolean isMoveDown = true;
        for (int i = 0; i < s.length(); i++) {
            str[row] += s.charAt(i);
            if (row == numRows - 1) {
                isMoveDown = false;
            } else if (row == 0) {
                isMoveDown = true;
            }
            if (isMoveDown) {
                row++;
            } else {
                row--;
            }
            if (row < 0) {
                row = 0;
            }
        }
//        System.out.println(Arrays.toString(str));
        return String.join("", str);
    }
}

class a {

}
