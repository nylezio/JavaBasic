package com.codejerry.京东1;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/06 19:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String a = sc.next();
        String b = sc.next();
        final double can = 0.5;
        double ans = check(a, b, len);
        if (ans <= can) {
            System.out.println(ans + " Yes");
        } else {
            System.out.println(ans + " No");
        }
    }

    private static double check(String a, String b, int len) {
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j]= Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return (double) dp[len][len] / (double) len;

    }


}
