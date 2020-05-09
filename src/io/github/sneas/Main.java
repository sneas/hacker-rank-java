package io.github.sneas;

import java.util.*;

public class Main {
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        Hashtable<Integer, Integer> h = new Hashtable<>();

        for (int i: s) {
            int mod = i % k;
            h.put(mod, h.getOrDefault(mod, 0) + 1);
        }

        int count = 0;

        for (int i = k - 1; i > k / 2; i--) {
            count += Math.max(
                    h.getOrDefault(i, 0),
                    h.getOrDefault(k - i, 0)
            );
        }

        if (h.containsKey(0)) {
            count += 1;
        }

        if (k % 2 == 0 && h.containsKey(k / 2)) {
            count += 1;
        }

        return count;
    }

    public static void main(String[] args) {
//        int result  = nonDivisibleSubset(3, new ArrayList<>(Arrays.asList(1, 7, 2, 4)));
        int result  = nonDivisibleSubset(4, new ArrayList<>(Arrays.asList(19, 10, 12, 10, 24, 25, 22)));
        System.out.println(result);
    }
}
