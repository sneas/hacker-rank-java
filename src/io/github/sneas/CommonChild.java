package io.github.sneas;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CommonChild {
    // Complete the commonChild function below.
    static int commonChild(String x, String y) {
        int m = x.length();
        int n = y.length();

        int[][] c = new int[m + 1][n + 1];

        for (int i = 1; i<= m; i++) {
            c[i][0] = 0;
        }

        for (int j = 1; j<= n; j++) {
            c[0][j] = 0;
        }

        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (x.charAt(i) == y.charAt(j)) {
                    c[i + 1][j + 1] = c[i][j] + 1;
                } else if (c[i][j + 1] >= c[i + 1][j]) {
                    c[i + 1][j + 1] = c[i][j + 1];
                } else {
                    c[i + 1][j + 1] = c[i + 1][j];
                }

                max = c[i + 1][j + 1];
            }
        }

        return max;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String s1 = "SHINCHAN";
        String s2 = "NOHARAAA";

        long result = commonChild(s1, s2);

        System.out.println(result);
    }
}
