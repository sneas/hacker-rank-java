package io.github.sneas;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimumAbsoluteDifference {
    // Complete the commonChild function below.
    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
        }

        return minDiff;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long result = minimumAbsoluteDifference(new int[]{1, -3, 71, 68, 17});

        System.out.println(result);
    }
}
