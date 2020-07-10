package io.github.sneas;

import java.util.Hashtable;

public class AlternatingCharacters {
    static int alternatingCharacters(String s) {
        int result = 0;
        char current = 'C';

        for (char ch: s.toCharArray()) {
            if (ch == current) {
                result++;
            }

            current = ch;
        }

        return result;
    }

    public static void main(String[] args) {
        int result = alternatingCharacters("AAABBB");
        System.out.println(result);
    }
}
