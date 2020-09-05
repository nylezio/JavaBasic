package com.codejerry.拼多多;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 *N 5 M 1 T 9
5 1 9
9 1
4 9
3 1
2 3
6 5
9 8

输出4
 * @date: 2020/08/02 19:30
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        if (t == 0) {
            System.out.println(0);
        } else {
            int[][] x = new int[n][2];
            int[][] y = new int[m][2];

            int ans = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                x[i][0] = sc.nextInt();
                x[i][1] = sc.nextInt();
                if (x[i][1] >= t) {
                    ans = Math.min(ans, x[i][0]);
                }
            }
            for (int i = 0; i < m; i++) {
                y[i][0] = sc.nextInt();
                y[i][1] = sc.nextInt();
                if (y[i][1] >= t) {
                    ans = Math.min(ans, y[i][0]);
                }
            }
            Arrays.sort(x, (a, b) -> a[1] - b[1]);
            Arrays.sort(y, (a, b) -> a[1] - b[1]);

            for (int i = 0; i < n; i++) {
                if (x[i][1] >= t) {
                    break;
                }
                for (int j = 0; j < m; j++) {
                    if (y[j][1] >= t) {
                        break;
                    }
                    if (x[i][1] + y[j][1] >= t) {
                        ans = Math.min(ans, x[i][0] + y[j][0]);
                    }
                }
            }
            if (ans == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(ans);
            }
        }

    }
}
