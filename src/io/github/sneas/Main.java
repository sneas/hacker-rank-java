package io.github.sneas;

import java.util.*;

public class Main {

    static class Sector {
        public final int position;
        public final int height;

        Sector(int position, int height) {
            this.position = position;
            this.height = height;
        }
    }

    static long largestRectangle(int[] h) {
        List<Sector> stack = new Stack<Sector>();

        int max = 0;

        for (int i = 0; i < h.length; i++) {
            int value = h[i];
            int position = i;
            Sector last = stack.isEmpty() ? null : stack.get(stack.size() - 1);
            while (last != null && last.height > value) {
                int square = last.height * (i - last.position);
                if (square > max) {
                    max = square;
                }
                position = last.position;
                stack.remove(stack.size() - 1);
                last = stack.isEmpty() ? null : stack.get(stack.size() - 1);
            }
            stack.add(new Sector(position, value));
        }

        while(!stack.isEmpty()) {
            Sector last = stack.remove(stack.size() - 1);
            int square = last.height * (h.length - last.position);
            if (square > max) {
                max = square;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        long result  = largestRectangle(new int[]{8979, 4570, 6436, 5083, 7780, 3269, 5400, 7579, 2324, 2116});
        System.out.println(result);
    }
}
