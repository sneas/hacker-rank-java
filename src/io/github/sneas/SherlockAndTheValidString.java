package io.github.sneas;

import java.util.Collections;
import java.util.Hashtable;

public class SherlockAndTheValidString {
    static String isValid(String s) {
        Hashtable<Character, Integer> h = new Hashtable<>();

        for (char ch: s.toCharArray()) {
            h.put(ch, h.getOrDefault(ch, 0) + 1);
        }

        Hashtable<Integer, Integer> t = new Hashtable<>();

        for(Integer n: h.values()) {
            t.put(n, t.getOrDefault(n, 0) + 1);
        }

        if (t.size() == 1) {
            return "YES";
        }

        if (t.size() > 2) {
            return "NO";
        }

        Integer min = Collections.min(t.keySet());
        Integer max = Collections.max(t.keySet());

        if (min == 1 && t.get(min) == 1) {
            return "YES";
        }

        if (min != max - 1) {
            return "NO";
        }

        if (t.get(max) == 1) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {
//        String result = isValid("abcdefghhgfedecba");
        String result = isValid("aabbbccc");
        System.out.println(result);
    }
}
