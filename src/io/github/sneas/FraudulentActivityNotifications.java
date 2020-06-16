package io.github.sneas;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Queue;

public class FraudulentActivityNotifications {
    static int activityNotifications(int[] expenditure, int d) {
        int result = 0;

        int[] counts = new int[200];
        int[] indexes = new int[200];
        int[] sorted = new int[d];
        int doubleMedian = 0;
        Queue<Integer> q = new ArrayDeque<Integer>();
        int last = 0;

        for (int expense: expenditure) {
            if (doubleMedian > 0 && expense >= doubleMedian) {
                result++;
            }

            if (q.size() == d) {
                last = q.remove();
                counts[last]--;
            }

            q.add(expense);
            counts[expense]++;

            if (q.size() < d) {
                continue;
            }

            int total = 0;
            for (int i = 0; i < counts.length; i++) {
                total += counts[i];
                indexes[i] = total;
            }

            ArrayList<Integer> list = new ArrayList<>(q);
            Hashtable<Integer, Integer> h = new Hashtable<>();

            for (int i: list) {
                sorted[h.getOrDefault(i, indexes[i] - 1)] = i;
                h.put(i, h.getOrDefault(i, indexes[i] - 1) - 1);
            }

            if (d % 2 == 0) {
                doubleMedian = sorted[d / 2] + sorted[d / 2  + 1];
            } else {
                doubleMedian = sorted[d / 2] * 2;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int result = activityNotifications(new int[]{1, 2, 3, 4, 4}, 4);
        int result = activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5);
        System.out.println(result);
    }
}
