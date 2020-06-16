package io.github.sneas;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    static int maximumToys(int[] prices, int k) {
        int result = 0;
        Arrays.sort(prices);
        for(int price: prices) {
            k -= price;
            if (k < 0) {
                break;
            }
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        int result = maximumToys(new int[]{1, 12, 5, 111, 200, 1000, 10}, 50);
        System.out.println(result);
    }
}
