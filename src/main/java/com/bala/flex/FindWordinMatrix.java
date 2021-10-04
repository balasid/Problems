package com.bala.flex;

/**
 * You are given a 2D array of characters, and a target string. Return whether or not the word target word exists in the matrix.
 * Unlike a standard word search, the word must be either going left-to-right, or top-to-bottom in the matrix.
 * <p>
 * Example:
 * [['F', 'A', 'C', 'I'],
 * ['O', 'B', 'Q', 'P'],
 * ['A', 'N', 'O', 'B'],
 * ['M', 'A', 'S', 'S']]
 * <p>
 * Given this matrix, and the target word FOAM, you should return true, as it can be found going up-to-down in the first column.
 */
public class FindWordinMatrix {
    public static void main(String[] args) {
        char[][] matrix = {{'F', 'A', 'F', 'I'},
                {'O', 'B', 'O', 'P'},
                {'C', 'N', 'A', 'B'},
                {'M', 'A', 'M', 'S'}};
        String word = "FOAM";
        int m = 4, n = 4;
        boolean isFound = wordSearch(matrix, word, m, n);
        System.out.println(isFound ? "Found" : "Not Found");
    }

    private static boolean wordSearch(char[][] matrix, String word, int m, int n) {
        int k = 0;
        char[] chars = word.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == chars[j] || matrix[j][k] == chars[j]) {
                    if (j == chars.length - 1) {
                        return true;
                    }
                } else {
                    break;
                }
            }
            k++;
        }
        return false;
    }
}
