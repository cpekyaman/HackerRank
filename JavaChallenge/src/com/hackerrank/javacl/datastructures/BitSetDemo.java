package com.hackerrank.javacl.datastructures;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by raistlin on 9/10/2017.
 */
class BitSetDemo {
    void run() {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int opers = in.nextInt();

        in.nextLine();

        final BitSet[] bitSets = new BitSet[]{new BitSet(size), new BitSet(size)};
        for (int i = 0; i < opers; ++i) {
            final String op = in.next();
            final int left = in.nextInt();
            final int right = in.nextInt();

            applyOperation(bitSets, op, left, right);
            System.out.printf("%d %d\n", bitSets[0].cardinality(), bitSets[1].cardinality());
        }
    }

    void applyOperation(BitSet[] bitSets, String op, int left, int right) {
        switch (op) {
            case "AND":
                bitSets[left - 1].and(bitSets[right - 1]);
                break;
            case "OR":
                bitSets[left - 1].or(bitSets[right - 1]);
                break;
            case "XOR":
                bitSets[left - 1].xor(bitSets[right - 1]);
                break;
            case "FLIP":
                bitSets[left - 1].flip(right);
                break;
            case "SET":
                bitSets[left - 1].set(right);
                break;
        }
    }
}
