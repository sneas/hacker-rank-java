package io.github.sneas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FraudulentActivityNotifications {
    static int activityNotifications(int[] expenditure, int d) {
        int result = 0;

        int[] freqs = new int[200];
        int doubleMedian = 0;
        Queue<Integer> q = new ArrayDeque<Integer>();
        int last = 0;

        for (int expense: expenditure) {
            if (doubleMedian > 0 && expense >= doubleMedian) {
                result++;
            }

            if (q.size() == d) {
                last = q.remove();
                freqs[last]--;
            }

            q.add(expense);
            freqs[expense]++;

            if (q.size() < d) {
                continue;
            }

            doubleMedian = getDoubleMedian(freqs, d);
        }

        return result;
    }

    public static int getDoubleMedian(int[] freqs, int d) {
        int total = 0;
        int doubleMedian = 0;

        if (d % 2 == 1) {
            for (int exp = 0; exp < freqs.length; exp++) {
                total += freqs[exp];
                if (total > d / 2) {
                    return exp * 2;
                }
            }
        }

        int first = -1;
        int second = -1;

        for (int exp = 0; exp < freqs.length; exp++) {
            total += freqs[exp];

            if(total == d/2)
            {
                first = exp;
            } else if(total > d/2) {
                if(first < 0 ) {
                    first = exp;
                }
                second = exp;

                return first + second;
            }
        }

        return doubleMedian;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input/fraudlent-activity-notifications/1.txt"), StandardCharsets.UTF_8.name());

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

//    public static void main(String[] args) {
////        int result = activityNotifications(new int[]{1, 2, 3, 4, 4}, 4);
//        int result = activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5);
//        System.out.println(result);
//    }
}
