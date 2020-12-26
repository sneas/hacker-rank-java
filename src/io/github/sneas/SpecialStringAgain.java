package io.github.sneas;

import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

public class SpecialStringAgain {
    static long substrCount(int n, String s) {
        LinkedList<List<Character>> l = new LinkedList<>();

        long count = 0;

        for (char c: s.toCharArray()) {
            if (l.size() == 0 || l.getLast().get(0) != c) {
                l.add(new ArrayList<>(Collections.singletonList(c)));
            } else if (l.getLast().get(0) == c) {
                l.getLast().add(c);
            }

            count += l.getLast().size();

            while (l.size() > 3) {
                l.removeFirst();
            }

            if (l.size() != 3) {
                continue;
            }

            if (l.get(1).size() != 1) {
                continue;
            }

            if (l.getFirst().get(0) == l.getLast().get(0) && l.getFirst().size() >= l.getLast().size()) {
                count += 1;
            }
        }

        return count;
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        String s = "aaabaaa";
//
//        long result = substrCount(s.length(), s);
//
//        System.out.println(result);
//    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input/special-string-again/2.txt"), StandardCharsets.UTF_8.name());

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        System.out.println(result);

        scanner.close();
    }
}
