package io.github.sneas;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Main {
    static long countTriplets(List<Long> arr, long r) {
        long result = 0;

        Hashtable<Long, Long> pairs = new Hashtable<>();
        Hashtable<Long, Long> amount = new Hashtable<>();

        for (long number: arr) {
            result += (number % r == 0) ? pairs.getOrDefault(number / r, 0L) : 0;

            if (pairs.containsKey(number)) {
                pairs.put(number, pairs.get(number)
                        + ((number % r == 0) ? amount.getOrDefault(number / r, 0L) : 0));
            }

            pairs.put(number * r, pairs.getOrDefault(number * r, 0L));

            amount.put(number, amount.getOrDefault(number, 0L) + 1);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/dima/Documents/hacker-rank-java/t2.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

//    public static void main(String[] args) {
//        long[] arr = {1, 3, 9, 9, 27, 81};
////        long[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,};
//
//        List<Long> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
//
//        long result = countTriplets(list, 3);
//
//        System.out.println(result);
//    }
}
