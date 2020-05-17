package io.github.sneas;

import java.util.*;

public class Main {
    static int hourglassSum(int[][] arr) {
        int max = -1000000;
        for (int i = 1; i<= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (i == 4 && j == 3) {
                    int k = 5;
                }
                int sum = arr[i - 1][j - 1]+ arr[i-1][j] + arr[i-1][j+1]
                        + arr[i][j]
                        + arr[i+1][j - 1] + arr[i + 1][j] + arr[i+1][j+1];

                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
//        int result  = hourglassSum(new int[][]{
//            {1, 1, 1, 0, 0, 0,},
//            {0, 1, 0, 0, 0, 0,},
//            {1, 1, 1, 0, 0, 0,},
//            {0, 0, 2, 4, 4, 0,},
//            {0, 0, 0, 2, 0, 0,},
//            {0, 0, 1, 2, 4, 0,},
//        });
        
        int result  = hourglassSum(new int[][]{
            {-1, -1, 0, -9, -2, -2,},
            {-2, -1, -6, -8, -2, -5,},
            {-1, -1, -1, -2, -3, -4,},
            {-1, -9, -2, -4, -4, -5,},
            {-7, -3, -3, -2, -9, -9,},
            {-1, -3, -1, -2, -4, -5,},
        });
        System.out.println(result);
    }
}
