package com.bala.paypal;

import java.util.Arrays;
import java.util.Stack;

public class QueryOnQueues {
    public static void main(String[] args) {
        int[] solve = solve(5, new int[]{4, 2, 3, 5, 1}, 2, new int[]{1, 3});
//        int[] solve = solve(4, new int[]{4, 2, 1, 3}, 2, new int[]{1, 4});
        System.out.println(Arrays.toString(solve));
    }

    public static int[] solve(int N, int[] A, int K, int[] Q) {
        int len = N;
        int[] left = new int[len];
        int[] right = new int[len];
        Stack<Integer> stack = new Stack<>() {
            /*@Override
            public Integer push(Integer item) {
                System.out.println("Stack Item Pushed " + item);
                return super.push(item);
            }

            @Override
            public synchronized Integer peek() {
                Integer peek = super.peek();
                System.out.println("Stack Item Peek " + peek);
                return peek;
            }

            @Override
            public synchronized Integer pop() {
                Integer pop = super.pop();
                System.out.println("Stack Item Pop " + pop);
                return pop;
            }*/
        };
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for (int i = len - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                    stack.pop();
                }
            }
            right[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i < len; i++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                    stack.pop();
                }
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
//        System.out.println(stack);
        int[] result = new int[K];
        for (int i = 0; i < K; i++) {
            int ans = 0;
            int index = Q[i] - 1;
            if (left[index] != -1) {
                ans += Math.abs(index - left[index]) - 1;
            } else {
                ans += Math.abs(index);
            }
            if (right[index] != -1) {
                ans += Math.abs(index - right[index]) - 1;
            } else {
                ans += Math.abs(index - len) - 1;
            }
            ans++;
            result[i] = ans;
        }
        return result;
    }
}
