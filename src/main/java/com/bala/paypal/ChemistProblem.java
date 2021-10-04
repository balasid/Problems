package com.bala.paypal;

public class ChemistProblem {
    public static void main(String[] args) {
        int desiredResult = 5;
        int n = 8;
        int arr[] = {2, 1, 4, 2, 3, 2, 2, 6};
        int nearestDiff = Integer.MAX_VALUE;
        int a = 0, b = 0;
        int endIndex = n - 1;
        int startIndex = 0;
        while (startIndex != endIndex) {
            int i1 = arr[startIndex] + arr[endIndex];
            int diffVal = i1 - desiredResult;
            if (nearestDiff > diffVal && diffVal >= 0 && arr[startIndex] != arr[endIndex]) {
                nearestDiff = diffVal;
                a = arr[startIndex];
                b = arr[endIndex];
            }
            if (arr[startIndex] < desiredResult) {
                startIndex++;
            } else {
                endIndex--;
            }
        }
        System.out.println("a Value " + a + " b Value " + b);
    }
}
