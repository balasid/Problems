package com.bala.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        List<Integer> oldList = null;
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(0, 1);
            if(i>0)
                integers.add(1);
            for (int j = 1; j <= i-1; j++) {
                integers.add(j, oldList.get(j-1) + oldList.get(j));
            }
            lists.add(integers);
            oldList = integers;
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle().generate(5));
    }
}
