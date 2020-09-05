package com.codejerry.顺丰;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 6 3
 0 0 1 1 0 0
 * @date: 2020/08/29 15:30
 */
public class Main {
    static int n;
    static int k;
    static long[][] dp;
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        dp = new long[n][k + 1];

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print(count(nums, 0, k));
        System.out.print(" ");
        System.out.print(max);

    }


    private static long count(int[] nums, int index, int k) {
        if (index >= n || k <= 0) {
            return 0;
        }
        if (dp[index][k] > 0) {
            return dp[index][k];
        }
        long ans = 0;
        long cur = 0;
        for (int i = index; i <= n - k; i++) {
            cur += nums[i];
            long tmp = cur * cur + count(nums, i + 1, k - 1);
            if (tmp >= ans) {
                ans = tmp;
                max = Math.max(max, i - index + 1);
            }
            System.out.println(tmp);
        }

        dp[index][k] = ans;

        return ans;
    }
}
