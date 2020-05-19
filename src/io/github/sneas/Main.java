package io.github.sneas;

import java.util.*;

public class Main {
    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Hashtable<String, Integer> h = new Hashtable<>();

        for (String s: magazine) {
            h.put(s, h.getOrDefault(s, 0) + 1);
        }

        for (String s: note) {
            if (h.getOrDefault(s, 0) == 0) {
                System.out.println("No");
                return;
            }

            h.put(s, h.get(s) - 1);
        }

        System.out.println("Yes");
    }

    public static void main(String[] args) {
        checkMagazine(
                new String[]{"give", "me", "one", "grand", "today", "night"},
                new String[]{"give", "me", "one", "grand", "today"}
        );

    }
}
