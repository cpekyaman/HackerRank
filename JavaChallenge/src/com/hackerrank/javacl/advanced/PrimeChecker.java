package com.hackerrank.javacl.advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * Created by raistlin on 9/4/2017.
 */
public class PrimeChecker {
    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(in));
        new Prime().checkPrime(2, 3, 5);
    }
}

class Prime {
    boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }

        if(n == 2) {
            return true;
        }

        for(int i = 2; i <= (int) Math.sqrt(n); ++i) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    void checkPrime(int... args) {
        StringBuilder output = new StringBuilder();
        for(int arg : args) {
            if(isPrime(arg)) {
                output.append(arg).append(" ");
            }
        }
        System.out.println(output.toString().trim());
    }
}
