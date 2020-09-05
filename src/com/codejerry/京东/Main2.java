package com.codejerry.京东;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/27 19:00
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        long[][] matrix = new long[2 * n - 1][2 * n - 1];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] s1 = s.trim().split(" ");
            for (int j = 0; j <= 2 * i; j++) {
                matrix[i][j] = Long.parseLong(s1[j]);
            }
        }

        System.out.println(dp(matrix, n));
    }

    private static long dp(long[][] matrix, int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return matrix[0][0];
        }

        long ans = matrix[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 2 * i; j++) {

                if (j == 0) {
                    matrix[i][j] += matrix[i - 1][j];
                } else if (j == 2 * i) {
                    matrix[i][j] += matrix[i - 1][j - 2];
                } else if (j == 1) {
                    if (i == 1) {
                        matrix[i][j] += matrix[0][0];
                    } else {
                        matrix[i][j] += Math.max(matrix[i - 1][0], matrix[i - 1][1]);
                    }
                } else if (j == 2 * i - 1) {
                    matrix[i][j] += Math.max(matrix[i - 1][2*(i-1)], matrix[i-1][2*(i -1)-1]);
                } else {
                    matrix[i][j] += Math.max(matrix[i - 1][j], Math.max(matrix[i - 1][j - 2],matrix[i - 1][j - 1]));
                }
                ans = Math.max(ans, matrix[i][j]);
            }
        }

        return ans;
    }
}
