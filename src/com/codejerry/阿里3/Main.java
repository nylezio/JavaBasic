package com.codejerry.阿里3;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/14 18:50
 */
public class Main {
    static long[][] mod;
    static long[][] div;
    static long max = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        long[][] matrix = new long[n][n];
        mod = new long[n][n];
        div = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
                mod[i][j] = matrix[i][j] % d;
                div[i][j] = matrix[i][j] / d;
                max = Math.max(max, div[i][j]);
            }
        }
        long ans = judge(matrix, d);
        System.out.println(ans);
    }

    private static long judge(long[][] matrix, int d) {
        long val = mod[0][0];
        int n = matrix.length;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mod[i][j] != val) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        if (!flag) {
            return -1;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += Math.abs(max - div[i][j]);
            }
        }

        return ans;
    }


}
