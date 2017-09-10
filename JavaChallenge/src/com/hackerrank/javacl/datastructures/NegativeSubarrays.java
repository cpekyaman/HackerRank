package com.hackerrank.javacl.datastructures;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by raistlin on 9/10/2017.
 */
class NegativeSubarrays {
    private int subArraysForSize(int[] arr, int size) {
        int count = 0;

        for (int i = 0; i <= arr.length - size; ++i) {
            int sum = 0;
            for (int j = 0; j < size; j++) {
                sum += arr[i + j];
            }
            if (sum < 0) {
                count++;
            }
        }

        return count;
    }

    void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();

        int negativeCount = 0;
        for (int sz = 1; sz < arr.length; sz++) {
            negativeCount += subArraysForSize(arr, sz);
        }

        if (Arrays.stream(arr).sum() < 0) {
            negativeCount++;
        }

        System.out.println(negativeCount);
    }
}
