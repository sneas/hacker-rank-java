package io.github.sneas;

import java.util.*;

public class Main {
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        String l = s1.length() > s2.length() ? s1 : s2;
        String s = s1.length() <= s2.length() ? s1 : s2;
        Hashtable<Character, Boolean> h = new Hashtable<>();

        for(Character c: l.toCharArray()) {
            h.put(c, true);
        }

        for (Character c: s.toCharArray()) {
            if (h.getOrDefault(c, false)) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        String result = twoStrings(
                "hello",
                "world"
        );

        System.out.println(result);
    }
}
