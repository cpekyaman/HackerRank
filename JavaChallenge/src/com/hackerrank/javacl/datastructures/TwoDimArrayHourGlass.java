package com.hackerrank.javacl.datastructures;

import java.util.Scanner;

/**
 * Created by raistlin on 9/10/2017.
 */
class TwoDimArrayHourGlass {
    private int hourglassSum(int arr[][], int row, int column) {
        int sum = 0;

        sum += arr[row][column] + arr[row][column + 1] + arr[row][column + 2];
        sum += arr[row + 1][column + 1];
        sum += arr[row + 2][column] + arr[row + 2][column + 1] + arr[row + 2][column + 2];

        return sum;
    }

    private void findMaxHourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row <= 3; ++row) {
            for (int column = 0; column <= 3; column++) {
                int currentSum = hourglassSum(arr, row, column);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        System.out.println(maxSum);
    }

    private int[][] fillHourGlassArray() {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        return arr;
    }

    void run() {
        findMaxHourglassSum(fillHourGlassArray());
    }
}
