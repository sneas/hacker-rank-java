package io.github.sneas;

import java.util.*;

public class Main {
    static int minimumSwaps(int[] arr) {
        int result = 0;
        Hashtable<Integer, Integer> h = new Hashtable<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i+1) {
                continue;
            }

            while (h.containsKey(arr[i]) && arr[i] != i+1) {
                result++;
                int ai = arr[i];
                arr[i] = h.get(ai);
                h.remove(ai);
                h.put(i+1, arr[i]);
            }

            h.put(i+1, arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int result  = minimumSwaps(new int[]{2, 3, 4, 1, 5});
//        int result  = minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7});
        System.out.println(result);
    }
}
