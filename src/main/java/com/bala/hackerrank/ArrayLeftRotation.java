package com.bala.hackerrank;

import java.util.Arrays;
import java.util.LinkedList;

public class ArrayLeftRotation {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rotateArray(arr, 2, arr.length);
        System.out.println(Arrays.toString(arr));
        rotateWithLinkedList(arr, 2, arr.length);
    }

    public static void rotateWithLinkedList(int[] arr, int d, int n) {
        System.out.println("Rotate With LinkedList");
        System.out.println(System.currentTimeMillis());
        LinkedList<Integer> array = new LinkedList<>();
        Arrays.stream(arr).forEach(a -> array.add(a));
        for (int i = 0; i < d; i++) {
            Integer integer = array.removeFirst();
            array.addLast(integer);
        }
        System.out.println(System.currentTimeMillis());
        System.out.println(array);
    }

    private static void rotateArray(int[] arr, int d, int n) {
        System.out.println("Rotate Array");
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < d; i++) {
            int temp = arr[0];
            for (int j = 0; j < n - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[n - 1] = temp;
        }
        System.out.println(System.currentTimeMillis());
    }
}
