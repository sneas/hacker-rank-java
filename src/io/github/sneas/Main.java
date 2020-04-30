package io.github.sneas;

import java.math.BigInteger;
import java.util.*;

public class Main {

    static void extraLongFactorials(int n) {
        BigInteger result = new BigInteger("1");

        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        System.out.println(result);
    }

    public static void main(String[] args) {

        extraLongFactorials(25);
    }
}
