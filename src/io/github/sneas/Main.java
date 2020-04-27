package io.github.sneas;

import java.util.*;

public class Main {
    static void generateSquare(int[][] s, LinkedList<Integer> results, LinkedList<Integer> availableItems, int index, int[] combination) {
        if (index == 9) {
            int magicSum = 0;
            int steps = 0;
            int diagonal1 = 0;
            for (int i = 0; i < 3; i++) {
                int horizontalSum = 0;
                int verticalSum = 0;
                for (int j = 0; j < 3; j++) {
                    int magicIJ = combination[i * 3 + j];
                    steps += Math.abs(s[i][j] - magicIJ);
                    horizontalSum += magicIJ;
                    verticalSum += combination[j * 3 + i];
                    if (i == j) {
                        diagonal1 += combination[i * 3 + j];
                    }
                }
                if (magicSum == 0) {
                    magicSum = horizontalSum;
                }

                if (horizontalSum != magicSum) {
                    return;
                }

                if (verticalSum != magicSum) {
                    return;
                }
            }

            if (diagonal1 != magicSum) {
                return;
            }

            int diagonal2 = 0;

            for (int i = 0; i < 3; i++) {
                diagonal2 += combination[i * 3 + (2 - i)];
            }

            if (diagonal2 != magicSum) {
                return;
            }

            results.add(steps);

            return;
        }

        for (Integer item: availableItems) {
            LinkedList<Integer> newAvailableItems = (LinkedList)availableItems.clone();
            newAvailableItems.remove(item);
            combination[index] = item;
            generateSquare(s, results, newAvailableItems, index + 1, combination);
        }
    }

    static int formingMagicSquare(int[][] s) {
        LinkedList<Integer> availableItems = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int index = 0;
        int[] combination = new int[9];
        LinkedList<Integer> results = new LinkedList<Integer>();

        generateSquare(s, results, availableItems, index, combination);

        int min = 10000000;

        for (int steps: results) {
            if (steps < min) {
                min = steps;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int result  = formingMagicSquare(new int[][]{
                {4, 8, 2},
                {4, 5, 7},
                {6, 1, 6}
        });
        System.out.println(result);
    }
}
