package com.bala.paypal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StringPermutation {
    public static void main(String[] args) {
        String perm = "he";
        computePermutations("", perm);
    }

    private static void computePermutations(String subString, String remainingStr) {
        if (remainingStr.length() == 0) {
            System.out.println(subString);
        }
        for (int i = 0; i < remainingStr.length(); i++) {
            String permStr = subString + remainingStr.charAt(i);
            String newRemainStr = remainingStr.substring(0, i) + remainingStr.substring(i + 1);
//            System.out.println("New Remaining : "+newRemainStr);
            computePermutations(permStr, newRemainStr);
        }
    }


    static class Graph {
        Map<Character, List<Character>> vertex = new HashMap<>();

        public void addEdge(Character source, Character destination) {
            vertex.computeIfAbsent(source, k -> new LinkedList<>()).add(destination);
        }
    }
}
