package com.codejerry.百度;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/09/03 20:14
 */
public class Main3 {
    static int mod = (int) Math.pow(10, 9) + 7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(count(n, m));
    }

    private static int count(int n, int m) {
        if (n <= 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        return dp[n];
    }

}
