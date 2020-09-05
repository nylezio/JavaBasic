package com.codejerry.虾皮;

import java.util.Scanner;

/**
 * @author: codeJerry
 * @description:
 * -2 1 -3 4 -1 2 1 -5 4
 * @date: 2020/08/12 14:27
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int ans = getMax(nums);
        System.out.println(ans);
    }

    private static int getMax(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = dp[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
