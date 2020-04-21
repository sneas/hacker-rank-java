package io.github.sneas;

import java.util.*;

public class Main {

    static long solve(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        long[] left = new long[arr.length];

        for (int i = 0; i < arr.length; i++) {
            long ai = arr[i];

            while(!stack.isEmpty() && arr[stack.peek()] <= ai) {
                stack.pop();
            }

            long li = stack.isEmpty() ? 0 : stack.peek() + 1;
            left[i] = li;

            stack.push(i);
        }

        stack.clear();

        long max = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            int ai = arr[i];

            while(!stack.isEmpty() && arr[stack.peek()] <= ai) {
                stack.pop();
            }

            long ri = stack.isEmpty() ? 0 : stack.peek() + 1;

            long indexProduct = ri * left[i];

            if (indexProduct > max) {
                max = indexProduct;
            }

            stack.push(i);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[100000];
        Arrays.fill(arr, 1000000000);
        arr[50000] = 1000;
        long result  = solve(arr);
        System.out.println(result);
    }
}
