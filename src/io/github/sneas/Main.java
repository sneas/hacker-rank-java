package io.github.sneas;

public class Main {

    static int twoStacks(int x, int[] a, int[] b) {
        int aSum = 0, totalSteps = 0;
        int maxSteps = 0;
        int ai, bi;

        for (ai = 0; ai < a.length; ai++) {
            if (aSum + a[ai] > x) {
                break;
            }

            aSum += a[ai];
            totalSteps++;
            maxSteps = totalSteps;
        }

        int bSum = 0;

        for (bi = 0; bi < b.length; bi++) {
            if (bSum + b[bi] > x) {
                break;
            }

            bSum += b[bi];

            totalSteps++;

            while (aSum + bSum > x) {
                ai--;
                aSum -= a[ai];
                totalSteps--;
            }

            if (totalSteps > maxSteps) {
                maxSteps = totalSteps;
            }
        }

        return maxSteps;
    }

    public static void main(String[] args) {
        int result = twoStacks(30, new int[]{10, 5, 5, 2, 1, 7, 3}, new int[]{5, 7, 5, 3, 7, 7, 5});
        System.out.println(result);
    }
}
