package io.github.sneas;

public class MergeSortCountingInversions {
    static long countInversions(int[] arr) {
        long result = mergesort(arr, new int[arr.length], 0, arr.length - 1);
        return result;
    }

    static long mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return 0;
        }

        long swaps = 0;

        int middle = (leftStart + rightEnd) / 2;
        swaps += mergesort(array, temp, leftStart, middle);
        swaps += mergesort(array, temp, middle + 1, rightEnd);
        return swaps + mergeHalves(array, temp, leftStart, rightEnd);
    }

    static long mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
        long swaps = 0;

        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd || right <= rightEnd) {
            if (left > leftEnd) {
                temp[index++] = array[right++];
            } else if (right > rightEnd) {
                temp[index++] = array[left++];
            } else if (array[left] <= array[right]) {
                temp[index++] = array[left++];
            } else {
                temp[index++] = array[right++];
                swaps += leftEnd + 1 - left;
            }
        }

        System.arraycopy(temp, leftStart, array, leftStart, size);

        return swaps;
    }

    public static void main(String[] args) {
        long result = countInversions(new int[]{2, 1, 3, 1, 2});
        System.out.println(result);
    }
}
