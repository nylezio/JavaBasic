package com.codejerry.美团2;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:（27）
 * @date: 2020/09/13 10:40
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int d = sc.nextInt();
        int mod = 998244353;
        System.out.println(count(n, k, d, mod));

    }

    private static int count(int n, int k, int d, int mod) {
        long[][] dp = new long[n + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[1][0] = d > 1 ? 0 : 1;
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                dp[i][0] = (dp[i][0] + dp[i - j][j >= d ? 1 : 0]) % mod;
                dp[i][1] = (dp[i][1] + dp[i - j][1]) % mod;
            }
//            System.out.print(i);
//            System.out.print(" ");
//            System.out.print(dp[i][0]);
//            System.out.print(" ");
//            System.out.println(dp[i][1]);
        }
        return (int) (dp[n][0] % mod);
    }
}
