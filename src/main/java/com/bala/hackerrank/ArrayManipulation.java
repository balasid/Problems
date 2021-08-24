package com.bala.hackerrank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayManipulation {

    public static void main(String[] args) {
        List<List<Integer>> queries = new LinkedList<>();
        queries.add(Arrays.stream(new Integer[]{1, 2, 100}).collect(Collectors.toList()));
        queries.add(Arrays.stream(new Integer[]{2, 5, 100}).collect(Collectors.toList()));
        queries.add(Arrays.stream(new Integer[]{3, 4, 100}).collect(Collectors.toList()));
       /* queries.add(Arrays.stream(new Integer[]{2, 6, 8}).collect(Collectors.toList()));
        queries.add(Arrays.stream(new Integer[]{3, 5, 7}).collect(Collectors.toList()));
        queries.add(Arrays.stream(new Integer[]{1, 8, 1}).collect(Collectors.toList()));
        queries.add(Arrays.stream(new Integer[]{5, 9, 15}).collect(Collectors.toList()));*/
        long l = arrayManipulation(10, queries);
        System.out.println(l);
        System.out.println(arrayManipulation1(10, queries));
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        int minRange = 0, maxRange = Integer.MAX_VALUE;
        List<Integer> a = new LinkedList<>();
        int max = 0;
        for (List<Integer> query : queries) {
            System.out.println("input arry" + query);
            Integer query0 = query.get(0);
            if (query0 > minRange) {
                minRange = query0;
            }
            Integer query1 = query.get(1);
            if (query1 < maxRange) {
                maxRange = query1;
            }
            Integer e = query.get(2);
//            max += e;
            a.add(e);

            System.out.print("minRange " + minRange);
            System.out.print(" maxRange " + maxRange);
            System.out.print(" value " + e+"\n");
        }
        System.out.println("Fin maxRange " + maxRange);
        System.out.println("Fin minRange " + minRange);
        System.out.println(a);
        return max;
    }

    public static long arrayManipulation1(int n, List<List<Integer>> queries) {
        // Write your code here
        int[] arr = new int[n];
        int max = 0;
        for (List<Integer> query : queries) {
            for (int j = query.get(0) - 1; j < query.get(1); j++) {
                arr[j] += query.get(2);
                if (max < arr[j]) {
                    max = arr[j];
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return max;
    }
}
