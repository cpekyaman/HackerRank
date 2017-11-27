package com.hackerrank.javacl.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by raistlin on 8/7/2017.
 */
public class ExceptionChallenge {
    private static void nToPowerM() {
        Scanner in = new Scanner(System.in);
        while (in .hasNextInt()) {
            int n = in .nextInt();
            int p = in .nextInt();

            try {
                System.out.println(new MyCalculator().power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private static void arithmetic() {
        Scanner in = new Scanner(System.in);
        try {
            int n1 = in.nextInt();
            int n2 = in.nextInt();

            System.out.println(n1 / n2);
        } catch (InputMismatchException e) {
            System.out.println(e.getClass().getName());
        } catch (ArithmeticException e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            in.close();
        }
    }

    public static void main(String[] args) {
        // arithmetic();
        nToPowerM();
    }
}

class MyCalculator {
    int power(int n, int p) throws Exception{
        if(n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        } else if(n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        } else {
            return (int) Math.pow(n, p);
        }
    }
}
