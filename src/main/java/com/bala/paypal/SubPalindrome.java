package com.bala.paypal;

import java.util.*;

public class SubPalindrome {
    static List<String> combinations = new ArrayList<>();

    public static void main(String[] args) {
        String palWord = "madam";
        Set<String> palindrome = computePalindrome(palWord);
        System.out.println(palindrome.size());
        System.out.println(palindrome);
    }

    private static Set<String> computePalindrome(String palWord) {
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < palWord.length(); i++) {
            computePalindrome(palWord, i, i, set);
            computePalindrome(palWord, i, i + 1, set);
        }
//        System.out.println(set);
        return set;
    }

    private static void computePalindrome(String palWord, int low, int high, Set<String> set) {
        while (low >= 0 && high < palWord.length() && palWord.charAt(low) == palWord.charAt(high)) {
            String substring = palWord.substring(low, high + 1);
            System.out.println(substring);
            set.add(substring);
            low--;
            high++;
        }
    }
}
