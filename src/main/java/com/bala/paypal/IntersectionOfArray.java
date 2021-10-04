package com.bala.paypal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class IntersectionOfArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {3, 4, 5, 6, 7};
        int i = NumberofElementsInIntersection(a, b, a.length, b.length);
        System.out.println(i);
    }

    public static int NumberofElementsInIntersection(int[] a, int[] b, int n, int m) {
        // Your code here
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        IntStream.of(a).forEach(x -> integerHashMap.put(x, x));
        Set<Integer> list = new HashSet<>();
        IntStream.of(b).forEach(x -> integerHashMap.computeIfPresent(x, (z, y) -> {
            list.add(z);
            return y;
        }));
        System.out.println(list);
        return list.size();
    }
}
