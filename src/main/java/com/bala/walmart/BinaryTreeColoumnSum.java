package com.bala.walmart;

import com.bala.paypal.Tree;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class BinaryTreeColoumnSum {
    public static void main(String[] args) {
        Tree elm = new Tree(1);
        elm.left = new Tree(2);
        elm.left.left = new Tree(4);
        elm.left.right = new Tree(5);
        elm.right = new Tree(3);
        elm.right.left = new Tree(6);
        elm.right.right = new Tree(7);
        Map<Integer, Integer> columSumMap = new TreeMap<>();
        columSumMap.put(0, elm.data);
        computeColumnSum(elm, columSumMap, 0);
        Set<Map.Entry<Integer, Integer>> entries = columSumMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println(entry.getValue());
        }
    }

    private static void computeColumnSum(Tree elm, Map<Integer, Integer> columSumMap, int currentColumnIndex) {
        if (elm == null) {
            return;
        }
        computeColumnSum(elm.left, columSumMap, currentColumnIndex - 1);
        Integer integer = columSumMap.get(currentColumnIndex);
        int count = elm.data;
        if (integer == null) {
            integer = count;
        } else {
            integer += count;
        }
        columSumMap.put(currentColumnIndex, integer);
        computeColumnSum(elm.right, columSumMap, currentColumnIndex + 1);
    }
}

