package com.codejerry.美团2;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:(91)
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int row = 1; row <= n; row++) {
            int[][] sub = new int[row][m];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < m; j++) {
                    sub[i][j] = matrix[i][j];
                }
            }

            int cur = row;
            boolean flag = true;
            while (cur < n) {
                if (!check(matrix, sub, cur - row)) {
                    flag = false;
                    break;
                }
                reverse(sub);
                cur += row;
            }
            if (flag) {
                for (int i = row - 1; i >= 0; i--) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(sub[i][j] + " ");
                    }
                    System.out.println();
                }
                return;
            }
        }
    }

    private static boolean check(int[][] matrix, int[][] sub, int start) {
        int m = matrix[0].length;
        for (int i = 0; i < sub.length; i++) {
            for (int j = 0; j < m; j++) {
                if (sub[i][j] != matrix[i + start][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void reverse(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return;
        }
        int max = n / 2;
        for (int i = 0; i < max; i++) {
            swap(matrix, i, n - 1 - i);
        }
    }

    private static void swap(int[][] matrix, int i, int j) {
        int m = matrix[0].length;
        for (int k = 0; k < m; k++) {
            int t = matrix[i][k];
            matrix[i][k] = matrix[j][k];
            matrix[j][k] = t;
        }
    }
}
