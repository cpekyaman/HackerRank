package com.hackerrank.javacl.bignumber;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by raistlin on 8/6/2017.
 */
public class BigNumberChallenge {
    private static void bigIntOperations() {
        Scanner in = new Scanner(System.in);
        String n1 = in.nextLine().trim();
        String n2 = in.nextLine().trim();
        in.close();

        BigInteger bigint1 = new BigInteger(n1);
        BigInteger bigint2 = new BigInteger(n2);

        System.out.println(bigint1.add(bigint2));
        System.out.println(bigint1.multiply(bigint2));
    }

    private static void isPrimaryTest() {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        in.close();

        System.out.println(n.isProbablePrime(1) ? "prime" : "not prime");
    }

    private static void bigDecimalTest() {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        Arrays.sort(s, (o1, o2) -> {
            if(o1 == null) {
                return 1;
            } else if (o2 == null) {
                return -1;
            }

            BigDecimal d1 = new BigDecimal(o1);
            BigDecimal d2 = new BigDecimal(o2);
            return d2.compareTo(d1);
        });

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }

    public static void main(String[] args) {
        bigDecimalTest();
    }
}
