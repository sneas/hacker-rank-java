package io.github.sneas;

import java.util.*;

public class Main {

    static long solve(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        Hashtable<Integer, Integer> hash =
                new Hashtable<Integer, Integer>();

        long result = 0;

        stack.push(arr[0]);
        hash.put(arr[0], 1);

        for (int i = 1; i < arr.length; i++) {
            int h = arr[i];

            while(!stack.empty() && stack.peek() < h) {
                int s = stack.pop();
                long h1 = hash.get(s);
                result += (h1 - 1) * h1;
                hash.replace(s, 0);
            }

            if (stack.empty() || stack.peek() > h) {
                stack.push(h);
            }

            if (hash.containsKey(h)) {
                hash.replace(h, hash.get(h) + 1);
            } else {
                hash.put(h, 1);
            }
        }

        while(!stack.empty()) {
            int s = stack.pop();
            long h1 = hash.get(s);
            result += (h1 - 1) * h1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[300000];
        Arrays.fill(input, 1);
        long result  = solve(input);
        System.out.println(result);
    }
}
