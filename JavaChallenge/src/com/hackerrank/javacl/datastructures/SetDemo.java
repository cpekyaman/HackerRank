package com.hackerrank.javacl.datastructures;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by raistlin on 9/10/2017.
 */
class SetDemo {
    void run() {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        Set<String> uniquePairs = new HashSet<>();
        for (int i = 0; i < t; ++i) {
            uniquePairs.add(Integer.toHexString(pair_left[i].hashCode()).concat("-").concat(Integer.toHexString(pair_right[i].hashCode())));
            System.out.println(uniquePairs.size());
        }
    }
}
