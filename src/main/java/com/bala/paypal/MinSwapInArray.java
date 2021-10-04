package com.bala.paypal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MinSwapInArray {
    public static void main(String[] args) {
        int[] a = {101, 315, 460, 472, 479, 619, 730, 758};
        System.out.println(computeMinSwapCount(a));
    }

    public static int computeMinSwapCount(int[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(Arrays.toString(args));
        AtomicInteger atomicInt = new AtomicInteger();
        Arrays.stream(args).forEach(k -> map.put(k, atomicInt.getAndIncrement()));
        int length = args.length;
        Boolean[] visited = new Boolean[length];
        Arrays.fill(visited, false);
        Arrays.sort(args);
        System.out.println(Arrays.toString(args));
        int swap = 0;
        for (int i = 0; i < length; i++) {
            if (visited[i] || map.get(args[i]) == i) {
                continue;
            }
            int j = i, swapCount = 0;
            while (!visited[j]) {
                visited[j] = true;
                int arg = args[j];
                j = map.get(arg);
                swapCount++;
            }
            if (swapCount > 0) {
                swap += (swapCount - 1);
            }
        }
        return swap;
    }

    /*public static int computeMinSwap(int[] arr) {
        int arrLength = arr.length;
        int[] temp = Arrays.copyOf(arr, arrLength);
        Arrays.sort(temp);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(temp));
        int swaps = 0;
        for (int i = 0; i < arrLength; i++) {
            if (arr[i] != temp[i]) {
                swaps++;
            }
        }
        return swaps;
    }*/
}
