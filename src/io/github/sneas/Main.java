package io.github.sneas;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Main {
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        Hashtable<Integer, Integer> numbers = new Hashtable<>();
        Hashtable<Integer, Integer> frequencies = new Hashtable<>();

        for (List<Integer> query: queries) {
            int action = query.get(0);
            int value = query.get(1);
            int prevFrequency;

            switch (action) {
                case 1:
                    prevFrequency = numbers.getOrDefault(value, 0);
                    frequencies.put(prevFrequency, frequencies.getOrDefault(prevFrequency, 1) - 1);
                    frequencies.put(prevFrequency + 1, frequencies.getOrDefault(prevFrequency + 1, 0) + 1);
                    numbers.put(value, prevFrequency + 1);
                    break;
                case 2:
                    prevFrequency = numbers.getOrDefault(value, 0);

                    if (prevFrequency == 0) {
                        break;
                    }

                    frequencies.put(prevFrequency, frequencies.get(prevFrequency) - 1);
                    frequencies.put(prevFrequency - 1, frequencies.get(prevFrequency - 1) + 1);
                    numbers.put(value, prevFrequency - 1);
                    break;
                default:
                    result.add(frequencies.getOrDefault(value, 0) == 0 ? 0 : 1);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./t2.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
