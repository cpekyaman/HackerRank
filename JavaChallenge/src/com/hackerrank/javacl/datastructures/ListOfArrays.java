package com.hackerrank.javacl.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by raistlin on 9/10/2017.
 */
class ListOfArrays {
    private void run() {
        Scanner in = new Scanner(System.in);
        int arrayCount = in.nextInt();
        List<int[]> rows = new ArrayList<>(arrayCount);

        for (int i = 0; i < arrayCount; i++) {
            int arrSize = in.nextInt();
            int[] arr = new int[arrSize];
            rows.add(arr);
            if (arrSize > 0) {
                for (int j = 0; j < arrSize; ++j) {
                    arr[j] = in.nextInt();
                }
            }
        }

        int queryCount = in.nextInt();
        for (int q = 0; q < queryCount; ++q) {
            int row = in.nextInt();
            int col = in.nextInt();
            if (rows.size() < row || rows.get(row - 1).length < col) {
                System.out.println("ERROR!");
            } else {
                System.out.println(rows.get(row - 1)[col - 1]);
            }
        }
    }
}
