package com.codejerry.背包;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * 01背包可取无限个
 * @date: 2020/08/01 14:49
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];


        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k * weight[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
            }
        }
        System.out.println(dp[m]);

    }

}