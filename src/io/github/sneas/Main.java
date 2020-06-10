package io.github.sneas;

public class Main {

    static void countSwaps(int[] a) {
        int tally = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    tally++;
                    int j1 = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = j1;
                }
            }

        }
        System.out.printf("Array is sorted in %s swaps.\n", tally);
        System.out.printf("First Element: %s\n", a[0]);
        System.out.printf("Last Element: %s\n", a[a.length - 1]);
    }

    public static void main(String[] args) {
        countSwaps(new int[]{3, 2, 1});
    }
}
