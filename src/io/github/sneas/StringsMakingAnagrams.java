package io.github.sneas;

import java.util.Hashtable;

public class StringsMakingAnagrams {
    static int makeAnagram(String a, String b) {
        int result = 0;

        Hashtable<Character, Integer> h = new Hashtable<>();

        for(Character ch: a.toCharArray()) {
            h.put(ch, h.getOrDefault(ch, 0) + 1);
        }

        for(Character ch: b.toCharArray()) {
            h.put(ch, h.getOrDefault(ch, 0) - 1);
        }

        for(int fr: h.values()) {
            result += Math.abs(fr);
        }

        return result;
    }

    public static void main(String[] args) {
        int result = makeAnagram("cde", "abc");
        System.out.println(result);
    }
}
