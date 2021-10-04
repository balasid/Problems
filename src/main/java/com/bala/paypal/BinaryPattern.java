package com.bala.paypal;

/*
0000 0001 0010
 */
public class BinaryPattern {
    public static void main(String[] args) {
        int n = 2;
        int arr[] = new int[n];
        generateBinaryPattern(n, arr, 0);
    }

    private static void generateBinaryPattern(int n, int[] arr, int i) {
        if (i == n) {
            printTheArray(arr, n);
            return;
        }
        arr[i] = 0;
        generateBinaryPattern(n, arr, i + 1);

        arr[i] = 1;
        generateBinaryPattern(n, arr, i + 1);
    }

    private static void printTheArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
