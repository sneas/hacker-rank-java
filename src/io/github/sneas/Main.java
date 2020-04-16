package io.github.sneas;

import java.util.*;

public class Main {

    static class TotalItem {
        int sum;
        int immediate;

        TotalItem(int sum, int immediate) {
            this.sum = sum;
            this.immediate = immediate;
        }
    }

    static int solve(int[][] shots, int[][] players) {
        Arrays.sort(shots, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int first = a[0] - b[0];
                if (first == 0) {
                    return a[1] - b[1];
                }

                return first;
            }
        });

        TotalItem[] totalItems = new TotalItem[shots[shots.length - 1][1]];
        int shotIndex = 0;
        Queue<Integer> end = new LinkedList<>();
        int sum = 0;
        int immediate = 0;

        for (int i = 0; i < totalItems.length; i++) {
            while (shotIndex < shots.length &&  i == shots[shotIndex][0] - 1) {
                sum++;
                immediate++;
                end.add(shots[shotIndex][1]);
                shotIndex++;
            }

            totalItems[i] = new TotalItem(sum, immediate);

            while (!end.isEmpty() && end.peek() == i + 1) {
                immediate--;
                end.remove();
            }
        }

        int result = 0;

        for (int[] player : players) {
            TotalItem startItem = totalItems[player[0] - 1];
            result += totalItems[player[1] - 1].sum - (startItem.sum - startItem.immediate);
        }

        return result;
    }

    public static void main(String[] args) {
        long result  = solve(new int[][]{
                {16, 52},
                {92, 177},
                {46, 139},
                {91, 146},
                {43, 139},
                {83, 118},
                {65, 77},
                {11, 12},
                {41, 66},
                {99, 188},
                {67, 86},
                {28, 37},
                {76, 125},
                {61, 79},
                {28, 93},
                {75, 154},
                {81, 146},
                {90, 114},
                {84, 173},
                {17, 112},
                {94, 130},
                {31, 66},
                {75, 128},
                {55, 137},
                {38, 89},
                {38, 47},
                {86, 116},
                {43, 56},
                {75, 103},
                {91, 183},
                {28, 94},
                {17, 77},
                {47, 66},
                {39, 86},
                {29, 56},
                {43, 135},
                {24, 103},
                {13, 50},
                {78, 131},
                {34, 48},
                {68, 134},
                {16, 25},
                {71, 138},
                {82, 144},
                {37, 121},
                {39, 48},
                {12, 58},
                {46, 79},
                {78, 139},
        }, new int[][]{
                {73, 120},
                {61, 118},
                {38, 41},
                {93, 101},
                {77, 124},
                {78, 106},
                {95, 177},
                {43, 132},
                {95, 97},
                {39, 104},
                {35, 92},
                {19, 94},
                {33, 109},
                {8, 62},
                {46, 87},
                {35, 37},
                {42, 133},
                {34, 35},
                {38, 78},
                {54, 137},
                {63, 109},
                {89, 147},
                {24, 81},
                {72, 163},
                {17, 93},
                {88, 180},
                {20, 109},
                {73, 145},
                {84, 166},
                {53, 121},
                {69, 154},
                {6, 78},
                {88, 140},
                {54, 59},
                {19, 25},
                {89, 105},
                {58, 82},
                {5, 92},
                {39, 43},
                {90, 184},
                {51, 141},
                {93, 142},
                {66, 105},
                {45, 104},
                {62, 112},
                {94, 96},
                {3, 28},
                {5, 55},
                {1, 14},
                {1, 56},
        });
        System.out.println(result);
    }

//    public static void main(String[] args) {
//        long result  = solve(new int[][]{
//                {1, 2},
//                {2, 3},
//                {4, 5},
//                {6, 7},
//        }, new int[][]{
//                {1, 5},
//                {2, 3},
//                {4, 7},
//                {5, 7},
//        });
//        System.out.println(result);
//    }
}
