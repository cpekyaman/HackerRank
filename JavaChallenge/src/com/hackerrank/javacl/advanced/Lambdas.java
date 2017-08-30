package com.hackerrank.javacl.advanced;

/**
 * Created by raistlin on 8/30/2017.
 */
public class Lambdas {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    PerformOperation isPrime() {
        return n -> !(n % 2 == 0 || java.util.stream.IntStream.rangeClosed(3, (int) Math.sqrt(n)).anyMatch(i -> n % i == 0) );
    }

    PerformOperation isPalindrome() {
        return n -> String.valueOf(n).equals(new StringBuilder(String.valueOf(n)).reverse().toString());
    }
}

@FunctionalInterface
interface PerformOperation {
    boolean check(int a);
}
