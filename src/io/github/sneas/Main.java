package io.github.sneas;

import java.util.*;

public class Main {

    static class Node {
        private Hashtable<Character, Node> children = new Hashtable<>();
        private int words = 0;

        public Node add(char c) {
            words = words + 1;

            if (!children.containsKey(c)) {
                Node n = new Node();
                children.put(c, n);
                return n;
            }

            return children.get(c);
        }

        public void add(String s) {
            Node n = this;
            for (char c: s.toCharArray()) {
                n = n.add(c);
            }
            n.words = n.words + 1;
        }

        public int find(String s) {
            Node n = this;
            for (char c: s.toCharArray()) {
                if (!n.children.containsKey(c)) {
                    return 0;
                }

                n = n.children.get(c);
            }

            return n.words;
        }
    }

    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) {
        List<Integer> result = new ArrayList<>();
        Node root = new Node();

        for (String[] query: queries) {
            if (query[0].equals("add")) {
                root.add(query[1]);
            } else {
                result.add(root.find(query[1]));
            }
        }

        return result.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        int[] result = contacts(new String[][]{
            { "add", "hack" },
            { "add", "hackerrank" },
            { "find", "hac" },
            { "find", "hak" }
        });
        System.out.println(Arrays.toString(result));
    }
}
