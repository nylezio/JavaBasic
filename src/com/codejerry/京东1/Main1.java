package com.codejerry.京东1;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/06 19:03
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] dp = new double[n + 1];

//        if (n == 1) {
//            System.out.printf("%.4f%n", f(1));
//        }
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + f(i);
        }
        System.out.println(String.format("%.4f", dp[n]));
    }

    private static double f(int i) {
        return 1.0 / (5.0 * (2.0 * i - 1)) - 1.0 / (5.0 * (2.0 * i));
    }

}
