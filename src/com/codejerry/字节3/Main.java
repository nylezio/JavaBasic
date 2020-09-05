package com.codejerry.字节3;

import java.util.Arrays;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/08/09 18:52
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, -2, -3, -4, 5};
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(nums[i], dp[i - 1][1] + nums[i]);
            dp[i][1] = Math.max(-nums[i], dp[i - 1][0] - nums[i]);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Math.max(dp[n - 1][0] , dp[n - 1][1]));
    }
}
