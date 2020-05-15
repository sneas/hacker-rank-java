package io.github.sneas;

public class Main {

    static void minimumBribes(int[] q) {
        int result = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] <= i + 1) {
                continue;
            }

            while (q[i] > i + 1) {
                int jump = q[i] - (i + 1);

                if (jump > 2) {
                    System.out.println("Too chaotic");
                    return;
                }

                result += jump;

                for (int j = 0; j < jump; j++) {
                    int qj = q[i + j];
                    q[i + j] = q[i + j + 1];
                    q[i + j + 1] = qj;
                }
            }
        }

        System.out.println(result);
    }


    public static void main(String[] args) {
//        minimumBribes(new int[]{2, 1, 5, 3, 4});
        minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
//        System.out.println(result);
    }
}
