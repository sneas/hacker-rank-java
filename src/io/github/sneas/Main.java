package io.github.sneas;

import java.util.*;

public class Main {

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        List<Integer> distinct = new ArrayList<>();

        for (int score: scores) {
            if (distinct.isEmpty() || distinct.get(distinct.size() - 1) != score) {
                distinct.add(score);
            }
        }

        int[] result = new int[alice.length];

        int j = distinct.size() - 1;

        for (int i = 0; i < alice.length; i++) {
            int play = alice[i];
            int rank = -1;

            while (j >= 0) {
                int dj = distinct.get(j);
                if (dj == play) {
                    rank = j + 1;
                    break;
                }

                if (dj > play) {
                    rank = j + 2;
                    break;
                }

                j--;
            };

            if (rank == -1 && j == -1) {
                rank = 1;
            }

            result[i] = rank;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result  = climbingLeaderboard(
                    new int[]{100, 100, 50, 40, 40, 20, 10},
                    new int[]{5, 25, 50, 120}
                );
        System.out.println(Arrays.toString(result));
    }
}
